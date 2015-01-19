INSERT INTO users(id, enabled, name, password, username, user_role) VALUES (1, 1, "Konstantin Mitov", "kosio123", "kosio", "ROLE_ADMIN");

INSERT INTO theatres(id, capacity, name) VALUES(1, 200, "Grand Hall 1");

INSERT INTO projections(id, date, movieId, theatreId) VALUES (1, NOW(), 1, 1);