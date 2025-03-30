<%@page pageEncoding="UTF-8"%>
<tiles:insert template="/WEB-INF/view/common/layout.jsp" flush="true">
  <tiles:put name="title" value="Fisshplate"></tiles:put>
  <tiles:put name="content" type="string">
    <h2>Fisshplate</h2>
    <div class="content">
      <ul>
        <li><s:link href="/excel/helloWorld/">FisshplateでHello World</s:link></li>
        <li>繰り返し（<s:link href="/excel/foreach/">縦</s:link>、<s:link href="/excel/hforeach/">横</s:link>）</li>
        <li><s:link href="/excel/suspend/">遅延評価</s:link></li>
        <li><s:link href="/excel/pageBreak/">改ページ</s:link></li>
        <li><s:link href="/excel/s2fisshplate/">S2Fisshplate</s:link></li>
      </ul>
    </div>
  </tiles:put>
</tiles:insert>
