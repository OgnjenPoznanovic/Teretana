$(document).on("submit", "#dodajtrenera", function (event) {     // kada je submit-ovana forma za kreiranje novog zaposlenog
    event.preventDefault();                                         // sprečavamo automatsko slanje zahteva da bismo pokupili (i validirali) podatke iz forme

    // preuzimamo vrednosti unete u formi
    let korisnicko_ime = $("#korisnicko_ime").val();
    let lozinka = $("#lozinka").val();
    let ime = $("#ime").val();
	let telefon = $("#telefon").val();
	let email = $("#email").val();
	let uloga = $("#uloga").val();
	let rodjendan = $("#rodjendan").val();
	//let aktiva = $("#aktivan").val();

    // kreiramo objekat zaposlenog
    // nazivi svih atributa moraju se poklapati sa nazivima na backend-u
    let newTrener = {
        korisnicko_ime,
        lozinka,
        ime, 
		telefon,
		email,
		uloga,
		rodjendan,
		//aktivan
    }
    
    // ajax poziv za kreiranje novog zaposlenog na backend-u
    $.ajax({
        type: "POST",                                               // HTTP metoda je POST
        url: "http://localhost:8080/trener",                 // URL na koji se šalju podaci
        dataType: "json",                                           // tip povratne vrednosti
        contentType: "application/json",                            // tip podataka koje šaljemo
        data: JSON.stringify(newTrener),                          // u body-ju šaljemo novog zaposlenog (JSON.stringify() pretvara JavaScript objekat u JSON)
        success: function (response) {                              // ova f-ja se izvršava posle uspešnog zahteva
            console.log(response);                                  // ispisujemo u konzoli povratnu vrednost radi provere

            alert("Trener " + response.id + " je uspešno kreiran!");// prikazujemo poruku uspeha korisniku
            window.location.href = "login.html";                // redirektujemo ga na employees.html stranicu
        },
        error: function () {                                        // ova f-ja se izvršava posle neuspešnog zahteva
            alert("Greška!");
        }
    });
});



$(document).ready(function () {    // Čeka se trenutak kada je DOM(Document Object Model) učitan da bi JS mogao sa njim da manipuliše.
    // ajax poziv za dobavljanje svih zaposlenih sa backend-a i prikaz u tabeli
    $.ajax({
        type: "GET",                                                // HTTP metoda
        url: "http://localhost:8080/trener",                 // URL koji se gađa
        dataType: "json",                                           // tip povratne vrednosti
        success: function (response) {                              // ova f-ja se izvršava posle uspešnog zahteva
            console.log("SUCCESS:\n", response);                    // ispisujemo u konzoli povratnu vrednost radi provere
 
            for (let trener of response) {                        // prolazimo kroz listu svih zaposlenih
                let row = "<tr>";                                   // kreiramo red za tabelu
                row += "<td>" + trener.korisnicko_ime + "</td>";       // ubacujemo podatke jednog zaposlenog u polja
                row += "<td>" + trener.email + "</td>";
                row += "<td>" + trener.aktivan + "</td>";
                // kreiramo button i definisemo custom data atribut id = id zaposlenog
                let btn = "<button class='btnSeeMore' data-id=" + trener.id + ">Odobri</button>";
                row += "<td>" + btn + "</td>";                      // ubacujemo button u poslednju ćeliju reda
                row += "</tr>";                                     // završavamo kreiranje reda

                $('#treneri').append(row);                        // ubacujemo kreirani red u tabelu čiji je id = employees
            }
        },
        error: function (response) {                                // ova f-ja se izvršava posle neuspešnog zahteva
            console.log("ERROR:\n", response);
        }
    });
});








































