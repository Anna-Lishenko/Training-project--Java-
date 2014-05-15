<script type="text/javascript"  src="<%=request.getContextPath()%>/js/jquery.js"></script>
<script type="text/javascript"  src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<script type="text/javascript"  src="<%=request.getContextPath()%>/js/app.js"></script>
<%
	String index = (String)request.getAttribute("index");
%>
<div>
<div class="modal-header">
     <button type="button" class="close" data-dismiss="modal" aria-hidden="true">x</button>
     <h3 id="myModalLabel">Update element</h3>
</div>
                            	
<div class="modal-body">
     <input id="inputUpdate" type="text" class="form-control" required="true">
	<div id="ppp" class="popover fade bottom in" style="display: none;">
		<div class="popover-content">Enter number</div>
	</div>
</div>
       						
<div class="modal-footer">
     <button onClick="UpdateElement();" id="UpdateElement" name=<%=index %> class="btn btn-primary" aria-hidden="true">Save</button>
</div>
</div>