class Pair{
   public  char c;
   public int index;
   Pair(char c, int index){
    this.c = c;
    this.index = index;
   }
}

class Solution {
    public String clearStars(String s) {

        char [] ch = s.toCharArray();
        Queue<Pair> pq = new PriorityQueue<>(
            (a,b) -> {
            if(a.c == b.c){
                return  b.index -a.index;
            }

            return Character.compare(a.c, b.c);
            }
        );

        for(int i=0; i<ch.length; i++){
            char tp = ch[i];

        if(tp != '*'){
            pq.offer(new Pair(ch[i],i));
            continue;
        }

        if(!pq.isEmpty()){
            Pair temp = pq.poll();
            ch[temp.index] = '*';
            
        }

        }

        StringBuilder res = new StringBuilder();
        for(char i : ch){
            if( i != '*')
            res.append(i);
        }

        return res.toString();

        
    }
}