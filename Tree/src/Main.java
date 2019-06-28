import java.util.Scanner;

public class Main {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		Node n = new Node();
		LinkedList l = new LinkedList();

		int number = 0;
		boolean Temp = false;
		int s3 = 0;

		n = l.CreateNode();

		/*
		 * // Level 1 l.InsertNode(n, 100); // Level 2 l.InsertNode(n, 90);
		 * l.InsertNode(n, 110); // Level 3 l.InsertNode(n, 80); l.InsertNode(n, 95);
		 * l.InsertNode(n, 105); l.InsertNode(n, 115); // Level 4 l.InsertNode(n, 75);
		 * l.InsertNode(n, 85); l.InsertNode(n, 93); l.InsertNode(n, 103);
		 * l.InsertNode(n, 106); l.InsertNode(n, 120); // Level 5 l.InsertNode(n, 83);
		 * l.InsertNode(n, 94); l.InsertNode(n, 108); l.InsertNode(n, 117);
		 */

		l.InsertNode(n, 18);
		l.InsertNode(n, 7);
		l.InsertNode(n, 26);
		l.InsertNode(n, 3);
		l.InsertNode(n, 12);
		
		l.InsertNode(n, 21);
		l.InsertNode(n, 31);

		Loop: for (;;) {

			System.out.print("1. Insert\t2. Count\t3. Search\t4. Search2\t5. Search3\t6. Search4\t"
					+ "7. LevelOder\t8. InorderPrint\t9. PrePrint\t10. PostPrint" + "\t\t11. NoChild"
					+ "\t12 NoChildDelete\nSelect >> ");

			switch (sc.nextInt()) {

			case 1:
				System.out.print("Data : ");
				l.InsertNode(n, sc.nextInt());
				break;
			case 2:
				System.out.println("Count : " + (l.CountNode(n) + 1));
				break;
			case 3:
				System.out.print("Search : ");
				number = sc.nextInt();
				Temp = l.SearchNode(n, number);
				System.out.println("<< Search >> " + Temp);
				break;
			case 4:
				if (Temp == true) {
					System.out.print("<< Search2 >> ");
					l.SearchNode2(n, number);
					System.out.println();
				}
				break;
			case 5:
				s3 = l.SearchNode3(n) + 2;
				System.out.println("<< Search3 >> " + s3);
				break;
			case 6:
				System.out.println("<< Search4 >> " + l.SearchNode4(n));
				break;
			case 7:
				l.LevelOderNode(n);
				break;
			case 8:
				System.out.print("<< InorderPrint >> ");
				l.InorderPrint(n);
				System.out.println();
				break;
			case 9:
				System.out.print("<< PrePrint >> ");
				l.PrePrint(n);
				System.out.println();
				break;
			case 10:
				System.out.print("<< PostPrint >> ");
				l.PostPrint(n);
				System.out.println();
				break;
			case 11:
				System.out.println("Child : " + l.NoChildNode(n));
				break;
			case 12:
				System.out.print("Data :");
				l.DeleteNode(n, sc.nextInt());
				l.LevelOderNode(n);
				break;
			default:
				System.out.println("종료합니다.");
				break Loop;

			}

		}

	}
}