function monthToString(month) {
  const monthNames = [
    "Ene",
    "Feb",
    "Mar",
    "Abr",
    "May",
    "Jun",
    "Jul",
    "Ago",
    "Sep",
    "Oct",
    "Nov",
    "Dic",
  ];
  return monthNames[month];
}
const eventosContainer = document.getElementById("eventos-container");

fetch("./eventos.json")
  .then((datos) => {
    if (!datos.ok) {
      throw new Error("Error al traer los datos");
    } else {
      return datos.json();
    }
  })
  .then((eventos) => {
    eventos.eventos.forEach((evento) => {
      mostrarLosEventos(evento); // Ensure this matches the function name
    });
    console.log("fetch eventos ok");
  })
  .catch((e) => {
    console.error("Hubo un error al operar con fetch " + e.message);
  });

const mostrarLosEventos = (item) => {
  const itemContainer = document.createElement("div");
  itemContainer.classList.add("col-md-4");
  itemContainer.classList.add("on-hover");

  const cardContainer = document.createElement("div");
  cardContainer.classList.add("card", "border-0", "mb-3", "h-100");

  const link = document.createElement("a");
  link.href = `./eventos/detail/${item.id}.html`;

  const img = document.createElement("img");
  img.src = item.URL_imagen;
  img.alt = item.titulo;
  img.classList.add("card-img-top");

  const fechaContainer = document.createElement("div");
  fechaContainer.classList.add(
    "date-pos",
    "bg-info-gradiant",
    "p-2",
    "d-inline-block",
    "text-center",
    "rounded",
    "text-white",
    "position-absolute",
    "d-flex",
    "flex-row"
  );

  const fecha = new Date(item.fecha);

  const fechaMes = document.createElement("span");
  fechaMes.textContent = monthToString(fecha.getMonth());

  const fechaDia = document.createElement("span");
  fechaDia.textContent = fecha.getDate() + 1;
  fechaDia.classList.add("d-block", "mx-1");

  const titulo = document.createElement("h5");
  titulo.textContent = item.titulo;
  titulo.classList.add("font-weight-medium", "mt-3");

  const titleLink = document.createElement("a");
  titleLink.href = `./eventos/detail/${item.id}.html`;
  titleLink.classList.add("text-decoration-none", "link");

  const descripcion = document.createElement("p");
  descripcion.textContent = item.descripcion;
  descripcion.classList.add("mt-3");

  itemContainer.appendChild(cardContainer);
  cardContainer.appendChild(link);
  link.appendChild(img);
  cardContainer.appendChild(fechaContainer);

  fechaContainer.appendChild(fechaMes);
  fechaContainer.appendChild(fechaDia);
  cardContainer.appendChild(titulo);
  titulo.appendChild(titleLink);
  cardContainer.appendChild(descripcion);
  eventosContainer.appendChild(itemContainer);
};
