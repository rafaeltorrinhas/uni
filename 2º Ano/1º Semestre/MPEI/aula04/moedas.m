function [probSimulacao] = moedas(k,n,p,N)
    % MOEDAS - calc probabilidade de k caras em n lançamentos
    % probabilidade de cara =  p
    % simular N vezes
    % USAGE: moedas(k,n,p,N)
    % AT, 19 set 2024, MPEI
    lancamentos = rand(n,N) <= p;
    sucessos= sum(lancamentos)==k;
    probSimulacao= sum(sucessos)/N;
end
