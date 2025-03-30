<%@page pageEncoding="UTF-8"%>
<tiles:insert template="/WEB-INF/view/common/layout.jsp" flush="true">
  <tiles:put name="title" value="S2Chronos"></tiles:put>
  <tiles:put name="content" type="string">
    <h2>S2Chronos</h2>
    <div class="content">
      S2Chronosのタスクが出力したログを表示しています。1分おきにリフレッシュされます。<br>
      <pre>${f:h(messages)}</pre>
    </div>
  </tiles:put>
</tiles:insert>
