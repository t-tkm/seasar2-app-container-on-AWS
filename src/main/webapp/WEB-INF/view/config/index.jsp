<%@page pageEncoding="UTF-8"%>
<tiles:insert template="/WEB-INF/view/common/layout.jsp" flush="true">
  <tiles:put name="title" value="S2Config"></tiles:put>
  <tiles:put name="content" type="string">
    <h2>S2Config</h2>
    <div class="content">
      Configオブジェクトから取得した値：
      <table border="1">
        <tr>
          <th>プロパティ</th>
          <th>値</th>
        </tr>
        <tr>
          <td>jdbc.driver</td>
          <td>${f:h(jdbcConfig.driver)}</td>
        </tr>
        <tr>
          <td>jdbc.url</td>
          <td>${f:h(jdbcConfig.url)}</td>
        </tr>
        <tr>
          <td>jdbc.user</td>
          <td>${f:h(jdbcConfig.user)}</td>
        </tr>
        <tr>
          <td>jdbc.password</td>
          <td>${f:h(jdbcConfig.password)}</td>
        </tr>
      </table>
      <br>
      JavaコードでConfigContainerから取得した値：
      <table border="1">
        <tr>
          <th>プロパティ</th>
          <th>値</th>
        </tr>
        <tr>
          <td>jdbc.driver</td>
          <td>${f:h(jdbcDriver)}</td>
        </tr>
        <tr>
          <td>jdbc.url</td>
          <td>${f:h(jdbcUrl)}</td>
        </tr>
        <tr>
          <td>jdbc.user</td>
          <td>${f:h(jdbcUser)}</td>
        </tr>
        <tr>
          <td>jdbc.password</td>
          <td>${f:h(jdbcPassword)}</td>
        </tr>
      </table>
    </div>
  </tiles:put>
</tiles:insert>
