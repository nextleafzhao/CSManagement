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
<link rel="stylesheet" href="css/matrix-media.css" />
<link rel="stylesheet" href="css/datepicker.css" />
<link rel="stylesheet" href="css/global_color.css" />
<link rel="stylesheet" href="css/global.css" />
<link rel="stylesheet" href="css/uniform.css" />
<link rel="stylesheet" href="css/select2.css" />
<!-- <link rel="stylesheet" href="css/style.css" /> -->
<link rel="stylesheet" href="css/bootstrap-wysihtml5.css" />
<link rel="stylesheet" href="css/self.css" />
<script src="js/jquery.min.js"></script>
<script src="js/self.js"></script>
<%-- <script src="js/matrix.tables.js"></script> --%>
<script src="js/bootstrap.min.js"></script>
<script src="js/fullcalendar.min.js"></script>
<script src="js/jquery.dataTables.min.js"></script>
<script src="js/bootstrap-datepicker.js"></script>
<script src="js/bootstrap-wysihtml5.js"></script>
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
/*start search*/
.search-box {
	border-radius: 15px;
	float: right;
	width: 300x;
	height: 25px;
	position: relative;
	z-index: 1;
	display: inline-block;
	border: 2px solid rgb(197, 197, 197);
}

.dataTables_length {
	color: #878787;
	margin: 7px 5px 0;
	position: relative;
	left: 5px;
	width: 1027px;
	top: -2px;
}

.search-box input[type="text"] {
	border-radius: 15px;
	text-align: center;
	outline: none;
	background: #fff;
	width: 100px;
	height: 17px;
	margin: 0;
	font-size: 0.9em;
	color: #7A7B78;
	border: none;
}

.search-box input[type="submit"] {
	background: url(images/search.png) no-repeat;
	width: 20px;
	height: 25px;
	display: inline-block;
	vertical-align: text-top;
	border: none;
	outline: none;
}

.searchform {
	display: block;
	margin-top: 0em;
}

::-webkit-input-placeholder {
	color: #7A7B78 !important;
}
/*--//search-ends --*/
.incr {
	width: 200px;
	margin-bottom: 3px;
}
</style>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						if ($("#errID").html() != "") {
							alert($("#errID").html());
						}
						if ($("#errID2").html() == 1) {
							$("#pages").html("");
						}
						 if ($("#errID1").html() == 1) {
							alert("未找到符合条件的记录！");
						} 
				
						
						$("#deleteAll")
								.click(
										function() {
											var r = window.confirm("是否删除选中记录？");
							              if(r){							                								                								   
											var n;
											var id;
											$("input[name='allDel']:checked")
													.each(
															function() { // 遍历选中的checkbox
																id = $(this)
																		.parent()
																		.parent()
																		.children(
																				"td:eq(1)")
																		.html();
																n = $(this)
																		.parents(
																				"tr")
																		.index();
																n++;
																$("#tab")
																		.find(
																				"tr:eq("
																						+ n
																						+ ")")
																		.remove();
																$
																		.ajax({
																			url : "Schedule_deleteAll.action?id="
																					+ id,
																			// 数据发送方式
																			type : "post",
																			// 接受数据格式
																			dataType : "json",
																			// 要传递的数据
																			// data :params ,
																			// 回调函数，接受服务器端返回给客户端的值，即result值
																			success : function(
																					data) {
																			}
																		});
															});
											alert("删除成功！");}
										})
						$("#college").change(
										function() {
											
											var collId = $(
													"select[name='college'] option:selected")
													.val();
											$
													.ajax({
														url : "Major_findAll.action?collId="
																+ collId,
														// 数据发送方式
														type : "post",
														// 接受数据格式
														dataType : "json",
														// 要传递的数据
														// data :params ,
														// 回调函数，接受服务器端返回给客户端的值，即result值
														success : function(
																list2) {
															$("#major")
																	.html("");
															$("#major")
																	.append(
																			'<option select="selected" value="">'
																					+ '-请选择-'
																					+ '</option>');
															$
																	.each(
																			list2,
																			function(
																					i,
																					value) {
																				$(
																						"#major")
																						.append(
																								'<option value="'+ value.majorid +'">'
																										+ value.majorname
																										+ '</option>');
																			});
														}
													});
										});
						$("#college1")
								.change(
										function() {
											var collId = $(
													"select[name='college1'] option:selected")
													.val();
											$
													.ajax({
														url : "Major_findAll.action?collId="
																+ collId,
														// 数据发送方式
														type : "post",
														// 接受数据格式
														dataType : "json",
														// 要传递的数据
														// data :params ,
														// 回调函数，接受服务器端返回给客户端的值，即result值
														success : function(
																list2) {
															$("#major1").html(
																	"");
															$("#major1")
																	.append(
																			'<option select="selected" value="">'
																					+ '-请选择-'
																					+ '</option>');
															$
																	.each(
																			list2,
																			function(
																					i,
																					value) {
																				$(
																						"#major1")
																						.append(
																								'<option value="'+ value.majorid +'">'
																										+ value.majorname
																										+ '</option>');
																			});
														}
													});
										});
						$("#major1")
								.change(
										function() {
											var majorId = $(
													"select[name='major1'] option:selected")
													.val();
											$
													.ajax({
														url : "Course_findByMajor.action?majorId1="
																+ majorId,
														// 数据发送方式
														type : "post",
														// 接受数据格式
														dataType : "json",
														// 要传递的数据
														// data :params ,
														// 回调函数，接受服务器端返回给客户端的值，即result值
														success : function(
																list4) {
															$("#xgcourseId")
																	.html("");
															$("#xgcourseId")
																	.append(
																			'<option select="selected" value="">'
																					+ '-请选择-'
																					+ '</option>');
															$
																	.each(
																			list4,
																			function(
																					i,
																					value) {
																				$(
																						"#xgcourseId")
																						.append(
																								'<option value="'+ value.id +'">'
																										+ value.coursename
																										+ '</option>');
																			});
														}
													});
										})
						$("#incollege")
								.change(
										function() {
											
											var collId = $(
													"select[name='incollege'] option:selected")
													.val();
											$
													.ajax({
														url : "Major_findAll.action?collId="
																+ collId,
														// 数据发送方式
														type : "post",
														// 接受数据格式
														dataType : "json",
														// 要传递的数据
														// data :params ,
														// 回调函数，接受服务器端返回给客户端的值，即result值
														success : function(
																list2) {
															$("#inmajor").html(
																	"");
															$("#inmajor")
																	.append(
																			'<option select="selected" value="">'
																					+ '-请选择-'
																					+ '</option>');
															$
																	.each(
																			list2,
																			function(
																					i,
																					value) {
																				$(
																						"#inmajor")
																						.append(
																								'<option value="'+ value.majorid +'">'
																										+ value.majorname
																										+ '</option>');
																			});
														}
													});
										})
						$("#inmajor")
								.change(
										function() {
											var majorId = $(
													"select[name='inmajor'] option:selected")
													.val();
											$
													.ajax({
														url : "Course_findByMajor.action?majorId1="
																+ majorId,
														// 数据发送方式
														type : "post",
														// 接受数据格式
														dataType : "json",
														// 要传递的数据
														// data :params ,
														// 回调函数，接受服务器端返回给客户端的值，即result值
														success : function(
																list4) {
															$("#incourseId")
																	.html("");
															$("#incourseId")
																	.append(
																			'<option select="selected" value="">'
																					+ '-请选择-'
																					+ '</option>');
															$
																	.each(
																			list4,
																			function(
																					i,
																					value) {
																				$(
																						"#incourseId")
																						.append(
																								'<option value="'+ value.id +'">'
																										+ value.coursename
																										+ '</option>');
																			});
														}
													});
										});
						$("#inser").click(function() {
							$("#inform").show();
						})
						/* $("#conUpdate").click(function() {
							alert("修改成功！");
						}) */
						/* $("#edit11").click(function(){
							$("#upform").show();
						}) */
					});

	function checkInfo() {
		var flag = 1;
		$("#errCollege").html("");
		$("#errMajor").html("");
		$("#errCourse").html("");
		$("#errGrade").html("");
		$("#errClassInfo").html("");
		$("#errSchtime").html("");
		$("#errClassroom").html("");
		$("#errTeacher").html("");
		var college = $("#incollege").val();
		var major = $("#inmajor").val();
		var course = $("#incourseId").val();
		var grade = $("#ingrade").val();
		var classInfo = $("#inclassInfo").val();
		var schooltime = $("#inschooltime").val();

		var classroom = $("#inclassroom").val();
		var teacher = $("#inTeacher").val();
		if (college == "") {
			$("#errCollege").html("请选择开设学院！");
			flag = false;
		}
		if (major == "") {
			$("#errMajor").html("请选择专业！");
			flag = false;
		}
		if (course == "") {
			$("#errCourse").html("请选择课程！");
			flag = false;
		}
		if (grade == "") {
			$("#errGrade").html("请选择上课年级！");
			flag = false;
		}
		if (classInfo == "") {
			$("#errClassInfo").html("请选择上课班级！");
			flag = false;
		}
		if (schooltime == "") {
			//alert("请输入上课时间！");
			$("#errSchtime").html("请输入上课时间！");
			flag = false;
		} else {

			$.ajax({
				url : "Schedule_checkSchtime.action?schooltime=" + schooltime,
				// 数据发送方式
				type : "post",
				// 接受数据格式
				dataType : "json",
				async : false,
				// 要传递的数据
				// data :params ,
				// 回调函数，接受服务器端返回给客户端的值，即result值
				success : function(error) {
					if (error == "error") {

						$("#errSchtime").html("排课时间冲突！");
						flag = false;
					}

				}
			});
		}
		if (classroom == "") {
			$("#errClassroom").html("请输入上课教室！");
			flag = false;
		}
		if (teacher == "") {
			$("#errTeacher").html("请选择授课教师！");
			flag = false;
		}
		/* $("#inschooltime").blur(function() {
			$.ajax({
				url : "Schedule_checkSchtime.action?schooltime=" + schooltime,
				// 数据发送方式
				type : "post",
				// 接受数据格式
				dataType : "json",
				async: false,
				// 要传递的数据
				// data :params ,
				// 回调函数，接受服务器端返回给客户端的值，即result值
				success : function(list) {
					if (list != null) {
						$("#errSchtime").html("排课时间冲突！");
						flag = false;
					}
				}
			});
		}) */
		if (flag == false) {
			return false;
		} else {
			alert("添加成功！");
			return true;
		}
	}
	function checkScId(){
		var schId=$("#sId").val();
		var sss=schId.replace(/ /g,'');	
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
	
	
	
	function checkUpdate() {
		$("#errCollege1").html("");
		$("#errMajor1").html("");
		$("#errCourse1").html("");
		$("#errGrade1").html("");
		$("#errClassInfo1").html("");
		$("#errSchtime1").html("");
		$("#errClassroom1").html("");
		$("#errTeacher1").html("");
		var flag = 1;
		var college = $("#college1").val();
		var major = $("#major1").val();
		var course = $("#xgcourseId").val();
		var grade = $("#xggrade").val();
		var classInfo = $("#xgclassInfo").val();
		var schooltime = $("#t6").val();
		
		var classroom = $("#t7").val();
		var teacher = $("#xgTeacher").val();
		if (college == "") {
			$("#errCollege1").html("请选择开设学院！");
			flag = false;
		}
		if (major == "") {
			$("#errMajor1").html("请选择专业！");
			flag = false;
		}
		if (course == "") {
			$("#errCourse1").html("请选择课程！");
			flag = false;
		}
		if (grade == "") {
			$("#errGrade1").html("请选上课年级！");
			flag = false;
		}
		if (classInfo == "") {
			$("#errClassInfo1").html("请选上课班级！");
			flag = false;
		}
		if (schooltime == "") {
			//alert("请输入上课时间！");
			$("#errSchtime1").html("请输入上课时间！");
			flag = false;
		} else {
		   var sch=$("#schtime").val();
           if(schooltime==sch){}
           else{
			$.ajax({
				url : "Schedule_checkSchtime.action?schooltime=" + schooltime,
				// 数据发送方式
				type : "post",
				// 接受数据格式
				dataType : "json",
				async : false,
				// 要传递的数据
				// data :params ,
				// 回调函数，接受服务器端返回给客户端的值，即result值
				success : function(list) {
					if (list != null) {

						$("#errSchtime1").html("排课时间冲突！");
						flag = false;
					}
				}
			});
		}}
		if (classroom == "") {
			$("#errClassroom1").html("请输入上课教室！");
			flag = false;
		}
		if (teacher == "") {
			$("#errTeacher1").html("请选择授课教师！");
			flag = false;
		}
		if (flag == false) {
			return false;
		} else {
			alert("修改成功！");
			return true;
		}
	}
	function tishi(){
		var r = window.confirm("是否删除该记录？");
        if(r){
        	alert("删除成功！");
        	return true;
        }
        else{
        	return false;
        }
	}
	function check() {
		var college = $("#college").val();
		var major = $("#major").val();
		if (college == "" || major == "") {
			alert("学院和专业必须同时选择！");
			return false;
		}
		return true;
	}
	function upInfo(t) {
		$("#upform").show();
		var id = $(t).parent().parent().children("td:eq(1)").html();
		$("#schId").val(id);
		var id1 = $("#schId").val();
		var coursename = $(t).parent().parent().children("td:eq(2)").html();
		var college = $(t).parent().parent().children("td:eq(3)").html();
		var majorname = $(t).parent().parent().children("td:eq(4)").html();
		var grade = $(t).parent().parent().children("td:eq(5)").html();
		var classname = $(t).parent().parent().children("td:eq(6)").html();
		var schooltime = $(t).parent().parent().children("td:eq(7)").html();
        
		schooltime = schooltime.replace(/ /g, "T");
		$("#schtime").val(schooltime);
		var classroom = $(t).parent().parent().children("td:eq(8)").html();
		var teaname = $(t).parent().parent().children("td:eq(9)").html();
		var modal = $("#myModal1");
		var coll = $("#college1 option").length;
		for (var i = 0; i < coll; i++) {
			if ($("#college1").get(0).options[i].text == college) {
				$("#college1").get(0).options[i].selected = true;
				var collId = $("#college1").val();
				$
						.ajax({
							url : "Major_findAll.action?collId=" + collId,
							// 数据发送方式
							type : "post",
							// 接受数据格式
							dataType : "json",
							// 要传递的数据
							// data :params ,
							// 回调函数，接受服务器端返回给客户端的值，即result值
							success : function(list2) {
								$("#major1").html("");
								$("#major1").append(
										'<option select="selected" value="">'
												+ '-请选择-' + '</option>');
								$.each(list2, function(i, value) {
									$("#major1").append(
											'<option value="'+ value.majorid +'">'
													+ value.majorname
													+ '</option>');
								});
								var maj = $("#major1 option").length;
								for (var i = 0; i < maj; i++) {
									if ($("#major1").get(0).options[i].text == majorname) {
										$("#major1").get(0).options[i].selected = true;
									}
								}
								var majorId = $("#major1").val();
								$
										.ajax({
											url : "Course_findByMajor.action?majorId1="
													+ majorId,
											// 数据发送方式
											type : "post",
											// 接受数据格式
											dataType : "json",
											// 要传递的数据
											// data :params ,
											// 回调函数，接受服务器端返回给客户端的值，即result值
											success : function(list4) {
												$("#xgcourseId").html("");
												$("#xgcourseId").append(
														'<option select="selected" value="">'
																+ '-请选择-'
																+ '</option>');
												$
														.each(
																list4,
																function(i,
																		value) {
																	$(
																			"#xgcourseId")
																			.append(
																					'<option value="'+ value.id +'">'
																							+ value.coursename
																							+ '</option>');
																});

												var cours = $("#xgcourseId option").length;
												for (var i = 0; i < cours; i++) {
													if ($("#xgcourseId").get(0).options[i].text == coursename) {
														$("#xgcourseId").get(0).options[i].selected = true;
													}
												}
											}
										});
							}
						});
			}
		}

		var classIn = $("#xgclassInfo option").length;
		for (var i = 0; i < classIn; i++) {
			if ($("#xgclassInfo").get(0).options[i].text == classname) {
				$("#xgclassInfo ").get(0).options[i].selected = true;
			}
		}
		var teaInfo = $("#xgTeacher option").length;
		for (var i = 0; i < teaInfo; i++) {
			if ($("#xgTeacher").get(0).options[i].text == teaname) {
				$("#xgTeacher ").get(0).options[i].selected = true;
			}
		}
		modal.find("#xggrade").val(grade);
		modal.find("#t6").val(schooltime);
		modal.find("#t7").val(classroom);
	};
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
					class="icon-home"></i> 选课系统后台管理</a> <a href="#" class="current">班级课表管理</a>
			</div>
			<div>
				<div style="margin-left:20px;margin-top:18px;color:blue">提示:学院和专业必须同时查询，为了提高选课效率，请同学们使用查询过滤功能。</div>
				<form action="Schedule_findByCondition.action" method="post"
					onsubmit="return check()">
					<table style="margin-left:20px;margin-top:5px">
						<tr>
							<td style="font-size:15px;color:red">开设学院：</td>
							<td><select
								style="width:140px;margin-top:10px;border-radius:15px"
								name="college" id="college">
									<option select="selected" value="">-请选择-</option>
									<s:iterator var="p" value="#session.clist">
										<option value="<s:property value="#p.collegeid" />"><s:property
												value="#p.collegename" /></option>
									</s:iterator>
							</select></td>
							<td style="width:55px"></td>
							<td style="font-size:15px;color:red">所属专业：</td>
							<td><select
								style="width:140px;margin-top:10px;border-radius:15px"
								name="major" id="major">
									<option select="selected" value="">-请选择-</option>
							</select></td>
							<td style="width:55px"></td>
							<td style="font-size:15px">上课年级:</td>
							<td><select
								style="width:140px;margin-top:10px;border-radius:15px"
								name="grade" id="grade">
									<option select="selected" value="">-请选择-</option>
									<option value="2014级">2014级</option>
									<option value="2015级">2015级</option>
									<option value="2016级">2016级</option>
									<option value="2017级">2017级</option>
							</select></td>
							<td style="width:55px"></td>
							<td style="font-size:15px">上课教室：</td>
							<td><input type="text" class="inputStyle"
								style="width:126px;margin-top:10px;border-radius:15px"
								name="classroom" id="classroom"></td>
							</td>
						</tr>
						<tr>
							<td style="font-size:15px">上课班级：</td>
							<td><select
								style="width:140px;margin-top:10px;border-radius:15px"
								name="classInfo" id="classInfo">
									<option select="selected" value="">-请选择-</option>
									<s:iterator var="p" value="#session.cllist">
										<option value="<s:property value="#p.classid" />"><s:property
												value="#p.classname" /></option>
									</s:iterator>
							</select></td>
							<td style="width:55px"></td>
							<td style="font-size:15px">课程名称：</td>
							<td><input type="text" class="inputStyle"
								style="width:126px;margin-top:10px;border-radius:15px"
								name="courseName" id="courseName"></td>
							<td style="width:55px"></td>
							<td style="font-size:15px">任课教师：</td>
							<td><input type="text" class="span11"
								style="width:126px;margin-top:10px;border-radius:15px"
								name="courseTeacher" id="courseTeacher"></td>
							<td style="width:55px"></td>
							<td><input type="submit" value="查询"
								style="border-radius:15px" id="su"/></td>
						</tr>
					</table>
				
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
							<h5>排课信息</h5>
						</div>
						<div class="widget-content nopadding">
							<div id="DataTables_Table_0_wrapper" class="dataTables_wrapper"
								role="grid">
								<div class="">
									<div id="DataTables_Table_0_length" class="dataTables_length"
										style="width:1200px;height:30px">

										<!-- 	<input type="text" 
											style="width:126px;border-radius:15px;margin-left:885px"> -->

										<div class="incr" style="width:1038px">
											<input type="button"
												style="border-radius:15px;height:25px;font-size:15px"
												class="btn btn-primary" id="inser" value="添加"
												data-toggle="modal" data-target="#myModal" /> <input
												style="border-radius:15px;height:25px;font-size:15px"
												class="btn btn-danger" type="button" value="批量删除"
												id="deleteAll" />
											<div style="float:right;margin-right:10px">
												<div class="search-box">
													<form class="searchform" method="post"
														action="Schedule_findByID.action" onsubmit="return checkScId()">
														<input type="text" placeholder="排课编号查询..." required=""
															name="schId" value="" id="sId"> <input type="submit"
															value="" >
													</form>
												</div>
												<div id="errID" style="display:none"><s:property value="message" /></div>
												<div id="errID1" style="display:none"><s:property value="message1" /></div>
				  							  <div id="errID2" style="display:none"><s:property value="message2" /></div>
											</div>
										</div>

									</div>
									<table class="table table-bordered data-table" id="tab">
										<thead>
											<tr>
												<th></th>
												<th>编号</th>
												<th>课程名称</th>
												<th>开设学院</th>
												<th>所属专业</th>
												<th>上课年级</th>
												<th>上课班级</th>
												<th>上课时间</th>
												<th>上课教室</th>
												<th>任课教师</th>
												<th></th>
											</tr>
										</thead>
										<tbody>
											<s:iterator var="p" value="#session.slist">
												<tr>
													<td style="text-align:center"><input type="checkbox"
														name="allDel" /></td>
													<td style="text-align:center"><s:property
															value="#p.id" /></td>
													<td style="text-align:center"><s:property
															value="#p.course.coursename" /></td>
													<td style="text-align:center"><s:property
															value="#p.collegeName" /></td>
													<td style="text-align:center"><s:property
															value="#p.major.majorname" /></td>
													<td style="text-align:center"><s:property
															value="#p.classinfo.grade" /></td>
													<td style="text-align:center"><s:property
															value="#p.classinfo.classname" /></td>
													<td style="text-align:center"><s:property
															value="#p.schooltime" /></td>
													<td style="text-align:center"><s:property
															value="#p.classroom" /></td>
													<td style="text-align:center"><s:property
															value="#p.teacher.teaname" /></td>
													<!-- 编辑啊啊啊啊啊啊啊啊啊啊啊 -->
													<td style="text-align:center"><a class="tip"
														onclick="upInfo(this)" data-toggle="modal"
														data-target="#myModal1"><i class="icon-pencil"></i></a>&nbsp;&nbsp;
														<a class="tip"
														href="Schedule_delete.action?id=<s:property value="#p.id" />"
														data-original-title="Delete" onclick="return tishi()"><i class="icon-remove"></i></a>
													</td>
												</tr>
											</s:iterator>
										</tbody>
									</table>
								    <div id="schtime" style="display:none"></div>
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
        	        	<a href="/CSManagement/Schedule_findByCondition.action?page=<s:property value="page-1"/>">上一页</a>
        	        </s:else>
        	        <s:iterator begin="1" end="totalPage" var="k">
        	        	<s:if test="page==#k">
        	        		<a href="/CSManagement/Schedule_findByCondition.action?page=<s:property value="#k"/>" class="current_page"><s:property value="#k"/></a>
        	        	</s:if>
        	        	<s:else>
        	        		<a href="/CSManagement/Schedule_findByCondition.action?page=<s:property value="#k"/>"><s:property value="#k"/></a>
        	        	</s:else>
        	        </s:iterator>
        	        <s:if test="page==totalPage">
        	        	<a href="#">下一页</a>
        	        </s:if>
        	        <s:else>
        	        	<a href="/CSManagement/Schedule_findByCondition.action?page=<s:property value="page+1"/>">下一页</a>
        	        </s:else>
                </div>
						
					</div>
				</div>
			</div>
		</div>
		<!-- <div class="fg-toolbar ui-toolbar ui-widget-header ui-corner-bl ui-corner-br ui-helper-clearfix" style="height:20px">
		  <div class="dataTables_filter" id="DataTables_Table_0_filter"></div>
		</div> -->
		<!--End-Action boxes-->
		<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">添加排课信息</h4>
					</div>
					<form action="Schedule_save.action" method="post"
						style="display:none" id="inform" onsubmit="return checkInfo()">
						<table style="margin-left:150px">
							<tr>
								<td style="font-size:15px">开设学院:</td>
								<td><select
									style="width:195px;margin-top:10px;border-radius:15px;margin-left:10px"
									name="incollege" id="incollege">
										<option select="selected" value="">-请选择-</option>
										<s:iterator var="p" value="#session.clist">
											<option value="<s:property value="#p.collegeid" />"><s:property
													value="#p.collegename" /></option>
										</s:iterator>
								</select> <!-- <input type="text" id="t2" name="college"
									class="increase" /> --></td>
								<td><div
										style="width:110px;color:red;font-size:13px;padding-left:5px"
										id="errCollege"></div></td>
							</tr>
							<tr>
								<td style="font-size:15px">所属专业:</td>
								<td><select
									style="width:195px;margin-top:10px;border-radius:15px;margin-left:10px"
									name="inmajor" id="inmajor">
										<option select="selected" value="">-请选择-</option>
								</select></td>
								<td><div
										style="width:110px;color:red;font-size:13px;padding-left:5px"
										id="errMajor"></div></td>
							</tr>
							<tr>
								<td style="font-size:15px">课程名称:</td>
								<td><select
									style="width:195px;margin-top:10px;border-radius:15px;margin-left:10px"
									name="incourseId" id="incourseId">
										<option select="selected" value="">-请选择-</option>
								</select> <!-- <input type="text" id="t1" name="courseId" id="xgcourseId"
									class="increase" /> --></td>
								<td><div
										style="width:110px;color:red;font-size:13px;padding-left:5px"
										id="errCourse"></div></td>
							</tr>
							<tr>
								<td style="font-size:15px">上课年级:</td>
								<td><select
									style="width:195px;margin-top:10px;border-radius:15px;margin-left:10px"
									name="grade" id="ingrade">
										<option select="selected" value="">-请选择-</option>
										<option value="2014级">2014级</option>
										<option value="2015级">2015级</option>
										<option value="2016级">2016级</option>
										<option value="2017级">2017级</option>
								</select></td>
								<!-- <input type="text" id="t4" name="grade"
									class="increase" /> -->
								<td><div
										style="width:110px;color:red;font-size:13px;padding-left:5px"
										id="errGrade"></div></td>
							</tr>
							<tr>
								<td style="font-size:15px">上课班级:</td>
								<td>
									<!-- <input type="text" id="t5" name="classId"
									class="increase" /> --> <select
									style="width:195px;margin-top:10px;border-radius:15px;margin-left:10px"
									name="classInfo" id="inclassInfo">
										<option select="selected" value="">-请选择-</option>
										<s:iterator var="p" value="#session.cllist">
											<option value="<s:property value="#p.classid" />"><s:property
													value="#p.classname" /></option>
										</s:iterator>
								</select>
								</td>
								<td><div
										style="width:110px;color:red;font-size:13px;padding-left:5px"
										id="errClassInfo"></div></td>
							</tr>
							<tr>
								<td style="font-size:15px">上课时间:</td>
								<td><input type="datetime-local" id="inschooltime"
									name="schooltime" class="increase" style="border-radius:15px"
									value="2015-09-24 13:59" /></td>
								<td><div
										style="width:110px;color:red;font-size:13px;padding-left:5px"
										id="errSchtime"></div></td>
							</tr>
							<!-- <tr>
							  <td></td>
							  <td><div style="width:100px;color:red" id="errSchtime"></div></td>
							</tr> -->
							<tr>
								<td style="font-size:15px">上课教室:</td>
								<td><input style="border-radius:15px" type="text"
									id="inclassroom" name="classroom" class="increase" /></td>
								<td><div
										style="width:110px;color:red;font-size:13px;padding-left:5px"
										id="errClassroom"></div></td>
							</tr>
							<tr>
								<td style="font-size:15px">任课教师:</td>
								<td><select
									style="width:195px;margin-top:10px;border-radius:15px;margin-left:10px"
									name="teaId" id="inTeacher">
										<option select="selected" value="">-请选择-</option>
										<s:iterator var="p" value="#session.tealist">
											<option value="<s:property value="#p.id" />"><s:property
													value="#p.teaname" /></option>
										</s:iterator>
								</select> <!-- <input style="border-radius:15px" type="text" id="t8"
									name="teaId" class="increase" /> --></td>
								<td><div
										style="width:110px;color:red;font-size:13px;padding-left:5px"
										id="errTeacher"></div></td>
							</tr>
						</table>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal" style="border-radius:15px">关闭</button>
							<input type="submit" id="conIncrease" style="border-radius:15px"
								class="btn btn-primary" value="确认添加" />
						</div>
					</form>
				</div>
			</div>
		</div>


		<div class="modal fade" id="myModal1" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">修改排课信息</h4>
					</div>
					<form action="Schedule_update.action" method="post"
						style="display:none" id="upform" onsubmit="return checkUpdate()">
						<input id="schId" value="" name="schId" style="display:none" />
						<table style="margin-left:150px">
							<tr>
								<td style="font-size:15px">开设学院:</td>
								<td><select
									style="width:195px;margin-top:10px;border-radius:15px;margin-left:10px"
									name="college1" id="college1">
										<option select="selected" value="">-请选择-</option>
										<s:iterator var="p" value="#session.clist">
											<option value="<s:property value="#p.collegeid" />"><s:property
													value="#p.collegename" /></option>
										</s:iterator>
								</select> <!-- <input type="text" id="t2" name="college"
									class="increase" /> --></td>
								<td><div
										style="width:110px;color:red;font-size:13px;padding-left:5px"
										id="errCollege1"></div></td>
							</tr>
							<tr>
								<td style="font-size:15px">所属专业:</td>
								<td><select
									style="width:195px;margin-top:10px;border-radius:15px;margin-left:10px"
									name="major1" id="major1">
										<option select="selected" value="">-请选择-</option>
								</select></td>
								<td><div
										style="width:110px;color:red;font-size:13px;padding-left:5px"
										id="errMajor1"></div></td>
							</tr>
							<tr>
								<td style="font-size:15px">课程名称:</td>
								<td><select
									style="width:195px;margin-top:10px;border-radius:15px;margin-left:10px"
									name="courseId" id="xgcourseId">
										<option select="selected" value="">-请选择-</option>
								</select> <!-- <input type="text" id="t1" name="courseId" id="xgcourseId"
									class="increase" /> --></td>
								<td><div
										style="width:110px;color:red;font-size:13px;padding-left:5px"
										id="errCourse1"></div></td>
							</tr>
							<tr>
								<td style="font-size:15px">上课年级:</td>
								<td><select
									style="width:195px;margin-top:10px;border-radius:15px;margin-left:10px"
									name="grade" id="xggrade">
										<option select="selected" value="">-请选择-</option>
										<option value="2014级">2014级</option>
										<option value="2015级">2015级</option>
										<option value="2016级">2016级</option>
										<option value="2017级">2017级</option>
								</select></td>
								<!-- <input type="text" id="t4" name="grade"
									class="increase" /> -->
								<td><div
										style="width:110px;color:red;font-size:13px;padding-left:5px"
										id="errGrade"></div></td>
							</tr>
							<tr>
								<td style="font-size:15px">上课班级:</td>
								<td>
									<!-- <input type="text" id="t5" name="classId"
									class="increase" /> --> <select
									style="width:195px;margin-top:10px;border-radius:15px;margin-left:10px"
									name="classInfo" id="xgclassInfo">
										<option select="selected" value="">-请选择-</option>
										<s:iterator var="p" value="#session.cllist">
											<option value="<s:property value="#p.classid" />"><s:property
													value="#p.classname" /></option>
										</s:iterator>
								</select>
								</td>
								<td><div
										style="width:110px;color:red;font-size:13px;padding-left:5px"
										id="errClassInfo1"></div></td>
							</tr>
							<tr>
								<td style="font-size:15px">上课时间:</td>
								<td>
									<%-- <div class="control-group">
										<label class="control-label">Date Picker (mm-dd)</label>
										<div class="controls">
											<div data-date="12-02-2012"
												class="input-append date datepicker">
												<input type="text" value="12-02-2012"
													data-date-format="mm-dd-yyyy" class="span11"> <span
													class="add-on"><i class="icon-th"></i></span>
											</div>
										</div>
									</div> --%> <input type="datetime-local" id="t6"
									name="schooltime" class="increase" style="border-radius:15px"
									value="2015-09-24 13:59" />
								</td>
								<td><div
										style="width:110px;color:red;font-size:13px;padding-left:5px"
										id="errSchtime1"></div></td>
							</tr>
							<tr>
								<td style="font-size:15px">上课教室:</td>
								<td><input style="border-radius:15px" type="text" id="t7"
									name="classroom" class="increase" /></td>
								<td><div
										style="width:110px;color:red;font-size:13px;padding-left:5px"
										id="errClassroom1"></div></td>
							</tr>
							<tr>
								<td style="font-size:15px">任课教师:</td>
								<!-- tealist -->
								<td><select
									style="width:195px;margin-top:10px;border-radius:15px;margin-left:10px"
									name="teaId" id="xgTeacher">
										<option select="selected" value="">-请选择-</option>
										<s:iterator var="p" value="#session.tealist">
											<option value="<s:property value="#p.id" />"><s:property
													value="#p.teaname" /></option>
										</s:iterator>
								</select> <!-- <input style="border-radius:15px" type="text" id="t8"
									name="teaId" class="increase" /> --></td>
								<td><div
										style="width:110px;color:red;font-size:13px;padding-left:5px"
										id="errTeacher1"></div></td>
							</tr>
						</table>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal" style="border-radius:15px">关闭</button>
							<input type="submit" id="conUpdate" style="border-radius:15px"
								class="btn btn-primary" value="提交更改" />
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<%-- <script src="js/fullcalendar.min.js"></script> --%>
	<script src="js/excanvas.min.js"></script>
	<script src="js/jquery.ui.custom.js"></script>
	<script src="js/jquery.flot.min.js"></script>
	<script src="js/jquery.flot.resize.min.js"></script>
	<script src="js/jquery.peity.min.js"></script>
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
	<%-- <script src="js/jquery.dataTables.min.js"></script> --%>
	<%-- <script src="js/matrix.tables.js"></script> --%>
	<script src="js/bootstrap-colorpicker.js"></script>
	<script src="js/jquery.toggle.buttons.html"></script>
	<script src="js/matrix.form_common.js"></script>
	<script src="js/wysihtml5-0.3.0.js"></script>
	<%-- <script src="js/bootstrap-wysihtml5.js"></script> --%>
	<%-- <script src="js/bootstrap-datepicker.js"></script> --%>
	<%-- <script src="js/bootstrap.min.js"></script> --%>

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