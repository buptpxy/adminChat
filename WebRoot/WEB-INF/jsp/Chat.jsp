<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
 <head>
    <meta charset="utf-8" />
    <title>聊天室</title>
    
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="apple-mobile-web-app-capable" content="yes" />    
    
    <link href="./css/bootstrap.min.css" rel="stylesheet" />
    <link href="./css/bootstrap-responsive.min.css" rel="stylesheet" />
    
    
    <link href="./css/font-awesome.css" rel="stylesheet" />
    
    <link href="./css/adminia.css" rel="stylesheet" /> 
    <link href="./css/adminia-responsive.css" rel="stylesheet" /> 
    
    
    <link href="./css/pages/plans.css" rel="stylesheet" /> 
	<link href="./css/pages/login.css" rel="stylesheet" /> 
    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
	
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>

<body>
	 <div class="navbar navbar-fixed-top">
	
	<div class="navbar-inner">
		
		<div class="container">

			<div class="nav-collapse">
			
				<ul class="nav pull-right">
					
					<li class="">
						
						<a href="javascript:;"></i> 您好 <span id="username" >${user.username}</span> ！欢迎进入聊天室^_^</a>
					</li>
				</ul>
				
			</div> <!-- /nav-collapse -->
			
		</div> <!-- /container -->
		
	</div> <!-- /navbar-inner -->
	
</div> <!-- /navbar -->
	
<div id="login-container">	
	
	<div id="login-content" class="clearfix">
	
	<div class="widget">			
		<div class="widget-header">
			<h3>聊天记录</h3>
		</div> <!-- /widget-header -->														
		<div class="widget-content">
			<div id="message" style="color: blue">
				【状态】		
			</div>	
			<div id="message1" >
					
			</div>		
			
			
		</div> <!-- /widget-content -->
		<div class="widget">					
				

		<div class="widget-content">
			<div class="tabbable">
				<div class="tab-content">
					<div class="tab-pane active" id="1">
						<div class="control-group">										
							<div class="controls">
								<textarea  class="input-medium" id="text" style="width:100%"></textarea>
							</div> <!-- /controls -->				
						</div> <!-- /control-group -->

						
							<button class="btn btn-primary" onclick="send()">发送</button> 
							<div class="pull-right">
								<button class="btn" onclick="closeWebSocket()">退出聊天室</button>
							<div class="pull-right">
	
					</div><!-- tab-pane active -->
					
				</div><!-- tab-content -->

			</div><!-- tabbable -->

		</div> <!-- /widget-content -->
	</div><!-- widget -->					
	</div><!-- widget -->
	</div><!-- login-content -->
</div><!-- login-container -->
</body>

<script type="text/javascript">
	var websocket = null;
	var username = document.getElementById('username').innerHTML;
	//判断当前浏览器是否支持WebSocket
	if ('WebSocket' in window) {
		websocket = new WebSocket("ws://localhost:8080/adminChat/check_user");
	} else {
		alert('不支持WebSocket!')
	}

	//连接发生错误的回调方法
	websocket.onerror = function() {
		setMessageInnerHTML("连接发生错误");
	};

	//连接成功建立的回调方法
	websocket.onopen = function(event) {
		setMessageInnerHTML("聊天室开启");
		
		var msg = "------【" + username + "】已上线------";
		websocket.send(msg);
	}

	//接收到消息的回调方法
	websocket.onmessage = function() {
		setMessageInnerHTML1(event.data);
	}

	//连接关闭的回调方法
	websocket.onclose = function() {
		setMessageInnerHTML("聊天室关闭");
	}

	//监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
	window.onbeforeunload = function() {
		
		var msg = "------【" + username + "】已下线------";
		websocket.send(msg);
		websocket.close();
	}

	//将消息显示在网页上
	function setMessageInnerHTML(innerHTML) {
		document.getElementById('message').innerHTML += innerHTML + '<br/>';
	}
	function setMessageInnerHTML1(innerHTML) {
		document.getElementById('message1').innerHTML += innerHTML + '<br/>';
	}

	//关闭连接
	function closeWebSocket() {
		
		var msg = "------【" + username + "】已下线------";
		websocket.send(msg);
		websocket.close();
	}

	//发送消息
	function send() {
		var message = document.getElementById('text').value;
		var msg = "【" + username + "】: " + message;
		websocket.send(msg);
		document.getElementById('text').value = "";
	}
</script>
</html>