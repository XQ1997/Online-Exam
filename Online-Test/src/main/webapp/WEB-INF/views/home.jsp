 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>《数据库原理与应用》考试系统--主页</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<%@ include file="include/css.jsp" %>
    <style type="text/css">
        body {
            font-family: Roboto, "Microsoft YaHei";
         .my-opacity{
        	opacity:0.6;
        }
        .my-opacity:hover{
        	opacity:1;
        }
        a{
			color: #2e7d32;
		}
    </style>
</head>
<body>
	<jsp:include page="include/header.jsp"></jsp:include>
	<div id="main">
	    <div class="container" style="padding: 20px;">
	    	<div class="divider" style="height:20px;background:#fff;"></div>
	        <div class="row">
	        
		        <div class="col s12 m4">
		            <div class="card">
		                <div class="card-image waves-effect waves-block waves-light my-opacity" >
		                    <a href="<%--<s:url action="studentexamlist"/>--%>"><img class="activator" src="/static/project/images/exampaper2.jpg"></a>
		                </div>
		                <div class="card-content">
		                    <a href="<%--<s:url action="studentexamlist"/>--%>">
		                    <span class="card-title activator light-green-text text-darken-4">试题列表
		                    <i class="fas fa-sign-in-alt fa-lg right light-green-text"></i></span></a>
		                    <p><a href="<%--<s:url action="studentexamlist"/>--%>">列出所有已有的试题列表</a></p>
		                </div>
		            </div>
	        	</div>
	        	
		        <div class="col s12 m4">
		            <div class="card">
		                <div class="card-image waves-effect waves-block waves-light my-opacity">
		                    <a href="questionByKnowledge.jsp"><img class="activator" src="/static/project/images/categories2.jpg"></a>
		                </div>
		                <div class="card-content">
		                	<a href="questionByKnowledge.jsp">
		                    <span class="card-title activator light-green-text text-darken-4">章节练习
		                    <i class="fas fa-sign-in-alt fa-lg right light-green-text"></i></span></a>
		                    <p><a href="questionByKnowledge.jsp">按照章节知识点分类进行练习</a></p>
		                </div>
		            </div>
	        	</div>
	        	
	        	<%--<s:if test="#session['USER_INFO']!=null && #session['USER_INFO'].role==1">--%>
	        	<div class="col s12 m4">
		            <div class="card">
		                <div class="card-image waves-effect waves-block waves-light my-opacity">
		                    <a href="questionTypes.jsp"><img class="activator" src="/static/project/images/questiontype2.jpg"></a>
		                </div>
		                <div class="card-content">
		                	<a href="questionTypes.jsp">
		                    <span class="card-title activator light-green-text text-darken-4">题型练习
		                    <i class="fas fa-sign-in-alt fa-lg right light-green-text"></i></span></a>
		                    <p><a href="questionTypes.jsp">按选择题、填空题、判断题分别练习</a></p>
		                </div>
		            </div>
	        	</div>
	        	<%--</s:if>--%>
	        	
	        	<%--<s:if test="#session['USER_INFO']!=null && #session['USER_INFO'].role==1">--%>
		        <div class="col s12 m4">
		            <div class="card">
		                <div class="card-image waves-effect waves-block waves-light my-opacity">
		                    <a href="examComposeTypes.jsp"><img class="activator" src="/static/project/images/papergenerator2.jpg"></a>
		                </div>
		                <div class="card-content">
		                	<a href="examComposeTypes.jsp">
		                    <span class="card-title activator light-green-text text-darken-4">抽题组卷
		                    <i class="fas fa-sign-in-alt fa-lg right light-green-text"></i></span></a>
		                    <p><a href="examComposeTypes.jsp">从题库中根据策略抽题组卷</a></p>
		                </div>
		            </div>
	        	</div>
	        	<%--</s:if>--%>

				<%--<s:if test="#session['USER_INFO']!=null && #session['USER_INFO'].role==1">--%>
		        <div class="col s12 m4">
		            <div class="card">
		                <div class="card-image waves-effect waves-block waves-light my-opacity">
		                    <a href="importData.jsp"><img class="activator" src="/static/project/images/importexport2.jpg"></a>
		                </div>
		                <div class="card-content">
		                	<a href="importData.jsp">
		                    <span class="card-title activator light-green-text text-darken-4">导入导出
		                    <i class="fas fa-sign-in-alt fa-lg right light-green-text"></i></span></a>
		                    <p><a href="importData.jsp">用户、试题等数据的导入导出</a></p>
		                </div>
		            </div>
	        	</div>
	        	<%--</s:if>--%>
	        	
	        	<%--<s:if test="#session['USER_INFO']!=null && #session['USER_INFO'].role==1">--%>
		        <div class="col s12 m4">
		            <div class="card">
		                <div class="card-image waves-effect waves-block waves-light my-opacity">
		                    <a href="statsTypes.jsp"><img class="activator" src="/static/project/images/datastats2.png"></a>
		                </div>
		                <div class="card-content">
		                    <a href="statsTypes.jsp">
		                    <span class="card-title activator light-green-text text-darken-4">试题分析
		                    <i class="fas fa-sign-in-alt fa-lg right light-green-text"></i></span></a>
		                    <p><a href="statsTypes.jsp">按照题型、知识点等进行统计分析</a></p>
		                </div>
		            </div>
	        	</div>
	        	<%--</s:if>--%>
	        	
	        </div>
	    </div>
	</div>
	
	<%--<s:if test="#session['USER_INFO']!=null && #session['USER_INFO'].role==1">--%>
	<a href="modifysettings" title="修改系统设置"><i class="fas fa-wrench fa-lg right blue-text"></i></a> | 
	<a href="pushbroadcastmessage" title="向在线用户推送广播消息"><i class="fas fa-share-square fa-lg right red-text"></i></a>
	<%--</s:if>--%>
	<jsp:include page="include/footer.jsp"/>
	<%@ include file="include/js.jsp" %>
	<script>
	    $(document).ready(function () {
	        $('.modal-trigger').leanModal({
	            dismissible: true, //是否点模态对话框外面就可以关闭
	            opacity: 0.6, //接近1，不透明
	        });//使用模态对话框，必须有这句
	        
	        $(".button-collapse").sideNav({
	            menuWidth: 200, // Default is 240
	            edge: 'left', // Choose the horizontal origin
	            closeOnClick: true // Closes side-nav on <a> clicks, useful for Angular/Meteor
	        });
	        
	        $(".collapsible").collapsible({
	            accordion: true
	        });
	    })
	   	
	</script>

	<%--<s:if test="hasActionErrors()">--%>
	<script type="text/javascript">
		toast1();
		function toast1(){
			var errorStr='<%--<s:property value="actionErrors[0]"/>--%>';
		    var $toastContent = $('<span class="red-text lighten-5"><h4>'+errorStr+'</h4></span>');
		    Materialize.toast($toastContent, 4000, 'rounded');
		}
	</script>
	<%--</s:if>--%>

	<%--<s:if test="hasActionMessages()">--%>
	<script type="text/javascript">
		toast2();
		function toast2(){
			var msgStr='<%--<s:property value="actionMessages[0]"/>--%>';
		    var $toastContent = $('<span class="teal-text lighten-5"><h4>'+msgStr+'</h4></span>');
		    Materialize.toast($toastContent, 4000, 'rounded');
		}
	</script>
	<%--</s:if>--%>

</body>
</html>