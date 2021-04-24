package com.blablacar.palii.service;

import org.springframework.stereotype.Component;

@Component
public class UserRateService {

	public int getUserRate(String userId) {
		try {
			//some remote call
			return 2;
		} catch (Exception e) {
			//failed to call, return default
			return 1;
		}
	}
}
