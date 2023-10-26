package model;

import java.util.ArrayList;
import java.util.List;

public class Gallery {

    private final List<Photo> photos = new ArrayList<>();

    public void addPhoto(Photo photo) {
        photos.add(photo);
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void clear() {
        photos.clear();
    }
}
