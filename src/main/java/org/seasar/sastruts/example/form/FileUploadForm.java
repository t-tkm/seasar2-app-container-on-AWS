package org.seasar.sastruts.example.form;

import org.apache.struts.upload.FormFile;
import org.seasar.struts.annotation.Required;

public class FileUploadForm {

	@Required
	public FormFile file;

	@Required
	public String comment;

}
