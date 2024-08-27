package br.unigran.controledeveiculos;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class CadastroActivity extends AppCompatActivity {

    //Criando variáveis Globais
    EditText carroMarca,carroModelo,carroAno;
    Button bsalvar;
    Button bvoltar;

    @Override  //Ao Abrir o App
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        //Instancias de botões
        carroMarca =findViewById(R.id.marca);
        carroModelo = findViewById(R.id.modelo);
        carroAno = findViewById(R.id.ano);
        bvoltar = findViewById(R.id.btnVoltar);
        bsalvar = findViewById(R.id.btnSalvar);

        //ActionListeners
        bvoltar.setOnClickListener(v->{onBackPressed();});

        bsalvar.setOnClickListener(v-> {
            if (!(carroMarca.getText().toString().isEmpty()|| carroModelo.getText().toString().isEmpty()|| carroAno.getText().toString().isEmpty())){
            Veiculo veiculo = new Veiculo();

            veiculo.marca =carroMarca.getText().toString();
            veiculo.modelo = carroModelo.getText().toString();
            veiculo.ano = carroAno.getText().toString();
            Dados d = new Dados();
            d.getInstance().salvar( veiculo);
            finish();
            }
        });
    }
}