/**
 * 
 */
package liaody.controller;

/**
* <p>Title:MyMedia </p>
* <p>Description: </p>
* <p>Company: </p>
* @author liaody
* @date 2017Äê7ÔÂ20ÈÕ
*/
public class MyMedia {
	
	private String mediaName;
	private String mediaType;
	private long mediaSize;
	
	public MyMedia () {
		
	}

	public MyMedia(String mediaName,String  mediaType,long mediaSize) {
		this.mediaName = mediaName;
		this.mediaType = mediaType;
		this.mediaSize = mediaSize;
	}
	
	/**
	 * @return the mediaName
	 */
	public String getMediaName() {
		return mediaName;
	}

	/**
	 * @param mediaName the mediaName to set
	 */
	public void setMediaName(String mediaName) {
		this.mediaName = mediaName;
	}

	/**
	 * @return the mediaType
	 */
	public String getMediaType() {
		return mediaType;
	}

	/**
	 * @param mediaType the mediaType to set
	 */
	public void setMediaType(String mediaType) {
		this.mediaType = mediaType;
	}

	/**
	 * @return the mediaSize
	 */
	public long getMediaSize() {
		return mediaSize;
	}

	/**
	 * @param mediaSize the mediaSize to set
	 */
	public void setMediaSize(long mediaSize) {
		this.mediaSize = mediaSize;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MyMedia [mediaName=" + mediaName + ", mediaType=" + mediaType + ", mediaSize=" + mediaSize + "]";
	}
	

}
