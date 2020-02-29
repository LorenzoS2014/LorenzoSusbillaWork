%Lorenzo Susbilla
%Csc 135
%10 May 2019

%pingPongMaster---------------------
game(n, a, b, s, t).
game(893,terry,rene,11,2).
game(894,marge,larry,11,8).
game(123,marge,larry,11,10).
game(721,terry,marge,11,5).

pingPongMaster(A) :-  game(_, A, _, S,T), game(_, A, _, D, F), S-T >= 6, D-F >= 6.

%getsMailBefore---------------------------
deliver(carrier, thisPerson, nextPerson).
deliver(fred, terry, emil).
deliver(fred, emil, sally).
deliver(fred, sally, cory).
deliver(fred, cory, art).
deliver(diane, steve, ali).
deliver(diane, ali, manuel).
deliver(diane, manuel, rick).

getsMailBefore(A, B) :- deliver(_,A,B).
getsMailBefore(A, B) :- deliver(X,A,_), deliver(X,_,B).

%count_occur---------------------------------------
count_occur([],0).
count_occur([[_|_]|X],Z) :- count_occur(X,Z+1).
count_occur([E|X],Z) :- E = [], count_occur(X,Z).

%listMax-------------------------------------------
listMax([],[],[]).
listMax([A|B], [C|D], [A|Y]) :- A >= C, listMax(B,D,Y).
listMax([A|B], [C|D], [C|Y]) :- A < C , listMax(B,D,Y).

%cycler--------------------------------------------
add([X|[]], N, M) :- M is N+X.
add([X|Y], N, M) :- sub(Y, N+X, M).
sub([X|[]], N, M) :- M is N-X.
sub([X|Y], N, M) :- mult(Y, N-X, M).
mult([X|[]], N, M) :- M is N*X.
mult([X|Y], N, M) :- add(Y, N*X, M).
cycler(L, N, M) :- add(L, N, M).




