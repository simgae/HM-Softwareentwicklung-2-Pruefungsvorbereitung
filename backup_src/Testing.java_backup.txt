package Task_10.d;

public class Testing {

    public static void main(String[] args) {
        SplitStrings splitStrings = new TwoStringImplementation("Hello", "World");

        System.out.println(splitStrings.fst());
        System.out.println(splitStrings.snd());
        System.out.println(splitStrings.concatString());
        System.out.println(splitStrings.indexOfMarker());

        System.out.println("--------------------------");

        System.out.println(splitStrings.shiftSeparatorOneToTheLeft());
        System.out.println(splitStrings.shiftSeparatorOneToTheRight());
        System.out.println(splitStrings.shiftSeparatorOneToTheRight());
        System.out.println(splitStrings.shiftSeparatorOneToTheLeft());

        System.out.println(splitStrings.shiftSeparatorLeft());
        System.out.println(splitStrings.shiftSeparatorRight());

        splitStrings = new TwoStringImplementation("Hello", "World");

        System.out.println("--------------------------");

        System.out.println(splitStrings.addStringLeftOfTheSeparatorMark("Test"));
        System.out.println(splitStrings.addStringRightOfTheSeparatorMark("Test"));


        splitStrings = new TwoStringImplementation("Hello", "World");

        System.out.println("--------------------------");

        System.out.println(splitStrings.switchFstAndSndString());

        splitStrings = new TwoStringImplementation("Hello", "World");

        System.out.println("--------------------------");

        System.out.println(splitStrings.deleteStringLeftOfSeparatorMark());
        System.out.println(splitStrings.deleteStringRightOfSeparatorMark());

        splitStrings = new TwoStringImplementation("Hello", "World");

        System.out.println("--------------------------");

        System.out.println(splitStrings.addSecondSplitString(splitStrings));



    }
}
