package BernoulliPack;

public class Bernoulli {
    protected int n;// количество повторений
    protected int nSuccess;// количество нужных успехов
    protected double p;// шанс на успех
    protected int C;// количество возможных исходов события
    protected double P;// вероятность нужного события

    protected boolean[][] possibleEvents;// массив для оторажения всех возможных вариантов исходов события

    public Bernoulli(int n, int nSuccess, double probabilitySuccess) {
        if (n <= 0) {
            System.out.println("Количество повторений равно нулю, поэтому мы закрываем программу\n");
        } else {
            this.n = n;
            this.nSuccess = nSuccess;
            if (probabilitySuccess > 1) {
                probabilitySuccess /= 100;
            }
            if (probabilitySuccess <= 0) {
                probabilitySuccess = 0;
            }
            p = probabilitySuccess;
            countingEventOutcomes();
            countingProbabiNeededEvents();
            possibleEvents = new boolean[C][n];
        }
    }

    private double countingProbabiNeededEvents() {
        P = C * Math.pow(p, nSuccess) * Math.pow(1 - p, n - nSuccess);
        return P;
    }

    private int countingEventOutcomes() {// подсчет количества возможных исходов событий
        C = ((getFactorial(n)) / (getFactorial(nSuccess) * getFactorial(n - nSuccess)));
        return C;
    }

    public static int getFactorial(int f) {// факториал числа
        int result = 1;
        for (int i = 1; i <= f; i++) {
            result = result * i;
        }
        return result;
    }

    public void Statistics() {// статистика

        System.out.println("Количество повторений события: " + n);
        System.out.println("Нужное количество успехов этого события: " + nSuccess);
        System.out.println("Шанс на успех: " + (p * 100) + "%");
        System.out.println("Шанс на неудачу: " + ((1 - p) * 100) + "%");
        System.out.println("Количество возможных исходов события: " + C);
        System.out.println("Вероятность нужного события: " + P * 100 + "%");

    }

    public boolean rnd0or1() {// рандом число 0 или 1
        double result = Math.random();
        if (result < 0.5) {
            return false;
        } else {
            return true;
        }

    }

}
