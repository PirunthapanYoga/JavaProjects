public class Node {
    Boolean duplicate;
    String name;

    public Node(String name) {
        duplicate = false;
        this.name = name;
    }

    public void setDuplicate (){
        this.duplicate=true;
    }

    public String getName() {
        return name;
    }

    public Boolean getDuplicate() {
        return duplicate;
    }

}
