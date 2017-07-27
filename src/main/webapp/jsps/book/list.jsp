<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>图书列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="<c:url value='/jsps/css/book/list.css'/>">
	<link rel="stylesheet" type="text/css" href="<c:url value='/jsps/pager/pager.css'/>" />
	<script type="text/javascript" src="<c:url value='/jquery/jquery-1.5.1.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/jsps/js/book/list.js'/>"></script>
  </head>
  
  <body>

<ul>
  <c:forEach items="${pd.list }" var="book">
  	<li>
	  <div class="inner">
	  <!-- 点击图片进行按照ID去查询 -->
	    <a class="pic" href="${pageContext.request.contextPath }/servlet/BookServlet?method=queryBookByBid&bid=${book.bid}"><img src="<c:url value='/${book.image_b }'/>" border="0"/></a>
	    <p class="price">
			<span class="price_n">&yen;${book.currPrice }</span>
			<span class="price_r">&yen;${book.price }</span>
			(<span class="price_s">${book.discount }</span>)
		</p>
		<p><a id="bookname" title="${book.bname }" href="<c:url value='/jsps/book/desc.jsp'/>">${book.bname }</a></p>
		<p><a href="<c:url value='/servlet/BookServlet?method=findBooksByAuthor&author=${book.author }'/>" name='P_zz' title='Craig Walls'>${book.author }</a></p>
		<p class="publishing">
			<span>出 版 社：</span><a href="<c:url value='/servlet/BookServlet?method=findBooksByPress&press=${book.press }'/>">${book.press }</a>
		</p>
		<p class="publishing_time"><span>出版时间：</span>${book.publishtime }</p>
	  </div>
   </li>
  </c:forEach>

</ul>

<div style="float:left; width: 100%; text-align: center;">
	<hr/>
	<br/>
	<%@include file="/jsps/pager/pager.jsp" %>
</div>

  </body>
 
</html>

