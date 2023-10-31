CREATE TABLE 'livro'(
    'id' bigint NOT NULL PRIMARY KEY AUTO_INCREMENT,
    'nome' varchar(255) NOT NULL,
    'autor' varchar(255) NOT NULL
    FOREIGN KEY ('autor nome') REFERENCES 'autor'('nome')
);