public class Album {
    private String title;
    private String artist;
    private Song[] songs = new Song[1];
    private int numSongs;

    public Album(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }
    public String getTitle() {
        return title;
    }
    public String getArtist() {
        return artist;
    }
    public int getnumSongs() {
        return numSongs;
    }
    public Song[] getSongs() {
        return songs;
    }

    public void addSong(Song s) {
        if (songs.length > numSongs) {
            songs[numSongs] = s;
        } else {
            Song[] temporary = new Song[2 * songs.length];
            for (int i = 0; i < songs.length; i++) {
                temporary[i] = songs[i];
            }
            songs = temporary;
            songs[numSongs] = s;
        }
        numSongs++;
    }

    public String toString() {
        String output = title + " - " + artist;
        int i = 0;
        while (i < numSongs) {
            output += "\n\t\t" + songs[i];
            i++;
        }
        return output;
    }
}
