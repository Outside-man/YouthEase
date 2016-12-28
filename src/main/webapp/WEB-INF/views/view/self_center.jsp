<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<jsp:include page="../public/base.jsp"/>
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
    function agre(id1,id2,id3){
        var array = new Array();
        array.push(id1);
        array.push(id2);
        array.push(id3);
        $.ajax({
            url:'http://localhost:8080/YouthEase/friend/agr',
            type:'post',
            async : false,
            data: "FriendPair=" + array,
            dataType: "json",
            success:function(data){
                location.reload();
                $("div #friend-list").html(data);
                $("div #friend_make").html(data);
                $("div #message-box").html(data);
            },
            error:function(data){
                alert("添加失败");
            },

        })
    }
    var showing= 0;
    function show(){
        if(showing==0)
        $("")
    }
    function del(id1,id2){
        var array = new Array();
        array.push(id1);
        array.push(id2);
        $.ajax({
            url:'http://localhost:8080/YouthEase/friend/del',
            type:'post',
            data: "FriendPair=" + array,
            dataType: "json",
            async : false,
            success:function(data){
                location.reload();
                $("div #friend-list").html(data);
                $("div #friend_make").html(data);
                $("div #message-box").html(data);
            },
            error:function(data){
                alert("删除失败");
            },

        })
    }
    function disag(id){
        $.ajax({
            url:'http://localhost:8080/YouthEase/message/del_friend_request',
            type:'post',
            data: "msgid=" + id,
            dataType: "json",
            success:function(data){
                location.reload();
                $("div #message-box").html(data);

            },
            error:function(data){
                alert("拒绝失败");
            },

        })
    }
</script>

<div class="bg-content">
    <div id="content"><div class="ic"></div>
        <div class="container">
            <div class="row">


                <article class="span8" style="float:right">
                    <h4>我的帖子</h4>
                    <div class="inner-1">
                        <ul class="list-blog">
                            beta-version

                            <div class="container">
                                <iframe scrolling="auto" rameborder="0" src="${centerUser.id}_1.myforum" name="right" width="80%" height="60%"></iframe>
                            </div>
                            <div class="container">
                                <iframe scrolling="auto" rameborder="0" src="${centerUser.id}_1.myforum" name="right" width="80%" height="60%"></iframe>
                            </div>
                        </ul>

                    </div>

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
                                    照片：<input type="file" name="icon" src=""/>
                                    <button type="submit"  id="submit_btn"
                                            class="btn btn-primary btn-lg">&nbsp;上&nbsp;传&nbsp; </button>
                                </form>
                            </section>
                        </c:if>
                    </div>
                </article>
                <article class="span8" style="float:none;width: 300px;">
                    <h3 >个人资料</h3>
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


                    <c:if test="${user.id!=centerUser.id}">
                        <div id="friend_make">
                            <section>

                                    <c:if test="${befriend==false}">
                                        <form action="friend/add" method="post">
                                            <input type="hidden" name="targetId"  value="${centerUser.id}"/>
                                            <input type="hidden" name="sourceId" value="${user.id}">
                                        <button type="submit"  id="button_friend_request" onclick=""
                                            class="btn btn-primary btn-lg">好友申请</button>
                                    </c:if>
                                    <c:if test="${befriend==true}">
                                        <button type="button"  id="button_friend_dequest" onclick="del(${centerUser.id},${user.id})"
                                                class="btn btn-primary btn-lg">删除好友</button>
                                    </c:if>
                                </form>
                            </section>
                        </div>
                    </c:if>
                    <c:if test="${user.authority==666}">
                        <section> <a href="admin/index.html" class="link-1">



                            <button type="submit"  id="button_manage"
                                    class="btn btn-primary btn-lg">&nbsp;管&nbsp;理&nbsp; </button></a>

                        </section>
                    </c:if>

                </article>

                <article class="span4">
                    <h3 class="extra">寻找易友</h3>
                    <form id="search" action="" method="GET" accept-charset="utf-8" >
                        <div class="clearfix">
                            <input type="text" name="s" onBlur="if(this.value=='') this.value=''" onFocus="if(this.value =='' ) this.value=''" >
                            <a href="#" onClick="document.getElementById('search').submit()" class="btn btn-1">GO!</a> </div>
                    </form>
                    <h3>最近联系</h3>
                    <ul class="list extra extra1">
                    </ul>
                    <h3>易友</h3>
                    <div id="friend-list" class="wrapper">
                        <ul class="list extra2 list-pad ">
                            <c:forEach items="${friends}" varStatus="i" var="item" >
                                <li><a href="self_center_p/${item.id}"> ${item.nuserName} </a></li>
                            </c:forEach>
                        </ul>
                    </div>
                    <h3>消息</h3>
                    <div id="message-box" class="wrapper">
                        <ul class="list extra2 list-pad ">
                            <c:forEach items="${messages}" varStatus="i" var="item" >
                                <c:if test="${item.type=='friend_making'}">
                                    <li>
                                            ${item.content}
                                    </li>
                                    <li>
                                        <section>
                                            <button type="button"  id="agr${item.id}"
                                                    class="btn btn-primary btn-small" onclick="agre(${item.targetId},${item.sourceId},${item.id} )">&nbsp;同&nbsp;意&nbsp; </button>
                                            <button type="button"  id="ref${item.id}"
                                                    class="btn btn-primary btn-small" onclick="disag(${item.id})">&nbsp;拒&nbsp;绝&nbsp; </button>
                                        </section>
                                    </li>
                                </c:if>

                            </c:forEach>
                        </ul>
                    </div>
                    <c:if test="${centerUser.id==user.id}">
                        <button type="button"   class="btn btn-primary btn-small" id="${user.id}" onclick="show()"> Ease Talk</button>
                    </c:if>
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