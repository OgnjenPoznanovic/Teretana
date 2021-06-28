// Kreiranje novog zaposlenog
$(document).on("submit", "#dodajNovuSalu", function (event) {       // kada je submit-ovana forma za kreiranje novog zaposlenog
    event.preventDefault();                                         // sprečavamo automatsko slanje zahteva da bismo pokupili (i validirali) podatke iz forme

    let kapacitet = $("#kapacitet").val();
	let oznaka = $("#oznaka").val();
    let fitnessid = $("#fitnessid").val();


    let newSala = {
        kapacitet,
		oznaka,
        fitnessid
    }
    

    $.ajax({
        type: "POST",                                               
        url: "http://localhost:8080/sala",                
        dataType: "json",                                           
        contentType: "application/json",                            
        data: JSON.stringify(newSala),                          
        success: function (response) {                              
            console.log(response);                                  

            alert("Sala: " + response.id + " je uspešno kreirana!");
            window.location.href = "administrator.html";                
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
        url: "http://localhost:8080/sala",                 // URL koji se gađa
        dataType: "json",                                           // tip povratne vrednosti
        contentType: "application/json", 
		success: function (response) {                              // ova f-ja se izvršava posle uspešnog zahteva
            console.log("SUCCESS:\n", response);                    // ispisujemo u konzoli povratnu vrednost radi provere
 
			for (let sale of response) {                        // prolazimo kroz listu svih zaposlenih
                let row = "<tr>";                                   // kreiramo red za tabelu
				row += "<td>" + sale.kapacitet + "</td>";       // ubacujemo podatke jednog zaposlenog u polja
                row += "<td>" + sale.oznaka + "</td>";
                row += "<td>" + sale.fitnessid + "</td>";
				
				let bri = "<button class='briSeeMore' data-id=" + sale.id + ">Brisanje</button>";
                row += "<td>" + bri + "</td>";
				
                row += "</tr>";                                     

                $('#sale').append(row);                       
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
		url: "http://localhost:8080/sala/" + trenerId,
		contentType: "application/json",
		success: function(response){
			console.log("SUCCESS:\n", response);
			
			window.location.href = "pregled_sala.html";                
			
		},
		error: function(response){
			console.log("ERROR:\n", response);
		}
	});
});







