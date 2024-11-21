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


%%

nl = 100;
p = zeros(nl+1,1)
for k=0:nl
    p(k+1)=moedas(k,nl,0.5,1e4);

end
plot(0:nl,p,'*')
