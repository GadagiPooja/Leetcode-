class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        char[] chars = s.toCharArray(); // Convert the string to a char array for easy modification

        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int dir = shift[2];

            for (int i = start; i <= end; i++) {
                if (dir == 1) {
                    // Shift forward
                    chars[i] = (char) ((chars[i] - 'a' + 1) % 26 + 'a');
                } else {
                    // Shift backward
                    chars[i] = (char) ((chars[i] - 'a' - 1 + 26) % 26 + 'a');
                }
            }
        }

        return new String(chars); // Convert the char array back to a string
    }
}





class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] diff = new int[n + 1]; // Difference array to record shifts

        // Step 1: Populate the difference array
        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2];

            if (direction == 1) {
                diff[start] += 1;
                diff[end + 1] -= 1;
            } else {
                diff[start] -= 1;
                diff[end + 1] += 1;
            }
        }

        // Step 2: Compute the prefix sum for net shifts
        int[] netShift = new int[n];
        int cumulative = 0;
        for (int i = 0; i < n; i++) {
            cumulative += diff[i];
            netShift[i] = cumulative;
        }

        // Step 3: Apply the shifts to the string
        char[] result = s.toCharArray();
        for (int i = 0; i < n; i++) {
            int shift = (result[i] - 'a' + netShift[i]) % 26;
            if (shift < 0) shift += 26; // Handle negative shifts
            result[i] = (char) (shift + 'a');
        }

        // Step 4: Return the final string
        return new String(result);
    }
}



