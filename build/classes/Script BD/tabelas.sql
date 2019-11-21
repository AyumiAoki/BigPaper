Drop Schema BigPaper;
Create Schema BigPaper;
Use BigPaper;

Create table Funcionario (
    nome varchar(50) not null,
    cpf varchar(11) not null,
    usuario varchar(50) not null,
    senha varchar(50) not null,
    primary key (cpf)
);

Create table Fornecedor (
    nome varchar(50) not null,
    cpf varchar(14) not null,
    telefone varchar(12) not null,
    primary key (cpf)
);

Create table Marca (
    nome varchar(50) not null,
    codigo int not null,
    unique(nome),
    primary key (codigo)
);

Create table Produto (
    codigo int not null,
    nome varchar(50) not null,
    descricao varchar(200) not null, 
    margemLucro float not null,
    medida varchar(10) not null,
    cpfFornecedor varchar(14) not null,
    codMarca int not null,
    primary key (codigo),
    foreign key (cpfFornecedor) references Fornecedor(cpf),
    foreign key (codMarca) references Marca(codigo)
);



select * from Funcionario;
