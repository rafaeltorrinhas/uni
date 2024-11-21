// Example starter JavaScript for disabling form submissions if there are invalid fields
var contador=0;

(function () {
    'use strict'

    // Fetch all the forms we want to apply custom Bootstrap validation styles to
    var forms = document.querySelectorAll('.needs-validation')

    // Loop over them and prevent submission
    Array.prototype.slice.call(forms)
        .forEach(function (form) {
            form.addEventListener('submit', function (event) {
                //-- Têm de ser válidas as duas funções
                if (!form.checkValidity() || !checkStatus()) {
                    event.preventDefault()
                    event.stopPropagation()
                }

                form.classList.add('was-validated')
            }, false)
        })
})()

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
          document.getElementById("question"+i+"_F").checked=false;
          document.getElementById("question"+i+"_T").checked=false;
          contador=0;
          document.getElementById("answers").value = String(contador)
          checkStatus(i)
        }

}

function clearAnswer(q,element) {
  
    if (!element.classList.contains("selected")) {
        contador--;
        element.classList.remove("selected");
        element.checked=false;
        document.getElementById("answers").value = String(contador)}
        document.getElementById("question"+q+"_F").checked=false;
        document.getElementById("question"+q+"_T").checked=false;
        checkStatus(q);
   
    
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
          document.getElementById("answers").value = String(contador)}
        
        if (contador <= 8) {
        retVal = false;
        document.getElementById("submitButton").disabled="disabled";
        }
        else{
            document.getElementById("submitButton").disabled="";
        }
        return retVal;
        }

       

