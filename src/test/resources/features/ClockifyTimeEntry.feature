Feature: Time Entry

  @TPFinal_API @GetTimeEntry
  Scenario Outline: Obtener las horas registradas en un workspace
    Given Teniendo un '<ApiKey>' valido generado
    And Un '<WorkspaceId>' asociado a la cuenta
    And Y un userID '<userID>' valido
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    Then status code <statusCode> is obtained
    Then Obtengo la lista de horas agregadas al proyecto

    Examples:
      | operation | entity    | jsonName     | statusCode | ApiKey                                           | WorkspaceId              | userID                   |
      | GET       | TIMEENTRY | timeEntryGET | 200        | MDkxYzFlYmEtNGQ4Ni00ZDA2LTlhYmYtMjJkNjgzYzVmMWUx | 6525bdd143528600a423cca6 | 6525bdd143528600a423cca5 |

  @TPFinal_API @AddTimeEntry
  Scenario Outline: Agregar una entrada de datos a un proyecto
    Given Teniendo un '<ApiKey>' valido generado
    And Un '<WorkspaceId>' asociado a la cuenta
    And Un '<ProyectId>' creado en el workspace
    And Ingreso una descripcion '<description>', hora de entrada '<startTime>' y hora de salida '<endTime>'
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    Then status code <statusCode> is obtained
    Then Obtengo la nueva entrada de datos agregado al proyecto

    Examples:
      | operation | entity       | jsonName     | statusCode | ApiKey                                           | WorkspaceId              | ProyectId                | description | startTime            | endTime              |
      | POST      | ADDTIMEENTRY | addTimeEntry | 201        | MDkxYzFlYmEtNGQ4Ni00ZDA2LTlhYmYtMjJkNjgzYzVmMWUx | 6525bdd143528600a423cca6 | 6525be56f4a5ad59fec5b20b | TPFinal     | 2023-11-29T11:30:00Z | 2023-12-02T08:00:00Z |

  @TPFinal_API @UpdateTimeEntry
  Scenario Outline: Editar una entrada de datos de un proyecto
    Given Teniendo un '<ApiKey>' valido generado
    And Un '<WorkspaceId>' asociado a la cuenta
    And Y un userID '<userID>' valido
    When I perform a 'GET' to 'TIMEENTRY' endpoint with the 'timeEntryGET' and ''
    And Obtengo un userID de la respuesta
    And Ingreso la nueva hora de entrada '<startTime>' y hora de salida '<endTime>'
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    Then status code <statusCode> is obtained

    Examples:
      | operation | entity          | jsonName        | statusCode | ApiKey                                           | WorkspaceId              | userID                   | startTime            | endTime              |
      | PUT       | UPDATETIMEENTRY | updateTimeEntry | 200        | MDkxYzFlYmEtNGQ4Ni00ZDA2LTlhYmYtMjJkNjgzYzVmMWUx | 6525bdd143528600a423cca6 | 6525bdd143528600a423cca5 | 2023-10-29T11:30:00Z | 2023-11-30T08:00:00Z |

  @TPFinal_API @DeletTimeEntry
  Scenario Outline: Eliminar una entrada de datos de un proyecto
    Given Teniendo un '<ApiKey>' valido generado
    And Un '<WorkspaceId>' asociado a la cuenta
    And Un '<ProyectId>' creado en el workspace
    And Ingreso una descripcion '<description>', hora de entrada '<startTime>' y hora de salida '<endTime>'
    When I perform a 'POST' to 'ADDTIMEENTRY' endpoint with the 'addTimeEntry' and ''
    And Obtengo un userID de la respuesta del post
    When I perform a '<operation>' to '<entity>' endpoint with the '<jsonName>' and ''
    Then status code <statusCode> is obtained

    Examples:
      | operation | entity          | jsonName        | statusCode | ApiKey                                           | WorkspaceId              | ProyectId                | description    | startTime            | endTime              |
      | DELETE    | DELETETIMEENTRY | deleteTimeEntry | 204        | MDkxYzFlYmEtNGQ4Ni00ZDA2LTlhYmYtMjJkNjgzYzVmMWUx | 6525bdd143528600a423cca6 | 6525be56f4a5ad59fec5b20b | TPFinal_Delete | 2023-10-29T11:30:00Z | 2023-11-30T08:00:00Z |