class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        Arrays.sort(rectangles, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }

            return Integer.compare(b[2], a[2]);
        });

        boolean xSplit = false;
        int latestX = rectangles[0][2];

        for (int[] rectangle : rectangles) {
            if (latestX <= rectangle[0]) {
                if (xSplit) {
                    return true;
                }

                xSplit = true;
            }

            latestX = Math.max(rectangle[2], latestX);
        }

        // Check for Y
        Arrays.sort(rectangles, (a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }

            return Integer.compare(b[3], a[3]);
        });

        boolean ySplit = false;
        int latestY = rectangles[0][3];
        
        for (int[] rectangle : rectangles) {
            if (latestY <= rectangle[1]) {
                if (ySplit) {
                    return true;
                }

                ySplit = true;
            }

            latestY = Math.max(rectangle[3], latestY);
        }

        return false;
    }
}