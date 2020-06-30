package edu.uog.Person;

import java.util.List;
import java.util.Scanner;

public class PersonInterface {
	public static void PersonManu() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int choice=-1;
		
		while (choice!=7) {
			System.out.println("=====================================================");
			System.out.println("Person Menu");
			System.out.println("=====================================================");
			System.out.println("1.   Insert");
			System.out.println("2.   Delete");
			System.out.println("3.   Show");
			System.out.println("4.   Show One Person Data");
			System.out.println("5.   Search");
			System.out.println("6.   Delete All");
			System.out.println("7.  Back");
			System.out.print("Enter Your Choice [1-7]: ");
			choice = scan.nextInt();

			switch (choice) {
			case 1:
				System.out.println("*********************************");
				System.out.println("Add New Person");
				System.out.println("*********************************");
				Person person = new Person();

				System.out.println("Enter Fore Name:");
				String name= scan.nextLine();
				name+=scan.nextLine();
				person.setFORE_NAME(name);

				System.out.println("Enter Sur Name: ");
				String sname = scan.nextLine();
				person.setSUR_NAME(sname);

				System.out.println("Enter Person Title: ");
				String title=scan.nextLine();
				person.setTITLE(title);
				
				System.out.println("Enter Person Gender: ");
				String gene=scan.nextLine();
				person.setGENDER(gene);
				
				System.out.println("Enter Person Age: ");
				int age=scan.nextInt();
				person.setAGE(age);
				
				System.out.println("Enter Person Address ");
				String address=scan.nextLine();
				address+=scan.nextLine();
				person.setADDRESS(address);
				
				person = PersonData.Save(person);
				System.out.println(person.toString());
				
				System.out.println("********************************\n");
				break;
			case 2:
				System.out.println("********************************");
				System.out.println("Delete Person");
				System.out.println("*********************************");
				System.out.println("Enter Person ID: ");
				int person_ID = scan.nextInt();
				
				Person persondelete = PersonData.DelOne(person_ID);
				System.out.println(persondelete.toString());
				System.out.println("---------------------------------\n");
				break;
			case 3:
				System.out.println("***********************************");
				System.out.println("Show All Persons Data");
				System.out.println("************************************");
				List<Person> persons = PersonData.findAll();
				for (int i=0; i<persons.size(); i++) {
					System.out.println(persons.get(i).toString());
				}
				System.out.println("***********************************\n");
				break;
			case 4:
				System.out.println("----------------------------------");
				System.out.println("Show One Person Data");
				System.out.println("-----------------------------------");
				Person per=PersonData.findOne(1);
				System.out.println(per.toString());
				System.out.println("------------------------------------");
			
			    break;
			case 5:
				System.out.println("---------------------------------");
				System.out.println("Search Person");
				System.out.println("---------------------------------");
				System.out.println("Enter search: ");
				String search = scan.nextLine();
				search+=scan.nextLine();
				List<Person> personsearch = PersonData.search(search);
				for (int i=0; i<personsearch.size(); i++) {
					System.out.println(personsearch.get(i).toString());
				}
				System.out.println("---------------------------------");
				
				break;
			case 6:
				System.out.println("---------------------------------");
				System.out.println("Delete All Data");
				System.out.println("---------------------------------");
				
				List<Person> Del=PersonData.DelAll();
				for(int i=0;i<Del.size();i++) {
					System.out.println(Del.get(i).toString());
				}
				System.out.println("---------------------------------");
				
				break;
			case 7:
				break;
			}
		}
	}


}
