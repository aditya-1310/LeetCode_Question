class Solution {
    public int[] smallestRange(List<List<Integer>> lists) {
         PriorityQueue<Element> minHeap = new PriorityQueue<>((a, b) -> a.value - b.value);

        int max = Integer.MIN_VALUE;
        int minRangeStart = 0, minRangeEnd = Integer.MAX_VALUE;

        // Initialize the heap with the first element from each list.
        for (int i = 0; i < lists.size(); i++) {
            int value = lists.get(i).get(0);
            minHeap.add(new Element(value, i, 0));
            max = Math.max(max, value);
        }

        // Process the heap to find the minimum range.
        while (minHeap.size() == lists.size()) {
            Element currentMin = minHeap.poll();
            int min = currentMin.value;

            // Update the range if it is smaller than the previous range.
            if (max - min < minRangeEnd - minRangeStart) {
                minRangeStart = min;
                minRangeEnd = max;
            }

            // Move to the next element in the current list.
            if (currentMin.index + 1 < lists.get(currentMin.listIndex).size()) {
                int nextValue = lists.get(currentMin.listIndex).get(currentMin.index + 1);
                minHeap.add(new Element(nextValue, currentMin.listIndex, currentMin.index + 1));
                max = Math.max(max, nextValue);
            }
        }

        return new int[]{minRangeStart, minRangeEnd};
    }
}

// Helper class to store the value, its list index, and the index within the list.
class Element {
    int value;
    int listIndex;
    int index;

    Element(int value, int listIndex, int index) {
        this.value = value;
        this.listIndex = listIndex;
        this.index = index;
    }
}