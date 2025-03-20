/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int sz=0;
        ListNode temp=head;
        while(temp!=null)
        {
            sz++;
            temp=temp.next;
        }
        if(sz==n)
        {
            head=head.next;
            return head;
        }
        int i=1;
        int itofi=sz-n;
        ListNode prev=head;
        while(i<itofi)
        {
            prev=prev.next;
            i++;
        }
        prev.next=prev.next.next;
        return head;
    }
}