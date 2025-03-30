<%@page pageEncoding="UTF-8"%>
<tiles:insert template="/WEB-INF/view/common/layout.jsp" flush="true">
  <tiles:put name="title" value="認証"></tiles:put>
  <tiles:put name="content" type="string">
    <h2>認証</h2>
    <div class="content">
      このページはログイン中のみ表示可能です。
    </div>
  </tiles:put>
</tiles:insert>
