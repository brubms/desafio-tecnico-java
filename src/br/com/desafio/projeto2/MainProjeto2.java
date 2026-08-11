package br.com.desafio.projeto2;

import java.util.Scanner;

public class MainProjeto2 {

    public static void main(String[] args) {
        //entrada do teclado para teste
        Scanner scan = new Scanner(System.in);
        //variáveis: 
        double valor = 0 ;
        int menu = 0;
        double resultado;
        double resultadoParcelado = 0;
        int parcelas;
        boolean valorValido = false;
        
        //loop para manter o menu sempre ativo até finalizar a compra
        do{
        System.out.println("===========CAIXA===========");

        while(!valorValido)//<-- loop para validar o valor até que seja maior que 0 e então seguir para a opção de pagamento.
        try{// tenta fazer a questão do valor!
        System.out.println("Digite o valor da compra: R$");
        valor = Double.parseDouble(scan.nextLine()); // armazena o valor da compra 
        if(valor <= 0 ){// condição onde se o usuário deigitar 0 ou menos que 0, recebe uma mensagem amigável!
            System.out.println("Valor deve ser maior que zero!");//
        }else{//altera o valor da varável para true onde ecerra o while
            valorValido = true;
        }

            }catch(NumberFormatException e){// caso o usuário digite alguma letra, recebe uma mensagem amigável!
            System.out.println("Digite apenas números !");
            continue;
        }

        //questiona quanto qual a forma de pagamento
        System.out.println("Selecione a forma pagamento:");
        System.out.println("1. Pix");
        System.out.println("2. Cartão");
        System.out.println("3. Dinheiro");
        System.out.println("===========================");
    
        //seletor de opção
        menu = scan.nextInt();

        switch (menu) {
            // forma de pagamento via PIX
            case 1:
                // cria um objeto do tipo FormaDePagamento com a classe pix 
                FormaDePagamento pagamentoPix = new Pix();
                resultado = pagamentoPix.calcularValor(valor); // armazena o resultado do calculo do método da interface
                System.out.println("Valor final: R$" + resultado);
                break;
            // forma de pagamento via cartão
            case 2:
                // cria um objeto do tipo cartão para que quando o usuario selecionar cartão ele possa acessar a opção de parcelamento
                Cartao pagamentoCartao = new Cartao();
                System.out.println("Quantas parcelas? ");
                parcelas = scan.nextInt();// armazena a quantidade de parcelas para ser comparada
                if(parcelas== 1){ // se cair dentro desse IF automaticamento entende que não vai dividir mas lança já a taxa
                    resultado = pagamentoCartao.calcularValor(valor);
                    System.out.println("Valor final: R$" + resultado);
                    System.out.println("Para concluir digite 0 ");
                }else{ // portanto caindo dentro do else, ele já lança com taxa e a quantidade de vezes que vai ser dividido 
                    resultado = pagamentoCartao.calcularValorComParcelas(valor, parcelas);
                   resultadoParcelado = resultado/ parcelas;
                   // resultado personalizado para que o usuario veja o valor e as parcelas finais. 
                   System.out.println("Valor final: R$" + resultado + " em " + parcelas + "x de R$" + resultadoParcelado);
                   System.out.println("Para concluir digite 0 ");
                }
                break;
            // forma de pagamento avista
            case 3: 
            // cria um objeto do tipo FormaDePagamento com a classe Dinheiro
                FormaDePagamento pagamentoDinheiro = new Dinheiro();
                resultado = pagamentoDinheiro.calcularValor(valor);// armazena o resultado do calculo do método da interface
                System.out.println("Valor final: R$" + resultado);
                System.out.println("Para concluir digite 0 ");
                break;
        
            default:
                break;
        }

    
    }while(menu!=0);// ao ser digitado o 0 em alguma das operações é finalizada a compra
         System.out.println("Compra finalizada");

       scan.close();

        
            
    
     
    }



}
