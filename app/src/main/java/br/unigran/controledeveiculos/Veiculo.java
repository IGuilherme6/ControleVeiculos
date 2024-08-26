package br.unigran.controledeveiculos;

import androidx.annotation.NonNull;

public class Veiculo {
public String nome;
public String placa;
public String modelo;

@NonNull
    @Override
    public String toString(){
    return nome;
}

}