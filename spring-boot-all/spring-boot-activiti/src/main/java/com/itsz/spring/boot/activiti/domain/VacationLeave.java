package com.itsz.spring.boot.activiti.domain;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Table(name = "tb_vacation_leave")
@Data
@Entity
public class VacationLeave implements Serializable {



    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name = "INSTANCE_ID")
    private String instanceId;

    @Column(name = "APPLICANT")
    private String applicant;

    @Column(name = "START_TIME")
    private LocalDateTime startTime;

    @Column(name = "END_TIME")
    private LocalDateTime endTime;

    @Column(name = "APPLY_TYPE")
    private String applyType;

    @Column(name = "REASON")
    private String reason;

    @Column(name = "APPLY_TIME")
    private LocalDateTime applyTime;

    @Column (name = "STATUS")
    private String status;


}
