package game.listeners;

import game.gameLogic.Counter;
import game.gameLogic.GameEnvironment;
import game.gameLogic.GameLevel;
import game.geometryLogic.Ball;
import game.geometryLogic.Block;
import game.geometryLogic.Velocity;

import java.awt.Color;
import java.util.Random;

/**
 * Listener that adds ball to game when white block is hit.
 */
public class BallAdder implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBalls;
    private GameEnvironment gameEnvironment;
    private Random random = new Random();

    /**
     * constructor.
     * @param gameLevel game.
     * @param remainingBalls blocks to remove.
     * @param gameEnvironment enviromnment to add ball to.
     */
    public BallAdder(GameLevel gameLevel, GameEnvironment gameEnvironment, Counter remainingBalls) {
        this.gameLevel = gameLevel;
        this.remainingBalls = remainingBalls;
        this.gameEnvironment = gameEnvironment;
    }

    /**
     * Note: extra ball blocks and ball killer blocks don't count as blocks needed to beat the game
     * and therefore do not lower the block counter.
     * @param beingHit Block being hit.
     * @param hitter The one hitting the block
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        Ball ball = new Ball((int) (beingHit.getCollisionRectangle().getUpperLeft().getX()
                        + (int) beingHit.getCollisionRectangle().getWidth() / 2),
                (int) beingHit.getCollisionRectangle().getUpperLeft().getY() - 1,
                5, Color.lightGray, gameEnvironment);
        ball.setVelocity(Velocity.fromAngleAndSpeed(((random.nextInt(89) + 1) * ((random.nextInt(4) + 1))),
                (random.nextInt(7) + 3)));
        remainingBalls.increase(1);
        ball.addToGame(gameLevel);
    }
}