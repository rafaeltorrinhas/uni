function [BF] = adicionar(elemento,BF,k)
chave = char(elemento);
% repetir k vezes
for i = 1:k      
%       aplicar a funçao hash a elemento
%               obtem-se indice
        indice = string2hash(chave);   

%       garantir que indice esta no intervalo 1:n
        
        indice = mod(indice,length(BF)) + 1;

%       na posiçao indice do array iguala a 1
        
        BF(indice) = 1;
end

end