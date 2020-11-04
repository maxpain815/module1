package testPackage;

class StringWrapper {
    private String theVal;
    public StringWrapper(String str){ this.theVal = str; }
}
public class Tester{
    public static void main(String[] args) {
        StringWrapper sw = new StringWrapper("How are you?");
        StringBuilder sb = new StringBuilder("How are you?");
        System.out.println("Hello, "+sw);
        System.out.println("Hello, "+sb);
        int sdf = toRet();
    }

    static int toRet(){

        return 12;
    }
}
