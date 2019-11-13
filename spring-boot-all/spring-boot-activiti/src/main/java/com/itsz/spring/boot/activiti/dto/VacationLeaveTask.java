package com.itsz.spring.boot.activiti.dto;

import com.itsz.spring.boot.activiti.domain.VacationLeave;
import lombok.Data;

@Data
public class VacationLeaveTask {

    private String taskId;

    private VacationLeave vacationLeave;

    private long days;
}
