<%@page import="crm.daomin.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<TITLE>添加图书</TITLE> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${pageContext.request.contextPath }/css/Style.css" type=text/css rel=stylesheet>
<LINK href="${pageContext.request.contextPath }/css/Manage.css" type=text/css
	rel=stylesheet>


<META content="MSHTML 6.00.2900.3492" name=GENERATOR>
</HEAD>
<BODY>
	<%
    	java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat(  
    	 "yyyy-MM-dd");  
   		java.util.Date currentTime = new java.util.Date();  
   		String time = simpleDateFormat.format(currentTime).toString();
     %>

 <form id=form1 name=form1 action = "${pageContext.request.contextPath}/bookServlet" method="post"  class="form-x">
      <input type="hidden" name="method" value="addsubmit" />
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_019.jpg"
						border=0></TD>
					<TD width="100%" background="${pageContext.request.contextPath }/images/new_020.jpg"
						height=20></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_021.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15 background=${pageContext.request.contextPath }/images/new_022.jpg><IMG
						src="${pageContext.request.contextPath }/images/new_022.jpg" border=0></TD>
					<TD vAlign=top width="100%" bgColor=#ffffff>
						<TABLE cellSpacing=0 cellPadding=5 width="100%" border=0>
							<TR>
								<TD class=manageHead>当前位置：图书管理 &gt; 添加图书</TD>
							</TR>
							<TR>
								<TD height=2></TD>
							</TR>
						</TABLE>
						
						<TABLE cellSpacing=0 cellPadding=5  border=0>
						    
							<TR>
								<td>图书名称：</td>
								<td>
									<INPUT class=textbox id=sChannel2 style="WIDTH: 180px" maxLength=50 name="bookname">
								</td>
							</TR>
							<TR>
								<td>图书类别：</td>
								<td>
									<INPUT  type="radio"  name="bookcategory" value="教科书">教科书
									<INPUT  type="radio"  name="bookcategory" value="工具书">工具书
									<INPUT  type="radio"  name="bookcategory" value="习题">习题
									<INPUT  type="radio"  name="bookcategory" value="其他">其他
								</td>
							</TR>
							<TR>
								
								<td>上架时间 ：</td>
								<td>
									<INPUT class=textbox type="date" id=sChannel2 style="WIDTH: 180px" maxLength=50 name="uptime" max="<%=time%>">
								</td>
							</TR>
							<TR>
								
								<td>价格 ：</td>
								<td>
									<INPUT class=textbox id=sChannel2 style="WIDTH: 180px" maxLength=50 name="price" value='<fmt:formatNumber  value="${book.price}" pattern="0.00"/>'>
								</td>
							</TR>
							<tr>
								<td rowspan=2>
									<INPUT class=button id=sButton2 type=submit value=" 保存 " name=sButton2>
								</td>
							</tr>
						</TABLE>
						
						
					</TD>
					<TD width=15 background="${pageContext.request.contextPath }/images/new_023.jpg">
					<IMG src="${pageContext.request.contextPath }/images/new_023.jpg" border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width="98%" border=0>
			<TBODY>
				<TR>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_024.jpg"
						border=0></TD>
					<TD align=middle width="100%"
						background="${pageContext.request.contextPath }/images/new_025.jpg" height=15></TD>
					<TD width=15><IMG src="${pageContext.request.contextPath }/images/new_026.jpg"
						border=0></TD>
				</TR>
			</TBODY>
		</TABLE>
	</FORM>
	
	
</BODY>
</HTML>
