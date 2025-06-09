const API_URL = 'http://localhost:9090/empresa';

// Carregar empresas ao iniciar a página
document.addEventListener('DOMContentLoaded', carregarEmpresas);

// Função para carregar todas as empresas
async function carregarEmpresas() {
    try {
        const response = await fetch(`${API_URL}/listarTodas`);
        const empresas = await response.json();
        const tbody = document.getElementById('empresasTableBody');
        tbody.innerHTML = '';

        empresas.forEach(empresa => {
            const tr = document.createElement('tr');
            tr.innerHTML = `
                <td>${empresa.nome}</td>
                <td>${empresa.descricao}</td>
                <td>${empresa.vantagens ? empresa.vantagens.length : 0} vantagens</td>
                <td>
                    <button class="btn btn-sm btn-primary" onclick="editarEmpresa('${empresa.id}')">Editar</button>
                    <button class="btn btn-sm btn-danger" onclick="deletarEmpresa('${empresa.id}')">Excluir</button>
                </td>
            `;
            tbody.appendChild(tr);
        });
    } catch (error) {
        console.error('Erro ao carregar empresas:', error);
        alert('Erro ao carregar empresas');
    }
}

// Função para adicionar campo de vantagem
function adicionarVantagem() {
    const container = document.getElementById('vantagensContainer');
    const div = document.createElement('div');
    div.className = 'vantagem-item mb-2';
    div.innerHTML = `
        <div class="row">
            <div class="col-md-6">
                <input type="text" class="form-control" placeholder="Descrição da Vantagem" required>
            </div>
            <div class="col-md-4">
                <input type="text" class="form-control" placeholder="URL da imagem" required>
            </div>
            <div class="col-md-4">
                <input type="number" class="form-control" placeholder="Custo" required>
            </div>
            <div class="col-md-2">
                <button type="button" class="btn btn-danger" onclick="removerVantagem(this)">Remover</button>
            </div>
        </div>
    `;
    container.appendChild(div);
}

// Função para remover campo de vantagem
function removerVantagem(button) {
    button.closest('.vantagem-item').remove();
}

// Função para coletar vantagens do formulário
function coletarVantagens() {
    const vantagens = [];
    const items = document.querySelectorAll('.vantagem-item');

    items.forEach(item => {
        const inputs = item.querySelectorAll('input');
        vantagens.push({
            descricao: inputs[0].value,
            urlImagem: inputs[1].value,
            custo: parseFloat(inputs[2].value)
        });
    });

    return vantagens;
}

// Função para salvar empresa (criar ou atualizar)
document.getElementById('empresaForm').addEventListener('submit', async function(e) {
    e.preventDefault();
    
    const empresaId = document.getElementById('empresaId').value;
    const empresa = {
        nome: document.getElementById('nome').value,
        descricao: document.getElementById('descricao').value,
        vantagens: coletarVantagens()
    };

    try {
        const url = empresaId ? `${API_URL}/atualizar/${empresaId}` : `${API_URL}/criar`;
        const method = empresaId ? 'PUT' : 'POST';

        const response = await fetch(url, {
            method: method,
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(empresa)
        });

        if (response.ok) {
            alert(empresaId ? 'Empresa atualizada com sucesso!' : 'Empresa criada com sucesso!');
            limparFormulario();
            carregarEmpresas();
        } else {
            alert('Erro ao salvar empresa');
        }
    } catch (error) {
        console.error('Erro ao salvar empresa:', error);
        alert('Erro ao salvar empresa');
    }
});

// Função para editar empresa
async function editarEmpresa(id) {
    try {
        const response = await fetch(`${API_URL}/buscarId/${id}`);
        const empresa = await response.json();

        document.getElementById('empresaId').value = empresa.id;
        document.getElementById('nome').value = empresa.nome;
        document.getElementById('descricao').value = empresa.descricao;

        // Limpar vantagens existentes
        const container = document.getElementById('vantagensContainer');
        container.innerHTML = '';

        // Adicionar vantagens da empresa
        if (empresa.vantagens && empresa.vantagens.length > 0) {
            empresa.vantagens.forEach(vantagem => {
                const div = document.createElement('div');
                div.className = 'vantagem-item mb-2';
                div.innerHTML = `
                    <div class="row">
                        <div class="col-md-6">
                            <input type="text" class="form-control" value="${vantagem.descricao}" required>
                        </div>
                        <div class="col-md-4">
                            <input type="text" class="form-control" value="${vantagem.urlImagem}" required>
                        </div>
                        <div class="col-md-4">
                            <input type="number" class="form-control" value="${vantagem.custo}" required>
                        </div>
                        <div class="col-md-2">
                            <button type="button" class="btn btn-danger" onclick="removerVantagem(this)">Remover</button>
                        </div>
                    </div>
                `;
                container.appendChild(div);
            });
        } else {
            adicionarVantagem(); // Adiciona um campo vazio se não houver vantagens
        }
    } catch (error) {
        console.error('Erro ao carregar empresa:', error);
        alert('Erro ao carregar dados da empresa');
    }
}

// Função para deletar empresa
async function deletarEmpresa(id) {
    if (confirm('Tem certeza que deseja excluir esta empresa?')) {
        try {
            const response = await fetch(`${API_URL}/deletar/${id}`, {
                method: 'DELETE'
            });

            if (response.ok) {
                alert('Empresa excluída com sucesso!');
                carregarEmpresas();
            } else {
                alert('Erro ao excluir empresa');
            }
        } catch (error) {
            console.error('Erro ao excluir empresa:', error);
            alert('Erro ao excluir empresa');
        }
    }
}

// Função para limpar formulário
function limparFormulario() {
    document.getElementById('empresaForm').reset();
    document.getElementById('empresaId').value = '';
    const container = document.getElementById('vantagensContainer');
    container.innerHTML = '';
    adicionarVantagem(); // Adiciona um campo vazio
} 