package br.com.desafio.projeto3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ReciboArquivo implements Recibo {

    public void gerarRecibo(String conteudo){
        File file = new File("recibo.txt");

        try(FileWriter fw = new FileWriter(file)){
            fw.write(conteudo);
            fw.flush();
            
        }catch(IOException e){
            e.printStackTrace();
        }


    }

}
