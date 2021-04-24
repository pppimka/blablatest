package com.blablacar.palii.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum TaskStatus {

	NEW("New"),
	ASSIGNED("Assigned"),
	IN_PROGRESS("In progress"),
	ON_REVIEW("On review"),
	COMPLETED("Completed"),
	REJECTED("Rejected");

	@Getter
	private String name;

}
