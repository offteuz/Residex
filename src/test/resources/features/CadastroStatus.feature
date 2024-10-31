#language: pt

Funcionalidade: Cadastro de um novo status
  Como usúario da API
  Quero cadastrar um novo status
  Para que o registro seja salvo corretamente no sistema

Cenario: Cadastro bem-sucedido do status
  Dado que eu tenha os seguintes dados do status:
    | campo           | valor    |
    | descricaoStatus | Guardar |

  Quando eu enviar a requisição para o endpoint "/api/status" de cadastro do status
  Então o status da resposta deve ser 201

Cenario: Consulta de status
  Quando eu enviar uma requisição GET para o endpoint "/api/status" de consulta do status
  Então o status da resposta de consulta deve ser 200