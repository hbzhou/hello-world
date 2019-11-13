package com.itsz.spring.boot.activiti.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApplyVacationLeaveReqDto {

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private String applyType;

    private String reason;




}
