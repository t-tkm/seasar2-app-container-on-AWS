<%@page pageEncoding="UTF-8"%>
<tiles:insert template="/WEB-INF/view/common/layout.jsp" flush="true">
  <tiles:put name="title" value="相関チェック"></tiles:put>
  <tiles:put name="content" type="string">
    <h2>相関チェック</h2>
    <div class="content">
      <html:errors/>
      <s:form>
        同じ値を入力してください：
        <html:text property="value1" />
        <html:text property="value2" /><br>
        <s:submit property="send" value="送信"/>
      </s:form>
    </div>
  </tiles:put>
</tiles:insert>