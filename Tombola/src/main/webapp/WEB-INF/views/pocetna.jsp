<%@ include file="header.jsp"%>
<div class="contaier">
	<h1>Tombola</h1>


	<form:form action="/" modelAttribute="igrac" method="POST">
		<table class="tabela">
			<tr>
				<td><label>Unesite ime:</label></td>
				<td colspan="6"><input type="text" name="ime" placeholder="Ime"
					id="ime" maxlength="30" required /></td>
			</tr>
			<tr>
				<td colspan="7"><c:if test="${errorMsgKey ne 'null'}">
						<p style="color: red">${errorMsgKey}</p>
					</c:if></td>
			</tr>

			<tr>
			<tr>
				<td><label>Unesite brojeve:</label></td>
				<td><input type="text" name="broj1" class="broj" maxlength="2"
					required /></td>
				<td><input type="text" name="broj2" class="broj" maxlength="2"
					required /></td>
				<td><input type="text" name="broj3" class="broj" maxlength="2"
					required /></td>
				<td><input type="text" name="broj4" class="broj" maxlength="2"
					required /></td>
				<td><input type="text" name="broj5" class="broj" maxlength="2"
					required /></td>
				<td><input type="text" name="broj6" class="broj" maxlength="2"
					required /></td>
			<tr>
				<td colspan="7"><c:if test="${errorMsgIndex ne 'null'}">
						<p style="color: red">${errorMsgIndex}</p>
					</c:if></td>
			</tr>
			<tr>
				<td><input type="submit" name="igra" value="Potvrdi"
					class="button" /></td>
			</tr>

		</table>
	</form:form>

	<br> <br>
	<p style="color: red; text-align: center;">${errorMsgIgraci}</p>
	<p id="Izvlacenje">
		<a href="/tombola" class="button">Izvlacenje</a>
	</p>

	<br> <br>

	<div class="listaIgraca">
		<table class="tabela">
			<tr>
				<td>Imena igraca:</td>
			</tr>
			<c:forEach var="igrac" items="${igraci}">
				<tr>
					<td>${igrac.ime}</td>
				</tr>
			</c:forEach>

		</table>
	</div>
</div>
</body>
</html>