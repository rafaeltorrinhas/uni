%% 1 a)
fprintf("1. \n")
a1 = .2;
a2 = .3;
a3 = .45;
a4 = .1;

%    1,2,3,4,5,M
T = [0,a1,0,0,1-a1,0;  % 1
     0,0,1-a2,a2,0,0;  % 2  
     0,0,0,1-a3,0,a3;  % 3
     0,1-a4,a4,0,0,0;  % 4  
     0,1,0,0 , 0 , 0;  % 5
     0,0,0,0, 0, 1]';  % M



%% 1 b)
fprintf("b) ")

v0 = [1,0,0,0,0,0]';
v3 = T^3 * v0;

fprintf("A probabilidade de seguir esse percurso é %.4f \n",v3(length(v3)));

%% 1 c)
fprintf("c) ")

Q = T(1:5,1:5);
F = inv(eye(5)-Q);

media = sum(F(1,:)) + 1; % 8.98 + meta

fprintf("O número médio de casas percorridas é %.2f \n",media);



%% 2 a)
fprintf("2. \n")

fprintf("a) ")

n = 300;
k = 1;

% se nao derem numero de funções de dispersão
% m = -n * log(0.03) / square(log(2));
% m = ceil(m);

% k = m/n * ln(2)
% pfp (% falsos positivos) = (1 - e^(-kn/m)) ^k <=> m = -(n*k/ln(1-pfp))

m = -300 / log(0.97);
m = ceil(m);

fprintf("O número de elementos do bloom filter vai ser %d \n", m);


%% 2 b)

fprintf("b) ")

bf = zeros(1,m);

palavras = randKeys(n);

for i = 1:length(palavras)
    bf = adicionar(palavras(i),bf,k);
end

n_test = 1e5;
palavras_test = randKeys(n_test);
trues = 0;
for i = 1:length(palavras_test)
    res = pertence(palavras_test(i),bf,k);
    if res == true
       trues = trues + 1;
    end
end

pfp = trues / n_test;
fprintf("A probabilidade de falsos positivos é %.3f \n",pfp)

%% 3.

fprintf("3. ")

frase1 = 'Lisboa e Porto são duas cidades importantes de Portugal.';
frase2 = 'Lisboa é a capital de Portugal.';
frase3 = 'Porto é a capital do Norte de Portugal.';
frase4 = 'Portugal não é só Lisboa e Porto.';

frases = {frase1,frase2,frase3,frase4};
Nu = 4;
k = 4;
shinglesize = 3;

minHash = zeros(k, Nu);  

nhf = 4;

% minHash
for i = 1 : Nu
    shingles = getShingles(char(frases{i}),shinglesize);
    for j = 1 : nhf
        min=intmax;
        for k = 1:length(shingles)
            hash = hf1(shingles{k}, j);
            if min > hash
                min = hash;
            end
        end
        minHash(j,i) = min;
     end
end

% Distancia de Jaccard
J=zeros(Nu); 
for n1 = 1: Nu
    for n2 = n1 : Nu
        vi = sum(minHash(:,n1) == minHash(:,n2));
        distJ = 1 - vi / nhf;
        J(n1,n2) = distJ;
    end
end

 fprintf("Assinatura: \n");
 fprintf("Frase 1 - %d %d %d %d \n",minHash(:,1));
 fprintf("Frase 2 - %d %d %d %d \n",minHash(:,2));
 fprintf("Frase 3 - %d %d %d %d \n",minHash(:,3));
 fprintf("Frase 4 - %d %d %d %d \n",minHash(:,4));

