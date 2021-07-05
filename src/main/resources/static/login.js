$(document).on("submit", "#prijava", function (event) {    
     event.preventDefault();
	 
	 
	let korisnicko_ime = $("#korisnicko_ime").val();
    let lozinka = $("#lozinka").val();


    // kreiramo objekat zaposlenog
    // nazivi svih atributa moraju se poklapati sa nazivima na backend-u
    let newClan = {
        korisnicko_ime,
        lozinka
    }
	
	console.log(korisnicko_ime);
	console.log(lozinka);
	
    $.ajax({
        type: "POST",                        
        url: "http://localhost:8080/prijava/login",
        dataType: "json",                                           // tip povratne vrednosti
        contentType: "application/json", 
		data: JSON.stringify(newClan),
		success: function (response) {                              // ova f-ja se izvršava posle uspešnog zahteva
            console.log("SUCCESS:\n", response);                    // ispisujemo u konzoli povratnu vrednost radi provere
			
			localStorage.setItem('user', JSON.stringify(response));
			
			window.location.href = "profil";
        },
        error: function (response) {                               
            console.log("ERROR:\n", response);
			alert("Clan ne postoji");
        }
    });
});

