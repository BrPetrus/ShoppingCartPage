//Definition of Song class

public class Song {
	private String title;
	private String artist;
	private double price;
	
	public Song() {
		title = "";
		artist = "";
		price = 0.0D;
	}
	public Song(String t, String a, double p) {
		setSong(t,a,p);
	}
	public void setSong(String t, String a, double p) {
		title = t;
		artist = a;
		price = p;
	}
	
	public String getTitle() { return title; };
	public String getArtist() { return artist; };
	public double getPrice() { return price; };
	
	public void setTitle(String t) { title = t; };
	public void setArtist(String a) { artist = a; };
	public void setPrice(double p) { price = p; };
}
