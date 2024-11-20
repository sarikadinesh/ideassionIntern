public class AnonymousClassExample {
    public static void main(String[] args) {
        Runnable task = new Runnable() {
            public void run() {
                System.out.println("Running in anonymous class!");
            }
        };

        Thread thread = new Thread(task);
        thread.start();
    }
}

