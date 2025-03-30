package org.seasar.sastruts.example.util;

import javax.annotation.Resource;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.seasar.extension.datasource.DataSourceFactory;

/**
 * データソース切り替え用インターセプターのサンプルです。
 *
 * @author Naoki Takezoe
 */
public class SwitchDataSourceInterceptor implements MethodInterceptor {

	  @Resource
	  protected DataSourceFactory dataSourceFactory;

	  public Object invoke(MethodInvocation invocation) throws Throwable {
	    // 使用するデータソース名を決定
	    String dataSourceName = "h2";

	    dataSourceFactory.setSelectableDataSourceName(dataSourceName);

	    System.out.println("データソース名にh2を設定しました。");

	    return invocation.proceed();
	  }

}
