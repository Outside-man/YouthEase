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
    <title>网站信息</title>  
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>  
</head>
<body>

<div class="panel admin-panel">

  <div class="panel-head"><strong class="icon-reorder"> 回帖管理</strong></div>
  <div class="padding border-bottom">
  </div> 
  <table class="table table-hover text-center">
    <tr>
      <th width="5%">ID</th>     
      <th width="500">评论内容</th>
      <th>发表者</th>
      <th width="250">操作</th>
    </tr>

      <c:forEach items="${list}" varStatus="i" var="item" >
    <tr>
        <td style="text-align:left; padding-left:20px;"><input type="checkbox" name="id[]" value="" />
                ${item.comment.id}</td>
      <td>${item.comment.content}</td>
      <td>${item.username}</td>
      <td>
      <div class="button-group">
       <a class="button border-red" href="javascript:void(0)" onclick="return DelSelect(${item.comment.id})"><span class="icon-trash-o"></span> 删除</a>
      </div>
      </td>
    </tr>

      </c:forEach>

    
  </table>
</div>
<td style="text-align:left; padding:19px 0;padding-left:20px;"><input type="checkbox" id="checkall"/>
    全选 </td>
<td colspan="7" style="text-align:left;padding-left:20px;"><a href="javascript:void(0)" class="button border-red icon-trash-o" style="padding:5px 15px;" onclick="DelSelect(-1)"> 删除</a>
    <script>
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
                    url:'http://localhost:8080/YouthEase/delete/comment',
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
</script>
</body></html>