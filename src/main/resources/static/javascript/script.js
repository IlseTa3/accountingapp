console.log("Hello there!")

document.addEventListener("DOMContentLoaded",function(){
    fetch('http://localhost:8080/betalingen/voedsel')
        .then(resp => resp.json())
        .then(data => {console.log("Data ontvangen: ", data);
        })
        .catch(error => {console.error("Fout bij ophalen: ", error);
        });
});

