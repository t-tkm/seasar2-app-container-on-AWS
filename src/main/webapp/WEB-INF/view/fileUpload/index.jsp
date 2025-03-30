<%@page pageEncoding="UTF-8"%>
<tiles:insert template="/WEB-INF/view/common/layout.jsp" flush="true">
  <tiles:put name="title" value="ファイルアップロード"></tiles:put>
  <tiles:put name="content" type="string">
    <h2>ファイルアップロード</h2>
    <div class="content">
      <html:errors/>
      <s:form method="POST" enctype="multipart/form-data">
        <table>
          <tr>
            <th>ファイル：</th>
            <td><html:file property="file" /></td>
          </tr>
          <tr>
            <th>コメント：</th>
            <td><html:text property="comment" size="40"/></td>
          </tr>
        </table>
        <html:submit property="upload" value="アップロード"/>
      </s:form>
    </div>
  </tiles:put>
</tiles:insert>