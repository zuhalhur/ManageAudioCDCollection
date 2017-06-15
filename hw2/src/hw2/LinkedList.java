package hw2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.security.Timestamp;

public class LinkedList {
	public  Node head;
	
	public class Node{
		public Album data;
		public Node next;
		
		public Node (Album data,Node next){
			this.data=data;
			this.next=next;
			
		}
			
	}
	
 public LinkedList() {
      
	 head=null;
	}
 //This method controls whether empty in Linked list.
public boolean isEmpty(){
	return head==null;
}
//This method add a new Album to the linked list.
public void addLast(Album item){
	if(head==null){
	head=new Node(item,head);
	}
	else{
		Node tmp=head;
		while(tmp.next!=null)
			tmp=tmp.next;
		tmp.next=new Node(item,null);
	}
	
}

//This method check whether an album with given album title exists in the linked list.
public Node searching(String title){
	Node tmp=head;
	while(tmp!=null){
		if(tmp.data.title.toUpperCase().equals(title.toUpperCase())){//Make the album title case insensitive.
			System.out.println(title+ " Album is in the linked list. " );
			return tmp;
	}
		tmp=tmp.next;
	}
	System.out.println(title+ " Album is not in linked list. ");
	return null;
}

//According to the title,this method remove existing album from the linked list.
public void deletion(String title){
	
	if(head==null)
		return;
	if(head.data.title.toUpperCase().equals(title.toUpperCase())){
		head=head.next;
	return;
}
Node cur=head;
Node prev=null;
while(cur!=null && !cur.data.title.toUpperCase().equals(title.toUpperCase())){
	prev=cur;
	cur=cur.next;
	
}
if(cur==null)
	return;
	prev.next=cur.next;

}
//This method display all albums and print sum of times of all albums in the linked list.
public void display(){
	int totalHour=0;
	int totalMinute=0;
	int totalSecond=0;
	String hour;
	String minute;
	String second;
	
     Node tmp = head;
    while(tmp != null){

        System.out.println(tmp.data.title + "," + tmp.data.artist + "," + tmp.data.genre + "," + tmp.data.rDate + "," + tmp.data.totalTime + "\n");
        String [] times=tmp.data.totalTime.split(":");
        totalHour+=Integer.parseInt(times[0]);
        totalMinute+=Integer.parseInt(times[1]);
        totalSecond+=Integer.parseInt(times[2]);
        tmp = tmp.next;
    }
    totalMinute+=totalSecond/60;
    totalHour+=totalMinute/60;
    totalSecond=totalSecond%60;
    totalMinute=totalMinute%60;
    if(totalSecond<10){
    	second = "0"+totalSecond;
    }else{
     second =""+totalSecond;
    }
    if(totalMinute<10){
    	 minute = "0"+totalMinute;
    }
    else{
    	 minute = ""+totalMinute;
    }
    if(totalHour<10){
    	 hour= "0"+totalHour;
    }
    else{
    	 hour= ""+totalHour;
    }
    System.out.println("Total time is : " + hour + ":" + minute + ":" + second + "\n");
 
  
}
//This method list all the albums in that genre.
public void List(String genre){
	if(head==null)
		return;
	Node tmp=head;
	while(tmp!=null){
		
	if(tmp.data.genre.toUpperCase().equals(genre.toUpperCase()))
		System.out.println(tmp.data.title + "," + tmp.data.artist + "," + tmp.data.genre + "," + tmp.data.rDate + "," + tmp.data.totalTime + "\n");
	tmp=tmp.next;
		  
	}
	
}
//This method save all the album information in the linked list to a text file named albums1.txt
public void Save() throws Exception{
	BufferedWriter bw = null;
	String mycontent = "";
File file = new File("albumsSaved.txt"); 
    		 FileWriter fw = new FileWriter(file);
    		  bw = new BufferedWriter(fw);
    try {
    	Node tmp=head;
    	
      while(tmp!=null){
    		mycontent = tmp.data.title + "," + tmp.data.artist + "," + tmp.data.genre + "," + tmp.data.rDate + "," + tmp.data.totalTime;
    		  bw.write(mycontent);
    		  bw.newLine();
    		tmp=tmp.next;
       	}
	 
	 System.out.println("File saved successfully!! \n ");

    }
    catch (IOException e) {
	   e.printStackTrace();
	}
	finally
	{ 
	   try{
	      if(bw!=null)
		 bw.close();
	   }catch(Exception ex){
	       System.out.println("Error in closing the BufferedWriter"+ex);
	    }
	}
 }
//From the text file,this method read the information about the albums and construct a linked list.
public void load(){
	 BufferedReader br = null;
	 try {
	      
	      br = new BufferedReader(new FileReader("albums.txt"));
	      String line = null;
	      
	      while ((line = br.readLine()) != null) {
	        
	        String[] values = line.split(",");
	        Album al1=new Album(values[0],values[1],values[2],values[3],values[4]);
	        addLast(al1);
	         }
	    }
	    catch (FileNotFoundException ex) {
	      ex.printStackTrace();
	    }
	    catch (IOException ex) {
	      ex.printStackTrace();
	    }
	    finally {
	      try {
	        if (br != null)
	          br.close();
	      }
	      catch (IOException ex) {
	        ex.printStackTrace();
	      }
	    }
}
	
}
