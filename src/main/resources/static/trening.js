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