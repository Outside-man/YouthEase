<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/28
  Time: 3:22
  To change this template use File | Settings | File Templates.
--%>
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
<body>

<div class="bg-content">
    <div id="content"><div class="ic"></div>
        <div class="container">
            <div class="row">
                <article class="span8" style="float:right">
                    <div class="inner-1">
                        <ul class="list-blog">
                            <c:forEach items="${forum}"  varStatus="i" var="item" >
                            <li>
                                <c:if test="${not empty item}">
                                <h2 > ${item.title}</h2> ----- <h3> ${item.add_time}</h3>
                                <a href="${item.id}.tie" class="btn btn-1">Read This</a>
                                </c:if>
                            </li>
                             </c:forEach>
                        </ul>

                    </div>
                </article>
              </div></td>
            <td colspan="8"><div class="big">页数 <c:forEach var="i"  begin="1" end="${pages}" > </span><a href="${centerUser.id}_${i}.myforum"> ${i}</a></c:forEach>
            </div>
        </div>

    </div>
</div>
</article>
<script type="text/javascript" src="js/bootstrap.js"></script>
</body>
</body>
</html>
