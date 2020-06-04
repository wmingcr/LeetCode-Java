import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MayBeOneOfTheBest不确定 {

    // 每次跳一个单词的距离，会不会出现问题？

    static class Solution {
        public List<Integer> findSubstring(String s, String[] words) {
            List<Integer> listOfSubstringId = new ArrayList<> ();

            // corner case 1
            if (s == null || words == null || words.length == 0) {
                return listOfSubstringId;
            }

            // initialization
            int sLen = s.length(), wordsNum = words.length, wordLen = words[0].length();
            HashMap<String, Integer> wordsFreq = new HashMap<>();
            for (String str: words) {
                wordsFreq.put(str, wordsFreq.getOrDefault(str, 0) + 1);
            }

            // corner case 2:
            if (s.length() < wordsNum * wordLen) {
                return listOfSubstringId;
            }

            int leftIdLimit = sLen - wordsNum * wordLen + 1;
            for (int i = 0; i < wordLen; i++) { // loop times
                for (int left = i; left < leftIdLimit; left += wordLen) { //!! range of leftId for this loop
                    HashMap<String, Integer> seenWordsFreq = new HashMap<>();

                    for (int wordId = wordsNum - 1; wordId > -1; wordId--) {
                        int id = left + wordId * wordLen;
                        String currWord = s.substring(id, id + wordLen);
                        int currFreq = seenWordsFreq.getOrDefault(currWord, 0) + 1;

                        if (currFreq > wordsFreq.getOrDefault(currWord, 0)) { //!!
                            left = id;  //!!
                            break;
                        }

                        seenWordsFreq.put(currWord, currFreq); //!! !!
                        if (wordId == 0) {  //!!
                            listOfSubstringId.add(left);
                        }
                    }

                }
            }

            return listOfSubstringId;
        }
    }
}
