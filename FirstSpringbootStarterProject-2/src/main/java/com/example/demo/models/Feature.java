package com.example.demo.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Entity
@Table(name = "Features")
@Data
public class Feature {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	
	@Embedded
	Dependency info;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "xdes_features", joinColumns=@JoinColumn(name="feature_id"),
	inverseJoinColumns=@JoinColumn(name="xde_id"))
	@JsonIgnore
	private List<XDE> xdesRealtion = new ArrayList<XDE>();
	
	
	@ElementCollection( fetch = FetchType.LAZY)
	@CollectionTable(name = "feature_xdes_dependency", joinColumns = @JoinColumn(name = "feature_id"))
//	@AttributeOverrides({ @AttributeOverride(name = "location", column = @Column(name = "snmp_location")),
//			@AttributeOverride(name = "commad", column = @Column(name = "snmp_command")) })
	private List<Dependency> xdeList;
	
	
	@ManyToOne()
	@JoinColumn(name="JobId")
	@JsonIgnoreProperties({"xdeList" , "featuresList", "profileList"})
	private Job job;
	
	
	
	@ManyToMany(mappedBy = "featureRealtion", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Profile> profileList = new ArrayList<Profile>();
	
	
	

}
