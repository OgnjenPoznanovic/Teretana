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
            window.location.href = "login.html";                
        },
        error: function () {                                       
            alert("Greška!");
        }
    });
});