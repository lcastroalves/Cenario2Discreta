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

    public final int[][] M_metro = {
            {1, 1, 0, 0, 0, 0},
            {0, 1, 1, 0, 0, 0},
            {0, 1, 1, 0, 0, 0},
            {0, 1, 0, 1, 0, 1},
            {1, 1, 0, 0, 1, 0},
            {0, 0, 0, 0, 1, 1}
    };

    public final int[][] M_onibus = {
            {0, 1, 0, 0, 0, 1},
            {1, 0, 0, 1, 0, 0},
            {0, 0, 0, 1, 0, 0},
            {0, 1, 1, 0, 0, 1},
            {0, 0, 0, 0, 0, 1},
            {1, 0, 0, 1, 1, 0}
    };

    // ==================================================
    public void propriedades() {
        System.out.println("Reflexiva?      " + (isReflexive(A) ? "Sim" : "Não"));
        System.out.println("Simétrica?      " + (isSymmetric(A) ? "Sim" : "Não"));
        System.out.println("Antissimétrica? " + (isAntisymmetric(A) ? "Sim" : "Não"));
        System.out.println("Assimétrica?    " + (isAsymmetric(A) ? "Sim" : "Não"));
        System.out.println("Transitiva?     " + (isTransitive(A) ? "Sim" : "Não"));
    }

    public boolean isReflexive(int[][] M) {
        for (int i = 0; i < M.length; i++) {
            if (M[i][i] != 1) return false;
        }
        return true;
    }

    public boolean isSymmetric(int[][] M) {
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                if (M[i][j] != M[j][i]) return false;
            }
        }
        return true;
    }

    public boolean isAntisymmetric(int[][] M) {
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                if (i != j && M[i][j] == 1 && M[j][i] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isAsymmetric(int[][] M) {
        for (int i = 0; i < M.length; i++) {
            if (M[i][i] == 1) return false;
        }
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                if (M[i][j] == 1 && M[j][i] == 1) return false;
            }
        }
        return true;
    }

    public boolean isTransitive(int[][] M) {
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

    // ==================================================
    //só para ter uma cópia que possa ser alterada
    private int[][] deepCopy(int[][] original) {
        int n = original.length;
        int[][] copy = new int[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(original[i], 0, copy[i], 0, n);
        }
        return copy;
    }

    public int[][] closureReflexive(int[][] M) {
        int[][] Mr = deepCopy(M);
        for (int i = 0; i < M.length; i++) {
            Mr[i][i] = 1;
        }
        return Mr;
    }

    public int[][] closureTransitive(int[][] M) {
        int n = M.length;
        int[][] Mt = deepCopy(M);
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (Mt[i][k] == 1 && Mt[k][j] == 1) {
                        Mt[i][j] = 1;
                    }
                }
            }
        }
        return Mt;
    }

    public int[][] closureSymmetric(int[][] M) {
        int n = M.length;
        int[][] Ms = deepCopy(M);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (M[i][j] == 1) {
                    Ms[j][i] = 1;
                }
            }
        }
        return Ms;
    }

    // ==================================================
    public int[][] composicao(int[][] R1, int[][] R2) {
        int n = R1.length;
        int[][] comp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (R1[i][k] == 1 && R2[k][j] == 1) {
                        comp[i][j] = 1;
                        break;
                    }
                }
            }
        }
        return comp;
    }

    // ==================================================
    public void printMatrix(String title, int[][] M) {
        System.out.println("\n" + title + ":");
        String[] stations = {"Av", "C", "Pç", "Pq", "Sh", "T"};
        System.out.print("   ");
        for (String s : stations) {
            System.out.print(s + " ");
        }
        System.out.println();
        for (int i = 0; i < M.length; i++) {
            System.out.print(stations[i] + " |");
            for (int val : M[i]) {
                System.out.print(" " + val);
            }
            System.out.println(" |");
        }
    }
}


