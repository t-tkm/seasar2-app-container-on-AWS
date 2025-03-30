package org.seasar.sastruts.example.action;

import javax.annotation.Resource;

import org.seasar.sastruts.example.annotation.Auth;
import org.seasar.sastruts.example.dto.UserDto;
import org.seasar.sastruts.example.form.LoginForm;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;
import org.seasar.struts.exception.ActionMessagesException;

/**
 * 認証処理のサンプルです。
 *
 * @author Naoki Takezoe
 */
public class LoginAction {

	@Resource
	@ActionForm
	protected LoginForm loginForm;

	@Resource
	public UserDto userDto;

	@Execute(validator=false)
	public String index(){
		return "loginForm.jsp";
	}

	@Execute(validator=false)
	public String logout(){
		userDto.userName = null;
		return "loginForm.jsp";
	}

	@Execute(validator=true, input="loginForm.jsp")
	public String login(){
		if(loginForm.userName.equals("admin") && loginForm.userName.equals("admin")){
			// ログイン成功
			userDto.userName = loginForm.userName;

			return "/login/?redirect=true";

		} else {
			// ログイン失敗
			throw new ActionMessagesException("ユーザ名かパスワードのどちらかが違います。", false);
		}
	}

	@Auth
	@Execute(validator=false)
	public String auth(){
		return "auth.jsp";
	}

}
