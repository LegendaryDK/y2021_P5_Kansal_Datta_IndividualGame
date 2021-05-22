import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.lang.Object;

import javafx.animation.AnimationTimer;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;

public abstract class World extends Pane{
	
	private AnimationTimer timer;
	private World world = this;
	private HashSet<KeyCode> keys;
	
	public World() {
		//List<Actor> actor = this.getChildren();
		timer = new AnimationTimer(){
			@Override
			public void handle(long now) {
				world.act(now);
				for(Node actor: world.getChildren()) {
					if(actor instanceof Actor) {
						((Actor) actor).act(now);
					}
				}
			}
		};
		keys = new HashSet<>();
	}
	
	public abstract void act(long now);

	public void addKey(KeyCode key){
		keys.add(key);
	}

	public void removeKey(KeyCode key){
		keys.remove(key);
	}

	public boolean isKeyDown(KeyCode key){
		if(keys.contains(key)) return true;
		return false;
	}

	public HashSet<KeyCode> getKeys(){
		return keys;
	}

	public void add(Actor actor) {
		this.getChildren().add(actor);
	}
	
	public void remove(Actor actor) {
		this.getChildren().remove(actor);
	}
	
	public void start() {
		timer.start();
	}
	
	public void stop() {
		timer.stop();
	}
	
	public <A extends Actor> java.util.List<A> getObjects(java.lang.Class<A> cls){
		List<A> list = new ArrayList<>();
		
		for(Node node: this.getChildren()) {
			if(cls.isInstance(node)) {
				list.add(cls.cast(node));
			}
		}
		return list;
	}

}
