package paystub;

import java.util.Scanner;

public class PaystubCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in); // imported the scanner to take the user's input
		
		String name, employer; 
		double hourly_rate, hours_worked, gross_earnings, ei, federal, provincial; 
		double total_pay, yearly_salary, fed_taxed_inc = 0, prov_taxed_inc = 0, c_p_p; // created floating points for all the 
		
		System.out.println("Please enter your name: "); // Input user's name
		name = in.nextLine();
		System.out.println("Please enter your employers name: "); // Input user's employer's name
		employer = in.nextLine();
		System.out.println("Please enter your hours worked: "); // Input user's hours worked in a week
		hours_worked = in.nextDouble();
		System.out.println("Please enter your hourly wage: "); // Input user's hourly wage
		hourly_rate = in.nextDouble();
		
		gross_earnings = (hourly_rate * hours_worked); // The gross_earnings is equal to the hourly_rate x hours_worked
		
		yearly_salary = (2080 * hourly_rate); //52 weeks in a year * 40 hours per week = 2080 hours. (We find the yearly salary for the user so we can use it later.)
		System.out.println("\nEmployer name: " + employer);
				
       if (yearly_salary <= 45282)
          fed_taxed_inc = ((yearly_salary * 0.15) / 52); /* Federal tax is 15 % while yearly salary is less than or equal to $45282.
          (I divided by 52, as we can find the federal tax applied to the user's salary per week, as there are 52 weeks in a year.) */
       else if (yearly_salary > 45282 && yearly_salary <= 90563) 
          fed_taxed_inc = ((yearly_salary * 0.205) / 52);
          // Federal tax is 20.5 % while yearly salary is greater than $45282 and less than or equal to $90563.
       else if (yearly_salary > 90563 && yearly_salary <= 140388)
       	fed_taxed_inc = ((yearly_salary * 0.26) / 52);
       	 // Federal tax is 26 % while yearly salary is greater than $90563 and less than or equal to $140388.
       else if (yearly_salary > 140388 && yearly_salary <= 200000)
       	fed_taxed_inc = ((yearly_salary * 0.29) / 52);
       	// Federal tax is 29 % while yearly salary is greater than $140388 and less than or equal to $200000.
       else if (yearly_salary > 200000)
       	fed_taxed_inc = ((yearly_salary * 0.33) / 52);
       	// Federal tax is 33 % while yearly salary is greater than $200000.
       	
       if (yearly_salary <= 41536)
       	prov_taxed_inc = ((yearly_salary * 0.0505) / 52);
       	/* Provincial tax is 5.05 % while yearly salary is less than or equal to $41,436.
          (I divided by 52, as we can find the provincial tax applied to the user's salary per week, as there are 52 weeks in a year.) */
       else if (yearly_salary > 41536  && yearly_salary <= 41539)
       	prov_taxed_inc = ((yearly_salary * 0.0915) / 52);
       	// Provincial tax is 9.15 % while yearly salary is greater than 41,536 and less than or equal to $41,539
       else if (yearly_salary > 41539 && yearly_salary <= 66925)
       	prov_taxed_inc = ((yearly_salary * 0.1116) / 52);
       	// Provincial tax is 11.16 % while yearly salary is greater than 41,539 and less than or equal to $66,925
       else if (yearly_salary > 66925 && yearly_salary <= 70000)
       	prov_taxed_inc = ((yearly_salary * 0.1216) / 52);
       	// Provincial tax is 12.16 % while yearly salary is greater than $66,925 and less than or equal to $70,000
       else if (yearly_salary >= 220000)
       	prov_taxed_inc = ((yearly_salary * 0.1316) / 52);
		// Provincial tax is 13.16 % while yearly salary is greater than or equal to $220,000
		
       ei = ((yearly_salary * 0.0188) / 52);   /* Since we calculated how much x earned every week, we divided the yearly ei and other variables by 52 (amount of weeks in a year.) */
       c_p_p = ((yearly_salary * 0.0495) / 52);
      
       total_pay = (gross_earnings - (ei + c_p_p + fed_taxed_inc + prov_taxed_inc)); /* The total pay is the accumulation of the employment insurance,
       CPP, Federal tax, and provincial tax, subtracted from the weekly gross_earnings. */
      
      
		System.out.println("Employee Name: "+name+ "\n\nGross Earnings   C.P.P "
				+ "  E.I    Federal \tProvincial \tTotal Pay\n_________________"
				+ "__________________________________________________________");
		System.out.println("$" + gross_earnings + "\t\t $"+c_p_p+ " $"+ei+ " \t$" +fed_taxed_inc+ " \t\t$"+prov_taxed_inc+ " \t\t$"+total_pay);		
	}
}
