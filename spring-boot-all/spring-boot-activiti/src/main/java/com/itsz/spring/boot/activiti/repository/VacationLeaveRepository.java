package com.itsz.spring.boot.activiti.repository;

import com.itsz.spring.boot.activiti.domain.VacationLeave;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacationLeaveRepository extends CrudRepository<VacationLeave, Long> {

    List<VacationLeave> queryByApplicant(String username);

    VacationLeave findByInstanceId(String InstanceId);
}
