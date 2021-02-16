<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
 
<html>
  <body>
    <h1>Main Simple Form Page</h1>
      
    <form:form method="POST" commandName="word">
        <table>
            <tr>
                <td>Word:</td>
                <td><form:input path="content" /></td>
            </tr>
            <tr>
                <td><input type="submit" /></td>
            </tr>
        </table>
    </form:form>
      
  </body>
</html>