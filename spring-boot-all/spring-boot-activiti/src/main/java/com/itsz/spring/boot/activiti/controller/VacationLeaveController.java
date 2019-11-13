package com.itsz.spring.boot.activiti.controller;


import com.itsz.spring.boot.activiti.domain.VacationLeave;
import com.itsz.spring.boot.activiti.dto.ApplyVacationLeaveReqDto;
import com.itsz.spring.boot.activiti.dto.HandleTaskReqDto;
import com.itsz.spring.boot.activiti.dto.VacationLeaveTask;
import com.itsz.spring.boot.activiti.service.VacationLeaveService;
import com.itsz.spring.boot.activiti.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vacation-leave")
public class VacationLeaveController {

    @Autowired
    private VacationLeaveService vacationLeaveService;


    @PostMapping("/")
    public void applyVacationLeave (@RequestBody ApplyVacationLeaveReqDto request){
        vacationLeaveService.applyVacationLeave(request);
    }

    @GetMapping("/")
    public List<VacationLeave> queryVacationLeaveByUserName(){
           return vacationLeaveService.queryByUserName(Constants.DEFAULT_USER_NAME);
    }

    @GetMapping("/tasks")
    public List<VacationLeaveTask> queryVacationLeaveTasks(){
        return vacationLeaveService.queryTasksByUserName(Constants.DEFAULT_USER_NAME);
    }

    @PutMapping("/handleTask/{taskId}")
    public void handleTaskById(@PathVariable(name = "taskId") String taskId, @RequestBody HandleTaskReqDto request){
        vacationLeaveService.handleTaskById(taskId, request);
    }

}
