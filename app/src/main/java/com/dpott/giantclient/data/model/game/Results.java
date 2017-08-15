
package com.dpott.giantclient.data.model.game;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "images"
})
public class Results implements Parcelable
{

    @JsonProperty("name")
    private String name;
    @JsonProperty("images")
    private List<Image> images = new ArrayList<Image>();
    public final static Creator<Results> CREATOR = new Creator<Results>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Results createFromParcel(Parcel in) {
            Results instance = new Results();
            instance.name = ((String) in.readValue((String.class.getClassLoader())));
            in.readList(instance.images, (Image.class.getClassLoader()));
            return instance;
        }

        public Results[] newArray(int size) {
            return (new Results[size]);
        }

    }
    ;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("images")
    public List<Image> getImages() {
        return images;
    }

    @JsonProperty("images")
    public void setImages(List<Image> images) {
        this.images = images;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(name);
        dest.writeList(images);
    }

    public int describeContents() {
        return  0;
    }

}
