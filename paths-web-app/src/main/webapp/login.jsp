<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>登录页</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/bootstrap/css/bootstrap.min.css'/>" />
</head>
<body onload='document.f.j_username.focus();'>

	<header>
	  <div class="container">
	    <h2>Over-thinking leads to negative thoughts.</h2>
	    <p class="lead">
	      <span class="label label-success">1. 昨夜西风凋碧树，独上高楼，望尽天涯路。</span>
	      <span class="label label-important">2. 衣带渐宽终不悔，为伊消得人憔悴。</span>
	      <span class="label label-info">3. 众里寻他千百度，蓦然回首，那人却在灯火阑珊处。</span>
	    </p>
	  </div>
	</header>
	
	<div class="container">
		<form class="form-horizontal" name='f' action="<c:url value='/j_spring_security_check' />" method="post">
			<fieldset>
				<legend>
					<strong><i class="icon-user"></i>用户登录</strong>
				</legend>
				<div class="control-group">
					<label class="control-label" or="inputUsername">用户名</label>
					<div class="controls">
						<input type="text" id="inputUsername" name="j_username" placeholder="用户名">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="inputPassword">密码</label>
					<div class="controls">
						<input type="password" id="inputPassword" name="j_password" placeholder="密码">
					</div>
				</div>

				<!-- <td><input type='checkbox' name='_spring_security_remember_me' /></td>
				<td>Remember me on this computer.</td> -->

				<div class="control-group">
					<div class="form-actions">
						<a href="/">没有用户账号？请注册！</a> 
						<input type="submit" class="btn btn-primary" value="登录" />
						<a href="/" class="btn">取消</a>
					</div>
				</div>
			</fieldset>
		</form>
	</div>
</body>
</html>