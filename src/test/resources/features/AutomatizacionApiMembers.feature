#Author: Jesus Dorado
#language: es

@PruebaGeneral
Característica: Automatizacion Api members

  Antecedentes:
    Dado que Jesus quiere registrar una persona en api members

  @Prueba1
  Esquema del escenario: Registro exitoso persona en API MEMBERS
    Cuando el consume el servicio con nombre y genero de la persona
      | name   | gender   |
      | <name> | <gender> |
    Entonces el verifica que la respuesta del servicio sea <codigoRespuesta>
    Y el verifica la informacion de la persona en el response

    Ejemplos:
      | name  | gender | codigoRespuesta |
      | jesus | Male   | 201             |

  @Prueba2
  Esquema del escenario: Consulta exitosa persona registrada en API MEMBERS
    Cuando el realiza la consulta de un miembro con <id>
    Entonces el verifica que la respuesta del servicio sea <codigoRespuesta>
    Y el verifica que el '<name>'  y '<gender>' sean correctos
    Ejemplos:
      | id | name   | gender | codigoRespuesta |
      | 31 | Ravina | Female | 200             |

  @Prueba3
  Esquema del escenario: Actualizacion exitosa datos persona en API MEMBERS
    Cuando el actualiza los siguientes datos para el miembro con <id>
      | name   | gender   |
      | <name> | <gender> |
    Entonces el verifica que la respuesta del servicio sea <codigoRespuesta>
    Y el verifica que la actualizacion sea correcta con los datos:
      | name   | gender   |
      | <name> | <gender> |
    Y verifica que el mensaje del ws "sea Member with id 31 is updated successfully"
    Ejemplos:
      | id | name   | gender | codigoRespuesta |
      | 31 | Albert | Male   | 200             |

  @Prueba4
  Esquema del escenario: Creacion de usuario y eliminacion exitosa
    Cuando el consume el servicio con nombre y genero de la persona
      | name   | gender   |
      | <name> | <gender> |
    Y el verifica que la respuesta del servicio sea <codigoRespuestaPost>
    Y el elimina al miembro del sistema
    Entonces el verifica la eliminacion del miembro del sistema
    Ejemplos:
      | name   | gender | codigoRespuestaPost |
      | Nezuko | Female | 201                 |