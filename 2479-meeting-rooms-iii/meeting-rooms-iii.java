class Solution {
    class Node {
        int roomIndex;
        long endTime;

        Node (int roomIndex, long endTime) {
            this.roomIndex = roomIndex;
            this.endTime = endTime;
        } 
    }

    public int mostBooked(int n, int[][] meetings) {
        int[] count = new int[n];
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        Node[] ar = new Node[n];
        for (int i = 0; i < n; i++) {
            ar[i] = new Node(i, 0);
        }

        for (int[] m : meetings) {
            int start = m[0];
            int end = m[1];

           Arrays.sort(ar, (a, b) -> {
                if (a.endTime <= start && b.endTime <= start) {
                    return a.roomIndex - b.roomIndex;
                } else {
                    if (a.endTime != b.endTime) {
                        return Long.compare(a.endTime, b.endTime); 
                    } else {
                        return a.roomIndex - b.roomIndex; 
                    }
                }
            });

            if (ar[0].endTime > start) {
                ar[0].endTime += (long) (end - start);
                count[ar[0].roomIndex]++;
            } else {
                ar[0].endTime = (long) end;
                count[ar[0].roomIndex]++;
            }
        }

        int max = 0;
        for (int i : count) {
            max = Math.max(max, i);
        }
        
        for (int i = 0; i < count.length; i++) {
            if (count[i] == max) {
                return i;
            }
        }
        return 0;
    } 
}