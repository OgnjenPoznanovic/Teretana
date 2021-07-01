$(document).on("submit", "#dodajnovitermin", function (event) {     // kada je submit-ovana forma za kreiranje novog zaposlenog
    event.preventDefault();                                         // sprečavamo automatsko slanje zahteva da bismo pokupili (i validirali) podatke iz forme

    // preuzimamo vrednosti unete u formi
    let vreme = $("#vreme").val();
    let cena = $("#cena").val();
    let prijavljenih = $("#prijavljenih").val();
	

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
        url: "http://localhost:8080/termini/novi",                 // URL na koji se šalju podaci
        dataType: "json",                                           // tip povratne vrednosti
        contentType: "application/json",                            // tip podataka koje šaljemo
        data: JSON.stringify(newTermin),                          // u body-ju šaljemo novog zaposlenog (JSON.stringify() pretvara JavaScript objekat u JSON)
        success: function (response) {                              // ova f-ja se izvršava posle uspešnog zahteva
            console.log(response);                                  // ispisujemo u konzoli povratnu vrednost radi provere

            alert("Termin " + response.id + " je uspešno kreiran!");// prikazujemo poruku uspeha korisniku
           // window.location.href = "login.html";                // redirektujemo ga na employees.html stranicu
        },
        error: function () {                                        // ova f-ja se izvršava posle neuspešnog zahteva
            alert("Greška!");
        }
    });
});