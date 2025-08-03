package com.gfg;

import java.util.ArrayList;

public class SearchPatternKMP {
    private void longestPrefixSuffix(int[] lps, String pattern) {
        lps[0] = 0;
        int i = 0, j = 1;
        int len = pattern.length();
        while (j < len) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                lps[j] = i + 1;
                i++;
                j++;
            } else {
                if (i == 0) {
                    lps[j] = 0;
                    j++;
                } else {
                    i = lps[i - 1];
                }
            }
        }
    }

    public ArrayList<Integer> search(String pat, String txt) {
        ArrayList<Integer> ans = new ArrayList<>();
        int tLen = txt.length();
        int pLen = pat.length();
        int i = 0, j = 0;
        int[] lsp = new int[pLen];
        longestPrefixSuffix(lsp, pat);
        while (i < tLen) {
            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
                if (j == pLen) {
                    ans.add(i - j);
                    j = lsp[j - 1];
                    // After a full pattern match, instead of resetting j = 0,
// we set j = lsp[j - 1] to check for overlapping matches.
//
// Example: txt = "aabaaba", pat = "aaba"
// - First match found at index 0: "aaba"
// - Remaining text: "aba"
// - Instead of restarting from the beginning, we look at lsp[3] = 1,
//   which tells us that the suffix "a" at the end of the match
//   is also a prefix of the pattern.
// - So we set j = 1 and continue matching from there.
//
// This allows us to find the next overlapping match: "aaba" at index 3.
// The LSP array captures this overlap efficiently,
// avoiding unnecessary comparisons.


                }
            } else {
                if (j == 0) {
                    i++;
                } else {
                    j = lsp[j - 1];
                }
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        String txt = "aabaacaadaabaaba";
        String pat = "aaba";
        SearchPatternKMP obj = new SearchPatternKMP();
        ArrayList<Integer> result = obj.search(pat, txt);
        System.out.println("Pattern found at indices: " + result);
    }
}
