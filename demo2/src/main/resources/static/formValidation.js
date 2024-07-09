
function validateForm() {
    let firstName = document.getElementById("firstName").value;
    let lastName = document.getElementById("lastName").value;
    let email = document.getElementById("email").value;
    let phone = document.getElementById("phone").value;

    if (firstName === "" || lastName === "" || email === "") {
        alert("First Name, Last Name, and Email are required!");
        return false;
    }

    // Simple email validation
    let emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
    if (!emailPattern.test(email)) {
        alert("Invalid email format!");
        return false;
    }

    return true;
}
