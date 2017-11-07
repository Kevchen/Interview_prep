class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> killList = new ArrayList<Integer>();
        killChildren(killList,pid,ppid,kill);
        return killList;
    }
    public void killChildren(List<Integer> killList, List<Integer> pid, List<Integer> ppid, int kill) {
        if(!killList.contains(kill)){
            killList.add(kill);
        }
        for(int i=0;i<ppid.size();i++){
            int num = ppid.get(i);
            if(num==kill){
                killChildren(killList,pid,ppid,pid.get(i));
            }
        }
    }
}