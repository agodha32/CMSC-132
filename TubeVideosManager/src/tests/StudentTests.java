package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import tubeVideosManager.Genre;
import tubeVideosManager.Playlist;
import tubeVideosManager.TubeVideosManager;
import tubeVideosManager.Video;

/**
 * 
 * You need student tests if you are asking for help during
 * office hours about bugs in your code. Feel free to use
 * tools available in TestingSupport.java
 * 
 * @author UMCP CS Department
 *
 */
public class StudentTests {

	@Test
	public void testVideoConstructor() {
		
		Video x = new Video("My Video", "www.youtube.com", 10, Genre.Comedy);
		Video y = new Video(x);
		Video z = new Video("MyVideo", "ww.youtube.com", 10, Genre.Comedy);
		
		assertTrue(x.equals(y));
		assertFalse(x.equals(z));
		assertTrue(x.getGenre() == Genre.Comedy);
		assertTrue(y.getTitle().equals(x.getTitle()));
		
	}
		
	@Test
	public void testAddComments() {
		
		Video x = new Video("My Video", "www.youtube.com", 10, Genre.Comedy);
		x.addComments("Wow");
		x.addComments("This is Bad");
		x.addComments("This is Amazing");
		x.addComments("Trash");
		
		assertTrue(x.getComments().get(0).equals("Wow"));
		assertTrue(x.getComments().get(1).equals("This is Bad"));
		assertTrue(x.getComments().get(2).equals("This is Amazing"));
		assertTrue(x.getComments().get(3).equals("Trash"));
		
	}
	
	@Test
	public void testPlaylistConstructors() {
		
		Video x = new Video("My Video", "www.youtube.com", 10, Genre.Comedy);
		Video y = new Video("A Video", "www.youtube.com", 10, Genre.Comedy);
		Video z = new Video("Not a Video", "ww.youtube.com", 10, Genre.Comedy);
		
		Playlist newPlaylist = new Playlist("Sample Videos");
		
		newPlaylist.addToPlaylist(x.getTitle());
		newPlaylist.addToPlaylist(y.getTitle());
		newPlaylist.addToPlaylist(z.getTitle());
		
		assertTrue(newPlaylist.getPlaylistVideosTitles().get(0).equals(x.getTitle()));
		
		assertTrue(newPlaylist.getName().equals("Sample Videos"));
		
		
	}
	
	@Test
	public void testTubeVideoManager() {
		
		TubeVideosManager VidDBP = new TubeVideosManager();
		
		Video x = new Video("My Video", "www.youtube.com", 10, Genre.Comedy);
		Video y = new Video("A Video", "www.youtube.com", 10, Genre.Comedy);
		Video z = new Video("Not a Video", "ww.youtube.com", 10, Genre.Comedy);
		
		Playlist newPlaylist = new Playlist("Sample Videos");
		
		newPlaylist.addToPlaylist(x.getTitle());
		newPlaylist.addToPlaylist(y.getTitle());
		newPlaylist.addToPlaylist(z.getTitle());
		
		VidDBP.addPlaylist(newPlaylist.getName());
		VidDBP.addVideoToDB(x.getTitle(), x.getUrl(), x.getDurationInMinutes(), x.getGenre());
		VidDBP.addVideoToDB(y.getTitle(), y.getUrl(), y.getDurationInMinutes(), y.getGenre());
		VidDBP.addVideoToDB(z.getTitle(), z.getUrl(), z.getDurationInMinutes(), z.getGenre());
		
		VidDBP.addComments(x.getTitle(), "Wow");
		VidDBP.addComments(x.getTitle(), "This is Bad");
		VidDBP.addComments(y.getTitle(), "This is Amazing");
		VidDBP.addComments(z.getTitle(), "Trash");
		VidDBP.addVideoToPlaylist(newPlaylist.getName(), x.getTitle());
		assertTrue(VidDBP.getAllVideosInDB().get(0).equals(x));
	
	}
	
}
