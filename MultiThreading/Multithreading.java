public class Multithreading {
    public static void main(String[] args) {
        Thread thread2 = new Thread(() -> longTask());
        thread2.start();
        System.out.println("Doing another task on main thread");
    }

    public static void longTask(){
        long t= System.currentTimeMillis();
        long end = t+3000;

        while(true){
            if(System.currentTimeMillis() == end){
                System.out.println("finished long task");
                break;
            }
        }
    }
}
