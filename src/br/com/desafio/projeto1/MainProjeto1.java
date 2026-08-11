package br.com.desafio.projeto1;

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class MainProjeto1 {

public static void main(String[] args) {
    
    Scanner scan = new Scanner(System.in); //<----- para entrada de dados
    
    CaixaDeLivros caixa1 = new CaixaDeLivros(); //<---- objeto do tipo Caixa de livros

    //variáveis do menu: 
    int opcao = 0; 
    String nome;
    String autor;
    double preco;
    String encerrar = "";

        
    //--------------------------------Menu de interação-----------------------------------------
    do{
        System.out.println("=======================");
        System.out.println("==========MENU=========");
        System.out.println("1. Colocar livro na caixa");
        System.out.println("2. Tirar livro da caixa");
        System.out.println("3. Ver livro do topo");
        System.out.println("0. Sair");
        System.out.println("Digite a opção desejada:");
        try{//<--- tenta acessar a opção do menu através das opções desejadas
            opcao = Integer.parseInt(scan.nextLine()); //<--- entrada para o menu 
        }catch(NumberFormatException e){
            System.out.println("Opção inválida. Digite um número.");
            continue;
        }
        

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


        //2. Tirar livro da caixa, toda vez que for acionada essa opção é removido o livro da caixa
        case 2:
            try{ //<--- tente 
                Livro removido = caixa1.desempilhar();
            System.out.println("removido: " + removido);

            }catch(EmptyStackException e){//<-- se não mostre a mensagem amigável!
                System.out.println("Caixa vazia!! ");
            }
            break;
                    
        //3. ver o livro do topo, toda vez que acionado consigo verificar qual livro está no topo
        case 3:
                    
            try{ //<--- tente 
            Livro topo = caixa1.topo();
            System.out.println("Livro: " + topo);
            }catch (EmptyStackException e){ //<--- se não emite a mensagem amigável ao usuário!
            System.out.println("Caixa vazia!! ");
            }           
            
            break;

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
