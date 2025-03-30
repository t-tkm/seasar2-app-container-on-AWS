<%@page pageEncoding="UTF-8"%>
<tiles:insert template="/WEB-INF/view/common/layout.jsp" flush="true">
  <tiles:put name="title" value="認証"></tiles:put>
  <tiles:put name="content" type="string">
    <h2>認証</h2>
    <div class="content">
      <%-- ログイン中の表示 --%>
      <c:if test="${userDto.login}">
        <strong>ログイン中です。</strong>
        <s:form>
          <s:submit property="logout" value="ログアウト"></s:submit>
        </s:form>
      </c:if>

      <%-- ログインしていない場合の表示 --%>
      <c:if test="${!userDto.login}">
        <html:errors/>
        <s:form>
          <table>
            <tr>
              <th>ユーザ名：</th>
              <td><html:text property="userName" errorStyleClass="error"/></td>
            </tr>
            <tr>
              <th>パスワード：</th>
              <td><html:password property="password" errorStyleClass="error"/></td>
            </tr>
          </table>
          <s:submit property="login" value="ログイン"/>
          ※admin/adminでログインできます。
        </s:form>
      </c:if>

      <s:link href="/login/auth/">ログイン中のみ表示可能なページ</s:link>
    </div>

    <br>
    <h2>ロール認証</h2>
    <div class="content">
      このサンプルを実行するにはtomcat-users.xmlに以下の設定を追加してください。
      <pre>&lt;?xml version=&quot;1.0&quot; encoding=&quot;UTF-8&quot;?&gt;
&lt;tomcat-users&gt;
  &lt;!-- &#12525;&#12540;&#12523;&#12434;&#23450;&#32681; --&gt;
  &lt;role rolename=&quot;admin&quot;/&gt;
  &lt;role rolename=&quot;guest&quot;/&gt;
  &lt;!-- &#12518;&#12540;&#12470;&#12434;&#23450;&#32681; --&gt;
  &lt;user password=&quot;admin&quot; roles=&quot;admin&quot; username=&quot;admin&quot;/&gt;
  &lt;user password=&quot;guest&quot; roles=&quot;guest&quot; username=&quot;guest&quot;/&gt;
&lt;/tomcat-users&gt; </pre>
      <ul>
        <li><s:link href="/role/admin/">ロール認証のサンプル（admin）</s:link></li>
        <li><s:link href="/role/guest/">ロール認証のサンプル（guest）</s:link></li>
      </ul>
    </div>
  </tiles:put>
</tiles:insert>
