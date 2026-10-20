class Solution {
    public int longestIncreasingPath(int[][] mat) {
        int ans = 0, n = mat.length, m = mat[0].length;
        int [][]inDegree = new int[n][m];
        int[] dir = new int[]{0, 1, 0, -1, 0};
        
        Queue<int []> q = new LinkedList<>();

        for(int  i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                for(int d = 0; d < 4; d++){
                    int nextI = i + dir[d], nextJ = j + dir[d + 1];
                    if(Math.min(nextI, nextJ)<0 || nextI>=n || nextJ>=m || mat[nextI][nextJ] >= mat[i][j])
                        continue;
                    else {
                        inDegree[i][j]++;
                    }
                }
                if(inDegree[i][j] == 0) q.offer(new int[]{i, j});
            }
        }

        while(!q.isEmpty()){
            int curLength = q.size();
            while(curLength > 0){
                curLength--;
                int []cur = q.poll();
                int i = cur[0], j = cur[1];
                for(int d = 0; d < 4; d++){
                    int nextI = i + dir[d], nextJ = j + dir[d + 1];
                    if(Math.min(nextI, nextJ)<0 || nextI>=n || nextJ>=m || mat[nextI][nextJ]<=mat[i][j])
                        continue;
                    else {
                        if(--inDegree[nextI][nextJ] == 0){
                            q.offer(new int[]{nextI, nextJ});
                        }
                    }
                }
            }
            ans++;
        }
        return ans;
    }
}
