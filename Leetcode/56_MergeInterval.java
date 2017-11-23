class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        intervals.sort((interval1,interval2) -> Integer.compare(interval1.start,interval2.start));
        Integer start = null;
        Integer end = null;
        int n = intervals.size();
        if(n>0){
            for(int i=0;i<n;i++){
                Interval curr = intervals.get(i);
                if(start==null){
                    start = curr.start;
                    end = curr.end;
                }else if(end<curr.start){
                    res.add(new Interval(start,end));
                    start = curr.start;
                    end = curr.end;
                }else{
                    end = end<=curr.end ? curr.end : end;
                }
            }
            res.add(new Interval(start,end));
        }
        return res;
    }
}