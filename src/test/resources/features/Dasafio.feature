Feature: Executar os testes sobre o desafio pedido

  @test01 @todos
  Scenario: Criar Novo Cliente
    Given Acesso ao link de teste
    And Clico em novo para adcionar novo cliente
    When Insiro as informações
    Then Valido a criacao

  @test02 @todos
  Scenario: Editar cliente
    Given Acesso ao link de teste
    And Clico no botao de editar
    When edito a opcao desejada
    Then Valido a edicao

  @test03 @todos
  Scenario: Deletar cliente
    Given Acesso ao link de teste
    When Clico no botao de editar
    Then clico em deletar

  @test04 @todos
  Scenario: Criar email cliente
    Given Acesso ao link de teste
    And Clico no botao de editar
    When clico em mostrar categorias
    And clico no botao novo
    And preencho os campos
    Then clico em cadastrar