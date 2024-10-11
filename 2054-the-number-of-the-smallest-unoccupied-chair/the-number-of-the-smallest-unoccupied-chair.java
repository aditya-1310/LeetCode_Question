import java.util.*;

class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;
        
        // Add index to times array to track which friend it belongs to
        int[][] friends = new int[n][3];
        for (int i = 0; i < n; i++) {
            friends[i][0] = times[i][0]; // arrival time
            friends[i][1] = times[i][1]; // leaving time
            friends[i][2] = i;           // friend index
        }
        
        // Sort friends by arrival time
        Arrays.sort(friends, (a, b) -> a[0] - b[0]);
        
        // Min-heap to track the smallest available chair
        PriorityQueue<Integer> availableChairs = new PriorityQueue<>();
        // Initially, we add as many chairs as we have friends
        for (int i = 0; i < n; i++) {
            availableChairs.offer(i);
        }

        // Min-heap to track when a friend leaves {leaving time, chair number}
        PriorityQueue<int[]> leavingQueue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        // Process each friend in order of arrival
        for (int i = 0; i < n; i++) {
            int arrival = friends[i][0];
            int leaving = friends[i][1];
            int friendIndex = friends[i][2];
            
            // Free chairs that are now available (based on the leaving time)
            while (!leavingQueue.isEmpty() && leavingQueue.peek()[0] <= arrival) {
                availableChairs.offer(leavingQueue.poll()[1]);
            }

            // Assign the smallest available chair
            int assignedChair = availableChairs.poll();

            // If this is the target friend, return the assigned chair
            if (friendIndex == targetFriend) {
                return assignedChair;
            }

            // Add this friend's leaving time and their assigned chair to the leaving queue
            leavingQueue.offer(new int[]{leaving, assignedChair});
        }

        // Return -1 if the target friend is not found (edge case, though problem guarantees they will be)
        return -1;
    }
}
