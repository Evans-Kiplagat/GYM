package com.example.gym;

import android.os.Parcel;
import android.os.Parcelable;

public class plan implements Parcelable {
    private int minutes;
    private  String day;
    private Model model;
    private Boolean isAccomplished;

    public plan(int minutes, String day, Model model, Boolean isAccomplished) {
        this.minutes = minutes;
        this.day = day;
        this.model = model;
        this.isAccomplished = isAccomplished;
    }

    protected plan(Parcel in) {
        minutes = in.readInt();
        day = in.readString();
        model = in.readParcelable(Model.class.getClassLoader());
        byte tmpIsAccomplished = in.readByte();
        isAccomplished = tmpIsAccomplished == 0 ? null : tmpIsAccomplished == 1;
    }

    public static final Creator<plan> CREATOR = new Creator<plan>() {
        @Override
        public plan createFromParcel(Parcel in) {
            return new plan(in);
        }

        @Override
        public plan[] newArray(int size) {
            return new plan[size];
        }
    };

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Boolean getAccomplished() {
        return isAccomplished;
    }

    public void setAccomplished(Boolean accomplished) {
        isAccomplished = accomplished;
    }

    @Override
    public String toString() {
        return "plan{" +
                "minutes=" + minutes +
                ", day='" + day + '\'' +
                ", model=" + model +
                ", isAccomplished=" + isAccomplished +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(minutes);
        dest.writeString(day);
        dest.writeParcelable(model, flags);
        dest.writeByte((byte) (isAccomplished == null ? 0 : isAccomplished ? 1 : 2));
    }
}
