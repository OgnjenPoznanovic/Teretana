$(document).on("submit", "#dodajnovitermin", function (event) {     // kada je submit-ovana forma za kreiranje novog zaposlenog
    event.preventDefault();                                         // sprečavamo automatsko slanje zahteva da bismo pokupili (i validirali) podatke iz forme

    // preuzimamo vrednosti unete u formi
    let vreme = $("#vreme").val();
    let cena = $("#cena").val();
    let prijavljenih = $("#prijavljenih").val();
	let sala = $("#sala").val();
	let trening = $("#trening").val();
	console.log(trening);
	console.log(sala);
	let url = "http://localhost:8080/termini/novi/" + sala + "/" + trening;
	console.log(url);

    // kreiramo objekat zaposlenog
    // nazivi svih atributa moraju se poklapati sa nazivima na backend-u
    let newTermin = {
        vreme,
        cena,
        prijavljenih
    }
    
    // ajax poziv za kreiranje novog zaposlenog na backend-u
    $.ajax({
        type: "POST",                                               // HTTP metoda je POST
        url: "http://localhost:8080/termini/novi/" + sala + "/" + trening,                 // URL na koji se šalju podaci
        dataType: "json",                                           // tip povratne vrednosti
        contentType: "application/json",                            // tip podataka koje šaljemo
        data: JSON.stringify(newTermin),                          // u body-ju šaljemo novog zaposlenog (JSON.stringify() pretvara JavaScript objekat u JSON)
        success: function (response) {                              // ova f-ja se izvršava posle uspešnog zahteva
            console.log(response);                                  // ispisujemo u konzoli povratnu vrednost radi provere

            alert("Termin " + response.id + " je uspešno kreiran!");// prikazujemo poruku uspeha korisniku
            window.location.href = "ProfilTrener.html";                // redirektujemo ga na employees.html stranicu
        },
        error: function () {                                        // ova f-ja se izvršava posle neuspešnog zahteva
            alert("Greška!");
        }
    });
});


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
                row += "</tr>";                                     

                $('#termini').append(row);                       
            }
        },
        error: function (response) {                               
            console.log("ERROR:\n", response);
        }
    });
});


$(document).on("submit", "#gde", function (event) {
	event.preventDefault(); 
	
	let vreme = $("#kad").val();
	let cena = $("#pare").val();
	let sala = $("#gdes").val();
	let id = $("#id").val();
	console.log(id);
	console.log(vreme);
	console.log(cena);
	console.log(sala);
	
	$.ajax({
		type: "PUT",
		url: "http://localhost:8080/termini/" + id + "/" + vreme + "/" + cena + "/" + sala,
		contentType: "application/json",
		success: function(response){
			console.log("SUCCESS:\n", response);
			
			alert("Termin " + response.id + " je izmenjen");
			window.location.href = "ProfilTrener.html";                
			
		},
		error: function(response){
			console.log("ERROR:\n", response);
		}
	});
});
