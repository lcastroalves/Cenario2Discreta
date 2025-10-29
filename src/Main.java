public class Main {
    public static void main(String[] args) {
        Matrizes matriz = new Matrizes();

        // Propriedades
        matriz.propriedades();

        // Fechamentos
        matriz.printMatrix("Fechamento Simétrico", matriz.closureSymmetric(matriz.M_metro));
        matriz.printMatrix("Fechamento Transitivo", matriz.closureTransitive(matriz.M_metro));
        matriz.printMatrix("Fechamento Reflexivo", matriz.closureReflexive(matriz.M_metro));

        // Composições
        int[][] comp = matriz.composicao(matriz.M_metro, matriz.M_onibus);


        matriz.printMatrix("Composição M_metro ∘ M_onibus", comp);

    }
}
