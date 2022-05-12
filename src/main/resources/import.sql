INSERT INTO users (username, email, password, enabled) values ("Mari", "mcgcarranza@hotmail.es", "$2a$10$OA/t2zHza0qpRaGEDxTO1OKUbslhss97NWSFiRs9fEz8xeA5npU7O", 1);
INSERT INTO users (username, email, password, enabled) values ("Andres", "andresruizdelgado12@gmail.com", "$2a$10$4BfOUFL9bBEIbvrxxzc4kOO1cEnd1gwtFhLV813.T20MT5KpWgOTy", 1);

INSERT INTO `roles` (rol_Name) VALUES ('ROLE_USER');
INSERT INTO `roles` (rol_Name) VALUES ('ROLE_ADMIN');

INSERT INTO user_role (user_id, role_id) VALUES (1,1);
INSERT INTO user_role (user_id, role_id) VALUES (2,2);
