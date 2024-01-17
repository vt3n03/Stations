public class Station {

    //Instance variables
    private static int nextID = 0;
    private int id;
    private int stnNo;
    private String name;
    private Station prev;
    private Station next;
    private int x;
    private int y;

    //Constrctor
    public Station(int stnNo, String stnName, int x, int y) {
        this.stnNo = stnNo;
        this.name = stnName;
        this.x = x;
        this.y = y;
        prev = next = null;
        this.id = nextID;
        nextID++;
    }

    //Getters Setters
    public int getId() {
        return id;
    }

    public int getStnNo() {
        return stnNo;
    }

    public String getName() {
        return name;
    }

    public Station getPrev() {
        return prev;
    }

    public Station getNext() {
        return next;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setPrev(Station prev) {
        this.prev = prev;
    }

    public void setNext(Station next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Stn: " + stnNo + " (" + name + ")";
    }

}