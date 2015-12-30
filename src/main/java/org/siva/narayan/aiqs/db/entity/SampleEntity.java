package org.siva.narayan.aiqs.db.entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * A Sample entity representing the SAMPLE table.
 * 
 * @author Siva Narayana Reddy M [siva.narayanareddy.maddula@gmail.com]
 *
 */
@Entity
@Table(name = "SAMPLE")
@Access(AccessType.FIELD)
public class SampleEntity {

	@Id
	@SequenceGenerator(sequenceName = "SAMPLE_SEQ", allocationSize = 1, initialValue = 1, name="SAMPLE_SEQ_GEN")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SAMPLE_SEQ_GEN")
	@Column(name = "ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
