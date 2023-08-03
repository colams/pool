package cn.colams.common.dto.airbnb.common;

import java.util.List;

public class Errors {


    private String message;
    private List<Locations> locations;
    private List<String> path;
    private Extensions extensions;

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setLocations(List<Locations> locations) {
        this.locations = locations;
    }

    public List<Locations> getLocations() {
        return locations;
    }

    public void setPath(List<String> path) {
        this.path = path;
    }

    public List<String> getPath() {
        return path;
    }

    public void setExtensions(Extensions extensions) {
        this.extensions = extensions;
    }

    public Extensions getExtensions() {
        return extensions;
    }
}
