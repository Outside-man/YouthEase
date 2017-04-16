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
</head>
<body class="bg-content">
<div class="bg-content">
    <div class="container"  id="e-talk">
        <div class="container">
            <div style="float:left;overflow:auto">
                <ul class="list-blog" >
                    <c:forEach items="${list}"  varStatus="i" var="item" >
                        <li>
                            <div>
                                <a href="self_center_p/${item.user.id}">${item.user.nuserName}</a>
                            </div>
                            <div>
                                <a href="etalkto/${item.user.id}.user"><img src="${item.icon}" width="100" height="100"/></a>
                            </div>
                        </li>
                    </c:forEach>
                </ul>
            </div>
<c:if test="${not empty target}">
            <iframe scrolling="auto"  rameborder="0" src="etalkto/${target}.mes" name="right" width="80%" height="100%"></iframe>
            </c:if>
            <div class="row">
    </div>
        </div>
        <c:if test="${not empty target}">

            <form action="message/send">
                <input type="text" name="content" onBlur="if(this.value=='') this.value=''" onFocus="if(this.value =='' ) this.value=''" style="width: 80%;" >
                <input type="hidden" name="type" value="etalk">
                <input type="hidden" name="sourceId" value="${user.id}">
                <input type="hidden" name="targetId" value="${target}">
                <button class="btn-sm" type="submit">发送</button>
            </form>
        </c:if>
    </div>


</div>
</body>
</html>
