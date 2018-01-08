class Solution {
    public int maximalRectangle(char[][] matrix) {
        //treat each row of the 2D matrix as the bottom of histagram
        int max = 0;
        if(matrix.length==0 || matrix[0].length==0)
            return 0;
        int[] prev = new int[matrix[0].length];
        int[] next = new int[matrix[0].length];
        for(int i=0;i<matrix.length;++i){
            Deque<Integer> stack = new ArrayDeque<Integer>();
            int j=0;
            while(j<matrix[0].length){
                next[j] =(matrix[i][j]=='1' ? 1+prev[j]:0);
                if(stack.isEmpty() || next[j] > next[stack.peek()]){
                    stack.push(j);
                    ++j;
                }else{
                    int temp = stack.pop();
                    int locMax = next[temp]*(stack.isEmpty()? j:j-1-stack.peek());
                    max = Math.max(max, locMax);

                }
            }
            while(!stack.isEmpty()){
                int temp = stack.pop();
                int height = next[temp];
                height*= stack.isEmpty() ? matrix[0].length:matrix[0].length-1-stack.peek();
                max = Math.max(max,height);
            }
            prev = Arrays.copyOf(next,next.length);
        }
        return max;
    }
}