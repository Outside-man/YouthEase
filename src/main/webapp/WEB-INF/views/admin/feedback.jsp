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
<form method="post" action="">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 反馈管理</strong></div>
    <div class="padding border-bottom">
      <ul class="search">
        <li>
          <button type="button"  class="button border-green" id="checkall"><span class="icon-check"></span> 全选</button>
          <button type="button" class="button border-red" onclick="DelSelect(-1)"><span class="icon-trash-o"></span> 批量删除</button>
        </li>
      </ul>
    </div>
    <table class="table table-hover text-center">
      <tr>
        <th width="120">ID</th>
        <th>姓名</th>       
        <th>电话</th>
        <th>邮箱</th>
        <th>其他</th>
        <th width="25%">内容</th>
         <th width="120">留言时间</th>
        <th>操作</th>       
      </tr>
      <c:forEach items="${list}" varStatus="i" var="item" >
        <tr>
          <td><input type="checkbox" id=${item.id } name="id[]" value="1" />
              ${item.id}</td>
          <td>${item.name}</td>
          <td>${item.phone}</td>
          <td>${item.email}</td>
           <td>未知</td>
          <td>${item.content}</td>
          <td>2016-07-01</td>
          <td><div class="button-group"> <a class="button border-red" href="javascript:void(0)" onclick="DelSelect(${item.id})"><span class="icon-trash-o"></span> 删除</a> </div></td>
        </tr>
      </c:forEach>


    </table>
  </div>
</form>
<script type="text/javascript">
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
                url:'http://localhost:8080/YouthEase/delete/contact',
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

</script>
</body></html>