package com.blablacar.palii.controller.response;

import com.blablacar.palii.entity.TaskStatus;

public interface TaskWithDepartmentAndUser extends IdView {

	public String getTopic();

	public String getDescription();

	public UserView getAuthor();

	public UserView getExecutor();

	public TaskStatus getTaskStatus();

}
