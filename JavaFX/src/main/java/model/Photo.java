package model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;

import java.io.ByteArrayInputStream;
import java.util.UUID;

public class Photo {

    private final StringProperty name;

    private final ObjectProperty<Image> photoData;

    public Photo(String extension, byte[] photoData) {
        this.photoData = new SimpleObjectProperty<>(new Image(new ByteArrayInputStream(photoData)));
        this.name = new SimpleStringProperty(UUID.randomUUID() + "." + extension);
    }

    public String getName() {
        return this.name.getName();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public Image getPhotoData() {
        return photoData.get();
    }

    public StringProperty getNameProperty() {
        return name;
    }

    public ObjectProperty<Image> getPhotoProperty() {
        return photoData;
    }
}
