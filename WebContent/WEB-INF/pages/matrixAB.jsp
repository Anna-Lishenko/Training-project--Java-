<%@page import="com.spring.entity.Matrix"%>
<%@page import="com.spring.data.MatrixData"%>
<%@page import="java.util.*"%>

<%
MatrixData a = (MatrixData)request.getAttribute("matrixListA");
String index = (String)request.getAttribute("index");
%>
<h3>Matrix <%=index%></h3>
<table>
	 <% for (int i=0; i<a.getSize(); i++) { %>
		 <tr>
		 <% for (int j=0; j<a.getSize(); j++) {
			 String par = index+"."+i+"."+j;
			 %>
		    <td>        				
		        <input id=<%=index+"."+i+"."+j %> name=<%=index+"."+i+"."+j  %> onClick="updateInp('<%=par%>');" href="#myModalA" role="button" data-toggle="modal" type="button" value=<%=a.getMatrixElement(i, j)%>>   				
		        <div  id="myModalA" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: block;">                            
				</div>
		    </td>
		  <%} %>
		  </tr>
	  <%}%>
</table>