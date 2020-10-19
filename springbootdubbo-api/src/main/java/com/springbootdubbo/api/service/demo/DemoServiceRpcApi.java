package com.springbootdubbo.api.service.demo;

import com.springbootdubbo.api.req.demo.DemoReq;
import com.springbootdubbo.api.resp.ApiResult;
import com.springbootdubbo.api.resp.demo.DemoResp;

public interface DemoServiceRpcApi {

	
	ApiResult<DemoResp> getDemoInfo(DemoReq obj);
}
