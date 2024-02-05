class Solution {
    public int firstUniqChar(String s) {
          int ans = Integer.MAX_VALUE;
        // Pair is not directly available in Java's standard library, so we'll use an array or a class.
        // Here, we'll use a 2D array to store the count and last index.
        int[][] res = new int[26][2]; // Assuming the input string only contains lowercase letters.

        for (int i = 0; i < s.length(); i++) {
            res[s.charAt(i) - 'a'][0] += 1; // Increment the count for the letter.
            res[s.charAt(i) - 'a'][1] = i; // Update the index for the letter.
        }

        for (int[] it : res) {
            if (it[0] == 1) // If the count is 1, it's a unique character.
                ans = Math.min(ans, it[1]); // Update ans to the minimum index found.
        }

        return ans != Integer.MAX_VALUE ? ans : -1;
    }
}




