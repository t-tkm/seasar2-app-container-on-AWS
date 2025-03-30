package org.seasar.sastruts.example.action;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.apache.struts.action.ActionErrors;
import org.seasar.framework.util.StringUtil;
import org.seasar.s2csv.csv.S2CSVWriteCtrl;
import org.seasar.s2csv.csv.factory.S2CSVCtrlFactory;
import org.seasar.sastruts.example.csv.DeptCsv;
import org.seasar.sastruts.example.form.CsvForm;
import org.seasar.sastruts.example.service.CsvService;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;
import org.seasar.struts.util.ActionMessagesUtil;

/**
 * S2CSVのサンプルです。
 *
 * @author Naoki Takezoe
 */
public class CsvAction {

	@Resource
	@ActionForm
	protected CsvForm csvForm;

	@Resource
	protected CsvService csvService;

	@Resource
	protected S2CSVCtrlFactory s2csvCtrlFactory;

	@Resource
	protected HttpServletRequest request;

	public List<DeptCsv> deptList;

	public String csv;

	@Execute(validator=false)
	public String index() throws IOException {

		InputStream in = Thread.currentThread()
			.getContextClassLoader()
			.getResourceAsStream("/data/dept.csv");

		try {
			this.csvForm.csvData = IOUtils.toString(in, "UTF-8");

		} finally {
			IOUtils.closeQuietly(in);
		}

		return "index.jsp";
	}

	@Execute(validator=true, input="index.jsp")
	public String read() throws Exception {
		ActionErrors errors = new ActionErrors();

		if(StringUtil.isNotEmpty(this.csvForm.processAll)){
			// 一括で処理
			this.deptList = csvService.parseAll(this.csvForm.csvData, errors);
		} else {
			// 1件ずつ処理
			this.deptList = csvService.parse(this.csvForm.csvData, errors);
		}

		if(!errors.isEmpty()){
			ActionMessagesUtil.addErrors(request, errors);
			return "index.jsp";
		}

		StringWriter writer = new StringWriter();

		S2CSVWriteCtrl<DeptCsv> controller
			= s2csvCtrlFactory.getWriteController(DeptCsv.class, writer);

		controller.writeAll(this.deptList);
		this.csv = writer.toString();

		return "read.jsp";
	}

}
