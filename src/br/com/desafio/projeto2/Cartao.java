package br.com.desafio.projeto2;

public class Cartao implements FormaDePagamento {

    @Override
    public double calcularValor(double valor){
            return valor;
    }
    
    public double calcularValorComParcelas(double valor, int parcelas){
        if(parcelas == 1){
            return valor;
        }else{
            return valor *1.05;
        }
    }

}
