class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans =new ArrayList<>();
        if(heights==null || heights.length==0){
            return ans;
        }
        int rows=heights.length;
        int cols=heights[0].length;
        boolean[][] pacific=new boolean[rows][cols];
        boolean[][] atlantic=new boolean[rows][cols];

        for(int i=0;i<rows;i++){
            mark(i,0,pacific,-1,heights);
            mark(i,cols-1,atlantic,-1,heights);
        }

        for(int j=0;j<cols;j++){
             mark(0,j,pacific,-1,heights);
            mark(rows-1,j,atlantic,-1,heights);
        }

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    ans.add(Arrays.asList(i,j));
                }
            }
        }
        return ans;
    }
        public void mark(int row,int col,boolean[][] visited,int prevHeight,int[][] heights){
       // Out of bounds
        if (row < 0 || col < 0 ||
            row >= heights.length || col >= heights[0].length)
            return;

        // Already visited
        if (visited[row][col])
            return;

        // Cannot move to a lower height
        if (heights[row][col] < prevHeight)
            return;

        // Mark current cell
        visited[row][col] = true;

visited[row][col]=true;

  // Explore all 4 directions
        mark(row + 1, col, visited, heights[row][col], heights);  //down
        mark(row - 1, col, visited, heights[row][col], heights);  //up
        mark(row, col + 1, visited, heights[row][col], heights);  //right
        mark(row, col - 1, visited, heights[row][col], heights);  //left
        }
    
}