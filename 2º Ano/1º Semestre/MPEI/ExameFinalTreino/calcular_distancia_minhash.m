function J = calcular_distancia_minhash(MH, Nu, k)

    J=zeros(Nu); % array para guardar distˆancias
   
    %% calcular distancia

    % para cada user
    for n1 = 1: Nu
        % para todos os outros
        for n2 = n1+ 1 : Nu
            % obter as 2 assinaturas (que sao colunas)
            assinatura1 = MH(:,n1);
            assinatura2 = MH(:,n2);
            % calcular num de valores iguais na mesma posiçao
            
            vi = sum(assinatura1 == assinatura2);
            % distancia = num de valores iguais / k
            
            distJ = vi / k;
            J(n1,n2) = distJ;
        end
    end
end