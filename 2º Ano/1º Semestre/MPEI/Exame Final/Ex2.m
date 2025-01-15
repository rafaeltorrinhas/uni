%% 2 a)

m = 600;
k = 3;
% out = kHashValues(key,k)
load file.mat

bf = zeros(1,m);
for i = 1:length(persons)
    
    out = kHashValues(persons{i},k);
    out = mod(out,length(bf)) + 1;
    bf(out) = bf(out) + 1;
end

nome = {'André'};

idx = kHashValues(nome{1},k);
idx = mod(idx,length(bf)) + 1;
a_in_p = sum(persons == string(nome))

for i = 1:length(idx)
    min = intmax;
    if bf(idx(i)) < min
        min = bf(idx(i));
    end
end
a_in_bf = min

%% 2 b)
trues = 0;
for i = 1:length(others)
    res = true;
    
    out = kHashValues(others{i},k);
    out = mod(out,length(bf)) + 1;
    for j= 1:length(out)
        if bf(out(j)) == 0
            res = false;
        end
    end
    if res == true
        trues = trues + 1;
    end
    
end
trues
pfp = trues/length(others)
