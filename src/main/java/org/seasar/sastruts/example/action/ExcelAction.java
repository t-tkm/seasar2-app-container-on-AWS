package org.seasar.sastruts.example.action;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.seasar.fisshplate.preview.FPPreviewUtil;
import org.seasar.fisshplate.template.FPTemplate;
import org.seasar.sastruts.example.fpao.HelloFpao;
import org.seasar.sastruts.example.fpao.HelloFpao.HelloDto;
import org.seasar.struts.annotation.Execute;
import org.seasar.struts.util.ResponseUtil;

/**
 * Fisshplateのサンプルです。
 *
 * @author Naoki Takezoe
 */
public class ExcelAction {

	@Resource
	protected HelloFpao helloFpao;

	/**
	 * Fisshplateのサンプル一覧を表示します。
	 */
	@Execute(validator=false)
	public String index(){
		return "index.jsp";
	}

	/**
	 * バインド変数のサンプルです。
	 */
	@Execute(validator=false)
	public String helloWorld() throws Exception {
		InputStream in = getClass().getResourceAsStream("/excel/HelloWorld.xls");
		FPTemplate template = new FPTemplate();

		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "たけぞう");

		HSSFWorkbook wb = template.process(in, map);

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		wb.write(out);

		ResponseUtil.download("HelloWorld.xls", out.toByteArray());

		return null;
	}

	/**
	 * 繰り返し処理のサンプルです。
	 */
	@Execute(validator=false)
	public String foreach() throws Exception{
		InputStream in = getClass().getResourceAsStream("/excel/Foreach.xls");
		FPTemplate template = new FPTemplate();

		Map<String, Object> map = new HashMap<String, Object>();
		List<Member> members = new ArrayList<Member>();
		members.add(new Member(1, "RYU"));
		members.add(new Member(2, "KEN"));
		members.add(new Member(3, "GUILE"));
		members.add(new Member(4, "E.HONDA"));

		map.put("members", members);

		HSSFWorkbook wb = template.process(in, map);

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		wb.write(out);

		ResponseUtil.download("Foreach.xls", out.toByteArray());

		return null;
	}

	@Execute(validator=false)
	public String hforeach() throws Exception{
		InputStream in = getClass().getResourceAsStream("/excel/HForeach.xls");
		FPTemplate template = new FPTemplate();

		Map<String, Object> map = new HashMap<String, Object>();
		List<Member> members = new ArrayList<Member>();
		members.add(new Member(1, "BISON"));
		members.add(new Member(2, "BARLOG"));
		members.add(new Member(3, "SAGAT"));
		members.add(new Member(4, "VEGA"));

		map.put("members", members);

		HSSFWorkbook wb = template.process(in, map);

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		wb.write(out);

		ResponseUtil.download("HForeach.xls", out.toByteArray());

		return null;
	}

	/**
	 * 繰り返し処理のサンプルで使用するDTOです。
	 *
	 * @author Naoki Takezoe
	 * @see ExcelAction#foreach()
	 */
	public static class Member {

		public Integer id;
		public String name;

		public Member(Integer id, String name){
			this.id = id;
			this.name = name;
		}
	}

	/**
	 * 遅延評価のサンプルです。
	 */
	@Execute(validator=false)
	public String suspend() throws Exception {
		InputStream in = getClass().getResourceAsStream("/excel/Suspend.xls");
		FPTemplate template = new FPTemplate();

		Map<String, Object> map = new HashMap<String, Object>();
		List<Item> items = new ArrayList<Item>();
		items.add(new Item("独習JavaScript", 2940));
		items.add(new Item("Seasar2徹底入門", 3800));

		map.put("items", items);

		HSSFWorkbook wb = template.process(in, map);

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		wb.write(out);

		ResponseUtil.download("Suspend.xls", out.toByteArray());

		return null;
	}

	/**
	 * 遅延評価のサンプルで使用するDTOです。
	 *
	 * @author Naoki Takezoe
	 * @see ExcelAction#suspend()
	 */
	public static class Item {

		public String name;
		public Integer price;

		public Item(String name, Integer price){
			this.name = name;
			this.price = price;
		}
	}

	/**
	 * 改ページのサンプルです。
	 */
	@Execute(validator=false)
	public String pageBreak() throws Exception {
		InputStream in = getClass().getResourceAsStream("/excel/PageBreak.xls");
		FPTemplate template = new FPTemplate();

		Map<String, Object> map = new HashMap<String, Object>();
		List<String> rows = new ArrayList<String>();
		rows.add("1行目");
		rows.add("2行目");
		rows.add("3行目");
		rows.add("4行目");
		rows.add("5行目");
		rows.add("6行目");
		rows.add("7行目");

		map.put("rows", rows);

		HSSFWorkbook wb = template.process(in, map);

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		wb.write(out);

		ResponseUtil.download("PageBreak.xls", out.toByteArray());

		return null;
	}

	/**
	 * S2Fisshplateのサンプルです。
	 */
	@Execute(validator=false)
	public String s2fisshplate() throws Exception {
		HelloDto helloDto = new HelloDto();
		helloDto.name = "たけぞう";

		HSSFWorkbook wb = helloFpao.hello(helloDto);

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		wb.write(out);

		ResponseUtil.download("HelloFpao_hello.xls", out.toByteArray());

		return null;
	}

	/**
	 * プレビュー機能のサンプルです。
	 */
	@Execute(validator=false)
	public String preview() throws Exception {
	    InputStream template = getClass().getResourceAsStream("/excel/Foreach.xls");
	    InputStream data = getClass().getResourceAsStream("/excel/Foreach_Preview.xls");

	    HSSFWorkbook wb = FPPreviewUtil.getWorkbook(template, data);

		ByteArrayOutputStream out = new ByteArrayOutputStream();
		wb.write(out);

		ResponseUtil.download("Foreach_Preview.xls", out.toByteArray());

		return null;
	}

}
