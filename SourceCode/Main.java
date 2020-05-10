
// imports
import java.util.*;
import java.io.*;
import payroll.*;

// Feature testing file

public class Main{

	public static void main(String[] args){

		System.out.println("Starting");
		Payroll pr = new Payroll(0);
		int id1 = pr.add_employee("emp1", "work by hour", true, "Account", 10);
		int id2 = pr.add_employee("emp2", "flat salary", false, "Mail", 3000);
		int id3 = pr.add_employee("emp3", "commission", false, "Mail", 300);


		// pr.de_bug(id1);
		// pr.de_bug(id2);

		// System.out.println();

		System.out.println(pr.post_time_card(id1, 10));
		System.out.println(pr.post_sales_reciept(id3, 40));

	}
}