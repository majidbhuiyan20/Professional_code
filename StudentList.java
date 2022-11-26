import java.io.*;
import java.text.*;
import java.util.*;
public class StudentList
{

	public static String getLineFromFile() throws Exception
	{
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(
						new FileInputStream("students.txt")));
		String line = bufferedReader.readLine();
		return  line;
	}
	public static BufferedWriter getFileBufferedWriter() throws Exception
	{
			return new BufferedWriter(
					new FileWriter("students.txt", true));
	}



	public static void main(String[] args)
	{

//		Check arguments
		if(args.length!=1)
		{
			System.err.println("Invalid number of argument");
			System.err.println("Exiting Program.");
			System.exit(1);
		}
		

		if(args[0].equals("a"))
		{
			System.out.println("Loading data ...");			
			try
			{

			String line = getLineFromFile();
			String students[] = line.split(", ");  //..
			for(String student : students)
			{
				System.out.println(student);
			}

			}
			catch (Exception e)
			{

			}
			System.out.println("Data Loaded.");
		}
		else if(args[0].equals("r")) 
		{
			System.out.println("Loading data ...");			
			try
			{

			String line = getLineFromFile();
			String students[] = line.split(", ");
			Random random = new Random();
				int index = random.nextInt(students.length);
					System.out.println(students[index]);
			}
			catch (Exception e){}
			System.out.println("Data Loaded.");			
		}
		else if(args[0].contains("+"))
		{
			System.out.println("Loading data ...");			
			try
			{
				BufferedWriter bufferedWriter = getFileBufferedWriter();
			String newData = args[0].substring(1);
	        Date date = new Date();
	        String df = "dd-mm-yyyy-hh:mm:ss a";
	        DateFormat dateFormat = new SimpleDateFormat(df);
	        String formatDate = dateFormat.format(date);
				bufferedWriter.write(", "+newData+"\nList last updated on "+formatDate);
				bufferedWriter.close();
			}
			catch (Exception e){}
							
			System.out.println("Data Loaded.");	
		}
		else if(args[0].contains("?")) 
		{
			System.out.println("Loading data ...");			
			try
			{

			String line = getLineFromFile();
			String students[] = line.split(",");
			boolean done = false;
			String newData = args[0].substring(1);
			for(int idx = 0; idx<students.length && !done; idx++)
			{
				if(students[idx].equals(newData))
				{
					System.out.println("We found it!");
						done=true;
				}
			}
			}
			catch (Exception e){}
			System.out.println("Data Loaded.");				
		}

		else if(args[0].contains("c")) 
		{
			System.out.println("Loading data ...");			
			try
			{
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(
							new FileInputStream("students.txt"))); 
			String line = bufferedReader.readLine();
			char students[] = line.toCharArray();
			boolean in_word = false;
			int count=0;
			for(char c:students)
			{
				if(c ==' ') 
				{
					if (!in_word) {	count++; in_word =true;
					}
					else { in_word=false;}			
				}
			}
			System.out.println(count +" word(s) found ");
			}
			catch (Exception e)
			{
				
			}
			System.out.println("Data Loaded.");				
		}

		else
		{
			System.err.println("Invalid number of argument");
			System.err.println("Exiting Program.");
			System.exit(2);
		}
	}

}