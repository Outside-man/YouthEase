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
              <c:forEach items="${forum}" varStatus="i" var="item" >
                  <li>
                      <h3>${item.title}</h3>
                      <time datetime="2012-11-09" class="date-1"><i class="icon-calendar icon-white"></i> ${item.add_time}</time>
                      <div class="name-author"><i class="icon-user icon-white"></i> <a href="#">${item.username}</a></div>
                      <a href="#" class="comments"><i class="icon-comment icon-white"></i>评论数:${item.floors}</a>
                      <div class="clear"></div>
                      <img alt="" src="img/blog-3.jpg">
                      <a href="${item.id}.tie" class="btn btn-1">Read More</a>
                  </li>
              </c:forEach>
          </ul>
          </div>  
        </article>
        <article class="span4">
          <h3 class="extra">Search</h3>
          <form id="search" action="search.php" method="GET" accept-charset="utf-8" >
            <div class="clearfix">
              <input type="text" name="s" onBlur="if(this.value=='') this.value=''" onFocus="if(this.value =='' ) this.value=''" >
              <a href="#" onClick="document.getElementById('search').submit()" class="btn btn-1">Search</a> </div>
          </form>
          <h3>分类</h3>
          <ul class="list extra extra1">
            <li><a href="#">诸位up主的声音</a></li>
            <li><a href="#">原创视频</a></li>
            <li><a href="#">摄影</a></li>
            <li><a href="#">平面设计</a></li>
            <li><a href="#">coder开源项目</a></li>                   
      </ul>
          <h3>时间轴</h3>
         <div class="wrapper">
          <ul class="list extra2 list-pad ">
            <li><a href="#">May 2012</a></li>
            <li><a href="#">April 2012</a></li>
            <li><a href="#">March 2012</a></li>
            <li><a href="#">February 2012</a></li>
            <li><a href="#">January 2012</a></li>
            <li><a href="#">December 2011</a></li>
          </ul>
            <ul class="list extra2">
            <li><a href="#">November 2012</a></li>
            <li><a href="#">October 2012</a></li>
            <li><a href="#">September 2012</a></li>
            <li><a href="#">August 2012</a></li>
            <li><a href="#">July 2012</a></li>
            <li><a href="#">June 2012</a></li>
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
