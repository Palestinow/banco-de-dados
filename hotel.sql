/* CREATE DATABASE hotel;
SHOW DATABASES;
USE hotel;

CREATE TABLE hotel.clientes
(
  id_clientes INT AUTO_INCREMENT,
  nome varchar(100),
  email varchar(50),
  telefone VARCHAR(16),
  documento VARCHAR(20),
  PRIMARY KEY(id_clientes)
);

CREATE TABLE hotel.quartos
(
  id_quarto INT AUTO_INCREMENT,
  numero_quarto INT,
  tipo_quarto VARCHAR(50),
  preco_noite DECIMAL(10, 2),
  status ENUM('Disponivel', 'Ocupado', 'Reservado') DEFAULT 'Disponivel',
  PRIMARY KEY(id_quarto)
);

CREATE TABLE hotel.reservas
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
);

CREATE TABLE hotel.pagamentos
(
  id_pagamento INT AUTO_INCREMENT,
  id_reserva INT NOT NULL,
  valor_pago DECIMAL(10, 2) NOT NULL,
  forma_pagamento ENUM('Cartao', 'Dinheiro', 'Pix') NOT NULL,
  data_pagamento TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  status ENUM('Pago', 'Pendente') DEFAULT 'Pendente',
  FOREIGN KEY (id_reserva) REFERENCES hotel.reservas(id_reserva),
  PRIMARY KEY(id_pagamento)
);

CREATE TABLE hotel.feedback
(
  id_feedback INT AUTO_INCREMENT,
  id_clientes INT NOT NULL,
  comentario TEXT,
  avaliacao INT CHECK (avaliacao BETWEEN 1 AND 5),
  data_avaliacao DATE,
  FOREIGN KEY (id_clientes) REFERENCES hotel.clientes(id_clientes),
  PRIMARY KEY (id_feedback)
);

CREATE TABLE hotel.atendimentos
(
  id_atendimento INT AUTO_INCREMENT,
  id_clientes INT NOT NULL,
  tipo_solicitacao VARCHAR(50) NOT NULL,
  descricao TEXT,
  data_solicitacao DATETIME NOT NULL,
  status_atendimento VARCHAR(20) DEFAULT 'Pendente',
  FOREIGN KEY (id_clientes) REFERENCES hotel.clientes(id_clientes),
  PRIMARY KEY (id_atendimento)
);

/* INSERT INTO hotel.clientes (id_clientes, nome, email, telefone, documento) VALUES
(1, 'Thiago', 'thiago@gmail.com', 4199999999, 09565664246),
(2, 'Jhonatan', 'jhonatan@gmail.com', 4188888888, 97650754932),
(3, 'Maria Silva', 'maria.silva@gmail.com', 41987654321, 12345678901),
(4, 'Carlos Oliveira', 'carlos.oliveira@yahoo.com', 4296543210, 98765432109),
(5, 'Ana Souza', 'ana.souza@hotmail.com', 41999887766, 11223344556),
(6, 'Lucas Pereira', 'lucas.pereira@gmail.com', 42333445566, 22334455667),
(7, 'Fernanda Costa', 'fernanda.costa@outlook.com', 41987654321, 33445566778),
(8, 'Roberto Santos', 'roberto.santos@gmail.com', 41988776655, 44556677889),
(9, 'Juliana Almeida', 'juliana.almeida@icloud.com', 42977665544, 55667788990),
(10, 'Ricardo Lima', 'ricardo.lima@uol.com.br', 41976543210, 66778899001),
(11, 'Patrícia Rocha', 'patricia.rocha@terra.com.br', 4298543210, 77889900112); */

/* INSERT INTO hotel.quartos (numero_quarto, tipo_quarto, preco_noite, status) VALUES
(101, 'Standard', 150.00, 'Disponivel'),
(102, 'Standard', 150.00, 'Ocupado'),
(103, 'Standard', 150.00, 'Reservado'),
(201, 'Luxo', 300.00, 'Disponivel'),
(202, 'Luxo', 300.00, 'Ocupado'),
(203, 'Luxo', 300.00, 'Reservado'),
(301, 'Suite', 500.00, 'Disponivel'),
(302, 'Suite', 500.00, 'Ocupado'),
(303, 'Suite', 500.00, 'Disponivel'),
(304, 'Suite', 500.00, 'Reservado');

INSERT INTO hotel.reservas (id_clientes, id_quarto, data_entrada, data_saida, status) VALUES
(1, 101, '2023-10-01', '2023-10-05', 'Concluida'),
(2, 102, '2023-10-05', '2023-10-10', 'Cancelada'),
(3, 103, '2023-10-15', '2023-10-18', 'Confirmada'),
(4, 201, '2023-10-20', '2023-10-25', 'Concluida'),
(5, 202, '2023-10-21', '2023-10-23', 'Concluida'),
(6, 203, '2023-10-25', '2023-10-28', 'Confirmada'),
(7, 301, '2023-10-27', '2023-10-30', 'Confirmada'),
(8, 302, '2023-10-28', '2023-11-01', 'Cancelada'),
(9, 303, '2023-11-02', '2023-11-05', 'Confirmada'),
(10, 304, '2023-11-10', '2023-11-15', 'Confirmada');

INSERT INTO hotel.pagamentos (id_reserva, valor_pago, forma_pagamento, status) VALUES
(1, 750.00, 'Cartao', 'Pago'),
(2, 600.00, 'Dinheiro', 'Pendente'),
(3, 450.00, 'Pix', 'Pago'),
(4, 1200.00, 'Cartao', 'Pago'),
(5, 600.00, 'Pix', 'Pago'),
(6, 900.00, 'Dinheiro', 'Pendente'),
(7, 1500.00, 'Cartao', 'Pago'),
(8, 1800.00, 'Pix', 'Cancelado'),
(9, 750.00, 'Cartao', 'Pago'),
(10, 1200.00, 'Dinheiro', 'Pendente');

INSERT INTO hotel.feedback (id_clientes, comentario, avaliacao, data_avaliacao) VALUES
(1, 'Ótimo atendimento e quarto confortável.', 5, '2023-10-06'),
(2, 'A limpeza poderia ser melhor.', 3, '2023-10-11'),
(3, 'Ambiente agradável e bom custo-benefício.', 4, '2023-10-19'),
(4, 'Problemas no ar-condicionado.', 2, '2023-10-26'),
(5, 'Funcionários atenciosos e educados.', 5, '2023-10-24'),
(6, 'Café da manhã excelente.', 4, '2023-10-30'),
(7, 'Quarto muito barulhento.', 2, '2023-11-01'),
(8, 'Boa localização e preço justo.', 4, '2023-11-02'),
(9, 'Equipe de atendimento foi prestativa.', 5, '2023-11-06'),
(10, 'Cama desconfortável.', 3, '2023-11-08');

INSERT INTO hotel.atendimentos (id_clientes, tipo_solicitacao, descricao, data_solicitacao, status_atendimento) VALUES
(1, 'Limpeza', 'Solicitação de limpeza do quarto.', '2023-10-02 10:00:00', 'Concluido'),
(2, 'Reparo', 'Conserto da TV no quarto.', '2023-10-06 15:30:00', 'Pendente'),
(3, 'Informação', 'Dúvidas sobre a piscina.', '2023-10-10 09:00:00', 'Concluido'),
(4, 'Serviço de Quarto', 'Solicitação de jantar no quarto.', '2023-10-12 19:00:00', 'Concluido'),
(5, 'Limpeza', 'Troca das toalhas.', '2023-10-15 14:30:00', 'Concluido'),
(6, 'Reparo', 'Problemas com o aquecedor.', '2023-10-18 18:00:00', 'Pendente'),
(7, 'Informação', 'Horário do café da manhã.', '2023-10-20 08:00:00', 'Concluido'),
(8, 'Serviço de Quarto', 'Pedido de bebidas.', '2023-10-22 20:00:00', 'Concluido'),
(9, 'Reparo', 'Lâmpada queimada no banheiro.', '2023-10-25 11:00:00', 'Concluido'),
(10, 'Limpeza', 'Limpeza extra solicitada.', '2023-10-28 13:00:00', 'Pendente'); */

ALTER TABLE hotel.quartos CHANGE COLUMN status status_quartos ENUM ('Pago', 'Pendente') DEFAULT 'Pendente';