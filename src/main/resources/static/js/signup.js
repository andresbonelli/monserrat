document.addEventListener("DOMContentLoaded", function () {
  const form = document.querySelector("form");
  const emailInput = document.getElementById("email");
  const passwordInput = document.getElementById("password");
  const confirmPasswordInput = document.getElementById("confirmPassword");

  form.addEventListener("submit", function (e) {
    e.preventDefault();

    if (
      !validateInputs(
        emailInput.value,
        passwordInput.value,
        confirmPasswordInput.value
      )
    ) {
      alert("Por favor complete todos los campos.");
      return;
    }

    const userData = {
      email: emailInput.value,
      pass: passwordInput.value,
    };

    fetch("http://localhost:8080/addUser", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(userData),
    })
      .then((response) => {
        if (!response.ok) {
          return response.json().then((errorMessage) => {
            alert(errorMessage.message);
            throw new Error(errorMessage);
          });
        }
        return response.json();
      })
      .then((data) => {
        console.log("Success:", data.message);
        alert("Usuario registrado correctamente");
        window.location.href = "login.html";
      })
      .catch((error) => {
        console.error("Error with addUser fetch operation: ", error);
        alert("Error en la registración. Por favor intente nuevamente.");
      });
  });

  function validateInputs(email, password, confirmPassword) {
    if (!email || !password || !confirmPassword) {
      return false;
    }
    if (password !== confirmPassword) {
      return false;
    }
    return true;
  }
});
