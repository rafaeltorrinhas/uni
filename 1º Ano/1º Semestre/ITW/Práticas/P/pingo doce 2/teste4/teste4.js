//--- TODO
var quantidade = document.getElementById("quantidades");
var total = document.getElementById("total");
var desconto5 = false;
var desconto100 = false;

function comprar(number) {
    var item = document.getElementById('produto' + number);
    var nr_itens = parseFloat(item.value) + 1;
    item.value = nr_itens.toString();
    calcular()
}

function calcular() {
    var produto1 = parseInt(document.getElementById('produto1').value);
    var produto2 = parseInt(document.getElementById('produto2').value);
    var produto3 = parseInt(document.getElementById('produto3').value);
    var produto4 = parseInt(document.getElementById('produto4').value);
    var produto5 = parseInt(document.getElementById('produto5').value);
    var produto6 = parseInt(document.getElementById('produto6').value);

    var precoproduto1 = parseFloat(document.getElementById('precoproduto1').value);
    var precoproduto2 = parseFloat(document.getElementById('precoproduto2').value);
    var precoproduto3 = parseFloat(document.getElementById('precoproduto3').value);
    var precoproduto4 = parseFloat(document.getElementById('precoproduto4').value);
    var precoproduto5 = parseFloat(document.getElementById('precoproduto5').value);
    var precoproduto6 = parseFloat(document.getElementById('precoproduto6').value);

    var nr_produtos = produto1 + produto2 + produto3 + produto4 + produto5 + produto6;
    console.log(nr_produtos);
    var preco_final = produto1 * precoproduto1 + produto2 * precoproduto2 + produto3 * precoproduto3 + produto4 * precoproduto4 + produto5 * precoproduto5 + produto6 * precoproduto6;

    if (nr_produtos >= 5 && desconto5 == false) {
        desconto5 = true;
        preco_final *= 0.95;
    }
    if (preco_final > 100 && desconto100 == false) {
        desconto100 = true;
        preco_final *= 0.95;
    }

    quantidade.innerText = nr_produtos;
    total.innerText = preco_final.toFixed(2);

}
calcular()

var contagem = 0;
var lst = [produto1, produto2, produto3, produto4, produto5, produto6]

function validar() {
    var controlo = true;
    var x = parseInt(document.getElementById('quantidades').innerHTML)

    if (x == 0) {
        controlo = false;
        alert('Precisa de pelo menos um produto para efetuar checkout');
    } else {
        controlo = true;
    }

    for (var i = 0; i <= lst.length; i++) {
        if (lst[i] >= 1) {
            contagem += 1;
        }
    }
    if (contagem < 2) {
        alert('Precisa de pelo menos dois produtos diferentes');
        controlo = false;
    }
    else{
        controlo = true;
    }
    return controlo
}

function limpar() {
    for (var i = 1; i <= 4; i++) {
        var y = document.getElementById("produto" + i);
        y.value = '0';
    }
    total.innerText = '0.00';
    quantidade.innerText = 0;
}