<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>工程文档</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/static/bootstrap/css/bootstrap.min.css'/>" />
<style type="text/css">
body {
	margin: 20px 0;
	background-color: #f7f7f9;
}

#the-show-area {
	width: 760px;
	border-radius: 3px;
  	border: 1px solid #e1e1e8;
  	padding: 20px;
}
</style>
</head>
<body>
	<div class="container" id="the-show-area">${innerHtml }</div>
</body>
</html>