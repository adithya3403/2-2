// 2. A resistor is a circuit device designed to provide a specific resistance between its two ends.
// Resistance is expressed in ohms (Ω) or kilo-ohms (kΩ). Resistors are usually marked with coloured bands
// that encode their resistance, as shown in figure 1 below. The first two bands represent
// digits and the third is a power-of-ten multiplier.
// The table below shows the number value of each band colour. For example, if the first band
// is red (represents 2), the second is black (represents 0), and the third is orange (represents 3), the
// resistance is 20 × 103 Ω or 20 kΩ.
// Write a Resistor class containing the parameterized constructor, which takes in three strings
// representing the three band colours. Write the methods to calculate and set the resistance for the resistor. 
import java.util.*;
class Resistor {
    String b1, b2, b3;
    HashMap<String, Integer> color=new HashMap<>();;
    public Resistor(String b1, String b2, String b3) {
        this.b1 = b1;
        this.b2 = b2;
        this.b3 = b3;
        color.put("black", 0);
        color.put("brown", 1);
        color.put("red", 2);
        color.put("orange", 3);
        color.put("yellow", 4);
        color.put("green", 5);
        color.put("blue", 6);
        color.put("violet", 7);
        color.put("grey", 8);
        color.put("white", 9);
    }
    public int getResistance() {
        int d1 = color.get(b1);
        int d2 = color.get(b2);
        int d3 = (int) Math.pow(10, color.get(b3));
        String v1 = Integer.toString(d1) + Integer.toString(d2);
        int v = Integer.parseInt(v1) * d3;
        return (int)(v / 1000);
    }
}
public class q2 {
    public static void main(String args[]) {
        Resistor r1 = new Resistor("red", "black", "orange");
        System.out.println(r1.getResistance()+" Kilo ohms);
    }
}
// output:
// 20 Kilo ohms
