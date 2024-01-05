// class DataStream {

// Queue<Integer> q = new LinkedList<>();
// int value, k;
//     public DataStream(int value, int k) {
//       this.k = k;
//       this.value = value;  
//     }
    
//     public boolean consec(int num) {
//         if( num != value){
//             q.clear();
//             return false;
//         }
//         if( num == value){
//             q.add(num);
//         }
//         if( q.size() == k) {
//             q.poll();
//             return true;
//         }
//         else return false;
        
//     }
// }

class DataStream {
int count;
int value, k;
    public DataStream(int value, int k) {
      this.k = k;
      this.value = value; 
      this.count = 0; 
    }
    
    public boolean consec(int num) {
        if( num != value){
           count =0;
            return false;
        }
        if( num == value){
            count++;
        }
        if( count == k) {
           count--;
            return true;
        }
        else return false;
        
    }
}

/**
 * Your DataStream object will be instantiated and called as such:
 * DataStream obj = new DataStream(value, k);
 * boolean param_1 = obj.consec(num);
 */