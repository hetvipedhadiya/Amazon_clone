import java.util.Scanner;

public class Circle
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		
		CircleAreaPerimeter c=new CircleAreaPerimeter();

		System.out.println("ENTER RADIUS OF CIRCLE= ");
		c.r=sc.nextDouble();

		c.printArea();
		c.printPerimeter();
	}
}

class CircleAreaPerimeter
{
	double r;

	void printArea()
	{
		double area=3.14*r*r;

		System.out.println("AREA= "+area);
	}

	void printPerimeter()
	{
		double perimeter=2*3.14*r;

		System.out.println("PERIMETER= "+perimeter);
	}
}