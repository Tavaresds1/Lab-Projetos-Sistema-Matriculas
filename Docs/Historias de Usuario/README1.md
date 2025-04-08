### 1.1 Aluno

**HU01 - Trocar moeda por cupom**

**Descrição:**  
Como um **Aluno**, quero trocar minhas moedas por cupons para aproveitar as vantagens oferecidas pelas empresas parceiras.

**Fluxo Principal:**
1. O **Aluno** acessa o sistema e realiza o login.
2. O sistema autentica o usuário.
3. O **Aluno** acessa a opção de troca de moedas.
4. O sistema exibe as vantagens disponíveis com seus respectivos custos.
5. O **Aluno** seleciona uma vantagem e confirma a troca.
6. O sistema envia um cupom por e-mail ao **Aluno** e atualiza seu saldo.

**Fluxo Alternativo:**
- Se o saldo for insuficiente, o sistema informa o **Aluno** e impede a troca.

**HU02 - Consultar extrato**

**Descrição:**  
Como um **Aluno**, quero consultar meu extrato para visualizar todas as transações de moedas realizadas.

**Fluxo Principal:**
1. O **Aluno** acessa o sistema e realiza o login.
2. O sistema autentica o usuário.
3. O **Aluno** acessa a opção de consultar extrato.
4. O sistema exibe a lista de transações realizadas, com data, tipo e valor.

**HU03 - Cadastrar-se no sistema**

**Descrição:**  
Como um **Aluno**, quero me cadastrar no sistema para acessar as funcionalidades disponíveis.

**Fluxo Principal:**
1. O **Aluno** acessa a tela de cadastro.
2. O **Aluno** preenche seus dados pessoais (nome, CPF, RG, curso, etc.).
3. O sistema valida e salva os dados.
4. O sistema cria uma conta de acesso para o Aluno.


### 1.2 Professor

**HU04 - Enviar moedas para aluno**

**Descrição:**  
Como um **Professor**, quero enviar moedas para os alunos como forma de reconhecimento por boas práticas.
**Fluxo Principal:**
1. O **Professor** acessa o sistema e realiza o login.
2. O sistema autentica o usuário.
3. O **Professor** acessa a opção de envio de moedas.
4. O **Professor** seleciona um Aluno, define o valor e escreve uma mensagem.
5. O sistema registra a transação e envia uma notificação por e-mail ao Aluno.
   
**Fluxo Alternativo:**
- Se o **Professor** não tiver saldo suficiente, o sistema emite um aviso e não realiza a operação.

**HU05 - Consultar extrato**

**Descrição:**  
Como um **Professor**, quero consultar meu extrato de moedas para acompanhar as transações realizadas.

**Fluxo Principal:**
1. O **Professor** acessa o sistema e realiza o login.
2. O sistema autentica o usuário.
3. O **Professor** acessa a opção de extrato.
4. O sistema exibe as transações de moedas realizadas.

### 1.3 Empresa Parceira

**HU06 - Cadastrar vantagem**

**Descrição:**  
Como uma **Empresa Parceira**, quero cadastrar vantagens com descrição e foto para que os alunos possam trocá-las por moedas.

**Fluxo Principal:**
1. A **Empressa** acessa o sistema e realiza o login.
2. O sistema autentica o usuário.
3. A **Empresa** acessa a funcionalidade de cadastro de vantagem.
4. A **Empresa** informa a descrição, foto e o custo em moedas da vantagem.
5. O sistema salva e disponibiliza a vantagem para os Alunos.
