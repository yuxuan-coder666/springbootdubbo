package com.springbootdubbo.server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springbdubbo.commons.service.impl.BaseServiceImpl;
import com.springbootdubbo.api.req.demo.DemoReq;
import com.springbootdubbo.config.BusinessException;
import com.springbootdubbo.server.entity.Demo;
import com.springbootdubbo.server.mapper.DemoMapper;
import com.springbootdubbo.server.service.DemoService;

import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
public class DemoServiceImpl extends BaseServiceImpl<Demo> implements DemoService {

	@Autowired
    private DemoMapper demoMapper;

	@Override
	@Transactional
	public List<Demo> getDemoInfo(DemoReq obj) {
		save(new Demo());
		if("1".equals(obj.getType())) {
			throw new BusinessException("123","出现异常");
		}else if("2".equals(obj.getType())){
			throw new RuntimeException();
		}else if("3".equals(obj.getType())){
			int a = 1/0;
		}else if("4".equals(obj.getType())) {
			DemoReq a = null;
			log.info(a.getPhone());
		}
		List<Demo> list = demoMapper.queryDemoList();
		return list;
	}


}
