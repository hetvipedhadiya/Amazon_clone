// Java program to find angle between hour and minute hands
import java.io.*;
import java.util.Scanner;
class hourMin
{
	// Function to calculate the angle
	static int calcAngle(double h, double m)
	{
		
		if (h <0 || m < 0 || h >12 || m > 60)
			System.out.println("Wrong input");

		if (h == 12)
			h = 0;
			if (m == 60)
	{
		m = 0;
		h += 1;
		if(h>12)
		h = h-12;
		}
		
		int hour_angle = (int)(0.5 * (h*60 + m));
		int minute_angle = (int)(6*m);

		// Find the difference between two angles
		int angle = Math.abs(hour_angle - minute_angle);

		// smaller angle of two possible angles
		angle = Math.min(360-angle, angle);

		return angle;
	}
	

	public static void main (String[] args)
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter hour hand: ");
		double h=sc.nextDouble();
		System.out.println("Enter minute hand: ");
		double m=sc.nextDouble();
		System.out.println(calcAngle(h, m)+" degree");
		
	}
}


