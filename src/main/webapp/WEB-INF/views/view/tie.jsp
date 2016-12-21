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
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<jsp:include page="../public/base.jsp"/>
<div class="bg-content">

    <!--  content  -->

    <div id="content">
        <div class="container">
            <div class="row ">
                <div class="span12">

                       <h2> ${forum.title} --- <h3> ${masteruser.nuserName}</h3> </h2>
                    <a href="self_center_p/${masteruser.id}" class="btn btn-group-sm">${masteruser.nuserName}</a>
                        <h4>${forum.content}</h4>
                </div >
                <div class="span10">
                <ul>
                <c:forEach items="${list}" varStatus="i" var="item" >
                    <ul>
                <li>
                    <div class=row">
                    <article class="span8">
                    <h5 > ${item.comment.content} </h5>
                    <a href="self_center_p/${item.comment.userId}" class="btn btn-1">${item.username}</a>
                    </article>
                    <h5 >---------------${item.comment.floor}-层</h5>
                        <img src="${item.iconUrl}" width="100" height="100"/>
                    </div>
                </li>
                    </ul>
                </c:forEach>
                </ul>
                </div>

            <div class="row">
            <article class="span8">
                <div class="inner-1">
                    <form id="post_comment" action="post_comment" method="post" accept-charset="utf-8" >
                        <ul class="list-blog">
                            <li>
                                <div class="clearfix">
                                <div class="clear"></div>
                                <div style="float: right;position: relative;top:18px;">
                                    <time datetime="2012-11-09" class="date-1"><i class="icon-calendar icon-white"></i> 9.11.2012</time>
                                    <div class="name-author"><i class="icon-user icon-white"></i> <a href="self_center.html">${user.nuserName}</a></div>
                                </div>
                                <h3>内容</h3>
                                <textarea type="text" name="content" rows="20" style="width: 100%;">
                                </textarea>
                                    <input type="hidden" name="forumId" value="${forum.id}"/>
                                    <input type="hidden" name="userId" value="${user.id}"/>
                                    <input type="hidden" name="floor" value="${fn:length(list)}"/>
                                <button type="submit"  id="submit_btn" class="btn btn-primary btn-lg" style="float: right;">&nbsp;回&nbsp;贴&nbsp; </button>
                                </div>
                            </li>
                        </ul>
                    </form>
                </div>

            </article>
            </div>
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