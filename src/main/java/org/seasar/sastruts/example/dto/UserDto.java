package org.seasar.sastruts.example.dto;

import java.io.Serializable;

import org.seasar.framework.container.annotation.tiger.Component;
import org.seasar.framework.container.annotation.tiger.InstanceType;

/**
 * 認証情報を格納するセッションスコープのDTOです。
 *
 * @author Naoki Takezoe
 */
@Component(instance=InstanceType.SESSION, name="userDto")
public class UserDto implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ログインしているかどうかを返します。
	 */
	public boolean isLogin(){
		return userName != null;
	}

	/**
	 * ログインしている場合はログイン中のユーザ名、
	 * ログインしていない場合はnullを設定します。
	 */
	public String userName = null;

}
