package com.example.projetopedrapapaeloutesoura;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void selecionadoPedra(View view) {
        this.opcaoSelecionada("pedra");
    }

    public void selecionadoPapel(View view) {
        this.opcaoSelecionada("papel");
    }

    public void selecionadoTesoura(View view) {
        this.opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada(String escolhaUsuario) {
        ImageView imagemResultado = findViewById(R.id.imgResultado);
        TextView textoResultado = findViewById(R.id.textResultado);

        int numero = new Random().nextInt(3);
        String[] opcoes = {"pedra", "papel", "tesoura"};
        String maquina = opcoes[numero];

        switch (maquina) {
            case "pedra":
                imagemResultado.setImageResource(R.drawable.pedra);
                break;

            case "papel":
                imagemResultado.setImageResource(R.drawable.papel);
                break;

            case "tesoura":
                imagemResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        if(
                (maquina == "tesoura" && escolhaUsuario == "papel") ||
                (maquina == "papel" && escolhaUsuario == "pedra") ||
                (maquina == "pedra" && escolhaUsuario == "tesoura")
        ){
            textoResultado.setText("Você perdeu!");
        } else if (
                (escolhaUsuario == "tesoura" && maquina == "papel") ||
                (escolhaUsuario == "papel" && maquina == "pedra") ||
                (escolhaUsuario == "pedra" && maquina == "tesoura")
        ){
            textoResultado.setText("Voce ganhou!");
        }else{
            textoResultado.setText("Empate!");
        }

    }
}