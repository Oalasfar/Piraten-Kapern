import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.LoggerConfig;
import pk.Dice;
import pk.Faces;
import pk.Player;
import pk.Run;

import java.util.Arrays;

public class PiratenKarpen {

    private static final Logger logger = LogManager.getLogger(PiratenKarpen.class);

    public static void main(String[] args) {

        if (args.length > 0 && args[0].equals("trace")) {
            LoggerConfig loggerConfig = ((org.apache.logging.log4j.core.Logger) logger).get();
            loggerConfig.setLevel(Level.TRACE);
        }

        if (logger.isTraceEnabled()) {
            logger.trace("Welcome to Piraten Karpen Simulator!");
            logger.trace("I'm rolling a dice");
            logger.trace("  (DEBUG) there are " + 6 + " faces");
            logger.trace("  (DEBUG) " + Arrays.toString(Faces.values()));
        }

        if (args.length == 1 && args[0].equals("random")) {
            Run game = new Run();
            game.random();
        } else if (args.length == 1 && args[0].equals("combo")) {
            Run game = new Run();
            game.strategy();
        } else if (args.length == 2 && args[0].equals("random") && args[1].equals("combo")) {
            Run game = new Run();
            game.randCombo();
        } else {
            logger.error("Invalid command line argument - Will run default mode: 'Random'");
            Run game = new Run();
            game.random();
        }

        logger.trace("That's all folks!");

    }
}