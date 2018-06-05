<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>选课系统后台管理</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="css/fullcalendar.css" />
<link rel="stylesheet" href="css/matrix-style.css" />
<link rel="stylesheet" href="css/global_color.css" />
<link rel="stylesheet" href="css/global.css" />
<link rel="stylesheet" href="css/matrix-media.css" />
<script src="js/jquery.min.js"></script>
<script src="js/self.js"></script>
<link rel="stylesheet" href="css/self.css" />

<link href="font-awesome/css/font-awesome.css" rel="stylesheet" />
<link rel="stylesheet" href="css/jquery.gritter.css" />
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800'
	rel='stylesheet' type='text/css' />
<style>
.increase {
	text-align: center;
	margin-top: 10px;
	margin-left: 10px;
	width: 180px;
}
.incr {
	margin-left: 980px;
}
/*start search*/
.search-box {
    border-radius:15px;
    margin-bottom:3px;
    float: right;
    width:300x;
    height:25px;
	position: relative;
    z-index: 1;
    display: inline-block;
    border:2px solid rgb(197, 197, 197);
}
.dataTables_length {
	color: #878787;
	margin: 7px 5px 0;
	position: relative;
	left:5px; width:1027px;
	top: -2px;
}
.search-box input[type="text"] {
border-radius:15px;
text-align:center;
    outline: none;
    background: #fff;
    width:100px;
     height:17px;
    margin: 0;
    font-size: 0.9em;
    color: #7A7B78;
    border: none;
}
.search-box input[type="submit"] {
    background: url(images/search.png)no-repeat;
    width: 20px;
    height:25px;
    display: inline-block;
    vertical-align: text-top;
    border: none;
    outline: none;
}
.searchform {
    display: block;
    margin-top: 0em;
}
::-webkit-input-placeholder{
   color:#7A7B78 !important;
}
/*--//search-ends --*/
</style>
<script type="text/javascript">
$(document).ready(function(){
	if ($("#errID").html() != "") {
		alert($("#errID").html());
	}
	if ($("#errID2").html() == 1) {
		$("#pages").html("");
	}
	if ($("#errID1").html() == 1) {
		alert("未找到符合条件的记录！");
	}
	$("#college").change(function(){
		var collId=$("select[name='college'] option:selected").val();
		$.ajax({
	        url: "Major_findAll.action?collId="+collId,
	        // 数据发送方式
	        type: "post",
	        // 接受数据格式
	        dataType : "json",
	        // 要传递的数据
	        // data :params ,
	        // 回调函数，接受服务器端返回给客户端的值，即result值
	         success:function(list2){  
	        	 $("#major").html("");
	        	 $("#major").append('<option select="selected" value="">'+'-请选择-'+'</option>');
	          	 $.each(list2,function(i,value){   
	         		 $("#major").append('<option value="'+ value.majorid +'">' + value.majorname + '</option>');
	             });  
	         }	
	       });	
	});
	$("#major").change(function(){
		var majorId=$("select[name='major'] option:selected").val();
		$.ajax({
	        url: "Course_findByMajor.action?majorId1="+majorId,
	        // 数据发送方式
	        type: "post",
	        // 接受数据格式
	        dataType : "json",
	        // 要传递的数据
	        // data :params ,
	        // 回调函数，接受服务器端返回给客户端的值，即result值
	         success:function(list4){  
	        	 $("#courseId").html("");
	        	 $("#courseId").append('<option select="selected" value="">'+'-请选择-'+'</option>');
	          	 $.each(list4,function(i,value){   
	         		 $("#courseId").append('<option value="'+ value.id +'">' + value.coursename + '</option>');
	             });  
	         }	
	       });	
	})
})
function checkCourId(){
		var courID=$("#courID").val();
		var sss=courID.replace(/ /g,'');	
/* 		if(schId.length == 0){
			alert("请输入排课编号！");
			return false;
		} */
		if(isNaN(sss)){
			alert("请输入数字！");
			return false;
		}
		return true;
	}
function check(){
		var college=$("#college").val();
		var major=$("#major").val();
		if(college==""||major==""){
		  alert("学院和专业必须同时选择！");	
		  return false;			
		}
		return true;
	}
</script>
</head>
<body>
	<!--Header-part-->
	<div id="header">
		<h1>
			<a href="dashboard.html">Matrix Admin</a>
		</h1>
	</div>
	<!--close-Header-part-->

	<!--top-Header-menu-->
	<div id="user-nav" class="navbar navbar-inverse">
		<ul class="nav">
			<li class="dropdown" id="profile-messages"><a title="" href="#"
				data-toggle="dropdown" data-target="#profile-messages"
				class="dropdown-toggle"><i class="icon icon-user"></i> <span
					class="text">Welcome User</span><b class="caret"></b></a></li>
			<li class=""><a title="" href="login.html"><i
					class="icon icon-share-alt"></i> <span class="text">Logout</span></a></li>
		</ul>
	</div>
	<!--close-top-Header-menu-->

	<!--sidebar-menu-->
	<div id="sidebar">
		<!-- <a href="#" class="visible-phone"><i
			class="icon icon-home"></i>Dashboard</a> -->
		<ul>
			<li class="submenu"><a href="#"><i
					class="icon icon-home"></i> 
					<span>院系专业管理</span></a>
				</li>
		
		<li class="submenu"><a href="#"><i
					class="icon icon-th"></i> 
					<span>班级课表管理</span></a>
				<ul>
					<li><a href="Schedule_findByCondition.action">查询班级课表</a></li>
					<li><a href="Course_findByCondition.action">查询全部课程</a></li>
					<li><a href="ClassInfo_findByCondition.action">查询班级基本信息</a></li>
				</ul></li>
				<li class="submenu"><a href="#"><i
					class="icon icon-file"></i> 
					<span>课程公告管理</span></a>
				</li>
					<li class="submenu"><a href="#"><i
					class="icon icon-pencil"></i> 
					<span>成绩信息管理</span></a>
				</li>
					<li class="submenu"><a href="#"><i
					class="icon icon-fullscreen"></i> 
					<span>教师信息管理</span></a>
				</li>
					<li class="submenu"><a href="#"><i
					class="icon icon-signal"></i> 
					<span>学生信息管理</span></a>
				</li>
				
		</ul>
	</div>
	<!--sidebar-menu-->

	<div id="content">
		<div id="content-header">
			<div id="breadcrumb">
				<a href="#" title="Go to Home" class="tip-bottom"><i
					class="icon-home"></i>选课系统后台管理</a> <a href="#" class="current">班级课表管理</a>
			</div>
			<div>
			    <div style="margin-left:20px;margin-top:18px;color:blue">提示:学院和专业必须同时查询，为了提高选课效率，请同学们使用查询过滤功能。</div>
				<form action="Course_findByCondition.action" method="post" onsubmit="return check()">
					<table style="margin-left:20px;margin-top:18px">
						<tr>
							<td style="font-size:15px;color:red">开设学院：</td>
							<td><select
								style="width:136px;margin-top:10px;border-radius:15px"
								name="college" id="college">
									<option select="selected" value="">-请选择-</option>
									<s:iterator var="p" value="#session.clist">
										<option value="<s:property value="#p.collegeid" />"><s:property
												value="#p.collegename" /></option>
									</s:iterator>
							</select></td>
							<td style="font-size:15px;color:red">所属专业：</td>
							<td><select
								style="width:136px;margin-top:10px;border-radius:15px"
								name="major" id="major">
									<option select="selected" value="">-请选择-</option>
							</select></td>
							<td style="font-size:15px">课程名称:</td>
							<td><select
								style="width:136px;margin-top:10px;border-radius:15px;margin-left:10px"
								name="coursename" id="courseId">
									<option select="selected">-请选择-</option>
							</select></td>
							<td style="font-size:15px">课程性质：</td>
							<td><input type="text" class="inputStyle"
								style="width:124px;margin-top:10px;border-radius:15px" name="coursetype"></td>
							<td style="font-size:15px">学分：</td>
							<td>
							<input type="text" class="inputStyle"
								style="width:124px;margin-top:10px;border-radius:15px" name="credit">
							</td></tr>
							<!-- <tr>
							  <td style="width:100px"></td>
							  <td><input type="submit" value="查询" /></td>
							</tr>
							<td><input type="submit" value="查询" /></td> -->
					</table>
					<div style="margin-left:1010px"><input type="submit" value="查询" style="border-radius:15px" /></div>
				</form>
			</div>
		</div>
		<div class="container-fluid">
			<hr>
			<div class="row-fluid">
				<div class="span12">
					<div class="widget-box">
						<div class="widget-title">
							<span class="icon"><i class="icon-th"></i></span>
							<h5>课程信息</h5>
						</div>
						<div class="widget-content nopadding">
							<div id="DataTables_Table_0_wrapper" class="dataTables_wrapper"
								role="grid">
								<div class="">
									<div id="DataTables_Table_0_length" class="dataTables_length">
										<!-- <div class="incr">
											<input type="button" value="添加" data-toggle="modal"
												data-target="#myModal" />
										</div> -->
										<div class="search-box">
											<form class="searchform" method="post" action="Course_findByID.action" onsubmit="return checkCourId()">
												<input type="text" placeholder="课程编号查询..." required="" name="courseId" value="" id="courID">
												<input type="submit" value="">
											</form>
										</div>
										<div id="errID" style="display:none"><s:property value="message" /></div>
												<div id="errID1" style="display:none"><s:property value="message1" /></div>
				  							  <div id="errID2" style="display:none"><s:property value="message2" /></div>
									</div>
									<table class="table table-bordered data-table">
										<thead>
											<tr>
												<th>编号</th>
												<th>课程名称</th>
												<th>课程性质</th>
												<th>学分</th>
												<th>开设学院</th>
												<th>所属专业</th>
											</tr>
										</thead>
										<tbody>
											<s:iterator var="p" value="#session.coulist">
												<tr>
													<td style="text-align:center"><s:property
															value="#p.id" /></td>
													<td style="text-align:center"><s:property
															value="#p.coursename" /></td>
													<td style="text-align:center"><s:property
															value="#p.coursetype" /></td>
													<td style="text-align:center"><s:property
															value="#p.credit" /></td>
													<td style="text-align:center"><s:property
															value="#p.college.collegename" /></td>		
													<td style="text-align:center"><s:property
															value="#p.major.majorname" /></td>				
												</tr>
											</s:iterator>
										</tbody>
									</table>
									<!-- <div class="dataTables_paginate fg-buttonset ui-buttonset fg-buttonset-multi ui-buttonset-multi paging_full_numbers" id="DataTables_Table_0_paginate">
								 <a tabindex="0" class="first ui-corner-tl ui-corner-bl fg-button ui-button ui-state-default" id="DataTables_Table_0_first">First</a>
								 <a tabindex="0" class="previous fg-button ui-button ui-state-default" id="DataTables_Table_0_previous">Previous</a> 
								
								</div>-->
								</div>
							</div>
						</div>
						<div id="pages" style="margin-left: 40px">
        	        <s:if test="page==1">
        	        	<a href="#">上一页</a>
        	        </s:if>
        	        <s:else>
        	        	<a href="/CSManagement/Course_findByCondition.action?page=<s:property value="page-1"/>">上一页</a>
        	        </s:else>
        	        <s:iterator begin="1" end="totalPage" var="k">
        	        	<s:if test="page==#k">
        	        		<a href="/CSManagement/Course_findByCondition.action?page=<s:property value="#k"/>" class="current_page"><s:property value="#k"/></a>
        	        	</s:if>
        	        	<s:else>
        	        		<a href="/CSManagement/Course_findByCondition.action?page=<s:property value="#k"/>"><s:property value="#k"/></a>
        	        	</s:else>
        	        </s:iterator>
        	        <s:if test="page==totalPage">
        	        	<a href="#">下一页</a>
        	        </s:if>
        	        <s:else>
        	        	<a href="/CSManagement/Course_findByCondition.action?page=<s:property value="page+1"/>">下一页</a>
        	        </s:else>
                </div>
					</div>
				</div>
			</div>
		</div>
		</div>
		<!--End-Action boxes-->
		<script src="js/excanvas.min.js"></script>
		<script src="js/jquery.ui.custom.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script src="js/jquery.flot.min.js"></script>
		<script src="js/jquery.flot.resize.min.js"></script>
		<script src="js/jquery.peity.min.js"></script>
		<script src="js/fullcalendar.min.js"></script>
		<script src="js/matrix.js"></script>
		<script src="js/matrix.dashboard.js"></script>
		<script src="js/jquery.gritter.min.js"></script>
		<script src="js/matrix.interface.js"></script>
		<script src="js/matrix.chat.js"></script>
		<script src="js/jquery.validate.js"></script>
		<script src="js/matrix.form_validation.js"></script>
		<script src="js/jquery.wizard.js"></script>
		<script src="js/jquery.uniform.js"></script>
		<script src="js/select2.min.js"></script>
		<script src="js/matrix.popover.js"></script>
		<script src="js/jquery.dataTables.min.js"></script>
		<script src="js/matrix.tables.js"></script>
		<script type="text/javascript">
			// This function is called from the pop-up menus to transfer to
			// a different page. Ignore if the value returned is a null string:
			function goPage(newURL) {

				// if url is empty, skip the menu dividers and reset the menu selection to default
				if (newURL != "") {

					// if url is "-", it is this page -- reset the menu:
					if (newURL == "-") {
						resetMenu();
					}
					// else, send page to designated URL            
					else {
						document.location.href = newURL;
					}
				}
			}

			// resets the menu selection upon entry to this page:
			function resetMenu() {
				document.gomenu.selector.selectedIndex = 2;
			}
		</script>
</body>
</html>