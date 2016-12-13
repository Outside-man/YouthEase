<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

      <div id="content"><div class="ic"></div>
    <div class="container">
          <div class="row">
        <article class="span12">
              <h4>Services</h4>
            </article>
        <div class="clear"></div>
        <ul class="thumbnails thumbnails-1 list-services">
            <li class="span4">
            <div class="thumbnail thumbnail-1"> <img  src="${iconUrl}" alt="">
                <c:if test="${user.id==centerUser.id}">
                <section> <a href="#" class="link-1"></a>
                      <form id=${user.id} action="uploads/userIcon" method="post" enctype="multipart/form-data">
                          照片：<input type="file" name="icon"/>
                          <button type="submit"  id="submit_btn"
                                  class="btn btn-primary btn-lg">&nbsp;上&nbsp;传&nbsp; </button>
                      </form>
                </section>
                </c:if>
                </div>
          </li>

            </ul>
      </div>
        </div>
  </div>
    </div>

<!--============================== footer =================================-->
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
