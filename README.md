# selenium-web-test
[![selenium-web-test](https://github.com/rlhorochovec/selenium-web-test/actions/workflows/ci.yml/badge.svg)](https://github.com/rlhorochovec/selenium-web-test/actions/workflows/ci.yml)

Projeto de automação de testes web utilizando Selenium, Cucumber e TesteNG, executando via GitHub Actions.

## Dependências
- JDK: 17
- Apache Maven: 3.6.3
- Selenium: 4.15.0
- Cucumber: 7.14.0
- Cucumber Reporting: 5.7.4
- TesteNG: 7.8.0
- WebDriverManager: 5.6.2

## Instalação
Baixando as dependências

```bash
  cd selenium-web-test
  mvn install
```

## Rodando os testes
Para rodar os testes, rode o seguinte comando

```bash
  mvn clean verify test
```
## Relatório dos testes
target/cucumber-report-html

## Demonstração
[Assistir vídeo da execução](https://youtu.be/_VEq6Eodp60)

## Screenshots
<img src="https://github.com/rlhorochovec/selenium-web-test/blob/develop/Screenshots/mvn_clean_verify_test.png" width="400" /> <img src="https://github.com/rlhorochovec/selenium-web-test/blob/develop/Screenshots/cucumber_local_1.png" width="400" />
<img src="https://github.com/rlhorochovec/selenium-web-test/blob/develop/Screenshots/cucumber_local_2.png" width="400" /> <img src="https://github.com/rlhorochovec/selenium-web-test/blob/develop/Screenshots/cucumber_report_1.png" width="400" />
<img src="https://github.com/rlhorochovec/selenium-web-test/blob/develop/Screenshots/cucumber_report_2.png" width="400" />

## Para visualizar o navegador executando comente a linha abaixo no arquivo TestRunner.java:
```bash
options.addArguments("--headless");
```