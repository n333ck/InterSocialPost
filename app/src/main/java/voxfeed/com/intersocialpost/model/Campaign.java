
package voxfeed.com.intersocialpost.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Campaign {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("coverImage")
    @Expose
    private String coverImage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

}
