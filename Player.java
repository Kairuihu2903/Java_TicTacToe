public class Player{
    private char mark;
    private String name;

    // constructor
    public Player(char mark, String name){
        // Initialize player with mark and name
        this.mark = mark;
        this.name = name;
    }

    // getter for mark
    public char getMark(){
        return mark;
    }
    //getter for name
    public String getName(){
        return name;
    }

}