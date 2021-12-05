import java.io. * ;
import java.text. * ;
import java.util. * ;

//Method for read file from students.txt.
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

				//return fullline for further use.
				return fullLine;
		}

		//for exception handle.
		catch(Exception exception) {
			System.out.println("Can't open file");
			return null;
		}
	}

	//main method.
	public static void main(String[] args) {

		//ctreating object of constant class.
		Constant cons = new Constant();

		String fullLine = readFile();

		//		Check arguments

		//while there is no argument then it shows invalid.
		if ((args==null)||(args.length==0))
		{
			System.out.println(cons.invalid);
		}

		//show the names in the list.
		else if (args[0].equals(cons.showList)) {
			System.out.println(cons.load);
			try {
				 
				String studentNames[] = fullLine.split(cons.comma);
				for (String student: studentNames) {
					System.out.println(student);
				}
			} catch(Exception exception) {}
			System.out.println(cons.loaded);
		}
		//show random
		else if (args[0].equals(cons.showRandom)) {
			System.out.println(cons.load);
			try {
				String studentNames[] = fullLine.split(cons.commaWithSpace);
				Random random = new Random();
				System.out.println(studentNames[Math.abs(random.nextInt() % studentNames.length)]);
			} catch(Exception exception) {}
			System.out.println(cons.loaded);
		}

		//add a new name.
		else if (args[0].contains(cons.add)) {
			System.out.println(cons.load);			
			try {
			BufferedWriter writter = new BufferedWriter(
					new FileWriter("students.txt", true));
			String newName = args[0].substring(1);
	        Date date = new Date();
	        DateFormat dateFormat = new SimpleDateFormat(cons.dateFormat);
			writter.write(cons.commaWithSpace+newName+"\nList last updated on "+dateFormat.format(date));
			writter.close();
			} catch (Exception e){}
							
			System.out.println(cons.loaded);	
		}

		//search a name
		else if (args[0].contains(cons.search)) {
			System.out.println(cons.load);
			try { 
				String studentNames[] = fullLine.split(cons.commaWithSpace);
				String addStudent = args[0].substring(1);
				for (int idx = 0; idx < studentNames.length; idx++) {
					if (studentNames[idx].equals(addStudent)) {
						System.out.println(cons.found);
						break;
					}
				}
			} catch(Exception exception) {}
			System.out.println(cons.loaded);
		}

		//count the words in the list.
		else if (args[0].contains(cons.countWords)) {
			System.out.println(cons.load);
			try {
				String studentNames[] = fullLine.split(cons.commaWithSpace);
				System.out.println(studentNames.length);
				int totalChar = 0 ;
				for (int i=0;i<studentNames.length;i++)
				{
					totalChar += studentNames[i].length();
				}
				System.out.println(totalChar);
			} catch(Exception exception) {}
			System.out.println(cons.loaded);
		}

		//if there is wrong argument then show "wrong".
		else{
			System.out.println(cons.wrong);
		}
	}
}

