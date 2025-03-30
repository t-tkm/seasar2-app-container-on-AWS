<%@page pageEncoding="UTF-8"%>
<tiles:insert template="/WEB-INF/view/common/layout.jsp" flush="true">
  <tiles:put name="title" value="フォーム"></tiles:put>
  <tiles:put name="content" type="string">
    <h2>フォーム</h2>
    <div class="content">
      <c:if test="${cancelled}">
        キャンセルされました。
      </c:if>
      テキスト入力
      <table border="1">
        <tr>
          <th>html:text</th>
          <td>${f:h(text)}</td>
        </tr>
        <tr>
          <th>html:password</th>
          <td>${f:h(password)}</td>
        </tr>
        <tr>
          <th>html:textarea</th>
          <td>${f:br(f:h(textarea))}</td>
        </tr>
        <tr>
          <th>html:radio</th>
          <td>${f:br(f:h(radio))}</td>
        </tr>
        <tr>
          <th>html:checkbox</th>
          <td>${f:br(f:h(checkbox))}</td>
        </tr>
        <tr>
          <th>html:multibox</th>
          <td>${f:h(multibox)}</td>
        </tr>
        <tr>
          <th>html:select</th>
          <td>${f:h(select1)}</td>
        </tr>
        <tr>
          <th>html:select</th>
          <td>${f:h(select2)}</td>
        </tr>
      </table>
    </div>
  </tiles:put>
</tiles:insert>