function [T,y] = ReconstroiSinal(x,Ta)
%RECONSTROISINAL Summary of this function goes here
%   Detailed explanation goes here
N=length(x);
T=0:Ta/100:N*Ta-Ta;
Fa=1/Ta;
y=zeros(1,N-1);
for t=1:length(T)
    temporary=0;
    for n=1:N
        sinc_component = sin(pi * Fa * (T(t) - (n-1) * Ta)) / (pi * Fa * (T(t) - (n-1) * Ta));
        sinc_component(isnan(sinc_component))=1;

        if sinc_component==0
                sinc_component = 1;
        
        end

        temporary= temporary +x(n)*sinc_component;
    end
    y(t)=temporary;
end



end

