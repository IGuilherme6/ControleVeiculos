package br.unigran.controledeveiculos;

import java.util.LinkedList;
import java.util.List;

public class Dados {

        public List<Veiculo> lista;
        private static Dados dados;

        Dados() {
                lista = new LinkedList<>();
        }

        // Método para obter a instância única da classe Dados
        public static Dados getInstance() {
                if (dados == null) {
                        dados = new Dados();
                }
                return dados;
        }

        // Método para salvar um veículo
        public void salvar(Veiculo veiculo) {
                lista.add(veiculo);
        }
}
