import java.util.PriorityQueue;

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
    public ListNode mergeKLists(ListNode[] lists) {
        // Handle edge cases where input is empty or null
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        // Initialize a Min-Heap. We compare nodes by their integer values.
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        
        // Push the head node of each non-empty linked list into the min-heap
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.add(node);
            }
        }
        
        // Create a dummy node to act as the anchor for our new merged list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        // Process nodes until the heap is completely empty
        while (!minHeap.isEmpty()) {
            // Extract the node with the absolute smallest value
            ListNode smallestNode = minHeap.poll();
            
            // Append it to our merged tracking list
            current.next = smallestNode;
            current = current.next;
            
            // If the extracted node has a next pointer, push the next node into the heap
            if (smallestNode.next != null) {
                minHeap.add(smallestNode.next);
            }
        }
        
        // Return the actual head of the newly sorted and merged list
        return dummy.next;
    }
}
