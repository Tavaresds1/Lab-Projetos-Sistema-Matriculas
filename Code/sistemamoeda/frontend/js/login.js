const API_URL = 'http://localhost:9090/login';

document.getElementById('loginForm').addEventListener('submit', async function(e) {
    e.preventDefault();

    const email = document.getElementById('email').value;
    const senha = document.getElementById('senha').value;

    try {
        const response = await fetch(API_URL, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ email, senha })
        });

        if (response.ok) {
            const aluno = await response.json();
            // Armazena dados no localStorage (ou sessionStorage)
            localStorage.setItem('alunoLogado', JSON.stringify(aluno));
            // Redireciona para dashboardAluno.html
            window.location.href = 'dashboardAluno.html';
        } else {
            const erro = await response.text();
            alert('Erro ao fazer login: ' + erro);
        }
    } catch (error) {
        console.error('Erro no login:', error);
        alert('Erro de conexão com o servidor.');
    }
});