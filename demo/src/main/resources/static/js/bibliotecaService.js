// Servicio HTTP: centraliza todas las llamadas al endpoint de Biblioteca.
const bibliotecaService = {
  async registrar(datosBiblioteca) {
    const respuesta = await fetch("/bibliotecas", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(datosBiblioteca)
    });

    if (!respuesta.ok) {
      throw new Error("No fue posible registrar la biblioteca.");
    }
    return respuesta.json();
  },

  async consultar() {
    const respuesta = await fetch("/bibliotecas");
    if (!respuesta.ok) {
      throw new Error("No fue posible consultar las bibliotecas.");
    }

    const datos = await respuesta.json();
    return datos.map((biblioteca) => new BibliotecaModelo(biblioteca));
  }
};
