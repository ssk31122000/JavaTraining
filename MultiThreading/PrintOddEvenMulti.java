public class PrintOddEvenMulti {



    public static void main(String[] args) {
        PrintNums nums = new PrintNums(6,12);

        Thread t1 = new Thread(()-> nums.printEven());
        Thread t2 = new Thread(()-> nums.printOdd());

        t1.start();
        t2.start();

    }

    public static class PrintNums{
        public int num;
        public int endNum;

        public PrintNums(int num, int endNum){
            this.num = num;
            this.endNum = endNum;
        }
        synchronized public void printOdd(){
            while(num<endNum){
                while(this.num%2 == 0){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                System.out.println(num +" odd - " + Thread.currentThread().getName());
                num+=1;
                notify();
            }
        }

        synchronized public void printEven(){
            while(num<endNum){
                while(this.num%2 != 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println(num +" even - " + Thread.currentThread().getName());
                num+=1;
                notify();
            }
        }

    }




}
