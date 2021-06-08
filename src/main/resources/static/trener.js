$(document).ready(function () {    // Čeka se trenutak kada je DOM(Document Object Model) učitan da bi JS mogao sa njim da manipuliše.
    // ajax poziv za dobavljanje svih zaposlenih sa backend-a i prikaz u tabeli
    $.ajax({
        type: "GET",                                                // HTTP metoda
        url: "http://localhost:8080/trener",                 // URL koji se gađa
        dataType: "json",                                           // tip povratne vrednosti
        contentType: "application/json", 
		success: function (response) {                              // ova f-ja se izvršava posle uspešnog zahteva
            console.log("SUCCESS:\n", response);                    // ispisujemo u konzoli povratnu vrednost radi provere
 
			for (let trener of response) {                        // prolazimo kroz listu svih zaposlenih
                let row = "<tr>";                                   // kreiramo red za tabelu
				row += "<td>" + trener.korisnicko_ime + "</td>";       // ubacujemo podatke jednog zaposlenog u polja
                row += "<td>" + trener.email + "</td>";
                row += "<td>" + trener.aktivan + "</td>";
                
                let btn = "<button class='btnSeeMore' data-id=" + trener.id + ">Odobri</button>";
                row += "<td>" + btn + "</td>";                    
                row += "</tr>";                                     

                $('#treneri').append(row);                       
            }
        },
        error: function (response) {                               
            console.log("ERROR:\n", response);
        }
    });
});


$(document).on("submit", "#dodajtrenera", function (event) {     // kada je submit-ovana forma za kreiranje novog zaposlenog
    event.preventDefault(); 

	var kriterijum = document.getElementById(kriterijum).value;
	var vrsta = document.getElementById(vrednost).value;
    
    // ajax poziv za kreiranje novog zaposlenog na backend-u
    $.ajax({
        type: "GET",                                               // HTTP metoda je POST
        url: "http://localhost:8080/trener/" + kriterijum + "/" + vrsta,                 // URL na koji se šalju podaci
        dataType: "json",                                           // tip povratne vrednosti
        contentType: "application/json",                            // tip podataka koje šaljemo                 
        success: function (response) {                              // ova f-ja se izvršava posle uspešnog zahteva
            console.log(response);                                  // ispisujemo u konzoli povratnu vrednost radi provere
             
			for (let trener of response) {                        // prolazimo kroz listu svih zaposlenih
                let row = "<tr>";                                   // kreiramo red za tabelu
				row += "<td>" + trener.korisnicko_ime + "</td>";       // ubacujemo podatke jednog zaposlenog u polja
                row += "<td>" + trener.email + "</td>";
                row += "<td>" + trener.aktivan + "</td>";
                
                let btn = "<button class='btnSeeMore' data-id=" + trener.id + ">Odobri</button>";
                row += "<td>" + btn + "</td>";                    
                row += "</tr>";                                     

                $('#treneri').append(row);                       
            }
        },
        error: function () {                                        // ova f-ja se izvršava posle neuspešnog zahteva
            alert("Greška!");
        }
    });
});

/*
$(document).on('click', '.btnSeeMore', function() {
	response.preventDefault();
	
	let trenerId = this.dataset.id;
	
	$.ajax({
		type: "PUT",
		url: "http://localhost:8080/trener",
		contentType = "application/json",
		data: JSON.stringify(odobren_trener),
		success: function(response){
			console.log("SUCCESS:\n", response);
			
			alert("Trener" + response.id + " je odobren");
		},
		error: function(response){
			console.log("ERROR:\n", response);
		}
	});
});
	*/




































