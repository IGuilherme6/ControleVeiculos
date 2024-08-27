package br.unigran.controledeveiculos;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    //Variáveis globais
    Button bNovo;
    Button bRemover;
    Button bSair;
    ListView lista;

    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Criando Instancias dos IDs
        bNovo = findViewById(R.id.btnNovo);
        bRemover=findViewById(R.id.btnRemover);
        bSair=findViewById(R.id.btnSair);
        lista = findViewById(R.id.lista);

        adapter =
                new ArrayAdapter(MainActivity.this, R.layout.linha ,Dados.getInstance().lista);
        lista.setAdapter(adapter);


        //ActionListeners de botões
        bNovo.setOnClickListener(v->{
            startActivity(new Intent(MainActivity.this,CadastroActivity.class));
        });
        bSair.setOnClickListener(v->{
            finish();
        });
    }

    //Processos de mudar de página, ele congela, e quando volta ele atualiza,p recisa fazer várias vezes, por isso fica fora do OnCreate
    @Override
    protected  void onResume(){
        super.onResume();
        adapter.notifyDataSetChanged();
    }
    @Override
    protected void onStart(){
        super.onStart();
        adapter.notifyDataSetChanged();
    }
}