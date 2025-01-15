%% 1 a)
T = [1,0,1/3,1/2,0;
     0,1,1/3,0,0;
     0,0,0,1/2,0;
     0,0,0,0,1;
     0,0,1/3,0,0]

%% 1 b)

v0 = [0;0;0;1;0];
v15 = T^15 * v0;

pestado4 = v15(4);
fprintf("%.4f\n",pestado4)

%% 1 c)

% Estados absorventes 1 e 2
Q = T(3:5,3:5);
I = eye(3);
F = inv(I - Q);

media = sum(F(:,3)) + 1; %


% 1 d)

N = 5;

H = zeros(N);

H(1,1) = 1;
H(2,2) = 1;
H(2,3) = 1;
H(5,3) = 1;
H(1,3) = 1;
H(3,4) = 1;
H(1,4) = 1;
H(4,5) = 1;

saidas = sum(H);
H = H ./ saidas;
H(isnan(H)) = 0;


beta = 0.8;
v0 = ones(N) / N;
v01 = ones(1,N) / N;
v01 = v01';
A = beta * H + (1-beta) * v0
a10 = A^10 * v01
