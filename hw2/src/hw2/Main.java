package hw2;

import java.util.Scanner;

public class Main {
	
	public static void main(String [] args) throws Exception {
		
		int key;
		LinkedList list=new LinkedList();
		boolean menu=true;
		
		while(menu){
		  System.out.println("Show menu : \n");
		  System.out.println(" 1-Add \n 2-Remove \n 3-Display \n 4-Search \n 5-List \n 6-Save \n 7-Load \n 8-Exit \n");
		
		  System.out.println("Your choice : " );
		
		Scanner scan=new Scanner(System.in);
		key=scan.nextInt();
		  
		    if(key==1){
				Scanner scn =new Scanner(System.in);
			    System.out.println("Add information to be added : ");
		        String input=scn.nextLine();
			    String []tmp=input.split(",");
			    list.addLast(new Album(tmp[0],tmp[1],tmp[2],tmp[3],tmp[4]));
			    System.out.println("Added !! ");
		  }
			else if(key==2){
				Scanner scn =new Scanner(System.in);
				System.out.println("Name of the deleting album : ");
				String input=scn.nextLine();
			    list.deletion(input);
			    System.out.println(input + " Album is deleted.\n");
			   
				
		}
			else if(key==3){
				
				System.out.println("Display all albums : \n");
				list.display();
		}
			else if(key ==4){
				Scanner scn=new Scanner(System.in);
				System.out.println("Name of the searching album : ");
				String input=scn.nextLine();
				list.searching(input);
				
		}
			else if(key==5){
				Scanner scn=new Scanner(System.in);
				System.out.println("Enter the genre : ");
				String input=scn.nextLine();
				System.out.println("Albums in the " + input + "genre : \n");
				list.List(input);
				
		}
			else if(key==6){
				list.Save();
				
		}
		  
		    else if(key==7){
			
			    list.load();
	  
	    }
		
		    else if(key==8){
				
				System.out.println("***********BYEEE**********");
				menu=false;
				
		}
		
	 }
   }
 }
