public class Song {
    private String      title;
    private String      artist;
    private int         duration;
    private User        owner;
    private int         downloads;

    public Song()  {
        this("", "", 0, 0);
    }

    public Song(String t, String a, int m, int s)  {
        title = t;
        artist = a;
        duration = m * 60 + s;
        owner = null;
        downloads = 0;
    }

    public String getTitle() { return title; }
    public String getArtist() { return artist; }
    public int getDuration() { return duration; }
    public User getOwner() { return owner; }
    public int getDownloads() { return downloads; }

    public void setDownloads(int downloads) {
        this.downloads = downloads;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public int getMinutes() {
        return duration / 60;
    }

    public int getSeconds() {
        return duration % 60;
    }

    public String toString()  {
        return("\"" + title + "\" by " + artist + " " + (duration / 60) + ":" + (duration%60));
    }
}