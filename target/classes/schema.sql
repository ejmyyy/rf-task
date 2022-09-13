DROP TABLE IF EXISTS documents;
DROP TABLE IF EXISTS protocols;



CREATE TABLE protocols (
   id SERIAL PRIMARY KEY,
   author varchar(255),
   created_at TIMESTAMP,
   state varchar(255)
);


CREATE TABLE documents (
    id SERIAL PRIMARY KEY,
    name varchar(255),
    author varchar(255),
    created_at TIMESTAMP,
    type varchar(255),
    protocol_id INT,
    FOREIGN KEY (protocol_id)
    REFERENCES protocols (id)
);

