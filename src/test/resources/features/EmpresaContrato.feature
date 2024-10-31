# language: pt
Funcionalidade: Validar o contrato ao realizar um cadastro bem-sucedido de entrega
  Como usúario da API
  Quero cadastrar uma nova empresa
  Para que eu consiga validar se o contrato esta conforme o esperado

  Cenario: Cadastro bem-sucedido da empresa
    Dado que eu tenha os seguintes dados da empresa:
      | campo           | valor                                |
      | cnpj            | 56293258000188                       |
      | razaoSocial     | Segur Residuos LTDA                  |
      | latitude        | 21.92                                |
      | longitude       | 43.12                                |
    Quando eu enviar a requisição para o endpoint "/api/empresa" de cadastro de empresas
    Então o status code da resposta deve ser 201
    E que o arquivo de contrato esperado é o "Cadastro bem-sucedido de entrega"
    Então a resposta da requisição deve estar em conformidade com o contrato selecionado