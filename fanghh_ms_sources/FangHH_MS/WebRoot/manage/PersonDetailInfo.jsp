<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%
	ResourceBundle res = ResourceBundle.getBundle("staticServer");
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>个人基本信息</title>
<style type="text/css">
body {
	font-size: 14px;
}

table {
	width: 970px;
	border: 1px solid black;
	border-bottom: none;
	border-left: none;
	border-top: none;
	border-collapse: collapse;
	border-spacing: 0;
}

table td,table th {
	border-bottom: 1px solid black;
	border-left: 1px solid black;
	padding: 8px 1px;
	text-align: center;
}

.doubleLineHeader td,.doubleLineHeader th {
	border-bottom: 1px dotted black;
}

.columnHeader {
	height: 28px;
	font-size: 19px;
	background-color: #ddd;
	text-align: left;
}

#baseinfoInTheLeft table {
	width: 750px;
}

#baseinfoInTheLeft,#baseinfoInTheRight {
	float: left;
}

#baseinfoInTheRight table {
	width: 220px;
	border-right: 1px solid black;
}

#baseinfoInTheRight table tr {
	height: 230px;
}

#baseinfoInTheRight table tr td {
	border-left: none;
}

.columnRemark {
	font-size: 14px;
}

.pageBreak {
	page-break-after: always;
}

@media print {
	body {
		margin: 0;
		padding: 0;
	}
	.button {
		display: none;
	}
}
</style>
</head>

<body>
	<input class="button" type="button" onclick="window.print();"
		name="name" value="打印全部" />
	
	<c:forEach var="each" items="${resume}" varStatus="status">
	<input class="button" type="button" onclick="location.href='<%=basePath %>manage/excel/single/${each.baseInfo.empNo}'" value="导出${each.baseInfo.name}的简历" />
		<table style="border-top:1px solid black;">
			<tr>
				<th width="33%"></th>
				<th width="33%" style="border-left:none; font-size: 22px; height:32px;">${each.baseInfo.name}
				</th>
				<th width="33%" style="border-left:none;vertical-align: bottom;text-align: right; padding-right: 10px;">更新日期：${each.baseInfo.update_time}</th>
			</tr>
		</table>
		<table>
			<tr>
				<th class="columnHeader">一、基本信息</th>
			</tr>
		</table>
		<div id="baseinfoInTheLeft">
			<table>
				<tr>
					<th width="80">姓名</th>
					<td colspan="2">${each.baseInfo.name}</td>
					<th width="100">性别</th>
					<td width="110">${each.baseInfo.sex}</td>
					<th width="80">民族</th>
					<td width="185">${each.baseInfo.ethnic}</td>
				</tr>
				<tr>
					<th >出生日期</th>
					<td width="115">${each.baseInfo.dob}</td>
					<th width="80">籍贯</th>
					<td colspan="2">${each.baseInfo.hometown}</td>
					<th >出生地</th>
					<td >${each.baseInfo.birthPlace}</td>
				</tr>
				<tr>
					<th >工号</th>
					<td >${each.baseInfo.empNo}</td>
					<th colspan="2">身份证号码</th>
					<td colspan="3">${each.baseInfo.idCard}</td>
				</tr>
				<tr>
					<th>最高学历</th>
					<td>${each.baseInfo.lastEducation}</td>
					<th>培养方式</th>
					<td>${each.baseInfo.lastEducationTrainType}</td>
					<th>毕业学校</th>
					<td colspan="2">${each.baseInfo.lastGraduateUnivercity}</td>
				</tr>
				<tr>
					<th>最高学位</th>
					<td>${each.baseInfo.lastDegree}</td>
					<th>培养方式</th>
					<td>${each.baseInfo.lastDegreeTrainType}</td>
					<th>毕业学校</th>
					<td colspan="2">${each.baseInfo.lastDegreeOrg}</td>
				</tr>
				<tr>
					<th>中共党员</th>
					<td><c:if test="${each.baseInfo.cpc == true}">
				是
			</c:if> <c:if test="${each.baseInfo.cpc == false}">
				否
			</c:if>
					</td>
					<th>入党日期</th>
					<td>${each.baseInfo.cpc_join_date}</td>
					<th>现任党内职务</th>
					<td colspan="2">${each.baseInfo.cpc_post}</td>
				</tr>
				<tr>
					<th>民主党派</th>
					<td>${each.baseInfo.democraticPartie}</td>
					<th>加入日期</th>
					<td>${each.baseInfo.dp_join_date}</td>
					<th>现任党内职务</th>
					<td colspan="2">${each.baseInfo.dp_post}</td>
				</tr>
			</table>
		</div>
		<div id="baseinfoInTheRight">
			<table>
				<tr>
					<td><img width="150px" height="200px" src="<%=basePath %>${each.personPhoto.photoPath}"></td>
				</tr>
			</table>
		</div>
		<table>
			<tr>
				<th width="101">参加工作年月</th>
				<td width="159">${each.baseInfo.dateOfStartWork}</td>
				<th width="96">本校入职日期</th>
				<td width="128">${each.baseInfo.dateOfEntry}</td>
				<th width="91">编制属性</th>
				<td width="261" colspan="3">${each.baseInfo.quota_type}</td>
			</tr>
			<tr>
				<th >所属部门</th>
				<td colspan="2">${each.baseInfo.department}</td>
				<th >二级单位</th>
				<td width="100" colspan="2">${each.baseInfo.sub_unit}</td>
				<th width="80">双基地</th>
				<td width="80">${each.baseInfo.doubleEmp?"是":"否"}</td>
			</tr>
			<tr>
				<th >岗位类型</th>
				<td colspan="2">${each.baseInfo.job_type}</td>
				<th >教师类型</th>
				<td colspan="4">${each.baseInfo.teacher_type}</td>
			</tr>
			<tr>
				<th >专业技术职务</th>
				<td colspan="2">${each.baseInfo.tech_post}</td>
				<th >专业技术级</th>
				<td colspan="4">${each.baseInfo.tech_grade}</td>
			</tr>
			<tr>
				<th>管理职务</th>
				<td colspan="2">${each.baseInfo.manage_post}</td>
				<th>职员职级</th>
				<td colspan="4">${each.baseInfo.manage_grade}</td>
			</tr>
			<tr>
				<th>工勤职务</th>
				<td colspan="2">${each.baseInfo.service_grade}</td>
				<th>工勤技术级别</th>
				<td colspan="4">${each.baseInfo.service_post}</td>
			</tr>
		</table>
		<table>
			<tr>
				<th colspan="7" align="left" class="columnHeader">二、联系方式</th>
			</tr>
			<tr>
				<th width="120">办公电话</th>
				<td width="240">${each.contact.office_phone}</td>
				<th width="77">家庭电话</th>
				<td width="240" colspan="2">${each.contact.home_phone}</td>
				<th width="76">移动电话</th>
				<td width="240">${each.contact.mobile}</td>
			</tr>
			<tr>
				<th >E-mail</th>
				<td colspan="2">${each.contact.email}</td>
				<th width="120">邮政编码</th>
				<td colspan="3">${each.contact.zipCode}</td>
			</tr>
			<tr>
				<th >办公地址</th>
				<td colspan="6" >${each.contact.office_addr}</td>
			</tr>
			<tr>
				<th>家庭住址</th>
				<td colspan="6">${each.contact.home_addr}</td>
			</tr>
			<tr>
				<th >紧急联系人</th>
				<td colspan="2">${each.contact.emergency_contact}</td>
				<th >联系人单位</th>
				<td colspan="3">${each.contact.emergency_unit}</td>
			</tr>
			<tr>
				<th>紧急联系人电话</th>
				<td colspan="6">${each.contact.emergency_phone}</td>
			</tr>
		</table>

		<table>
			<tr>
				<th colspan="7" class="columnHeader">三、主要家庭成员<span
					class="columnRemark">（包括配偶、子女、父母等）</span></th>
			</tr>
			<tr>
				<th width="67">姓名</th>
				<th width="82">关系</th>
				<th width="126">出生年月</th>
				<th width="284">工作单位</th>
				<th width="204">职务</th>
				<th width="73">学历</th>
				<th width="73">备注</th>
			</tr>
			<c:if test="${each.familyMemebers == null}">
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
			</c:if>
			<c:forEach var="fm" items="${each.familyMemebers}" varStatus="status">
				<tr>
					<c:choose>
						   <c:when test="${(fn:contains(fm.employer,'哈尔滨工业大学') || fn:contains(fm.employer,'哈工大')) && fm.relationship=='配偶'}">
						   		<td><a href="<%=basePath %>report/resume/personDetailInfo?empNo=${fm.empNo}" target="_blank">${fm.name}</a></td>
						   </c:when>  
						   <c:otherwise>
						   		<td>${fm.name}</td>
						   </c:otherwise>  
					</c:choose>
					<td>${fm.relationship}</td>
					<td>${fm.dateOfBirth}</td>
					<td>${fm.employer}</td>
					<td>${fm.post}</td>
					<td>${fm.education}</td>
					<td>${fm.remark}</td>
				</tr>
			</c:forEach>
		</table>

		<table>
			<tr>
				<th colspan="5" class="columnHeader">四、工作经历<span
					class="columnRemark">（含国内、国外所有工作经历，包括博士后研究及其他形式的工作）</span></th>
			</tr>
			<tr>
				<th>起止年月</th>
				<th>工作单位</th>
				<th>院/系/部门</th>
				<th>管理/技术职务</th>
				<th>备注</th>
			</tr>
			<c:if test="${each.workExperiences == null}">
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
			</c:if>
			<c:forEach var="we" items="${each.workExperiences}"
				varStatus="status">
				<tr>
					<td><c:choose>
						   <c:when test="${we.we_from==''||we.we_from==null}">
						   		<c:out value="0000/00/00 "></c:out>
						   </c:when>  
						   <c:otherwise>
						   		${we.we_from}
						   </c:otherwise>  
						</c:choose>-
						<c:choose>
						   <c:when test="${we.we_to==''||we.we_to==null}">
						   		<c:out value="现在 "></c:out>
						   </c:when>  
						   <c:otherwise>
						   		${we.we_to}
						   </c:otherwise>  
						</c:choose>
					</td>
					<td>${we.employer}</td>
					<td>${we.sub_unit}</td>
					<td>${we.manage_post}/${we.tech_post}</td>
					<td>${we.remark}</td>
				</tr>
			</c:forEach>
		</table>
		<table>
			<tr>
				<th colspan="7" class="columnHeader">五、学习经历<span
					class="columnRemark">（含国内、国外所有工作经历，包括博士后研究及其他形式的工作）</span></th>
			</tr>
			<tr class="doubleLineHeader">
				<th>起止年月</th>
				<th>学校</th>
				<th>院系</th>
				<th>专业</th>
				<th>学历</th>
				<th>学位</th>
				<th>培养方式</th>
			</tr>
			<tr>
				<th>学校（校区）地址</th>
				<th>学科门类</th>
				<th>一级学科</th>
				<th>二级学科</th>
				<th>学历日期</th>
				<th>学位日期</th>
				<th>备注</th>
			</tr>
			<c:if test="${each.educationBackgrounds == null}">
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
			</c:if>
			<c:forEach var="eb" items="${each.educationBackgrounds}"
				varStatus="status">
				<tr class="doubleLineHeader">
					<td><c:choose>
						   <c:when test="${eb.eb_from==''||eb.eb_from==null}">
						   		<c:out value="0000/00/00"></c:out>
						   </c:when>  
						   <c:otherwise>
						   		${eb.eb_from}
						   </c:otherwise>  
						</c:choose>-
						<c:choose>
						   <c:when test="${eb.eb_to==''||eb.eb_to==null}">
						   		<c:out value="0000/00/00 "></c:out>
						   </c:when>  
						   <c:otherwise>
						   		${eb.eb_to}
						   </c:otherwise>  
						</c:choose>
					</td>
					<td>${eb.university}</td>
					<td>${eb.school}</td>
					<td>${eb.major}</td>
					<td>${eb.education}</td>
					<td>${eb.degree}</td>
					<td>${eb.train_type}</td>
				</tr>
				<tr>
					<td>${eb.university_address}</td>
					<td>${eb.disciplineGroup}</td>
					<td>${eb.firstDescipline}</td>
					<td>${eb.secondDescipline}</td>
					<td>${eb.edu_date}</td>
					<td>${eb.issue_date}</td>
					<td>${eb.remark}</td>
				</tr>
			</c:forEach>
		</table>

		<table border="0" cellspacing="0" cellpadding="0" style="border-collapse:collapse;" rules="none">
			<tr>
				<th colspan="6" class="columnHeader">六、专业技术职务信息<span
					class="columnRemark">（含工作经历中技术岗位职务、职级所有信息）</span>
				</th>
			</tr>
			<tr>
				<th width="200">职务起止日期</th>
				<th>聘任单位</th>
				<th>院/系/部门</th>
				<th>技术职务</th>
				<th>职务等级</th>
				<!-- <th>技术等级</th>
				<th>技术等级日期</th> -->
				<th>备注</th>
			</tr>

			<c:if test="${each.professionals == null}">
				<tr>
					<td width="200">&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<!-- <td>&nbsp;</td>
					<td>&nbsp;</td> -->
					<td>&nbsp;</td>
				</tr>
			</c:if>
			<c:forEach var="p" items="${each.professionals}" varStatus="status">
				<tr>
					<td width="200">
						<c:choose>
						   <c:when test="${p.postDate==''||p.postDate==null}">
						   		<c:out value="0000/00/00"></c:out>
						   </c:when>  
						   <c:otherwise>
						   		${p.postDate}
						   </c:otherwise>  
						</c:choose>-${p.upToPresent?"现在":((p.postDateTo==''||p.postDateTo==null)?'0000/00/00':p.postDateTo)}</td>
					<td>${p.employer}</td>
					<td>${p.sub_unit}</td>
					<td>${p.post=='其他'?p.remark:p.post}</td>
					<td>${p.post_class}</td>
					<%-- <td>${p.pat_class}</td>
					<td>${p.employDate}</td> --%>
					<td>${p.post=='其他'?'':p.remark}</td>
				</tr>
			</c:forEach>
			<c:choose>
			   <c:when test="${fn:length(each.professionalGrades)==0}">
			   </c:when>  
			   <c:otherwise>
			   		<tr  height="10px" style="line-height:10px">
						<td colspan="6" style="line-height:10px"></td>
					</tr>
					<tr>
						<td colspan="6" style="padding:0px">
							<table border="0" cellspacing="0" cellpadding="0" style="border-collapse: collapse;border-width:0px; border-style:hidden;" frame="void">
								<tr class="doubleLineHeader">
									<td width="80" style="font-weight:bold;">分级日期</td>
									<c:forEach var="p" items="${each.professionalGrades}" varStatus="status">
										<td width="100">${p.employDate}</td>
									</c:forEach>
									<c:choose>
										<c:when test="${(fn:length(each.professionalGrades))>7}">
								   		</c:when>  
									    <c:otherwise>
									      <c:set var="property1" value="${7-fn:length(each.professionalGrades)}" />
											<c:forEach var ="i" begin="1" end="${property1}">
												<td width="100"></td>
											</c:forEach>
									    </c:otherwise>
								    </c:choose>
								</tr>
								<tr>
									<td width="80" style="font-weight:bold;">技术等级</td>
									<c:forEach var="p" items="${each.professionalGrades}" varStatus="status">
										<td width="100">${p.pat_class}</td>
									</c:forEach>
									<c:choose>
										<c:when test="${(fn:length(each.professionalGrades))>7}">
								   		</c:when>  
									    <c:otherwise>
									      <c:set var="property2" value="${7-fn:length(each.professionalGrades)}" />
											<c:forEach var ="i" begin="1" end="${property2}">
												<td width="100"></td>
											</c:forEach>
									    </c:otherwise>
								    </c:choose>
								</tr>
							</table>
						</td>
					</tr>
			   </c:otherwise>  
			</c:choose>
		</table>
		<table border="0" cellspacing="0" cellpadding="0" style="border-collapse:collapse;" rules="none">
			<tr>
				<th colspan="6" class="columnHeader">七、管理职务信息<span
					class="columnRemark">（含工作经历中管理岗位职务、职级所有信息）</span>
				</th>
			</tr>
			<tr>
				<th width="200">职务起止日期</th>
				<th width="245">聘任单位</th>
				<th width="245">院/系/单位</th>
				<th width="100">管理职务</th>
				<th width="100">职务等级</th>
				<!-- <th width="100">职员职级</th>
				<th width="150">管理职级日期</th> -->
				<th width="70">备注</th>
			</tr>

			<c:if test="${each.managements == null}">
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<!-- <td>&nbsp;</td>
					<td>&nbsp;</td> -->
					<td>&nbsp;</td>
				</tr>
			</c:if>
			<c:forEach var="m" items="${each.managements}" varStatus="status">
				<tr>
					<td><c:choose>
						   <c:when test="${m.post_from==''||m.post_from==null}">
						   		<c:out value="0000/00/00"></c:out>
						   </c:when>  
						   <c:otherwise>
						   		${m.post_from}
						   </c:otherwise>  
						</c:choose>
						-${m.upToPresent?"现在":((m.post_to==''||m.post_to==null)?'0000/00/00':m.post_to)}  
					</td>
					<td>${m.employer}</td>
					<td>${m.sub_unit}</td>
					<td>${m.post}</td>
					<td>${m.post_class}</td>
					<%-- <td>${m.mng_grade}</td>
					<td>${m.gradeEmpDate}</td> --%>
					<td>
						<c:choose>
						   <c:when test="${m.remark==''||m.remark==null}">
						   		<c:out value="${m.post_attribute?'兼职':''}"></c:out>
						   </c:when>  
						   <c:otherwise>
						   		${m.remark}
						   </c:otherwise>  
						</c:choose>
					</td>
				</tr>
			</c:forEach>
			<c:choose>
			   <c:when test="${fn:length(each.managementGrades)==0}">
			   </c:when>  
			   <c:otherwise>
			   		<tr  height="10px" style="line-height:10px">
						<td colspan="6" style="line-height:10px"></td>
					</tr>
					<tr>
						<td colspan="6" style="padding:0px">
							<table border="0" cellspacing="0" cellpadding="0" style="border-collapse: collapse;border-width:0px; border-style:hidden;" frame="void">
								<tr class="doubleLineHeader">
									<td width="80" style="font-weight:bold;">职级日期</td>
									<c:forEach var="m" items="${each.managementGrades}" varStatus="status">
										<td width="100">${m.gradeEmpDate}</td>
									</c:forEach>
									<c:choose>
										<c:when test="${(fn:length(each.managementGrades))>7}">
								   		</c:when>  
									    <c:otherwise>
									      <c:set var="property1" value="${7-fn:length(each.managementGrades)}" />
											<c:forEach var ="i" begin="1" end="${property1}">
												<td width="100"></td>
											</c:forEach>
									    </c:otherwise>
								    </c:choose>
								</tr>
								<tr>
									<td width="80" style="font-weight:bold;">管理职级</td>
									<c:forEach var="m" items="${each.managementGrades}" varStatus="status">
										<td width="100">${m.mng_grade}</td>
									</c:forEach>
									<c:choose>
										<c:when test="${(fn:length(each.managementGrades))>7}">
								   		</c:when>  
									    <c:otherwise>
									      <c:set var="property2" value="${7-fn:length(each.managementGrades)}" />
											<c:forEach var ="i" begin="1" end="${property2}">
												<td width="100"></td>
											</c:forEach>
									    </c:otherwise>
								    </c:choose>
								</tr>
							</table>
						</td>
					</tr>
			   </c:otherwise>  
			</c:choose>
		</table>
		<table>
			<tr>
				<th colspan="7" class="columnHeader">八、技术等级信息<span
					class="columnRemark">（工勤人员填写，含工作经历中工勤职务、职级所有信息）</span>
				</th>
			</tr>
			<tr>
				<th width="150">聘任日期</th>
				<th width="256">聘任单位</th>
				<th width="255">院/系/单位</th>
				<th width="100">岗位分类</th>
				<th width="100">工勤职务</th>
				<th width="100">工勤技术级别</th>
				<th width="130">备注</th>
			</tr>

			<c:if test="${each.servicePosts == null}">
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
			</c:if>
			<c:forEach var="s" items="${each.servicePosts}" varStatus="status">
				<tr>
					<td>${s.empDate}</td>
					<td>${s.employer}</td>
					<td>${s.sub_unit}</td>
					<td>${s.jobType}</td>
					<td>${s.techPost}</td>
					<td>${s.techGrade}</td>
					<td>${s.remark}</td>
				</tr>
			</c:forEach>
		</table>
		<table>
			<tr>
				<th colspan="8" class="columnHeader">九、海外经历</th>
			</tr>
			<tr>
				<th width="140">起止年月</th>
				<th width="109">国家/地区</th>
				<th width="224">院校/企业</th>
				<th width="224">院系/部门</th>
				<th width="224">身份/职务</th>
				<th width="117">留学类别</th>
				<th width="117">派遣方式</th>
				<th width="129">备注</th>
			</tr>
			<c:if test="${each.abroadexp == null}">
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
			</c:if>
			<c:forEach var="ab" items="${each.abroadexp}" varStatus="status">
				<tr>
					<td>${ab.ae_from}-${ab.ae_to}</td>
					<td>${ab.country}</td>
					<td>${ab.university}</td>
					<td>${ab.sub_unit}</td>
					<td>${ab.post}</td>
					<td>${ab.abroad_identity}</td>
					<td>${ab.dispatch_type}</td>
					<td>${ab.remark}</td>
				</tr>
			</c:forEach>
		</table>
		<!-- 	<table>
		<tr>
			<th colspan="10" class="columnHeader">九、学术信息</th>
		</tr>
		<tr>
			<th height="42" colspan="10" align="left">1、论文情况</th>
		</tr>
		<tr>
			<th width="122"><p>总数</p>
				<p>（篇）</p></th>
			<th width="90">类别</th>
			<th height="42" colspan="6">期刊（按收录最高级别填写）</th>
			<th width="121">会议</th>
			<th width="91">小计</th>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<th width="54">SCI</th>
			<th width="54">EI</th>
			<th width="54">CSSCI</th>
			<th width="54">SSCI</th>
			<th width="54">SCI&amp;EI</th>
			<th width="54">核心</th>
			<th>ISTP</th>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td rowspan="4">&nbsp;</td>
			<th>第一作者</th>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<th>第二作者</th>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<th>通讯作者</th>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<th>小计</th>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<th height="876" colspan="10" align="left" valign="top"><span
				class="STYLE6">请按时间顺序著名论文作者、论文名称、发表载体、发表时间、页码、作者排序、收录情况、收录号、影响因子等</span>
			</th>
		</tr>
	</table>
	<table>
		<tr>
			<th colspan="7" align="left">2、项目情况</th>
		</tr>
		<tr>
			<th width="145">立项日期</th>
			<th width="145">项目名称</th>
			<th width="145">性质及来源</th>
			<th width="145">合同经费</th>
			<th width="145">到校经费</th>
			<th width="145">可支配经费</th>
			<th width="100">本人排名</th>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
	</table>
	<table>
		<tr>
			<th colspan="6" align="left">3、专利类型（已授权专利）</th>
		</tr>
		<tr>
			<th width="177">专利保护期</th>
			<th width="194">专利名称</th>
			<th width="125">专利号</th>
			<th width="107">附件号</th>
			<th width="148">专利类型</th>
			<th width="85">本人排名</th>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
	</table>
	<table>
		<tr>
			<th colspan="5" align="left">4、代表性专著、编著、译著</th>
		</tr>
		<tr>
			<th width="269">书名</th>
			<th width="297">出版社</th>
			<th width="152">出版年月</th>
			<th width="130">字数（万）</th>
			<th width="100">排序</th>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
	</table>
	<table>
		<tr>
			<th colspan="8">所有著作&nbsp;本，其中</th>
		</tr>
		<tr>
			<th colspan="2">主编</th>
			<th colspan="2">参编</th>
			<th colspan="2">译著</th>
			<th colspan="2">审著</th>
		</tr>
		<tr>
			<th width="116" height="35">本数</th>
			<th width="113">&nbsp;
				</td>
				<th width="184">本数</th>
				<th width="107">&nbsp;
					</td>
					<th width="163">本数</th>
					<th width="106">&nbsp;
						</td>
						<th width="100" rowspan="2">本数</th>
						<td width="47" rowspan="2">&nbsp;</td>
		</tr>
		<tr>
			<th>字数（万）</th>
			<td>&nbsp;</td>
			<th>字数（万）</th>
			<td>&nbsp;</td>
			<th>字数（万）</th>
			<td>&nbsp;</td>
		</tr>
		<tr align="left">
			<th colspan="8">备注：如果出版物无排序或按姓氏笔画排序等，请在“排序”一栏写“无”
				</td>
		</tr>
	</table>
	 -->
		<table>
			<tr>
				<th colspan="5" class="columnHeader">十、社会兼职</th>
			</tr>
			<tr>
				<th width="205">起止日期</th>
				<th width="100">国家（地区）</th>
				<th width="301">机构名称</th>
				<th width="101">职务</th>
				<th width="100">备注</th>
			</tr>
			<c:if test="${each.socialPost == null}">
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
			</c:if>
			<c:forEach var="sp" items="${each.socialPost}" varStatus="status">
				<tr>
					<td><c:choose>
						   <c:when test="${sp.scp_from==''||sp.scp_from==null}">
						   		<c:out value="0000/00/00"></c:out>
						   </c:when>  
						   <c:otherwise>
						   		${sp.scp_from}
						   </c:otherwise>  
						</c:choose>-${sp.upToPresent?"现在":((sp.scp_to==''||sp.scp_to==null)?'0000/00/00':sp.scp_to)}</td>
					<td>${sp.country}</td>
					<td>${sp.organization}</td>
					<td>${sp.post}</td>
					<td>${sp.remark}</td>
				</tr>
			</c:forEach>
		</table>
		<table>
			<tr>
				<th colspan="7" class="columnHeader">十一、获奖信息</th>
			</tr>
			<tr>
				<th width="115">获奖日期</th>
				<th width="300">奖项项目（课题）</th>
				<th width="300">奖项（称号）名称及等级</th>
				<th width="161">颁奖单位</th>
				<th width="161">奖项类别</th>
				<th width="100">本人排名</th>
				<th width="100">备注</th>

			</tr>
			<c:if test="${each.awards == null}">
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
			</c:if>
			<c:forEach var="aw" items="${each.awards}" varStatus="status">
				<tr>
					<td>${aw.award_date}</td>
					<td>${aw.award_subject}</td>
					<td>${aw.award_name}</td>
					<td>${aw.grant_org}</td>
					<td>${aw.award_class}</td>
					<td>${aw.award_order}</td>
					<td>${aw.remark}</td>
				</tr>
			</c:forEach>
		</table>

		<table>
			<tr>
				<th colspan="7" class="columnHeader">十二、导师信息<span class="columnRemark">（含博、硕士研究生导师）</span>
				</th>
			</tr>
			<tr>
				<th width="115">聘任日期</th>
				<th width="100">导师类型</th>
				<th width="301">聘任单位</th>
				<th width="151">学科门类</th>
				<th width="151">一级学科</th>
				<th width="151">二级学科</th>
				<th width="100">备注</th>
			</tr>
			<c:if test="${each.tutorInfo == null}">
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
			</c:if>
			<c:forEach var="tt" items="${each.tutorInfo}" varStatus="status">
				<tr>
					<td>${tt.empDate}</td>
					<td>${tt.tutorType}</td>
					<td>${tt.grant_unit}</td>
					<td>${tt.disciplineGroup}</td>
					<td>${tt.firstDescipline}</td>
					<td>${tt.secondDescipline}</td>
					<td>${tt.remark}</td>
				</tr>
			</c:forEach>
		</table>

		<table>
			<tr>
				<th colspan="4" class="columnHeader">十三、优秀人才<span
					class="columnRemark">（含院士、长江、杰青、千人、泰山等人才计划及突贡专家、教学带头人等）</span>
				</th>
			</tr>
			<tr>
				<th width="217">起止日期</th>
				<th width="219">专家类别</th>
				<th width="433">聘任单位</th>
				<th width="83">备注</th>
			</tr>
			<c:if test="${each.talentInfo == null}">
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
			</c:if>
			<c:forEach var="ta" items="${each.talentInfo}" varStatus="status">
				<tr>
					<td><c:choose>
						   <c:when test="${ta.rt_from==''|| ta.rt_from==null}">
						   		<c:out value="0000/00/00"></c:out>
						   </c:when>  
						   <c:otherwise>
						   		${ta.rt_from}
						   </c:otherwise>  
						</c:choose>
						-${ta.upToPresent?"现在":((ta.rt_to==''||ta.rt_to==null)?'0000/00/00':ta.rt_to)} 
					</td>
					<td>${ta.talentType}</td>
					<td>${ta.grant_unit}</td>
					<td>${ta.remark}</td>
				</tr>
			</c:forEach>
		</table>
		<p>&nbsp;</p>
		<div class="pageBreak"></div>

	</c:forEach>
</body>
</html>
