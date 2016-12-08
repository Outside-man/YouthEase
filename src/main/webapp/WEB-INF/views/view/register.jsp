<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>College Art | 注册</title>
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

<style type="text/css">
.form-group {margin-bottom: 20px;}
.form-group.space {padding-top: 15px; border-top: 1px #FFF dotted;}
.form-group img {margin-top: 1px; height: 32px; vertical-align: top;}
.m {cursor: pointer;}
</style>





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
   <div class="spinner"></div> 
<!-- header start -->
<header>
      <div class="container clearfix">
    <div class="row">
          <div class="span12">
        <div class="navbar navbar_">
              <div class="container">
            <h1 class="brand brand_"><a href="index.html"><img alt="" src="img/logo.png"> </a></h1>
            <a class="btn btn-navbar btn-navbar_" data-toggle="collapse" data-target=".nav-collapse_">Menu <span class="icon-bar"></span> </a>
            <div class="nav-collapse nav-collapse_  collapse">
                  <ul class="nav sf-menu">
                <li class="active"><a href="index.jsp">首页</a></li>
                <li class="sub-menu"><a href="login.jsp">帖子汇总&nbsp;</a>
                      <ul>
                    <li><a href="emotion.jsp">感情帖</a></li>
                <li><a href="trade.jsp">交易帖</a></li>
                <li><a href="mix.jsp">杂&nbsp;帖</a></li>
                  </ul>
                    </li>
                <li><a href="work.jsp">作品栈</a></li>
                <li><a href="contact.jsp">联系我们</a></li>
                <li><h3><a href="locate.jsp">杭州</a></h3></li>
              </ul>
                </div>
          </div>
            </div>
      </div>
        </div>
  </div>
    </header>
<div class="bg-content">
  
      
      <!-- content -->
      
     
  

    
        <div class="container">
          <div class="main_box">
    <div class="login_box">
      <div class="login_logo">
      <h3>注 册</h3>
      <a href="login.jsp">already have an account？click here</a>
      </div>
    
      <div class="login_form">
        <form action="user/register" id="login_form" method="post">
          <div class="form-group">
            <label for="email" class="t">邮　箱：</label>
            <input id="email" value="" name="email" type="text" class="form-control x319 in"
            autocomplete="off">
          </div>
          <div class="form-group">
            <label for="password" class="t">密　码：</label>
            <input id="password" value="" name="PasswordHash" type="password"
            class="password form-control x319 in">
          </div>
          <div class="form-group">
            <label for="repassword" class="t">确认密码：</label>
            <input id="repassword" value="" name="repassword" type="password"
            class="password form-control x319 in">
          </div>
          <div class="form-group">
            <label for="j_captcha" class="t">验证码：</label>
             <input id="j_captcha" name="j_captcha" type="text" class="form-control x164 in">
            <img id="captcha_img" alt="点击更换" title="点击更换" src="img/captcha.jpeg" class="m">
          </div>
         
          <div class="form-group space">
            <label class="t"></label>　　　
            <button type="submit"  id="submit_btn"
            class="btn btn-primary btn-lg">&nbsp;注&nbsp;册&nbsp; </button>
            <input type="reset" value="&nbsp;重&nbsp;置&nbsp;" class="btn btn-default btn-lg">
          </div>
        </form>
      </div>
    </div>
    
  </div>
      </div>
       

   
  
    </div>

  
<!-- footer -->
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
