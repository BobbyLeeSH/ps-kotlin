package programmers;

public class TileCircumference {
    // https://programmers.co.kr/learn/courses/30/lessons/43104?language=java

    public long solution(int N) {
        long DP[] = new long[N];
        DP[0] = 1;
        DP[1] = 1;
        for (int i=2; i<N; i++) {
            DP[i] = DP[i-1] + DP[i-2];
        }
        long answer = 2 * DP[N-2] + 4 * DP[N-1];

        return answer;
    }
}

/**
 * a[i+1] = a[i] + a[i-1]
 * t[i] = ( a[i] + a[i+1] ) * 2
 * 0 1
 * 1 1
 * 2 2
 * 3 3
 * 4 5
 * 5 8
 * 6 13
 * 7 21
 * */
