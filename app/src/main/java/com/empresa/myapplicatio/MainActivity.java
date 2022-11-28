package com.empresa.myapplicatio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void selecionarPedra(View view){
        this.opcaoSelecionada("pedra");
    }
    public void selecionarPapael(View view){
        this.opcaoSelecionada("papel");
    }
    public void selecionartesoura(View view){
        this.opcaoSelecionada("tesoura");
    }
    public void opcaoSelecionada(String escolhaUsuario){

        ImageView imageResultado = findViewById(R.id.imageResultado);
        TextView textResultado = findViewById(R.id.textResultado);

        int numero = new Random().nextInt(3);
        String[] opcoes ={"pedra","papel","tesoura"};
        String escolhaApp =  opcoes[numero];

        switch (escolhaApp){
            case "pedra": imageResultado.setImageResource(R.drawable.pedra);
                break;
            case "papel":imageResultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura":imageResultado.setImageResource(R.drawable.tesoura);
                break;
        }
        boolean validacaoappVitoria = (escolhaApp == "tesoura" && escolhaUsuario == "papel") || (escolhaApp == "papel" && escolhaUsuario == "pedra")
                || (escolhaApp == "pedra" && escolhaUsuario == "tesoura");

        boolean ValidacaousuarioaVitoria = (escolhaUsuario == "tesoura" && escolhaApp == "papel") || (escolhaUsuario == "papel" && escolhaApp == "pedra")
                || (escolhaUsuario == "pedra" && escolhaApp == "tesoura");



        if(validacaoappVitoria){
            textResultado.setText("App ganhador");
        }else if (ValidacaousuarioaVitoria){
            textResultado.setText("usuario ganhador ");
        }else{
            textResultado.setText("Empate");
        }
    }

}