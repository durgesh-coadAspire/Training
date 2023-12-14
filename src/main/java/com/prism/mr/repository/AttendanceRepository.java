package com.prism.mr.repository;

import com.prism.mr.model.Attendance;
import com.prism.mr.model.AttendanceProjection;
import com.prism.mr.model.QAttendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "attendance" ,collectionResourceRel = "attendance",excerptProjection= AttendanceProjection.class)
public interface AttendanceRepository extends JpaRepository<Attendance,Long>, QuerydslPredicateExecutor<QAttendance> {
}
