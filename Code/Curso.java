import java.util.ArrayList;
import java.util.List;

class Curso {

    private String nome;
    private int creditos;
    private List<Disciplina> disciplinas;

    public Curso(String nome, int creditos) {
        this.nome = nome;
        this.creditos = creditos;
        this.disciplinas = new ArrayList<>();
    }

    public void adicionarDisciplinaObrigatoria(DisciplinaObrigatoria disciplina) {
        this.disciplinas.add(disciplina);
    }
    public void adicionarDisciplinaOptativa(DisciplinaOptativa disciplina) {
        this.disciplinas.add(disciplina);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
}
