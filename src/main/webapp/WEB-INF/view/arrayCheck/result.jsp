<%@page pageEncoding="UTF-8"%>
<tiles:insert template="/WEB-INF/view/common/layout.jsp" flush="true">
  <tiles:put name="title" value="配列の入力チェック"></tiles:put>
  <tiles:put name="content" type="string">
    <h2>配列の入力チェック</h2>
    <div class="content">
      以下のフレームワークが選択されました。
      <ul>
        <c:forEach items="${frameworks}" var="framework">
          <li>${f:h(framework)}</li>
        </c:forEach>
      </ul>
    </div>
  </tiles:put>
</tiles:insert>