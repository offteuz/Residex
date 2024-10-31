# language: pt
Funcionalidade: Cadastro de uma nova empresa
  Como usúario da API
  Quero cadastrar uma nova empresa
  Para que o registro seja salvo corretamente no sistema

  Cenario: Cadastro bem-sucedido da empresa
    Dado que eu tenha os seguintes dados da empresa:
      | campo           | valor                                |
      | cnpj            | 56293258000188                       |
      | razaoSocial     | Segur Residuos LTDA                  |
      | latitude        | 21.92                                |
      | longitude       | 43.12                                |
    Quando eu enviar a requisição para o endpoint "/api/empresa" de cadastro de empresas
    Então o status code da resposta deve ser 201

  Cenario: Consulta de empresas
    Quando eu envar a requisição GET para o endpoint "/api/empresa" da consulta de empresa
    Então o status da resposta de  consulta deve ser 200


  Cenario: Cadastro de uma empresa com os dados errados
    Dado que eu tenha os seguintes dados da empresa:
      | campo           | valor                                |
      | cnpj            | 56293258000                        |
      | razaoSocial     | Etna Serviços Ambientais Ltda        |
      | latitude        | 21.12                                |
      | longitude       | 43.12                                |
    Quando eu enviar a requisição para o endpoint "/api/empresa" de cadastro de empresas
    Então o status code da resposta deve ser 400
    E o corpo de resposta de erro da api deve retornar "Dados fornecidos estão em formato inválido, verificar CNPJ, latitude e longitude"
