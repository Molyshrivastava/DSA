class Solution {
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0 || grid[0].length==0 )
         {
               return 0;
          }

    int ans=0;

//explore every cell of the grid
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
              //if cell is land ("1") than perform dfs
                if(grid[i][j]=='1'){
                    dfs(i,j,grid);
                    ans++; //count islands
                }
            }
        }
        return ans;
    }

    public void dfs(int i,int j,char[][] grid){
        //check if length exceeds
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length)
        return;

        //check if water or visited
        if(grid[i][j]=='0') 
        return;

        grid[i][j]='0';  //mark the cell visited

//explore all four directions
dfs(i+1,j,grid); //down
dfs(i-1,j,grid); //up
dfs(i,j+1,grid); //right
dfs(i,j-1,grid); //left

    }
}