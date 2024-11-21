%% 2.1 1 a)

N = 1e3; 
p = 0.5; 
k = 1; % prob de ter 1 rapaz
n = 2; 
familias = rand(n,N) < p;
rapazes= sum(familias)>=k; % prob de terem 1 ou mais rapazes
probSimulacao= sum(rapazes)/N

%% 2.1 1 b)

% Os casos possíveis são MM MF FM FF, logo,
% destes 4 casos possíveis 3 são favoráveis
% então a probabilidade é 3/4 = 0.75, que é
% a aproximação do valor do resultado da alínea a)

%% 2.1 1 c)

N = 1e5; 
p = 0.5; 
k = 1; 
n = 2; 
exp = rand(n,N) < p;
cpos = sum(exp)>=k;
cfav = sum(exp)==2;
probSimulacao= cfav/cpos

%% 2.1 1 d)

N = 1e3; 
p = 0.5; % prob de ser rapaz
k = 1;
n = 2; 
exp = rand(n,N) < p;
rapaz= sum(exp)==k; % prob do segundo filho ser rapaz
probSimulacao= sum(rapaz)/N

%% 2.1 1 e)

N = 1e6; 
p = 0.5;  
n = 5; 
exp = rand(n,N) < p;
cpos = sum(exp) >= 1;
cfav = sum(exp) == 2;
probSimulacao= cfav/cpos

%% 2.1 1 f)

N = 1e6; 
p = 0.5;  
n = 5; 
exp = rand(n,N) < p;
cpos = sum(exp) >= 1;
cfav = sum(exp) >= 3;
prob = cfav/cpos

%% 2.1 2 a)

N = 1e6;  
n = 20;    % nº de dardos
m = 100;   % nº de alvos
cfav = 0;
exp = randi(m,n,N); % randi(nmáx, n linhas, n colunas)

for c = 1:N
    col = exp(:,c);
    if length(unique(col)) == n
        cfav = cfav + 1;
    end
end

prob = cfav / N

%% 2.1 2 a) (alternativa)

dardos(20,100,1e6)


%% 2.1 2 b) 

resp = 1 - dardos(20,100,1e6)


%% 2.1 2 c)

m = 1000;
N = 1e6;
i = 1;
for n = 10:10:100
    
    p(i) = 1 - dardos(n,m,N);
    i = i+1;

end
subplot(1,2,1)
plot(10:10:100,p,'b*:')
title("m=1000")

m = 100000;
N = 1e6;
i = 1;
for n = 10:10:100
    
    p(i) = 1 - dardos(n,m,N);
    i = i+1;

end

subplot(1,2,2)
plot(10:10:100,p,'r*:')
title("m=100000")


%% 2.1 2 d)

N = 1e6;
m = [200, 500, 1000, 2000, 5000, 10000, 20000, 50000, 100000];
n = 100;
p = zeros(length(m));
i = 1;

for k = 1: length(m)
    p(i) = 1 - dardos(n,m(k),N);
    i = i + 1;
end
plot(m, p)

%% 2.1 3. a)

N = 1e6;
T = 1000;
k = 10; 
pfinal = 1 - dardos(k,T,N)

%% 2.1 3. b)
N = 1e6;
k = 10:10:100;
T = 1000;
p = zeros(1, length(k));
for i = 1: length(k)
    p(i) = 1 - dardos(k(i),T,N);
end

plot(k,p);

%% 2.1 3. c)

N = 1e6;
k = 50;
T = 100:100:1000;
p = zeros(1,length(T));

for i = 1:length(T)
    p(i) = dardos(k,T(i),N);
end

plot(T, p);

%% 2.1 4. a)

N = 1e5;
d = 365;
p = 0;
n = 0;
while p < 0.5
    n = n+1; 
    p = 1 - dardos(n,d,N);
end

fprintf('%d pessoas \n', n);

%% 2.1 4. b)

N = 1e5;
d = 365;
p = 0;
n = 0;

while p < 0.9
    n = n+1; 
    p = 1 - dardos(n,d,N);
end

fprintf('%d pessoas \n', n);