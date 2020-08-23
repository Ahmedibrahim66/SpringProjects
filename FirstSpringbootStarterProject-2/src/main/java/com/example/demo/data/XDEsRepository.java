package com.example.demo.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Cli;
import com.example.demo.models.XDE;


@Repository
public interface XDEsRepository extends JpaRepository<XDE, Long> {
	
	@Query(nativeQuery = true, value = "SELECT * FROM xdes WHERE artifact_id = :artifactId AND group_id = :groupId")
	public List<XDE> getFeatureXDE(@Param("artifactId") String artifcatId ,@Param("groupId") String groupId);
	
	public XDE findById(long id);
	
//	cannot return CLI check for answer (dto)
//	@Query(nativeQuery = true, value = "SELECT * FROM xde_cli_list where xde_id = :id")
//	public List<Cli> getXDECli(long id);
	
	@Query(nativeQuery = true , value = "SELECT  mib FROM xde_snmp_list where xde_id = :id")
	public List<String> getXDEMib(long id);
	
	

}
