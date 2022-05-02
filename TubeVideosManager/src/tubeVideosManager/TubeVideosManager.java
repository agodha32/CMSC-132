package tubeVideosManager;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * Implements the functionality of the videos manager. It implements the
 * TubeVideosManagerInt interface. The video manager keeps track of videos in an
 * ArrayList called videoDatabase. It also keeps track of playlists that have
 * been created using an Arraylist. We have declared these instance variables for
 * you.
 * 
 * Feel free to add any private instance variables and private methods you
 * understand you need. Do not add static methods, static variables or any
 * public methods except a default constructor.
 * 
 * Some methods have been provided; do not modify them.
 * 
 * @author UMCP CS Department
 *
 */
public class TubeVideosManager implements TubeVideosManagerInt {
	private ArrayList<Video> videoDatabase; // Represents the videos database
	private ArrayList<Playlist> playlists; // Represents the playlist

	/**
	 * Creates any necessary data structures and performs any required
	 * initialization.
	 */
	public TubeVideosManager() {
		
		this.videoDatabase = new ArrayList<Video>(); // creates a new video database
		this.playlists = new ArrayList<Playlist>(); // creates a new playlist
	
	}

	/**
	 * Creates a video based on the parameter information and adds it to the
	 * videoDatase ArrayList. Returns true if video was added and false otherwise
	 * (e.g., invalid parameters were provided). This method will not check for the
	 * validity of parameters. If an exemption takes place while creating a video,
	 * the method will print the error message returned by the exception and return
	 * false. Use System.err.println to print the error message.
	 * 
	 * @return true if video added; false otherwise
	 */
	public boolean addVideoToDB(String title, String url, int durationInMinutes, Genre videoGenre) {
		
		Video newVideo = new Video(title, url, durationInMinutes, videoGenre); // create a new video
		
		this.videoDatabase.add(newVideo); // add it to the database
		
		return true;
		
	}

	/**
	 * Returns an ArrayList with copies of the videos in the database. Modifications
	 * to the returned ArrayList should not affect the database.
	 * 
	 * @return ArrayList of Video references
	 */
	public ArrayList<Video> getAllVideosInDB() {
		
		ArrayList<Video> newDB = new ArrayList<Video> (); // new db to avoid privacy leakes
		
		for(Video y : this.videoDatabase) {
			
			newDB.add(y); // add videos to the new db
			
		}
		
		return newDB;
	
	}

	/**
	 * Find a video in the database, returning a copy of the video if found;
	 * otherwise null will be returned. If the parameter is null or blank (according
	 * to the String class isBlank() method) an
	 * IllegalArgumentException (with any error message) will be thrown.
	 * 
	 * @return reference to copy of Video found or null
	 * 
	 */
	public Video findVideo(String title) {
		
		Video videoIsFound = null; // pre condition if video is not found

		if(title.isBlank() || title == null) {
			
			throw new IllegalArgumentException();
			
		}
	
		for(Video possibleVideo : this.videoDatabase) {
			// finding video in db and mathching its title
			if(possibleVideo.getTitle().equals(title)) {
				
				videoIsFound = possibleVideo; // set the video which will be returned if found
				
			}
			
		}
		
		return videoIsFound;
		
	}

	/**
	 * Adds the specified comments to the video with the specified title (if the
	 * video exists). If the parameters are invalid (null or empty string) the
	 * method will return false.
	 * 
	 * @return true if comments added; false otherwise
	 */
	public boolean addComments(String title, String comments) {
		
		if(title.isBlank() || title == null || comments.isBlank() || comments == null) {
		
			return false;
			
		} else {
			
			Video videoToAddComments = findVideo(title); // find the video to add the comment to
			videoToAddComments.addComments(comments); // add the comments
			return true;
			
		}
		
	}

	/**
	 * Creates and adds a playlist to the manager if a playlist with the specified
	 * name does not already exist. The method will throw an
	 * IllegalArgumentException (with any message) if the parameter is invalid (null
	 * or blank).
	 * 
	 * @return true if playlist has been added; false otherwise
	 */
	public boolean addPlaylist(String playlistName) {

		boolean playlistNameExists = false; // pre-condition to add playlist
		
		if(playlistName.isBlank() || playlistName == null) {
			
			throw new IllegalArgumentException ();
			
		}
	
		for(Playlist x : this.playlists) {
		// tring to find if the new playlist exists
			if(x.getName().equals(playlistName)) {
				
				playlistNameExists = true;
				
			}
			
		}
		
		if(playlistNameExists == false) {
			// create a new playlist and add it to the tube video manager
			Playlist newPlaylist = new Playlist(playlistName);
			
			this.playlists.add(newPlaylist);
			
			return true;

		} else {
			
			return false;
			
		}
		
		
	}

	/**
	 * Returns array with the names of playlists. An empty array will be returned if
	 * there are no playlists.
	 * 
	 * @return Array of String references.
	 */
	public String[] getPlaylistsNames() {
		//create an array of strings for the playlist names
		String[] playlistName = new String[this.playlists.size()];
		
		for(int x = 0; x < this.playlists.size(); x++) {
			// add each name using a for loop
			playlistName[x] = this.playlists.get(x).getName();
			
		}
		
		return playlistName;
	
	}

	/**
	 * Adds the title to the specified playlist if the title exists in the database
	 * and the playlist also exists.
	 * 
	 * @return true if the title is added to the playlist; false otherwise
	 */
	public boolean addVideoToPlaylist(String title, String playlistName) {

		Video videoTitlePresent = findVideo(title); // find the video
		Playlist playlistNamePresent = findPlayListInternal(playlistName); // find the playlist
		boolean videoAdded = false; // pre-condition
		
		if(videoTitlePresent != null && playlistNamePresent != null) {
			
			videoAdded = playlistNamePresent.addToPlaylist(title);
			videoAdded = true; // if video is added
			
		}
		
		return videoAdded;
		
	}

	/**
	 * Returns a copy of the playlist associated with the specified name; null
	 * otherwise (e.g., if playlist is not found). If the parameter is null or is
	 * blank string (according to String class isBlank() method) the method will
	 * throw an IllegalArgumentException (with any message) and perform no
	 * processing.
	 * 
	 * @return Reference to playlist or null
	 */
	public Playlist getPlaylist(String playlistName) {
		// returns a copy of the playlist found
		return new Playlist(findPlayListInternal(playlistName));
	
		
	}

	/**
	 * Clears the database by removing all videos and all playlists.
	 */
	public void clearDatabase() {
		// removes the playlists and the videos
		this.playlists.removeAll(playlists);
		this.videoDatabase.removeAll(videoDatabase);
		
	}

	/**
	 * Returns a playlist with videos that match the specified parameter criteria.
	 * The maximumDurationInMinutes represents the maximum duration allowed for a
	 * video. If a parameter is null or the duration is a negative value, that
	 * particular criteria will be ignored. For example, if we call the method with
	 * null, -1, null a playlist with the titles of all videos in the database will
	 * be returned. The returned playlist will not be added to the list of playlists
	 * kept by the system. 
	 */
	public Playlist searchForVideos(String playlistName, String title, int maximumDurationInMinutes, Genre genre) {

		Playlist x = new Playlist(playlistName);
		
		if(title == null && maximumDurationInMinutes < 0 && genre.equals(null)) {
			
			for(Video y : this.videoDatabase) {
				
				x.addToPlaylist(y.getTitle());
				
			}
		
		} else if(title == null) {
		
			for(Video y : this.videoDatabase) {
				
				if(y.getDurationInMinutes() == maximumDurationInMinutes &&
						y.getGenre().equals(genre)) {
				
					x.addToPlaylist(y.getTitle());
				
				}
			
			}
		
		} else if(maximumDurationInMinutes > 0) {
			
			for(Video y : this.videoDatabase) {
				
				if(y.getTitle().equals(title) && y.getGenre().equals(genre)) {
				
					x.addToPlaylist(y.getTitle());
				
				}
			
			}
			
		} else if(!(genre.equals(null))) {
			
			for(Video y : this.videoDatabase) {
				
				if(y.getTitle().equals(title) && y.getDurationInMinutes() ==
					maximumDurationInMinutes) {
				
					x.addToPlaylist(y.getTitle());
				
				}
			
			}
			
		} else {
			
			for(Video y : this.videoDatabase) {
				
				if(y.getTitle().equals(title) && y.getDurationInMinutes() ==
					maximumDurationInMinutes && y.getGenre().equals(genre)) {
				
					x.addToPlaylist(y.getTitle());
				
				}
			
			}
			
		}
		
		return x;
	
	}

	/**
	 * Provided; please don't modify. Loads video information from the specified
	 * file into the database represented by the ArrayList videoDatabase.
	 * 
	 * Information for a video will appear in the file as follows: title, url,
	 * duration and genre (string) each on a line by itself. A line
	 * ("===============================") will mark the end of an entry. The last
	 * entry will also have this line. Do not add empty lines after the line
	 * identifying the end of data.
	 * 
	 * This method relies on the addVideoToDB method to load the data into the
	 * database. Feedback information is printed on the console if requested.
	 * 
	 * @param filename
	 * @return true if data loaded; false otherwise
	 * 
	 *         This method is brought to you by Pepsi, the CS Department and the
	 *         NFAB (National Foundation Against Bugs).
	 */
	public boolean loadVideosToDBFromFile(String filename, boolean printFeedback) {
		Scanner fileScanner;
		try {
			fileScanner = new Scanner(new File(filename));
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			return false;
		}

		int count = 0;
		while (fileScanner.hasNextLine()) {
			String title = fileScanner.nextLine();
			String url = fileScanner.nextLine();
			int durationInMinutes = fileScanner.nextInt();
			fileScanner.nextLine(); // to consume \n
			String genreString = fileScanner.nextLine();
			fileScanner.nextLine(); // gets rid of line marking end of video info

			/* Mapping genre to Genre enum type must match one present in Genre.java */
			Genre videoGenre = null;
			for (Genre genre : Genre.values()) {
				if (genreString.equals(genre.toString())) {
					videoGenre = genre;
					break;
				}
			}
			if (videoGenre == null) {
				System.err.println("Invalid genre found while loading data");
				System.exit(0);
			}

			if (printFeedback) {
				String message = "Loading: " + title + ", ";
				message += url + ", ";
				message += durationInMinutes + ", ";
				message += videoGenre + ", ";
				System.out.println(message);
			}

			addVideoToDB(title, url, durationInMinutes, videoGenre);
			count++;
		}

		if (printFeedback) {
			System.out.println("Video entries loaded: " + count);
		}

		return true;
	}

	/**
	 * Provided; please don't modify. Statistics about video database and playlists
	 * 
	 * @return string with statistics
	 */
	public String getStats() {
		String answer = "***** Statistics *****\n";

		answer += "Number of video entries: " + videoDatabase.size() + "\n";
		answer += "Number of playlists: " + playlists.size() + "\n";

		for (Genre genre : Genre.values()) {
			int count = 0;
			for (Video video : videoDatabase) {
				if (genre.equals(video.getGenre())) {
					count++;
				}
			}
			answer += "Genre \"" + genre + "\" count " + count + "\n";
		}

		return answer;
	}

	/**
	 * Provided; please don't modify. Generates HTML for the specified playlist in
	 * the specified file. An IllegalArgumentException will be thrown if any
	 * parameter is null or if the playlist does not exist.
	 */
	public void genHTMLForPlaylist(String filename, String playlistName, boolean printFeedback) {
		Playlist playlist;
		String htmlBody = "";

		if (playlistName == null || playlistName.isBlank() || (playlist = findPlayListInternal(playlistName)) == null) {
			throw new IllegalArgumentException("TubeVideosManager genHTMLForPlaylist: Invalid parameter(s)");
		}
		htmlBody += "<h2>Playlist: " + playlistName + "</h2>\n";
		for (String title : playlist.getPlaylistVideosTitles()) {
			String url = findVideo(title).getUrl();

			htmlBody += "<strong>" + title + "</strong><br>";
			htmlBody += "<iframe width=\"100\" height=\"100\" ";
			htmlBody += "src=" + "\"" + url + "\">" + "</iframe><br><br>";
		}
		generateHTMLPageWithBody(filename, htmlBody, printFeedback);
	}

	/* ***** Private methods ***** */
	
	/* Returns reference to playlist if found and null otherwise. You must implement
	 * and use this method.  Feel free to use it during the implementation of other
	 * methods.
	 */
	private Playlist findPlayListInternal(String playlistName) {
		
		Playlist playlistFound = null;
		
		if (playlistName == null || playlistName.isBlank()) {
			throw new IllegalArgumentException("TubeVideosManager findPlaylistInternal: Invalid parameter(s)");
		}

		for(Playlist x : this.playlists) {
			
			if(x.getName().equals(playlistName)) {
				
				playlistFound = x;
				
			}
			
		}
		
		return playlistFound;
	
	}

	/*
	 * Provided; please don't modify. Generates full HTML document using body
	 * parameter as HTML document body.
	 */
	private static void generateHTMLPageWithBody(String filename, String body, boolean printFeedback) {
		String page = "<!doctype html>\n";

		page += "<html lang=\"en\">\n";
		page += "<head>\n";
		page += "<title>Manager</title>\n";
		page += "<meta charset=\"utf-8\" />\n";
		page += "</head>\n";
		page += "<body>\n";
		page += body + "\n";
		page += "</body>\n";
		page += "</html>\n";

		writeStringToFile(filename, page);
		if (printFeedback) {
			System.out.println(
					filename + " has been created (You may need to refresh the Eclipse project to see the file).");
		}
	}

	/*
	 * Provided; please don't modify.
	 * 
	 * Writes a string to a file
	 */
	private static boolean writeStringToFile(String filename, String data) {
		try {
			FileWriter output = new FileWriter(filename);
			output.write(data);
			output.close();
		} catch (IOException exception) {
			System.err.println("ERROR: Writing to file " + filename + " failed.");
			return false;
		}
		return true;
	}
}
