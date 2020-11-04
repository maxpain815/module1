package util;

public class LoopTest {
    int k = 5;
    public boolean checkIt(int k){
        return k-->0?true:false;
    }
    public void printThem(){
        while(checkIt(k)){
            System.out.print(k--);
        }
    }
    public static void main(String[] args) {
        byte by = 12;
        double d = 10.0;
        d = (long) by/d*3;
    }
}
