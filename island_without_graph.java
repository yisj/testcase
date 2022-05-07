import java.io.*;
import java.util.StringTokenizer;

public class island_without_graph {
    static int w, h;
    static int[][] map;
    static boolean[][] visited;
    static int[] dc = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dr = {-1, 0, 1, 1, 1, 0, -1, -1};

    public static void main(String[] args) throws IOException {
        System.setIn(new java.io.FileInputStream("sample_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            map = new int[h][w];
            visited = new boolean[h][w];
            int cnt = 0;

            if (w == 0 && h == 0) {
                break;
            }
            for (int r = 0; r < h; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < w; c++) {
                    map[r][c] = Integer.parseInt(st.nextToken());
                    if(map[r][c] == 1) {
                    	int localCnt = 0;
                    	boolean allZero = true;
                    	for(int d=0; d< 8; d++) {
                    		int nr = r + dr[d];
                    		int nc = c + dc[d];
                    		if(nr>=0 && nr < h && nc >= 0 && nc < w) {
                    			if (map[nr][nc] == 1) allZero = false;
                    		}
                    	}
                    	if(allZero) cnt++;
                    	
                    	if(r-1 >= 0 && c-1 >= 0 && c+1 < w) {
                    		if(map[r-1][c-1] == 1 && map[r-1][c] == 0 && map[r-1][c+1] == 1) cnt--;
                            else if(map[r][c-1] == 1 && map[r-1][c] == 0 && map[r-1][c+1] == 1) cnt--;
                    	}
                    }
                }
            }
            bw.write(cnt + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}