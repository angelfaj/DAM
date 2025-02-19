function calcular(operacion) {
    const num1 = parseFloat(document.getElementById('textInput1').value);
    const num2 = parseFloat(document.getElementById('textInput2').value);
    let result;

    if (isNaN(num1) || isNaN(num2)) {               //Con este if impedimos que opere con valores que no sean números, por ejemplo el error que muestra al dividir por 0.
        document.getElementById('resultado').innerText = "Por favor, ingrese números válidos.";
        return;
    }

    switch (operacion) {
        case 'sumar':
            result = num1 + num2;
            break;
        case 'restar':
            result = num1 - num2;
            break;
        case 'multiplicar':
            result = num1 * num2;
            break;
        case 'dividir':
            result = num1 / num2;
            break;
        case 'potencia':
            result = Math.pow(num1, num2);
            break;
        default:
            result = 'Operación no válida';
    }
    console.log("result vale:" + result);
    document.getElementById('resultado').innerText = `TOTAL: ${result}`;
}