package com.springbootdubbo.server.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.springbdubbo.commons.mapper.BaseMapper;
import com.springbootdubbo.server.entity.Demo;

@Mapper
public interface DemoMapper extends BaseMapper<Demo> {

	List<Demo> queryDemoList();

}
