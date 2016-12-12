<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/8
  Time: 22:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title>Codester | 404 Page not found</title>
    <meta charset="utf-8">
    <link rel="icon" href="http://dzyngiri.com/favicon.png" type="image/x-icon">
    <link rel="shortcut icon" href="http://dzyngiri.com/favicon.png" type="image/x-icon" />
    <meta name="description" content="Codester is a free responsive Bootstrap template by Dzyngiri">
    <meta name="keywords" content="free, template, bootstrap, responsive">
    <meta name="author" content="Inbetwin Networks">
    <link rel="stylesheet" href="css/bootstrap.css" type="text/css" media="screen">
    <link rel="stylesheet" href="css/responsive.css" type="text/css" media="screen">
    <link rel="stylesheet" href="css/style.css" type="text/css" media="screen">
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300' rel='stylesheet' type='text/css'>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/superfish.js"></script>
    <script type="text/javascript" src="js/jquery.easing.1.3.js"></script>
    <script type="text/javascript" src="js/jquery.cookie.js"></script>
    <script>
        jQuery(window).load(function() {
            jQuery('.spinner').animate({'opacity':0},1000,'easeOutCubic',function (){jQuery(this).css('display','none')});
        });
    </script>

    <!--[if lt IE 8]>
    <div style='text-align:center'><a href="http://www.microsoft.com/windows/internet-explorer/default.aspx?ocid=ie6_countdown_bannercode"><img src="http://www.theie6countdown.com/img/upgrade.jpg"border="0"alt=""/></a></div>
    <![endif]-->
    <!--[if (gt IE 9)|!(IE)]><!-->
    <!--<![endif]-->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <link rel="stylesheet" href="css/docs.css" type="text/css" media="screen">
    <link rel="stylesheet" href="css/ie.css" type="text/css" media="screen">
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:300' rel='stylesheet' type='text/css'>
    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400' rel='stylesheet' type='text/css'>

    <![endif]-->
</head>

<body>
<div class="spinner"></div>
<!--  header  -->
<header>
    <div class="container clearfix" id=“top”>
        <div class="row">
            <div class="span12">
                <div class="navbar navbar_">
                    <div class="container">
                        <h1 class="brand brand_"><a href="index.jsp"><img alt="" src="img/logo.png"> </a></h1>
                        <a class="btn btn-navbar btn-navbar_" data-toggle="collapse" data-target=".nav-collapse_">Menu <span class="icon-bar"></span> </a>
                        <div class="nav-collapse nav-collapse_  collapse">
                            <ul class="nav sf-menu">
                                <li class="active"><a href="index.html">首页</a></li>
                                <li class="sub-menu"><a href="#">帖子汇总&nbsp;</a>
                                    <ul>
                                        <li><a href="emotion.html">感情帖</a></li>
                                        <li><a href="trade.html">交易帖</a></li>
                                        <li><a href="redirect/mix">杂&nbsp;帖</a></li>
                                    </ul>
                                </li>
                                <li><a href="work.jsp">作品栈</a></li>
                                <% if(request.getSession().getAttribute("user")==null) {

                                %>
                                <li class="sub-menu"><a href="redirect/login">登&nbsp;录</a>
                                    <ul>


                                        <li><a href="register.html">注册</a></li> </ul>
                                        <%}else{%>
                                <li><a href="user/logout">登出</a></li>
                                <%}%>

                                </li>
                                <li><a href="redirect/contact">联系我们</a></li>
                                <li><h3><a href="redirect/locate">杭州</a></h3></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</header>
<div class="bg-content">

    <!--  content  -->

    <div id="content">
        <div class="container">
            <div class="row ">
                <div class="span12">

                       <h2> ${forum.title} --- <h3> ${forum.additionStatus}</h3> </h2>
                        <h4>${forum.content}</h4>

                </div>
            </div>
        </div>
        <article class="span8">
            <div class="inner-1">
                <form id="postforum" action="post_forum" method="GET" accept-charset="utf-8" >
                    <ul class="list-blog">
                        <li>
                            <div class="clearfix">
                                <h3>标题</h3>
                                <input type="text" name="title" onBlur="if(this.value=='') this.value=''" onFocus="if(this.value =='' ) this.value=''" style="width: 100%;" ></div>
                            <div class="clear"></div>
                            <div style="float: right;position: relative;top:18px;">
                                <time datetime="2012-11-09" class="date-1"><i class="icon-calendar icon-white"></i> 9.11.2012</time>
                                <div class="name-author"><i class="icon-user icon-white"></i> <a href="#">Admin</a></div>
                            </div>
                            <h3>内容</h3>
                            <textarea type="text" name="content" rows="20" style="width: 100%;"
                            >
              </textarea>
                            <button type="submit"  id="submit_btn"
                                    class="btn btn-primary btn-lg" style="float: right;">&nbsp;回&nbsp;贴&nbsp; </button>
                        </li>
                    </ul>
                </form>
            </div>
        </article>
    </div>

</div>
<!--  footer  -->
<footer>
    <div class="container clearfix">
        <ul class="list-social pull-right">
            <li><a class="icon-1" href="#"></a></li>
            <li><a class="icon-2" href="#"></a></li>
            <li><a class="icon-3" href="#"></a></li>
            <li><a class="icon-4" href="#"></a></li>
        </ul>
        <div class="privacy pull-left">&copy; Copyright &copy; 2016.College Art  All rights reserved.<a target="_blank" href="http://sc.chinaz.com/moban/"></a></div>
    </div>
</footer>
<script type="text/javascript" src="js/bootstrap.js"></script>
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>