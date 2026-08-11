package br.com.desafio.projeto3;

import java.io.FileWriter;
import java.util.EmptyStackException;
import java.util.Scanner;
import br.com.desafio.projeto1.Livro;
import br.com.desafio.projeto1.CaixaDeLivros;
import br.com.desafio.projeto2.FormaDePagamento;
import br.com.desafio.projeto2.Pix;
import br.com.desafio.projeto2.Cartao;
import br.com.desafio.projeto2.Dinheiro;
import java.io.FileWriter;
import java.io.IOException;



public class MainProjeto3 {

    public static void main(String[] args) {

    Scanner scan = new Scanner(System.in); //<----- para entrada de dados
    CaixaDeLivros caixa1 = new CaixaDeLivros(); //<---- objeto do tipo Caixa de livros
    Recibo recibo = new ReciboArquivo();
    
    

    //variáveis do menu: 
    int opcao = 0; 
    String nome;
    String autor;
    double preco;
    String encerrar = "";
    double valor = 0 ;
    int menu = 0;
    double resultado = 0;
    double resultadoParcelado = 0;
    int parcelas = 0;
    boolean valorValido = false;
    String livrosTexto = "";
    String formaPagamento = "";
    int qtdParcelas = 0;
    double valorParcela = 0;
    
    
        
    //--------------------------------Menu de interação-----------------------------------------
    do{
        System.out.println("=======================");
        System.out.println("==========MENU=========");
        System.out.println("1. Colocar livro na caixa");
        System.out.println("2. Tirar livro da caixa");
        System.out.println("3. fechar compra");
        System.out.println("0. Sair");
        System.out.println("Digite a opção desejada:");
        try{//<--- tenta acessar a opção do menu através das opções desejadas
            opcao = Integer.parseInt(scan.nextLine()); //<--- entrada para o menu 
        }catch(NumberFormatException e){
            System.out.println("Opção inválida. Digite um número.");
            continue;
        }
        
    //-------------------------------------------------------------------------------------------
        //seletor de opções
        switch (opcao) {
        
        /*1. colocar livro na caixa, através desta opção o usuário pode adicionar livros a caixa de livros
        toda vez que for colocar um livro na caixa será necessario antes dizer qual livro, autor e o preço
        */
        case 1:
            
        do{ //loop para repetir o menu até que não seja mais necessário colocar mais livros na pilha        
                    
            //verificação do livro
            System.out.println("Nome do livro: ");
            nome = scan.nextLine();
            System.out.println("Nome do autor: ");
            autor = scan.nextLine();
            try{ //<--- tenta realizar o cadastro do preço do livro
            System.out.println("Preço do livro: ");
            preco = Double.parseDouble(scan.nextLine());

            }catch(NumberFormatException e){//<-- caso o usuário digite algo que não aceita a variável ele manda uma mensagem amigável.
                System.out.println("Aceita apenas números!");
                continue;
            }
            
            //Criação do livro 
            Livro livro = new Livro(nome, autor, preco);
            //método para empilhar o novo livro
            caixa1.empilhar(livro);
                
            //verificação para se continua ou não o método
            System.out.println("deseja continuar?");
            encerrar = scan.nextLine();

        }while(!encerrar.equalsIgnoreCase("N"));
            System.out.println("Encerrando..");
            break;
    //-----------------------------------------------------------------------------------------------------
        //2. Tirar livro da caixa, toda vez que for acionada essa opção é removido o livro da caixa
        case 2:
            try{ //<--- tente 
                Livro removido = caixa1.desempilhar();
            System.out.println("removido: " + removido);

            }catch(EmptyStackException e){//<-- se não mostre a mensagem amigável!
                System.out.println("Caixa vazia!! ");
            }
            break;

    //----------------------------------------------------------------------------------------------------
    //3. Fechamento da compra
        case 3:

        
        System.out.println("===========CAIXA===========");
            double total = 0;
        for (Livro livro : caixa1.getPilha()) {
           total = total + livro.getPreco();
            
        }

        while(!valorValido)//<-- loop para validar o valor até que seja maior que 0 e então seguir para a opção de pagamento.
        try{// tenta fazer a questão do valor!
        System.out.println("valor da compra: R$" + total);
        valor = total; // armazena o valor da compra 
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
        menu = Integer.parseInt(scan.nextLine());

        switch (menu) {
            // forma de pagamento via PIX
            case 1:
                // cria um objeto do tipo FormaDePagamento com a classe pix 
                FormaDePagamento pagamentoPix = new Pix();
                resultado = pagamentoPix.calcularValor(valor); // armazena o resultado do calculo do método da interface
                System.out.println("Valor final: R$" + resultado);  
                formaPagamento = "PIX";
                
                
                break;
            // forma de pagamento via cartão
            case 2:
                // cria um objeto do tipo cartão para que quando o usuario selecionar cartão ele possa acessar a opção de parcelamento
              

                Cartao pagamentoCartao = new Cartao();
                System.out.println("Quantas parcelas? ");
                parcelas = Integer.parseInt(scan.nextLine());// armazena a quantidade de parcelas para ser comparada
                if(parcelas== 1){ // se cair dentro desse IF automaticamento entende que não vai dividir mas lança já a taxa
                    resultado = pagamentoCartao.calcularValor(valor);
                    System.out.println("Valor final: R$" + resultado);
            
                }else{ // portanto caindo dentro do else, ele já lança com taxa e a quantidade de vezes que vai ser dividido 
                    resultado = pagamentoCartao.calcularValorComParcelas(valor, parcelas);
                   resultadoParcelado = resultado/ parcelas;
                   // resultado personalizado para que o usuario veja o valor e as parcelas finais. 
                   System.out.println("Valor final: R$" + resultado + " em " + parcelas + "x de R$" + resultadoParcelado);
                   
                }
                formaPagamento = "Cartão";
              qtdParcelas = parcelas;
              valorParcela = resultadoParcelado;
                scan.nextLine();
                break;
            // forma de pagamento avista
            case 3: 
            // cria um objeto do tipo FormaDePagamento com a classe Dinheiro
                FormaDePagamento pagamentoDinheiro = new Dinheiro();
                resultado = pagamentoDinheiro.calcularValor(valor);// armazena o resultado do calculo do método da interface
                System.out.println("Valor final: R$" + resultado);
                scan.nextLine();
                formaPagamento = "Avista";
                break;

            
            
            

            default:
                break;
        

        }

        
        

        System.out.println("Confirmar compra? (S/N)");
        String confirmar = scan.nextLine();
                if(confirmar.equalsIgnoreCase("S")){
                
                   
                    for (Livro livro : caixa1.getPilha()) {
            livrosTexto = livrosTexto + livro.getNome() + " - R$" + livro.getPreco() + "\n ";
            
        }
        String conteudo = "===RECIBO===\n" + livrosTexto + 
        "Forma de pagamento: " + formaPagamento + "\n";

        if (qtdParcelas > 1) {
        conteudo += "Parcelado em " + qtdParcelas + "x de R$" + valorParcela + "\n";
}

        conteudo += "Total: R$" + resultado;

        recibo.gerarRecibo(conteudo);
        
        System.out.println("Gerando recibo....\nGerado recibo com sucesso !!");
                    
                }else{
                    System.out.println("Compra cancelada!!");
                }

        

        break;

        
    //------------------------------------------------------------------------------------------------------
        //0. opção de saída do sistema
        case 0: //<--- saída do menu
            break;
        
        default:
            
            System.out.println("Opção inválida");
            break;

    }


        
    }while(opcao!=0);
        System.out.println("Você saiu!!"); 
        
    scan.close();


    }

}





