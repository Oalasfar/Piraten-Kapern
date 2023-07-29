package pk;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class Run {
    private static final Logger logger = LogManager.getLogger(Run.class);
    private Player player1;
    private Player player2;

    public Run() {
        this.player1 = new Player();
        this.player2 = new Player();
    }

    public void random() {

        int player1Wins = 0;
        int player2Wins = 0;

        for (int i = 0; i < 42; i++) {
            boolean status = false;
            while (!status) {
                player1.turn();
                if (player1.getScore() >= 6000) {
                    player2.turn();
                    if (player1.getScore() > player2.getScore()) {
                        player1Wins++;
                        logger.trace("Player 1 wins");
                    } else {
                        player2Wins++;
                        logger.trace("Player 2 wins");
                    }
                    status = true;
                } else {
                    player2.turn();
                    if (player2.getScore() >= 6000) {
                        player1.turn();
                        if (player1.getScore() > player2.getScore()) {
                            player1Wins++;
                            logger.trace("Player 1 wins");
                        } else {
                            player2Wins++;
                            logger.trace("Player 2 wins");
                        }
                        status = true;
                    }
                }
            }
            player1.reset();
            player2.reset();
        }
        logger.info("Player 1 win percentage: " + (player1Wins / 42.0) * 100 + "%");
        logger.info("Player 2 win percentage: " + (player2Wins / 42.0) * 100 + "%");
    }

    public void strategy() {

        int player1Wins = 0;
        int player2Wins = 0;

        for (int i = 0; i < 42; i++) {
            boolean status = false;
            while (!status) {
                player1.combo();
                if (player1.getScore() >= 6000) {
                    player2.combo();
                    if (player1.getScore() > player2.getScore()) {
                        player1Wins++;
                        logger.trace("Player 1 wins");
                    } else {
                        player2Wins++;
                        logger.trace("Player 2 wins");
                    }
                    status = true;
                } else {
                    player2.combo();
                    if (player2.getScore() >= 6000) {
                        player1.combo();
                        if (player1.getScore() > player2.getScore()) {
                            player1Wins++;
                            logger.trace("Player 1 wins");
                        } else {
                            player2Wins++;
                            logger.trace("Player 2 wins");
                        }
                        status = true;
                    }
                }
            }
            player1.reset();
            player2.reset();
        }
        logger.info("Player 1 win percentage: " + (player1Wins / 42.0) * 100 + "%");
        logger.info("Player 2 win percentage: " + (player2Wins / 42.0) * 100 + "%");
    }

    public void randCombo() {

        int player1Wins = 0;
        int player2Wins = 0;

        for (int i = 0; i < 42; i++) {
            boolean status = false;
            while (!status) {
                player1.turn();
                if (player1.getScore() >= 6000) {
                    player2.combo();
                    if (player1.getScore() > player2.getScore()) {
                        player1Wins++;
                        logger.trace("Player 1 (Random) wins");
                    } else {
                        player2Wins++;
                        logger.trace("Player 2 (Combo) wins");
                    }
                    status = true;
                } else {
                    player2.combo();
                    if (player2.getScore() >= 6000) {
                        player1.turn();
                        if (player1.getScore() > player2.getScore()) {
                            player1Wins++;
                            logger.trace("Player 1 (Random) wins");
                        } else {
                            player2Wins++;
                            logger.trace("Player 2 (Combo) wins");
                        }
                        status = true;
                    }
                }
            }
            player1.reset();
            player2.reset();
        }
        logger.info("Player 1 win percentage: " + (player1Wins / 42.0) * 100 + "%");
        logger.info("Player 2 win percentage: " + (player2Wins / 42.0) * 100 + "%");
    }

}