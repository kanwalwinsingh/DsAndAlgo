package ConcurrenyQuestions.RateLimiterTokenFiller.usingfactory;

public class TokenBucketFilterFactory {

    private TokenBucketFilterFactory(){

    }
    static public TokenBucketFilter makeTokenBucketFilterFactory(int capacity){
        MultithreadedTokenBucketFilter tbf = new MultithreadedTokenBucketFilter(capacity);
        tbf.initialize();
        return tbf;
    }

    private static class MultithreadedTokenBucketFilter extends TokenBucketFilter{
        private long possibleTokens = 0;
        private final int maxTokens;
        private final int ONE_SECOND = 1000;

        MultithreadedTokenBucketFilter(int maxTokens){
            this.maxTokens = maxTokens;
        }

        void initialize(){
            Thread dt = new Thread(()->daemonThread());
            dt.setDaemon(true);
            dt.start();
        }

        private void daemonThread() {
            while (true){
                synchronized (this){
                    if (possibleTokens<maxTokens){
                        possibleTokens++;
                    }
                    this.notify();
                }
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException ex){
                    System.out.println(ex);
                }
            }
        }

        @Override
        public void getToken() {
            synchronized (this){
                if (possibleTokens == 0) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            possibleTokens--;
            System.out.println(
                    "Granting " + Thread.currentThread().getName() + " token at " + System.currentTimeMillis() / 1000);
        }
    }
}
