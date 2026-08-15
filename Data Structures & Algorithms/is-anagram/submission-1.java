class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> characters = new HashMap<Character, Integer>();

        if(t.length() > s.length()){
            String temp = t;
            t = s;
            s = temp;
        }
        
        for(char c : s.toCharArray()){
            int count = characters.getOrDefault(c, 0) + 1;
            characters.put(c, count);
        }

        int uniq_count = characters.size();

        for(char c : t.toCharArray()){
            int count = characters.getOrDefault(c, 0) - 1;

            if(count == -1){
                return false;
            }


            if(count == 0){
                uniq_count -= 1;
            }

            if (uniq_count == 0){
                return true;
            }

            characters.put(c, count);

        }

        return uniq_count == 0 ? true : false;
    }
}
