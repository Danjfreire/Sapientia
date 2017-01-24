use sapientia;
alter table emprestimo modify column status_emprestimo  varchar(8);
drop trigger if exists inserirEmprestimo;
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
