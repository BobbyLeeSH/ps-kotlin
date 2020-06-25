package programmers;

public class IntegerTriangle {
    // https://programmers.co.kr/learn/courses/30/lessons/43105
    public int solution(int[][] triangle) {
        if (triangle.length == 1) return triangle[0][0];
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                int first = Math.max(0, j - 1);
                int second = Math.min(triangle[i-1].length - 1, j);
                triangle[i][j] = Math.max(triangle[i-1][first], triangle[i-1][second]) + triangle[i][j];
                System.out.print(triangle[i][j] + " ");
            }
            System.out.print(" ");
        }
        int answer = 0;
        for (int i = 0; i < triangle[triangle.length - 1].length; i++) {
            answer = Math.max(answer, triangle[triangle.length - 1][i]);
        }

        return answer;
    }
}

/**
 * 7
 * 3 8
 * 8 1 0
 * 2 7 4 4
 * 4 5 2 6 5
 *
 * 7
 * 10 15
 * 18 16 15
 */
