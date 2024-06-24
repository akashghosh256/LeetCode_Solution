class Solution {
    public int partitionString(String s) {
        
        char a[] = s.toCharArray();
        int count = 0;
        Set<Character> set = new HashSet<>();;
        for(char i : a){
            if(set.isEmpty()){
                count++;
                    set.add(i);
            }
           else if(set.contains(i)){
            set = new HashSet<>();
            count++;
            set.add(i);
            }else{
                set.add(i);
            }
        }
        return count;

    }
}