/*Variáveis globais*/
var contador=0;

'use strict';
 window.addEventListener('load', function() {
    // Fetch all the forms we want to apply custom Bootstrap validation styles to
    var forms = document.getElementsByClassName('needs-validation');
    // Loop over them and prevent submission
    var validation = Array.prototype.filter.call(forms, function(form) {
      form.addEventListener('submit', function(event) {
        if (form.checkValidity() === false) {
          event.preventDefault();
          event.stopPropagation();
        }
        form.classList.add('was-validated');
      }, false);
    });
  }, false);


function clearForm() {
    document.getElementById("NMEC").value=""
    document.getElementById("name").value=""
    document.getElementById("email").value=""
    document.getElementById("degree").value=""
    clearAnswers();
    var formulario = document.getElementById("formulario");
    if (formulario.classList.contains("was-validated")) {
      formulario.classList.remove("was-validated");
    };
}

function clearAnswers() {
    for (var i=1; i<13; i++) {
      for (var n=0; n<6; n++) {
        document.getElementById("question"+i+"_"+n).checked=false;
        contador=0;
      }
    }
}

function checkStatus(element) {
    if (element.checked==true){
      if (element.classList.contains("selected")) {
        contador--;
        element.classList.remove("selected");
        element.checked=false;
      } else {
        contador++;
        console.log("selecionado")
        element.classList.add("selected");
      }
    }
    console.log(contador); 
    if (contador<8){
      document.getElementById("submitButton").disabled="disabled";
    
    }else{   
      document.getElementById("submitButton").disabled="";

    }

}


