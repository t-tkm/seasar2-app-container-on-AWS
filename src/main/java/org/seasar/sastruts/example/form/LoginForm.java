package org.seasar.sastruts.example.form;

import org.seasar.struts.annotation.Required;

public class LoginForm {

	@Required
	public String userName;

	@Required
	public String password;

}
