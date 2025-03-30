<%@page pageEncoding="UTF-8"%>
<html>
<head>
  <title><tiles:getAsString name="title" /> - Seasar2徹底入門サンプル</title>
  <link rel="stylesheet" type="text/css" href="${f:url('/style.css')}">
</head>
<body>
<table width="100%">
  <tr><td colspan="2"><tiles:insert page="/WEB-INF/view/common/header.jsp" /></td></tr>
  <tr>
    <td width="20%" valign="top"><tiles:insert page="/WEB-INF/view/common/menu.jsp" /></td>
    <td valign="top" class="content"><tiles:insert attribute="content" /></td>
  </tr>
  <tr><td colspan="2"><tiles:insert page="/WEB-INF/view/common/footer.jsp" /></td></tr>
</table>
</body>
</html>