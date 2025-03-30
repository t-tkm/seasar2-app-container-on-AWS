<%@page pageEncoding="UTF-8"%>
<tiles:insert template="/WEB-INF/view/common/layout.jsp" flush="true">
  <tiles:put name="title" value="ロール認証"></tiles:put>
  <tiles:put name="content" type="string">
    <h2>ロール認証</h2>
    <div class="content">
      <strong>ユーザ：${f:h(userName)}、ロール：${f:h(userRole)}</strong>で認証されています。<br>
    </div>
  </tiles:put>
</tiles:insert>