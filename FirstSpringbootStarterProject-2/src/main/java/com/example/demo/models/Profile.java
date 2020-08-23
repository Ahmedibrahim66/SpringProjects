package com.example.demo.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


@Data
@Entity
@Table(name = "Profiles")
public class Profile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Embedded
	private Dependency info;
	
	@Embedded
	@AttributeOverrides({
		  @AttributeOverride( name = "groupId", column = @Column(name = "parent_groupId")),
		  @AttributeOverride( name = "artifactId", column = @Column(name = "parent_artifactId")),
		  @AttributeOverride( name = "version", column = @Column(name = "parent_version")),
		  @AttributeOverride( name = "type", column = @Column(name = "parent_type"))

		})
	private Dependency parent;
	
	
	@ElementCollection
	@CollectionTable(name = "profile_featureList", joinColumns = @JoinColumn(name = "profile_id"))
	@JsonIgnore
	private List<Dependency> featureList;
	
	
	@ElementCollection
	@CollectionTable(name = "profile_exclusionList", joinColumns = @JoinColumn(name = "profile_id"))
	private List<Dependency> exclusionList;
	
	
	@ElementCollection
	@CollectionTable(name = "profile_overrideList", joinColumns = @JoinColumn(name = "profile_id"))
	private List<Dependency> overrideList;
	
	@ElementCollection
	@CollectionTable(name = "profile_configList", joinColumns = @JoinColumn(name = "profile_id"))
	private List<Config> configList;
	
	@ManyToMany()
	@JoinTable(name = "profiles_features", joinColumns=@JoinColumn(name="profile_id"),
	inverseJoinColumns=@JoinColumn(name="feature_id"))
	@JsonIgnore
	private List<Feature> featureRealtion = new ArrayList<Feature>();
	
	
	@ManyToOne()
	@JoinColumn(name="JobId")
	@JsonIgnore
	private Job job;
	
	
}
