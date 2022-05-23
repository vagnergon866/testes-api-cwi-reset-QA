# testes-api-cwi-reset-QA

Melhorias:
No teste fazer criação com payload invalido está retornando um status 500 mais o ideal seria o 400.

Observação:
No teste de payload com mais campos conforme o conceito de tolerant reader a api deve tolerar
atributos extras na requisição.

Cadastro De BUGs:

B1- Erro ao tentar criar uma reserva com um dos parâmetros null.
Está cadastrando uma reserva passando parâmetros null.
Resultado esperado:
O sistema deveria retornar um status 400 e não cadastrar a reserva.
Severidade: Média
Prioridade: 2 – Média


B2- Erro ao tentar criar uma reserva com os parâmetros de checkin e checkout errados.
Está cadastrando uma reserva sem verificar checkin e checkout estão no formato correto date.
Resultado esperado:
O sistema deveria retornar um status 400 e não cadastrar a reserva.
Severidade: Critica
Prioridade: 1 – Alta


B3- Erro ao tentar realizar login com nome em um formato não valido.
Está retornando uma mensagem de erro e um status 200 ok.
Resultado esperado:
O sistema deveria retornar o status 400 junto com uma mensagem de nome em formato invalido.
Severidade: Critica
Prioridade: 1 - Alta


B4- Erro ao tentar realizar login com senha em um formato não valido.
Está retornando uma mensagem de erro e um status 200 ok.
Resultado esperado:
O sistema deveria retornar o status 400 junto com uma mensagem de nome em formato invalido.
Severidade: Critica
Prioridade: 1 - Alta
