<%@ include file="header.jsp"%>
<%@page import="com.nemanja.service.IgraService"%>
<%@page import="java.util.ArrayList"%>
<div class="container">
	<h1>Izvlacenje</h1>

	<div id="izvlacenjeBrojeva">

		<c:forEach var="broj" items="${brojevi}">
		|
		<c:out value="${broj}" />
		|
		</c:forEach>
		<br>
		<p>
			<%
				System.out.print("Hello");
			%>
		</p>
		<p>Pobednik je ${pobednik}!</p>
	</div>
	<div>
		<form action="/tombola" method="POST">
		<p style="text-align: center">
			<button  name="obrisi" class="button">Nova igra</button>
		</p>
		</form>
		
		<p style="text-align: center">
			<a href="/listaPobednika" class="button">Lista pobednika</a>
		</p>
	</div>
</div>
</body>
</html>