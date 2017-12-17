<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>注册</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="apple-mobile-web-app-capable" content="yes" />    
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="././css/bootstrap.min.css" rel="stylesheet" />
    <link href="././css/bootstrap-responsive.min.css" rel="stylesheet" />
    <link href="././css/font-awesome.css" rel="stylesheet" />
    <link href="././css/adminia.css" rel="stylesheet" /> 
    <link href="././css/adminia-responsive.css" rel="stylesheet" /> 
    <link href="././css/pages/login.css" rel="stylesheet" /> 

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
	
  
  </head>
  
  <body>
    <div class="navbar navbar-fixed-top">
	
	<div class="navbar-inner">
		
		<div class="container">
			
			<div class="nav-collapse">
			
				<ul class="nav pull-right">
					
					<li class="">
						
						<a href="javascript:;"><i class="icon-chevron-left"></i> 回到主页</a>
					</li>
				</ul>
				
			</div> <!-- /nav-collapse -->
			
		</div> <!-- /container -->
		
	</div> <!-- /navbar-inner -->
	
</div> <!-- /navbar -->


<div id="login-container">
	
	
	<div id="login-header">
		
		<h3>欢迎注册</h3>
		
	</div> <!-- /login-header -->
	
	<div id="login-content" class="clearfix">
	<c:if test="${error!=null}">
		<div class="widget" >
			<div class="widget-content" style="color:red">
				<h3>注册失败!</h3>
				<p>${error}</p>
			</div>
		</div>
	</c:if>
	<form:form modelAttribute="user" commandName="user" action="save_user" method="post">
				<fieldset>
					<div class="control-group">
						<label class="control-label" for="username">Username</label>
						<div class="controls">
							<form:input  id="username" path="username"/>
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="password">Password</label>
						<div class="controls">
							<form:password  id="password" path="password"/>
						</div>
					</div>
				</fieldset>
				
				
				
				<div class="pull-right">
					<button type="submit" class="btn btn-warning btn-large">
						注册
					</button>
				</div>
	</form:form>
			
		</div> <!-- /login-content -->
		
		
		<div id="login-extra">
			
			<p>已有账号 ？<a href=" <c:url value='/login' />">去登录</a></p>
			
		</div> <!-- /login-extra -->
	
</div> <!-- /login-wrapper -->

<script src="././js/jquery-1.7.2.min.js"></script>
<script src="././js/bootstrap.js"></script>

  
  </body>
</html>
