package Task_10.d;

public abstract class AbstractSplitString implements  SplitStrings{

    @Override
    public abstract String fst();

    @Override
    public abstract String snd();

    @Override
    public String concatString() {
        return fst() + snd();
    }

    @Override
    public int indexOfMarker() {
        return fst().length();
    }

    @Override
    public SplitStrings shiftSeparatorLeft() {

        int separatorIndex = fst().length();

        for (int i = 0; i < separatorIndex; i++) {
            shiftSeparatorOneToTheLeft();
        }

        return this;
    }

    @Override
    public SplitStrings shiftSeparatorRight() {

        int separatorIndex = snd().length();

        for (int i = 0; i < separatorIndex; i++) {
            shiftSeparatorOneToTheRight();
        }

        return this;
    }

    @Override
    public abstract SplitStrings shiftSeparatorOneToTheLeft();

    @Override
    public abstract SplitStrings shiftSeparatorOneToTheRight();

    @Override
    public abstract SplitStrings addStringLeftOfTheSeparatorMark(String add);

    @Override
    public abstract SplitStrings addStringRightOfTheSeparatorMark(String add);

    @Override
    public abstract SplitStrings switchFstAndSndString();

    @Override
    public abstract SplitStrings deleteStringLeftOfSeparatorMark();

    @Override
    public abstract SplitStrings deleteStringRightOfSeparatorMark();

    @Override
    public SplitStrings addSecondSplitString(SplitStrings splitStrings) {

        addStringLeftOfTheSeparatorMark(splitStrings.fst());
        addStringRightOfTheSeparatorMark(splitStrings.snd());

        return this;
    }
}
