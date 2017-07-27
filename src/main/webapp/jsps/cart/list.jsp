<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>cartlist.jsp</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script src="<c:url value='/jquery/jquery-1.5.1.js'/>"></script>
<script src="<c:url value='/js/round.js'/>"></script>

<link rel="stylesheet" type="text/css"
	href="<c:url value='/jsps/css/cart/list.css'/>">
<script type="text/javascript">
	$(function() {
		//onload 页面加载完后再执行的代码区域
		//进入页面首先 计算总计价格，规则就是将选中的商品价格进行累加
		//$(":checkbox") 表示选择页面input元素 并且input元素的type 类型是  CheckBox的
		// 在上层选择器的基础上在进行一个选择，选择属性name=checkboxBtn的元素,checked=true 表示多选框的
		// checked这个属性必须是true，也就是选中状态
		total();
		//给全选的按钮增加点击事件
		// 表示当我点击$("#selectAll")这个元素的时候，执行function匿名函数
		$("#selectAll").click(function() {
			var bool = $("#selectAll").attr("checked");
			//所有购物车明细的选择框的状态要和 $("#selectAll")的状态一致。
			// jQuery api 隐含着 隐士遍历
			cartItemCheckboxStatus(bool);
			
			submitBtnStyle(bool);
			//每次点击时候，都要计算一次总价
			total();
		});
		//给每一个购物车明细的checkbox 添加点击事件
		$(":checkbox[name=checkboxBtn]")
				.click(
						function() {
							//1 只要有一个购物车明细的checkbox没有被选中，那么全选按钮，就应该取消选中状态
							var allCheckBoxBtnLength = $(":checkbox[name=checkboxBtn]").length;
							var allCheckedBoxBtnLength = $(":checkbox[name=checkboxBtn][checked=true]").length;
							if (allCheckBoxBtnLength == allCheckedBoxBtnLength) {
								//表示所有购物车明细的CheckBox都被选中了
								$("#selectAll").attr("checked", true);
								submitBtnStyle(true);
							} else {
								$("#selectAll").attr("checked", false);
								submitBtnStyle(false);
							}
							//2。重新计算总计
							total();
						});
		//提供修改数量的方法。点击数量旁边的+号，就是修改数量。
		// 使用ajax向后台接口传递两个参数 ，一个是cartItemId,quantity
		$(".jia").click(function() {
			//4F0EE2B8054A4C979FE83112A2562D9DJia
			var jiaId = $(this).attr("id");
			// uuid字符串作为主键，是标准32位的字符串
			var cartItemId = jiaId.substring(0, 32);
			var quantity = $("#" + cartItemId + "Quantity").val();
			quantity = (quantity - 0) + 1;
			updateQuantity(cartItemId, quantity);

		});
		// 减去数量
		$(".jian").click(function() {
			var jianId = $(this).attr("id");
			// uuid字符串作为主键，是标准32位的字符串
			var cartItemId = jianId.substring(0, 32);
			var quantity = $("#" + cartItemId + "Quantity").val();
			quantity = (quantity - 0) - 1;
			//执行ajax
			if (quantity == 0) {
				alert("请点击删除按钮进行删除");
				return false;// 取消点击事件
			}
			updateQuantity(cartItemId, quantity);
		});
	});
	function total() {
		var resultTotal = 0;
		$(":checkbox[name=checkboxBtn][checked=true]").each(function() {
			//1.首选找到购物车明细的ID
			var cartItemId = $(this).val();
			var cartItemSubTotalId = cartItemId + "Subtotal";
			var subTotal = $("#" + cartItemSubTotalId).text();//字符串的数字
			resultTotal += (subTotal - 0);
		});
		$("#total").text(resultTotal);
	}

	function cartItemCheckboxStatus(bool) {
		$(":checkbox[name=checkboxBtn]").attr("checked", bool);
	}
	function updateQuantity(cartItemId, quantity) {
		$.ajax({
					url : "/books/servlet/CartServlet?method=updateQuantityByCartItemId",
					data : "cartItemId=" + cartItemId + "&quantity=" + quantity,
					dataType : "json",//自动将后台返回的json字符串转换位json对象。
					// result =  {"quantity":"2"} ===> jQuery 会把json字符串变成json对象
					success : function(result) {
						//alert(result.quantity);
						// result 这个json对象中存储着该商品在数据库中保存的数量
						$("#" + cartItemId + "Quantity").val(result.quantity);
						// 还要更新小计。后台不光要传过来数量，也要把计算后的小计也要传过来。
						//更新小计
						$("#" + cartItemId + "Subtotal").text(result.subTotal);

						total();//重新计算，总价
					}
				});
	}
	//批量删除
	function batchDeleteCartItems() {
		//要在这个方法中拼接参数，发送请求
		var ids = [];
		$(":checkbox[name=checkboxBtn][checked=true]").each(function() {
			ids.push($(this).val());
		});
		//"D9F6E69111DD4382AFFB72BB474FB016,699D673FF7CB4A8A8375568131F2BE60" 
		// 数组变成字符串   默认情况下就是把数组中的数据已，分隔
		//window.location.href 这个操作就是模仿点击超链接。只要给href赋值一个地址。那么浏览器就去跳转到相应的地址
		if (ids.length == 0) {
			alert("不要瞎点，看清楚");
			return;
		}
		window.location.href = "/books/servlet/CartServlet?method=batchDeleteCartItemsByIds&cartItemIds="
				+ ids;
	}
	
	
	function submitBtnStyle(bool){
		//如果bool为true,则点亮btn
		// 如果bool 为false，则置灰btn
		
		if(bool){
			//点亮效果 jiesuan 是一个css的样式
			$("#jiesuan").removeClass("kill");
			$("#jiesuan").addClass("jiesuan");
		}else{
			$("#jiesuan").removeClass("jiesuan");
			$("#jiesuan").addClass("kill");
		}
		
		
	}
	
	
	
	
	
</script>
</head>
<body>


	<c:choose>
		<c:when test="${empty cartItems}">
			<table width="95%" align="center" cellpadding="0" cellspacing="0">
				<tr>
					<td align="right"><img align="top"
						src="<c:url value='/images/icon_empty.png'/>" /></td>
					<td><span class="spanEmpty">您的购物车中暂时没有商品</span></td>
				</tr>
			</table>
		</c:when>
		<c:otherwise>
			<table width="95%" align="center" cellpadding="0" cellspacing="0">
				<tr align="center" bgcolor="#efeae5">
					<td align="left" width="50px"><input type="checkbox"
						id="selectAll" checked="checked" /><label for="selectAll">全选</label>
					</td>
					<td colspan="2">商品名称</td>
					<td>单价</td>
					<td>数量</td>
					<td>小计</td>
					<td>操作</td>
				</tr>
				<c:forEach items="${cartItems }" var="cartItem">
					<tr align="center">
						<td align="left"><input value="${cartItem.cartItemId }"
							type="checkbox" name="checkboxBtn" checked="checked" /></td>
						<td align="left" width="70px"><a class="linkImage"
							href="<c:url value='/jsps/book/desc.jsp'/>"> <!-- 这个image标签是购物车中添加商品的图片 -->
								<img border="0" width="54" align="top"
								src="${pageContext.request.contextPath }/${cartItem.book.image_b}" /></a></td>
						<td align="left" width="400px"><a
							href="<c:url value='/jsps/book/desc.jsp'/>"><span>${cartItem.book.bname }</span></a></td>
						<td><span>&yen;<span class="currPrice"
								id="12345CurrPrice">${cartItem.book.currPrice }</span></span></td>
						<td><a class="jian" id="${cartItem.cartItemId}Jian"></a> <!-- 一种商品的数量 -->
							<input class="quantity" readonly="readonly"
							id="${cartItem.cartItemId }Quantity" type="text"
							value="${cartItem.quantity }" /> <a class="jia"
							id="${cartItem.cartItemId }Jia"></a></td>
						<td width="100px"><span class="price_n">&yen;<span
								class="subTotal" id="${cartItem.cartItemId}Subtotal">${cartItem.subTotal}</span>
								<!--cartItem.subTotal 其实在调用cartItem.getSubTotal()  -->
						</span></td>
						<td><a
							href="${pageContext.request.contextPath}/servlet/CartServlet?method=batchDeleteCartItemsByIds&cartItemIds=${cartItem.cartItemId}">删除</a></td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="4" class="tdBatchDelete">
						<!-- 点击超链接，执行JavaScript的javascript:batchDeleteCartItems();方法 --> <a
						href="javascript:batchDeleteCartItems();">批量删除</a>
					</td>
					<td colspan="3" align="right" class="tdTotal"><span>总计：</span><span
						class="price_t">&yen;<span id="total"></span></span></td>
				</tr>
				<tr>
					<td colspan="7" align="right">
					<a
						href="<c:url value='/jsps/cart/showitem.jsp'/>" id="jiesuan"
						class="jiesuan"></a></td>
				</tr>
			</table>
			<form id="form1" action="<c:url value='/jsps/cart/showitem.jsp'/>"
				method="post">
				<input type="hidden" name="cartItemIds" id="cartItemIds" /> <input
					type="hidden" name="method" value="loadCartItems" />
			</form>
		</c:otherwise>
	</c:choose>






</body>
</html>
