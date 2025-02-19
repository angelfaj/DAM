function calculate(operation) {
    const num1 = parseFloat(document.getElementById('num1').value);
    const num2 = parseFloat(document.getElementById('num2').value);
    let result;

    if (isNaN(num1) || isNaN(num2)) {
        document.getElementById('result').innerText = "Por favor, ingrese números válidos.";
        return;
    }

    switch (operation) {
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

    document.getElementById('result').innerText = `Resultado: ${result}`;
}