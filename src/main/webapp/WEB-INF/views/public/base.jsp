<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/13
  Time: 23:51
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
<z:block name="head">
    <head>
        <base href="<%=basePath%>">

        <title>College Art | Home</title>
        <meta charset="utf-8">
        <link rel="icon" href="http://dzyngiri.com/favicon.png" type="image/x-icon">
        <link rel="shortcut icon" href="http://dzyngiri.com/favicon.png" type="image/x-icon" />
        <meta name="description" content="Codester is a free responsive Bootstrap template by Dzyngiri">
        <meta name="keywords" content="free, template, bootstrap, responsive">
        <meta name="author" content="Inbetwin Networks">
        <link rel="stylesheet" href="css/bootstrap.css" type="text/css" media="screen">
        <link rel="stylesheet" href="css/responsive.css" type="text/css" media="screen">
        <link rel="stylesheet" href="css/style.css" type="text/css" media="screen">
        <link rel="stylesheet" href="css/touchTouch.css" type="text/css" media="screen">
        <link rel="stylesheet" href="css/kwicks-slider.css" type="text/css" media="screen">
        <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300' rel='stylesheet' type='text/css'>
        <script type="text/javascript" src="js/jquery.js"></script>
        <script type="text/javascript" src="js/superfish.js"></script>
        <script type="text/javascript" src="js/jquery.flexslider-min.js"></script>
        <script type="text/javascript" src="js/jquery.kwicks-1.5.1.js"></script>
        <script type="text/javascript" src="js/jquery.easing.1.3.js"></script>
        <script type="text/javascript" src="js/jquery.cookie.js"></script>
        <script type="text/javascript" src="js/touchTouch.jquery.js"></script>
        <script type="text/javascript">if($(window).width()>1024){document.write("<"+"script src='js/jquery.preloader.js'></"+"script>");} </script>



        <script>
            jQuery(window).load(function() {
                $x = $(window).width();
                if($x > 1024)
                {
                    jQuery("#content .row").preloader();    }

                jQuery('.magnifier').touchTouch();
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
    <div class="backtotop"><a href="#top"><img src="img/backToTop.png"></a></div>
    <div class="spinner"></div>

    <!-- header start -->
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
                                            <li><a href="emotion.forum">感情帖</a></li>
                                            <li><a href="trade.forum">交易帖</a></li>
                                            <li><a href="mix.forum">杂&nbsp;帖</a></li>
                                        </ul>
                                    </li>
                                    <li><a href="work.html">作品栈</a></li>
                               <c:choose>

                                    <c:when test="${empty user or logininfo=='logout'}">
                                    <li class="sub-menu"><a href="redirect/login">登&nbsp;录</a>
                                        <ul>
                                            <li><a href="register.html">注册</a></li> </ul>
                                        </c:when>
                                    <c:otherwise>
                                    <li class="sub-menu"><a href="self_center.html">${user.nuserName}</a>
                                        <ul><a href="user/logout">登出</a></ul>
                                    </c:otherwise>
                                    </c:choose>
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
    </body>
</z:block>
</html>
