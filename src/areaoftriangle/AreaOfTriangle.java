/*
 * Andrew Thompson
 * February 19, 2020
 * Calculates the area of a triangle
 */
package areaoftriangle;

/**
 *
 * @author antho6229
 */
import javax.swing.JOptionPane;

public class AreaOfTriangle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double a, b, c, C;

        int option = Integer.parseInt(JOptionPane.showInputDialog("Enter 1 to use Heron's formula or 2 to use trigonometry"));
    }

    /**
     *
     * @param a - side length a
     * @param b - side length b
     * @param c - side length c
     * @return - area of triangle with side lengths a, b and c
     */
    public static double heronsFormula(double a, double b, double c) {
        double area;
        //calculkate semi-perimeter
        double semiPerimeter = (a + b + c) / 2;
        //calculate number that goes inside square root
        double interior = semiPerimeter * (semiPerimeter - a) * (semiPerimeter - b) * (semiPerimeter - c);
        area = Math.sqrt(interior);

        return area;
    }
    
    /**
     * 
     * @param a - side length a
     * @param b - side length b
     * @param C - angle C (in between a and b)
     * @return - area of triangle with side lengths a and b, and angle C
     */
    public static double trigArea(double a, double b, double C) {
        double area;
        double angleInRadians = Math.toRadians(C);

        area = ((a * b) / 2) * Math.sin(angleInRadians);

        return area;
    }

}
