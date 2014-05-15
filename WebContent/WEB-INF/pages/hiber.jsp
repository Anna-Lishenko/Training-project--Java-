<%@page import="com.spring.entity.Matrix"%>
<%@page import="com.spring.data.MatrixData"%>
<%@page import="java.util.List"%>
<%@page import= "java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<style>
   <%@include file="css/Style.css" %>
   <%@include file="css/bootstrap.css" %>
</style>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Matrix Calculator</title>

	<script type="text/javascript"  src="<%=request.getContextPath()%>/js/jquery.js"></script>
	<script type="text/javascript"  src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
	<script type="text/javascript"  src="<%=request.getContextPath()%>/js/app.js"></script>

</head>

<body onload="loadPage()">
		<div id="topbg">
			<h3>Matrix Calculator</h3>
		</div>
		<%
		MatrixData a = (MatrixData)request.getAttribute("matrixListA");
		MatrixData b = (MatrixData)request.getAttribute("matrixListB");
		%>
		<div class="container-fluid">
		<div>
				<ul class="nav nav-pills">
					<li>
						
						<a href="#myModal" data-toggle="modal"  id="buttonResult">
							<span></span>
							Calculation
						</a>
					</li>
					<li>
						<a href="#myModalHistory" data-toggle="modal"  id="buttonHistory">
							<span></span>
							History							
						</a>
					</li>
					<li>
						<a href="#myModalChangeSize" data-toggle="modal"  id="buttonChangeSize">
							<span></span>
							Change size
						</a>
					</li>
				</ul>
			</div>
			<div class="row-fluid">
				<div class="span6" id="matrix1">
				<!--
					<h3>Matrix 1</h3>
					
					<table>
	    			<% //for (int i=0; i<a.getSize(); i++) { %>
	    				<tr>
	        			<% //for (int j=0; j<a.getSize(); j++) { %>
	        				<td>        				
	        					<input id=<//%="1."+i+"."+j %> name=<%//="1."+i+"."+j %> href="#myModalA" role="button" data-toggle="modal" type="button" value=<%//=a.getMatrixElement(i, j)%>>   				
	        					<div  id="myModalA" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: block;">                            
								</div>
	        				</td>
	        			<%//} %>
	        			</tr>
	    			<%//}%>
	    			</table>
	    			 -->
	    		</div> 
		
				<div class="span6" id="matrix2">
				<!--
				<h3>Matrix 2</h3>
					
					<table>
		    		<% //for (int i=0; i<b.getSize(); i++) { %>
		    			<tr>
		        		<%// for (int j=0; j<b.getSize(); j++) { %>
		        			<td>
		        				<input id=<%//="2."+i+"."+j %> name=<%//="2."+i+"."+j %> href="#myModalA" role="button" data-toggle="modal" type="button" value=<%//=b.getMatrixElement(i, j)%>>   				
		        				<div  id="myModalA" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: block;">                            
								</div>
		        			</td>
		        		<%//} %>
		        		</tr>
		    		<%//}%>
		    		</table>
		    		 -->
				</div>     	
    	
		    	<div class="divResult">  	
					<div class="modal hide fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: block;">
					</div>
				</div>	
				<div class="modal hide fade" id="myModalHistory" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: block;">
				</div>
				<div class="modal hide fade" id="myModalChangeSize" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
						<h3 id="myModalLabel">Change Size</h3>
					</div>
					                            	
					<div class="modal-body">
					    <input id="inputChangeSize" type="text" class="form-control" required="true">
						<div id="ppp" class="popover fade bottom in" style="display: none;">
							<div class="popover-content">Enter number!!!</div>
						</div>
					</div>
					       						
					<div class="modal-footer">
					     <button id="changeSize"  class="btn btn-primary" aria-hidden="true">Save</button>
					</div>
				</div>
		</div>
	</div>
</body>
</html>