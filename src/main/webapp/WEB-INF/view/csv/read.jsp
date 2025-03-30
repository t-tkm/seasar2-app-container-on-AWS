<%@page pageEncoding="UTF-8"%>
<tiles:insert template="/WEB-INF/view/common/layout.jsp" flush="true">
  <tiles:put name="title" value="S2CSV"></tiles:put>
  <tiles:put name="content" type="string">
    <h2>S2CSV</h2>
    <div class="content">
      <table border="1">
        <tr>
          <th>ID</th>
          <th>DEPT NO</th>
          <th>DEPT NAME</th>
          <th>LOC</th>
          <th>VERSION NO</th>
        </tr>
        <c:forEach var="dept" items="${deptList}">
          <tr>
            <td>${dept.id}</td>
            <td>${dept.deptNo}</td>
            <td>${dept.deptName}</td>
            <td>${dept.loc}</td>
            <td>${dept.versionNo}</td>
          </tr>
        </c:forEach>
      </table>
      <br>
      S2CSVでオブジェクトから書き出したCSV：<br>
      <pre>${f:h(csv)}</pre>
    </div>
  </tiles:put>
</tiles:insert>
