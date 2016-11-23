<%@ page session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>jQuery UI Datepicker - Default functionality</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
<script type="text/javascript"
    src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
    $('#owner').change(function(event) {  
    var owner=$("select#owner").val();
    $.getJSON("<c:url value="/appointment/owner"/>",{owner:owner}, function(response) {   
    	   var $select = $('#pets');                           
           $select.find('option').remove();                          
           $.each(response, function(key, value) {               
               $('<option>').val(key).text(value).appendTo($select);      
                });
    });
    });
    
  $('#pets').change(function(event) {  
    $.getJSON("<c:url value="/appointment/vet"/>", function(response) {   
    	   var $select = $('#vet');                           
           $select.find('option').remove();                          
           $.each(response, function(key, value) {               
               $('<option>').val(key).text(value).appendTo($select);      
                });
    });
    });
    	   $( "#datepicker" ).datepicker();
});          
</script>
<style type="text/css">
table, td, th {
	border-collapse: collapse;
	border: 2px solid red;
	width: 400px;
}
</style>

</head>
<body>
	<div align="center">
		<form method="GET" action="/HelloWeb/addStudent">
			<table>
				<tr>
					<td>Owner</td>
					<td><select id="owner" name="owner">
							<option selected="selected">Please select</option>
							<c:forEach items="${owners}" var="owner">
								<option value="${owner.key}">${owner.value}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td>Pets</td>
					<td><select id="pets" name="pets">
							<option>Please select</option>
					</select></td>
				</tr>
				<tr>
					<td>Vets</td>
					<td><select id="vet" name="vet">
							<option>Please select</option>
					</select></td>
				</tr>
			</table>
			<p>Date: <input type="text" id="datepicker"></p>
<input type=submit value="click">
		</form>
	</div>
</body>
</html>