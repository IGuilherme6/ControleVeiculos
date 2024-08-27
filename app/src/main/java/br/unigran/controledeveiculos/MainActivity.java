package br.unigran.controledeveiculos;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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
    Veiculo veiculoSelecionado;

    ArrayAdapter<Veiculo> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Criando Instancias dos IDs
        bNovo = findViewById(R.id.btnNovo);
        bRemover=findViewById(R.id.btnRemover);
        bSair=findViewById(R.id.btnSair);
        lista = findViewById(R.id.lista);

        adapter = new ArrayAdapter<Veiculo>(this, R.layout.linha, Dados.getInstance().lista) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if (convertView == null) {
                    convertView = LayoutInflater.from(getContext()).inflate(R.layout.linha, parent, false);
                }

                Veiculo veiculo = getItem(position);

                TextView textView = convertView.findViewById(R.id.textView);
                textView.setText(veiculo.toString());

                return convertView;
            }
        };
        lista.setAdapter(adapter);


        //ActionListeners de botões
        bNovo.setOnClickListener(v->{
            startActivity(new Intent(MainActivity.this,CadastroActivity.class));
        });
        bSair.setOnClickListener(v->{
            finish();
        });
        //torna a listview selecionavel
        lista.setOnItemClickListener((parent, view, position, id) -> {
            veiculoSelecionado = (Veiculo) parent.getItemAtPosition(position);
        });

        bRemover.setOnClickListener(v->{
            if (veiculoSelecionado != null) {
                Dados.getInstance().lista.remove(veiculoSelecionado);
                adapter.notifyDataSetChanged();
                veiculoSelecionado = null;
            }
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