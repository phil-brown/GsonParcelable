package self.philbrown.gsonparceable;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * superclass for simple Parceling with Gson
 *
 * @author Phil Brown
 * @since 1:26 PM Aug 14, 2015
 */
public abstract class GsonParcelable implements Parcelable {

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(getCREATOR().getGson().toJson(this));
    }

    public abstract GsonCreator getCREATOR();
}
