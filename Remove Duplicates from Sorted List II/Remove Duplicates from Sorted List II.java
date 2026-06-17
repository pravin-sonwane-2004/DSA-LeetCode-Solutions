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
 //i wrote this solution which takes the unique values  but this solution
//  will not work here because this problem wants unique nodes which as came in 
// it so only take the unique nodes 
// so basically this solution wont work here

// class Solution {
//     public ListNode deleteDuplicates(ListNode head) {
//         Set<Integer> set = new LinkedHashSet<>();
//         ListNode curr = head;
//         while(curr != null) {
//             set.add(curr.val);
//             curr = curr.next;
//         }
//         // ListNode ln = new ListNode(head);
//         ListNode dummy = new ListNode(-1);
//         curr = dummy;

//         for(int i : set) {
//             curr.next = new ListNode(i);
//             curr = curr.next;
//         }
//         return dummy.next;
//     }
// }


class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while(curr != null && curr.next != null) {
            if(curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }
}