import java.util.Scanner;

public class MusicCollection {
    private static Scanner input = new Scanner(System.in);

    public static void albumOptions(Album albumName) {
        System.out.println("[0] Add Song");
        System.out.println("[1] Go Back");
        System.out.print(">>> ");

        int number = input.nextInt();
        input.nextLine();
        if (number == 1) {
            return;
        }
        if (number == 0) {
            System.out.print("Enter title, artist[, genre]: ");
            String[] myStringArray = input.nextLine().split(",");

            if (myStringArray.length == 3) {
                String temporaryHolder1 = myStringArray[0].trim();
                String temporaryHolder2 = myStringArray[1].trim();
                String temporaryHolder3 = myStringArray[2].trim();
                Song newSongList = new Song(temporaryHolder1,
                        temporaryHolder2, temporaryHolder3);
                albumName.addSong(newSongList);
            } else {
                String temporaryHolder1 = myStringArray[0].trim();
                String temporaryHolder2 = myStringArray[1].trim();
                Song newSongList = new Song(temporaryHolder1, temporaryHolder2);
                albumName.addSong(newSongList);
            }
        }
    }

    public static void main(String[] args) {
        Album album1 = new Album("Graduation", "Kanye West");
        Album album2 = new Album("Looking 4 Myself", "Usher");
        Album album3 = new Album("Only One Flo (Part 1)", "Flo Rida");

        Song song1 = new Song("Stronger", "Kanye West", "Hip Hop");
        Song song2 = new Song("Scream", "Usher", "dance-pop");
        Song song3 = new Song("Club Can't Handle Me", "Flo Rida", "Hip house");

        album1.addSong(song1);
        album2.addSong(song2);
        album3.addSong(song3);

        int count = 0;
        while (count != -1) {
            System.out.println("[0] " + album1.getTitle()
                + " - " + album1.getArtist());
            System.out.println("[1] " + album2.getTitle()
                   + " - " + album2.getArtist());
            System.out.println("[2] " + album3.getTitle()
                   + " - " + album3.getArtist());
            System.out.print("\n");
            System.out.println("Select an album or choose -1 to quit: ");
            System.out.print(">>> ");
            count = Integer.parseInt(input.nextLine());
            if (count == 0) {
                System.out.println(album1);
                albumOptions(album1);
            }
            if (count == 1) {
                System.out.println(album2);
                albumOptions(album2);
            }
            if (count == 2) {
                System.out.println(album3);
                albumOptions(album3);
            }
        }
    }
}
