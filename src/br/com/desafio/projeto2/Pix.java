package br.com.desafio.projeto2;

public class Pix implements FormaDePagamento{

    @Override
    public double calcularValor(double valor){
        return valor * 0.9;
    }
    

}
