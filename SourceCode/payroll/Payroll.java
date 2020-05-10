
// package
package payroll;

// imports
import java.util.*;
import java.io.*;

class Employee{

	int id, start_date;
	String name;
	boolean is_union_member;
	String payment_type;
	double salary_per_unit;

	Employee(int id,String name,boolean is_union_member,String payment_type,double salary_per_unit,int start_date){
		this.id = id;
		this.name = name;
		this.is_union_member = is_union_member;
		this.payment_type = payment_type;
		this.salary_per_unit = salary_per_unit;
		this.start_date = start_date;
	}
}

class Work_by_hour extends Employee{

	int normal_hrs;
	int extra_hrs;
	double extra_hour_factor = 1.5;
	int payment_frequency = 7;

	Work_by_hour(int id,String name,boolean is_union_member,String payment_type,double salary_per_unit,int start_date){
		super(id, name, is_union_member, payment_type, salary_per_unit, start_date);
		normal_hrs = 0;
		extra_hrs = 0;
	}

	// double view_payroll(int day_count){

	// 	return 0.0;
	// }

	double payroll(int day_count){

		return 0.0;
	}
}

class Flat_salary extends Employee{

	int payment_frequency = 28;

	Flat_salary(int id,String name,boolean is_union_member,String payment_type,double salary_per_unit,int start_date){
		super(id, name, is_union_member, payment_type, salary_per_unit, start_date);
	}

	double payroll(int day_count){

		return 0.0;
	}
}

class Commission_payment extends Employee{

	int payment_frequency = 14;
	int sales_count;

	Commission_payment(int id,String name,boolean is_union_member,String payment_type,double salary_per_unit,int start_date){
		super(id, name, is_union_member, payment_type, salary_per_unit, start_date);
		sales_count = 0;
	}

	double payroll(int day_count){

		return 0.0;
	}
}

public class Payroll{

	private HashMap<Integer, Employee> employees;
	private HashMap<Integer, String> type_matching;
	private int avail_id = 0;
	private int day_count = 1;

	public Payroll(int day_count){

		this.day_count = day_count;
		employees = new HashMap<>();
		type_matching = new HashMap<>();
	}

	public void increment_day(){

		day_count += 1;
	}

	public int add_employee(String name,String salary_type,boolean is_union_member,String payment_type,double salary_per_unit){

		avail_id += 1;
		int id = avail_id;
		if (salary_type.equals("work by hour")){
			Employee emp = new Work_by_hour(id, name, is_union_member, payment_type, salary_per_unit,day_count);
			employees.put(id, emp);
			type_matching.put(id, salary_type);
			// System.out.println("Employee "+name+" successfully added");
		}
		else if(salary_type.equals("flat salary")){
			Employee emp = new Flat_salary(id, name, is_union_member, payment_type, salary_per_unit,day_count);
			employees.put(id, emp);
			type_matching.put(id, salary_type);
			// System.out.println("Employee "+name+" successfully added");
		}
		else if(salary_type.equals("commission")){
			Employee emp = new Commission_payment(id, name, is_union_member, payment_type, salary_per_unit,day_count);
			employees.put(id, emp);
			type_matching.put(id, salary_type);
			// System.out.println("Employee "+name+" successfully added");
		}
		else{
			avail_id -= 1;
			id = -1;
			// System.out.println("No such salary type");
		}
		return id;
	}

	public int delete_employee(int id){

		if (employees.containsKey(id)){
			Employee emp = employees.get(id);
			emp = null;
			employees.remove(id);
			type_matching.remove(id);
			// System.out.println("Deleted "+id+" Successfully");
			return id;
		}
		else{
			// System.out.println(id + " Not present");
			return -1;
		}

	}

	public int post_time_card(int id, int work_hours){

		if (employees.containsKey(id) && type_matching.get(id).equals("work by hour")){
			Work_by_hour emp = (Work_by_hour)employees.get(id);
			if (work_hours > 8){
				emp.normal_hrs += 8;
				emp.extra_hrs += (work_hours-8);
			}
			else{
				emp.normal_hrs += work_hours;
			}
			System.out.println("Time card added successfully");
			return emp.normal_hrs + emp.extra_hrs;
		}
		else{
			System.out.println("Not appliacable or no id");
			return -1;
		}
	}

	public int post_sales_reciept(int id, int sales_count){

		if (employees.containsKey(id) && type_matching.get(id).equals("commission")){
			Commission_payment emp = (Commission_payment)employees.get(id);
			emp.sales_count += sales_count;
			System.out.println("Sales reciept added successfully");
			return emp.sales_count;
		}
		else{
			System.out.println("Not appliacable or no id");
			return -1;
		}
	}

	public void de_bug(int id){

		if (employees.containsKey(id)){
			Employee e1 = employees.get(id);
			System.out.println(e1.payment_type);
			System.out.println(e1.is_union_member);
		}
		else{
			System.out.println("No Such id");
		}
	}

            
}