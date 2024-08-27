package br.unigran.controledeveiculos;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class CadastroActivity extends AppCompatActivity {

    //Criando variáveis Globais
    EditText texto;
    Button bsalvar;
    Button bvoltar;

    @Override  //Ao Abrir o App
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        //Instancias de botões
        texto =findViewById(R.id.nomeVeiculo);
        bvoltar = findViewById(R.id.btnVoltar);
        bsalvar = findViewById(R.id.btnSalvar);

        //ActionListeners
        bvoltar.setOnClickListener(v->{onBackPressed();});

        bsalvar.setOnClickListener(v-> {
            Veiculo veiculo = new Veiculo();
            Dados d = new Dados();
            veiculo.nome=texto.getText().toString();
            d.salvar(  veiculo);
        });
    }
}