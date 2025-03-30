<%@page pageEncoding="UTF-8"%>
<tiles:insert template="/WEB-INF/view/common/layout.jsp" flush="true">
  <tiles:put name="title" value="S2CSV"></tiles:put>
  <tiles:put name="content" type="string">
    <h2>S2CSV</h2>
    <div class="content">
      <a href="http://s2csv.sandbox.seasar.org/">S2CSV</a>を使ったCSVの読み込みのサンプルです。
      <html:errors/>
      <s:form>
        <html:textarea property="csvData" cols="80" rows="10"></html:textarea><br>
        <html:checkbox property="processAll" value="1" styleId="processAll"/><label for="processAll">一括で処理する</label>
        <s:submit property="read" value="送信" />
      </s:form>
    </div>
  </tiles:put>
</tiles:insert>
