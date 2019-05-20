<%@ include file="header.jsp"%>
<div class="contaier">
	<h1>Lista pobednika</h1>
	
	<table class="tabela">
		<tr>
			<th>id igre</th>
			<th>ime dobitnika</th>
			<th>kombinacija</th>
		</tr>
		<c:forEach var="igra" items="${dobitnici}">
			<tr>
				<td>${igra.idIgre}</td>
				<td>${igra.imePobednika}</td>
				<td>${igra.prikazKomb(igra.dobitnaKomb)}</td>
			</tr>
		</c:forEach>
	</table>

</div>
</body>
</html>