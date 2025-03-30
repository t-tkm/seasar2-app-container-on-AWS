<%@page pageEncoding="UTF-8"%>
<tiles:insert template="/WEB-INF/view/common/layout.jsp" flush="true">
  <tiles:put name="title" value="S2JDBC"></tiles:put>
  <tiles:put name="content" type="string">
    <h2>S2JDBC</h2>
    <div class="content">
      全部で<strong>${total}</strong>件のデータがあります。
      <table border="1">
        <tr>
          <th>ID</th>
          <th>社員番号</th>
          <th>名前</th>
          <th>サラリー</th>
        </tr>
        <c:forEach var="emp" items="${empList}">
          <tr>
            <td>${emp.id}</td>
            <td>${emp.empNo}</td>
            <td>${f:h(emp.empName)}</td>
            <td>${emp.sal}</td>
          </tr>
        </c:forEach>
      </table>
      <c:if test="${hasPrev}">
        <a href="?page=${page - 1}">&lt;前へ</a>
      </c:if>
      <c:if test="${!hasPrev}">
        &lt;前へ
      </c:if>
      <c:if test="${hasNext}">
        <a href="?page=${page + 1}">次へ&gt;</a>
      </c:if>
      <c:if test="${!hasNext}">
        次へ&gt;
      </c:if>
    </div>
  </tiles:put>
</tiles:insert>
