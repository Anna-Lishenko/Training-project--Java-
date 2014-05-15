<%@page import="com.spring.entity.History"%>
<%@page import="java.util.*"%>
<%
	List<History> historyList = (List<History>)request.getAttribute("historyList");
%>

<div class="modal-header">
   <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
	<h3 id="myModalLabel">History</h3>
</div>
      
<div class="modal-body">
<table id="historyTable" class="table table-striped">
     <tr>
         <td><b>ID</b></td>
         <td><b>Date</b></td>
     </tr>
     <%
     for (History h:  historyList) {
     %>
     <tr>
         <td><%=h.getID()%></td>
         <td><%=h.getDate()%></td>
     </tr>
	<%}%>
</table>
</div>
      
<div class="modal-footer">
    <div><button class="btn btn-primary" data-dismiss="modal" aria-hidden="true">Close</button></div>
</div>	