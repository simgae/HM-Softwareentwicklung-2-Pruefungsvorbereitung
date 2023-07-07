package Task_10.d;

public class OneStringImplementation extends AbstractSplitString{

    private String wholeString;
    private int separatorIndex;

    public OneStringImplementation(String fst, String snd){
        this.wholeString = fst + "," + snd;
        this.separatorIndex = fst.length();
    }


    @Override
    public String fst() {
        return wholeString.substring(0, separatorIndex);
    }

    @Override
    public String snd() {
        return wholeString.substring(separatorIndex + 1);
    }

    @Override
    public SplitStrings shiftSeparatorOneToTheLeft() {

        wholeString = wholeString.replace(",", "");
        separatorIndex--;
        wholeString = wholeString.substring(0, separatorIndex) + "," + wholeString.substring(separatorIndex);

        return this;
    }

    @Override
    public SplitStrings shiftSeparatorOneToTheRight() {

        wholeString = wholeString.replace(",", "");
        separatorIndex++;
        wholeString = wholeString.substring(0, separatorIndex) + "," + wholeString.substring(separatorIndex);

        return this;
    }

    @Override
    public SplitStrings addStringLeftOfTheSeparatorMark(String add) {

        wholeString = fst() + add + "," + snd();
        separatorIndex = fst().length() + add.length();

        return this;
    }

    @Override
    public SplitStrings addStringRightOfTheSeparatorMark(String add) {

        wholeString = fst() + "," + add + snd();

        return this;
    }

    @Override
    public SplitStrings switchFstAndSndString() {

        wholeString = snd() + "," + fst();
        separatorIndex = snd().length();

        return this;
    }

    @Override
    public SplitStrings deleteStringLeftOfSeparatorMark() {

        wholeString = "," + snd();
        separatorIndex = 0;

        return this;
    }

    @Override
    public SplitStrings deleteStringRightOfSeparatorMark() {

        wholeString = fst() + ",";

        return this;
    }

    @Override
    public String toString() {
        return wholeString;
    }
}
