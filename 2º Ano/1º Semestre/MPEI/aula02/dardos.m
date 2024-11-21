function p = dardos(n,m,N)

cfav = 0;
exp = randi(m,n,N); % randi(nmáx, n linhas, n colunas)

for c = 1:N
    col = exp(:,c);
    if length(unique(col)) == n
        cfav = cfav + 1;
    end
end

p = cfav / N
end

