<%@ page language="java" contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
<title>接口测试</title>
<link href="https://lib.baomitu.com/font-awesome/5.13.0/css/all.min.css"
	rel="stylesheet">
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/clipboard.min.js"></script>
<style type="text/css">
.carousel-inner .item img {
	width: 100%;
	height: 250px;
}
</style>

</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
	<div>
		<!-- 导航条 -->
		<div>
		<nav class="navbar navbar-inverse">
      <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand glyphicon glyphicon-heart" href="#tis"> Http接口测试工具</a>
    </div>
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" style="padding-top: 5px;">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">接口测试 <span class="sr-only">(current)</span></a></li>
        <li><a href="/FindAllbyPageServlet">数据查询</a></li>
		  <li><button class="0btn btn-primary" onclick="tishi()">使用提示</button></li>yige
      </ul>
    </div>
		</div>
</nav>
		</div>
		<!-- 轮播图container为轮播图添加居中属性 -->
		<div class="container" style="width:1000px;">
			<div id="carousel-example-generic" class="carousel slide"
				data-ride="carousel">
				<!-- 设置轮播图的顺序 -->
				<ol class="carousel-indicators">
					<li data-target="#carousel-example-generic" data-slide-to="0"
						class="active"></li>
					<li data-target="#carousel-example-generic" data-slide-to="1"></li>
					<li data-target="#carousel-example-generic" data-slide-to="2"></li>
					<li data-target="#carousel-example-generic" data-slide-to="3"></li>
					<li data-target="#carousel-example-generic" data-slide-to="4"></li>
				</ol>
				<!-- 设置轮播图片 -->
				<div class="carousel-inner" role="listbox" >
					<div class="item active" style="width: 100%;">
						<img src="img/d.PNG" alt="">
						<div class="carousel-caption"></div>
					</div>
					<div class="item" style="width: 100%;">
						<img src="img/c.PNG" alt="">
						<div class="carousel-caption"></div>
					</div>
					<div class="item" style="width: 100%;">
						<img src="img/b.PNG" alt="">
						<div class="carousel-caption"></div>
					</div>
					<div class="item" style="width: 100%;">
						<img src="img/e.PNG" alt="">
						<div class="carousel-caption"></div>
					</div>
					<div class="item" style="width: 100%;">
						<img src="img/8.PNG" alt="">
						<div class="carousel-caption"></div>
					</div>
				</div>
				<!-- Controls -->
				<a class="left carousel-control" href="#carousel-example-generic"
					role="button" data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					<span class="sr-only">Previous</span>
				</a> <a class="right carousel-control" href="#carousel-example-generic"
					role="button" data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					<span class="sr-only">Next</span>
				</a>
			</div>
		</div>
		<!-- form表单输入框组 -->
		<div style="width: 2000px;">
		<br>
			<form name="post_detail" action="/ServletDate" method="post" class="form-horizontal">
			<!-- 输入接口地址 -->
				<div class="form-group">
					<label class="col-sm-2 control-label">url</label>
					<div class="col-sm-10" style="width: 900px;">
						<input type="text" name="get" class="form-control" placeholder="请输入接口地址;">
					</div>
				</div>
			 <!--key/value输入框 -->
				<div class="form-group">
					<label class="col-sm-2 control-label">key</label>
					<div class="col-sm-10" style="width: 900px;">
						<input type="text" name="keys" class="form-control" placeholder="">
					</div>
				</div>
				<div class="form-group" style="margin-bottom: 0.5em;">
					<label class="col-sm-2 control-label">value</label>
					<div class="col-sm-10" style="width: 900px;">
						<input type="text" name="values" class="form-control" placeholder="">
					</div>
				</div>
		        <!-- 方法单选按钮 -->
				<div class="form-group" style="margin-bottom: 0.5em;">
				<div class="col-sm-offset-2 col-sm-10">
					<label class="radio-inline">
                     <input type="radio" name="Options" id="inlineRadio1" value="get"> get
                    </label>
                    <label class="radio-inline">
                     <input type="radio" name="Options" id="inlineRadio2" value="put"> put
                    </label>
                    <label class="radio-inline">
                      <input type="radio" name="Options" id="inlineRadio3" value="post"> post
                    </label>
                    <label class="radio-inline">
                      <input type="radio" name="Options" id="inlineRadio4" value="delete"> delete
                    </label>
				</div>
				</div>
				<script id="tis">
					function tishi() {
						alert("请输入请求链接(多链接请用“,”隔开)；请输入请求属性(多属性请用“.”隔开，每个链接属性请用“，”结束;请输入请求属性值(多属性值请用“.”隔开，每个链接属性请用“，”结束)")
                    }
				</script>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-primary">提交</button>
					</div>
				</div>
			</form>
			<form action="/ServletDateWay2" method="post" class="form-horizontal">
					<div class="form-group" style="margin-bottom: 0.5em;">
						<div class="col-sm-offset-2 col-sm-10">
							<label class="radio-inline">
								<input type="radio" name="Opt" id="inlineRadio5" value="get"> get
							</label>
							<label class="radio-inline">
								<input type="radio" name="Opt" id="inlineRadio6" value="put"> put
							</label>
							<label class="radio-inline">
								<input type="radio" name="Opt" id="inlineRadio7" value="post"> post
							</label>
							<label class="radio-inline">
								<input type="radio" name="Opt" id="inlineRadio8" value="delete"> delete
							</label>
							<br>
							<input type="file" name="file" id="fileField1" onchange="">
							<button type="submit" class="btn btn-primary">以文件得形式提交</button>
						</div>
					</div>
				</form>
			<br>
		</div>
		<!-- 响应体显示（标签页） -->
		<div style="width: 1200px;">
			<ul class="nav nav-tabs col-md-offset-3">
				<li class="active" style=""><button onclick="showbody()">响应体</button></li>
				<li class="active" style=""><button onclick="showhead()">响应头</button></li>
				<li class="active" style=""><button onclick="showcontext()">Jsoup数据解析</button></li>
				<li class="active" style=""><button type="button"
													class="btn_copy btn-default" data-clipboard-target="#foo" aria-label="复制成功！"> copy</button></li>
		<!-- 结果状态显示 -->
				<li name="status_detail" style="padding-left: 500px; padding-top: 10px;">
				<!-- 通过后端传过来的状态码，来显示访问接口的状态。
				开始默认隐藏状态栏，后端传过来的值与那个label的value匹配，则触发相应事件，显示相应的状态标签 -->
			<script type="text/javascript">
				function suc(){

				}
			</script>
                <%--<span class="label label-success" value="Success" id="suc">Success</span>--%>
                <%--<span class="label label-danger" value="Failed" id="faill">Failed</span>--%>
					响应代码为：<span><%
						int[] code=(int[])request.getAttribute("code");
						if(code!=null){
							for(int a=0;code[a]!=0;a++){
								out.print(code[a]);
								out.write("&nbsp");
							}
						}
					%></span>
				</li>
			</ul>
			<div id="foo" class="tab-content col-md-offset-3">
				<div class="tab-pane active" id="home" style="padding: 5px;">
					<div margin:0 auto width:120px id="body" style="display:block">
    <textarea placeholder="响应体在这里显示" readonly="readonly" cols="120" rows="10">
        <%
			String[] body=(String[])request.getAttribute("body");
			if(body!=null){
				for(int b=0;body[b]!=null;b++){
					out.write(body[b]);
					out.write("\n");
					out.write("--------------------------------------");
					out.write("\n");
				}
			}
		%>
    </textarea>
					</div>
				</div>
					<div margin:0 auto width:300px id="header" style="display: none">
           <textarea placeholder="响应体在这里显示" readonly="readonly" cols="120" rows="10">
  <%
	  String[][] headers=(String[][]) request.getAttribute("headers");
	  if(headers!=null){
		  for(int i=0;headers[i][0]!=null;i++){
			  for(int j=0;headers[i][j]!=null;j++){
				  out.write(headers[i][j]);
				  out.write("\n");
			  }
			  out.write("*******************************************");
			  out.write("\n");
		  }
	  }
  %>
    </textarea>
					</div>
				<div margin:0 auto width:300px id="context" style="display: none">
           <textarea placeholder="Jsoup数据解析" readonly="readonly" cols="120" rows="10">
  <%
	  String[] title =(String[])request.getAttribute("title") ;
	  String[] context=(String[])request.getAttribute("context");
	  if (title!=null){
		  for (int i = 0; title[i]!=null; i++) {
			  out.write("title为："+title[i]);
			  out.write("\n");
		  }
	  }
	  if(context!=null){
		  for (int j = 0; context[j]!=null ; j++) {
				  out.write(context[j]);
				  out.write("\n");


		  }
	  }
  %>
    </textarea>
				</div>
			    </div>
			<script>
                function showbody() {
                    document.getElementById("body").style.display = "block"
                    document.getElementById("header").style.display = "none"
                    document.getElementById("context").style.display = "none"
                }
                function showhead() {
                    document.getElementById("header").style.display = "block"
                    document.getElementById("body").style.display = "none"
                    document.getElementById("context").style.display = "none"
                }
                function showcontext() {
                    document.getElementById("header").style.display = "none"
                    document.getElementById("body").style.display = "none"
                    document.getElementById("context").style.display = "block"
                }
			</script>

			<!-- 文本框 -->
		</div>
		</div>
	<!-- 测试能否获取浏览器上输入的值 -->
	<script>
       var clipboard = new Clipboard('.btn_copy');
       clipboard.on('success', function(e) {
	   var msg = e.trigger.getAttribute('aria-label');
	   alert(msg);
       console.info('Action:', e.action);
       console.info('Text:', e.text);
       console.info('Trigger:', e.trigger);
       e.clearSelection();
       });
    </script>
</body>
</html>