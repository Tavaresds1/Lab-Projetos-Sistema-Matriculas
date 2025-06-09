document.addEventListener('DOMContentLoaded', () => {
    const loginForm = document.getElementById('loginForm');
    const errorMessageDiv = document.getElementById('errorMessage');
    
    // Define the base URL for your Spring Boot API
    const API_BASE_URL = 'http://localhost:9090'; // Ensure this is your Spring Boot app's URL

    if (loginForm) {
        loginForm.addEventListener('submit', async (event) => {
            event.preventDefault(); 
            errorMessageDiv.classList.add('d-none'); 
            errorMessageDiv.textContent = '';

            const email = document.getElementById('email').value;
            const senha = document.getElementById('senha').value;

            const loginData = {
                email: email,
                senha: senha
            };

            try {
                // Use the API_BASE_URL for the fetch request
                const response = await fetch(`${API_BASE_URL}/login`, { 
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(loginData)
                });

                if (response.ok) {
                    const responseBody = await response.text(); 
                    if (responseBody === "Login realizado com sucesso!") {
                        alert("Login realizado com sucesso!");
                        window.location.href = 'index.html'; 
                    } else {
                        // If the backend returns 200 OK but not the expected success message
                        const contentType = response.headers.get("content-type");
                        if (contentType && contentType.indexOf("application/json") !== -1) {
                            const jsonData = await response.json(); // Re-parse as JSON if it was actually JSON
                            displayError(jsonData.message || JSON.stringify(jsonData));
                        } else {
                            displayError(responseBody || "Resposta inesperada do servidor.");
                        }
                    }
                } else {
                    // Handle HTTP errors (e.g., 400, 401, 500)
                    let errorContent = "Ocorreu um erro. Tente novamente."; // Default error
                    try {
                        // Try to parse as JSON, as your controller sends JSON for 400 errors
                        const errorData = await response.json(); 
                        if (response.status === 400 && Array.isArray(errorData)) {
                            errorContent = errorData.join('\n');
                        } else if (typeof errorData === 'string') { 
                            errorContent = errorData;
                        } else if (errorData && errorData.message) {
                            errorContent = errorData.message;
                        } else if (errorData) {
                            errorContent = JSON.stringify(errorData);
                        }
                    } catch (e) {
                        // If response is not JSON, try to read as text
                        errorContent = await response.text();
                        if (!errorContent) { // If text is also empty
                           errorContent = `Erro: ${response.status} - ${response.statusText}`;
                        }
                    }
                    displayError(errorContent);
                }
            } catch (error) {
                console.error('Erro ao tentar fazer login:', error);
                displayError('Não foi possível conectar ao servidor. Verifique se o backend está rodando e tente novamente.');
            }
        });
    }

    function displayError(message) {
        errorMessageDiv.textContent = message;
        errorMessageDiv.classList.remove('d-none');
    }
});