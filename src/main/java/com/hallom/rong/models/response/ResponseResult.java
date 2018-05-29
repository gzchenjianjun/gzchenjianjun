package com.hallom.rong.models.response;

import com.hallom.rong.models.Result;
import com.hallom.rong.util.GsonUtil;

/**
 *  http 成功返回结果
 */
public class ResponseResult extends Result {

	public ResponseResult(Integer code, String msg) {
		super(code, msg);
		this.code = code;
		this.msg = msg;
	}

	@Override
	public String toString() {
		return GsonUtil.toJson(this, ResponseResult.class);
	}
}
