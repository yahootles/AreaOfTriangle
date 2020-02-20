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
        //variable declaration
        double a, b, c, C;//side lengths and angle
        double area = 0;//area
        boolean flag = false;//flag for while loop
        
        while (!flag) {
            try {
                //get option from user
                int option = Integer.parseInt(JOptionPane.showInputDialog("Enter 1 to use Heron's formula or 2 to use trigonometry"));
                switch (option) {
                    case 1:
                        //get required side lengths
                        a = getSideLength();
                        b = getSideLength();
                        c = getSideLength();
                        //calculate area
                        area = heronsFormula(a,b,c);
                        
                        flag = true;
                        break;
                    case 2:
                        //get required side lengths and angle
                        a = getSideLength();
                        b =  getSideLength();
                        C = getAngle();
                        //calculate area
                        area = trigArea(a,b,C);
                        
                        flag = true;
                        break;
                    default:
                        //make sure input is valid
                        throw new NumberFormatException(); 
                }
                
            } catch (NumberFormatException nfe) {
                System.err.println("Not an option");
            }
        }
        //output area
        System.out.println("The area of the trianlge is: " + area);
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

    /**
     *
     * @return - side length that user entered
     */
    public static double getSideLength() {
        double sLength = 0;
        boolean flag = false;

        while (!flag) {
            try {
                //prompt for input
                sLength = Double.parseDouble(JOptionPane.showInputDialog("Enter a side length (must be positive)"));
                //make sure side length is positive
                if (sLength <= 0) {
                    throw new NumberFormatException();
                } else {
                    return sLength;
                }
            } catch (NumberFormatException nfe) {
                System.err.println("Invalid input");
            }
        }
        return sLength;
    }

    /**
     *
     * @return - angle that user entered
     */
    public static double getAngle() {
        double angle = 0;
        boolean flag = false;
        
        while (!flag) {
            try {
                //prompt user for input
                angle = Double.parseDouble(JOptionPane.showInputDialog("Enter an angle in degrees"));
                flag = true;
            } catch (NumberFormatException nfe) {
                //ensure input is valid
                System.err.println("Invalid input");
            }
        }
        return angle;
    }

}
