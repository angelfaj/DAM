function addPelicula() {          //Esta funcion añade un alumno a nuestro servidor de eclipse 
    console.log("addPelicula funciona");
    fetch(              // esta funcion la utiliza ajax para comunicarse con el servidor
        'http://localhost:8080/peliculas/add_pelicula',{        //url a la que se comunica
            method:'POST', headers:{
                "Content-Type":"application/json",
            },
            body: JSON.stringify({          //Modificar este bloque para que añada desde los campos del formulario
                "id_alumno":100,
                "nombre":"JUAN",
                "asignatura":"lenguaje marcas",
                "nota":9.6
            })
        }    
    )           
}

function validar() {
    var valoresCorrectos = true;

    if (document.getElementById("name").value.length < 2) {
        valoresCorrectos = false;
    }
    if (document.getElementById("id_pelicula").value < 1) { //Modificar estos campos tambn
        valoresCorrectos = false;
    }
    if (document.getElementById("asignatura").length < 2) {
        valoresCorrectos = false;
    }

    if (valoresCorrectos) {
        addPelicula();
    }else {
        alert("los datos no cumplen con los requisitos");
    }
}