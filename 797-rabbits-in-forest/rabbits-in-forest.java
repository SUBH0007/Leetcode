class Solution {
    public int numRabbits(int[] answers) {
        Arrays.sort(answers);
        int rabbits = answers[0] + 1;
        int start = answers[0];
        int count = 1;

        for (int i = 1; i < answers.length; i++) {
            if (start != answers[i]) {
                rabbits += answers[i] + 1;
                start = answers[i];
                count = 1;
            } else {
                count++;
            }
            if (count > start + 1) {
                rabbits += answers[i] + 1;
                count = 1;
            }
        }

        return rabbits;
    }
}