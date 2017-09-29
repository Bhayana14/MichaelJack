package demo.frap.michaeljacksonapp.Model;

/**
 * Created by Ramandeep on 9/27/17.
 */

public class TrackListModel {

    String artistName;
    String trackName;
    String collectionCensoredName;
    String trackCensoredName;
    String trackPrice;
    String currency;
    String primaryGenreName;
    String releaseDate;
    String artistPic;
    String song;

    public String getArtistName() {
        return artistName;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public String getCollectionCensoredName() {
        return collectionCensoredName;
    }

    public String getCurrency() {
        return currency;
    }

    public String getPrimaryGenreName() {
        return primaryGenreName;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getTrackCensoredName() {
        return trackCensoredName;
    }

    public String getTrackName() {
        return trackName;
    }

    public String getTrackPrice() {
        return trackPrice;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public void setCollectionCensoredName(String collectionCensoredName) {
        this.collectionCensoredName = collectionCensoredName;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setPrimaryGenreName(String primaryGenreName) {
        this.primaryGenreName = primaryGenreName;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setTrackCensoredName(String trackCensoredName) {
        this.trackCensoredName = trackCensoredName;
    }

    public void setTrackName(String trackName) {
        this.trackName = trackName;
    }

    public void setTrackPrice(String trackPrice) {
        this.trackPrice = trackPrice;
    }

    public String getArtistPic() {
        return artistPic;
    }

    public void setArtistPic(String artistPic) {
        this.artistPic = artistPic;
    }
}
