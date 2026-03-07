/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode list1, ListNode list2) {
        if(list1==null || list2==null){
            return null;
        }
        ListNode p1=list1;
        ListNode p2=list2;
        while(p1!=p2){
            p1=p1==null?list2:p1.next;
            p2=p2==null?list1:p2.next;
        }
        return p1;
        
    }
}