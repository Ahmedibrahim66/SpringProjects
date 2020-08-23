package com.example.demo.data;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.models.Job;

public interface JobsRepository extends JpaRepository<Job, UUID> {

	@Query(nativeQuery = true, value = "SELECT * FROM jobs WHERE id = :id" )
	Job getFromId(@Param("id") UUID id);

}
