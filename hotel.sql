CREATE DATABASE hotel;
USE hotel;

CREATE TABLE cliente (
  id_cliente INT AUTO_INCREMENT,
  nome VARCHAR(100),
  email VARCHAR(50),
  telefone VARCHAR(16),
  documento VARCHAR(20),
  PRIMARY KEY(id_cliente)
);

CREATE TABLE quarto (
  id_quarto INT AUTO_INCREMENT,
  numero_quarto INT,
  tipo_quarto VARCHAR(50),
  preco_noite DECIMAL(10, 2),
  status_quarto ENUM('Disponivel', 'Ocupado', 'Reservado') DEFAULT 'Disponivel',
  PRIMARY KEY(id_quarto)
);

CREATE TABLE reserva (
  id_reserva INT AUTO_INCREMENT,
  id_cliente INT NOT NULL,
  id_quarto INT NOT NULL,
  data_entrada DATE NOT NULL,
  data_saida DATE NOT NULL,
  data_reserva TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  status_reserva ENUM('Confirmada', 'Cancelada', 'Concluida') DEFAULT 'Confirmada',
  PRIMARY KEY(id_reserva),
  FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente),
  FOREIGN KEY (id_quarto) REFERENCES quarto(id_quarto)
);

CREATE TABLE pagamento (
  id_pagamento INT AUTO_INCREMENT,
  id_reserva INT NOT NULL,
  valor_pago DECIMAL(10, 2) NOT NULL,
  forma_pagamento ENUM('Cartao', 'Dinheiro', 'Pix') NOT NULL,
  data_pagamento TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  status_pagamento ENUM('Pago', 'Pendente') DEFAULT 'Pendente',
  PRIMARY KEY(id_pagamento),
  FOREIGN KEY (id_reserva) REFERENCES reserva(id_reserva)
);

CREATE TABLE feedback (
  id_feedback INT AUTO_INCREMENT,
  id_cliente INT NOT NULL,
  comentario TEXT,
  avaliacao INT CHECK (avaliacao BETWEEN 1 AND 5),
  data_avaliacao DATE,
  PRIMARY KEY (id_feedback),
  FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente)
);

CREATE TABLE atendimento (
  id_atendimento INT AUTO_INCREMENT,
  id_cliente INT NOT NULL,
  tipo_solicitacao VARCHAR(50) NOT NULL,
  descricao TEXT,
  data_solicitacao DATETIME NOT NULL,
  status_atendimento VARCHAR(20) DEFAULT 'Pendente',
  PRIMARY KEY (id_atendimento),
  FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente)
);

ALTER TABLE atendimento
MODIFY status_atendimento ENUM('Pendente', 'Concluida', 'Cancelada') DEFAULT 'Pendente';

ALTER TABLE cliente
ADD COLUMN telefone_alternativo VARCHAR(16);

ALTER TABLE feedback
ADD COLUMN sugestoes TEXT;

INSERT INTO cliente (nome, email, telefone, documento, telefone_alternativo) VALUES
('João Silva', 'joao.silva@gmail.com', '(11) 98765-4321', '123.456.789-00', '(11) 91234-5678'),
('Maria Oliveira', 'maria.oliveira@yahoo.com', '(21) 99876-5432', '987.654.321-00', '(21) 91234-5678'),
('Carlos Souza', 'carlos.souza@hotmail.com', '(31) 93456-7890', '321.654.987-00', '(31) 98765-4321'),
('Ana Pereira', 'ana.pereira@outlook.com', '(41) 91234-5678', '456.123.789-00', '(41) 92345-6789'),
('Lucas Santos', 'lucas.santos@icloud.com', '(51) 92345-6789', '654.321.987-00', '(51) 91234-5678'),
('Fernanda Lima', 'fernanda.lima@gmail.com', '(61) 93456-7890', '789.123.456-00', '(61) 91234-5678'),
('Paulo Costa', 'paulo.costa@yahoo.com', '(71) 91234-5678', '852.963.741-00', '(71) 92345-6789'),
('Juliana Rocha', 'juliana.rocha@hotmail.com', '(81) 99876-5432', '159.753.486-00', '(81) 98765-4321'),
('Ricardo Almeida', 'ricardo.almeida@outlook.com', '(91) 93456-7890', '741.852.963-00', '(91) 92345-6789'),
('Gabriela Martins', 'gabriela.martins@icloud.com', '(11) 98765-4321', '123.987.654-00', '(11) 91234-5678');

INSERT INTO quarto (numero_quarto, tipo_quarto, preco_noite, status_quarto) VALUES
(101, 'Simples', 150.00, 'Disponivel'),
(102, 'Duplo', 200.00, 'Ocupado'),
(103, 'Luxo', 350.00, 'Reservado'),
(104, 'Simples', 160.00, 'Disponivel'),
(105, 'Duplo', 220.00, 'Ocupado'),
(106, 'Luxo', 400.00, 'Reservado'),
(107, 'Simples', 180.00, 'Disponivel'),
(108, 'Duplo', 210.00, 'Ocupado'),
(109, 'Luxo', 370.00, 'Reservado'),
(110, 'Simples', 145.00, 'Disponivel');

INSERT INTO reserva (id_cliente, id_quarto, data_entrada, data_saida, status_reserva) VALUES
(1, 1, '2024-11-10', '2024-11-12', 'Confirmada'),
(2, 2, '2024-11-11', '2024-11-15', 'Cancelada'),
(3, 3, '2024-11-12', '2024-11-14', 'Concluida'),
(4, 4, '2024-11-13', '2024-11-16', 'Confirmada'),
(5, 5, '2024-11-14', '2024-11-17', 'Confirmada'),
(6, 6, '2024-11-15', '2024-11-18', 'Concluida'),
(7, 7, '2024-11-16', '2024-11-20', 'Confirmada'),
(8, 8, '2024-11-17', '2024-11-21', 'Cancelada'),
(9, 9, '2024-11-18', '2024-11-22', 'Confirmada'),
(10, 10, '2024-11-19', '2024-11-23', 'Cancelada');

INSERT INTO pagamento (id_reserva, valor_pago, forma_pagamento, status_pagamento) VALUES
(1, 300.00, 'Cartao', 'Pago'),
(2, 800.00, 'Dinheiro', 'Pago'),
(3, 700.00, 'Pix', 'Pago'),
(4, 480.00, 'Cartao', 'Pago'),
(5, 880.00, 'Dinheiro', 'Pendente'),
(6, 1200.00, 'Pix', 'Pago'),
(7, 360.00, 'Cartao', 'Pago'),
(8, 630.00, 'Dinheiro', 'Pendente'),
(9, 740.00, 'Pix', 'Pago'),
(10, 435.00, 'Cartao', 'Pendente');

INSERT INTO feedback (id_cliente, comentario, avaliacao, data_avaliacao, sugestoes) VALUES
(1, 'Excelente atendimento!', 5, '2024-11-12', 'Nada a melhorar, tudo perfeito!'),
(2, 'Quarto confortável, mas o Wi-Fi não estava bom.', 4, '2024-11-13', 'Melhorar o sinal do Wi-Fi nos quartos.'),
(3, 'Atendimento muito bom, recomendaria!', 5, '2024-11-14', 'Manter o excelente atendimento!'),
(4, 'Fiquei insatisfeito com a limpeza do quarto.', 2, '2024-11-15', 'Reforçar a limpeza dos quartos.'),
(5, 'Ótimo preço para o que oferece.', 4, '2024-11-16', 'Oferecer mais opções de café da manhã.'),
(6, 'Ambiente muito agradável e tranquilo.', 5, '2024-11-17', 'Poderiam ter mais atividades de lazer no hotel.'),
(7, 'O serviço de quarto demorou um pouco.', 3, '2024-11-18', 'Melhorar o tempo de resposta do serviço de quarto.'),
(8, 'Funcionários muito educados, voltarei em breve.', 5, '2024-11-19', 'Nada a melhorar, foi ótimo!'),
(9, 'Quarto bonito, mas a cama não era muito confortável.', 3, '2024-11-20', 'Investir em colchões mais confortáveis.'),
(10, 'Gostei muito do atendimento, mas a comida do restaurante deixou a desejar.', 4, '2024-11-21', 'Melhorar o cardápio do restaurante.');

INSERT INTO atendimento (id_cliente, tipo_solicitacao, descricao, data_solicitacao, status_atendimento) VALUES
(1, 'Problema com ar condicionado', 'O ar condicionado do quarto não estava funcionando.', '2024-11-10 14:30:00', 'Pendente'),
(2, 'Pedido de informações', 'Solicitei informações sobre os serviços oferecidos pelo hotel.', '2024-11-11 10:15:00', 'Pendente'),
(3, 'Troca de lençóis', 'Pedi para trocarem os lençóis do meu quarto.', '2024-11-12 16:45:00', 'Concluida'),
(4, 'Desbloqueio de porta', 'A chave do meu quarto não estava funcionando.', '2024-11-13 09:00:00', 'Cancelada'),
(5, 'Problema com Wi-Fi', 'O sinal do Wi-Fi estava muito fraco no meu quarto.', '2024-11-14 20:30:00', 'Pendente'),
(6, 'Pedido de travesseiro extra', 'Solicitei um travesseiro extra, pois o meu estava muito baixo.', '2024-11-15 11:00:00', 'Concluida'),
(7, 'Consulta sobre atividades', 'Perguntei sobre atividades disponíveis no hotel.', '2024-11-16 08:00:00', 'Cancelada'),
(8, 'Solicitação de late check-out', 'Solicitei para sair do hotel mais tarde.', '2024-11-17 13:00:00', 'Pendente'),
(9, 'Pedido de limpeza extra', 'Solicitei uma limpeza extra no meu quarto.', '2024-11-18 12:00:00', 'Pendente'),
(10, 'Solicitação de mais toalhas', 'Pedi para trazerem mais toalhas para o meu quarto.', '2024-11-19 14:00:00', 'Concluida');

SELECT * FROM atendimento;
SELECT * FROM cliente;
SELECT * FROM feedback;
SELECT * FROM pagamento;
SELECT * FROM quarto;
SELECT * FROM reserva;

SELECT * FROM quarto
WHERE status_quarto = 'Disponivel';

SELECT * FROM reserva
WHERE status_reserva = 'Concluida';