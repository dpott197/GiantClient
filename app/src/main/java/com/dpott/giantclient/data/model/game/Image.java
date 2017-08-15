
package com.dpott.giantclient.data.model.game;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "icon_url",
    "medium_url",
    "screen_url",
    "small_url",
    "super_url",
    "thumb_url",
    "tiny_url",
    "tags"
})
public class Image implements Parcelable
{

    @JsonProperty("icon_url")
    private String iconUrl;
    @JsonProperty("medium_url")
    private String mediumUrl;
    @JsonProperty("screen_url")
    private String screenUrl;
    @JsonProperty("small_url")
    private String smallUrl;
    @JsonProperty("super_url")
    private String superUrl;
    @JsonProperty("thumb_url")
    private String thumbUrl;
    @JsonProperty("tiny_url")
    private String tinyUrl;
    @JsonProperty("tags")
    private String tags;
    public final static Creator<Image> CREATOR = new Creator<Image>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Image createFromParcel(Parcel in) {
            Image instance = new Image();
            instance.iconUrl = ((String) in.readValue((String.class.getClassLoader())));
            instance.mediumUrl = ((String) in.readValue((String.class.getClassLoader())));
            instance.screenUrl = ((String) in.readValue((String.class.getClassLoader())));
            instance.smallUrl = ((String) in.readValue((String.class.getClassLoader())));
            instance.superUrl = ((String) in.readValue((String.class.getClassLoader())));
            instance.thumbUrl = ((String) in.readValue((String.class.getClassLoader())));
            instance.tinyUrl = ((String) in.readValue((String.class.getClassLoader())));
            instance.tags = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public Image[] newArray(int size) {
            return (new Image[size]);
        }

    }
    ;

    @JsonProperty("icon_url")
    public String getIconUrl() {
        return iconUrl;
    }

    @JsonProperty("icon_url")
    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    @JsonProperty("medium_url")
    public String getMediumUrl() {
        return mediumUrl;
    }

    @JsonProperty("medium_url")
    public void setMediumUrl(String mediumUrl) {
        this.mediumUrl = mediumUrl;
    }

    @JsonProperty("screen_url")
    public String getScreenUrl() {
        return screenUrl;
    }

    @JsonProperty("screen_url")
    public void setScreenUrl(String screenUrl) {
        this.screenUrl = screenUrl;
    }

    @JsonProperty("small_url")
    public String getSmallUrl() {
        return smallUrl;
    }

    @JsonProperty("small_url")
    public void setSmallUrl(String smallUrl) {
        this.smallUrl = smallUrl;
    }

    @JsonProperty("super_url")
    public String getSuperUrl() {
        return superUrl;
    }

    @JsonProperty("super_url")
    public void setSuperUrl(String superUrl) {
        this.superUrl = superUrl;
    }

    @JsonProperty("thumb_url")
    public String getThumbUrl() {
        return thumbUrl;
    }

    @JsonProperty("thumb_url")
    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
    }

    @JsonProperty("tiny_url")
    public String getTinyUrl() {
        return tinyUrl;
    }

    @JsonProperty("tiny_url")
    public void setTinyUrl(String tinyUrl) {
        this.tinyUrl = tinyUrl;
    }

    @JsonProperty("tags")
    public String getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(String tags) {
        this.tags = tags;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(iconUrl);
        dest.writeValue(mediumUrl);
        dest.writeValue(screenUrl);
        dest.writeValue(smallUrl);
        dest.writeValue(superUrl);
        dest.writeValue(thumbUrl);
        dest.writeValue(tinyUrl);
        dest.writeValue(tags);
    }

    public int describeContents() {
        return  0;
    }

}
