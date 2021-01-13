# Teste_de_Software
Projeto para disciplina de Teste de Software.

### Descrição do Sistema
Sistema de Gerenciamento de Folha de Pagamento em que os funcionários são classificados da seguinte forma:
* **Horistas:** Eles recebem um salário por hora trabalhada. Eles submetem "cartões de ponto" todo dia para informar o número de horas trabalhadas naquele dia. Recebem todas as sextas-feiras;
* **Assalariados:** Eles recebem um salário fixo mensal. São pagos no último dia útil do mês;
* **Comissionados:** Além do salário-base, recebem também uma comissão por cada venda realizada. O percentual de comissão varia de empregado para empregado. Eles são pagos a cada 2 sextas-feiras.

O sistema gera um idenficador único para cada funcionário, possibilitando acessar as informações de cada, como nome, endereço, método de pagamento, tipo, data de pagamento, salário e se possui filiação sindical (caso possua, é descontado o valor de 12,5% do salário bruto do funcionário).

#### Funcionalidades
* Adicionar Empregado;
* Remover Empregado;
* Acessar Informações;
* Alterar Informações;
* Bater Ponto;
* Lançar Venda;
* Rodar Folha de Pagamento do Dia;
* Finalizar Dia de Trabalho.

### Tecnologias Utilizadas
* JDK 11
* MySQL 8.0.22
* JUnit 4.12
* Intellij 2019.3.2
