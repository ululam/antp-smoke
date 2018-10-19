import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        String s = in.next();

        Solver solver = new Solver(s, len);

        System.out.println(solver.solve());
    }

    public static class Solver {
        private int[] lengths;
        private int maxLength;
        private final String str;

        private final Map<Character, Map<Character, Word>> FOREST = new HashMap<>(26);
        {
            for (char c = 'a'; c <= 'z'; c++) {
                final Map<Character, Word> tree = new HashMap<>();
                for (char c2 = 'a'; c2 <= 'z'; c2++) {
                    if (c2 == c) {
                        continue;
                    }

                    tree.put(c2, new Word());
                }

                FOREST.put(c, tree);
            }
        }

        public Solver(String str) {
            this(str, str.length());
        }

        Solver(String str, int strLength) {
            this.str = str;

            this.lengths = new int[strLength+1];
        }

        public int solve() {
            str.chars().forEach(c -> onNextChar((char)c));

            return getMaxLength();
        }

        private void onNextChar(char c) {
            for (char i = 'a'; i <= 'z'; i++) {
                if (i == c) {
                    continue;
                }
                final Map<Character, Word> tree = FOREST.get(i);
                Word w = tree.get(c);
                processWord(w, c);
            }

            Map<Character, Word> tree = FOREST.get(c);
            for (Word w : tree.values()) {
                processWord(w, c);
            }
        }

        private void processWord(Word w, Character c) {
            if (w.duplicationHappened) {
                return;
            }

            if (w.current == c) {
                w.duplicationHappened = true;
                if (--lengths[w.len] == 0 && w.len == maxLength) {
                    int i = w.len;
                    while (--i > 0 && lengths[i] == 0) {}
                    maxLength = i;
                }
                return;
            }

            w.current = c;
            lengths[w.len]--;
            lengths[++w.len]++;
            maxLength = Math.max(w.len, maxLength);
        }

        private int getMaxLength() {
            return maxLength;
        }

        private class Word {
            private char current;
            private int len;
            private boolean duplicationHappened;

            @Override
            public String toString() {
                return String.format("[%s, %s, %s]", current, len, duplicationHappened);
            }
        }
    }
}