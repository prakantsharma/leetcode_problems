class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        int first = -1;
        int last = -1;

        int minDist = Integer.MAX_VALUE;
        int maxDist = 0;

        int index = 1;

        ListNode prev = head;
        ListNode curr = head.next;

        while (curr.next != null) {

            int a = prev.val;
            int b = curr.val;
            int c = curr.next.val;

            // Check if current node is a critical point
            if ((b > a && b > c) || (b < a && b < c)) {

                // First critical point
                if (first == -1) {
                    first = index;
                } 
                else {
                    // Distance from previous critical point
                    minDist = Math.min(minDist, index - last);

                    // Distance from first critical point
                    maxDist = index - first;
                }

                last = index;
            }

            prev = curr;
            curr = curr.next;
            index++;
        }

        // Fewer than 2 critical points
        if (first == -1 || first == last) {
            return new int[]{-1, -1};
        }

        return new int[]{minDist, maxDist};
    }
}