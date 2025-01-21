const app = document.getElementById('app');

// Register Form
const registerForm = `
    <h2>Register</h2>
    <input type="text" id="name" placeholder="Name">
    <input type="email" id="email" placeholder="Email">
    <input type="password" id="password" placeholder="Password">
    <button onclick="register()">Register</button>
`;

// Display Register Form
app.innerHTML = registerForm;

// Register Function
async function register() {
    const name = document.getElementById('name').value;
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    const response = await fetch('http://localhost:8080/api/users/register', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ name, email, password }),
    });

    if (response.ok) {
        alert('User registered successfully!');
    } else {
        alert('Failed to register user');
    }
}
