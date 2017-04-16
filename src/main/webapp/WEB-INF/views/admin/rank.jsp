<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="css/pintuer.css">
<link rel="stylesheet" href="css/admin.css">
<script src="js/jquery.js"></script>
<script src="js/pintuer.js"></script>
</head>
<body>
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 权限设置</strong> <a href="" style="float:right; display:none;">添加字段</a></div>
    <div class="padding border-bottom">
      <ul class="search" style="padding-left:10px;">
        <li> <a class="button border-main icon-plus-square-o" href="admin/newuser.html"> 添加用户</a> </li>
        <form action="search/user">
        <select name="types" class="input w50" >
          <option value="email">邮箱</option>
          <option value="id">id</option>
          <option value="nuser_name">用户名</option>
        </select>
        <li>搜索：</li>
        <li>



          <input type="text" placeholder="请输入搜索关键字" name="keywords" class="input" style = "width:250px; line-height:17px;display:inline-block" >
          <button type="submit" class="button border-main icon-search" >搜索</button>
          </form>
        </li>
      </ul>
    </div>
    <table class="table table-hover text-center">
      <tr>
        <th width="100" style="text-align:left; padding-left:20px;">ID</th>
        <th>用户名称</th>
        <th>用户目前级别</th>
        <th width="310">操作</th>
      </tr>
      <volist name="list" id="vo">
          <c:forEach items="${list}" varStatus="i" var="item" >
        <tr>
          <td style="text-align:left; padding-left:20px;"><input type="checkbox" id ="${item.id }"name="id[]" value="" />
           ${item.id}</td>
          <c:if test="${empty search or search==false}">
          <td>${item.nuserName}</td>
          </c:if>
          <c:if test="${ search==true}">
            <td>${item.nuser_name}</td>
          </c:if>
            <c:if test="${item.authority==666}">
            <td><font color="#00CC99">超级管理员</font></td>
            </c:if>
            <c:if test="${item.authority==233}">
                <td><font color="#00CC99">普通管理员</font></td>
            </c:if>
            <c:if test="${item.authority==0 or empty item.authority}">
                <td><font color="#00CC99">普通用户</font></td>
            </c:if>
          <td><div class="button-group"> <a class="button border-main" <c:if test="${item.authority==666}"> disabled="true"</c:if> href="admin/updateuserX${item.id}.html"><span class="icon-edit"></span> 修改</a> <a class="button border-red" <c:if test="${item.authority==666}"> disabled="true"</c:if> onclick="DelSelect(${item.id})"><span class="icon-trash-o"
          ></span> 删除</a> </div></td>
        </tr>
              </c:forEach>
      </volist>
      <c:if test="${empty search or search==false}">
      <td colspan="8"><div class="pagelist"> <c:forEach var="i"  begin="1" end="${pages}" > </span><a href="admin/rank_${i}.html">${i}</a></c:forEach> </div></td>
      </c:if>
      <c:if test="${ search==true}">
      <td colspan="8"><div class="pagelist"> <c:forEach var="i"  begin="1" end="${pages}" > </span><a href="search/user_${search_info}_${i}.html">${i}</a></c:forEach> </div></td>
      </c:if>

      <tr>
        <td style="text-align:left; padding:19px 0;padding-left:20px;"><input type="checkbox" id="checkall"/>
          全选 </td>
        <td colspan="7" style="text-align:left;padding-left:20px;"><a href="javascript:void(0)" class="button border-red icon-trash-o" style="padding:5px 15px;" onclick="DelSelect(-1)"> 删除</a> <!-- <a href="javascript:void(0)" style="padding:5px 15px; margin:0 10px;" class="button border-blue icon-edit" onclick="sorts()"> 排序</a> -->
      <!--     <select name="ishome" style="padding:5px 15px; border:1px solid #ddd;" onchange="changeishome(this)">
            <option value="">首页</option>
            <option value="1">是</option>
            <option value="0">否</option>
          </select>
          <select name="isvouch" style="padding:5px 15px; border:1px solid #ddd;" onchange="changeisvouch(this)">
            <option value="">推荐</option>
            <option value="1">是</option>
            <option value="0">否</option>
          </select>
          <select name="istop" style="padding:5px 15px; border:1px solid #ddd;" onchange="changeistop(this)">
            <option value="">置顶</option>
            <option value="1">是</option>
            <option value="0">否</option>
          </select> -->
          <!-- <select name="copynum" style="padding:5px 15px; border:1px solid #ddd;" onchange="changecopy(this)">
            <option value="">请选择复制</option>
            <option value="5">复制5条</option>
            <option value="10">复制10条</option>
            <option value="15">复制15条</option>
            <option value="20">复制20条</option>
          </select> --></td>
      </tr>
      <tr>

      </tr>

    </table>
  </div>
<script type="text/javascript">

//搜索
function changesearch(){	
		
}

//单个删除
function del(id,mid,iscid){
	if(confirm("您确定要删除吗?")){
		
	}
}

//全选
$("#checkall").click(function(){ 
  $("input[name='id[]']").each(function(){
	  if (this.checked) {
		  this.checked = false;
	  }
	  else {
		  this.checked = true;
	  }
  });
})

//批量删除
function DelSelect(id){
    var Checkbox=false;
    var array = new Array();

    if(id!=-1){
        array.push(id);
        Checkbox=true;

    }else{
        $("input[name='id[]']").each(function(){
            if (this.checked==true) {
                Checkbox=true;
                var key=this.id;
                array.push(key);
                alert(key);
            }
        });
    }

    if (Checkbox){
        var t=confirm("您确认要删除选中的内容吗？");
        if (t==false) return false;
        else{
            $.ajax({
                url:'delete/user',
                type:'post',
                data: "DeleteList=" + array,
                dataType: "json",
                success:function(data){
                    location.reload()
                },
                error:function(data){
                    alert("删除失败");
                },

            })
        }


    }
    else{
        alert("请选择您要删除的内容!");
        return false;
    }
}

//批量排序
function sorts(){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){	
		
		$("#listform").submit();		
	}
	else{
		alert("请选择要操作的内容!");
		return false;
	}
}


//批量首页显示
function changeishome(o){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){
		
		$("#listform").submit();	
	}
	else{
		alert("请选择要操作的内容!");		
	
		return false;
	}
}

//批量推荐
function changeisvouch(o){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){
		
		
		$("#listform").submit();	
	}
	else{
		alert("请选择要操作的内容!");	
		
		return false;
	}
}

//批量置顶
function changeistop(o){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){		
		
		$("#listform").submit();	
	}
	else{
		alert("请选择要操作的内容!");		
	
		return false;
	}
}


//批量管理
function changecate(o){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){		
		
		$("#listform").submit();		
	}
	else{
		alert("请选择要操作的内容!");
		
		return false;
	}
}

//批量复制
function changecopy(o){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){	
		var i = 0;
	    $("input[name='id[]']").each(function(){
	  		if (this.checked==true) {
				i++;
			}		
	    });
		if(i>1){ 
	    	alert("只能选择一条信息!");
			$(o).find("option:first").prop("selected","selected");
		}else{
		
			$("#listform").submit();		
		}	
	}
	else{
		alert("请选择要复制的内容!");
		$(o).find("option:first").prop("selected","selected");
		return false;
	}
}

</script>
</body>
</html>