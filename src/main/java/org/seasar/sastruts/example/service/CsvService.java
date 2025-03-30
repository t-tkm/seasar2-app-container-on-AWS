package org.seasar.sastruts.example.service;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMessage;
import org.seasar.s2csv.csv.S2CSVParseCtrl;
import org.seasar.s2csv.csv.exception.runtime.CSVValidationResultException;
import org.seasar.s2csv.csv.exception.runtime.CSVValidationResultRuntimeException;
import org.seasar.s2csv.csv.factory.S2CSVCtrlFactory;
import org.seasar.s2csv.csv.message.CSVMsg;
import org.seasar.s2csv.csv.validator.CSVValidateResult;
import org.seasar.sastruts.example.csv.DeptCsv;

/**
 * CSVをパースして{@link DeptCsv}のリストを返すサービスです。
 *
 * @author Naoki Takezoe
 */
public class CsvService {

	@Resource
	protected S2CSVCtrlFactory s2csvCtrlFactory;

	/**
	 * CSVを一括パースします。
	 *
	 * @param csvData CSVデータ
	 * @param errors エラーがあった場合、このActionErrorsオブジェクトにActionMessageが追加されます。
	 * @return CSVをパースして作成されたDeptCsvのリスト
	 */
	public List<DeptCsv> parseAll(String csvData, ActionErrors errors){
		try {
			S2CSVParseCtrl<DeptCsv> controller = s2csvCtrlFactory.getParseController(
					DeptCsv.class, new StringReader(csvData));

			return controller.parseAll();

		} catch(CSVValidationResultException ex){
			List<CSVValidateResult> resultList = ex.getValidateResultList();
			for(CSVValidateResult result: resultList){
				for(CSVMsg msg: result.getMsgs()){
					errors.add("csvData", new ActionMessage(
							result.getLineNo() + "行目：" + msg.toString(), false));
				}
			}

			// パースに成功したデータを返す
			return ex.getDataList();
		}
	}

	/**
	 * CSVを1件ずつパースします。
	 *
	 * @param csvData CSVデータ
	 * @param errors エラーがあった場合、このActionErrorsオブジェクトにActionMessageが追加されます。
	 * @return CSVをパースして作成されたDeptCsvのリスト
	 */
	public List<DeptCsv> parse(String csvData, ActionErrors errors){
		List<DeptCsv> deptList = new ArrayList<DeptCsv>();

		S2CSVParseCtrl<DeptCsv> controller = s2csvCtrlFactory.getParseController(
				DeptCsv.class, new StringReader(csvData));

		while(controller.readNext()){
			try {
				DeptCsv dept = controller.parse();
				deptList.add(dept);

			} catch(CSVValidationResultRuntimeException ex){
				CSVValidateResult result = ex.getValidateResult();
				for(CSVMsg msg: result.getMsgs()){
					errors.add("csvData", new ActionMessage(
							result.getLineNo() + "行目：" + msg.toString(), false));
				}
			}
		}

		return deptList;
	}
}
