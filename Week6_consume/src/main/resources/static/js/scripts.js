function getStudentAsJSON(id){
	if (document.getElementById("student"+id).innerHTML == ""){
		fetch('http://localhost:8085/getStudentAsJSON/'+id)
		.then(data => data.json())
		.then(function(data){
			var textToDisplay = "";
			textToDisplay +="ID: " + data.id + "</br>";
			textToDisplay +="Name: " + data.name + "</br>";
			textToDisplay +="Grade: " + data.grade + "</br>";
			textToDisplay +="Letter Grade: " + data.letterGrade + "</br>";
			
			document.getElementById("student"+id).innerHTML = textToDisplay;
		});
	}else{
		document.getElementById("student"+id).innerHTML = "";
	}
}