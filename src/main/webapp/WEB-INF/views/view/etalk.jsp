
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://zlzkj.com/tags" prefix="z" %>
    <html>
    <head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta name="description" content="Codester is a free responsive Bootstrap template by Dzyngiri">
    <meta name="keywords" content="free, template, bootstrap, responsive">
    <meta name="author" content="Inbetwin Networks">
    <link rel="stylesheet" href="css/bootstrap.css" type="text/css" media="screen">
    <link rel="stylesheet" href="css/responsive.css" type="text/css" media="screen">
    <link rel="stylesheet" href="css/style.css" type="text/css" media="screen">
    <link rel="stylesheet" href="css/touchTouch.css" type="text/css" media="screen">
    <link rel="stylesheet" href="css/kwicks-slider.css" type="text/css" media="screen">
    <!--[if lt IE 8]>
<![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<!--<![endif]-->
<!--[if lt IE 9]>

<![endif]-->
</head>
    <script>
        <c:if test="${not empty target}">
        setTimeout('run()',5000);
        </c:if>
 //方法执行
    function run() {
            location.reload();
    }
    </script>
    <body class="bg-content">

<div class="bg-content">

    <div id="content"><div class="ic">

    </div>
    <div class="container">
    <div class="row">
    <div class="inner-1" style="overflow:auto">
        <c:if test="${not empty messages}">
            <c:forEach items="${messages}"  varStatus="i" var="item" >
                <c:if test="${user.id==item.sourceId}">
            <ul class="list-blog">
                <div class="container">
                <li>
                        <img src="${iconUrl}" width="64" height="64"/>${item.content}
                </li>
                </div >
                </c:if>
                <c:if test="${user.id!=item.sourceId}">
                    <div class="container">
                        <li class="nav pull-right">

                                    ${item.content}  <img src="${targetIcon}" width="64" height="64"/>
                        </li>
                    </div>
                </c:if>
            </c:forEach>
            </ul>
        </c:if>

</div>
</div>
</div>
</div>

</div>
</div>
</article>
<div class="line-big" style="">

</div>
<script type="text/javascript" src="js/bootstrap.js"></script>
    </body>
    </body>
    </html>