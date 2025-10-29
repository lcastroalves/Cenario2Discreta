public class Main {
    public static void main(String[] args) {
        Matrizes matriz = new Matrizes();
        //matriz.propriedades();

        int[][] Ms = matriz.closureSymmetric(matriz.M_metro);
        matriz.printMatrix("MS", Ms);
        int[][] Mt = matriz.closureTransitive(matriz.M_metro);
        matriz.printMatrix("Mt", Mt);
        int[][] Mr = matriz.closureReflexive(matriz.M_metro);
        matriz.printMatrix("Mr", Mr);

    }
}