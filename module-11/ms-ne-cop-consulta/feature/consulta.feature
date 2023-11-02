Feature: Notificaciones de investigación
  Todos quiere registrar su investigación

  Scenario: el usuario recibirá notificaciones de las investigaciones publicadas, incluída las suyas
    Given Una nueva investigación
    When Usuario se encuentre conectado a cierto endpoint, 
    Then recibirá las notificaciones ocn detalle que son suyas, o si está en fase de prueba, o si es un usuario PREMIUM