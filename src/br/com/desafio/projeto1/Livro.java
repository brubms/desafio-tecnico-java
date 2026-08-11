package br.com.desafio.projeto1;

public class Livro {
    //Atributos da classe
    private String nome;
    private String autor;
    private double preco;
    //Construtor para inicialização de um objeto do tipo Livro.
    public Livro(String nome, String autor, double preco){
        this.nome = nome;
        this.autor = autor;
        this.preco = preco;
    }
    //setters
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setAutor(String autor){
        this.autor = autor;
    }
    public void setPreco(double preco){
        this.preco = preco;
    }
    //getters
    public String getNome(){
        return this.nome;
    }
    public String getAutor(){
        return this.autor;
    }
    public double getPreco(){
        return this.preco;
    } 
    //toString -> para vizualizar todas as informações, transformando o objeto em uma String para impressão!!
    @Override
    public String toString(){
        return "|Livro: " + nome + " |" + "Autor: " + autor + " |Preço: " + preco + " |"; 
    }

}
