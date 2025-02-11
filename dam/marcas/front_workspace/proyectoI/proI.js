var contador = 0;


window.onload = function(){
    incrementar = document.getElementById("incrementButon");
    incrementar.addEventListener("click", suma);
    decrementar = document.getElementById("decrementButon");
    decrementar.addEventListener("click", resta);
    setContador = document.getElementById("initButon");
    setContador.addEventListener("click", inicializar);
}

function suma() {
    contador++;
    //alert("Hola mundo");
    console.log("El contador vale: " + contador);
}

function resta() {
    contador--;
    //alert("Hola mundo");
    console.log("El contador vale: " + contador);
}

function inicializar() {
    contador = document.getElementById("initButon").value;
}

