# TQI Evolution Backend
API de analise de credito, 

## Funcionalidades Solicitadas no desafio.
[X] Cadastro de clientes
O cliente pode cadastrar: nome, e-mail, CPF, RG, endereço completo, renda e senha.

[X] Solicitação de empréstimo
Para solicitar um empréstimo, precisamos do valor do empréstimo, data da primeira parcela e quantidade de parcelas.
O máximo de parcelas será 60 e a data da primeira parcela deve ser no máximo 3 meses após o dia atual.

[X] Acompanhamento das solicitações de empréstimo
O cliente pode visualizar a lista de empréstimos solicitados por ele mesmo e também os detalhes de um de seus empréstimos.
Na listagem, devemos retornar no mínimo o código do empréstimo, o valor e a quantidade de parcelas.
No detalhe do empréstimo, devemos retornar: código do empréstimo, valor, quantidade de parcelas, data da primeira parcela, 
e-mail do cliente e renda do cliente.

[ ] Login a autenticação será realizada por e-mail e senha.