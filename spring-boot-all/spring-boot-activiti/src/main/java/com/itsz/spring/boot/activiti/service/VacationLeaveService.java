package com.itsz.spring.boot.activiti.service;

import com.itsz.spring.boot.activiti.domain.VacationLeave;
import com.itsz.spring.boot.activiti.dto.ApplyVacationLeaveReqDto;
import com.itsz.spring.boot.activiti.dto.HandleTaskReqDto;
import com.itsz.spring.boot.activiti.dto.VacationLeaveTask;

import java.util.List;

public interface VacationLeaveService {


    void applyVacationLeave(ApplyVacationLeaveReqDto request);

    List<VacationLeave> queryByUserName(String username);

    List<VacationLeaveTask> queryTasksByUserName(String username);

    void handleTaskById(String taskId, HandleTaskReqDto request);

}
