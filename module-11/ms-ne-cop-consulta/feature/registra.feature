Feature: Registrar mi investigación
  Todos quiere registrar su investigación

  Scenario: Un usuario quiere registrar su investigación
    Given Título y detalle resumen de la investigación
    When Usuario envía la data de su investigación y detalle válidos
    Then Se registra la información y se devuelve un código de investigación.

Feature: Registrar mi investigación
  Todos quiere registrar su investigación

  Scenario: Un usuario quiere registrar su investigación pero hay un bad request
    Given Solo el detalle de la investigación, sin un título
    When Usuario envía la data de su investigación y detalle 
    Then Se devuelve un mensaje de error