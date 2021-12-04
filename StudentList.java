import java.io. * ;
import java.text. * ;
import java.util. * ;
public class StudentList {
	public static String readFile()
	{
		try{
				String fullLine;
				BufferedReader bufferReader = new BufferedReader(
				new InputStreamReader(
				new FileInputStream("students.txt")));
				fullLine = bufferReader.readLine();
				bufferReader.close();
				return fullLine;
		}
		catch(Exception exception) {
			System.out.println("Can't open file");
			return null;
		}
	}
	public static void main(String[] args) {

		String fullLine = readFile();
		//		Check arguments
		if ((args==null)||(args.length==0))
		{
			System.out.println("Invalid argument");
		}
		else if (args[0].equals("a")) {
			System.out.println("Loading data ...");
			try {
				 
				String studentNames[] = fullLine.split(",");
				for (String student: studentNames) {
					System.out.println(student);
				}
			} catch(Exception exception) {}
			System.out.println("Data Loaded.");
		}
		else if (args[0].equals("r")) {
			System.out.println("Loading data ...");
			try {
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
			BufferedWriter s = new BufferedWriter(
					new FileWriter("students.txt", true));
			String t = args[0].substring(1);
	        Date d = new Date();
	        String df = "dd/mm/yyyy-hh:mm:ss a";
	        DateFormat dateFormat = new SimpleDateFormat(df);
	        String fd= dateFormat.format(d);
			s.write(", "+t+"\nList last updated on "+fd);
			s.close();
			} catch (Exception e){}
							
			System.out.println("Data Loaded.");	
		}
		else if (args[0].contains("?")) {
			System.out.println("Loading data ...");
			try {
				 
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

