function login() {
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;

    // Simulate a simple authentication check
    if (username === "admin" && password === "password") {
        // Redirect to the home page (replace with your actual home page URL)
        window.location.href = "http://localhost:8080/OC/admin.html";
    } else {
        document.getElementById("error-message").innerText = "Invalid username or password";
    }
}
