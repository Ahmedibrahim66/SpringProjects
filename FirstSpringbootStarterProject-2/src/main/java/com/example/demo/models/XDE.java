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
import javax.persistence.Table;
import lombok.Data;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;


@Data
@Entity
@Table(name = "XDEs")
public class XDE {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Embedded
	private Dependency info;

	@ElementCollection
	@CollectionTable(name = "xde_cliList", joinColumns = @JoinColumn(name = "xde_id"))
//	@AttributeOverrides({ @AttributeOverride(name = "location", column = @Column(name = "cli_location")),
//			@AttributeOverride(name = "mib", column = @Column(name = "cli_mib")) })
	private List<Cli> cliList;

	
	@ElementCollection
	@CollectionTable(name = "xde_snmpList", joinColumns = @JoinColumn(name = "xde_id"))
//	@AttributeOverrides({ @AttributeOverride(name = "location", column = @Column(name = "snmp_location")),
//			@AttributeOverride(name = "commad", column = @Column(name = "snmp_command")) })
	private List<Snmp> snmpList;
	
	
	@ManyToMany(mappedBy = "xdesRealtion", fetch = FetchType.LAZY)
	private List<Feature> featureList = new ArrayList<Feature>();
	
	
	@ManyToOne()
	@JoinColumn(name="JobId")
	private Job job;
	
	
	

}
