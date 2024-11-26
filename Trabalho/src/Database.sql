CREATE DATABASE trabalhoBD
GO
USE trabalhoBD
GO
 
CREATE TABLE Usuario (
    id CHAR(10) NOT NULL IDENTITY(100, 1) ,
    nome VARCHAR(70) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    telefone VARCHAR(11),
    senha VARCHAR(20) NOT NULL
    PRIMARY KEY (id)
);
 
 
CREATE TABLE Cliente (
    CPF CHAR(11) UNIQUE NOT NULL,
    EnderecoId CHAR(10) NOT NULL,
    Usuarioid CHAR(10) NOT NULL,
    FOREIGN KEY (Usuarioid) REFERENCES Usuario(id),
    FOREIGN KEY (EndercoId) REFERENCES Endereco(Id),
    PRIMARY KEY (CPF)
);
 
 
CREATE TABLE Vendedor (
    CNPJ CHAR(14) UNIQUE NOT NULL,
    EnderecoId CHAR(10) NOT NULL,
    Usuarioid CHAR(10) NOT NULL,
    FOREIGN KEY (Usuarioid) REFERENCES Usuario(id),
    FOREIGN KEY (EndercoId) REFERENCES Endereco(Id),
    PRIMARY KEY (CNPJ) 
);
 
 
CREATE TABLE Loja (
    id INTEGER PRIMARY KEY,
    VendedorUsuarioid INTEGER NOT NULL,
    nome VARCHAR(50) NOT NULL,
    descricao VARCHAR(150),
    EnderecoId CHAR(10) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (VendedorUsuarioid) REFERENCES Vendedor(Usuarioid),
    FOREIGN KEY (EnderecoId) REFERENCES Endereco(Id)
);
 
 
CREATE TABLE Produto (
    id INTEGER,
    Lojaid INTEGER NOT NULL,
    Categoriacodigo INTEGER NOT NULL,
    nome VARCHAR(70) NOT NULL,
    descricao VARCHAR(170),
    valor DECIMAL(10, 2) NOT NULL,
    quantidadeEstoque INTEGER DEFAULT 0,
    PRIMARY KEY(id),
    FOREIGN KEY (Lojaid) REFERENCES Loja(id),
    FOREIGN KEY (Categoriacodigo) REFERENCES Categoria(codigo)
);
 
 
CREATE TABLE Carrinho (
    id INTEGER,
    Usuarioid INTEGER NOT NULL
    PRIMARY KEY (id),
    FOREIGN KEY (Usuarioid) REFERENCES Usuario(id)
);
 
 
CREATE TABLE Produto_Carrinho (
    Produtoid INTEGER NOT NULL,
    Carrinhoid INTEGER NOT NULL,
    quantidadeProdutos INTEGER NOT NULL,
    PRIMARY KEY (Produtoid, Carrinhoid),
    FOREIGN KEY (Produtoid) REFERENCES Produto(id),
    FOREIGN KEY (Carrinhoid) REFERENCES Carrinho(id)
);
 
 
CREATE TABLE Pedido (
    codigo INTEGER,
    Usuarioid INTEGER NOT NULL,
    data DATE NOT NULL,
    valorTotal DECIMAL(10, 2) NOT NULL,
    PRIMARY KEY (codigo),
    FOREIGN KEY (Usuarioid) REFERENCES Usuario(id)
);
 
 
CREATE TABLE Pagamento (
    PedidoCodigo INTEGER NOT NULL,
    PedidoUsuarioid INTEGER NOT NULL,
    metodo CHAR(30) NOT NULL,
    data DATE NOT NULL,
    PRIMARY KEY (PedidoCodigo, PedidoUsuarioid),
    FOREIGN KEY (PedidoCodigo) REFERENCES Pedido(codigo),
    FOREIGN KEY (PedidoUsuarioid) REFERENCES Usuario(id)
);
GO

CREATE TABLE Endereco (
   Id CHAR(10) NOT NULL IDENTITY (1, 1),
   logradouro VARCHAR(255) NOT NULL,
   numero INTEGER NOT NULL,
   cep CHAR(8) NOT NULL,
   complemento VARCHAR(255),
   bairro VARCHAR(255),
   cidade VARCHAR (255),
   estado VARCHAR(255)
   PRIMARY KEY (Id)
)

GO
INSERT INTO Usuario (nome, email, endereco, telefone, tipo) VALUES
('Ana Silva', 'ana.silva@email.com', 'Rua das Flores, 123', '11987654321', 'cliente'),
('Carlos Souza', 'carlos.souza@email.com', 'Av. Paulista, 456', '11976543210', 'cliente'),
('Maria Oliveira', 'maria.oliveira@email.com', 'Rua dos Ipês, 789', '11923456789', 'vendedor'),
('José Santos', 'jose.santos@email.com', 'Rua das Palmeiras, 101', '11876543210', 'vendedor');

GO
INSERT INTO Cliente (CPF) VALUES
('12345678901'),
('98765432100');

GO
INSERT INTO Vendedor (CNPJ) VALUES
('12345678000123'),
('98765432000198');


SELECT * FROM Vendedor
SELECT * FROM Cliente
SELECT * FROM Usuario