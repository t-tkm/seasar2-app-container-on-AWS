<%@page pageEncoding="UTF-8"%>
<tiles:insert template="/WEB-INF/view/common/layout.jsp" flush="true">
  <tiles:put name="title" value="フォーム"></tiles:put>
  <tiles:put name="content" type="string">
    <h2>フォーム</h2>
    <div class="content">
      <html:errors/>
      <s:form method="POST">
        テキスト入力
        <table border="1">
          <tr>
            <th>html:text</th>
            <td><html:text property="text"/></td>
          </tr>
          <tr>
            <th>html:password</th>
            <td><html:password property="password"/></td>
          </tr>
          <tr>
            <th>html:textarea</th>
            <td><html:textarea property="textarea"/></td>
          </tr>
          <tr>
            <th>html:radio</th>
            <td>
              <html:radio styleId="radio1" property="radio" value="1"/><label for="radio1">ラジオボタン1</label>
              <html:radio styleId="radio2" property="radio" value="2"/><label for="radio2">ラジオボタン2</label>
            </td>
          </tr>
          <tr>
            <th>html:checkbox</th>
            <td><html:checkbox styleId="checkbox" property="checkbox" value="1"/><label for="checkbox">チェックボックス</label></td>
          </tr>
          <tr>
            <th>html:multibox</th>
            <td>
              <html:multibox styleId="multibox1" property="multibox" value="1"/><label for="multibox1">マルチボックス1</label>
              <html:multibox styleId="multibox2" property="multibox" value="2"/><label for="multibox2">マルチボックス2</label>
              <html:multibox styleId="multibox3" property="multibox" value="3"/><label for="multibox3">マルチボックス3</label>
            </td>
          </tr>
          <tr>
            <th>html:select</th>
            <td>
              <html:select property="select1">
                <html:option value="1">Java</html:option>
                <html:option value="2">C#</html:option>
                <html:option value="3">Python</html:option>
              </html:select>
            </td>
          </tr>
          <tr>
            <th>html:select(multiple)</th>
            <td>
              <html:select property="select2" size="5" multiple="multiple">
                <html:options collection="empList" property="id" labelProperty="empName"/>
              </html:select>
            </td>
          </tr>
        </table>
        <s:submit value="送信" property="send"/>
        <html:reset value="リセット"/>
      </s:form>
    </div>
  </tiles:put>
</tiles:insert>