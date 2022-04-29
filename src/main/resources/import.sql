INSERT INTO users (username, url, email, password, enabled) values ("Mari", "https://pbs.twimg.com/profile_images/661151677127499776/29Z2V10T_400x400.jpg", "mcgcarranza@hotmail.es", "$2a$10$OA/t2zHza0qpRaGEDxTO1OKUbslhss97NWSFiRs9fEz8xeA5npU7O", 1);
INSERT INTO users (username, url, email, password, enabled) values ("Andres", "https://pbs.twimg.com/profile_images/1472177290784219138/eeFHzMtv_400x400.jpg", "andresruizdelgado12@gmail.com", "$2a$10$4BfOUFL9bBEIbvrxxzc4kOO1cEnd1gwtFhLV813.T20MT5KpWgOTy", 1);

INSERT INTO roles (rol_Name) VALUES ("ROLE_USER");
INSERT INTO roles (rol_Name) VALUES ("ROLE_ADMIN");

INSERT INTO user_role (user_id, role_id) VALUES (1,1);
INSERT INTO user_role (user_id, role_id) VALUES (2,2);
