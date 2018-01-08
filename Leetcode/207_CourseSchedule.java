//BFS
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
            int[] dependencies = new int[numCourses];
            ArrayList<Integer>[] graph = new ArrayList[numCourses];
            ArrayDeque<Integer> queue = new ArrayDeque<>();
            for(int[] i: prerequisites){
                ++dependencies[i[0]];
                if(graph[i[1]]==null){
                    graph[i[1]] = new ArrayList<Integer>();
                }
                graph[i[1]].add(i[0]);
            }
            for(int i=0;i<numCourses;++i){
                if(dependencies[i]==0){
                    queue.add(i);
                }
            }
            while(!queue.isEmpty()){
                int temp = queue.pop();
                if(graph[temp]==null)
                    continue;
                for (Integer i: graph[temp]) {
                    if(--dependencies[i] == 0){
                        queue.add(i);
                    }
                }
            }
            for (int i:dependencies) {
                if(i!=0)
                    return false;
            }
            return true;
        }
}
//DFS
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        List<Integer> white = new ArrayList<>();
        List<Integer> grey = new ArrayList<>();
        List<Integer> black = new ArrayList<>();
        for(int i=0;i<numCourses;++i){
            white.add(i);
            graph[i] = new ArrayList<Integer>();
        }
        for(int[] e:prerequisites){
            graph[e[1]].add(e[0]);
        }
        Iterator iter = white.iterator();
        while(iter.hasNext()){
            Integer temp = (Integer) iter.next();
            if(black.contains(temp))
                continue;
            if(!dfs(temp,white,black,grey,graph))
                return false;
        }
        return true;
    }
    public boolean dfs (int i, List<Integer> white, List<Integer> black, List<Integer> grey, List<Integer>[] graph){
        if(grey.contains(i)){
            return false;
        }
        if(black.contains(i)){
            return true;
        }else{
            grey.add(i);
            for(int outdegree: graph[i]){
                if(!dfs(outdegree,white,black,grey,graph)){
                    return false;
                }
            }
        }
        black.add(i);
        grey.remove(Integer.valueOf(i));
        return true;
    }
}
