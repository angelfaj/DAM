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