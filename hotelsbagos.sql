 /*CREATE DATABASE hotel;
   CREATE TABLE hotel.clientes
(
	id_clientes INT AUTO_INCREMENT,
    nome varchar(100),
    email varchar(50),
	telefone VARCHAR(16),
	documento VARCHAR(20),
    PRIMARY KEY(id_clientes)
);*/
/*CREATE TABLE hotel.quartos
(
	id_quarto INT AUTO_INCREMENT,
	numero_quarto INT,
    tipo_quarto VARCHAR(50),
    preco_noite DECIMAL(10, 2),
    status ENUM('Disponivel','ocupado','reservado') DEFAULT 'disponivel',
    PRIMARY KEY(id_quarto) 
);    */
   /* CREATE TABLE hotel.reservas
(
	id_reserva INT AUTO_INCREMENT,
    id_clientes INT,
    id_quarto INT,
    data_entrada DATE NOT NULL,
    data_saida DATE NOT NULL,
    data_reserva TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(id_reserva),
    FOREIGN KEY(id_clientes) REFERENCES clientes(id_clientes),
    FOREIGN KEY(id_quarto) REFERENCES quartos(id_quarto)
);*/
CREATE TABLE hotel.pagamentos
(
	id_pagamento INT,
    id_reserva INT NOT NULL,
    valor_pago DECIMAL(10, 2) NOT NULL,
    forma_pagamento ENUM('cartao', 'dinheiro', 'pix'),
    data_pagamento TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    status ENUM('pago','pendente') DEFAULT 'pendente',
	PRIMARY KEY(id_pagamento),
    FOREIGN KEY(id_reserva) REFERENCES hotel.reservas(id_reserva)
);    
    
    

/*SELECT * FROM hotel.quartos;

SELECT * FROM hotel.clientes;

SELECT * FROM hotel.reservas;*/

/*insert into hotel.clientesclientesid_clientes
(id_clientes, nome, email, telefone, documento)
VALUES(1, 'thiago', 'thiago@gmail.com',4199999999, 09565664246) 

insert into hotel.clientes
(id_clientes, nome, email, telefone, documento)
VALUES(2, 'jhonatan', 'jhonatan@gmail.com',4188888888, 09999999999);*/

/*INSERT INTO hotel.clientes
(id_clientes, nome, email, telefone, documento)
VALUES (3, 'Maria Silva', 'maria.silva@hotmail.com', 4191234567, '12345678900');

INSERT INTO hotel.clientes
(id_clientes, nome, email, telefone, documento)
VALUES (4, 'Carlos Souza', 'carlos.souza@outlook.com', 4198765432, '23456789011');

INSERT INTO hotel.clientes
(id_clientes, nome, email, telefone, documento)
VALUES (5, 'Amanda Lima', 'amanda.lima@gmail.com', 4192345678, '34567890122');

INSERT INTO hotel.clientes
(id_clientes, nome, email, telefone, documento)
VALUES (6, 'Pedro Almeida', 'pedro.almeida@yahoo.com.br', 4173456789, '45678901233');

INSERT INTO hotel.clientes
(id_clientes, nome, email, telefone, documento)
VALUES (7, 'Beatriz Costa', 'beatriz.costa@icloud.com', 4187654321, '56789012344');

INSERT INTO hotel.clientes
(id_clientes, nome, email, telefone, documento)
VALUES (8, 'Rafael Oliveira', 'rafael.oliveira@gmail.com', 4196543210, '67890123455');

INSERT INTO hotel.clientes
(id_clientes, nome, email, telefone, documento)
VALUES (9, 'Fernanda Martins', 'fernanda.martins@outlook.com', 4195432109, '78901234566');

INSERT INTO hotel.clientes
(id_clientes, nome, email, telefone, documento)
VALUES (10, 'João Pereira', 'joao.pereira@gmail.com', 4176543210, '89012345677');

INSERT INTO hotel.clientes
(id_clientes, nome, email, telefone, documento)
VALUES (11, 'Laura Santos', 'laura.santos@hotmail.com', 4189876543, '90123456788');*/


