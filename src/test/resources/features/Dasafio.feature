Feature: Executar os testes sobre o desafio proposto

  @test01
  Scenario: Criar Novo usuario
    Given Acesso ao link de teste
    And Clico em sign in
    When insiro um email valido
    And preencho as informacoes
    Then usuario criado com sucesso

  @test02
  Scenario: Realizar login
    Given Acesso ao link de teste
    And Clico em sign in
    When insiro as informacoes de login
    Then login realizado com sucesso
