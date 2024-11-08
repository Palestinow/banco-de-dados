/* CREATE DATABASE hotel; /*
/* SHOW DATABASES; */
/* USE hotel */

/* CREATE TABLE hotel.clientes
(
  id_clientes INT AUTO_INCREMENT,
  nome varchar(100),
  email varchar(50),
  telefone VARCHAR(16),
  documento VARCHAR(20),
  PRIMARY KEY(id_clientes)
); */

/* CREATE TABLE hotel.quartos
(
  id_quarto INT AUTO_INCREMENT,
  numero_quarto INT,
  tipo_quarto VARCHAR(50),
  preco_noite DECIMAL(10, 2),
  status ENUM('Disponivel', 'Ocupado', 'Reservado') DEFAULT 'Disponivel',
  PRIMARY KEY(id_quarto)
); */

/* CREATE TABLE hotel.reservas
(
  id_reserva INT AUTO_INCREMENT,
  id_clientes INT NOT NULL,
  id_quarto INT NOT NULL,
  data_entrada DATE NOT NULL,
  data_saida DATE NOT NULL,
  data_reserva TIMESTAMP DEFAULT CURRENT_TIMESTAMP,	
  status ENUM('Confirmada', 'Cancelada', 'Concluida') DEFAULT 'Confirmada',
  FOREIGN KEY (id_clientes) REFERENCES hotel.clientes(id_clientes),
  FOREIGN KEY (id_quarto) REFERENCES hotel.quartos(id_quarto),
  PRIMARY KEY(id_reserva)
); */

/* CREATE TABLE hotel.pagamentos
(
  id_pagamento INT AUTO_INCREMENT,
  id_reserva INT NOT NULL,
  valor_pago DECIMAL(10, 2) NOT NULL,
  forma_pagamento ENUM('Cartao', 'Dinheiro', 'Pix') NOT NULL,
  data_pagamento TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  status ENUM('Pago', 'Pendente') DEFAULT 'Pendente',
  FOREIGN KEY (id_reserva) REFERENCES hotel.reservas(id_reserva),
  PRIMARY KEY(id_pagamento)
); */

/* INSERT INTO hotel.clientes (id_clientes, nome, email, telefone, documento) 
VALUES (1, 'Thiago', 'thiago@gmail.com', 4199999999, 09565664246); */

/* INSERT INTO hotel.clientes (id_clientes, nome, email, telefone, documento) 
VALUES (2, 'Jhonatan', 'jhonatan@gmail.com', 4188888888, 97650754932); */

/* INSERT INTO hotel.clientes (id_clientes, nome, email, telefone, documento) 
VALUES (3, 'Maria Silva', 'maria.silva@gmail.com', 41987654321, 12345678901); */

/* INSERT INTO hotel.clientes (id_clientes, nome, email, telefone, documento) 
VALUES (4, 'Carlos Oliveira', 'carlos.oliveira@yahoo.com', 4296543210, 98765432109); */

/* INSERT INTO hotel.clientes (id_clientes, nome, email, telefone, documento) 
VALUES (5, 'Ana Souza', 'ana.souza@hotmail.com', 41999887766, 11223344556); */

/* INSERT INTO hotel.clientes (id_clientes, nome, email, telefone, documento) 
VALUES (6, 'Lucas Pereira', 'lucas.pereira@gmail.com', 42333445566, 22334455667); */

/* INSERT INTO hotel.clientes (id_clientes, nome, email, telefone, documento) 
VALUES (7, 'Fernanda Costa', 'fernanda.costa@outlook.com', 41987654321, 33445566778); */

/* INSERT INTO hotel.clientes (id_clientes, nome, email, telefone, documento) 
VALUES (8, 'Roberto Santos', 'roberto.santos@gmail.com', 41988776655, 44556677889); */

/* INSERT INTO hotel.clientes (id_clientes, nome, email, telefone, documento) 
VALUES (9, 'Juliana Almeida', 'juliana.almeida@icloud.com', 42977665544, 55667788990); */

/* INSERT INTO hotel.clientes (id_clientes, nome, email, telefone, documento) 
VALUES (10, 'Ricardo Lima', 'ricardo.lima@uol.com.br', 41976543210, 66778899001); */

/* INSERT INTO hotel.clientes (id_clientes, nome, email, telefone, documento) 
VALUES (11, 'Patrícia Rocha', 'patricia.rocha@terra.com.br', 4298543210, 77889900112); */