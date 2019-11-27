public class HangManSolver {
    private Boolean gameWon;
    private Boolean lastGuessGood;
    private Integer counter;
    private static final Integer loseCondition = 6;
    private String predeterminedGuesses;
    String score;
    Integer gotten;

    public HangManSolver() {
        gameWon = false;
        lastGuessGood = false;
        counter = 0;
        predeterminedGuesses = "AEDING";
    }

    public String runGame(String blanks) {

        for (int i = 0; i < loseCondition; i++) {

            //This will be displayed after every turn
            Integer total = countTotal(blanks);
            score = "You've gotten " + gotten + " out of " + total + " characters so far.  With " + (total - i) + "body parts remaining";

            //Updates lastGuessGood
            makeGuess(blanks, i);

            //Evaluates the Guess
            if (lastGuessGood) {
                updateScore(total);
                i--;
            }

            //Displays score
            System.out.println(score);

            //Ends Turn
            if (gameWon) { return "You've won"; }
            counter++;

        }
        //If you reach this you've run out of turns
        return "Game over";
    }


    //Methods called in runGame Loop
    public Integer countTotal(String blanks) {
        Integer total = 0;
        for (int i = 0; i < blanks.length(); i++) {
            if (Character.isLetter(blanks.charAt(i))) {
                total++;
            }
        }
        return total;
    }


    public void makeGuess (String blanks, Integer guessNumber){
        char getGuess = predeterminedGuesses.charAt(guessNumber);
        String guess = Character.toString(getGuess);
        lastGuessGood = blanks.contains(guess);
    }

    public void updateScore(Integer total){
        gotten++;
        gameWon = (gotten == total) ? true : false;
    }


    }
