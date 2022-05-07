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
			return;
		}

		int middle = (start + end ) / 2;
		
		System.out.println("? "+ start + " " + middle);
		System.out.flush();
		int ans1 = sc.nextInt();
		System.out.println("? "+ (middle+1) + " " + end);
		System.out.flush();
		int ans2 = sc.nextInt();

		if(ans1 == N-1) dfs(start, middle);
		else if(ans2 == N-1) dfs(middle+1, end);
		else if(ans1 == N) dfs(start, middle);
		else if(ans2 == N) dfs(middle+1, end);

		if(start == middle && ans1 == N-1)
			System.out.println("! "+start);
		else if(middle+1 == end && ans2 == N-1)
			System.out.println("! "+end);
	}	
}
