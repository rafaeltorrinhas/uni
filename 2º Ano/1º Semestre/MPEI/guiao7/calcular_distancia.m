function J = calcular_distancia(Set, Nu)

%CALCULARDISTANCIA Summary of this function goes here
%   Detailed explanation goes here
    
J=zeros(Nu); % array para guardar distˆancias
h= waitbar(0,'Calculating');

for n1= 1:Nu
    waitbar(n1/Nu,h);
    for n2= n1+1:Nu

        C1 = Set{n1};
        C2 = Set{n2};
        intersecao = intersect(C1,C2);
        uniao = union(C1,C2);
        similJ = length(intersecao) / length(uniao);
        distJ = 1- similJ;
        J(n1,n2) = distJ;
    
    end
end

delete (h)