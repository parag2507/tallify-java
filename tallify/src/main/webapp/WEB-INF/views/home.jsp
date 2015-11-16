<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>
<html>
<body>

	<h2>Tallify</h2>
	<h3></h3>This is just glimpse of Tallify- The text mining software. Word count analysis of text files</br>
	
	But we plan to ......</br>
	
	Capture your work by storing your past analyses. In addition, the results from these  analyses are also stored for easy access. Users may also rerun analysis on previous work. 

	Custom analysis of your text. As a Tallify user you may analyze multiple, already exisiting, texts, as well as upload texts and webpages. Tallify works to provide users with the freedom to select a default stop word list, specify compound nouns through analysis selection, and enter metadata. 
	</h3>
	
	<form:form method="POST"
		action="${pageContext.servletContext.contextPath}/processText">
		<table>
			
			<tr>
				<td><form:label path="text">Text</form:label></td>

				<td><form:textarea path="text" rows="25" cols="30" /></td>
			</tr>
			<tr>
				<td><form:label path="stopWords">Enter stop words separated with comma</form:label></td>
				<td><form:textarea path="stopWords" rows="5" cols="30"/></td>

			</tr>

			<tr>
				<td></td>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>
	
	<h2>Analysis</h2>
	<table border="1">
	<thead> <th> Word</th>  <th> Count</th></thead>
	<c:forEach items="${mapOfStringCount}" var="entry">
    <tr>
    <td>${entry.key}</td> <td> ${entry.value}</td>
    </tr>
	</c:forEach>
	</table>

</body>
</html>