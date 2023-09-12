import java.util.HashMap;

class AuthenticationManager {
    
    // HashMap to store tokens and their expiration times
    HashMap<String, Integer> map;
    
    // The time duration for token expiration
    int time;
    
    // Constructor to initialize the AuthenticationManager
    public AuthenticationManager(int timeToLive) {
        // Initialize the HashMap to store tokens
        map = new HashMap<>();
        // Initialize the time duration for token expiration
        time = timeToLive;
    }
    
    // Method to generate a token with an expiration time
    public void generate(String tokenId, int currentTime) {
        // Add the token to the HashMap with its expiration time
        map.put(tokenId, currentTime + time);
    }
    
    // Method to renew a token's expiration time
    public void renew(String tokenId, int currentTime) {
        // Get the current expiration time for the token
        int expires = map.getOrDefault(tokenId, 0);
        // Check if the token is still valid (not expired)
        if (expires > currentTime) {
            // Renew the token's expiration time by adding the time duration
            map.put(tokenId, currentTime + time);
        }
    }
    
    // Method to count the number of unexpired tokens at a given time
    public int countUnexpiredTokens(int currentTime) {
        // Initialize a count variable to keep track of unexpired tokens
        int count = 0;
        // Iterate through the tokens in the HashMap
        // for (String key : map.keySet()) {
        //     // Check if the token's expiration time is greater than the current time
        //     if (map.get(key) > currentTime) {
        //         // Increment the count if the token is unexpired
        //         count++;
        //     }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
    String key = entry.getKey();
    Integer value = entry.getValue();
    if (value > currentTime) count++;

        }
        // Return the count of unexpired tokens
        return count;
    }
}
