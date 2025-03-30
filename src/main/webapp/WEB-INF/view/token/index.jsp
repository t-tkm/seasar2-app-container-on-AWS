<%@page pageEncoding="UTF-8"%>
<tiles:insert template="/WEB-INF/view/common/layout.jsp" flush="true">
  <tiles:put name="title" value="トランザクショントークン"></tiles:put>
  <tiles:put name="content" type="string">
    <h2>トランザクショントークン</h2>
    <div class="content">
      ※送信後にF5でリクエストを再送信するとエラーになります。
      <html:errors/>
      <s:form>
        <s:submit property="send" value="送信"/>
        <s:submit property="index" value="トークンを再発行"/>
      </s:form>
    </div>
  </tiles:put>
</tiles:insert>