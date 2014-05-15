$(document).ready(function(){
	   $("#buttonResult").click(function(){	
		   $.ajax({
			   url: "resp",
			   type: "POST",
			   success: function(data){
				   document.getElementById("myModal").innerHTML = data;
				   $("myModal").modal("show");
			   }
		   });
	   });
});

	   $("matrix1  td input").click(function(){	
		   var index = $(this).attr("name");
		   $.ajax({
			   url: "openUpdate",
			   type: "POST",
			   data: {fName1:this.data, fName2:index},		  
			   success: function(data){
				   document.getElementById("myModalA").innerHTML = data;
			   }		   	   
		   });
	   });

function updateInp(index){
	//var index = $("td input").attr("name");
	   $.ajax({
		   url: "openUpdate",
		   type: "POST",
		   data: {fName1:this.data, fName2:index},		  
		   success: function(data){
			   document.getElementById("myModalA").innerHTML = data;
		   }		   	   
	   });
}

function UpdateElement(){
	var v = $("#inputUpdate").val();
	var index = $("#UpdateElement").attr("name");
	if(isNaN(v)){
		$("#ppp").css("display","block");
	}else{
	   $.ajax({
		   url: "update",
		   type: "POST",
		   data: {value:v, index:index}, 
		   success: function(){
			   document.getElementById(index).value = v;
		   }
	   });
	   $('#myModalA').modal('hide');	   
	}
}

$(document).ready(function(){
	   $("#buttonHistory").click(function(){	
		   $.ajax({
			   url: "history",
			   type: "POST",
			   success: function(data){
				   document.getElementById("myModalHistory").innerHTML = data;
				   $("myModalHistory").modal("show");
			   }
		   });
	   });
});

$(document).ready(function(){
	   $("#changeSize").click(function(){	
		   var n = $("#inputChangeSize").val();
		   if(isNaN(n)||n<=0 || n>=15){
				$("#ppp").css("display","block");
			}else{
			   $.ajax({
				   url: "changeSize",
				   type: "POST",
				   data: {n: n},
				   success: function(){
					    loadMatrix(1);
					    loadMatrix(2);
				   }
			   });			   
			   $('#myModalChangeSize').modal('hide');
			}
		   document.getElementById("inputChangeSize").value = "";
	   });
});

function loadMatrix(index){
    $.ajax({
		   url: "matrixAB",
		   type: "POST",
		   data: {index: index},
		   success: function(data){
			   if(index==1){
				   document.getElementById("matrix1").innerHTML = data;}
			   if(index==2){
				   document.getElementById("matrix2").innerHTML = data;}
		   }
	   });
}

function loadPage() {
    loadMatrix(1);
    loadMatrix(2);
}
