import java.util.ArrayList;
import java.util.List;

class GerenciadorDisciplina {
    private List<Disciplina> disciplinas;
    
    public GerenciadorDisciplina() {
        this.disciplinas = new ArrayList<>();
    }
    
    public void adicionarDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
    }
    
    public List<Disciplina> listarDisciplinas() {
        return disciplinas;
    }
    
    public void removerDisciplina(Disciplina disciplina) {
        disciplinas.remove(disciplina);
    }
}