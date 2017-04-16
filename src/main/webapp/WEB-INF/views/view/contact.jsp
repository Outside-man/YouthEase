<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<jsp:include page="../public/base.jsp"/>
<div class="bg-content">
    <script type="text/javascript">
        function ajaxx(){
            $.ajax({

                data:{
                    "name":$("#name").val(),
                    "phone":$("#phone").val(),
                    "email":$("#email").val(),
                    "content":$("#contents").val()
                },
                type:"GET",
                dataType: 'json',
                url:"contact",
                error:function(data){
                    alert("出错了！！:"+data.infos);
                },
                success:function(data){
                    alert("success:"+data.infos);
                }
            });
        }
    </script>
    <!-- content -->
      <div id="content"><div class="ic"></div>
    <div class="container">
          <div class="row">
        <article class="span8">
              <h3>Contact us</h3>
              <div class="inner-1">
            <form id="contact-form" action="contact">
                  <div class="success"> Your message has been sent succesfuly!<strong> We will be in touch soon.</strong> </div>
                  <fieldset>
                <div>
                    <label class="name">
                    <input type="text" id ="name" name="name" value="Your name">
                  <br>
                    <span class="error">*This is not a valid name.</span> <span class="empty">*This field is required.</span> </label>
                    </div>
                  <div>
                    <label class="phone">
                    <input type="tel" id ="phone" name="phone" value="Telephone">
                    <br>
                    <span class="error">*This is not a valid phone number.</span> <span class="empty">*This field is required.</span> </label>
                    </div>
                <div>
                    <label class="email">
                    <input type="email"  id ="email" name = "email" value="Email">
                    <br>
                    <span class="error">*This is not a valid email address.</span> <span class="empty">*This field is required.</span> </label>
                    </div>
                <div>
                    <label class="message">
                    <textarea id ="contents" name="content" >Message</textarea>
                    <br>
                    <span class="error">*The message is too short.</span> <span class="empty">*This field is required.</span> </label>
                    </div>
                <div class="buttons-wrapper"> <a class="btn btn-1" data-type="reset">Clear</a>         <button type="submit"  id="button_contact"
                                                                                                               class="btn btn-1">Send</button></div>
              </fieldset>
                </form>
          </div>
            </article>
        <article class="span4">
              <h3>Contact info</h3>
              <div class="map">
            <a href="http://dribbble.com/shots/624850-Presentaion-image-1" target="_blank"><img src="img/map.jpg" alt="Location on Map" /></a>
          </div>
              <address class="address-1">
          <strong>Inbetwin Networks,<br>
              Paud Phata, Road,<br>
              Kothrud, Pune-38.</strong>
          <div class="overflow"> <span>Mobile:</span>+91 12345 67890<br>
                <span>Telephone:</span>+91 12345 67890<br>
                <span>FAX:</span>+91 12345 67890 <br>
                <span>E-mail:</span> <a href="#" class="mail-1">you@domain.com</a><br>
                <span>Skype:</span> <a href="#" class="mail-1">@woohooo</a></div>
          </address>
            </article>
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
