
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
		int id2 = pr.add_employee("emp2", "flat salary", false, "Mail", 10000);
		int id3 = pr.add_employee("emp3", "commission", false, "Mail", 30);


		// pr.de_bug(id1);
		// pr.de_bug(id2);

		// System.out.println();

		// System.out.println(pr.post_time_card(id1, 10));
		// System.out.println(pr.post_sales_reciept(id3, 40));

		// pr.add_service_charge(id1, 15);
		// pr.add_union_membership(id3);
		// System.out.println(pr.get_salary_per_unit(id2));
		// pr.alter_salary_per_unit(id2, 5000);
		// System.out.println(pr.get_salary_per_unit(id2));
		// System.out.println(pr.get_payment_mode(id3));
		// pr.alter_payment_mode(id3, "by hand");
		// System.out.println(pr.get_payment_mode(id3));


		// for(int i = 1;i < 29;i++){
		// 	System.out.println("Day:"+i);
		// 	pr.process_payroll_all();
		// 	pr.increment_day();
		// }



		pr.add_service_charge(id1,25);
		pr.add_service_charge(id3, 50);
		pr.add_service_charge(id2, 100);
		for(int i = 1;i < 29;i++){
			System.out.println("Day:"+i);
			pr.post_time_card(id1,9);
			pr.post_sales_reciept(id3, 10);

			double var1 = pr.process_payroll(id1);
			if (var1 != -1.0){
				System.out.println(id1 +":"+var1);
			}
			double var2 = pr.process_payroll(id2);
			if (var2 != -1.0){
				System.out.println(id2 +":"+var2);
			}
			double var3 = pr.process_payroll(id3);
			if (var3 != -1.0){
				System.out.println(id3 +":"+var3);
			}

			pr.increment_day();

		}


	}
}