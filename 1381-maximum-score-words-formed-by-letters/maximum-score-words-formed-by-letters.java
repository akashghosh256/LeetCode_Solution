class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {

        int freq[] = new int [26];
        for(char i : letters)
        freq[i-'a']++;

        return solve(0,words,freq,score);
        
    }
  int solve(int i, String[] words, int freq[], int[] score){
    if( i>=words.length) return 0;

    int s = 0; //score
    boolean possible = true;
    int clone[] = freq.clone();

    for( char c : words[i].toCharArray()){
        if( clone[c-'a']>0) {
            s+= score[c-'a'];
            clone[c-'a']--;
        }
        else{
            possible = false;
            break;
        }
    }

int ans = 0;
if(possible){
    ans = s+solve(i+1,words,clone,score); // take
}
ans = Math.max(ans,solve(i+1,words,freq,score)); // not take frequency array remains same

return ans;

  }




}