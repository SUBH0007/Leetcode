class Solution {
    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        int left = firstPlayer; //P1
        int right = secondPlayer; //P2

        if (left == n - right + 1) {
            return new int[]{1, 1}; // Return a new int array initialized with values.
        }
        //corner case fightsRight=n - right + 1 when left/P1 > fightsRight then midCount = fightsRight - left - 1 this will be -ve, to avoid this as the problem is symmetric shift p1/left and p2/right by 1 to left.
        //for 1,2,3,4,5 p1=2 p2=5, so fightsRight=5-5+1=1 so midCount will be negative so make p1=1 and p2=4 therefore fightRight=5-4+1=2
        if (left > n - right + 1) {
            int temp = n - left + 1;
            left = n - right + 1;
            right = temp;
        }

        int minRound = n;
        int maxRound = 1;
        int nextRoundPlayersCount = (n + 1) / 2;

        if (right <= nextRoundPlayersCount) { //Case-1 both on the same side
            int countLeft = left - 1;
            int midCount = right - left - 1;

            for (int survivorsLeft = 0; survivorsLeft <= countLeft; survivorsLeft++) {
                for (int survivorsMid = 0; survivorsMid <= midCount; survivorsMid++) {
                    int pos1 = survivorsLeft + 1;
                    int pos2 = pos1 + survivorsMid + 1;
                    int[] tempResult = earliestAndLatest(nextRoundPlayersCount, pos1, pos2); // Recursive call returns an int array.

                    minRound = Math.min(minRound, tempResult[0] + 1);// +1 for current round consideration.
                    maxRound = Math.max(maxRound, tempResult[1] + 1); // +1 for current round consideration.
                }
            }
        } else { //case - 2 both on opposite end
            int fightsRight = n - right + 1;
            int countLeft = left - 1;
            int midCount = fightsRight - left - 1;
            int remainMidCount = right - fightsRight - 1;

            for (int survivorsLeft = 0; survivorsLeft <= countLeft; survivorsLeft++) {
                for (int survivorsMid = 0; survivorsMid <= midCount; survivorsMid++) {
                    int pos1 = survivorsLeft + 1;
                    int pos2 = pos1 + survivorsMid + (remainMidCount + 1) / 2 + 1;

                    int[] tempResult = earliestAndLatest(nextRoundPlayersCount, pos1, pos2); // Recursive call returns an int array.

                    minRound = Math.min(minRound, tempResult[0] + 1); // +1 for current round consideration.
                    maxRound = Math.max(maxRound, tempResult[1] + 1); // +1 for current round consideration.
                }
            }
        }
        return new int[]{minRound, maxRound}; 
    }
}