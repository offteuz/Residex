# language: pt
Funcionalidade: Deletar uma empresa
  Como usuário da API
  Quero conseguir deletar uma empresa
  Para que o registro seja apagado corretamente no sistema
  Contexto: Cadastro bem-sucedido da empresa
    Dado que eu tenha os seguintes dados da empresa:
      | campo           | valor                                |
      | cnpj            | 56293258000188                       |
      | razaoSocial     | Segur Residuos LTDA       |
      | latitude        | 57.18                                |
      | longitude       | 34.22                                |
    Quando eu enviar a requisição para o endpoint "/api/empresa" de cadastro de empresas
    Então o status code da resposta deve ser 201
    
  Cenario: Deve ser possivel deletar uma empresa
    Dado que eu recupera o id da empresa
    Quando eu enviar a requisição com o ID para o endpoint "/api/empresa/{idEmpresa}" de deleção de empresa
    Então o status code da resposta deve ser 204