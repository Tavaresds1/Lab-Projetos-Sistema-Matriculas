### 1.1 Aluno

**HU01 - Realizar matrícula**

**Descrição:**  
Como um **Aluno**, quero me matricular em até 4 disciplinas obrigatórias e 2 optativas, para participar no semestre.

**Fluxo Principal:**
1. O **Aluno** acessa o sistema e realiza o login.
2. O sistema exibe as disciplinas disponíveis para o semestre, separadas em obrigatórias e optativas.
3. O **Aluno** seleciona até 4 disciplinas obrigatórias e 2 optativas.
4. O sistema confirma a matrícula e atualiza a grade de horários do **Aluno**.

**Fluxo Alternativo:**
- Se houver conflito de horário ou falta de pré-requisitos, o sistema informa o **Aluno** e sugere ajustes.

**HU02 - Cancelar matrícula**

**Descrição:**  
Como um **Aluno**, quero cancelar minha matrícula em uma disciplina, para ajustar minha grade de horários.

**Fluxo Principal:**
1. O **Aluno** acessa o sistema e realiza o login.
2. O sistema exibe as disciplinas em que o **Aluno** está matriculado.
3. O **Aluno** seleciona a disciplina que deseja cancelar.
4. O sistema remove a matrícula da disciplina.

**Fluxo Alternativo:**
- Se o prazo para cancelamento tiver expirado, o sistema informa o **Aluno** que o cancelamento não é mais possível.

### 1.2 Secretaria

**HU03 - Gerar currículo**

**Descrição:**  
Como um **Funcionário da Secretaria**, quero criar e atualizar o currículo do semestre, para garantir a organização das disciplinas.

**Fluxo Principal:**
1. O **Funcionário da Secretaria** acessa o sistema e realiza o login.
2. O sistema exibe a interface de gerenciamento de currículos.
3. O **Funcionário da Secretaria** adiciona, remove ou atualiza disciplinas no currículo do semestre.
4. O sistema salva as alterações e atualiza a lista de disciplinas disponíveis para matrícula.

**Fluxo Alternativo:**
- Se houver conflito de horário entre disciplinas, o sistema alerta o **Funcionário da Secretaria** para ajustes.

**HU04 - Gerenciar Usuários**

**Descrição:**  
Como um **Funcionário da Secretaria**, quero gerenciar informações sobre professores e alunos, para manter o sistema atualizado.

**Fluxo Principal:**
1. O **Funcionário da Secretaria** acessa o sistema e realiza o login.
2. O sistema exibe a interface de gerenciamento de usuários.
3. O **Funcionário da Secretaria** adiciona, remove ou atualiza informações de **Professores** e **Alunos**.
4. O sistema salva as alterações e atualiza os registros de usuários.

**Fluxo Alternativo:**
- Se houver informações incompletas ou inválidas, o sistema solicita correções ao **Funcionário da Secretaria**.

### 1.3 Professor

**HU05 - Verificar matriculados**

**Descrição:**  
Como um **Professor**, quero acessar a lista de alunos matriculados nas minhas disciplinas.

**Fluxo Principal:**
1. O **Professor** acessa o sistema e realiza o login.
2. O sistema exibe as disciplinas ministradas pelo **Professor**.
3. O **Professor** seleciona uma disciplina para visualizar a lista de alunos matriculados.
4. O sistema exibe a lista de alunos matriculados na disciplina selecionada.

**Fluxo Alternativo:**
- Se não houver alunos matriculados, o sistema informa o **Professor** que a lista está vazia.
