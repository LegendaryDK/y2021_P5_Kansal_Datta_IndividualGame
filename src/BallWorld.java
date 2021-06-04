import java.util.ArrayList;
import java.util.List;

public class BallWorld extends World implements ScoreListener{

	private Score score;
	private List<Brick> bricks;

	public BallWorld(){
		score = new Score();
		score.setX(30);
		score.setY(30);
		this.getChildren().add(score);
		score.addScoreListener(this);

		bricks = new ArrayList<>();
		double x = 250;
		double y = 100;
		int changeX = -1;
		for(int i = 1; i <= 12; i++){
			Brick br = new Brick();
			if(i == 7){
				changeX = 1;
				x = 250;
				y = 100;
			}
			if(i == 1 || i == 7){
				x += 50 * changeX;
				br.setX(x);
				br.setY(y);
				y += 45;
			}
			else if(i == 2 || i == 8){
				x += 50 * changeX;
				br.setX(x);
				br.setY(y);
				y += 70;
			}
			else if(i == 6 || i == 12){
				x -= 50 * changeX;
				y += 25;
//				x += 100 * changeX;
				br.setY(y);
				br.setX(x);
			}
			else {
				br.setX(x);
				br.setY(y);
				y += 35;
			}
			addBrick(br);
		}
	}
	
	@Override
	public void act(long now) {
		
	}

	public Score getScore(){
		return score;
	}

	public void scoreChanged(int oldVal, int newVal) {
		score.setText(String.valueOf(newVal));
	}

	public List<Brick> getBricks(){
		return bricks;
	}

	public void addBrick(Brick brick){
		bricks.add(brick);
		this.add(brick);
	}

	public void removeBrick(Brick brick){
		bricks.remove(brick);
		this.remove(brick);
	}
}
