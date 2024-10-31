#language: pt

Funcionalidade: Cadastro de um novo morador
  Como usúario da API
  Quero cadastrar um novo morador
  Para que o registro seja salvo corretamente no sistema

Cenario: Cadastro bem-sucedido do morador
  Dado que eu tenha os seguintes dados do morador:
    | campo           | valor                                |
    | nomeMorador     | Kiies                             |
    | email           | kiies@icloud.com                   |
    | telefone        | 19982120022                          |
    | logradouro      | Rua Avenida Brasil                   |
    | latitude        | 23.92                                |
    | longitude       | 55.12                                |

  Quando eu enviar a requisição para o endpoint "/api/morador" de cadastro do morador
  Então o status da resposta de cadastro deve ser 201