package sec13.exam02_random;

import java.util.Arrays;
import java.util.Random;

public class RandomExample {

    public static void main(String[] args) {
        // 선택번호
        int[] selectNum = new int[6];
        Random random = new Random(3); // seed 값이 같으면 나오는 랜덤 값도 같다
        System.out.print("선택 번호: ");
        for (int i = 0; i < 6; i++) {
            selectNum[i] = random.nextInt(45) + 1;
            System.out.print(selectNum[i] + " ");
        }
        System.out.println();

        // 당첨 번호
        int[] winningNum = new int[6];
        random = new Random(3);
        System.out.print("당첨 번호: ");
        for (int i = 0; i < 6; i++) {
            winningNum[i] = random.nextInt(45) + 1;
            System.out.print(winningNum[i] + " ");
        }
        System.out.println();

        // 당첨 여부
        Arrays.sort(selectNum);
        Arrays.sort(winningNum);
        boolean result = Arrays.equals(selectNum, winningNum);
        System.out.println(result);
    }
}
