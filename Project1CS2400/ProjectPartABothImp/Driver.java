public class Driver {

	public static void main(String[] args) {

		//Bag<Student> myBag = new Bag<Student>(5);
		LinkedBag<Student> myList = new LinkedBag<Student>();
		Bag<Student> myBag = new Bag<Student>(2);
		Student John = new Student(402341, "John", "Tyson", "junior");
		Student John1 = new Student(301341, "Mike", "Tyson", "freshman");
		Student John11 = new Student(201241, "Roy", "Tyson", "freshman");
		Student John111 = new Student(999999, "Lisa", "Tyson", "junior");
		Student tom = new Student(999998, "Tom", "ty", "sophmore");
		System.out.println("linked List implementation");
		myList.add(John);
		myList.add(John111);
		myList.add(tom);
		myList.add(John1);	
		myList.numOfStudentsInEachLevel();
		System.out.println("resizeable Array Implemntation");
		myBag.add(John);
		myBag.add(John111);
		myBag.add(tom);
		myBag.add(John1);	
		myBag.numOfStudentsInEachLevel();

	}

}
