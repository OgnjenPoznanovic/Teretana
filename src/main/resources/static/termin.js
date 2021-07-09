$(document).ready(function () {    // Čeka se trenutak kada je DOM(Document Object Model) učitan da bi JS mogao sa njim da manipuliše.
    /*
	let broj = localStorage.getItem("lozinka");
	console.log(broj);
	*/

	
    $.ajax({
        type: "GET",                                                // HTTP metoda
        url: "http://localhost:8080/termini",                 // URL koji se gađa
        dataType: "json",                                           // tip povratne vrednosti
        contentType: "application/json", 
		success: function (response) {                              // ova f-ja se izvršava posle uspešnog zahteva
            console.log("SUCCESS:\n", response);                    // ispisujemo u konzoli povratnu vrednost radi provere
 
			for (let termin of response) {                        // prolazimo kroz listu svih zaposlenih
                let row = "<tr>";                                   // kreiramo red za tabelu
				row += "<td>" + termin.id + "</td>";       // ubacujemo podatke jednog zaposlenog u polja
                row += "<td>" + termin.vreme + "</td>";
                row += "<td>" + termin.cena + "</td>";
				row += "<td>" + termin.prijavljenih + "</td>";
				let bri = "<button class='kako' data-id=" + termin.id + ">Pregled</button>";
                row += "<td>" + bri + "</td>";
                row += "</tr>";                                     

                $('#termini').append(row);                       
            }
        },
        error: function (response) {                               
            console.log("ERROR:\n", response);
        }
    });
});


$(document).on("submit", "#uslov", function (event) {    
     event.preventDefault();
	 
	 let sakri = $("#prva");                      // dobavljamo element čiji je id = allEmployees  (pogledati html)
    sakri.hide(); 
	 
	var sort = document.getElementById("sort").value;
	var fullURL = "http://localhost:8080/termini/" + sort;
	
    $.ajax({
        type: "GET",                        
        url: fullURL,
        dataType: "json",                                           // tip povratne vrednosti
        contentType: "application/json", 
		success: function (response) {                              // ova f-ja se izvršava posle uspešnog zahteva
            console.log("SUCCESS:\n", response);                    // ispisujemo u konzoli povratnu vrednost radi provere
			

 
			for (let termin of response) {                        // prolazimo kroz listu svih zaposlenih
                let row = "<tr>";                                   // kreiramo red za tabelu
				row += "<td>" + termin.id + "</td>";       // ubacujemo podatke jednog zaposlenog u polja
                row += "<td>" + termin.vreme + "</td>";
                row += "<td>" + termin.cena + "</td>";
				row += "<td>" + termin.prijavljenih + "</td>";                              
                row += "</tr>";                                     

                $('#tabelasort').append(row);                       
            }
			
			let pokazi = $("#druga");                // dobavljamo element čiji je id = oneEmployee
            pokazi.show(); 
        },
        error: function (response) {                               
            console.log("ERROR:\n", response);
        }
    });
});


$(document).on("submit", "#tpretraga", function (event) {     // kada je submit-ovana forma za kreiranje novog zaposlenog
    event.preventDefault();
	
	let employeesDiv = $("#prva");                      // dobavljamo element čiji je id = allEmployees  (pogledati html)
    employeesDiv.hide();

	var vreme = document.getElementById("vreme").value;
	var cena = document.getElementById("cena").value;

	
	
    // ajax poziv za kreiranje novog zaposlenog na backend-u
    $.ajax({
        type: "GET",                                               // HTTP metoda je POST
        url: "http://localhost:8080/termini/" + vreme + "/" + cena,
        dataType: "json",                                           // tip povratne vrednosti
        contentType: "application/json",                            // tip podataka koje šaljemo                 
        success: function (response) {                              // ova f-ja se izvršava posle uspešnog zahteva
            console.log(response);        

			
			for (let termin of response) {                        // prolazimo kroz listu svih zaposlenih
                let row = "<tr>";                                   // kreiramo red za tabelu
				row += "<td>" + termin.id + "</td>";       // ubacujemo podatke jednog zaposlenog u polja
                row += "<td>" + termin.vreme + "</td>";
                row += "<td>" + termin.cena + "</td>";
				row += "<td>" + termin.prijavljenih + "</td>";                              
                row += "</tr>";                                     

                $('#tabelasort').append(row);                       
            }
			
			let employeeDiv1 = $("#druga");                // dobavljamo element čiji je id = oneEmployee
            employeeDiv1.show();  
        },
        error: function () {                                        // ova f-ja se izvršava posle neuspešnog zahteva
            alert("Greška!");
        }
    });
});

$(document).on('click', '.kako', function() {
	//response.preventDefault();
	
	let employeesDiv = $("#prva");                      // dobavljamo element čiji je id = allEmployees  (pogledati html)
    employeesDiv.hide();
	let employeesDiv1 = $("#druga");                      // dobavljamo element čiji je id = allEmployees  (pogledati html)
    employeesDiv1.hide();
	
	
	let terminId = this.dataset.id;
	let url = "http://localhost:8080/termini/detalji/" + terminId;
	console.log(url);
	
	$.ajax({
		
		type: "GET",
		url: "http://localhost:8080/termini/detalji/" + terminId,
		contentType: "application/json",
		success: function(response){
			console.log("SUCCESS:\n", response);
			
			console.log(response.id);
			console.log(response.vreme);
			console.log(response.cena);
			console.log(response.prijavljenih);
			
			            // prolazimo kroz listu svih zaposlenih
                  
				let row = "<tr>";                                   // kreiramo red za tabelu
				row += "<td>" + response.id + "</td>";       // ubacujemo podatke jednog zaposlenog u polja
                row += "<td>" + response.vreme + "</td>";
                row += "<td>" + response.cena + "</td>";
				row += "<td>" + response.prijavljenih + "</td>";
				let zak = "<button class='promena' data-id=" + response.id + ">Prijava</button>";
                row += "<td>" + zak + "</td>";
				let otk = "<button class='otk' data-id=" + response.id + ">Otkazivanje</button>";
                row += "<td>" + otk + "</td>";
                row += "</tr>";                                     

                $('#detalji').append(row); 
								
				
				let employeesDiv2 = $("#treca");                      // dobavljamo element čiji je id = allEmployees  (pogledati html)
				employeesDiv2.show();
	
			               
			
		},
		error: function(response){
			console.log("ERROR:\n", response);
		}
		
	});
});

$(document).on('click', '.promena', function() {
	//response.preventDefault();
	var trenerid = JSON.parse(localStorage.getItem('user'));
	
	var ime= trenerid.id;
	
	let terminId = this.dataset.id;
	
	$.ajax({
		
		type: "PUT",
		url: "http://localhost:8080/termini/zakazi/" + terminId + "/" + ime,
		contentType: "application/json",
		success: function(response){
			console.log("SUCCESS:\n", response);
			
			console.log(response.id);
			console.log(response.vreme);
			console.log(response.cena);
			console.log(response.prijavljenih);
	
            alert("Uspesno zakazan " +  response.id + ". termin");  		
			window.location.href = "pregled_termina.html";
			               
			
		},
		error: function(response){
			alert("Nema mesta"); 
			console.log("ERROR:\n", response);
		}
		
	});
});

$(document).on('click', '.otk', function() {
	//response.preventDefault();
	var trenerid = JSON.parse(localStorage.getItem('user'));
	
	var ime= trenerid.id;
	
	let terminId = this.dataset.id;
	
	
	$.ajax({
		
		type: "PUT",
		url: "http://localhost:8080/termini/otkazi/" + terminId + "/" + ime,
		contentType: "application/json",
		success: function(response){
			console.log("SUCCESS:\n", response);
			
			console.log(response.id);
			console.log(response.vreme);
			console.log(response.cena);
			console.log(response.prijavljenih);
	
            alert("Uspesno otkazan");		
			window.location.href = "pregled_termina.html";
			               
			
		},
		error: function(response){
			console.log("ERROR:\n", response);
		}
		
	});
});






