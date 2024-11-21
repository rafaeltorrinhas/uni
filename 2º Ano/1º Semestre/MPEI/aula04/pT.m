function p = pT(k,n,p)

p = nchoosek(n,k)*p^k*(1-p)^(n-k); 

end