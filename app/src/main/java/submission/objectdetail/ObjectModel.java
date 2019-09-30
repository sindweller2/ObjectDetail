package submission.objectdetail;

import android.os.Parcel;
import android.os.Parcelable;

public class ObjectModel implements Parcelable {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String name, remark, picture, status, gender, description;

    @Override
    public int describeContents() {
        return 0;
    }
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.remark);
        dest.writeString(this.picture);
        dest.writeString(this.gender);
        dest.writeString(this.status);
        dest.writeString(this.description);
    }

    public ObjectModel() {
    }

    protected ObjectModel(Parcel in) {
        this.name = in.readString();
        this.remark = in.readString();
        this.picture = in.readString();
        this.gender = in.readString();
        this.status = in.readString();
        this.description = in.readString();
    }
    public static final Parcelable.Creator<ObjectModel> CREATOR = new Parcelable.Creator<ObjectModel>() {

        @Override
        public ObjectModel createFromParcel(Parcel source) {
            return new ObjectModel(source);
        }

        @Override
        public ObjectModel[] newArray(int size) {
            return new ObjectModel[size];
        }
    };
}
