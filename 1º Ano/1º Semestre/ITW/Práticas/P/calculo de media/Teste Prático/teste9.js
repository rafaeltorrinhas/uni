function enviar() {

    var valid = true

    for (let i = 0; i<10, i++;) {
        var nota = parseFloat(document.getElementById("field3" + i).value);        
        if (nota < 0 || nota > 20 ) {
            document.getElementById("fld_" + i + "_error").classList.remove("d-none");
        valid = false;
        } else {
            if (!document.getElementById("fld_" + i  + "_error").classList.contains("d-none")) {
                document.getElementById("fld_" + i + "_error").classList.add("d-none");
            }
            valid = true;
        }
    }

    if (document.getElementById("fld_1").value.split(" ").length < 2) {
        valid = false
        document.getElementById("fld_1_Error").classList.remove("d-none");
    } else {
        if (document.getElementById("fld_1_error").classList.contains("d-none")) {
            document.getElementById("fld_1_error").classList.add("d-none");
        }
        valid = true
    }

    return valid;

}


function calcular() {

    d11 = parseFloat(document.getElementById("field_30").value);
    d12 = parseFloat(document.getElementById("field_31").value);
    d13 = parseFloat(document.getElementById("field_32").value);
    d14 = parseFloat(document.getElementById("field_33").value);
    d15 = parseFloat(document.getElementById("field_34").value);
    d21 = parseFloat(document.getElementById("field_35").value);
    d22 = parseFloat(document.getElementById("field_36").value);
    d23 = parseFloat(document.getElementById("field_37").value);
    d24 = parseFloat(document.getElementById("field_38").value);
    d25 = parseFloat(document.getElementById("field_39").value);

    avg_1 = (d11 + d12 + d13 + d14 + d15) / 5
    avg_2 = (d21 + d22 + d23 + d24 + d25) / 5

    document.getElementById("avg_1").value = avg_1;
    document.getElementById("avg_2").value = avg_2;
    document.getElementById("avg_t").value = (avg_1 + avg_2) / 2;






}

function limpar() {

    document.getElementById("fld_1").value = ""
    document.getElementById("fld_2").value = ""
    document.getElementById("field_30").value = ""
    document.getElementById("field_31").value = ""
    document.getElementById("field_32").value = ""
    document.getElementById("field_33").value = ""
    document.getElementById("field_34").value = ""
    document.getElementById("field_35").value = ""
    document.getElementById("field_36").value = ""
    document.getElementById("field_37").value = ""
    document.getElementById("field_38").value = ""
    document.getElementById("field_39").value = ""
    document.getElementById("avg_1").value = ""
    document.getElementById("avg_2").value = ""
    document.getElementById("avg_t").value = ""

}

// FÓRMULAS
// ----------------------------------------------------------------
// new Date("2019-11-09").getDate();     //--- Devolverá 9
// new Date("2019-11-09").getMonth();    //--- Devolverá 11
// new Date("2019-11-09").getFullYear(); //--- Devolverá 2019
// 
// document.getElementById("myCheck").checked //--- testa se uma checkbox/radiobox está checked
