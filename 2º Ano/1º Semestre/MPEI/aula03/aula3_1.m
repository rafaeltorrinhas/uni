%% 2.2 1. a)

N = 1e6;  % Simulações
n = 2;    % nº de lançamentos
exp = randi(6, n, N);

% A = "Soma = 9"

A = sum(exp) == 9;

% B = "2º ser par"

B = mod(exp(2,:), 2) == 0;

% C = "Pelo menos um cinco"

C = any(exp == 5);

% D = "nenhum 1"

D = all(exp ~= 1);


prob_A = sum(A) / N
prob_B = sum(B) / N
prob_C = sum(C) / N
prob_D = sum(D) / N

%% 2.2 1. b)

% Os casos possíveis de AB são 2, logo, P(AB) = 2/36
% P(A)*P(B)=4/36 *1/2 = 2/36 = P(AB), logo são independentes

%% 2.2 1. c)

% Os casos possíveis de CD são 9, logo P(CD) = 9/36
% P(C)*P(D)=11/36*25/36 != P(CD), logo não são independentes

%% 2.3 1. a)

% André  -  1/100   - 20 programas
% Bruno  -  5/100   - 30 programas
% Carlos -  1/1000  - 50 programas


% P(ERRO) = P(A) * P(E|A) + P(B) * P(E|B) + P(C) * P(E|C)
% 20/100 * 1/100 + 30/100 * 5/100 + 50/100 * 1/1000 = 0.0175

% P(C|ERRO) = P(C /\ ERRO)/P(ERRO) = P (ERRO|C) * P(C)

% P(C|ERRO) = (50/100 * 1/1000) / 175/10000 = 0.0286


%% 2.3 1. b) 

% ERRO = E
% P(A|E) = P(E|A) * P(A) = 0.1143
% P(B|E) = P(E|B) * P(B) = 0.8571
% P(C|E) = 0.0286

%% 2.3 1. a) exp.

N = 1e6; % nº de simulações

n = [20,30,50];

% Probabilidade de serem escolhidos
pA = 20/100;
pB = 30/100;
pC = 50/100; 
pEA= 0.01;           % P(Erro|André)
pEB= 0.05;           % P(Erro|Bruno)
pEC= 0.001;          % P(Erro|Carlos)

% Simulação de erros para cada um dos programadores
A = rand(n(1), N) < pEA;
B = rand(n(2), N) < pEB;
C = rand(n(3), N) < pEC;

EXP = [A; B; C];

pE= sum(sum(EXP))/(N*100); 

pTotalC = (pC * pEC)/pE

%% 2.3 1. b) exp
% Dar run à alínea a) primeiro
% pTotalC = .0286
pTotalA = (pA * pEA)/pE
pTotalB = (pB * pEB)/pE

% Maior prob. do bruno.


%% 2.3 2.

N = 1e5;
p = 3;
n = 2;

seq = randi(3,n,N);

CP = 0;

for c = 1:N
    if seq(1,c) == 2 || seq(2,c) == 2 % Casos possíveis (a sequência tem 2)
        CP = CP+1;
    end
end

CF = 0;

for c = 1:N
    if (seq(1,c)==1 && seq(2,c)==2) || (seq(1,c)==2 && seq(2,c)==1) % Casos favoráveis (a sequência tem 1 e 2)
        CF = CF+1;
    end
end


pCF = CF/N;
pCP = CP/N;

pTotal = pCF/pCP
