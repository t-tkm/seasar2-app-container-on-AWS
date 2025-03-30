<%@page pageEncoding="UTF-8"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>

<tiles:insert template="/WEB-INF/view/common/layout.jsp" flush="true">
  <tiles:put name="title" value="エコーアプリケーション"></tiles:put>
  <tiles:put name="content" type="string">
    <h2>エコーアプリケーション</h2>
    <div class="content">
      カスタムタグで出力：<my:hello name="${name}"/><br>
      タグファイルで出力：<tags:hello name="${name}" />
    </div>
  </tiles:put>
</tiles:insert>
