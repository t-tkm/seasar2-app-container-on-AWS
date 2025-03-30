<%@page pageEncoding="UTF-8"%>
<tiles:insert template="/WEB-INF/view/common/layout.jsp" flush="true">
  <tiles:put name="title" value="Seasar2徹底入門"></tiles:put>
  <tiles:put name="content" type="string">
    <h2>Seasar2徹底入門</h2>
    <div class="content">
      Seasar2徹底入門のサンプルアプリケーションです。<br>
      <br>
      現在の動作モード：<strong>${f:h(mode)}</strong>
    </div>
  </tiles:put>
</tiles:insert>