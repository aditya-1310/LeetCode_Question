class Solution {
    public boolean checkStrings(String s1, String s2) {
         if (s1.length() != s2.length()) {
            return false;
        }

        // Extract characters at even and odd indices for both strings
        StringBuilder evenS1 = new StringBuilder();
        StringBuilder oddS1 = new StringBuilder();
        StringBuilder evenS2 = new StringBuilder();
        StringBuilder oddS2 = new StringBuilder();

        for (int i = 0; i < s1.length(); i++) {
            if (i % 2 == 0) {
                evenS1.append(s1.charAt(i));
                evenS2.append(s2.charAt(i));
            } else {
                oddS1.append(s1.charAt(i));
                oddS2.append(s2.charAt(i));
            }
        }

        // Convert the strings to char arrays and sort them to compare
        char[] evenArrayS1 = evenS1.toString().toCharArray();
        char[] evenArrayS2 = evenS2.toString().toCharArray();
        char[] oddArrayS1 = oddS1.toString().toCharArray();
        char[] oddArrayS2 = oddS2.toString().toCharArray();

        Arrays.sort(evenArrayS1);
        Arrays.sort(evenArrayS2);
        Arrays.sort(oddArrayS1);
        Arrays.sort(oddArrayS2);

        // Compare sorted even and odd character arrays
        return Arrays.equals(evenArrayS1, evenArrayS2) && Arrays.equals(oddArrayS1, oddArrayS2);
    }
    }
