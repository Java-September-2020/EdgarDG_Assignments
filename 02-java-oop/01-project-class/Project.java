public class Project {
    //Init Fields
    private String name;
    private String description;

    //Methods
    public String elevatorPitch() {
        return name + " : " + description;
    }

    //Constructors
    public Project() {
    }
    public Project(String name) {
        this.name = name;
    }
    public Project(String name, String description) {
        this.name = name;
        this.description = description;
    }

    //Getters and Setters
    public String getName() {
        return this.name;
    }
    public String getDescription() {
        return this.description;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }

}