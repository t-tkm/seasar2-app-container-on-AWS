package org.seasar.sastruts.example.action;

import java.util.List;

import javax.annotation.Resource;

import org.seasar.framework.util.IntegerConversionUtil;
import org.seasar.sastruts.example.entity.Emp;
import org.seasar.sastruts.example.form.JdbcForm;
import org.seasar.sastruts.example.service.EmpService;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

/**
 * S2JDBCのサンプルです。
 *
 * @author Naoki Takezoe
 */
public class JdbcAction {

	@Resource
	protected EmpService empService;

	@Resource
	@ActionForm
	protected JdbcForm jdbcForm;

	// 前のページがあるかどうか
	public boolean hasNext = false;

	// 次のページがあるかどうか
	public boolean hasPrev = false;

	// 総件数
	public long total;

	public List<Emp> empList;

	// 1ページに5件ずつ表示
	private static final int LIMIT = 5;

	@Execute(validator=false)
	public String index(){
		// ページ番号を取得
		int page = IntegerConversionUtil.toPrimitiveInt(this.jdbcForm.page);

		// 総件数を取得
		this.total = this.empService.getCount();

		// 表示するデータを取得
		this.empList = this.empService.findAllOrderById(LIMIT, page * LIMIT);

		// 前のページがあるかどうかを判定
		if(page != 0){
			hasPrev = true;
		}
		// 次のページがあるかどうかを判定
		if((page + 1) * LIMIT < total){
			hasNext = true;
		}

		return "index.jsp";
	}

}
