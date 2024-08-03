package ConcurrenyQuestions.RateLimiterTokenFiller;

import java.util.HashSet;
import java.util.Set;

public class TokenBucketFilterWithSync {
    private int MAX_TOKENS;
    private long lastRequestTime = System.currentTimeMillis();
    long possibleToken = 0;

    public TokenBucketFilterWithSync(int maxTokens){
        MAX_TOKENS = maxTokens;
    }

    synchronized void getToken(){
        possibleToken += (System.currentTimeMillis()-lastRequestTime)/1000;
        if(possibleToken>MAX_TOKENS){
            possibleToken = MAX_TOKENS;
        }
        if(possibleToken == 0){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }else {
            possibleToken--;
        }
        lastRequestTime = System.currentTimeMillis();
        System.out.println("Granting "+Thread.currentThread().getName()+ " token at"+ (System.currentTimeMillis() / 1000));
    }

    public static void runTest(){
        final TokenBucketFilterWithSync tokenBucketFilterWithSync = new TokenBucketFilterWithSync(5);
        Set<Thread> allThreads = new HashSet<>();
        for(int i =0; i<10;i++){
            Thread thread = new Thread(
                    tokenBucketFilterWithSync::getToken
            );
            thread.setName("Thread_"+(i+1));
            allThreads.add(thread);
        }
        for (Thread t : allThreads){
            t.start();
        }
        for (Thread t : allThreads){
            try {
                t.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        runTest();
    }

}
