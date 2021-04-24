package com.blablacar.palii.controller.response;

import org.springframework.beans.factory.annotation.Value;

public interface UserView extends IdView {

	public String getName();

	public String getSurname();

	@Value("#{@userRateService.getUserRate(target.getId())}")
	public int getRate();

	public DepartmentView getDepartment();
}
