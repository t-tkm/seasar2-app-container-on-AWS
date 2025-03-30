<%@page pageEncoding="UTF-8"%>
<tiles:insert template="/WEB-INF/view/common/layout.jsp" flush="true">
  <tiles:put name="title" value="ファイルアップロード"></tiles:put>
  <tiles:put name="content" type="string">
    <h2>ファイルアップロード</h2>
    <div class="content">
      以下のファイルがアップロードされました。
      <ul>
        <li>ファイル名： ${f:h(filename)}</li>
        <li>ファイルサイズ： ${size}bytes</li>
        <li>コメント： ${f:h(comment)}</li>
      </ul>
    </div>
  </tiles:put>
</tiles:insert>