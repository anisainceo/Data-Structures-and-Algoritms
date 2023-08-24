public class Pen { 
    private String name;
    private String type;
    public Pen(String name, String type) {
        this.name = name;
        this.type = type;
    }
    @Override
    public String toString() {
        return "(N: " +name+ ", T: " +type+ ")";
    }
}