package pk;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Arrays;

public class Player {
    private int points;
    private int goldNum = 0;
    private int diamondNum = 0;
    private int skullsNum = 0;
    private int monkeyNum = 0;
    private int parrotNum = 0;
    private int saberNum = 0;

    Dice dice = new Dice();
    Deck deck = new Deck();

    private static final Logger logger = LogManager.getLogger(Player.class);

    public Player() {
        this.points = 0;
    }


    public void turn() {

        Cards card = deck.draw();

        Faces[] result = dice.roll(8);
        for (int i = 0; i < result.length; i++) {
            if (result[i] == Faces.SKULL) {
                skullsNum++;
            } else if (result[i] == Faces.GOLD) {
                goldNum++;
            } else if (result[i] == Faces.DIAMOND) {
                diamondNum++;
            } else if (result[i] == Faces.MONKEY) {
                monkeyNum++;
            } else if (result[i] == Faces.PARROT) {
                parrotNum++;
            } else if (result[i] == Faces.SABER) {
                saberNum++;
            }
        }

        int points = 0;
        int counter = 0;
        int[] comboArray = new int[5];
        comboArray[0] = saberNum;
        comboArray[1] = goldNum;
        comboArray[2] = diamondNum;
        comboArray[3] = monkeyNum;
        comboArray[4] = parrotNum;

        for (int i = 0; i < comboArray.length; i++) {
            if (comboArray[i] == 3) {
                points += 100;
            } else if (comboArray[i] == 4) {
                points += 200;
            } else if (comboArray[i] == 5) {
                points += 500;
            } else if (comboArray[i] == 6) {
                points += 1000;
            } else if (comboArray[i] == 7) {
                points += 2000;
            } else if (comboArray[i] == 8) {
                points += 4000;
            }
        }

        logger.info(Arrays.toString(result));
        points += (goldNum + diamondNum) * 100;

        if (skullsNum < 3 && this.points <= 6000) {
            if (card == Cards.Sea_Battle) {
                if (saberNum >= 4) {
                    this.points += points;
                } else {
                    int diceLeft = 8 - skullsNum;

                    while (skullsNum < 3 && this.points <= 6000 && saberNum < 4) {
                        Random random = new Random();
                        int numToReroll = random.nextInt(diceLeft - 1) + 2;
                        Faces[] reroll = dice.roll(numToReroll);

                        int rerollGoldNum = 0;
                        int rerollDiamondNum = 0;
                        int rerollMonkeyNum = 0;
                        int rerollParrotNum = 0;
                        int rerollSaberNum = 0;

                        for (int i = 0; i < reroll.length; i++) {
                            if (reroll[i] == Faces.SKULL) {
                                skullsNum++;
                            } else if (reroll[i] == Faces.GOLD) {
                                rerollGoldNum++;
                            } else if (reroll[i] == Faces.DIAMOND) {
                                rerollDiamondNum++;
                            } else if (reroll[i] == Faces.MONKEY) {
                                rerollMonkeyNum++;
                            } else if (reroll[i] == Faces.PARROT) {
                                rerollParrotNum++;
                            } else if (reroll[i] == Faces.SABER) {
                                rerollSaberNum++;
                            }
                        }
                    }
                    if (saberNum >= 4)
                        this.points += points;
                    else
                        this.points -= 1000;
                }
            } else if (card == Cards.Monkey_Bus) {
                if (parrotNum + monkeyNum >= 3) {
                    this.points += points;
                    return;
                }
                else {
                    int diceLeft = 8 - skullsNum;

                    while (skullsNum < 3 && this.points <= 6000 && saberNum < 4) {
                        Random random = new Random();
                        int numToReroll = random.nextInt(diceLeft - 1) + 2;
                        Faces[] reroll = dice.roll(numToReroll);

                        int rerollGoldNum = 0;
                        int rerollDiamondNum = 0;
                        int rerollMonkeyNum = 0;
                        int rerollParrotNum = 0;
                        int rerollSaberNum = 0;

                        for (int i = 0; i < reroll.length; i++) {
                            if (reroll[i] == Faces.SKULL) {
                                skullsNum++;
                            } else if (reroll[i] == Faces.GOLD) {
                                rerollGoldNum++;
                            } else if (reroll[i] == Faces.DIAMOND) {
                                rerollDiamondNum++;
                            } else if (reroll[i] == Faces.MONKEY) {
                                rerollMonkeyNum++;
                            } else if (reroll[i] == Faces.PARROT) {
                                rerollParrotNum++;
                            } else if (reroll[i] == Faces.SABER) {
                                rerollSaberNum++;
                            }
                        }
                    }
                    int monkeyBus = monkeyNum + parrotNum;
                    if (monkeyBus == 3) {
                        points += 100;
                    } else if (monkeyBus == 4) {
                        points += 200;
                    } else if (monkeyBus == 5) {
                        points += 500;
                    } else if (monkeyBus == 6) {
                        points += 1000;
                    } else if (monkeyBus == 7) {
                        points += 2000;
                    } else if (monkeyBus == 8) {
                        points += 4000;
                    }
                    if (skullsNum < 3) {
                        this.points += points;
                    }
                }
            }
            else {
                int diceLeft = 8 - skullsNum;

                while (skullsNum < 3 && this.points <= 6000 && saberNum < 4) {
                    Random random = new Random();
                    int numToReroll = random.nextInt(diceLeft - 1) + 2;
                    Faces[] reroll = dice.roll(numToReroll);

                    int rerollGoldNum = 0;
                    int rerollDiamondNum = 0;
                    int rerollMonkeyNum = 0;
                    int rerollParrotNum = 0;
                    int rerollSaberNum = 0;

                    for (int i = 0; i < reroll.length; i++) {
                        if (reroll[i] == Faces.SKULL) {
                            skullsNum++;
                        } else if (reroll[i] == Faces.GOLD) {
                            rerollGoldNum++;
                        } else if (reroll[i] == Faces.DIAMOND) {
                            rerollDiamondNum++;
                        } else if (reroll[i] == Faces.MONKEY) {
                            rerollMonkeyNum++;
                        } else if (reroll[i] == Faces.PARROT) {
                            rerollParrotNum++;
                        } else if (reroll[i] == Faces.SABER) {
                            rerollSaberNum++;
                        }
                    }

                    int repoints = 0;
                    int[] array = new int[5];
                    array[0] = rerollSaberNum;
                    array[1] = rerollGoldNum;
                    array[2] = rerollDiamondNum;
                    array[3] = rerollMonkeyNum;
                    array[4] = rerollParrotNum;


                    for (int i = 0; i < array.length; i++) {
                        if (array[i] == 3) {
                            repoints += 100;
                        } else if (array[i] == 4) {
                            repoints += 200;
                        } else if (array[i] == 5) {
                            repoints += 500;
                        } else if (array[i] == 6) {
                            repoints += 1000;
                        } else if (array[i] == 7) {
                            repoints += 2000;
                        } else if (array[i] == 8) {
                            repoints += 4000;
                        }
                    }

                    logger.info(Arrays.toString(reroll));
                    logger.trace("Instances of each face: " + Arrays.toString(array));

                    int rerollPts = (rerollGoldNum + rerollDiamondNum) * 100;
                    logger.trace("Player got " + rerollGoldNum + " gold coins, " + rerollDiamondNum + " diamond coins, and " + skullsNum + " skulls.");
                    diceLeft = 8 - skullsNum;
                    rerollGoldNum = 0;
                    rerollDiamondNum = 0;
                    rerollMonkeyNum = 0;
                    rerollParrotNum = 0;
                    rerollSaberNum += saberNum;

                    if (skullsNum < 3 && this.points <= 6000) {
                        this.points += points;
                    }

                    diceLeft = 8 - skullsNum;
                }
            }
        }
        else {
            points = 0;
            this.points += points;
        }

        logger.trace("Player's turn is over with a score of: " + this.points);
        goldNum = 0;
        diamondNum = 0;
        skullsNum = 0;
        saberNum = 0;
        monkeyNum = 0;
        parrotNum = 0;
        return;
    }

    public int getScore() {
        return this.points;
    }

    public void reset() {
        this.points = 0;
    }


    public void combo() {
        Faces[] result = dice.roll(8);
        for (int i = 0; i < result.length; i++) {
            if (result[i] == Faces.SKULL) {
                skullsNum++;
            } else if (result[i] == Faces.GOLD) {
                goldNum++;
            } else if (result[i] == Faces.DIAMOND) {
                diamondNum++;
            } else if (result[i] == Faces.MONKEY) {
                monkeyNum++;
            } else if (result[i] == Faces.PARROT) {
                parrotNum++;
            } else if (result[i] == Faces.SABER) {
                saberNum++;
            }
        }

        int points = 0;
        int[] comboArray = new int[5];
        comboArray[0] = saberNum;
        comboArray[1] = goldNum;
        comboArray[2] = diamondNum;
        comboArray[3] = monkeyNum;
        comboArray[4] = parrotNum;
        int maximum = comboArray[0];

        for (int i = 0; i < comboArray.length; i++) {
            if (comboArray[i] == 3) {
                points += 100;
            } else if (comboArray[i] == 4) {
                points += 200;
            } else if (comboArray[i] == 5) {
                points += 500;
            } else if (comboArray[i] == 6) {
                points += 1000;
            } else if (comboArray[i] == 7) {
                points += 2000;
            } else if (comboArray[i] == 8) {
                points += 4000;
            }
            if (comboArray[i] > maximum) {
                maximum = comboArray[i];
            }
        }

        logger.info(Arrays.toString(result));
        int Firstpoints = (goldNum + diamondNum) * 100;
        if (skullsNum < 3 && this.points <= 6000) {
            this.points += points + Firstpoints;
        }
        logger.trace("Player starts with " + this.points + " points");

        int diceLeft = 8 - skullsNum - maximum;
        while (skullsNum < 3 && this.points <= 6000) {
            Random random = new Random();
            int numToReroll = random.nextInt(diceLeft) + 1;
            Faces[] reroll = dice.roll(numToReroll);

            int rerollGoldNum = 0;
            int rerollDiamondNum = 0;
            int rerollMonkeyNum = 0;
            int rerollParrotNum = 0;
            int rerollSaberNum = 0;

            for (int i = 0; i < reroll.length; i++) {
                if (reroll[i] == Faces.SKULL) {
                    skullsNum++;
                } else if (reroll[i] == Faces.GOLD) {
                    rerollGoldNum++;
                } else if (reroll[i] == Faces.DIAMOND) {
                    rerollDiamondNum++;
                } else if (reroll[i] == Faces.MONKEY) {
                    rerollMonkeyNum++;
                } else if (reroll[i] == Faces.PARROT) {
                    rerollParrotNum++;
                } else if (reroll[i] == Faces.SABER) {
                    rerollSaberNum++;
                }
            }

            int repoints = 0;
            int[] array = new int[5];
            array[0] = rerollSaberNum;
            array[1] = rerollGoldNum;
            array[2] = rerollDiamondNum;
            array[3] = rerollMonkeyNum;
            array[4] = rerollParrotNum;
            int max = array[0];

            for (int i = 0; i < array.length; i++) {
                if (array[i] == 3) {
                    repoints += 100;
                } else if (array[i] == 4) {
                    repoints += 200;
                } else if (array[i] == 5) {
                    repoints += 500;
                } else if (array[i] == 6) {
                    repoints += 1000;
                } else if (array[i] == 7) {
                    repoints += 2000;
                } else if (array[i] == 8) {
                    repoints += 4000;
                }

                if (array[i] > max) {
                    max = i;
                }
            }

            logger.info(Arrays.toString(reroll));
            logger.trace("Instances of each face: " + Arrays.toString(array));

            int rerollPoints = (rerollGoldNum + rerollDiamondNum) * 100;
            if (skullsNum < 3) {
                this.points += rerollPoints + repoints;
            }
            logger.trace("Player got " + rerollGoldNum + " gold coins, " + rerollDiamondNum + " diamond coins, and " + skullsNum + " skulls.");


        }

        logger.trace("Player's turn is over with a score of: " + this.points);
        goldNum = 0;
        diamondNum = 0;
        skullsNum = 0;
        saberNum = 0;
        monkeyNum = 0;
        parrotNum = 0;

    }

}
