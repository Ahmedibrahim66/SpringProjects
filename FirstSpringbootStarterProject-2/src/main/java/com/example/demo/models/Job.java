package com.example.demo.models;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import lombok.Data;


@Data
@Entity
@Table(name = "Jobs")
public class Job {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator", parameters = {
			@Parameter(name = "uuid_gen_strategy_class", value = "org.hibernate.id.uuid.CustomVersionOneStrategy") })
	private UUID id;

	private String branch;

	private String owner;

	private Timestamp time ;
	

	
	@OneToMany(orphanRemoval=true , mappedBy = "job", fetch = FetchType.LAZY)
	private List<XDE> xdeList = new ArrayList<XDE>();
	
	@OneToMany(orphanRemoval=true , mappedBy = "job", fetch = FetchType.LAZY)
	private List<Feature> featuresList = new ArrayList<Feature>();
	
	@OneToMany(orphanRemoval=true , mappedBy = "job", fetch = FetchType.LAZY)
	private List<Profile> profileList = new ArrayList<Profile>();

}
