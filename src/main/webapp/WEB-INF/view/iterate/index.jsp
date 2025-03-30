<%@page pageEncoding="UTF-8"%>
<tiles:insert template="/WEB-INF/view/common/layout.jsp" flush="true">
  <tiles:put name="title" value="繰り返し入力"></tiles:put>
  <tiles:put name="content" type="string">
    <h2>繰り返し入力</h2>
    <div class="content">
      <html:errors/>
      <s:form method="POST">
        <table border="1">
          <tr>
            <th>名前</th>
            <th>メールアドレス</th>
          </tr>
          <c:forEach items="${rows}" varStatus="s">
            <tr>
              <td><html:text property="rows[${s.index}].name" size="20"/></td>
              <td><html:text property="rows[${s.index}].mail" size="40"/></td>
            </tr>
          </c:forEach>
        </table>
        <html:submit property="send" value="送信"/>
      </s:form>
    </div>
  </tiles:put>
</tiles:insert>