$(document).ready(function () { 

	
	var trenerid = JSON.parse(localStorage.getItem('user'));
	
	var ime= trenerid.id;
    
    $.ajax({
        type: "GET",                                                // HTTP metoda
        url: "http://localhost:8080/registracija_clana/" + ime,                 // URL koji se gađa
        dataType: "json",                                           // tip povratne vrednosti
        contentType: "application/json", 
		success: function (response) {                              // ova f-ja se izvršava posle uspešnog zahteva
            console.log("SUCCESS:\n", response);                    // ispisujemo u konzoli povratnu vrednost radi provere
 
			                      
                let row = "<tr>";                                   // kreiramo red za tabelu
				row += "<td>" + response.ime + "</td>";       // ubacujemo podatke jednog zaposlenog u polja
                row += "<td>" + response.email + "</td>";
                row += "<td>" + response.uloga + "</td>";
                row += "</tr>";                                     

                $('#ppret').append(row);                       
            
        },
        error: function (response) {                               
            console.log("ERROR:\n", response);
        }
    });
});