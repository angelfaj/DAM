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
                "anio": anio_publicacion,
                "autor": autor,
                "genero": genero,
            })
        }    
    ).then(respuesta => respuesta.json())
    .then(respuesta => {                    //Bloque informativo para el usuario
        const respuestaElemento = document.getElementById("respuesta");

        if (respuesta == 0) {
            respuestaElemento.innerHTML = "🎉 Película añadida correctamente";
            respuestaElemento.className = "mensaje-respuesta mensaje-exito";
        } else {
            respuestaElemento.innerHTML = "⚠️ El ID introducido ya existe en la base de datos";
            respuestaElemento.className = "mensaje-respuesta mensaje-error";
        }

    })
}

function getPeliculas() {                   //Llamamos al servicio para que nos muestre las peliculas guardadas
    fetch('http://localhost:8080/peliculas/get_peliculas')
    .then(respuesta => respuesta.json())
    .then(peliculas => {
        let tabla = `
            <table border="1">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Título</th>
                        <th>Año</th>
                        <th>Autor</th>
                        <th>Género</th>
                    </tr>
                </thead>
                <tbody>
        `;

        peliculas.forEach(p => {
            tabla += `
                <tr>
                    <td>${p.id_pelicula}</td>
                    <td>${p.nombre || p.titulo}</td>
                    <td>${p.anio}</td>
                    <td>${p.autor}</td>
                    <td>${p.genero}</td>
                </tr>
            `;
        });

        tabla += `
                </tbody>
            </table>
        `;

        document.getElementById("listaPeliculas").innerHTML = tabla;
    });
}


function validar() {
    var valoresCorrectos = true;

    if (document.getElementById("titulo").value.length < 2) {
        valoresCorrectos = false;
    }
    if (document.getElementById("id_pelicula").value < 1) { 
        valoresCorrectos = false;
    }
    if (document.getElementById("autor").value.length < 2) {
        valoresCorrectos = false;
    }
    if (document.getElementById("anio_publicacion").value < 1888) {         //La pelicula más antigua de la que se tiene constancia es del año 1888
        valoresCorrectos = false;
    }

    if (valoresCorrectos) {
        addPelicula();
    }else {
        alert("Los datos no cumplen con los requisitos, por favor revisa la información introducida.");
    }
}