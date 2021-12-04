import java.io. * ;
import java.text. * ;
import java.util. * ;
public class StudentList {
	public static void main(String[] args) {
		
		//		Check arguments
		if ((args==null)||(args.length==0))
		{
			System.out.println("Invalid argument");
		}
		else if (args[0].equals("charArray")) {
			System.out.println("Loading data ...");
			try {
				BufferedReader bufferReader = new BufferedReader(
				new InputStreamReader(
				new FileInputStream("students.txt")));
				String fullLine = bufferReader.readLine();
				String studentNames[] = fullLine.split(",");
				for (String student: studentNames) {
					System.out.println(student);
				}
			} catch(Exception exception) {}
			System.out.println("Data Loaded.");
		}
		else if (args[0].equals("fullLine")) {
			System.out.println("Loading data ...");
			try {
				BufferedReader bufferReader = new BufferedReader(
				new InputStreamReader(
				new FileInputStream("students.txt")));
				String fullLine = bufferReader.readLine();
				String studentNames[] = fullLine.split(", ");
				Random random = new Random();
				int size = studentNames.length;
				int randomIndex = random.nextInt() % size;
				randomIndex = Math.abs(randomIndex);
				System.out.println(randomIndex);
				System.out.println(size);
				System.out.println(studentNames[randomIndex]);
			} catch(Exception exception) {}
			System.out.println("Data Loaded.");
		}
		else if (args[0].contains("+")) {
			System.out.println("Loading data ...");
			try {
				BufferedWriter bufferReader = new BufferedWriter(
				new FileWriter("students.txt", true));
				String addStudent = args[0].substring(1);
				Date date = new Date();
				String dateFormate = "dd/mm/yyyy-hh:mm:ss charArray";
				DateFormat dateFormat = new SimpleDateFormat(dateFormate);
				String fd = dateFormat.format(date);
				bufferReader.write(", " + addStudent + "\nList last updated on " + fd);
				bufferReader.close();
			} catch(Exception exception) {}

			System.out.println("Data Loaded.");
		}
		else if (args[0].contains("?")) {
			System.out.println("Loading data ...");
			try {
				BufferedReader bufferReader = new BufferedReader(
				new InputStreamReader(
				new FileInputStream("students.txt")));
				String fullLine = bufferReader.readLine();
				String studentNames[] = fullLine.split(", ");
				boolean done = false;
				String addStudent = args[0].substring(1);
				for (int idx = 0; idx < studentNames.length && !done; idx++) {
					if (studentNames[idx].equals(addStudent)) {
						System.out.println("We found it!");
						done = true;
					}
				}
			} catch(Exception exception) {}
			System.out.println("Data Loaded.");
		}
		else if (args[0].contains("c")) {
			System.out.println("Loading data ...");
			try {
				BufferedReader bufferReader = new BufferedReader(
				new InputStreamReader(
				new FileInputStream("students.txt")));
				String date = bufferReader.readLine();
				char charArray[] = date.toCharArray();
				boolean in_word = false;
				int count = 0;
				for (char c: charArray) {
					if (c == ' ') {
						if (!in_word) {
							count++;
							in_word = true;
						}
						else {
							in_word = false;
						}
					}
				}
				System.out.println(count + " word(bufferReader) found " + charArray.length);
			} catch(Exception exception) {}
			System.out.println("Data Loaded.");
		}
		else{
			System.out.println("Wrong argument");
		}
	}
}