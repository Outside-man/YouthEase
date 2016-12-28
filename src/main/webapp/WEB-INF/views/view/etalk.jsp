
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
    <body>

<div class="bg-content">

    <div id="content"><div class="ic">

    </div>
    <div class="container">
        <div style="float:left;overflow:auto">
            <ul class="list-blog">
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
    <div class="row">
    <article class="span8" style="float:right;overflow:auto" >
    <div class="inner-1" style="overflow:auto">
        <c:if test="${not empty messages}">
            <c:forEach items="${messages}"  varStatus="i" var="item" >
                <c:if test="${user.id==item.sourceId}">
                <div>
                <li>
                        <img src="${iconUrl}" width="64" height="64"/>${item.content}
                </li>
                </div>
                </c:if>
                <c:if test="${user.id!=item.sourceId}">
                    <div >
                        <li>
                          ${item.content}  <img src="${targetIcon}" width="64" height="64"/>
                        </li>
                    </div>
                </c:if>
            </c:forEach>
        </c:if>

</div>
</article>
</div>
</div>
</div>

</div>
</div>
</article>
<div class="line-big" style="">
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
<script type="text/javascript" src="js/bootstrap.js"></script>
    </body>
    </body>
    </html>