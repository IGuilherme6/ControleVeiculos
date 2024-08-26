package br.unigran.controledeveiculos;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CadastroActivity extends AppCompatActivity {

    //Criando variáveis Globais
    EditText texto;
    Button bsalvar;
    Button bvoltar;

    @Override  //Ao Abrir o App
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Instancias de botões
        texto=findViewById(R.id.editTextText);
        bvoltar = findViewById(R.id.btnVoltar);
        bsalvar = findViewById(R.id.btnSalvar);

        //ActionListeners
        bvoltar.setOnClickListener(v->{onBackPressed();});

        bsalvar.setOnClickListener(v-> {
            Veiculo veiculo = new Veiculo();
            veiculo.nome=texto.getText().toString();
            Dados.lista.add(veiculo);
        });
    }
}