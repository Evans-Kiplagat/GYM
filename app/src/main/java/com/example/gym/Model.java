package com.example.gym;


import android.os.Parcel;
import android.os.Parcelable;

public class Model  implements Parcelable {
    private int id;
    private String Title;
    private String londescr;
    private String shortdescr;
    private String imageUrl;

    public Model(int id, String title, String londescr, String shortdescr, String imageUrl) {
        this.id = id;
        Title = title;
        this.londescr = londescr;
        this.shortdescr = shortdescr;
        this.imageUrl = imageUrl;
    }


    protected Model(Parcel in) {
        id = in.readInt();
        Title = in.readString();
        londescr = in.readString();
        shortdescr = in.readString();
        imageUrl = in.readString();
    }

    public static final Creator<Model> CREATOR = new Creator<Model>() {
        @Override
        public Model createFromParcel(Parcel in) {
            return new Model(in);
        }

        @Override
        public Model[] newArray(int size) {
            return new Model[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getLondescr() {
        return londescr;
    }

    public void setLondescr(String londescr) {
        this.londescr = londescr;
    }

    public String getShortdescr() {
        return shortdescr;
    }

    public void setShortdescr(String shortdescr) {
        this.shortdescr = shortdescr;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Model{" +
                "id=" + id +
                ", Title='" + Title + '\'' +
                ", londescr='" + londescr + '\'' +
                ", shortdescr='" + shortdescr + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(Title);
        dest.writeString(londescr);
        dest.writeString(shortdescr);
        dest.writeString(imageUrl);
    }
}
