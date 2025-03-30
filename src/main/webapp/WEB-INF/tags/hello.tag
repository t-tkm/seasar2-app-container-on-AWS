<%@ tag pageEncoding="UTF-8" body-content="empty" %>
<%@ attribute name="name" type="java.lang.String" required="true"%>

<%@ taglib prefix="f" uri="http://sastruts.seasar.org/functions" %>

こんにちは、<strong>${f:h(name)}</strong>さん！
