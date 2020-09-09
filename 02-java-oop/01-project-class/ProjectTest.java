public class ProjectTest {
    public static void main(String[] args) {
        Project projectTestOne = new Project();
        projectTestOne.setName("Dovakin");
        projectTestOne.setDescription("The mythic journey of the Dragonborn, going about the world and bring peace and balance to Skyrim.");
        System.out.println(projectTestOne.getName());
        System.out.println(projectTestOne.getDescription());
        System.out.println(projectTestOne.elevatorPitch());

        Project projectTestTwo = new Project("Link");
        projectTestTwo.setDescription("A young man discovers he is the chosen hero of time and light, and must use his courage to overcome the darkness and save the world.");
        System.out.println(projectTestTwo.getName());
        System.out.println(projectTestTwo.getDescription());
        System.out.println(projectTestTwo.elevatorPitch());

        Project projectTestThree = new Project("Cloud", "An amnesiac discovers that his old military buddy is out for blood and needs to search the world to find himself and his buddy, while confronting the fact that everything in his life is a lie.");
        System.out.println(projectTestThree.getName());
        System.out.println(projectTestThree.getDescription());
        System.out.println(projectTestThree.elevatorPitch());
    }
}