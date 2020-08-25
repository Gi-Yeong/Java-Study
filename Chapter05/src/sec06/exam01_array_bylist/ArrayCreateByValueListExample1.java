package sec06.exam01_array_bylist;

public class ArrayCreateByValueListExample1 {

    public static void main(String[] args) {
        int[] scores = {83, 90, 87};

        System.out.println(scores[0]);
        System.out.println(scores[1]);
        System.out.println(scores[2]);

        int sum = 0;

        for (int i = 0; i < scores.length; i++) {
            sum += scores[i];
        }

        System.out.println("총합 : " + sum);

        double avg = (double) sum / 3;
        System.out.println("평균 : " + avg);
    }
}
