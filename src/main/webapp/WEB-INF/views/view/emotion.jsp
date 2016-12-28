<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<jsp:include page="../public/base.jsp"/>
<div class="bg-content">       
  <!--  content  -->      
   <div id="content"><div class="ic"></div>
    <div class="container">
          <div class="row">
        <article class="span8">
         <div class="inner-1">         
          <ul class="list-blog">
            <li>  
            <h3>Morbi ullamcorper leo eget varius elementum</h3>     
            <time datetime="2012-11-09" class="date-1"><i class="icon-calendar icon-white"></i> 9.11.2012</time>
            <div class="name-author"><i class="icon-user icon-white"></i> <a href="#">Admin</a></div>
            <a href="#" class="comments"><i class="icon-comment icon-white"></i> 11 comments</a> 
            <div class="clear"></div>            
              <img alt="" src="img/blog-1.jpg">                               
              <p>Morbi ullamcorper, leo eget varius elementum, orci leo feugiat lectus, vitae lobortis mauris velit tempor erat. Etiam eget orci at massa pretium fringilla ac non tortor. Fusce sed velit risus, vitae vehicula quam. Cras at turpis urna, eget volutpat neque. Nullam porttitor, est interdum placerat pharetra, erat sapien aliquet urna, at commodo risus tellus eu nunc.</p>
              <a href="#" class="btn btn-1">Read More</a>
            </li>  
                        
            <li>  
            <h3>Duis autem vel eum iriure dolor</h3>     
            <time datetime="2012-11-08" class="date-1">8.11.2012</time>
            <div class="name-author">by <a href="#">Admin</a></div>
            <a href="#" class="comments">9 comments</a> 
            <div class="clear"></div>            
              <img alt="" src="img/blog-2.jpg">                               
              <p>Morbi ullamcorper, leo eget varius elementum, orci leo feugiat lectus, vitae lobortis mauris velit tempor erat. Etiam eget orci at massa pretium fringilla ac non tortor. Fusce sed velit risus, vitae vehicula quam. Cras at turpis urna, eget volutpat neque. Nullam porttitor, est interdum placerat pharetra, erat sapien aliquet urna, at commodo risus tellus eu nunc.</p>
              <a href="#" class="btn btn-1">Read More</a>          
            </li> 
            
            <li>  
            <h3>Nullam porttitor est interdum placerat pharetra</h3>     
            <time datetime="2012-11-09" class="date-1"><i class="icon-calendar icon-white"></i> 9.11.2012</time>
            <div class="name-author"><i class="icon-user icon-white"></i> <a href="#">Admin</a></div>
            <a href="#" class="comments"><i class="icon-comment icon-white"></i> 11 comments</a> 
            <div class="clear"></div>            
              <img alt="" src="img/blog-3.jpg">                               
              <p>Morbi ullamcorper, leo eget varius elementum, orci leo feugiat lectus, vitae lobortis mauris velit tempor erat. Etiam eget orci at massa pretium fringilla ac non tortor. Fusce sed velit risus, vitae vehicula quam. Cras at turpis urna, eget volutpat neque. Nullam porttitor, est interdum placerat pharetra, erat sapien aliquet urna, at commodo risus tellus eu nunc.</p>
              <a href="#" class="btn btn-1">Read More</a>          
            </li>
              <c:forEach items="${forum}" varStatus="i" var="item" >
              <li>
                  <h2 > ${item.title}</h2> ----- <h3> ${item.addTime}</h3>
                  <a href="${item.id}.tie" class="btn btn-1">Read This</a>
              </li>
              </c:forEach>
          </ul>

          </div>

        </article>
              <article class="span4">
          <h3 class="extra">Search</h3>
          <form id="search" action="" method="GET" accept-charset="utf-8" >
            <div class="clearfix">
              <input type="text" name="s" onBlur="if(this.value=='') this.value=''" onFocus="if(this.value =='' ) this.value=''" >
              <a href="#" onClick="document.getElementById('search').submit()" class="btn btn-1">Search</a> </div>
          </form>
          <h3>热门精选</h3>
          <ul class="list extra extra1">
            <li><a href="#">Vonsequat</a></li>
            <li><a href="#">Utdminim veniam</a></li>
            <li><a href="#">Qullamcorper</a></li>
            <li><a href="#">Suscipitlobortis</a></li>
            <li><a href="#">Comnsequat</a></li>
            <li><a href="#">Duendrerit</a></li>
            <li><a href="#">Facilisis</a></li>
            <li><a href="#">Luptatum</a></li>
            <li><a href="#">Qui blandit</a></li>                     
      </ul>
          <h3>时间轴</h3>
         <div class="wrapper">
          <ul class="list extra2 list-pad ">
            <li><a href="#">May 2016</a></li>
            <li><a href="#">April 2016</a></li>
            <li><a href="#">March 2016</a></li>
            <li><a href="#">February 2016</a></li>
            <li><a href="#">January 2016</a></li>
            <li><a href="#">December 2016</a></li>
          </ul>
            <ul class="list extra2">
            <li><a href="#">November 2016</a></li>
            <li><a href="#">October 2016</a></li>
            <li><a href="#">September 2016</a></li>
            <li><a href="#">August 2016</a></li>
            <li><a href="#">July 2016</a></li>
            <li><a href="#">June 2016</a></li>
          </ul>
          
          </div>
        </article>
      </div>
     </div>
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
