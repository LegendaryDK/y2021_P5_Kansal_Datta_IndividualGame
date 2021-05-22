public class BallWorld extends World{

	private Score score;

	public BallWorld(){
		score = new Score();
		score.setX(30);
		score.setY(30);
		this.getChildren().add(score);
	}
	
	@Override
	public void act(long now) {
		
	}

	public Score getScore(){
		return score;
	}
}
