//--- TODO
inputPrecoTotal = document.getElementById("total");
inputQtdTotal = document.getElementById("quantidades")
precoTotal = 0
qtdTotal = 0

function addProduct(number) {
  qtdProdSelec = document.getElementById("qty" + number)
  qtdProdSelec.value++;
  calculate();
}

function calculate() {
  for (i = 1; i <= 6; i++) {
    precAtual = parseFloat(document.getElementById("price" + i).value);
    qtdAtual = parseFloat(document.getElementById("qty" + i).value);
    precoTotal = precAtual * qtdAtual;
    qtdTotal += qtdAtual;
  }

  if (precoTotal>100){
  precoTotal = precoTotal * 0.95  
  }

  if (qtdTotal>=5){
    precoTotal = precoTotal * 0.95
  }
  inputQtdTotal.innnerText = qtdTotal;
  inputPrecoTotal.innertext = precoTotal.toFixed(2);
}

function valid() {
  if (precoTotal <= 0 && qtdTotal <= 0) {
      alert("Erro o carrinho está vazio");
      return false;
  } else {
      return true
  }
}

function clean() {
  for (let i = 1; i <= 6; i++) {
      qtdAtual = document.getElementById('qty' + i).value = 0;
  }
  precoTotal = 0;
  qtdTotal = 0;
  inputPrecoTotal.innerText = "0.00";
  inputQtdTotal.innerText = 0;
}