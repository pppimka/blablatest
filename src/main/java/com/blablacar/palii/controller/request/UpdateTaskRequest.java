package com.blablacar.palii.controller.request;

import com.blablacar.palii.entity.TaskStatus;
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
public class UpdateTaskRequest {

	private TaskStatus taskStatus;

	private String executorId;
}
