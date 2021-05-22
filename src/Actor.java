import java.util.ArrayList;
import java.util.List;

import javafx.scene.Node;
import javafx.scene.image.ImageView;

public abstract class Actor extends ImageView{
	
	public abstract void act(long now);
	
	public void move(double dx, double dy) {
		this.setX(this.getX() + dx);
		this.setY(this.getY() + dy);
	}
	
	public World getWorld() {
		return (World) this.getParent();
	}

	public double getHeight() {
		return this.getBoundsInParent().getHeight();
	}
	
	public double getWidth() {
		return this.getBoundsInParent().getWidth();
	}
	
	public <A extends Actor> java.util.List<A> getIntersectingObjects(java.lang.Class<A> cls){
		List<A> list = new ArrayList<>();
		
		for(Node node: getWorld().getChildren()) {
			if(this != node && cls.isInstance(node) && node.intersects(getBoundsInLocal())) {
				list.add(cls.cast(node));
			}
		}
		return list;
	}
	
	public <A extends Actor> A getOneIntersectingObject(java.lang.Class<A> cls){
		for(Node node: getWorld().getChildren()) {
			if(this != node && cls.isInstance(node) && node.intersects(getBoundsInLocal())) {
				return cls.cast(node);
			}
		}
		return null;
	}
	
	
}
