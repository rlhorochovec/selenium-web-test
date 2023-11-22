# selenium-web-test
[![selenium-web-test](https://github.com/rlhorochovec/selenium-web-test/actions/workflows/ci.yml/badge.svg)](https://github.com/rlhorochovec/selenium-web-test/actions/workflows/ci.yml)

Projeto de automação de testes web utilizando Selenium, executando via GitHub Actions.

## Dependências
- JDK: 17
- Apache Maven: 3.6.3
- Selenium: 4.15.0
- testng: 7.8.0
- webdrivermanager: 5.6.2

## Instalação
Baixando as dependências

```bash
  cd selenium-web-test
  mvn install
```

## Rodando os testes
Para rodar os testes, rode o seguinte comando

```bash
  mvn test
```

## Para visualizar o navegador executando comente a linha abaixo no arquivo TestRunner.java:
```bash
options.addArguments("--headless");
``