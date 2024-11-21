function valida() {
    const forms = document.querySelectorAll('.needs-validation');
    const form = forms[0];
    const isValid = form.checkValidity();

    form.classList.add('was-validated')

    if (!isValid) {
        event.preventDefault()
        event.stopPropagation()
    } else {
		let mediaV = media();

		let nome = document.getElementById("fld_1").value;
		let male = document.getElementById("field_21").checked; let det = male ? "O" : "A";

		let data = new Date(document.getElementById("field_4").value);
		let dia = data.getDate();
		let mes = data.toLocaleString('pt-PT', { month: 'long' });
		let ano = data.getFullYear();

		let value = `${det} ${nome}, nascido no dia ${dia} de ${mes} de ${ano} têm uma média de ${mediaV} valores`;
		document.getElementById("media").value = value;
	}

    return isValid
}


function limpa() {
    document.getElementById("media").value = "";
    const forms = document.querySelectorAll('.needs-validation');
    const form = forms[0];
    form.classList.remove('was-validated')
}

function media() {
    const field_51 = parseFloat(document.getElementById("field_51").value);
    const field_52 = parseFloat(document.getElementById("field_52").value);
    const field_53 = parseFloat(document.getElementById("field_53").value);
    const field_54 = parseFloat(document.getElementById("field_54").value);
    const field_55 = parseFloat(document.getElementById("field_55").value);

    return (field_51 + 
			field_52 +
			field_53 +
			field_54 +
			field_55) / 5
}


// FÓRMULAS
// ----------------------------------------------------------------
// new Date("2019-11-09").getDate();     //--- Devolverá 9
// new Date("2019-11-09").getMonth();    //--- Devolverá 11
// new Date("2019-11-09").getFullYear(); //--- Devolverá 2019
//
// document.getElementById("myCheck").checked //--- testa se uma checkbox/radiobox está checked