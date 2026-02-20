# 💍 Lariel — Backend (Java + Quarkus)

API REST do sistema **Lariel**, responsável por toda a regra de negócio e integração com o banco Oracle.  
Este backend atende tanto o **site público** (convidados) quanto o **painel administrativo** (noivos), oferecendo endpoints para:

- Convites e convidados (RSVP / lista de presença)
- Recados (pendentes e aceitos) com moderação
- Persistência e consultas no **Oracle SQL**

---

## 📌 Status

🚧 Em desenvolvimento contínuo  
✔ Endpoints REST principais implementados  
✔ Integração com Oracle via DAO  
✔ Separação em camadas (Resource → BO → DAO → TO)

---

## 🧠 Visão Geral da Arquitetura

O projeto segue uma arquitetura em camadas para manter o código organizado e fácil de evoluir:

## 🔹 Resource

Responsável por expor os endpoints REST e receber requisições HTTP.

Exemplo:
- `ConviteResource`
- `ConvidadoResource`
- `RecadosPendentesResource`
- `RecadosAceitosResource`

---

## 🔹 Business Object (BO)

Contém as regras de negócio, validações e fluxos do sistema.

Exemplo:
- Atualizar status de presença
- Aceitar ou recusar recado
- Buscar convidados por convite

---

## 🔹 DAO

Responsável por executar comandos SQL utilizando `PreparedStatement`.

Exemplo:
- SELECT
- INSERT
- UPDATE
- DELETE

---

## 🔹 Transfer Objects (TO)

Objetos simples utilizados para transportar dados entre camadas.

Exemplo:
- `ConviteTO`
- `ConvidadoTO`
- `RecadoPendenteTO`
- `RecadoAceitosTO`

---

## 🔹 ConnectionFactory

Classe responsável por:

- Criar conexão com Oracle
- Encerrar conexão corretamente
- Centralizar configuração de acesso ao banco

---

# 🗃 Modelo de Negócio

## 📩 Convite

Representa um grupo/família.

Campos:
- `idConvite` (String)
- `nomeConvite` (String)

---

## 👥 Convidado

Convidado vinculado a um convite.

Campos:
- `idConvidado` (Long)
- `idConvite` (String)
- `nomeConvidado` (String)
- `status` (String)

### Status possíveis:
- `P` → Pendente
- `C` → Confirmado
- `A` → Ausente

---

## 📝 Recado Pendente

Mensagem enviada pelo site público aguardando aprovação.

Campos:
- `idRecadoPendente`
- `nomeConvidados`
- `mensagem`
- `dataMensagem`

---

## ✅ Recado Aceito

Mensagem aprovada e publicada no mural.

Campos:
- `idRecadoAceitos`
- `nome`
- `mensagem`
- `dataMensagem`

---

# 🔄 Fluxos de Negócio

## 🔹 Fluxo RSVP

1. Usuário acessa confirmação de presença
2. Sistema busca convidados vinculados ao convite
3. Atualiza status individual (`P`, `C`, `A`)
4. Salva no banco

---

## 🔹 Fluxo de Recados

1. Visitante envia recado → `POST /pendentes`
2. Recado salvo como pendente
3. No painel ADM:
    - Aceitar → move para `aceitos`
    - Recusar → remove
4. Site público consome `GET /aceitos`

---

# 🌐 Endpoints REST

## 📩 Convites

- `GET /convites`
- `GET /convites/{id}`
- `POST /convites`
- `PUT /convites/{id}`
- `DELETE /convites/{id}`

---

## 👥 Convidados

- `GET /convidados`
- `GET /convidados/{id}`
- `GET /convidados/convidados_de/{idConvite}`
- `POST /convidados`
- `PUT /convidados/{id}`
- `PUT /convidados/status/{id}`
- `DELETE /convidados/{id}`

---

## 📝 Recados Pendentes

- `GET /pendentes`
- `POST /pendentes`
- `DELETE /pendentes/{id}`

---

## ✅ Recados Aceitos

- `GET /aceitos`
- `POST /aceitos`
- `DELETE /aceitos/{id}`

---

# 🛠 Tecnologias Utilizadas

- Java
- Quarkus
- Jakarta REST
- Jackson (serialização JSON)
- Oracle SQL
- Maven
- Render (deploy)

---

# ⚙ Configuração

A aplicação utiliza conexão manual via `ConnectionFactory`.

Configure:
- URL do banco Oracle
- Usuário
- Senha

Recomenda-se usar variáveis de ambiente em produção.

---

# ▶️ Rodando em Desenvolvimento

```bash
./mvnw quarkus:dev