package BernoulliPack;

public class TableOutcomes extends Bernoulli {

    public TableOutcomes() {// конструктор по умолчанию
        super(0, 0, 0.0);
    }

    public TableOutcomes(int n, int nSuccess, double probabilitySuccess){
        super(n,nSuccess,probabilitySuccess);
    }

    private void formingColumn(boolean[] a) {// сформировать один столбец для дальнейшей проверки, вспомогательный
                                             // метод
        boolean[] column = new boolean[n];
        int nOne = 0;
        for (int i = 0; i < column.length; i++) {
            column[i] = rnd0or1();
            if (column[i] == true) {
                nOne++;
            }
            if (i == (column.length - 1)) {
                if (nOne != nSuccess) {
                    i = -1;
                    nOne = 0;
                }
            }
        }
        for (int i = 0; i < a.length; i++) {
            a[i] = column[i];
        }
    }

    private void FillPossibleEvents() {// заполнение массива с возможными исходами
        formingColumn(possibleEvents[0]);
        for (int i = 1; i < possibleEvents.length; i++) {
            formingColumn(possibleEvents[i]);
            if (isPovtorColumn(possibleEvents, possibleEvents[i], i)) {
                i = i - 1;
            }
        }
    }

    private boolean isPovtorColumn(boolean[][] a, boolean[] b, int i_m) {// сравнение колонки с остальными
        int nPovtor = 0;
        for (int i = 0; i < i_m; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] == b[j]) {
                    nPovtor++;
                }
            }
            if (nPovtor == n) {
                return true;
            } else {
                nPovtor = 0;
            }
        }
        return false;
    }

    public void outputPossibleEvents() {
        FillPossibleEvents();
        System.out.println();
        for (int i = 0; i < possibleEvents.length; i++) {
            System.out.print("[");
            for (int j = 0; j < possibleEvents[i].length; j++) {
                if (possibleEvents[i][j] == true) {
                    System.out.print(1 + "\t");
                } else {
                    System.out.print(0 + "\t");
                }
            }
            System.out.print("]\n");
        }
    }
}
