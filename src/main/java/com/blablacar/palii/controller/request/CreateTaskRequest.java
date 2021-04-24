package com.blablacar.palii.controller.request;

import com.blablacar.palii.entity.TaskStatus;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateTaskRequest {

	@NotNull
	private String topic;

	private String description;

	@NotNull
	private String authorId;

	private String executorId;

	private TaskStatus taskStatus;

}
