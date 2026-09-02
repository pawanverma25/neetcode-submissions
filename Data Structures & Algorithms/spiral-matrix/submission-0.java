class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        int []dir = new int[]{0, 1, 0, -1, 0};
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = 0, d = 0;
        List<Integer> res = new ArrayList<>();

        while(res.size() < n * m){
            res.add(matrix[i][j]);
            matrix[i][j] = -101;
            
            int nextI = i + dir[d], nextJ = j + dir[d + 1];
            if(nextI < 0 || nextJ < 0 || nextI >= m || nextJ >= n || matrix[nextI][nextJ] == -101){
                d = (d + 1) % 4;
                nextI = i + dir[d];
                nextJ = j + dir[d + 1];
            }
            i = nextI;
            j = nextJ;

        }

        return res;
    }
}
