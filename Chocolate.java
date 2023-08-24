public class Chocolate {
    private String name;
    private String type;
    public Chocolate(String name, String type) {
        this.name = name;
        this.type = type;
    }
    @Override
    public String toString() {
        return "(N: " + name + ", T: " + type+")";
    }
}