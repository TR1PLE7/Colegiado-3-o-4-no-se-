
import java.util.Random;

import javax.swing.JOptionPane;

public class SongInformation {

    // Private attributes for added security and to avoid errors
    private int songID = 0;
    private int songYear = 0;
    private Double duration = 0.0;
    private String songName = "";
    private String songAuthor = "";

    // Get the number of entities to save
    int entities = Integer.parseInt(JOptionPane.showInputDialog(null, "HOW MANY ENTITIES DO YOU WANT TO SAVE?", "SONG", JOptionPane.QUESTION_MESSAGE));

    SongInformation[] dataSong = new SongInformation[entities];

    public SongInformation(int songID, String songName, String songAuthor, Double duration, int songYear) {
        this.songAuthor = songAuthor;
        this.songName = songName;
        this.songID = songID;
        this.songYear = songYear;
        this.duration = duration;
    }
    public void mostrarAlerta() {
        JOptionPane optionPane = new JOptionPane("!THANKS FOR LISTEN SPOTIFY!");
        Object[] options = { "CONTINUE" };
        optionPane.setOptions(options);
        optionPane.setInitialValue(options[0]);


        JOptionPane.showOptionDialog(null, "DO YOU WANT SPOTIFY PREMIUN?!", "SPORTIFY %",
                JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);

}

    // Setters and getters for easy information handling
    public void setSongID() {
        Random random = new Random();
        songID = random.nextInt(10000);
    }

    public int getSongID() {
        return songID;
    }

    public void setSongName() {
        songName = JOptionPane.showInputDialog("Enter the song title: ");
    }

    public String getSongName() {
        return this.songName;
    }

    public void setSongAuthor() {
        songAuthor = JOptionPane.showInputDialog("Enter the song author: ");
    }

    public String getSongAuthor() {
        return this.songAuthor;
    }

    public void setDuration() {
        duration = Double.parseDouble(JOptionPane.showInputDialog("Enter the song duration: "));
    }

    public double getDuration() {
        return this.duration;
    }

    public void setSongYear() {
        songYear = Integer.parseInt(JOptionPane.showInputDialog("Enter the song year (e.g., 2012): "));
    }

    public int getSongYear() {
        return this.songYear;
    }

    // Function to save the data
    public void setSaveData() {
        for (int i = 0; i < entities; i++) {
            setSongID();
            setSongAuthor();
            setSongName();
            setSongYear();
            setDuration();
            mostrarAlerta();
            // Create a new SongInformation object with the entered data and add it to the array.

            dataSong[i] = new SongInformation(getSongID(), getSongName(), getSongAuthor(), getDuration(), getSongYear());
        }
    }

    // Function to display song information as requested
    public void showSongs() {
        int currentYear = 2023;
        double maxDuration = 0.0;
        int longestSongIndex = -1;

        for (int i = 0; i < entities; i++) {
            SongInformation song = dataSong[i];
            JOptionPane.showMessageDialog(null, song.toString());

            int songYear = song.getSongYear();
            if (songYear < currentYear) {
                JOptionPane.showMessageDialog(null, "This song was released before the current year: " + song);
            } else if (songYear == currentYear) {
                JOptionPane.showMessageDialog(null, "This song was released in the current year: " + song);
            } else {
                JOptionPane.showMessageDialog(null, "This song was released after the current year: " + song);
            }

            double songDuration = song.getDuration();
            if (songDuration > maxDuration) {
                maxDuration = songDuration;
                longestSongIndex = i;
            }
        }

        JOptionPane.showMessageDialog(null, "Song with the longest duration: " + dataSong[longestSongIndex]);
        JOptionPane.showMessageDialog(null, "Song at position 1: " + dataSong[0]);

        

    }
}