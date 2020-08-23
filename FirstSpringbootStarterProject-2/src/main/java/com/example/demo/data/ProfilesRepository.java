package com.example.demo.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Feature;
import com.example.demo.models.Profile;

@Repository
public interface ProfilesRepository extends JpaRepository<Profile, Long>{
	

	@Query(nativeQuery = true, value = "select * from profiles where id in (select profile_id from profiles_features where feature_id in (select id from features where id in (select feature_id from xdes_features where xde_id = :id)))")
	public List<Profile> getProfileFromXDE(@Param("id") long id);
	
	@Query(nativeQuery = true , value =  "select * from profiles where id in ( select profile_id from profiles_features where feature_id in  (select feature_id from xdes_features where xde_id in  (select id from xdes where id in (select xde_id from xde_cli_list where command like %:command%))))")
	public List<Profile> getProfileFromCliCommandLike(@Param("command") String command);
	
	
}
