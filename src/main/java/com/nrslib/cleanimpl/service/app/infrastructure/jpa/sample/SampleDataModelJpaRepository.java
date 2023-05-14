package com.nrslib.cleanimpl.service.app.infrastructure.jpa.sample;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SampleDataModelJpaRepository extends JpaRepository<SampleDataModel, UUID> {}
