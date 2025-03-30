<%@page pageEncoding="UTF-8"%>
<tiles:insert template="/WEB-INF/view/common/layout.jsp" flush="true">
  <tiles:put name="title" value="繰り返し入力"></tiles:put>
  <tiles:put name="content" type="string">
    <h2>繰り返し入力</h2>
    <div class="content">
      <table border="1">
      <tr>
        <th>名前</th>
        <th>メールアドレス</th>
      </tr>
      <c:forEach var="row" items="${rows}">
        <tr>
          <td>${f:h(row.name)}</td>
          <td>${f:h(row.mail)}</td>
        </tr>
      </c:forEach>
      </table>
    </div>
  </tiles:put>
</tiles:insert>