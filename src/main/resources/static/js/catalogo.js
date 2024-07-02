const catalogContainer = document.getElementById("catalog-container");

fetch("http://localhost:8080/listarLibros")
  .then((datos) => {
    if (!datos.ok) {
      throw new Error("Error al traer los datos");
    } else {
      console.log("todo OK");
      return datos.json();
    }
  })
  .then((libros) => {
    libros.forEach((libro) => {
      mostrarLosLibros(libro); // Ensure this matches the function name
    });
    console.log("fetch catalogo ok");
  })
  .catch((e) => {
    console.error("Hubo un error al operar con fetch " + e.message);
  });

const mostrarLosLibros = (libro) => {
  const itemContainer = document.createElement("div");
  itemContainer.classList.add("item-container");

  const bookContainer = document.createElement("div");
  bookContainer.classList.add("book-container");

  const link = document.createElement("a");
  link.href = `./pages/detail/${libro.id}.html`;

  const img = document.createElement("img");
  img.src = `./images/libros/portada-libro${libro.id}.jpg`; //libro.URL_portada;
  img.alt = libro.titulo;
  img.classList.add("product-item");

  const title = document.createElement("h5");
  title.textContent = libro.titulo;

  const genre = document.createElement("p");
  genre.textContent = libro.genero;

  link.appendChild(img);
  bookContainer.appendChild(link);
  itemContainer.appendChild(bookContainer);
  itemContainer.appendChild(title);
  itemContainer.appendChild(genre);
  catalogContainer.appendChild(itemContainer);
};
