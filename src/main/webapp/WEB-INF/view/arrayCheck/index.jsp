<%@page pageEncoding="UTF-8"%>
<tiles:insert template="/WEB-INF/view/common/layout.jsp" flush="true">
  <tiles:put name="title" value="配列の入力チェック"></tiles:put>
  <tiles:put name="content" type="string">
    <h2>配列の入力チェック</h2>
    <div class="content">
      <s:form>
        使用しているフレームワークを選択してください：<br>
        <html:errors/>
        <html:multibox property="frameworks" styleId="Seasar2" value="Seasar2"/><label for="Seasar2">Seasar2</label><br>
        <html:multibox property="frameworks" styleId="SAStruts" value="SAStruts"/><label for="SAStruts">SAStruts</label><br>
        <html:multibox property="frameworks" styleId="S2JDBC" value="S2JDBC"/><label for="S2JDBC">S2JDBC</label><br>
        <html:multibox property="frameworks" styleId="Spring Framework" value="Spring Framework"/><label for="Spring Framework">Spring Framework</label><br>
        <html:multibox property="frameworks" styleId="Struts" value="Struts"/><label for="Struts">Struts</label><br>
        <html:multibox property="frameworks" styleId="Hibernate" value="Hibernate"/><label for="Hibernate">Hibernate</label><br>
        <s:submit property="send" value="送信"/>
      </s:form>
    </div>
  </tiles:put>
</tiles:insert>