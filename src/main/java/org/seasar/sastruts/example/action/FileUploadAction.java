package org.seasar.sastruts.example.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.seasar.sastruts.example.form.FileUploadForm;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;
import org.seasar.struts.upload.S2MultipartRequestHandler;
import org.seasar.struts.util.ActionMessagesUtil;

/**
 * ファイルアップロードのサンプルです。
 *
 * @author Naoki Takezoe
 */
public class FileUploadAction {

	@ActionForm
	@Resource
	protected FileUploadForm fileUploadForm;

	@Resource
	protected HttpServletRequest request;

	public String filename;

	public String content;

	public Integer size;

	public String comment;

	@Execute(validator=false)
	public String index(){
		SizeLimitExceededException ex = (SizeLimitExceededException)
			request.getAttribute(S2MultipartRequestHandler.SIZE_EXCEPTION_KEY);
		if(ex != null){
			// ファイルサイズの上限を超えた場合のエラーメッセージをセット
			ActionMessages errors = new ActionMessages();
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
				"errors.upload.size",
			 	new Object[] { ex.getActualSize(), ex.getPermittedSize() }));
			ActionMessagesUtil.addErrors(request, errors);
		}

		return "index.jsp";
	}

	@Execute(validator=true, input="index.jsp")
	public String upload() {
		this.filename = this.fileUploadForm.file.getFileName();
		this.size = this.fileUploadForm.file.getFileSize();

		// ファイルの内容を取得
		//byte[] fileData = this.fileUploadForm.file.getFileData();

		this.comment = this.fileUploadForm.comment;

		return "result.jsp";
	}

}
