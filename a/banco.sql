CREATE TABLE FORMULARIO_CONTATO (
  cod_contato INTEGER NOT NULL,
  nome_contato VARCHAR(60) NOT NULL,
  email_contato VARCHAR(60) NOT NULL,
  mensagem_contato VARCHAR(1500) NOT NULL, -- VER ESSE CAMPO COM O PROFESSOR
  tipo_contato VARCHAR(50) NOT NULL,
  PRIMARY KEY (cod_contato)
);

CREATE TABLE PLANO_SAUDE (
  cod_plano INTEGER NOT NULL,
  nome_plano VARCHAR(60) NOT NULL,
  modalidade_plano VARCHAR(30),
  PRIMARY KEY (cod_plano)
);

-- VER PLURAL NOME TABELA
-- VER TAMNHO DO CAMPO SENHA_USUARIO DEPENDE DO TIPO DE CRIPTOGRAFIA QUE USARMOS
CREATE TABLE USUARIO (
  cod_usuario INTEGER NOT NULL,
  nome_usuario VARCHAR(60),
  email_usuario VARCHAR(60) NOT NULL,
  senha_usuario VARCHAR(80) NOT NULL,
  PRIMARY KEY(cod_usuario)
);

-- CRIANDO AMARRAÇÃO COM O USUARIO
CREATE TABLE CLINICA (
  cod_clinica INTEGER NOT NULL,
  nome_clinica VARCHAR(60) NOT NULL,
  email_clinica VARCHAR(60) NOT NULL,
  cnpj_clinica CHAR(18) NOT NULL,
  site_clinica VARCHAR(60) NOT NULL,
  horario_clinica VARCHAR(255) NOT NULL,
  status_clinica BOOLEAN NOT NULL DEFAULT FALSE,
  busca_clinica INTEGER DEFAULT 0,
  telefone_clinica CHAR(10) NOT NULL,
  cod_usuario INTEGER NOT NULL,
  cod_endereco INTEGER NOT NULL,
  PRIMARY KEY (cod_clinica),
  FOREIGN KEY (cod_usuario) REFERENCES USUARIO(cod_usuario) ON DELETE CASCADE,
  FOREIGN KEY (cod_endereco) REFERENCES ENDERECO(cod_endereco) ON DELETE CASCADE
);

CREATE TABLE ENDERECO (
  cod_endereco INTEGER NOT NULL,
  logradouro_endereco VARCHAR(150) NOT NULL,
  numero_endereco VARCHAR(10) NOT NULL,
  bairro_endereco VARCHAR(40) NOT NULL,
  cidade_endereco VARCHAR(50) NOT NULL,
  estado_endereco CHAR(2) NOT NULL,
  cep_endereco VARCHAR(10) NOT NULL,
  PRIMARY KEY(cod_endereco)
);


CREATE TABLE ESPECIALIDADE (
  cod_especialidade INTEGER NOT NULL,
  nome_especialidade VARCHAR(60) NOT NULL,
  PRIMARY KEY (cod_especialidade)
);

CREATE TABLE CLINICA_ESPECIALIDADE (
  cod_especialidade,
  cod_clinica,
  PRIMARY KEY(cod_especialidade, cod_clinica),
  FOREIGN KEY(cod_especialidade) REFERENCES ESPECIALIDADE(cod_especialidade) ON DELETE CASCADE,
  FOREIGN KEY(cod_clinica) REFERENCES CLINICA(cod_clinica) ON DELETE CASCADE
);


CREATE TABLE CLINICA_PLANO (
  cod_plano,
  cod_clinica,
  PRIMARY KEY (cod_plano, cod_clinica),
  FOREIGN KEY (cod_plano) REFERENCES PLANO_SAUDE(cod_plano) ON DELETE CASCADE,
  FOREIGN KEY (cod_clinica) REFERENCES CLINICA(cod_clinica) ON DELETE CASCADE
);
