package com.itsz.spring.boot.activiti.service.impl;

import com.google.common.collect.Lists;
import com.itsz.spring.boot.activiti.domain.VacationLeave;
import com.itsz.spring.boot.activiti.dto.ApplyVacationLeaveReqDto;
import com.itsz.spring.boot.activiti.dto.HandleTaskReqDto;
import com.itsz.spring.boot.activiti.dto.LeaveVacationStatus;
import com.itsz.spring.boot.activiti.dto.VacationLeaveTask;
import com.itsz.spring.boot.activiti.repository.VacationLeaveRepository;
import com.itsz.spring.boot.activiti.service.VacationLeaveService;
import com.itsz.spring.boot.activiti.util.Constants;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.task.TaskQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VacationLeaveServiceImpl implements VacationLeaveService {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private VacationLeaveRepository vacationLeaveRepository;

    @Override
    public void applyVacationLeave(ApplyVacationLeaveReqDto request) {

        //get duration days
        LocalDateTime startTime = request.getStartTime();
        LocalDateTime endTime = request.getEndTime();
        Duration duration = Duration.between(startTime, endTime);

        //start process
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(Constants.VACACTION_LEAVE_DEFINE_KEY);

        VacationLeave vacationLeave = new VacationLeave();
        vacationLeave.setApplicant(Constants.DEFAULT_USER_NAME);
        vacationLeave.setApplyType(request.getApplyType());
        vacationLeave.setApplyTime(LocalDateTime.now());
        vacationLeave.setStartTime(startTime);
        vacationLeave.setEndTime(endTime);
        vacationLeave.setReason(request.getReason());
        vacationLeave.setInstanceId(processInstance.getId());
        vacationLeave.setStatus(LeaveVacationStatus.IN_PROGRESS);

        // start user task
        Task task = taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
        String taskId = task.getId();
        taskService.claim(taskId, Constants.DEFAULT_USER_NAME);
        taskService.setVariable(taskId, "days", duration.toDays());
        taskService.complete(task.getId());

        vacationLeaveRepository.save(vacationLeave);
    }

    @Override
    public List<VacationLeave> queryByUserName(String username) {
        return vacationLeaveRepository.queryByApplicant(username);
    }

    /**
     * TODO should get roles by username then query task by roles
     */
    @Override
    public List<VacationLeaveTask> queryTasksByUserName(String username) {
        List<VacationLeaveTask> vacationLeaveTasks = getVacationLeaveTasksByGroupName(Constants.BOSS_GROUP_NAME);
        List<VacationLeaveTask> managerVacationLeaveTasks = getVacationLeaveTasksByGroupName(Constants.MANAGER_GROUP_NAME);
        //merge lists
        vacationLeaveTasks.addAll(managerVacationLeaveTasks);
        return vacationLeaveTasks;
    }

    @Override
    public void handleTaskById(String taskId, HandleTaskReqDto request) {
        Map<String, Object> variableMap = new HashMap<>();
        variableMap.put(taskId, request);
        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        VacationLeave  vacationLeave = vacationLeaveRepository.findByInstanceId(task.getProcessInstanceId());
        vacationLeave.setStatus(LeaveVacationStatus.FINISHED);
        taskService.claim(taskId, Constants.DEFAULT_USER_NAME);
        taskService.complete(taskId);

    }

    private List<VacationLeaveTask> getVacationLeaveTasksByGroupName(String groupName) {
        List<VacationLeaveTask> vacationLeaveTasks = Lists.newArrayList();
        List<Task> manageGroupTasks = taskService.createTaskQuery().taskCandidateGroup(groupName).list();
        for (Task task : manageGroupTasks) {
            VacationLeaveTask vacationLeaveTask = new VacationLeaveTask();
            vacationLeaveTask.setTaskId(task.getId());
            vacationLeaveTask.setDays(((Long) taskService.getVariable(task.getId(),"days")));
            vacationLeaveTask.setVacationLeave( vacationLeaveRepository.findByInstanceId(task.getProcessInstanceId()));
            vacationLeaveTasks.add(vacationLeaveTask);
        }
        return vacationLeaveTasks;
    }
}
