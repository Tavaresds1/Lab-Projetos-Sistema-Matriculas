const API_URL = 'http://localhost:9090/aluno';


// Função para salvar aluno (criar ou atualizar)
document.getElementById('alunoForm').addEventListener('submit', async function(e) {
    e.preventDefault();
    
    const alunoId = document.getElementById('alunoId').value;
    const aluno = {
        nome: document.getElementById('nome').value,
        email: document.getElementById('email').value,
        senha: document.getElementById('senha').value, // Added senha
        cpf: document.getElementById('cpf').value,
        endereco: document.getElementById('endereco').value,
        instituicaoEnsino: document.getElementById('instituicaoEnsino').value,
        curso: document.getElementById('curso').value
        // Saldo é definido no backend, não precisa enviar daqui para criação.
    };

    try {
        const url = alunoId ? `${API_URL}/atualizar/${alunoId}` : `${API_URL}/criar`;
        const method = alunoId ? 'PUT' : 'POST';

        const response = await fetch(url, {
            method: method,
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(aluno)
        });

        if (response.ok) {
            alert(alunoId ? 'Aluno atualizado com sucesso!' : 'Aluno criado com sucesso!');
            if (!alunoId) {
                window.location.href = 'login.html'; // Redireciona para login após criação
            }
        } else {
            const errorData = await response.json(); // Backend envia lista de mensagens de erro
            if (response.status === 400 && Array.isArray(errorData)) {
                // Exibir mensagens de validação específicas
                alert('Erro ao salvar aluno:\n' + errorData.join('\n'));
            } else if (errorData && errorData.message) { // Caso genérico de erro do Spring
                 alert('Erro ao salvar aluno: ' + errorData.message);
            } else {
                alert('Erro ao salvar aluno. Status: ' + response.status);
            }
        }
    } catch (error) {
        console.error('Erro ao salvar aluno:', error);
        alert('Erro ao salvar aluno. Verifique o console para mais detalhes.');
    }
});

// Função para editar aluno
async function editarAluno(id) {
    try {
        const response = await fetch(`${API_URL}/buscarId/${id}`);
        const aluno = await response.json();

        document.getElementById('alunoId').value = aluno.id;
        document.getElementById('nome').value = aluno.nome;
        document.getElementById('email').value = aluno.email;
        document.getElementById('cpf').value = aluno.cpf;
        document.getElementById('endereco').value = aluno.endereco;
        document.getElementById('instituicaoEnsino').value = aluno.instituicaoEnsino;
        document.getElementById('curso').value = aluno.curso;
        document.getElementById('senha').value = ''; // Limpar campo senha ao editar por segurança/UX
        // Saldo não é editável por aqui
    } catch (error) {
        console.error('Erro ao carregar dados do aluno para edição:', error);
        alert('Erro ao carregar dados do aluno para edição.');
    }
}

// Função para deletar aluno
async function deletarAluno(id) {
    if (confirm('Tem certeza que deseja excluir este aluno?')) {
        try {
            const response = await fetch(`${API_URL}/deletar/${id}`, {
                method: 'DELETE'
            });

            if (response.ok) {
                alert('Aluno excluído com sucesso!');
                carregarAlunos();
            } else {
                alert('Erro ao excluir aluno. Status: ' + response.status);
            }
        } catch (error) {
            console.error('Erro ao excluir aluno:', error);
            alert('Erro ao excluir aluno. Verifique o console.');
        }
    }
}

// Função para limpar formulário
function limparFormulario() {
    document.getElementById('alunoForm').reset();
    document.getElementById('alunoId').value = ''; // Garante que o ID oculto seja limpo
}