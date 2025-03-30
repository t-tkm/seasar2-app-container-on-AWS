<%@page pageEncoding="UTF-8"%>
<tiles:insert template="/WEB-INF/view/common/layout.jsp" flush="true">
  <tiles:put name="title" value="エコーアプリ"></tiles:put>
  <tiles:put name="content" type="string">
    <html:javascript formName="echoActionForm_echo"/>
    <h2>エコーアプリケーション</h2>
    <div class="content">
      <html:errors/>
      <s:form method="POST">
        お名前をどうぞ！
        <html:text property="name" />
        <s:submit property="echo" value="送信"/>
        <s:submit property="echo" value="送信(JavaScriptで入力チェック)" clientValidate="true"/>
      </s:form>
    </div>
  </tiles:put>
</tiles:insert>