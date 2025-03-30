package org.seasar.sastruts.example.csv;

import org.seasar.s2csv.csv.annotation.CSVValidator;
import org.seasar.s2csv.csv.annotation.column.CSVColumn;
import org.seasar.s2csv.csv.annotation.column.CSVMaxLength;
import org.seasar.s2csv.csv.annotation.column.CSVRequired;
import org.seasar.s2csv.csv.annotation.entity.CSVEntity;
import org.seasar.s2csv.csv.annotation.entity.CSVRecordValidator;

/**
 * dept.csvにマッピングするCSVエンティティクラスです。
 *
 * @author Naoki Takezoe
 */
@CSVEntity(header=true)
@CSVRecordValidator(msgKey="errors.deptRecordCheck", method="validateRecord")
public class DeptCsv {

	  @CSVRequired
	  @CSVColumn(columnIndex=0)
	  public Long id;

	  @CSVRequired
	  @CSVColumn(columnIndex=1)
	  public Integer deptNo;

	  @CSVRequired
	  @CSVMaxLength(maxlength=10)
	  @CSVColumn(columnIndex=2)
	  public String deptName;

	  @CSVRequired
	  @CSVMaxLength(maxlength=10)
	  @CSVColumn(columnIndex=3)
	  public String loc;

	  @CSVRequired
	  @CSVValidator(msgKey="errors.versionNo", args={CSVColumn.REPLACE_NAME}, method="validateVersionNo")
	  @CSVColumn(columnIndex=4)
	  public Integer versionNo;

	  /**
	   * {@link #versionNo}フィールドのバリデーションを行います。
	   */
	  public boolean validateVersionNo(String arg){
		  return "1".equals(arg);
	  }

	  /**
	   * エンティティのバリデーションを行います。
	   */
	  public boolean validateRecord(String[] args){
		  String id     = args[0];
		  String deptNo = args[1];

		  if(!id.equals(deptNo)){
			  return false;
		  }

		  return true;
	  }

}
