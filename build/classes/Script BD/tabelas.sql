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
    codigo int not null,
    telefone varchar(12) not null,
    primary key (cpf, codigo)
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
    codFornecedor int not null,
    codMarca int not null,
    foreign key (codFornecedor) references Fornecedor(codigo),
    foreign key (codMarca) references Marca(codigo),
    primary key (codigo)
);

select * from Funcionario;
