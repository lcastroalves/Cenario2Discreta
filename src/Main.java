public class Main {
    public static void main(String[] args) {
        Matrizes matriz = new Matrizes();
//        matriz.propriedades();

        int[][] Ms = matriz.closureSymmetric(matriz.M_metro);
        matriz .printMatrix("MS", Ms);

        int[][] Mt = matriz.closureTransitive(matriz.M_metro);
        matriz.printMatrix("MT", Mt);

        int[][] Mr = matriz.closureReflexive(matriz.M_metro);
        matriz.printMatrix("MR", Mr);
    }
}