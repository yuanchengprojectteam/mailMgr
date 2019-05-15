<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品管理</title>
	<link rel="stylesheet" type="text/css" href="js/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="js/easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="js/easyui/demo/demo.css">
	<script type="text/javascript" src="js/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="js/easyui/jquery.easyui.min.js"></script>

	<script type="text/javascript">
		
		function add(){
			$('#w').window('open');
		}
		function edit(){
			var row= $('#dg').datagrid('getSelected');
			if(row == null){
				alert("请选择要修改的商品！");
				return;
			}
			$('#E').window('open');
		}
		
	</script>
	<style type="text/css">
		.lab{
			width:100px;
			display: inline-block;
			text-align: right; 
		}
	</style>
</head>
<body>
	<table id="dg" class="easyui-datagrid" title="商品列表" style="width:700px;height:250px"
		 data-options="pagination:true,fitColumns:true,rownumbers:true,singleSelect:true,url:'datagrid_data1.json',method:'get',toolbar:'#tb',fit:true"
		>
		<thead>
			<tr>
				<th data-options="field:'itemid',width:80">商品ID</th>
				<th data-options="field:'attr1',width:240">商品名称</th>
				<th data-options="field:'productid',width:100">颜色</th>
				<th data-options="field:'listprice',width:80,align:'right'">商品价格</th>
				<th data-options="field:'unitcost',width:80,align:'right'">评论数</th>
				<th data-options="field:'status',width:80,align:'center'">商品数量</th>
				<th data-options="field:'status',width:80,align:'center'">商品的积分</th>
				<th data-options="field:'status',width:80,align:'center'">尺寸</th>
				<th data-options="field:'status',width:80,align:'center'">类型</th>
				<th data-options="field:'attr1',width:240">上架时间</th>
			</tr>
		</thead>
	</table>
	<div id="tb" style="padding:5px;height:auto">
		<div style="margin-bottom:5px">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="add()"></a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="edit()"></a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="delete()"></a>
		</div>
		<div>
			
			商品名称：<input  class="easyui-textbox" style="width:80px">
			价格： <input  class="easyui-textbox" style="width:80px">
			类型 <select class="easyui-combobox" panelHeight="auto" style="width:100px"></select>
			上架时间： <input class="easyui-datebox" style="width:80px">
			<a href="#" onclick="query" class="easyui-linkbutton" iconCls="icon-search">Search</a>
		</div>
	</div>
	
		<div id="w" class="easyui-window" 
		title="添加商品信息" data-options="iconCls:'icon-save',closed:true" 
		style="width:450px;height:375px;padding:5px;">
		<div class="easyui-layout" data-options="fit:true">
			<div data-options="region:'center'" style="padding:10px;text-align: center">
				<form id="fm" method="post" action="">
	    			<span  class="lab">商品名称：</span><input  class="easyui-textbox" name="name"><br>
	    			<span  class="lab">商品颜色：</span><input  class="easyui-textbox" name="pwd"><br>
	    			<span  class="lab">商品上架数量：</span><input  class="easyui-textbox" name="phone"><br>
	    			<span  class="lab">商品的积分：</span><input  class="easyui-textbox" name="email"><br>
	    			<span  class="lab">商品的价格：</span><input  class="easyui-textbox" name="company"><br>
	    			<span  class="lab">商品类型：</span><select class="easyui-combobox" name="state" style="width:155px;"></select><br>
	    			<span  class="lab">商品的尺寸：</span><input  class="easyui-textbox" name="address"><br>
	    			<span  class="lab">商品图片：</span><input class="easyui-filebox" name="file1" data-options="prompt:'Choose a file...'" style="width:50%"><br>
	    			<span  class="lab">商品详情：</span><input class="easyui-filebox" name="file1" data-options="prompt:'Choose a file...',separator:';',multiple:true" style="width:50%"><br>
	    		</form>
			</div>
			<div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
				<a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" href="javascript:void(0)"  style="width:80px">保存</a>
				<a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" href="javascript:void(0)" onclick="$('#w').window('close')" style="width:80px">取消</a>
			</div>
		</div>
	</div>
	
	<div id="E" class="easyui-window" 
		title="修改商品信息" data-options="iconCls:'icon-save',closed:true" 
		style="width:450px;height:375px;padding:5px;">
		<div class="easyui-layout" data-options="fit:true">
			<div data-options="region:'center'" style="padding:10px;text-align: center">
				<form id="" method="post" action="">
	    			<span  class="lab">商品名称：</span><input  class="easyui-textbox" name="name"><br>
	    			<span  class="lab">商品颜色：</span><input  class="easyui-textbox" name="pwd"><br>
	    			<span  class="lab">商品上架数量：</span><input  class="easyui-textbox" name="phone"><br>
	    			<span  class="lab">商品的积分：</span><input  class="easyui-textbox" name="email"><br>
	    			<span  class="lab">商品的价格：</span><input  class="easyui-textbox" name="company"><br>
	    			<span  class="lab">商品类型：</span><select class="easyui-combobox" name="state" style="width:155px;"></select><br>
	    			<span  class="lab">商品的尺寸：</span><input  class="easyui-textbox" name="address"><br>
	    			<span  class="lab">商品图片：</span><input class="easyui-filebox" name="file1" data-options="prompt:'Choose a file...'" style="width:50%"><br>
	    			<span  class="lab">商品详情：</span><input class="easyui-filebox" name="file1" data-options="prompt:'Choose a file...',separator:';',multiple:true" style="width:50%" ><br>
	    			
	    		</form>
			</div>
			<div data-options="region:'south',border:false" style="text-align:right;padding:5px 0 0;">
				<a class="easyui-linkbutton" data-options="iconCls:'icon-ok'" href="javascript:void(0)"  style="width:80px">保存</a>
				<a class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" href="javascript:void(0)" onclick="$('E').window('close')" style="width:80px">取消</a>
			</div>
		</div>
	</div>
	
</body>

<script>

function delete(){
	var row= $('#dg').datagrid('getSelected');
	if(row == null){
		alert("请选择要删除的商品！");
		return;
	}else{
		if(row){
			$.messager.confirm('Confirm','Are you sure you want to destroy this goods?',function(r){
				if (r){
					$.post('destroy_user.php',{id:row.id},function(result){
						if (result.success){
							$('#dg').datagrid('reload');	// reload the user data
						} else {
							$.messager.show({	// show error message
								title: 'Error',
								msg: result.errorMsg
							});
						}
					},'json');
				}
			});
		}
	}
}
		function submitForm(){
			$('#ff').form('submit');
		}
		function clearForm(){
			$('#ff').form('clear');
		}
	</script>
</html>