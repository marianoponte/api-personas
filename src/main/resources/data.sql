INSERT INTO countries (id, code, name) VALUES (1, 'AR', 'Argentina');
INSERT INTO countries (id, code, name) VALUES (2, 'BR', 'Brasil');
INSERT INTO countries (id, code, name) VALUES (3, 'PY', 'Paraguay');
INSERT INTO countries (id, code, name) VALUES (4, 'UY', 'Uruguay');
INSERT INTO countries (id, code, name) VALUES (5, 'CH', 'Chile');

INSERT INTO document_type (id, name) VALUES (1, 'DNI');
INSERT INTO document_type (id, name) VALUES (2, 'CUIT');
INSERT INTO document_type (id, name) VALUES (3, 'RUC');

INSERT INTO people (id, id_document_type, document_number, id_countries, name, last_name, birth_date, nacionality, email, contact_number)
VALUES (1, 1, '1111', 2, 'Arturo', 'De Micheli', '04-06-1996', 'Argetina', 'test@test.com', '12345');
INSERT INTO people (id, id_document_type, document_number, id_countries, name, last_name, birth_date, nacionality, email, contact_number, id_father)
VALUES (2, 1, '2222', 2, 'Omar', 'De Micheli', '04-06-1996', 'Argetina', 'test@test.com', '12345', 1);
INSERT INTO people (id, id_document_type, document_number, id_countries, name, last_name, birth_date, nacionality, email, contact_number, id_father)
VALUES (3, 1, '3333', 2, 'Daniel', 'De Micheli', '04-06-1996', 'Argetina', 'test@test.com', '12345', 1);
INSERT INTO people (id, id_document_type, document_number, id_countries, name, last_name, birth_date, nacionality, email, contact_number, id_father)
VALUES (4, 1, '4444', 2, 'Yasmin', 'De Micheli', '04-06-1996', 'Argetina', 'test@test.com', '12345', 2);
INSERT INTO people (id, id_document_type, document_number, id_countries, name, last_name, birth_date, nacionality, email, contact_number, id_father)
VALUES (5, 1, '5555', 2, 'Milagros', 'De Micheli', '04-06-1996', 'Argetina', 'test@test.com', '12345', 3);