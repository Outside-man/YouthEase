<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<jsp:include page="../public/base.jsp"/>
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
      <script type="text/javascript">

          function passwords(){
              var pas1,pas2;

              pas1=document.getElementById("password").value;
              pas2=document.getElementById("repassword").value;
              if(pas1.length<6){
                  $("#pass-result").html("密码长度小于6位");
                  $("#pass-result").css("color","red");
                  $("#submit_btn").attr("disabled", true);
                  return;
              }
              if(!(pas1==pas2 && pas2!='')){
                  $("#pass-result").html("重复密码不匹配");
                  $("#pass-result").css("color","red");
                  $("#submit_btn").attr("disabled", true);
                  return;
              }else{
                  $("#pass-result").html("有效的密码");
                  $("#pass-result").css("color","green");
                  $("#submit_btn").attr("disabled", false);
              }
          }
          function check(){
              var e=$("#email").val();
              $.ajax({
                  url:'http://localhost:8080/YouthEase/user/checking',
                  type:'post',
                  data: "email=" + e,
                  dataType: "json",
                  success:function(data){
                      var obj = data;
                      var myData=[];       //定义一个数组变量
                      $.each(obj,function(key,value){
                          myData.push(value);
                      });
                      if(myData[2]==1){
                          $("#show-result").css("color","red");
                          $("#submit_btn").attr("disabled", true);

                      }else{
                          $("#show-result").css("color","green");
                          $("#submit_btn").attr("disabled", false);
                      }
                      $("#show-result").html(myData[1]);

                  },
                  error:function(data){
                      alert("删除失败");
                  }
              })
          }
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
          <div class="form-group" id="email-container">
              <label id="show-result"  class="t"></label>
            <label id="email-title" for="email" class="t">邮　箱：</label>

            <input id="email" value="" name="email" type="text"  onblur="check()" class="form-control x319 in" autocomplete="off">
          </div>
          <div class="form-group">
              <label id="pass-result"  class="t"></label>
            <label for="password" class="t">密　码：</label>
            <input id="password" value=""  onkeypress="passwords()"  onblur="passwords()" name="passwordHash" type="password"
            class="password form-control x319 in"/>
          </div>
          <div class="form-group">
            <label for="repassword" class="t">确认密码：</label>
            <input id="repassword" value="" onkeypress="passwords()" onblur="passwords()" name="repassword" type="password"
            class="password form-control x319 in"/>
          </div>
          <div class="form-group">
            <label for="j_captcha" class="t">验证码：</label>
             <input id="j_captcha" name="j_captcha" type="text" class="form-control x164 in">
            <img id="captcha_img" alt="点击更换" title="点击更换" src="img/captcha.jpeg" class="m">
          </div>
          <div class="form-group space">
            <label class="t"></label>　　　
            <button type="submit"  id="submit_btn"
            class="btn btn-primary btn-lg" disabled="true" >&nbsp;注&nbsp;册&nbsp; </button>
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
