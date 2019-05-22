<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="js/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="js/easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="js/easyui/demo/demo.css">
	<script type="text/javascript" src="js/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="js/easyui/jquery.easyui.min.js"></script>
</head>
<body>
		    <table id="dg" title="My Users" class="easyui-datagrid" style="width:700px;height:250px"
            url="queryGtype"
            toolbar="#toolbar" pagination="true" fit="true"
            rownumbers="true" fitColumns="true" singleSelect="true">
        <thead>
            <tr>
                <th field="id" width="50">类型编号</th>
                <th field="name" width="50">类型</th>
                <th field="pname" width="50">父类型</th>
                <th field="sunname" width="50">祖父类型</th>
            </tr>
        </thead>
    </table>
    <div id="toolbar">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">新增</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="edit()">编辑</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteType()">删除</a>
    </div>
    
    <div id="dlg" class="easyui-dialog" style="width:400px" data-options="closed:true,modal:true,border:'thin',buttons:'#dlg-buttons' ">
        <form id="fm" method="post" action="saveType" novalidate style="margin:0;padding:20px 50px">
            <h3>新增类型</h3>
            <div style="margin-bottom:10px">
               <input name="newName" class="easyui-textbox" required="true" label="类型:" style="width:100%">
            </div>
            <div style="margin-bottom:10px">
                  <input id="typeName" label=" 选择父类型：" class="easyui-combobox" name="pid"
    				data-options="valueField:'id',textField:'text',url:'getdata'"  style="width:100%">
            </div>
        </form>
    </div>
    <div id="dlg-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveUser()" style="width:90px">Save</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">Cancel</a>
    </div>
    
    <div id="E" class="easyui-window" 
		title="修改商品信息" data-options="iconCls:'icon-save',closed:true" 
		style="width:450px;height:300px;padding:5px;">
		<div class="easyui-layout" data-options="fit:true">
			<div data-options="region:'center'" style="padding:10px;text-align: center">
				<form id="fe" method="post" action="updateType">
					<input  id="name" class="easyui-textbox" name="id" type="hidden">
	    			<span  class="lab">类型名称：</span><input  id="addname" class="easyui-textbox" name="name"><br>
	    			<span  class="lab">父类型：</span><input id="typeName" class="easyui-combobox" name="pid"
    				data-options="valueField:'id',textField:'text',url:'getdata'" ><br>
	    			</form>
			</div>
			<div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
				<a onclick="updateType()" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" href="javascript:void(0)"  style="width:80px">保存</a>
				<a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" href="javascript:void(0)" onclick="$('E').window('close')" style="width:80px">取消</a>
			</div>
		</div>
	</div>
	
    <script type="text/javascript">
        var url;
        function newUser(){
            $('#dlg').dialog('open').dialog('center').dialog('setTitle','New User');
            $('#fm').form('clear');
            url = 'save_user.php';
        }
        function editUser(){
            var row = $('#dg').datagrid('getSelected');
            if (row){
                $('#dlg').dialog('open').dialog('center').dialog('setTitle','Edit User');
                $('#fm').form('load',row);
                url = 'update_user.php?id='+row.id;
            }
        }
        
        function edit(){
			var row= $('#dg').datagrid('getSelected');
			if(row == null){
				alert("请选择要修改的商品！");
				return;
			}
			$('#fe').form('load',row);
			$('#E').window('open');
		}
        
        
        	function saveUser(){
    			$("#fm").form('submit',{
    				
    				success:function(data){
    					alert("添加成功！");
    					$("#dlg").window('close');
    					$('#dg').datagrid('reload');
    				}
    				
    			})
    		}
     
        	function deleteType(){
    			var row= $('#dg').datagrid('getSelected');
    			if(row == null){
    				alert("请选择要删除的类型！");
    				return;
    			}
    			
    			var id = row.id;
    			$.ajax({
    				type:"post",
    				url:"deleteType",
    				data:{"id":id},
    				success:function(data){
    					alert("删除成功！");
    					//$("#dlg").window('close');
    					$('#dg').datagrid('reload');
    				},
    				error:function(e){
    					alert("删除失败！");
    				}
    				
    			});
    		}
        	function updateType(){
    			$("#fe").form('submit',{
    				
    				success:function(data){
    					alert("修改成功！");
    					$("#E").window('close');
    					$('#dg').datagrid('reload');
    				}
    				
    			})
    			
    		}
    </script>
</body>
</html>