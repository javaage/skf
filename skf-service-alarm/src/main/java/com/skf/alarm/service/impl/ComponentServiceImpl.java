package com.skf.alarm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skf.alarm.mapper.ComponentMapper;
import com.skf.alarm.service.ComponentService;

/**
 * @author P0088589
 *
 */
@Service
public class ComponentServiceImpl implements ComponentService {

	@Autowired
	private ComponentMapper mapper;

	@Override
	public void updateDangerLevel(String componentCode, float dangerLevel, float totalValue) {
		mapper.updateDangerLevel(componentCode, dangerLevel, totalValue);
	}

}
