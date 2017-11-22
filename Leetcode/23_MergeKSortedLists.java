/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/*Solution one: recursive O(kn) where k is the number of list
* ---Not fast enough Time Limit Exceeded---
*/
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = new ListNode(0);
        helper(lists, res);
        return res.next;
    }
    public void helper(ListNode[] lists, ListNode res){
        Integer lowest=null;
        int origin=0;
        for(int i=0;i<lists.length;i++){
            if(lists[i]!=null && (lowest==null || lists[i].val<lowest)){
                lowest=lists[i].val;
                origin=i;
            }
        }
        if(lowest!=null){
            res.next = lists[origin];
            lists[origin] = lists[origin].next;
            helper(lists,res.next);
        }
    }
}

/*Solution two: use Priority Queue
 *
/*
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode res = new ListNode(0);
        ListNode trav = res;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(1,new Comparator<ListNode>(){
            @Override
            public int compare(ListNode node1, ListNode node2){
                return node1.val-node2.val;
            }
        });
        for(ListNode list:lists){
            if(list!=null)
                queue.add(list);
        }
        while(!queue.isEmpty()){
            ListNode toAdd = queue.poll();
            if(toAdd.next!=null){
                queue.add(toAdd.next);
            }
            trav.next = toAdd;
            trav = toAdd;
        }
        return res.next;
    }
}
