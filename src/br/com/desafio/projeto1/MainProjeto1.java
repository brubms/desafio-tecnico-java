import java.util.Scanner;
import java.util.Stack;

public class MainProjeto1 {

            public static void main(String[] args) {
            //para entrada de dados
            Scanner scan = new Scanner(System.in);
            //objeto do tipo Caixa de livros
            CaixaDeLivros caixa1 = new CaixaDeLivros();
            //atributos para o menu
            int opcao;
            String nome;
            String autor;
            double preco;
            String encerrar;
        
            //Menu de interação
            do{
                System.out.println("=======================");
                System.out.println("==========MENU=========");
                System.out.println("1. Colocar livro na caixa");
                System.out.println("2. Tirar livro da caixa");
                System.out.println("3. Ver livro do topo");
                System.out.println("0. Sair");
                System.out.println("Digite a opção desejada:");
                //entrada para o menu 
                opcao = Integer.parseInt(scan.nextLine());
                //seletor de opções
                switch (opcao) {
                /*1. colocar livro na caixa, através desta opção o usuário pode adicionar livros a caixa de livros
                toda vez que for colocar um livro na caixa será necessario antes dizer qual livro, autor e o preço
                */
                case 1:
                //loop para repetir o menu até que não seja mais necessário colocar mais livros na pilha            
                do{
                    
                    //verificação do livro
                    System.out.println("Nome do livro: ");
                    nome = scan.nextLine();
                    System.out.println("Nome do autor: ");
                    autor = scan.nextLine();
                    System.out.println("Preço do livro: ");
                    preco = Double.parseDouble(scan.nextLine());
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
                    if(caixa1.isEmpty()){
                        System.out.println("caixa vazia");
                    }else{
                        Livro removido = caixa1.desempilhar();
                        System.out.println("removido: " + removido);
                    }
                    break;
                    //3. ver o livro do topo, toda vez que acionado consigo verificar qual livro está no topo
                    case 3:
                    if(caixa1.isEmpty()){
                        System.out.println("caixa vazia");
                    }else{
                        Livro topo = caixa1.topo();
                        System.out.println("Livro: " + topo);
                    }

                    break;

                    case 0: 
                    break;
        
                    default:
                    System.out.println("Opção inválida");
                    break;

                }
                //saída do menu 
                }while(opcao!=0);
                System.out.println("Você saiu!!"); 
        

            }

            }
