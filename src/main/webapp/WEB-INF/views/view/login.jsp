<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<jsp:include page="../public/base.jsp"/>
<div class="bg-content">
  
      
      <!-- content -->
      
     
  

    
        <div class="container">
          <div class="main_box">
    <div class="login_box">
      <div class="login_logo">
      <h3>登 录</h3>
      <a href="register.html">sign up to find interesting thing</a>
      </div>
    
      <div class="login_form">
        <form action="user/login" id="login_form" method="post">
          <div class="form-group">
            <label for="email" class="t">邮　箱：</label>
            <input id="email" value="" name="email" type="text" class="form-control x319 in"
            autocomplete="off">
          </div>
          <div class="form-group">
            <label for="password" class="t">密　码：</label>
            <input id="password" value="" name="passwordHash" type="password"
            class="password form-control x319 in">
          </div>
          
          <div class="form-group">
            <label for="j_captcha" class="t">验证码：</label>
             <input id="j_captcha" name="j_captcha" type="text" class="form-control x164 in">
            <img id="captcha_img" alt="点击更换" title="点击更换" src="img/captcha.jpeg" class="m">
          </div>
           <div class="form-group">
            <label class="t"></label>
            <label for="j_remember" class="m">
            <input id="j_remember" type="checkbox" value="true">&nbsp;记住登陆账号!</label>
          </div>
          <div class="form-group space">
            <label class="t"></label>　　　
            <button type="submit"  id="submit_btn"
            class="btn btn-primary btn-lg">&nbsp;登&nbsp;录&nbsp; </button>
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
