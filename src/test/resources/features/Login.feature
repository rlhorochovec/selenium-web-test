# language: pt
Funcionalidade: Login
  Eu como usuário do sistema
  Desejo realizar o login no sistema
  Para realizar minhas tarefas

  @LoginInvalido
  Esquema do Cenário: Login inválido
    Dado que desejo acessar o sistema
    Quando inserir usuário "<usuario>" e senha "<senha>"
    E clicar no botão Entrar
    Então apresentará uma mensagem de "<mensagem>"
    Exemplos:
      | usuario | senha  | mensagem                       |
      | admin   |        | Informe a senha!               |
      |         | user   | Informe o usuário!             |
      | admin   | user   | Usuário e/ou senha incorretos! |
      |         |        | Informe usuário e senha!       |