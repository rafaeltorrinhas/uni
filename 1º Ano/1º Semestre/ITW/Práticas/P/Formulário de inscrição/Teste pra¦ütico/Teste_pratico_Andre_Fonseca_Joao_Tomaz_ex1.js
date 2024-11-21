function validar() {
	var nomeerro=document.getElementById( "nomeerro" );
	var nome=document.getElementById( "Fn" );
	var loginerro=document.getElementById( "loginerro" );
	var login=document.getElementById( "login" );
	var passerro=document.getElementById( "passerro" );
	var pass=document.getElementById( "Password" );
	var nomecorreto=false;
	var passcorreto=false;
	var logincorreto=false;
	

	if (nome.value.length < 10 || nome.value.length > 100){
		nomeerro.innerHTML="Nome tem de ter minimo 10 caracteres e no maximo 100!!";
		nomeerro.style.color="red";
	}	
	else{
		nomecorreto=true;
		nomeerro.innerHTML="";
	}
	if (login.value.length < 10 || login.value.length > 30){
		loginerro.innerHTML="Login tem de ter no minimo 10 caracteres e no maximo 30!!";
		loginerro.style.color="red";
	}
	else{
		logincorreto = true;
		loginerro.innerHTML="";
	}
	if (pass.value.length <7 || pass.value.length >30){
		passerro.innerHTML="Password tem de ter no minimo 7 caracteres e no maximo 30!!";
		passerro.style.color="red";
	}
	else{
		passcorreto=true;
		passerro.innerHTML="";
	}
	if (nomecorreto==true && logincorreto==true && passcorreto==true){
		return true;
	
	}
	else{
		return false;
	}
	
}

/*var disciplinas={
	var sem1=[5];
	sem1[0]=document.getElementById("ALGA");
	sem1[1]=document.getElementById("EF");
	sem1[2]=document.getElementById("CI");
	sem1[3]=document.getElementById("ITW");
	sem1[4]=document.getElementById("FP");
	var e=0;
	var sem2=[5];
	sem1[0]=document.getElementById("MAS");
	sem1[1]=document.getElementById("CII");
	sem1[2]=document.getElementById("MD");
	sem1[3]=document.getElementById("IAC");
	sem1[4]=document.getElementById("POO");
	function validar(sem){
		var e=0
		for (i=0; i<sem.length;i++){
			if (sem[i].checked==true){
				e=e+1;
			}
		}
		if (e<2 || e>4){
			alert("Tem de escolher entre 2 e 4 opçoes");
			return false
		}
		else{
			return true
		}
	}
}*/