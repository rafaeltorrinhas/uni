function J = calcular_distancia_minhash(Set, Nu, k, R)

    J=zeros(Nu); % array para guardar distˆancias
    h= waitbar(0,'Calculating');
    
    % for n1= 1:Nu
    %     waitbar(n1/Nu,h);
    %     for n2= n1+1:Nu
    % 
    %         C1 = Set{n1};
    %         C2 = Set{n2};
    %         intersecao = intersect(C1,C2);
    %         uniao = union(C1,C2);
    %         similJ = length(intersecao) / length(uniao);
    %         distJ = 1- similJ;
    %         J(n1,n2) = distJ;
    % 
    %     end
    % end


    %% 1- calcular matriz minhash
    
    MH = zeros(k, Nu);  % linha - hash function
    
    % para cada funçao de hash
    for hf = 1 : k
        % para cada user (conjunto do user)
         for user = 1 : Nu
             conjunto = Set{user};
             hashlist = zeros(1,length(conjunto));
            % aplicar funçao de hash a todos os elementos do conjunto
            for elem = 1:length(conjunto)
                hash_code = hash_function(conjunto(elem),hf,R);
                hashlist(elem) = hash_code;
            end
            % obter minimo dos hashcodes
            minhash = min(hashlist);
            % guardar na matriz (posiçao = hash, user)
            MH(hf,user) = minhash;
         end
    end

    %% 2- calcular distancia

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