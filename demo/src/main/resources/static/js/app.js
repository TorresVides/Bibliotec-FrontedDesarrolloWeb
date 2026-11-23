// Componente formulario: procesa el registro sin incluir datos locales de libros.
const formulario = document.querySelector("#formulario-biblioteca");
const mensaje = document.querySelector("#mensaje");

formulario.addEventListener("submit", async (evento) => {
  evento.preventDefault();

  const datos = new FormData(formulario);
  const biblioteca = {
    nombre: datos.get("nombre").trim(),
    direccion: datos.get("direccion").trim(),
    ciudad: datos.get("ciudad").trim()
  };

  try {
    await bibliotecaService.registrar(biblioteca);
    formulario.reset();
    mensaje.textContent = "Biblioteca registrada correctamente.";
    await cargarTabla();
  } catch (error) {
    mensaje.textContent = error.message;
  }
});

// Componente tabla: recorre las bibliotecas y crea una fila por cada libro asociado.
async function cargarTabla() {
  const cuerpoTabla = document.querySelector("#tabla-libros");
  cuerpoTabla.replaceChildren();

  try {
    const bibliotecas = await bibliotecaService.consultar();

    bibliotecas.forEach((biblioteca) => {
      biblioteca.libros.forEach((libro) => {
        const fila = document.createElement("tr");
        fila.innerHTML = `
          <td>${libro.titulo}</td>
          <td>${libro.autor}</td>
          <td>${libro.anioPublicacion}</td>
          <td>${biblioteca.nombre}</td>
        `;
        cuerpoTabla.appendChild(fila);
      });
    });
  } catch (error) {
    mensaje.textContent = error.message;
  }
}

// La consulta inicial se realiza al cargar la página.
cargarTabla();
