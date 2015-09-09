package self.philbrown.gsonparceable;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.Gson;

import java.lang.reflect.Array;

/**
 * TODO Description
 *
 * @author Phil Brown
 * @since 1:27 PM Aug 14, 2015
 */
public abstract class GsonCreator<T extends GsonParcelable> implements Parcelable.Creator<T> {

    private Class<T> clazz;

    public GsonCreator(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public T createFromParcel(Parcel parcel) {
        return getGson().fromJson(parcel.readString(), clazz);
    }

    @Override
    public T[] newArray(int size) {
        return (T[]) Array.newInstance(clazz, size);
    }

    public abstract Gson getGson();
}
