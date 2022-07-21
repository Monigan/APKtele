package com.example.apktele.model;

public class Application {
    private Long id;
    private int category;
    private String title;
    private String ico = "tmp";
    private String fullDescription;
    private String shortDescription;
    private String applicationTag;


    public Application(int id, String title, String ico, int category){

    }

    public Application(Long id, String title, String ico, String fullDescription, String shortDescription, int category) {
        this.id = id;
        this.title = title;
        this.ico = ico;
        this.fullDescription = fullDescription;
        this.shortDescription = shortDescription;
        this.applicationTag = setTagToCategory(category);
        this.category = category;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIco() {
        return ico;
    }

    public void setIco(String ico) {
        this.ico = ico;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getApplicationTag() {
        return applicationTag;
    }

    public void setApplicationTag(String applicationTag) {
        this.applicationTag = applicationTag;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    private String setTagToCategory(int category){
        switch (category){
            case 1: return "Other";
            case 2: return "Arcade";
            case 3: return "Business";
            case 4: return "Social";
            case 5: return "Work";
            case 6: return "Sport";
            case 7: return "Simulator";
            case 8: return "Education";
            default: return "Common";
        }
    }

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", category=" + category +
                ", title='" + title + '\'' +
                ", ico='" + ico + '\'' +
                ", fullDescription='" + fullDescription + '\'' +
                ", shortDescription='" + shortDescription + '\'' +
                ", applicationTag='" + applicationTag + '\'' +
                '}';
    }
}
