drop schema if exists sapientia;
create schema sapientia;
use sapientia;

create table usuario(
	id_usuario int auto_increment primary key not null,
    cpf_usuario varchar(15) unique,
    nome_usuario varchar(50),
    telefone_usuario varchar(20),
    email_usuario varchar(50),
    login_usuario varchar(50) unique,
    senha_usuario varchar(50),
    tipo_usuario varchar(1),
    sexo_usuario varchar(1),
    logradouro varchar(50),
    numero int,
	bairro varchar(50),
	cidade varchar(50),
	estado varchar(2)
)engine=InnoDB;

create table livro(
	id_livro int auto_increment not null,
    titulo_livro varchar(50),
    autor_livro varchar(50),
    edicao_livro varchar(10),
    ano_livro varchar(10),
    isbn_livro varchar(50) unique,
    volume_livro varchar(10),
    categoria_livro varchar(50),
    resumo_livro varchar(50),
    total_livro int,
    estoque_livro int,
    primary key(id_livro, isbn_livro)
)engine=InnoDB;

create table emprestimo(
	id_emprestimo int auto_increment primary key not null,
    funcionario_cpf varchar(15),
    cliente_cpf varchar(15),
    data_saida_emprestimo date,
    data_entrega_emprestimo date,
    status_emprestimo varchar(8),
    isbn_livro varchar(50),
    constraint usuario_funcio foreign key(funcionario_cpf) references usuario(cpf_usuario),
    constraint usuario_cliente foreign key(cliente_cpf) references usuario(cpf_usuario),
    constraint isbn_lv foreign key(isbn_livro) references livro(isbn_livro)
)engine=InnoDB;

delimiter //
create trigger inserirEmprestimo
before insert on emprestimo
for each row
begin
	if (select tipo_usuario from usuario where cpf_usuario = new.funcionario_cpf) <> "F" then
		signal sqlstate '45000' set message_text='Cpf do funcionário inserido não pertence a um usuário cadastrado!';
    elseif (select tipo_usuario from usuario where cpf_usuario = new.cliente_cpf) <> "C" then
		signal sqlstate '45000' set message_text='Cpf do cliente inserido não pertence a um usuário cadastrado!';
    elseif (select estoque_livro from livro where isbn_livro = new.isbn_livro and estoque_livro <> 0) is null then
		signal sqlstate '45000' set message_text='Livro indisponível no estoque!';
    elseif new.data_saida_emprestimo > new.data_entrega_emprestimo then
		signal sqlstate '45000' set message_text='Data de saída não pode ser superior à de entrega!';
	elseif new.status_emprestimo not like "ENTREGUE"
       and new.status_emprestimo not like "ATRASADO"  
       and new.status_emprestimo not like "PENDENTE" then
		signal sqlstate '45000' set message_text='Tipo de status incorreto!';
	else
		update livro
		set estoque_livro = estoque_livro - 1
		where isbn_livro = new.isbn_livro;
	end if;
end//

delimiter //
create trigger removerEmprestimo
before delete on emprestimo
for each row
begin
	update livro
    set estoque_livro = estoque_livro + 1
    where isbn_livro = old.isbn_livro;
end//

delimiter //
create trigger inserirLivro
before insert on livro
for each row
begin
	if new.estoque_livro > new.total_livro then
		signal sqlstate '45000' set message_text='Estoque não pode ser maior que total!';
    end if;
end//

delimiter //
create trigger inserirUsuario
before insert on usuario
for each row
begin
	if new.tipo_usuario <> "F" 
    and new.tipo_usuario <> "C" 
    and new.tipo_usuario <> "A" then
		signal sqlstate '45000' set message_text='Tipo de usuário incorreto!';
    elseif new.sexo_usuario <> "M"
    and new.sexo_usuario <> "F"  then
		signal sqlstate '45000' set message_text='Tipo de sexo incorreto!';
	end if;
end//