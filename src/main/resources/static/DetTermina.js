$(document).on('click', '.kako', function() {
	//response.preventDefault();
	
	let terminId = this.dataset.id;
	let url = "http://localhost:8080/termini/detalji/" + terminId;
	console.log(url);
	
	$.ajax({
		
		type: "GET",
		url: "http://localhost:8080/termini/detalji/" + terminId,
		contentType: "application/json",
		success: function(response){
			console.log("SUCCESS:\n", response);
			
			            // prolazimo kroz listu svih zaposlenih
                  
				let row = "<tr>";                                   // kreiramo red za tabelu
				row += "<td>" + response.id + "</td>";       // ubacujemo podatke jednog zaposlenog u polja
                row += "<td>" + response.vreme + "</td>";
                row += "<td>" + response.cena + "</td>";
				row += "<td>" + response.prijavljenih + "</td>";
				let zak = "<button class='promena' data-id=" + response.id + ">Prijava</button>";
                row += "<td>" + zak + "</td>";
				let otk = "<button class='briSeeMore' data-id=" + response.id + ">Otkazivanje</button>";
                row += "<td>" + otk + "</td>";
                row += "</tr>";                                     

                $('#detalji').append(row); 
								
            
			/*
				for (let termin of response) {                        // prolazimo kroz listu svih zaposlenih
                let row = "<tr>";                                   // kreiramo red za tabelu
				row += "<td>" + termin.id + "</td>";       // ubacujemo podatke jednog zaposlenog u polja
                row += "<td>" + termin.vreme + "</td>";
                row += "<td>" + termin.cena + "</td>";
				row += "<td>" + termin.prijavljenih + "</td>";                              
                row += "</tr>";                                     

                $('#detalji').append(row);                       
            }
			*/
			//window.location.href = "DetaljiTermina.html";               
			
		},
		error: function(response){
			console.log("ERROR:\n", response);
		}
		
	});
});