function validatePayment() {
    var cardNumber = document.getElementById("cardNumber").value;
    var expiryDate = document.getElementById("expiryDate").value;
    var cvv = document.getElementById("cvv").value;
    var email = document.getElementById("email").value;
    var cvv = document.getElementById("Rs").value;

    // Validate 16-digit card number
    if (!isValidCardNumber(cardNumber)) {
        displayError("Invalid card number. Please enter a 16-digit number.");
        return false;
    }

    // Perform additional validation for expiry date and CVV if needed

    // Simulate payment processing (replace with actual payment processing logic)
    alert("Payment successful!");
    return false;
}

function isValidCardNumber(cardNumber) {
    // Validate 16-digit card number
    var cardNumberRegex = /^[0-9]{16}$/;
    return cardNumberRegex.test(cardNumber);
}

function displayError(message) {
    document.getElementById("error-message").innerText = message;
}
