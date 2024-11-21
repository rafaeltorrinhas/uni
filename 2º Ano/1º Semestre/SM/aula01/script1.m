%% gerar sequencia de numeros impares entre 1 e 10
seq1 = 1:2:10

%% gerar sequencia de 11 numeros inteiros entre -5 e 5 (resolver 2 formas)
seq2 = -5:1:5
seq2_1 = 5:-1:-5

%% gerar a matriz A = [1, 5, 1-j;4, j, -1]
A = [1,5,1-j;4,j,-1]

%% adicionar uma linha e uma coluna
A(:,4) = [83;2]
A(3,:) = [10,-4,9,10]

%% apagar colunas ímpares
B = A(:,2:2:end)