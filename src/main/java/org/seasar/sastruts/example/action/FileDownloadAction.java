package org.seasar.sastruts.example.action;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.seasar.struts.annotation.Execute;
import org.seasar.struts.util.ResponseUtil;

/**
 * ファイルダウンロードのサンプルです。
 *
 * @author Naoki Takezoe
 */
public class FileDownloadAction {

	@Resource
	protected HttpServletRequest request;

	@Execute(validator=false)
	public String index() throws UnsupportedEncodingException {
		String filename = "サンプル.txt";
		String content = "ファイルダウンロードのサンプルです。";

		String userAgent = request.getHeader("USER-AGENT");

		// 日本語ファイル名の文字化け対応
		if(userAgent.indexOf("MSIE") >= 0 && userAgent.indexOf("Opera") < 0){
			filename = new String(filename.getBytes("Windows-31J"), "ISO8859_1");
		} else {
			filename = new String(filename.getBytes("UTF-8"), "ISO8859_1");
		}

		ResponseUtil.download(filename, content.getBytes("UTF-8"));

		return null;

	}

}
