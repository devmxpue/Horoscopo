<%@page import="com.ituniversity.horoscopo.modelo.Articulo"%>
<%@page import="com.ituniversity.horoscopo.modelo.Carrito"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.text.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
  <%@taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="content/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<title>Insert title here</title>
<%! private int contador=0; 
	private String getfecha(){
		return LocalDateTime.now().format(DateTimeFormatter.BASIC_ISO_DATE);
	}
%>
</head>
<body>
<jsp:useBean id="fecha" class="java.util.Date"></jsp:useBean>
<div class="container">
<%@ include file="/WEB-INF/plantilla/header.jsp"%>
		<h1>scriptlets</h1>
		<%-- int x =16; 
			double precio = (Math.random()*100);
			double impuesto = (precio * x)/100;
		--%>
		<c:set var ="x" value ="16"/>
		<c:set var ="precio" value ="${Math.random()*100}"/>
		<c:set var ="impuesto" value ="${(precio * x)/100}"/>
		<ol>
		<li> precio <c:out value="${precio}"></c:out></li>
		<li> precio con jstl <c:out value="${precio}"/></li>
		<li> impuesto ${impuesto}</li>
		<li class="bg-info"> total ${precio + impuesto }></li>
		</ol>
		<div class="alert alert-success">
			Visitas <%= ++contador %> veces al dia de hoy <%=getfecha() %>
		</div>
	</div>
	<table class="table table-striped">
		<thead>
		 <tr>
			<th>Nombre</th>
			<th>Tipo</th>
			<th>Precio</th>
			<th>Cantidad</th>
			<th>Subtotal</th>
		</tr>
		</thead>
		
		<tbody>
			<c:if test="${!empty carrito}">
				<c:forEach var ="a" items="${carrito.listaArticulos}">
			<tr>
				<td><c:out value="${a.nombre}"/></td>
				<td><c:out value="${a.tipo}"/></td>
				<td><fmt:formatNumber value="${a.precio}" type="currency" currencySymbol="$"/></td>
				<td><c:out value="${a.cantidad}"/></td>
				<td><fmt:formatNumber value="${a.costo}" type="currency" currencySymbol="$"/></td>			
			</tr>
			</c:forEach>
			</c:if>
			</tbody>
			<tfoot class="well">
			<tr><td colspan="5"><strong>Subtotal: <fmt:formatNumber value="${cart.getSubtotal()}"/></strong></td> </tr>
			<tr><td colspan="5"><strong>Impuesto: <fmt:formatNumber value="${cart.getImpuesto()}"/></strong></td></tr>
			<tr><td colspan="5"><strong>Total: <fmt:formatNumber value= "${cart.getTotal()}"/> </strong></td></tr>
			
			<tfoot>
			
		<%= fecha %>
	</table>
</div>


</body>
</html>