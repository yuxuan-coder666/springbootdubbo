package com.springbootdubbo.server.service;

import java.util.List;

import com.springbdubbo.commons.service.BaseService;
import com.springbootdubbo.api.req.demo.DemoReq;
import com.springbootdubbo.server.entity.Demo;

public interface DemoService extends BaseService<Demo> {

	List<Demo> getDemoInfo(DemoReq obj);
	
}
