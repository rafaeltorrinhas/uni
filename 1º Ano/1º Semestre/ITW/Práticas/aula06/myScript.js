var op1 = document.getElementById("op1");
var op2 = document.getElementById("op2");
var res = document.getElementById("res");

function getOperacao() {
  var o = document.getElementById("operacao");
  operacao = o.options[o.selectedIndex].value;
  console.log(operacao);
}

function calcula() {
  switch (operacao) { 
    case "+":
      res.value = parseFloat(op1.value) + parseFloat(op2.value);
      break;
    case "-":
      res.value = op1.value - op2.value;
      break;
    case "/":
      if (op2.value != 0) {
        res.value = op1.value / op2.value;
      }
      else {
        alert("Erro. Operação inválida...")
        res.value = "ERROR";
      }
      break;       
    case "x":
      res.value = op1.value * op2.value;  
      break;
    case "%":
      res.value = op1.value % op2.value;
      break;
  }
}