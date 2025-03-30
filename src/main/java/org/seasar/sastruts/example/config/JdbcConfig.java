package org.seasar.sastruts.example.config;

import org.seasar.config.core.config.annotation.Config;
import org.seasar.config.core.config.annotation.ConfigKey;

@Config(name="jdbc")
public class JdbcConfig {

	@ConfigKey(name="jdbc.driver", readOnly=true)
	public String driver;

	@ConfigKey(name="jdbc.url", readOnly=true)
	public String url;

	@ConfigKey(name="jdbc.user", readOnly=true)
	public String user;

	@ConfigKey(name="jdbc.password", readOnly=true)
	public String password;

}
