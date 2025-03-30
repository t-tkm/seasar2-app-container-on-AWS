package org.seasar.sastruts.example.action;

import javax.annotation.Resource;

import org.seasar.config.core.container.ConfigContainer;
import org.seasar.sastruts.example.config.JdbcConfig;
import org.seasar.struts.annotation.Execute;

/**
 * S2Configのサンプルです。
 *
 * @author Naoki Takezoe
 */
public class ConfigAction {

	@Resource
	public JdbcConfig jdbcConfig;

	@Resource
	protected ConfigContainer configContainer;

	public String jdbcDriver;
	public String jdbcUrl;
	public String jdbcUser;
	public String jdbcPassword;

	@Execute(validator=false)
	public String index(){
		this.jdbcDriver = configContainer.findAllConfigValue(String.class, "jdbc.driver");
		this.jdbcUrl = configContainer.findAllConfigValue(String.class, "jdbc.url");
		this.jdbcUser = configContainer.findAllConfigValue(String.class, "jdbc.user");
		this.jdbcPassword = configContainer.findAllConfigValue(String.class, "jdbc.password");

		return "index.jsp";
	}

}
