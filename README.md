# 🌐 Projeto Residex - Aplicação Web
Este projeto está disponível completamente na nuvem! Não é necessário instalar nada localmente.

# 📂 Ambientes Disponíveis
- Produção: [fiap-simple-prod](fiap-simple-prod-apgmekgecwbkaze8.eastus2-01.azurewebsites.net)
- Desenvolvimento: [fiap-simple-dev](fiap-simple-dev-fugncnc4gxc6drdr.eastus2-01.azurewebsites.net)

# Execução

## 1. Criar Caminhão
Endpoint: POST /api/caminhao
Descrição: Registra um novo caminhão.
Exemplo de Requisição:

## POST /api/caminhao

{
  "placa": "ABC-1234",
  "empresaId": 1,
  "capacidade": 5000
}

Resposta:
  
  {
    "id": 1,
    "placa": "ABC-1234",
    "empresaId": 1,
    "capacidade": 5000
  }

## 2. Listar Todos os Caminhões
Endpoint: GET /api/caminhao
Descrição: Retorna uma lista de todos os caminhões cadastrados.
Exemplo de Requisição:

GET api/caminhao

Resposta
  {
    "id": 1,
    "placa": "ABC-1234",
    "empresaId": 1,
    "capacidade": 5000
  }

## 3. Buscar Caminhão por Status
Endpoint: GET /api/caminhao/status/{status}
Descrição: Filtra caminhões pelo status.
Exemplo de Requisição:

api/caminhao/status/ativo

## 4. Buscar Caminhão por ID
Endpoint: GET /api/caminhao/id/{idCaminhao}
Descrição: Retorna um caminhão específico com base no ID.
Exemplo de Requisição:

api/caminhao/id/1

## 5. Sair para Coleta
Endpoint: PUT /api/caminhao/coletar/{idRecipiente}/{idCaminhao}
Descrição: Marca o caminhão como saindo para coletar.
Exemplo de Requisição:

api/caminhao/coletar/2/1

## 6. Retornar de Coleta
Endpoint: PATCH /api/caminhao/retornar/{idEmpresa}/{idCaminhao}
Descrição: Marca o caminhão como retornando de uma coleta.
Exemplo de Requisição:

api/caminhao/retornar/1/1

# 🏢 Empresa API
## 📋 Rotas Disponíveis
## 1. Criar Empresa
Endpoint: POST /api/empresa
Descrição: Registra uma nova empresa no sistema.
Exemplo de Requisição:

  {
    "nome": "Empresa XYZ",
    "cnpj": "00.000.000/0001-00",
    "endereco": "Rua Exemplo, 123",
    "telefone": "(11) 98765-4321"
  }

## 2. Listar Empresas
Endpoint: GET /api/empresa
Descrição: Retorna uma lista de todas as empresas cadastradas.
Exemplo de Requisição:

api/empresa

## 3. Excluir Empresa por ID
Endpoint: DELETE /api/empresa/{idEmpresa}
Descrição: Exclui uma empresa com base no seu ID.
Exemplo de Requisição:

api/empresa/1

## 4. Atualizar Empresa por ID
Endpoint: PUT /api/empresa/{idEmpresa}
Descrição: Atualiza os dados de uma empresa existente.
Exemplo de Requisição:

{
  "nome": "Empresa ABC",
  "cnpj": "00.000.000/0001-01",
  "endereco": "Rua Nova, 456",
  "telefone": "(11) 91234-5678"
}

# 🏠 Morador API
## 📋 Rotas Disponíveis
## 1. Cadastrar Morador
Endpoint: POST /api/morador
Descrição: Registra um novo morador no sistema.
Exemplo de Requisição:

{
  "nome": "Carlos Silva",
  "cpf": "123.456.789-00",
  "email": "carlos@email.com",
  "telefone": "(11) 99999-8888"
}

## 2. Consultar Morador por ID
Endpoint: GET /api/morador/{idMorador}
Descrição: Retorna os detalhes de um morador específico.
Exemplo de Requisição:

/api/morador/1

{
  "id": 1,
  "nome": "Carlos Silva",
  "cpf": "123.456.789-00",
  "email": "carlos@email.com",
  "telefone": "(11) 99999-8888"
}

## 3. Excluir Morador por ID
Endpoint: DELETE /api/morador/{idMorador}
Descrição: Exclui um morador do sistema com base no seu ID.
Exemplo de Requisição:

api/morador/1

# 📢 Notificação API
## 📋 Rotas Disponíveis
## 1. Cadastrar Notificação
Endpoint: POST /api/notificacao
Descrição: Cria uma nova notificação no sistema.
Exemplo de Requisição:

{
  "titulo": "Nova Notificação",
  "mensagem": "Seu caminhão saiu para coleta.",
  "data": "2024-10-18T10:00:00Z"
}

## 2. Consultar Todas as Notificações
Endpoint: GET /api/notificacao
Descrição: Retorna uma lista de todas as notificações.
Exemplo de Requisição:

{
    "id": 1,
    "titulo": "Nova Notificação",
    "mensagem": "Seu caminhão saiu para coleta.",
    "data": "2024-10-18T10:00:00Z"
  },
  {
    "id": 2,
    "titulo": "Outra Notificação",
    "mensagem": "O caminhão retornou com carga.",
    "data": "2024-10-18T11:00:00Z"
  }

# 🗑️ API de Recipientes
## 📋 Rotas Disponíveis
## 1. Cadastrar Recipiente
Endpoint: POST /api/recipiente/{idMorador}
Descrição: Cria um novo recipiente associado a um morador específico.
Parâmetros:

{
  "tipo": "Lata",
  "capacidade": "5L",
  "descricao": "Recipiente para lixo reciclável."
}

## 2. Consultar Todos os Recipientes
Endpoint: GET /api/recipiente
Descrição: Retorna uma lista de todos os recipientes cadastrados.
Exemplo de Requisição:

{
    "id": 1,
    "tipo": "Lata",
    "capacidade": "5L",
    "descricao": "Recipiente para lixo reciclável.",
    "moradorId": 1
  },
  {
    "id": 2,
    "tipo": "Caixa",
    "capacidade": "10L",
    "descricao": "Recipiente para lixo orgânico.",
    "moradorId": 2
  }

## 3. Excluir Recipiente
Endpoint: DELETE /api/recipiente/{idRecipiente}
Descrição: Remove um recipiente específico do sistema
Parâmetros: idRecipiente: ID do recipiente a ser excluído.


# 📊 API de Status
## 📋 Rotas Disponíveis
## 1. Cadastrar Status
Endpoint: POST /api/status
Descrição: Cria um novo status no sistema.
Exemplo de Requisição:

{
  "descricao": "Ativo"
}

## 2. Consultar Todos os Status
Endpoint: GET /api/status
Descrição: Retorna uma lista de todos os status cadastrados.
Exemplo de Requisição:

{
    "id": 1,
    "descricao": "Ativo"
  },
  {
    "id": 2,
    "descricao": "Inativo"
  }

## 3. Consultar Status por ID
Endpoint: GET /api/status/id/{idStatus}
Descrição: Retorna detalhes de um status específico pelo seu ID.
Parâmetros: idStatus: ID do status que você deseja consultar.
Exemplo de Requisição:

{
  "id": 1,
  "descricao": "Ativo"
}

## 4. Consultar Status por Descrição
Endpoint: GET /api/status/descricao/{descricaoStatus}
Descrição: Retorna uma lista de status que correspondem a uma descrição específica.
Parâmetros: descricaoStatus: Descrição do status que você deseja consultar.
Exemplo de Requisição:

{
    "id": 1,
    "descricao": "Ativo"
}

## 5. Atualizar Status
Endpoint: PUT /api/status/{idStatus}
Descrição: Atualiza um status existente.
Parâmetros: idStatus: ID do status que você deseja atualizar.
Exemplo de Requisição:

{
  "id": 1,
  "descricao": "Ativo Atualizado"
}

## 6. Excluir Status
Endpoint: DELETE /api/status/{idStatus}
Descrição: Remove um status específico do sistema.
Parâmetros:
idStatus: ID do status a ser excluído.
Exemplo de Requisição:

 /api/status/1

## 🛠️ Como Rodar a API
1. Pré-requisitos:
- Java 17
- Maven instalado
2. Instalar dependências:
  - mvn clean install
  - mvn spring-boot:run
# Build e Deploy Automático
Este projeto usa dois jobs principais:

1. Build: Cria e envia a imagem Docker para o Docker Hub.
2. Deploy: Faz o deploy no Azure Web App de acordo com a branch.

1. **Clone o repositório:**
   ```bash
   - git clone https://github.com/offteuz/residex.git
   - cd residex

# 🚀 Como Acessar
1. Produção: Acesse a URL de produção para utilizar a versão final da aplicação.
- Acessar Produção

2. Desenvolvimento: Acesse a URL de desenvolvimento para acompanhar novas features e testes.
- Acessar Desenvolvimento


