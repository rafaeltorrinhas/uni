function [Set, Nu, users] = criar_conjuntos(ficheiro)
% USAGE: [Set, Nu, users] = criar_conjuntos('u.data')


udata = load(ficheiro);

% Fica apenas com as duas primeiras colunas
u= udata(1:end,1:2); clear udata;

% Lista de utilizadores
users = unique(u(:,1)); % Extrai os IDs dos utilizadores

Nu= length(users); % Numero de utilizadores

% Constr´oi a lista de filmes para cada utilizador
Set= cell(Nu,1); % Usa celulas

for n = 1:Nu % Para cada utilizador
    % Obt´em os filmes de cada um
    ind = find(u(:,1) == users(n));
    % E guarda num array. Usa celulas porque utilizador tem um numero
    % diferente de filmes. Se fossem iguais podia ser um array
    Set{n} = [Set{n} u(ind,2)];
end

end

