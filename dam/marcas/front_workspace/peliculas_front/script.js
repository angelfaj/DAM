function addPelicula() {          //Esta funcion añade un alumno a nuestro servidor de eclipse 
    const id_pelicula = document.getElementById("id_pelicula").value;
    const titulo = document.getElementById("titulo").value;
    const anio_publicacion = document.getElementById("anio_publicacion").value;
    const autor = document.getElementById("autor").value;
    const genero = document.getElementById("genero").value;


    console.log("addPelicula funciona");
    fetch(              // esta funcion la utiliza ajax para comunicarse con el servidor
        'http://localhost:8080/peliculas/add_pelicula',{        //url a la que se comunica
            method:'POST', headers:{
                "Content-Type":"application/json",
            },
            body: JSON.stringify({          //Este bloque añade a la BD desde los campos del formulario
                "id_pelicula": id_pelicula,
                "titulo": titulo,
                "año": anio_publicacion,
                "autor": autor,
                "género": genero
            })
        }    
    ).then(respuesta => respuesta.json())
    .then(respuesta => {
        if (respuesta == 0) {
            document.getElementById("respuesta").innerHTML = "Película añadida correctamente";
            getPeliculas();
        }else {
            document.getElementById("respuesta").innerHTML = "El id introducido ya existe en la base de datos";
        }
    })
}

function getPeliculas() {
    fetch('http://localhost:8080/peliculas/get_pelicula')
    .then(respuesta => respuesta.json())
    .then(peliculas => {
        const listaPeliculas = peliculas.map(p =>
            `ID: ${p.id_pelicula} - ${p.nombre} ${p.anio} - ${p.autor} [${p.genero}]<br>`
        ).join("");
        document.getElementById("listaPeliculas").innerHTML =  listaPeliculas;     //Esta linea llena el div del html con el listado de peliculas
    })
}

function validar() {
    var valoresCorrectos = true;

    if (document.getElementById("titulo").value.length < 2) {
        valoresCorrectos = false;
    }
    if (document.getElementById("id_pelicula").value < 1) { 
        valoresCorrectos = false;
    }
    if (document.getElementById("genero").length < 2) {
        valoresCorrectos = false;
    }
    if (document.getElementById("autor").value.length < 2) {
        valoresCorrectos = false;
    }
    if (document.getElementById("anio_publicacion").value < 1800) { 
        valoresCorrectos = false;
    }

    if (valoresCorrectos) {
        addPelicula();
    }else {
        alert("los datos no cumplen con los requisitos");
    }
}