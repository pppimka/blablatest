package com.blablacar.palii.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Department extends BaseEntity {

	@Column(name = "department_name")
	private String name;
}
