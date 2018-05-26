package com.noisyninja.androidlistpoc.model;

import android.arch.persistence.room.TypeConverter;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.noisyninja.androidlistpoc.R;
import com.squareup.picasso.Picasso;

import java.lang.reflect.Type;
import java.util.List;

/**
 * data binding converters
 * Created by sudiptadutta on 12/05/18.
 */

public class DataConverter {

    @BindingAdapter("thumbnail")
    public static void loadImage(final ImageView view, final String imageUrl) {
        Picasso.with(view.getContext())
                .load(imageUrl)
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher_round)
                .fit()
                .into(view);

    }

    @TypeConverter
    public String fromName(Name name) {
        if (name == null) {
            return (null);
        }
        Gson gson = new Gson();
        return gson.toJson(name);
    }

    @TypeConverter
    public Name toName(String nameString) {
        if (nameString == null) {
            return (null);
        }
        Gson gson = new Gson();
        return gson.fromJson(nameString, Name.class);
    }

    @TypeConverter
    public String fromPicture(Picture picture) {
        if (picture == null) {
            return (null);
        }
        Gson gson = new Gson();
        return gson.toJson(picture);
    }

    @TypeConverter
    public Picture toPicture(String pictureString) {
        if (pictureString == null) {
            return (null);
        }
        Gson gson = new Gson();
        return gson.fromJson(pictureString, Picture.class);
    }

    @TypeConverter
    public String fromPictureList(List<Picture> pictureList) {
        if (pictureList == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Picture>>() {
        }.getType();
        return gson.toJson(pictureList, type);
    }

    @TypeConverter
    public List<Picture> toPictureList(String pictureListString) {
        if (pictureListString == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<Picture>>() {
        }.getType();
        return gson.fromJson(pictureListString, type);
    }
}
