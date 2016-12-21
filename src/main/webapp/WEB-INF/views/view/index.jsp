<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://zlzkj.com/tags" prefix="z" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
<jsp:include page="../public/base.jsp"/>
<div class="bg-content">
     <div class="container" id="container" >
    <div class="row">
          <div class="span12"> 
        <!-- slider -->
        <div class="flexslider">
              <ul class="slides">
            <li> <img src="img/slide-1.jpg" alt="" > </li>
            <li> <img src="img/slide-2.jpg" alt="" > </li>
            <li> <img src="img/slide-3.jpg" alt="" > </li>
            <li> <img src="img/slide-4.jpg" alt="" > </li>
            <li> <img src="img/slide-5.jpg" alt="" > </li>
          </ul>
            </div>
        <span id="responsiveFlag"></span>
        <div class="block-slogan">
              <h2>Trade!</h2>
              <div>
            <p>新一代大学生论坛，专为大学生打造的信息发布平台，发帖的同时让更多人知道你的作品、经历、心情以及进行各种交易，娱乐交友两不误。快来发帖交易吧！</p>
            <p style="text-align:center; padding-top:20px;"><a href="post.html" class="btn btn-1">我要发帖</a></p>
          </div>
            </div>
      </div>
        </div>
  </div>
      
      <!-- content -->
      
      <div id="content" class="content-extra"><div class="ic"></div>
    <div class="row-1">
        <div class="container">
        <div class="row">
        <article class="span12">
        <h4>帖子精选</h4>
         </article>
              <ul class="thumbnails thumbnails-1">
            <li class="span3">
                  <div class="thumbnail thumbnail-1">
                <h3>焚烧坏情绪</h3>
                <img  src="img/blog-featured-01.jpg" alt="">
                <section> 
                    <a href="#"><h3>At vero eos et accusamus et iusto </h3></a>
                      <div class="meta">
                            <time datetime="2012-11-09" class="date-1"><i class="icon-calendar"></i> 9.11.2012</time>
                            <div class="name-author"><i class="icon-user"></i> <a href="#">Admin</a></div>
                            <a href="#" class="comments"><i class="icon-comment"></i> 7 comments</a>
                        </div> 
                        <div class="clear"></div>
                      <p>Vivamus sollicitudin libero auctor arcu pulvinar commodo.</p>
                      <a href="#" class="btn btn-1">Read More</a> </section>
              </div>
                </li>
            <li class="span3">
                  <div class="thumbnail thumbnail-1">
                <h3>平面设计</h3>
                <img  src="img/blog-featured-02.jpg" alt="">
                <section> 
                    <a href="#"><h3>Deleniti atque corrupti quos</h3></a>
                        <div class="meta">
                            <time datetime="2012-11-09" class="date-1"><i class="icon-calendar"></i> 9.11.2012</time>
                            <div class="name-author"><i class="icon-user"></i> <a href="#">Admin</a></div>
                            <a href="#" class="comments"><i class="icon-comment"></i> 4 comments</a>
                        </div>
                        <div class="clear"></div>            
                      <p>Vestibulum volutpat urna sed sapien vehicula varius.</p>
                      <a href="#" class="btn btn-1">Read More</a> </section>
              </div>
                </li>
            <li class="span3">
                  <div class="thumbnail thumbnail-1">
                <h3>摄影</h3>
                <img  src="img/blog-featured-03.jpg" alt="">
                <section>
                    <a href="#"><h3>Similique sunt in culpa qui officia</h3></a>
                        <div class="meta">
                            <time datetime="2012-11-09" class="date-1"><i class="icon-calendar"></i> 9.11.2012</time>
                            <div class="name-author"><i class="icon-user"></i> <a href="#">Admin</a></div>
                            <a href="#" class="comments"><i class="icon-comment"></i> 9 comments</a>
                        </div>
                        <div class="clear"></div>   
                      <p>Pellentesque mi justo, laoreet non bibendum non, auctor imperdiet eros.</p>
                      <a href="#" class="btn btn-1">Read More</a> </section>
              </div>
                </li>
            <li class="span3">
                  <div class="thumbnail thumbnail-1">
                <h3 class="title-1 extra">后期</h3>
                <img  src="img/blog-featured-04.jpg" alt="">
                <section> <a href="#"><h3>Similique sunt in culpa qui officia</h3></a>
                    <div class="meta">
                            <time datetime="2012-11-09" class="date-1"><i class="icon-calendar"></i> 9.11.2012</time>
                            <div class="name-author"><i class="icon-user"></i> <a href="#">Admin</a></div>
                            <a href="#" class="comments"><i class="icon-comment"></i> 1 comment</a>
                        </div> 
                        <div class="clear"></div>   
                      <p>Vestibulum volutpat urna sed sapien vehicula varius.</p>
                      <a href="#" class="btn btn-1">Read More</a> </section>
              </div>
                </li>
          </ul>
            </div>
      </div>
        </div>
    <div class="row-2">
        <div class="container">
        	<h3>部分慷慨的人士捐献的开源作品</h3>
            <h3>容易使用，免费下载，有爱的！</h3>
            <p>这个平台是完全提供给新手借鉴学习的。</p>
            <a href="work.jsp" class="btn btn-1">进入下载</a>
      </div>
        </div>
    
    
    <div class="container">
          <div class="row">
        <article class="span6">
              <h3>关于我们</h3>
              <div class="wrapper">
            <figure class="img-indent"><img src="img/15.jpg " alt="" /></figure>
            <div class="inner-1 overflow extra">
                  <div class="txt-1">平台提供者，杭州电子科学大学信息工程学院三人组</div>
                  你可以非常方便地找到我们，联系我们<a href="#">xingong@163.com</a>
                </div>
          </div>
            </article>
        <article class="span6">
              <h3>站外链接</h3>
                <div class="wrapper">
                    <ul class="list list-pad">
                          <li><a href="#">Campaigns</a></li>
                          <li><a href="#">Portraits</a></li>
                          <li><a href="#">Fashion</a></li>
                          <li><a href="#">Fine Art</a></li>
                        </ul>
                    <ul class="list list-pad">
                          <li><a href="#">Campaigns</a></li>
                          <li><a href="#">Portraits</a></li>
                          <li><a href="#">Fashion</a></li>
                          <li><a href="#">Fine Art</a></li>
                        </ul>
                    <ul class="list">
                          <li><a href="#">Advertising</a></li>
                          <li><a href="#">Lifestyle</a></li>
                          <li><a href="#">Love story</a></li>
                          <li><a href="#">Landscapes</a></li>
                    </ul>
                </div>
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
