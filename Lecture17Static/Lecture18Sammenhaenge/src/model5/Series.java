package model5;

import java.util.*;

public class Series {
	private String title;
	private ArrayList<String> cast;
	private ArrayList<Episode> episodes;
	
	public Series(String title, ArrayList<String> cast) {
		this.title = title;
		this.cast = cast;
	}
	
	public String getTitle() {
		return title;
	}
	
	public ArrayList<String> getCast() {
		return new ArrayList<String>(cast);
	}
	
	public Episode createEpisode(int number, int lenght, ArrayList<String> guestActors) {
		Episode episode = new Episode(number, lenght, guestActors);
		episodes.add(episode);
		return episode;
	}
	
	public void removeEpisode(Episode episode) {
		episodes.remove(episode);
	}
	
	public ArrayList<Episode> getEpisodes() {
		return new ArrayList<Episode>(episodes);
	}
	
	public int totalLenght() {
		int totalLenght = 0;
		
		for(Episode e : episodes) {
			totalLenght += e.getLenght();
		}
		
		return totalLenght;
	}
	
	public ArrayList<String> getGuestActors() {
		ArrayList<String> allGuestCasts = new ArrayList<String>();
		for(Episode e : episodes) {
			for(String g : e.getGuestCast()) {
				allGuestCasts.add(g);
			}
		}
		return allGuestCasts;
	}
}
