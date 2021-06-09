$(document).ready(function(){

	//ls
	//onst cat = localStorage.getItem('myCat');
	var user = localStorage.getItem('user');
	
	if(user == null) {
		window.location.href = "login";
	}

});