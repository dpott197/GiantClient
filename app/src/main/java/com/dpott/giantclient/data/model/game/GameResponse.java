
package com.dpott.giantclient.data.model.game;

import android.os.Parcel;
import android.os.Parcelable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "error",
    "limit",
    "offset",
    "number_of_page_results",
    "number_of_total_results",
    "status_code",
    "results",
    "version"
})
public class GameResponse implements Parcelable
{

    @JsonProperty("error")
    private String error;
    @JsonProperty("limit")
    private int limit;
    @JsonProperty("offset")
    private int offset;
    @JsonProperty("number_of_page_results")
    private int numberOfPageResults;
    @JsonProperty("number_of_total_results")
    private int numberOfTotalResults;
    @JsonProperty("status_code")
    private int statusCode;
    @JsonProperty("results")
    private Results results;
    @JsonProperty("version")
    private String version;
    public final static Creator<GameResponse> CREATOR = new Creator<GameResponse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public GameResponse createFromParcel(Parcel in) {
            GameResponse instance = new GameResponse();
            instance.error = ((String) in.readValue((String.class.getClassLoader())));
            instance.limit = ((int) in.readValue((int.class.getClassLoader())));
            instance.offset = ((int) in.readValue((int.class.getClassLoader())));
            instance.numberOfPageResults = ((int) in.readValue((int.class.getClassLoader())));
            instance.numberOfTotalResults = ((int) in.readValue((int.class.getClassLoader())));
            instance.statusCode = ((int) in.readValue((int.class.getClassLoader())));
            instance.results = ((Results) in.readValue((Results.class.getClassLoader())));
            instance.version = ((String) in.readValue((String.class.getClassLoader())));
            return instance;
        }

        public GameResponse[] newArray(int size) {
            return (new GameResponse[size]);
        }

    }
    ;

    @JsonProperty("error")
    public String getError() {
        return error;
    }

    @JsonProperty("error")
    public void setError(String error) {
        this.error = error;
    }

    @JsonProperty("limit")
    public int getLimit() {
        return limit;
    }

    @JsonProperty("limit")
    public void setLimit(int limit) {
        this.limit = limit;
    }

    @JsonProperty("offset")
    public int getOffset() {
        return offset;
    }

    @JsonProperty("offset")
    public void setOffset(int offset) {
        this.offset = offset;
    }

    @JsonProperty("number_of_page_results")
    public int getNumberOfPageResults() {
        return numberOfPageResults;
    }

    @JsonProperty("number_of_page_results")
    public void setNumberOfPageResults(int numberOfPageResults) {
        this.numberOfPageResults = numberOfPageResults;
    }

    @JsonProperty("number_of_total_results")
    public int getNumberOfTotalResults() {
        return numberOfTotalResults;
    }

    @JsonProperty("number_of_total_results")
    public void setNumberOfTotalResults(int numberOfTotalResults) {
        this.numberOfTotalResults = numberOfTotalResults;
    }

    @JsonProperty("status_code")
    public int getStatusCode() {
        return statusCode;
    }

    @JsonProperty("status_code")
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    @JsonProperty("results")
    public Results getResults() {
        return results;
    }

    @JsonProperty("results")
    public void setResults(Results results) {
        this.results = results;
    }

    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(error);
        dest.writeValue(limit);
        dest.writeValue(offset);
        dest.writeValue(numberOfPageResults);
        dest.writeValue(numberOfTotalResults);
        dest.writeValue(statusCode);
        dest.writeValue(results);
        dest.writeValue(version);
    }

    public int describeContents() {
        return  0;
    }

}
