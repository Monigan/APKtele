package com.example.apktele.dto;

public class AplicationDTO {
    private Long id;
    private String name;
    private String path_file;
    private String description;
    private Double rating;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath_file() {
        return path_file;
    }

    public void setPath_file(String path_file) {
        this.path_file = path_file;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "AplicationDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", path_file='" + path_file + '\'' +
                ", description='" + description + '\'' +
                ", rating=" + rating +
                '}';
    }
}
