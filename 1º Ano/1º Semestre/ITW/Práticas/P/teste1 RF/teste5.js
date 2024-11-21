//--- TODO
var qtd = document.getElementById("quantidades");
var total = document.getElementById("total");
var precoprod1 = parseFloat(document.getElementById("precoproduto1").value);
var precoprod2 = parseFloat(document.getElementById("precoproduto2").value);
var precoprod3 = parseFloat(document.getElementById("precoproduto3").value);
var precoprod4 = parseFloat(document.getElementById("precoproduto4").value);
var prod1 = parseFloat(document.getElementById("produto1").value);
var prod2 = parseFloat(document.getElementById("produto2").value);
var prod3 = parseFloat(document.getElementById("produto3").value);
var prod4 = parseFloat(document.getElementById("produto4").value);
var somaprod = prod1 + prod2 + prod3 + prod4;
var precototal = prod1*precoprod1 + prod2*precoprod2 + prod3*precoprod3 + prod4*precoprod4;

function comprar(number){
    var prod = document.getElementById("produto"+number);
    var x = parseFloat(prod.value) + 1;
    prod.value = x.toString();
    calcular();
}

function calcular(){
    var qtd = document.getElementById("quantidades");
    var total = document.getElementById("total");
    var precoprod1 = parseFloat(document.getElementById("precoproduto1").value);
    var precoprod2 = parseFloat(document.getElementById("precoproduto2").value);
    var precoprod3 = parseFloat(document.getElementById("precoproduto3").value);
    var precoprod4 = parseFloat(document.getElementById("precoproduto4").value);
    var prod1 = parseFloat(document.getElementById("produto1").value);
    var prod2 = parseFloat(document.getElementById("produto2").value);
    var prod3 = parseFloat(document.getElementById("produto3").value);
    var prod4 = parseFloat(document.getElementById("produto4").value);
    var somaprod = prod1 + prod2 + prod3 + prod4;
    var precototal = prod1*precoprod1 + prod2*precoprod2 + prod3*precoprod3 + prod4*precoprod4;
    var precofinal = 0;

    if (somaprod >= 5){
        var desc1 = 0.05*precototal;
        precofinal = precototal - desc1;
    }
    else{
        precofinal = precototal;
    }

    if (precototal>100){
        var desc2 = 0.05*precofinal;
        precofinal = precototal - desc2;
    }
    qtd.innerText = somaprod;
    total.innerText = precofinal.toFixed(2);
}   

function limpar() {
    //--- TODO: escrever o código em falta aqui...
    for (var i=1; i<=4; i++){
    var x = document.getElementById("produto"+i);
    x.value = "0";
    }
    qtd.innerText = 0
    total.innerText = "0.00"
}

function validar() {
    //--- TODO: escrever o código em falta aqui...
    //--- Se a função retornar true o formulário será enviado; 
    //--- Se a função retornar false, o formulário não será enviaddo.
    var val = true;
    var qtd = parseFloat(document.getElementById("quantidades").innerHTML);
    if (qtd==0){
        val = false;
        alert("Tem que comprar pelo menos um produto.")
        
    }
    return val;

}