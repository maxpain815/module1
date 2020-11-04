package px;

class Square {
    private double side = 0;
    String color;
    public Square(double length){
        this.side = length;
    }
    public double getSide() {  return side;    }

    public void setSide(double side) {  this.side = side;   }

}

public class TestClass{
    public static void main(String args){
        for(int i=0; i<3; i++){
            System.out.print(args+" ");
        }
    }
}
