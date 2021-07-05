// Kreiranje novog zaposlenog
$(document).on("submit", "#dodajNoviFitnes", function (event) {       // kada je submit-ovana forma za kreiranje novog zaposlenog
    event.preventDefault();                                         // sprečavamo automatsko slanje zahteva da bismo pokupili (i validirali) podatke iz forme

    let naziv = $("#naziv").val();
	let adresa = $("#adresa").val();
    let broj_telefona = $("#broj_telefona").val();
    let email = $("#email").val();


    let newFitness = {
        naziv,
		adresa,
        broj_telefona,
        email    
    }
    

    $.ajax({
        type: "POST",                                               
        url: "http://localhost:8080/admin",                
        dataType: "json",                                           
        contentType: "application/json",                            
        data: JSON.stringify(newFitness),                          
        success: function (response) {                              
            console.log(response);                                  

            alert("Fitnes: " + response.id + " je uspešno kreiran!");
          //  window.location.href = "login.html";                
        },
        error: function () {                                       
            alert("Greška!");
        }
    });
});



$(document).ready(function () {    // Čeka se trenutak kada je DOM(Document Object Model) učitan da bi JS mogao sa njim da manipuliše.
    // ajax poziv za dobavljanje svih zaposlenih sa backend-a i prikaz u tabeli
    $.ajax({
        type: "GET",                                                // HTTP metoda
        url: "http://localhost:8080/admin",                 // URL koji se gađa
        dataType: "json",                                           // tip povratne vrednosti
        contentType: "application/json", 
		success: function (response) {                              // ova f-ja se izvršava posle uspešnog zahteva
            console.log("SUCCESS:\n", response);                    // ispisujemo u konzoli povratnu vrednost radi provere
 
			for (let centar of response) {                        // prolazimo kroz listu svih zaposlenih
                let row = "<tr>";                                   // kreiramo red za tabelu
				row += "<td>" + centar.id + "</td>";
				row += "<td>" + centar.naziv + "</td>";       // ubacujemo podatke jednog zaposlenog u polja
                row += "<td>" + centar.adresa + "</td>";
                row += "<td>" + centar.broj_telefona + "</td>";
				row += "<td>" + centar.email + "</td>";
				
				let bri = "<button class='briSeeMore' data-id=" + centar.id + ">Brisanje</button>";
                row += "<td>" + bri + "</td>";
				
                row += "</tr>";                                     

                $('#fitne_centri').append(row);                       
            }
        },
        error: function (response) {                               
            console.log("ERROR:\n", response);
        }
    });
});



$(document).on('click', '.briSeeMore', function() {
	//response.preventDefault();
	
	let trenerId = this.dataset.id;
	
	$.ajax({
		type: "DELETE",
		url: "http://localhost:8080/admin/" + trenerId,
		contentType: "application/json",
		success: function(response){
			console.log("SUCCESS:\n", response);
			
			window.location.href = "pregled_fitnescentara.html";                
			
		},
		error: function(response){
			console.log("ERROR:\n", response);
		}
	});
});

$(document).on("submit", "#izmenaFitnes", function (event) {
	event.preventDefault(); 
	
	let vrednost = $("#id").val();
	let kriterijum = $("#kriterijum").val();
	let zamena = $("#zamena").val();
	
	$.ajax({
		type: "PUT",
		url: "http://localhost:8080/admin/" + kriterijum + "/" + vrednost + "/" + zamena,
		contentType: "application/json",
		success: function(response){
			console.log("SUCCESS:\n", response);
			
			alert("Fitnes centar" + response.id + " je izmenjen");
			window.location.href = "pregled_fitnescentara.html";                
			
		},
		error: function(response){
			console.log("ERROR:\n", response);
		}
	});
});






