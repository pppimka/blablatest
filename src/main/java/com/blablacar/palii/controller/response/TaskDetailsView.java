package com.blablacar.palii.controller.response;

import com.blablacar.palii.entity.TaskStatus;

import java.util.List;

public interface TaskDetailsView {

	public String getTopic();

	public String getDescription();

	public TaskStatus getTaskStatus();

	public List<CommentView> getComments();

	public List<AttachmentView> getAttachments();

}
