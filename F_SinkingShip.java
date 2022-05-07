import java.util.Scanner;

public class F_SinkingShip {

	static int N;
	static Scanner sc;
	
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		N = sc.nextInt();
		dfs(1, N);
	}
	
	private static void dfs(int start, int end) {
		if(start == end) {
			System.out.println("! "+start);
			return;
		}
		int middle = (start + end ) / 2;
		System.out.println("? "+ start + " " + middle);
		System.out.flush();
		int ans = sc.nextInt();
		if(ans == N-1) {
			dfs(start, middle);
		} else {
			dfs(middle+1, end);
		}
	}	
}
