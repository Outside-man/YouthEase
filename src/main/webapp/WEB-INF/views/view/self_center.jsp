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
    <script type="text/javascript">
        var count=0;
    function update_userdata(){

        if(count==0){
            document.getElementById('user_name').disabled = false;
            document.getElementById("real_name").disabled=false;
            document.getElementById("inputPassword").disabled=false;
            count++;
        }else{
            if(document.getElementById("inputPassword").value!=null)
                document.getElementById('data_form').submit();
         count=0;
        }
    }
    </script>

    <div id="content"><div class="ic"></div>
        <div class="container">
            <div class="row">
                <article class="span8">
                    <article class="span12">
                        <h3 >个人资料</h3>
                    </article>
                    <form id="data_form" action = "user/update">
                        <div class="control-group">
                            <label class="control-label" for="user_name">用户名：</label>
                            <div class="controls">
                                <input type="text" name="nuserName" id="user_name" placeholder="user_name" value="${centerUser.nuserName}" disabled="true">
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="real_name">真实姓名：</label>
                            <div class="controls">
                                <input type="text" name="realName" id="real_name" placeholder="real_name" value="${centerUser.realName}" disabled="true">
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="inputEmail" >邮箱：</label>
                            <div class="controls">
                                <input type="text" name="email" id="inputEmail" placeholder="Email" value="${centerUser.email} "disabled= "true">
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="inputPassword">密码：</label>
                            <div class="controls">
                                <input type="password" name="passwordHash" id="inputPassword" placeholder="Password" value="" disabled= "true">
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="inputSchool" >学校：</label>
                            <div class="controls">
                                <input type="text" id="inputSchool" placeholder="School" value="" disabled= "true">
                            </div>
                            <input type="hidden" id="userId" name="id" value="${centerUser.id}">
                        </div>
                        <c:if test="${user.id==centerUser.id}">
                            <div>
                                <section> <a href="#" class="link-1"></a>
                                    <button type="button"  id="button_update" onclick="update_userdata()"
                                            class="btn btn-primary btn-lg">&nbsp;更&nbsp;新&nbsp; </button>
                                </section>
                            </div>
                        </c:if>
                    </form>



                    <c:if test="${user.authority==666}">
                        <section> <a href="#" class="link-1"></a>
                            <button type="button"  id="button_manage"
                                    class="btn btn-primary btn-lg">&nbsp;管&nbsp;理&nbsp; </button>
                        </section>
                    </c:if>

                </article>


                <article class="span4">
                    <article class="span12">
                        <h3 >头像</h3>
                    </article>
                    <div class="thumbnails thumbnails-1 ">
                        <img  src="${iconUrl}" alt="" width="265"  >  </div>
                    <div>
                        <c:if test="${user.id==centerUser.id}">
                            <section> <a href="#" class="link-1"></a>
                                <form id="${user.id}" action="uploads/userIcon" method="post" enctype="multipart/form-data">
                                    照片：<input type="file" name="icon"/>
                                    <button type="submit"  id="submit_btn"
                                            class="btn btn-primary btn-lg">&nbsp;上&nbsp;传&nbsp; </button>
                                </form>
                            </section>
                        </c:if>
                    </div>
                </article>





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
