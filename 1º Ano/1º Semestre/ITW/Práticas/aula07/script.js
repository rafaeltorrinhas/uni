var op1 = ""
var op2 = ""
var operacao = ""
res = op1+operacao+op2;
tecla = tecla.target.value;
console.log(tecla);


function addNumber() { 
  if (operacao==""){
    op1 += tecla.value;
  }
  else{
    op2 += tecla.value;
  }
  res.innerText = op1+operacao+op2

}

function addOperation() {

}
