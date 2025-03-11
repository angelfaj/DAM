function addAlumno() {          //Esta funcion añade un alumno a nuestro servidor de eclipse 
    console.log("addAlumno funciona");
    fetch(              // esta funcion la utiliza ajax para comunicarse con el servidor
        'http://localhost:8090/alumnos/add_alumno',{        //url a la que se comunica
            method:'POST', headers:{
                "Content-Type":"application/json",
            },
            body: JSON.stringify({
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
    if (document.getElementById("id_alumno").value < 1) {
        valoresCorrectos = false;
    }
    if (document.getElementById("asignatura").length < 2) {
        valoresCorrectos = false;
    }

    if (valoresCorrectos) {
        addAlumno();
    }else {
        alert("los datos no cumplen con los requisitos");
    }
}