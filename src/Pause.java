import javafx.scene.image.Image;

public class Pause extends Actor{
    public Pause(){
        String path = getClass().getClassLoader().getResource("resources/Pause.png").toString();
        Image img = new Image(path);
        this.setImage(img);
    }

    @Override
    public void act(long now) {

    }
}
