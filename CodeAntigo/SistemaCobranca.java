public class SistemaCobranca {

    public double cobrarAluno(Aluno aluno) {
        // Implementar lógica de cobrança baseada nas disciplinas matriculadas
        int totalCreditos = 0;

        // Calcular créditos das disciplinas obrigatórias
        for (Object disciplina : aluno.getDisciplinasMatriculadasObrigatoria()) {
            totalCreditos += DisciplinaObrigatoria.getCreditos();
        }

        // Calcular créditos das disciplinas optativas
        for (Object disciplina : aluno.getDisciplinasMatriculadasOptativa()) {
            totalCreditos += DisciplinaOptativa.getCreditos();
        }

        // Valor da cobrança por crédito
        double valorPorCredito = 100.0;

        // Calcular valor total da cobrança
        return totalCreditos * valorPorCredito;
    }

}
