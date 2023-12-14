package com.prism.mr.repository;

import com.prism.mr.model.ClientSchedule;
import com.prism.mr.model.ClientScheduleProjection;
import com.prism.mr.model.QClientSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "schedules", collectionResourceRel = "schedules",excerptProjection= ClientScheduleProjection.class)
public interface ClientScheduleRepository extends JpaRepository<ClientSchedule,Long>, QuerydslPredicateExecutor<QClientSchedule>{

}
