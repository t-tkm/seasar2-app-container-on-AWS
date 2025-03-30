package org.seasar.sastruts.example.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.seasar.struts.annotation.Execute;

/**
 * ロール認証のサンプルです。
 *
 * @author Naoki Takezoe
 */
public class RoleAction {

	public String userRole;
	public String userName;

	@Resource
	protected HttpServletRequest request;

	/**
	 * adminロールが必要な実行メソッドです。
	 */
	@Execute(validator=false, roles="admin")
	public String admin(){
		setUserInfo();
		return "index.jsp";
	}

	/**
	 * admin、guestのいずれかのロールが必要な実行メソッドです。
	 */
	@Execute(validator=false, roles="admin,guest")
	public String guest(){
		setUserInfo();
		return "index.jsp";
	}

	private void setUserInfo(){
		this.userName = request.getUserPrincipal().getName();

		if(request.isUserInRole("admin")){
			this.userRole = "admin";
		} else if(request.isUserInRole("guest")){
			this.userRole = "guest";
		}
	}
}
