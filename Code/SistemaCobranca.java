public class SistemaCobranca {

    public double cobrarAluno(Aluno aluno) {
        // Implementar lógica de cobrança baseada nas disciplinas matriculadas
        int totalCreditos = 0;

        // Calcular créditos das disciplinas obrigatórias
        for (DisciplinaObrigatoria disciplina : aluno.getDisciplinasMatriculadasObrigatoria()) {
            totalCreditos += disciplina.getCreditos();
        }

        // Calcular créditos das disciplinas optativas
        for (DisciplinaOptativa disciplina : aluno.getDisciplinasMatriculadasOptativa()) {
            totalCreditos += disciplina.getCreditos();
        }

        // Valor da cobrança por crédito
        double valorPorCredito = 100.0;

        // Calcular valor total da cobrança
        return totalCreditos * valorPorCredito;
    }

}
