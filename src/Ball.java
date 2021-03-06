import javafx.scene.image.Image;

public class Ball extends Actor {
	
	private double dx;
	private double dy;
	
	public Ball() {
		String path = getClass().getClassLoader().getResource("resources/ball.png").toString();
		Image img = new Image(path);
		this.setImage(img);
		int change = (Math.random() > 0.5) ? 1 : -1;
		dx = ((Math.random() * 3) + 2.5) * change;
		dy = ((Math.random() * 2) + 1.5) * change;
//		dx = 3.5;
//		dy = -2;
	}


	@Override
	public void act(long now) {
		// TODO Auto-generated method stub
		this.move(dx, dy);
		if(getX() <= 0) {
			dx = -dx;
		}
		if(getX() + getWidth() >= getWorld().getWidth()) {
			dx = -dx;
		}
		
		if(getY() <= 0) {
			dy = -dy;
		}
		if(getY() + getHeight() >= getWorld().getHeight()) {
			dy = -dy;
			Score obj = ((BallWorld) getWorld()).getScore();
			int tempScore = obj.getScoreCount();
			obj.setScore(tempScore - 1000);
			((BallWorld) getWorld()).scoreChanged(tempScore, obj.getScoreCount());
		}


		if(getOneIntersectingObject(Brick.class)!=null){
			Brick b = getOneIntersectingObject(Brick.class);
			double x = b.getX();
			double y = b.getY();
			if(getX() >= x && getX() <= x + b.getWidth()){
				dy = -dy;
			}
			else if(getY() >= y && getY() <= y + b.getHeight()){
				dx = -dx;
			}
			else{
				dy = -dy;
				dx = -dx;
			}

			Score obj = ((BallWorld)getWorld()).getScore();
			int tempScore = obj.getScoreCount();
			obj.setScore(tempScore + 100);
			((BallWorld)getWorld()).scoreChanged(tempScore, obj.getScoreCount());

			((BallWorld) getWorld()).removeBrick(b);
		}


		if(getOneIntersectingObject(Paddle.class)!=null){
			double x = getOneIntersectingObject(Paddle.class).getX();
			double y = getOneIntersectingObject(Paddle.class).getY();
			Paddle paddle = getOneIntersectingObject(Paddle.class);

			if((paddle.getDx()==0 || paddle.getPos() == paddle.getX()) && getX() >= x && getX() <= x + getOneIntersectingObject(Paddle.class).getWidth()){
				dy = -dy;
			}
			if(paddle.getDx()!=0 || paddle.getPos() != paddle.getX()){
				if((paddle.getDx() < 0 || paddle.getPos() > paddle.getX()) &&
						getX() <= paddle.getX() + paddle.getWidth()/3){
					dx = -Math.abs(dx);
					dy = -dy;
				}
				else if(getX() <= paddle.getX() + (paddle.getWidth()*2)/3){
					dy = - dy;
				}
				else if(((paddle.getDx() > 0 || paddle.getPos() < paddle.getX())) &&
				getX() >= paddle.getX() + (paddle.getWidth()*2)/3){
					dx = Math.abs(dx);
					dy = -dy;
				}
			}
		}
	}

}
