# Desafio Técnico 

## Projetos

- Projeto 1: Caixa de Livros
## O que faz:

Projeto tem o intuito de simular uma caixa de livros, onde é utilizado o conceito de Pilha(LIFO)

## Regras de negócio

O último livro que é colocado é o primeiro livro que ao ser acionado o método que faz a retirada dos livros da caixa sai, ou seja literalmente se entende que é uma pilha, pois o primeiro livro está na parte inferior da pilha enquanto o último está na parte superior

Não existe a possibilidade de tentar tirar o livro de uma caixa vazia, ou seja existe uma verificação que se antecipa para que quando acionado o método para retirar algum livro da caixa, seja emitido um aviso que a caixa está vazia e retorna ao menu principal


- Projeto 2: Sistema de Cobrança
## O que faz:

Projeto com a intenção de criar a interação de uma compra através de um sistema de venda, com opções para cartão, avista e pix.

## Regras de negócio

Se a forma de pagamento selecionada for PIX, o sistema aplica um desconto de 10% a compra. Todavia se a mesma for no cartão, existe uma taxa ao parcelamento, já no dinheiro está isento de taxas e descontos.

- Projeto 3: Caixa da Livraria
## O que faz:

União dos dois projetos 1 e 2, através de implementações de interfaces para gerar recibo, onde o usuário consegue gerar uma compra, cadastrando os livros que o cliente pediu, podendo até tirar os livros de cima da caixa, se caso o cliente não quiser comprar. Portanto para concluir a compra, após a seleção dos livros, seleciona então o método de pagamento, podendo ser PIX, crédito parcelado e à vista.

## Regras de negócio

tratar as exceções com try/cacth, utilizar o FileWriter ou BufferedWriter para gerar o recibo e integrar ambos projetos em um só. 