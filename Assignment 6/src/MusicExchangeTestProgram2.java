import java.util.ArrayList;

public class MusicExchangeTestProgram2 {
    public static void main(String args[]) {
        ArrayList<String> catalog;

        // Create a new music exchange center
        MusicExchangeCenter   mec = new MusicExchangeCenter();

        // Create some users and give them some songs
        User discoStew = User.DiscoStew();
        User sleepingSam = User.SleepingSam();
        User ronnieRocker = User.RonnieRocker();
        User countryCandy = User.CountryCandy();
        User peterPunk = User.PeterPunk();

        // Register the users
        discoStew.register(mec);
        ronnieRocker.register(mec);
        sleepingSam.register(mec);
        countryCandy.register(mec);
        peterPunk.register(mec);

        // Log on all users
        discoStew.logon(mec);
        sleepingSam.logon(mec);
        ronnieRocker.logon(mec);
        countryCandy.logon(mec);
        peterPunk.logon(mec);
        System.out.println("Status: " + mec);

        // Simulate a user requesting a list of songs
        catalog = discoStew.requestCompleteSonglist(mec);
        System.out.println("Complete Song List: ");
        for (String s: catalog)
            System.out.println("  " + s);

        // Simulate a user downloading 3 songs from the list
        System.out.println("\nDisco Stew before downloading: " + discoStew);
        discoStew.downloadSong(mec, "Bite My Arms Off", "Peter Punk");
        discoStew.downloadSong(mec, "Meadows", "Sleeping Sam");
        discoStew.downloadSong(mec, "If I Had a Hammer", "Country Candy");
        discoStew.downloadSong(mec, "Sandy Toes", "Country Candy");
        ronnieRocker.logoff(mec); // log off Ronnie, next download should fail
        discoStew.downloadSong(mec, "Only You Can Rock Me", "Ronnie Rocker");
        System.out.println("Disco Stew after downloading: " + discoStew);

        ronnieRocker.logon(mec); // log on Ronnie, next download should work
        discoStew.downloadSong(mec, "Only You Can Rock Me", "Ronnie Rocker");
        System.out.println("Disco Stew after downloading Ronnie's: " + discoStew + "\n");

        // Simulate a user requesting a list of songs by a specific artist
        catalog = discoStew.requestSonglistByArtist(mec, "Jaw");
        System.out.println("Songs by Jaw: ");
        for (String s: catalog)
            System.out.println("  " + s);
    }
}
