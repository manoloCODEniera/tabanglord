package studentdb2;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import static java.nio.file.StandardOpenOption.*;
import java.nio.*;

public class StudentMain{
	
	ArrayList<Student> students  = new ArrayList<>();
	FileOutputStream fos = null;
    ObjectOutputStream oos = null;
    FileInputStream fis = null;
    ObjectInputStream ois = null;
	
	
	
	public void registerStudent(){
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter Student number: ");
		Student stud = new Student();
		
		String studNum;
				studNum = sc.nextLine();
				stud.setStudentNumber(studNum);
			
			
		System.out.println("Please enter First Name: ");
			stud.setFirstName(sc.nextLine());
		System.out.println("Please enter Last Name: ");
			stud.setLastName(sc.nextLine());
		System.out.println("Please enter Middle Initial: ");
			stud.setMiddleInitial(sc.nextLine().charAt(0));	
		System.out.println("Please enter Program: ");
			stud.setCourse(sc.nextLine());
		System.out.println("Enter Year Level: ");
			stud.setYearLevel(Integer.parseInt(sc.nextLine()));
			
			students.add(stud);
			System.out.println("Student added.");
		
	}
	
	
	private boolean checkStudent(String studNum){
		
		boolean found = false;
		for(Student st:students){
				if(st != null){
					if(st.getStudentNumber().equals(studNum)){
						System.out.println(st);
						found = true;
				}
			}
		}
		
		return found;
	}
	
	public void searchStudent(){
		
		System.out.println("Enter student number: ");
		Scanner sc = new Scanner(System.in);
		String studNum = sc.nextLine();
		Boolean foundStudent = false;
		for(Student st:students){
			if(st.getStudentNumber().equals(studNum)){
				System.out.println("Student Number: " + st.getStudentNumber()
									+"\nName: "+st.getLastName()+ ", " +st.getFirstName()+" "+st.getMiddleInitial()+".\n"
									+"Course: "+st.getCourse()
									+"\nYear Level: "+st.getYearLevel());	
                                foundStudent = true;
                                break;
			}
		}
                if(!foundStudent){
                    System.out.println("No Student Found");
                }
	}
	
	
	public void removeStudent(){
		
		System.out.println("Enter student number: ");
		Scanner sc = new Scanner(System.in);
		String studNum = sc.nextLine();
                Boolean foundStudent = false;
		
		for(Student st:students){
			if(st.getStudentNumber().equals(studNum)){
				
				students.remove(st);
                                System.out.println("Student Removed!");
                                foundStudent = true;
			        break;
			}
		}
                if(!foundStudent){
                    System.out.println("No Student Found");
                }
	}
	
	
	//method to save the list into a file labeled db.txt
	public void save(){
		
		
		try {
			//TODO
            fos = new FileOutputStream("db.txt");
            oos = new ObjectOutputStream(fos);

			
			
			
            File file = new File("D:/dump eclipse/StudentMain/bin/db.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            //TODO
            fos = new FileOutputStream("db.txt");
            oos = new ObjectOutputStream(fos);

            oos.writeObject(students);
            
            oos.close();
            
            
            System.out.println("LIST SAVED \n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

		
		/*
		Path p = Paths.get("db.txt");
		
		
		try (OutputStream out = new PrintStream(Files.newOutputStream(p, CREATE, APPEND))) {
			this.open();
			
			for(Student st : students){
				
				//
					
					    	byte[] data = st.getStudentNumber().getBytes();
					    	out.write(data);
					    	((PrintStream) out).append("\r\n"); 
					    	
					    	data = st.getLastName().getBytes();
					    	out.write(data);
					    	((PrintStream) out).append("\r\n"); 
					    	 
					    	data = st.getFirstName().getBytes();
					    	out.write(data);
					    	((PrintStream) out).append("\r\n"); 
					    	
					    	data = Character.toString(st.getMiddleInitial()).getBytes();
					    	out.write(data);
					    	((PrintStream) out).append("\r\n"); 
					    	
					    	data = st.getCourse().getBytes();
					    	out.write(data);
					    	((PrintStream) out).append("\r\n"); 
					    	
					    	data = Integer.toString(st.getYearLevel()).getBytes();
					    	out.write(data);
					    	((PrintStream) out).append("\r\n"); 
						//}
			    	
			    }  
			    
			
			out.close();
			    } catch (IOException x) {
			      System.err.println(x);
			    }finally{
			    	
			    }
	
		*/
	
	
	//method that should be used to open an existing file, or create it if it doesn't exist
	public void open(){
		
		 File fin = new File("db.txt");
         if(fin.length() == 0) {
             // file is emtpy!!
             System.err.println("FILE IS EMPTY");
             System.exit(-1);
         }
         try {
			fis = new FileInputStream(fin);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
         try {
			ois = new ObjectInputStream(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			try {
				 students = (ArrayList<Student>) ois.readObject();
				
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {

            // make sure to close the files!
            try {
                //fos.close();
            	ois.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

         
		
        

	
		
		
		/*
		Path file = Paths.get("db.txt");
		
		
		//String studNum;
		try (	InputStream in = Files.newInputStream(file);
			    BufferedReader reader =
			    				new BufferedReader(new InputStreamReader(in))) {
			    String line;
                            int counter = 1;
			    while ((line = reader.readLine()) != null) {
			        Student stud = new Student();
			       //line is initially the student number, need to perform checking before adding to the list
			        
                                switch(counter){
                                    case 1:{
                                        stud.setStudentNumber(line);
                                        System.out.println(line);
                                        counter++;
                                    }
                                    case 2:{
                                    	line = reader.readLine();
                                        stud.setLastName(line);
                                        System.out.println(line);
                                        counter++;
                                    }
                                    case 3:{
                                    	line = reader.readLine();
                                        stud.setFirstName(line);
                                        System.out.println(line);
                                        counter++;
                                    }
                                    case 4:{
                                    	
                                        line = reader.readLine();
                                        stud.setMiddleInitial(line.charAt(0));
                                        System.out.println(line);
                                        counter++;
                                    }
                                    case 5:{
                                    	line = reader.readLine();
                                        stud.setCourse(line);
                                        System.out.println(line);
                                        counter++;
                                    }
                                    case 6:{
                                    	line = reader.readLine();
                                        stud.setYearLevel(Integer.parseInt(line));
                                        System.out.println(line);
                                        counter++;
                                    }   
                                   
                                    students.add(stud);
                                    counter = 1;
                                }
			        
                                
                                	
                                
			        }
			    reader.close();
			    
			} catch (IOException x) {
			    System.err.println(x);
			}

		
		
	}
	
	*/
	
	
	public static void main(String[] args){
	
	Scanner sc = new Scanner(System.in);
	boolean exit = false;
	StudentMain mein = new StudentMain();
		
        
	
	while(exit==false){
	
			System.out.println(" 1 - Register a student \n 2 - Search by Student Number \n 3 - Delete a student \n 4 - Load previous session \n 5 - Save \n 6 - Exit");
			
			
			int choice = sc.nextInt();
			
				switch(choice){
				case 1:{
					mein.registerStudent();
					break;
				}
				case 2:{
					mein.searchStudent();
					break;
				}case 3:{
					mein.removeStudent();
					break;
					
				}case 4:{
					mein.open();
					break;
					
				}case 5:{
					mein.save();
					break;
					
				}case 6:{
					exit = true;
					break;
				}
				
				default:{
					System.out.println("no choice selected!");
				}
				}
		}
	}
}