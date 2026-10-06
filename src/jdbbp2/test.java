package jdbbp2;
import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter employee ID: ");
		int eid = sc.nextInt();
		sc.nextLine(); // Consume newline left-over
		System.out.print("Enter employee name: ");
		String ename = sc.nextLine();
		System.out.print("Enter employee salary: ");
		int sal = sc.nextInt();
		String query = "INSERT INTO newemp (eid, ename, sal) VALUES (" + eid + ", '" + ename + "', " + sal + ")";
		System.out.println("Query: " + query);

	}

}
