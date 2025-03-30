<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<tiles:insert template="/WEB-INF/view/common/layout.jsp" flush="true">
  <tiles:put name="title" value="エラー処理"></tiles:put>
  <tiles:put name="content" type="string">
    <h2>エラーが発生しました</h2>
    <div class="content">
      <ul>
        <li>ステータスコード - ${requestScope["javax.servlet.error.status_code"]}</li>
        <li>メッセージ - ${f:h(requestScope["javax.servlet.error.exception"].message)}</li>
        <li>例外の型 - ${f:h(requestScope["javax.servlet.error.exception_type"])}</li>
        <li>例外の発生したURI - ${f:h(requestScope["javax.servlet.error.request_uri"])}</li>
        <li>例外が発生したサーブレット名 - ${f:h(requestScope["javax.servlet.error.servlet_name"])}</li>
      </ul>
    </div>
  </tiles:put>
</tiles:insert>