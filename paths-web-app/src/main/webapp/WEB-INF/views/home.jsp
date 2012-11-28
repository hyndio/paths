<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Paths-Home</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/bootstrap/css/bootstrap.min.css'/>" />
</head>
<body>

	<header>
	  <div class="container">
	    <h2>Over-thinking leads to negative thoughts.</h2>
	    <p class="lead">
	      <span class="label label-success">1. 昨夜西风凋碧树，独上高楼，望尽天涯路。</span>
	      <span class="label label-important">2. 衣带渐宽终不悔，为伊消得人憔悴。</span>
	      <span class="label label-info">3. 众里寻他千百度，蓦然回首，那人却在灯火阑珊处。</span>
	    </p>
	    <div id="sss"></div>
	  </div>
	</header>
	
	<h2>
		<a href="<c:url value="/clickHere" />"><spring:message code="click.here" /></a>
	</h2>
	<h3>
		<a href="secure/index.jsp">spring-security</a>
	</h3>
	
	<h3>
		<a href="<c:url value="/slowlySpead" />">spring-ws-slowly</a>
	</h3>
	
	<!-- javascript -->
	<script type="text/javascript" src="<c:url value='/resources/js/common/sea.js'/>" id="seajsnode" 
		data-main="<c:url value='/resources/js/init/home.js'/>"></script>
</body>
</html>