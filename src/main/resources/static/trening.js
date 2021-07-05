$(document).ready(function () {    // Čeka se trenutak kada je DOM(Document Object Model) učitan da bi JS mogao sa njim da manipuliše.
    // ajax poziv za dobavljanje svih zaposlenih sa backend-a i prikaz u tabeli
    $.ajax({
        type: "GET",                                                // HTTP metoda
        url: "http://localhost:8080/trening",                 // URL koji se gađa
        dataType: "json",                                           // tip povratne vrednosti
        contentType: "application/json", 
		success: function (response) {                              // ova f-ja se izvršava posle uspešnog zahteva
            console.log("SUCCESS:\n", response);                    // ispisujemo u konzoli povratnu vrednost radi provere
 
			for (let trening of response) {                        // prolazimo kroz listu svih zaposlenih
                let row = "<tr>";                                   // kreiramo red za tabelu
				row += "<td>" + trening.id + "</td>";       // ubacujemo podatke jednog zaposlenog u polja
                row += "<td>" + trening.naziv + "</td>";
                row += "<td>" + trening.tip + "</td>";
				row += "<td>" + trening.trajanje + "</td>";                              
                row += "</tr>";                                     

                $('#lista_treninga').append(row);                       
            }
        },
        error: function (response) {                               
            console.log("ERROR:\n", response);
        }
    });
});


$(document).on("submit", "#pretraga", function (event) {     // kada je submit-ovana forma za kreiranje novog zaposlenog
    event.preventDefault();

	let employeesDiv = $("#tablediv");                      // dobavljamo element čiji je id = allEmployees  (pogledati html)
    employeesDiv.hide(); 

	var vrsta = document.getElementById("vrednost").value;
	var kriterijum = document.getElementById("kriterijum").value;
	
	var fullURL = "http://localhost:8080/trening/" + kriterijum + "/" + vrsta; 
	
	console.log(fullURL);
	
    // ajax poziv za kreiranje novog zaposlenog na backend-u
    $.ajax({
        type: "GET",                                               // HTTP metoda je POST
        url: fullURL,
        dataType: "json",                                           // tip povratne vrednosti
        contentType: "application/json",                            // tip podataka koje šaljemo                 
        success: function (response) {                              // ova f-ja se izvršava posle uspešnog zahteva
            console.log(response);        

			
			for (let trening of response) {                        // prolazimo kroz listu svih zaposlenih
                let row = "<tr>";                                   // kreiramo red za tabelu
				row += "<td>" + trening.id + "</td>";       // ubacujemo podatke jednog zaposlenog u polja
                row += "<td>" + trening.naziv + "</td>";
                row += "<td>" + trening.tip + "</td>";
				row += "<td>" + trening.trajanje + "</td>";                              
                row += "</tr>";                                     

                $('#rez').append(row);                       
            }
			
			let employeeDiv1 = $("#sakri");                // dobavljamo element čiji je id = oneEmployee
            employeeDiv1.show();  
        },
        error: function () {                                        // ova f-ja se izvršava posle neuspešnog zahteva
            alert("Greška!");
        }
    });
});


$(document).on("submit", "#vpretraga", function (event) {     // kada je submit-ovana forma za kreiranje novog zaposlenog
    event.preventDefault();
	
	console.log("Aloooo");
	let employeesDiv = $("#tablediv");                      // dobavljamo element čiji je id = allEmployees  (pogledati html)
    employeesDiv.hide();
	let employeesDiv2 = $("#sakri");                      // dobavljamo element čiji je id = allEmployees  (pogledati html)
    employeesDiv2.hide();

	var naziv = document.getElementById("naziv").value;
	var tip = document.getElementById("tip").value;
	var trajanje = document.getElementById("trajanje").value;
	
	var fullURL = "http://localhost:8080/trening/vpretraga/" + naziv + "/" + tip +"/" + trajanje; 
	
	//console.log(fullURL);
	
	
    // ajax poziv za kreiranje novog zaposlenog na backend-u
    $.ajax({
        type: "GET",                                               // HTTP metoda je POST
        url: "http://localhost:8080/trening/vpretraga/" + naziv + "/" + tip +"/" + trajanje,
        dataType: "json",                                           // tip povratne vrednosti
        contentType: "application/json",                            // tip podataka koje šaljemo                 
        success: function (response) {                              // ova f-ja se izvršava posle uspešnog zahteva
            console.log(response);        

			
			for (let trening of response) {                        // prolazimo kroz listu svih zaposlenih
                let row = "<tr>";                                   // kreiramo red za tabelu
				row += "<td>" + trening.id + "</td>";       // ubacujemo podatke jednog zaposlenog u polja
                row += "<td>" + trening.naziv + "</td>";
                row += "<td>" + trening.tip + "</td>";
				row += "<td>" + trening.trajanje + "</td>";                              
                row += "</tr>";                                     

                $('#vrez').append(row);                       
            }
			
			let employeeDiv1 = $("#treca");                // dobavljamo element čiji je id = oneEmployee
            employeeDiv1.show();  
        },
        error: function () {                                        // ova f-ja se izvršava posle neuspešnog zahteva
            alert("Greška!");
        }
    });
});