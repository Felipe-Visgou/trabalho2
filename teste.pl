:- dynamic([agent_score/1, 
				agent_health/1, 
				agent_ammo/1,
				agent_location/2]).
init_agent :- assert(agent_score(0)),
				  assert(agent_location(1,1)),
				  assert(agent_energy(100)),
				  assert(agent_ammo(5)). 
pos(1, 1, agente).
pos(1, 2, vazio).
pos(1, 3, vazio).
pos(1, 4, vazio).
pos(1, 5, vazio).
pos(1, 6, vazio).
pos(1, 7, vazio).
pos(1, 8, vazio).
pos(1, 9, vazio).
pos(1, 10,alakazam).
pos(1, 11, vazio).
pos(1, 12, vazio).
pos(2, 1, vazio).
pos(2, 2, pokeball).
pos(2, 3, vazio).
pos(2, 4, vazio).
pos(2, 5, vortex).
pos(2, 6, vazio).
pos(2, 7, vazio).
pos(2, 8, vazio).
pos(2, 9, vazio).
pos(2, 10, haunter).
pos(2, 11, cyndaquil).
pos(2, 12, vazio).
pos(3, 1, vazio).
pos(3, 2, vazio).
pos(3, 3, vortex).
pos(3, 4, vazio).
pos(3, 5, vazio).
pos(3, 6, vazio).
pos(3, 7,alakazam).
pos(3, 8, vazio).
pos(3, 9, vazio).
pos(3, 10, vazio).
pos(3, 11, vortex).
pos(3, 12, vazio).
pos(4, 1, vazio).
pos(4, 2, vazio).
pos(4, 3, vazio).
pos(4, 4, vazio).
pos(4, 5, vazio).
pos(4, 6, vazio).
pos(4, 7, vazio).
pos(4, 8, vazio).
pos(4, 9, vazio).
pos(4, 10, vazio).
pos(4, 11, vazio).
pos(4, 12, vazio).
pos(5, 1, vazio).
pos(5, 2, vazio).
pos(5, 3, totodile).
pos(5, 4, vazio).
pos(5, 5, vazio).
pos(5, 6, vazio).
pos(5, 7, vazio).
pos(5, 8, vazio).
pos(5, 9, vazio).
pos(5, 10, vazio).
pos(5, 11, vazio).
pos(5, 12, vazio).
pos(6, 1, vazio).
pos(6, 2, vazio).
pos(6, 3, vazio).
pos(6, 4, vazio).
pos(6, 5, gengar).
pos(6, 6, vazio).
pos(6, 7, vazio).
pos(6, 8, vazio).
pos(6, 9, vazio).
pos(6, 10, vortex).
pos(6, 11, vazio).
pos(6, 12, vazio).
pos(7, 1,alakazam).
pos(7, 2, vazio).
pos(7, 3, vazio).
pos(7, 4, vazio).
pos(7, 5, vazio).
pos(7, 6, vazio).
pos(7, 7, pokeball).
pos(7, 8, vazio).
pos(7, 9, vazio).
pos(7, 10, vazio).
pos(7, 11, vazio).
pos(7, 12, vazio).
pos(8, 1, vazio).
pos(8, 2, vazio).
pos(8, 3, vazio).
pos(8, 4, vortex).
pos(8, 5, vazio).
pos(8, 6, vazio).
pos(8, 7, vazio).
pos(8, 8, vazio).
pos(8, 9, vazio).
pos(8, 10, vazio).
pos(8, 11, gengar).
pos(8, 12, vazio).
pos(9, 1, vazio).
pos(9, 2, haunter).
pos(9, 3, vazio).
pos(9, 4, vazio).
pos(9, 5, vazio).
pos(9, 6, vazio).
pos(9, 7, vortex).
pos(9, 8, vazio).
pos(9, 9, vazio).
pos(9, 10, vazio).
pos(9, 11, vazio).
pos(9, 12, vazio).
pos(10, 1, vazio).
pos(10, 2, vazio).
pos(10, 3, vazio).
pos(10, 4, vazio).
pos(10, 5, vazio).
pos(10, 6, vazio).
pos(10, 7, vazio).
pos(10, 8, vazio).
pos(10, 9, vazio).
pos(10, 10, vortex).
pos(10, 11, vazio).
pos(10, 12, vazio).
pos(11, 1, vazio).
pos(11, 2, vortex).
pos(11, 3, vazio).
pos(11, 4,alakazam).
pos(11, 5, vazio).
pos(11, 6, vazio).
pos(11, 7, vazio).
pos(11, 8, vazio).
pos(11, 9, chikorita).
pos(11, 10, vazio).
pos(11, 11, vazio).
pos(11, 12, vazio).
pos(12, 1, pokeball).
pos(12, 2, vazio).
pos(12, 3, vazio).
pos(12, 4, vazio).
pos(12, 5, vazio).
pos(12, 6, vazio).
pos(12, 7, vazio).
pos(12, 8, vazio).
pos(12, 9, vazio).
pos(12, 10, vazio).
pos(12, 11, vazio).
pos(12, 12, vazio).
wall(X,Y) :- Y =< 0.
wall(X,Y) :- X =< 0.
wall(X,Y) :- X >= 13.
wall(X,Y) :- Y >= 13.
adjacente(X, Y, AX, Y) :-  X < 12, AX is X + 1.   
adjacente(X, Y, AX, Y) :-  X > 1,  AX is X - 1.   
adjacente(X, Y, X, AY) :- Y < 12, AY is Y + 1. 
adjacente(X, Y, X, AY) :- Y > 1,  AY is Y - 1.
