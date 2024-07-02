document.addEventListener("DOMContentLoaded", function () {
  const form = document.querySelector("form");
  const emailInput = document.getElementById("email");
  const passwordInput = document.getElementById("password");

  form.addEventListener("submit", function (e) {
    e.preventDefault();

    if (!emailInput.value || !passwordInput.value) {
      alert("Por favor, completa todos los campos.");
      return;
    }
    const userData = {
      email: emailInput.value,
      pass: passwordInput.value,
    };
    fetch("http://localhost:8080/loginUser", {
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
        alert(data.message);
        window.location.href = "/";
      });
  });
});
