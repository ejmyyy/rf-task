INSERT INTO protocols(author, created_at, state) VALUES ('Jana', '2022-06-22 15:10:25-07', 'NEW');
INSERT INTO protocols(author, created_at, state) VALUES ('Ada', '2022-02-10 16:10:25-07', 'PREPARE_FOR_SHIPMENT');
INSERT INTO protocols(author, created_at, state) VALUES ('Hannah', '2022-03-30 22:10:25-07', 'CANCELLED');

INSERT INTO documents(name, author, created_at, type, protocol_id) VALUES ('doc1', 'Janko','2022-05-22 19:10:25-07', 'PDF', 1);
INSERT INTO documents(name, author, created_at, type, protocol_id)  VALUES ('doc2', 'Janka','2022-04-22 19:10:25-07', 'JPG', 2);
INSERT INTO documents(name, author, created_at, type, protocol_id)  VALUES ('doc3', 'Mirko','2022-04-22 19:10:25-07', 'PDF', 3);
INSERT INTO documents(name, author, created_at, type, protocol_id)  VALUES ('doc4', 'Misko','2022-09-10 19:10:25-07', 'PDF', 1);
INSERT INTO documents(name, author, created_at, type, protocol_id)  VALUES ('doc5', 'Misko','2022-08-22 19:10:25-07', 'JPG', 2);
INSERT INTO documents(name, author, created_at, type, protocol_id)  VALUES ('doc6', 'Anna','2022-05-22 19:10:25-07', 'PDF', 2);
INSERT INTO documents(name, author, created_at, type, protocol_id)  VALUES ('doc7', 'Anna','2022-07-22 19:10:25-07', 'PDF', 1);
