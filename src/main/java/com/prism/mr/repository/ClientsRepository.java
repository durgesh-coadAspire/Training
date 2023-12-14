package com.prism.mr.repository;

import com.prism.mr.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(path = "clients",collectionResourceRel= "clients",excerptProjection= ClientsProjection.class)
public interface ClientsRepository extends JpaRepository<Clients,Long>, QuerydslPredicateExecutor<QClients> {

    Optional<Clients> findByClientCode(String clientCode);
    Optional<Clients> findByClientCodeAndIdNotIn(String clientCode, List<Long> Id);
    Optional<Clients> findByClientCodeAndIdIn(String clientCode, List<Long> Id);
}
