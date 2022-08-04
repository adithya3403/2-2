// 5. Define a MyRectangle class with four public data members representing the x- and y-coordinates of the bottom-left vertex and 
// top-right vertex of a rectangle, whose sides are parallel to the x- or y-axis.
// For example, the statement new MyRectangle(20,80,30,90) creates a rectangle with bottom-left vertex at position (20,80), and 
// top-right vertex at (30,90). 
// (a) Write an area() method, which computes the area of a rectangle.
// (b) Write the overlap(MyRectangle rect) method. This method returns a rectangle which is the overlapped region of two rectangles. In 
// the event that there is no overlap, it should return a rectangle with both bottom-left vertex and top-right vertex at position (0,0).
// (c) Using the overlap(MyRectangle rect) method written above, write the overlapAll(MyRectangle[] rectangles) method which returns the 
// overlapped region of all the rectangles in the array. You may assume that there is at least one element in the array. Your method 
// should be efficient in that the moment it finds that the overlapped region is empty, it should return a rectangle with both vertices 
// at (0,0) immediately. 
// (d) Write MySquare.java, MySquare extends MyRectangle.
// A square is defined by its bottom-left vertex and the length of its side. Complete the super( . . . ) statement in the constructor.
// (e)Below is output of MySquare.java program when the user enters: 10 30 5.
// Override the toString() method in MyRectangle in order to get such output.
import java.util.*;
class MyR {
    int v1x, v1y, v2x, v2y;
    MyR(int v1x, int v1y, int v2x, int v2y) {
        this.v1x = v1x; this.v1y = v1y;
        this.v2x = v2x; this.v2y = v2y;
    }
    MyR overlap(MyR rect) {
        int x1 = Math.max(v1x, rect.v1x), y1 = Math.max(v1y, rect.v1y);
        int x2 = Math.min(v2x, rect.v2x), y2 = Math.min(v2y, rect.v2y);
        if (x1 > x2 || y1 > y2) return new MyR(0, 0, 0, 0);
        else return new MyR(x1, y1, x2, y2);
    }
    int area() { return Math.abs((v1x - v2x) * (v2y - v1y)); }
}
class MySq extends MyR {
    int xcor, ycor, len;
    MySq(int xcor, int ycor, int len) {
        super(xcor, ycor, xcor + len, ycor + len);
        this.xcor = xcor; this.ycor = ycor; this.len = len;
    }
    public int area() { return len * len; }
}
public class q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x=sc.nextInt(), y=sc.nextInt(), len=sc.nextInt();
        MySq sq = new MySq(x, y, len);
        System.out.println(sq.area());
    }
}
// Input : 10 30 5
// Output: 25
