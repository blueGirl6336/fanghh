//package snippet;
//
//public class Snippet {
//	<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
//	<html xmlns="http://www.w3.org/1999/xhtml">
//	<head>
//	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
//	<link rel="stylesheet" type="text/css" href="css/CommonHeadAndLeft.css">
//	<link rel="stylesheet" type="text/css" href="css/EnterCustomer.css">
//	<title>录入客户</title>
//	<script language="javascript" type="text/javascript">
//	function time(){
//		var Daynames=new Array("星期日","星期一","星期二","星期三","星期四","星期五","星期六");
//		var otime=new Date();
//		document.getElementById('week').innerHTML=Daynames[otime.getDay()];
//		document.getElementById('day').innerHTML=otime.getFullYear()+"年"+(otime.getMonth()+1)+"月"+otime.getDate()+"日";
//	}
//	</script>
//	<script type="text/javascript" src="jquery-1.12.2.min.js"></script>
//	<script>
//	$(function(){
//		$(".Check").click(function(){
//			$(".ToolTip").show();
//		});
//		$(".toDetails").click(function(){
//			location.href="#";
//		});
//		$(".continue").click(function(){
//			window.location.reload();
//		});
//	});
//	$.ajax({
//			url:"pass/inputCustomers.do",
//			data:{
//				$(".name_value").val(customerName),
//				$(".phone_value").val(customerPhone),
//				$(".style_value").val(propertyType),
//				$(".square_value").val(areaDemand),
//				$(".want_value").val(buildingId),
//				$(".instead_value").val(isSubstitute),
//				$(".partner_value").val(isCompany),
//				$(".note_value").val(remark)
//			},
//			type:"post",
//			dataType:"json",
//			success:function(data){
//				alert(customerName);
//			}
//		});
//	$.ajax({
//			url:"pass/inputCustomers.do",
//			data:{
//				$(".name_value").val(customerName),
//				$(".phone_value").val(customerPhone),
//				$(".style_value").val(propertyType),
//				$(".square_value").val(areaDemand),
//				$(".want_value").val(buildingId),
//				$(".instead_value").val(isSubstitute),
//				$(".partner_value").val(isCompany),
//				$(".note_value").val(remark)
//			},
//			type:"post",
//			dataType:"json",
//			success:function(data){
//				$(".Check").click(function(){
//					alert(customerName);
//				});
//			}
//		});
//	</script>
//	</head>
//	
//	<body onload="time()">
//		<div class="header comWidth">
//			<div class="logo fl" ><img src="image/nav_logo.png" class="logo_picture"  ></div>
//			<div class="place fl"><span>（山东省威海市）区域代理PC端</span></div>
//			<ul class="menu fr">
//				<li><div><a href="#" class="exit">退出系统</a></div></li>
//				<li><div class="week" id="week"></div></li>
//				<li><div class="day" id="day"></div></li>
//			</ul>
//			<div class="head_bottom fl">
//				<img src="image/nav_splitline.png">
//			</div>
//		</div>
//	
//		<div class="mainbody comWidth">
//			<div class="leftmenu fl">
//				<ul class="leftlist">
//					<li class="manage">客户管理</li>
//					<li><div class="list"><a href="#">客户列表</a></div></li>
//					<li><div class="typeIn active"><a href="#" class="active">录入客户</a></div></li>
//					<li class="wallet">钱包</li>
//					<li><div class="myWallet"><a href="#">我的钱包</a></div></li>
//					<li><div class="bandage"><a href="#">绑定银行卡</a></div></li>
//					<li class="personal">个人中心</li>
//					<li><div class="setCenter"><a href="#">设置中心</a></div></li>
//				</ul>
//			</div>
//			<div class="bodytitle"><span>录入客户</span></div>
//			<div class="bodycontent">
//				<div class="contentHeader">
//					<span>客户详情</span>
//				</div>
//				<div class="bottomBorder"><span></span></div>
//				<div class="details">
//					<form>
//					<div class="Name">
//						<div class="name fl"><span>客户姓名：</span></div>
//						<div><input type="text" class="name_value"></div>
//					</div>
//					<div class="Phone">
//						<div class="phone fl"><span>客户电话：</span></div>
//						<div><input type="text"class="phone_value"></div>
//					</div>
//					<div class="Want">
//						<div class="want fl"><span>购房意向：</span></div>
//						<div class="want_value">
//							<select name="chooseBuiding">
//								<option value="Building">请选择推荐楼盘</option>
//								<option value="jiashangfu">佳尚府</option>
//								<option value="wenquankangcheng">温泉康城</option>
//								<option value="jinhouxihaimingju">金猴西海名居</option>
//							</select>
//						</div>
//					</div>
//					<div class="Style">
//						<div class="style fl"><span>物业类型：</span></div>
//						<div class="style_value">
//							<select name="chooseType">
//								<option value="Type">请选择物业类型（选填）</option>
//								<option value="zhuzhai">住宅</option>
//								<option value="gongyu">公寓</option>
//								<option value=" bieshu">别墅</option>
//								<option value="dujiacun">度假村</option>
//							</select>
//						</div>
//					</div>
//					<div class="Square">
//						<div class="square fl"><span>需求面积：</span></div>
//						<div><input type="text"  class="square_value" placeholder="请输入需求面积（选填）"><span class="unit">平方米</span></div>
//					</div>
//					<div class="Instead">
//						<div class="instead fl"><span>是否可能他人代看房：</span></div>
//						<div class="instead_value"><form>
//							<input type="radio" name="whetherInstead" value="y"><span class="y">是</span>
//							<input type="radio" name="whetherInstead" value="n"><span class="n">否</span></form>
//						</div>
//					</div>
//					<div class="Partner">
//						<div class="partner fl"><span>是否需要陪同看房：</span></div>
//						<div class="partner_value"><form>
//							<input type="radio" name="whetherPart" value="y"><span class="y">是</span>
//							<input type="radio" name="whetherPart" value="n"><span class="n">否</span></form>
//						</div>
//					</div>
//					<div class="Note">
//						<div class="note fl"><span>备注：</span></div>
//						<div><input type="text" class="note_value"></div>
//					</div>
//					<div class="Check fl"><a href="#"><span>确定</span></a></div>
//					
//					</form>
//				</div>
//				<div class="ToolTip fl">
//					<div class="tipTitle">温馨提示</div>
//					<div class="tipBody">
//						<div class="tip">该客户信息已录用成功！请到客户列表查看。</div>
//						<div class="toDetails fl"><a href="#">查看客户详情</a></div>
//						<div class="continue fl"><a href="#">继续录入</a></div>
//					</div>
//				</div>
//			</div>
//		</div>
//	</body>
//	</html>
//}
//
