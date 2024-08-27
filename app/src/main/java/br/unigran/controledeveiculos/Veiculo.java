package br.unigran.controledeveiculos;

import androidx.annotation.NonNull;

import java.util.List;

public class Veiculo {
    public String marca;
    public String ano;
    public String modelo;

    @NonNull
    @Override
    public String toString(){
        return marca+" "+modelo+" "+ano;
    }

}