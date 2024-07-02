document.addEventListener('DOMContentLoaded', function() {
    const form = document.querySelector('form');
    const emailInput = document.getElementById('email');
    const passwordInput = document.getElementById('password');
  
    form.addEventListener('submit', function(event) {
      event.preventDefault(); 

      if (!emailInput.value ||!passwordInput.value) {
        alert('Por favor, completa todos los campos.');
      } else {
        console.log('Formulario enviado correctamente');
      }
    });
  });
  