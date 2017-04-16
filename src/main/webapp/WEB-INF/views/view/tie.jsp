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
<script language="javascript" type="text/javascript">
    if(top.location!=self.location)top.location=self.location;
</script>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<jsp:include page="../public/base.jsp"/>
<div class="bg-content">

    <!--  content  -->

    <div id="content">
        <div class="container">
            <div class="row ">
                <div class="span8">
                    <div class="inner-1">
                        <ul class="list-blog">
                            <li>
                                <h3>${forum.title}</h3>
                                <div class="avatar" >
                                    <div style="float:left;width:120px">
                                        <a href="self_center_p/${masteruser.id}"><img src="${masterIconUrl}" width="100" height="100"/></a>
                                        <div class="name-author"><i class="icon-user icon-white"></i>
                                            <a href="self_center_p/${masteruser.id}" >${masteruser.nuserName}</a>
                                        </div>
                                    </div>

                                    <p style="text-indent:2em;">${forum.content}</p>
                                    <c:if test="${empty forum.additionId or forum.additionId==0}">
                                        <img alt=""  src="img/blog-1.jpg"><!--图片如果有就添加-->
                                    </c:if>
                                    <c:if test="${forum.additionId==1}">
                                        <img alt="" src="${additionUrl}"><!--图片如果有就添加-->
                                    </c:if>
                                    <c:if test="${forum.additionId==2}">
                                        <video src= "${additionUrl}" controls="controls">
                                            您的浏览器不支持 video 标签。
                                        </video>
                                    </c:if>
                                </div>
                                <div class="clear"></div>

                                <div class="tail" style="float:right;">

                                    <a href="#" class="comments">${forum.addTime}&nbsp;&nbsp;|</a>
                                    <a href="#post_comment" class="comments" > 回复|</a> <!--回复帖主跳转至底部发布回复区域-->
                                </div>

                            </li>
                            <li>
                                <c:forEach items="${list}" varStatus="i" var="item" >
                                <div class="avatar" >
                                    <div style="float:left;width:120px；">
                                        <a href="self_center_p/${item.comment.userId}"><img src="${item.iconUrl}" width="100" height="100"/></a>
                                        <div class="name-author"><i class="icon-user icon-white"></i>
                                            <a href="self_center_p/${masteruser.id}" >${item.username}</a>
                                        </div>
                                    </div>
                                    <p style="text-indent:2em;">${item.comment.content}</p>

                                </div>
                                <div class="clear"></div>
                                <div class="tail" style="float:right;">
                                    <a href="#" class="comments">${item.comment.floor+1}层&nbsp;&nbsp;|</a>
                                    <a href="#" class="comments">${item.addTime}&nbsp;&nbsp;|</a>
                                    <a href="#" class="comments" onclick="showText();return false;" id="respond"> 回复 </a> <!--回复评论 显示被隐藏的回复区域 showText()在base.jsp-->
                                </div>
                                <div id="text">
                     <textarea type="text" name="content" rows="3" style="width: 100%;">
                     </textarea>
                                    <a href="#" class="comments" >发表回复</a>
                                </div>



                    </c:forEach>
                    </li>
                    </ul>
                    </div>
                </div >
            </div>


            <li>
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
            </li>

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