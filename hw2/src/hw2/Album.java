package hw2;


public class Album {

	public String title ;
	public String artist ;
	public String genre;
	public String rDate ;
	public String totalTime;
	

	public Album(String title,String artist,String genre,String rDate,String totalTime){
		this.title=title;
		this.artist=artist;
		this.genre=genre;
		this.rDate=rDate;
		this.totalTime=totalTime;		
	
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getArtist() {
		return artist;
	}


	public void setArtist(String artist) {
		this.artist = artist;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
	}


	public String getrDate() {
		return rDate;
	}


	public void setrDate(String rDate) {
		this.rDate = rDate;
	}


	public String getTotalTime() {
		return totalTime;
	}


	public void setTotalTime(String totalTime) {
		this.totalTime = totalTime;
	}
	
	



}
