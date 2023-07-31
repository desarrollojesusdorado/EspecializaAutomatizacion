#Author: Jesus Dorado
#language: es


  Característica: Carga de archivo median API

    @Prueba5
    Escenario: Carga exitosa de archivo
      Dado que Jesus quiere registrar una persona en api members
      Cuando el quiere realizar el consumo para cargar un archivo
      Entonces el verifica el mensaje "File uploaded successfully!"
