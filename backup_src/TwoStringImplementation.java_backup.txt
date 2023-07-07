package Task_10.d;

public class TwoStringImplementation extends AbstractSplitString {

    private String fst;
    private String snd;

    public TwoStringImplementation(String fst, String snd) {
        this.fst = fst;
        this.snd = snd;
    }

    @Override
    public String fst() {
        return fst;
    }

    @Override
    public String snd() {
        return snd;
    }

    @Override
    public SplitStrings shiftSeparatorOneToTheLeft() {

        char lastOfFst = fst.charAt(fst.length() - 1);

        fst = fst.substring(0, fst.length() - 1);
        snd = lastOfFst + snd;

        return this;
    }

    @Override
    public SplitStrings shiftSeparatorOneToTheRight() {

        char fstOfSnd = snd.charAt(0);

        fst = fst + fstOfSnd;
        snd = snd.substring(1);

        return this;
    }

    @Override
    public SplitStrings addStringLeftOfTheSeparatorMark(String add) {

        fst = fst + add;

        return this;
    }

    @Override
    public SplitStrings addStringRightOfTheSeparatorMark(String add) {

        snd = add + snd;

        return this;
    }

    @Override
    public SplitStrings switchFstAndSndString() {

        String temp = fst;

        fst = snd;
        snd = temp;

        return this;
    }

    @Override
    public SplitStrings deleteStringLeftOfSeparatorMark() {

        fst = "";

        return this;
    }

    @Override
    public SplitStrings deleteStringRightOfSeparatorMark() {

        snd = "";

        return this;
    }

    @Override
    public String toString() {
        return fst + "," + snd;
    }
}
