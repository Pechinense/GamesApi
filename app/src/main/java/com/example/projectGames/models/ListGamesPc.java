
package com.example.projectGames.models;


import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ListGamesPc implements Parcelable
{

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("short_description")
    @Expose
    private String shortDescription;
    @SerializedName("game_url")
    @Expose
    private String gameUrl;
    @SerializedName("genre")
    @Expose
    private String genre;
    @SerializedName("platform")
    @Expose
    private String platform;
    @SerializedName("publisher")
    @Expose
    private String publisher;
    @SerializedName("developer")
    @Expose
    private String developer;
    @SerializedName("release_date")
    @Expose
    private String releaseDate;
    @SerializedName("freetogame_profile_url")
    @Expose
    private String freetogameProfileUrl;
    public final static Creator<ListGamesPc> CREATOR = new Creator<ListGamesPc>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ListGamesPc createFromParcel(android.os.Parcel in) {
            return new ListGamesPc(in);
        }

        public ListGamesPc[] newArray(int size) {
            return (new ListGamesPc[size]);
        }

    }
    ;

    protected ListGamesPc(android.os.Parcel in) {
        this.id = ((int) in.readValue((int.class.getClassLoader())));
        this.title = ((String) in.readValue((String.class.getClassLoader())));
        this.thumbnail = ((String) in.readValue((String.class.getClassLoader())));
        this.shortDescription = ((String) in.readValue((String.class.getClassLoader())));
        this.gameUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.genre = ((String) in.readValue((String.class.getClassLoader())));
        this.platform = ((String) in.readValue((String.class.getClassLoader())));
        this.publisher = ((String) in.readValue((String.class.getClassLoader())));
        this.developer = ((String) in.readValue((String.class.getClassLoader())));
        this.releaseDate = ((String) in.readValue((String.class.getClassLoader())));
        this.freetogameProfileUrl = ((String) in.readValue((String.class.getClassLoader())));
    }

    /**
     * No args constructor for use in serialization
     * 
     */
    public ListGamesPc() {
    }

    /**
     * 
     * @param thumbnail
     * @param releaseDate
     * @param genre
     * @param publisher
     * @param gameUrl
     * @param developer
     * @param id
     * @param shortDescription
     * @param title
     * @param platform
     * @param freetogameProfileUrl
     */
    public ListGamesPc(int id, String title, String thumbnail, String shortDescription, String gameUrl, String genre, String platform, String publisher, String developer, String releaseDate, String freetogameProfileUrl) {
        super();
        this.id = id;
        this.title = title;
        this.thumbnail = thumbnail;
        this.shortDescription = shortDescription;
        this.gameUrl = gameUrl;
        this.genre = genre;
        this.platform = platform;
        this.publisher = publisher;
        this.developer = developer;
        this.releaseDate = releaseDate;
        this.freetogameProfileUrl = freetogameProfileUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ListGamesPc withId(int id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ListGamesPc withTitle(String title) {
        this.title = title;
        return this;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public ListGamesPc withThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
        return this;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public ListGamesPc withShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
        return this;
    }

    public String getGameUrl() {
        return gameUrl;
    }

    public void setGameUrl(String gameUrl) {
        this.gameUrl = gameUrl;
    }

    public ListGamesPc withGameUrl(String gameUrl) {
        this.gameUrl = gameUrl;
        return this;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public ListGamesPc withGenre(String genre) {
        this.genre = genre;
        return this;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public ListGamesPc withPlatform(String platform) {
        this.platform = platform;
        return this;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public ListGamesPc withPublisher(String publisher) {
        this.publisher = publisher;
        return this;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public ListGamesPc withDeveloper(String developer) {
        this.developer = developer;
        return this;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public ListGamesPc withReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    public String getFreetogameProfileUrl() {
        return freetogameProfileUrl;
    }

    public void setFreetogameProfileUrl(String freetogameProfileUrl) {
        this.freetogameProfileUrl = freetogameProfileUrl;
    }

    public ListGamesPc withFreetogameProfileUrl(String freetogameProfileUrl) {
        this.freetogameProfileUrl = freetogameProfileUrl;
        return this;
    }

    public void writeToParcel(android.os.Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(title);
        dest.writeValue(thumbnail);
        dest.writeValue(shortDescription);
        dest.writeValue(gameUrl);
        dest.writeValue(genre);
        dest.writeValue(platform);
        dest.writeValue(publisher);
        dest.writeValue(developer);
        dest.writeValue(releaseDate);
        dest.writeValue(freetogameProfileUrl);
    }

    public int describeContents() {
        return  0;
    }

}
