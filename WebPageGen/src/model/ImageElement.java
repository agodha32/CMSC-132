package model;

/**
 * 
 * Represents an <img> tag. For this project you can assume we will not update
 * any of the attributes associated with this tag.
 * 
 * @author UMCP
 *
 */

public class ImageElement extends TagElement {

	private String imageURL;

	/**
	 * 
	 * Initializes object with the provided parameters.
	 * 
	 * @param imageURL
	 * @param width
	 * @param height
	 * @param alt
	 * @param attributes
	 * 
	 */

	public ImageElement(String imageURL, int width, int height, String alt, String attributes) {

		super("img ", " src=\"" + imageURL + "\" width=\"" + width + "\" height=\"" + height
				+ "\" alt=\"" + alt + "\"", false, null);

		this.imageURL = imageURL;
	
	}

	/**
	 * 
	 * Returns the Image URl
	 * 
	 * @return url
	 * 
	 */

	public String getImageURL() {

		return this.imageURL;

	}
	
}
