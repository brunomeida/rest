CREATE TABLE Ativo (
    idAtivo INT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    tipo VARCHAR(50) NOT NULL,
    setor VARCHAR(100) NOT NULL,
    dataUltimaCotacao DATE NOT NULL,
    moeda VARCHAR(50) NOT NULL
);

CREATE TABLE Cotacao (
    idCotacao INT PRIMARY KEY,
    idAtivo INT NOT NULL,
    data DATE NOT NULL,
    precoAbertura DECIMAL(18,2) NOT NULL,
    precoFechamento DECIMAL(18,2) NOT NULL,
    precoMaximo DECIMAL(18,2) NOT NULL,
    precoMinimo DECIMAL(18,2) NOT NULL,
    volumeNegociacao INT NOT NULL,
    FOREIGN KEY (idAtivo) REFERENCES Ativo(idAtivo)
);

CREATE TABLE Empresa (
    idEmpresa INT PRIMARY KEY,
    idAtivo INT NOT NULL,
    nome VARCHAR(255) NOT NULL,
    razaoSocial VARCHAR(255) NOT NULL,
    cnpj VARCHAR(18) NOT NULL,
    site VARCHAR(255) NOT NULL,
    descricao TEXT,
    fundacao DATE NOT NULL,
    sede VARCHAR(255) NOT NULL,
    FOREIGN KEY (idAtivo) REFERENCES Ativo(idAtivo)
);

CREATE TABLE Indicador (
    idIndicador INT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao TEXT,
    sigla VARCHAR(10) UNIQUE NOT NULL,
    tipo_dado VARCHAR(50) NOT NULL
);

CREATE TABLE IndicadorAtivo (
    idIndicador INT NOT NULL,
    idAtivo INT NOT NULL,
    data DATE NOT NULL,
    valor DECIMAL(18,2) NOT NULL,
    FOREIGN KEY (idIndicador) REFERENCES Indicador(idIndicador),
    FOREIGN KEY (idAtivo) REFERENCES Ativo(idAtivo),
    PRIMARY KEY (idIndicador, idAtivo, data)
);

CREATE TABLE Formula (
    idFormula INT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    descricao TEXT,
    formula TEXT NOT NULL
);

CREATE TABLE IndicadorFormula (
    idIndicador INT NOT NULL,
    idFormula INT NOT NULL,
    FOREIGN KEY (idIndicador) REFERENCES Indicador(idIndicador),
    FOREIGN KEY (idFormula) REFERENCES Formula(idFormula),
    PRIMARY KEY (idIndicador, idFormula)
);
