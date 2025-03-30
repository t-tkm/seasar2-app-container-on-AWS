<%@page pageEncoding="UTF-8"%>
<tiles:insert template="/WEB-INF/view/common/layout.jsp" flush="true">
  <tiles:put name="title" value="トランザクショントークン"></tiles:put>
  <tiles:put name="content" type="string">
    <h2>トランザクショントークン</h2>
    <div class="content">
      正しいリクエストを受け付けました。<br>
      F5でリクエストを再送信すると不正なリクエストとして検出されます。
    </div>
  </tiles:put>
</tiles:insert>