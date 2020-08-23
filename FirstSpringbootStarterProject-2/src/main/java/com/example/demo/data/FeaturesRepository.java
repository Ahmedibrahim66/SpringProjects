package com.example.demo.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.demo.models.Feature;

@Repository
public interface FeaturesRepository extends JpaRepository<Feature, Long>  {
	
	@Query(nativeQuery = true, value = "SELECT * FROM features WHERE artifact_id = :artifactId AND group_id = :groupId")
	public List<Feature> getProfileFeature(@Param("artifactId") String artifcatId ,@Param("groupId") String groupId);
	
	
	@Query(nativeQuery = true, value = "SELECT * FROM features WHERE id IN (SELECT feature_id FROM xdes_features WHERE xde_id = :id)")
	public List<Feature> getFeatureFromXDE(@Param("id") long id);
	
	
	@Query(nativeQuery = true, value = "SELECT * FROM features WHERE id IN (SELECT feature_id FROM xdes_features WHERE xde_id IN (SELECT id FROM xdes WHERE artifact_id = :artifactId))")
	public List<Feature> getFeaturesFromXdeArtifactId(@Param("artifactId") String artifactId);
	
	
	@Query(nativeQuery = true , value =  "select * from features where id in (select feature_id from xdes_features where xde_id In (select xde_id from xde_cli_list where command like %:command%))")
	public List<Feature> getFeaturesFromCliCommnadLike(@Param("command") String command);
	
	@Query(nativeQuery = true , value =  "SELECT * FROM features WHERE id IN (SELECT feature_id FROM xdes_features WHERE xde_id IN (SELECT xde_id FROM xde_snmp_list WHERE mib LIKE %:mib%))")
	public List<Feature> getFeaturesFromSnmpMibLike(@Param("mib") String mib);

}
