package com.easyenglish.exception;

import java.io.Serializable;

/**
 * 
* @author Way Liang 
* @Description: TODO(系统异常)   
* @date 2018年2月11日
 */

public enum ErrorCodeConstant implements Serializable {
	//common error
	E00000("E00000","操作失败"),
	E00001("E00001","操作成功"),
	E00002("E00002","请输入主键"),
	E00003("E00003","系统内部错误"),
	E00004("E00004","没有数据"),
	E00005("E00005","用户名不存在或密码错误"),
	E00006("E00006","验证码不能为空"),
	E00007("E00007","验证码错误"),
	E00008("E00008","文件太大,超过10M"),
	E00009("E00009","账号不能为空"),
	E00010("E00010","密码不能为空"),
	E00011("E00011","当前用户已经登录,请先登出"),
	E00012("E00012","当前用户已经成功登出"),
	E00013("E00013","账号名格式出错,账户名格式为6-20位字母数字组合"),
	E00014("E00014","邮箱格式出错"),
	E00015("E00015","密码格式出错,密码格式为6-20位字母数字组合"),
	E00016("E00016","两次密码不一致"),
	E00017("E00017","用户名已经存在 不能注册"),

	;
	
	

	private final String code;

	private final String message;

	private ErrorCodeConstant(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return this.code;
	}

	public String getMessage() {
		return this.message;
	}

}