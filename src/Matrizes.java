public class Matrizes {
    //Matriz adjacente

    private int[][] A = {
            {0, 1, 0, 0, 0, 0},
            {1, 0, 1, 0, 0, 0},
            {0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 1},
            {0, 1, 0, 1, 1, 0}
    };

    public void propriedades(){
        System.out.println("Reflexiva?      " + (isReflexive(A)      ? "Sim" : "Não"));
        System.out.println("Simétrica?      " + (isSymmetric(A)      ? "Sim" : "Não"));
        System.out.println("Antissimétrica? " + (isAntisymmetric(A)  ? "Sim" : "Não"));
        System.out.println("Assimétrica?    " + (isAsymmetric(A)     ? "Sim" : "Não"));
        System.out.println("Transitiva?     " + (isTransitive(A)     ? "Sim" : "Não"));
    }

    public boolean isReflexive(int[][] M){
        for (int i = 0; i < M.length; i++) {
            if (M[i][i] != 1) return false;
        }
        return true;
    }

    public boolean isSymmetric(int[][] M){
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++){
                if (M[i][j] != M[j][i]) return false;
            }
        }
        return true;
    }

    public boolean isAntisymmetric(int[][] M){
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                if (i != j && M[i][j] == 1 && M[j][i] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isAsymmetric(int[][] M){
        for (int i = 0; i < M.length; i++){
            if (M[i][i] == 1) return false;
        }

        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                if (M[i][j] == 1 && M[j][i] == 1) return false;
            }
        }

        return true;
    }

    public  boolean isTransitive(int[][] M){
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                if (M[i][j] == 1) {
                    for (int k = 0; k < M.length; k++) {
                        if (M[j][k] == 1 && M[i][k] == 0) return false;
                    }
                }
            }
        }
        return true;
    }
}
