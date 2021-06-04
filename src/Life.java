public class Life {
    private int lives;

    public Life(){
        lives = 3;
    }

    public int getLives(){
        return lives;
    }

    public void reduceLife(){
        lives--;
    }

    public void addLife(){
        lives++;
    }
}
