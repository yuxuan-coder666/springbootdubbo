package com.springbootdubbo.server.rpc;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.springbootdubbo.api.req.demo.DemoReq;
import com.springbootdubbo.api.resp.ApiResult;
import com.springbootdubbo.api.resp.demo.DemoResp;
import com.springbootdubbo.api.service.demo.DemoServiceRpcApi;
import com.springbootdubbo.config.ApiLog;
import com.springbootdubbo.server.entity.Demo;
import com.springbootdubbo.server.service.DemoService;

@Service(group="${dubbo.group}",version = "${dubbo.version}")
public class DemoRpc implements DemoServiceRpcApi{
	
	@Autowired
    private DemoService demoService;

	@Override
	@ApiLog(title = "查询demo信息")
	public ApiResult<DemoResp> getDemoInfo(DemoReq obj) {
		List<Demo> list = demoService.getDemoInfo(obj);
		DemoResp data = new DemoResp();
		data.setAge(list.get(0).getVersion());
		data.setName(obj.getPhone());
		data.setObj(obj.getType());
		data.setTime(new Date());
		ApiResult result = new ApiResult().OK(data);
		return result;
	}

}
