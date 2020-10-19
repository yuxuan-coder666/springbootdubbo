package com.springbdubbo.commons.mapper;

import tk.mybatis.mapper.common.Mapper;

/**
 * 平台通用Mapper
 * 
 * @author liuyuxuan
 *
 * @param <T>
 */
public interface BaseMapper<T> extends Mapper<T>, InsertMapper<T> {
	
 	 
}
