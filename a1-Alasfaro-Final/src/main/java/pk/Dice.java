package pk;
import java.util.Arrays;
import java.util.Random;

public class Dice {

    public Faces[] roll() {
        return roll(8);
    }

    public Faces[] roll(int diceNum) {
        int howManyFaces = Faces.values().length;

        Faces[] result = new Faces[diceNum];
        Random bag = new Random();
        for (int i = 0; i < diceNum; i++) {
            result[i] = Faces.values()[bag.nextInt(howManyFaces)];
        }
        return result;
    }
}


