<%@page import="com.spring.entity.Matrix"%>
<%@page import="com.spring.data.MatrixData"%>
<%@page import="java.util.*"%>
<style>
   <%@include file="css/Style.css" %>
   <%@include file="css/bootstrap.css" %>
</style>
<% 
	MatrixData Result = (MatrixData)request.getAttribute("Result");
%>
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h3 id="myModalLabel">Matrix Result</h3>
      </div>
      
      <div id="resultBody" class="modal-body">
    	<table>
    	<% for (int i=0; i<Result.getSize(); i++) { %>
    		<tr>
        		<% for (int j=0; j<Result.getSize(); j++) { %>
        			<td><%=Result.getMatrixElement(i, j)%></td>
        		<%} %>
        	</tr>
    	<%}%>
    	</table>
      </div>
      
      <div class="modal-footer">
        <div><button class="btn btn-primary" data-dismiss="modal" aria-hidden="true">Close</button></div>
      </div>	