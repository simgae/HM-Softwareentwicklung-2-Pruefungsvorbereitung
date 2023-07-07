package Task_10.d;

/**
 * 10d. Geteilte Strings
 * Das Interface SplitString repräsentiert eine veränderliche Kombination von
 * zwei Strings, wie zum Beispiel "Hello" und "World". Man kann einen
 * SplitString auch als einzelnen String mit einer Trennstelle sehen: "Hello-
 * World" mit dem Trenner vor dem Zeichen mit Index 5.
 * Definieren Sie das Interface mit den folgenden Methoden. In den Beispielen
 * ist die Trennstelle mit einem Komma markiert. In Wahrheit ist die Trennstelle
 * allerdings eine logische Position und kein konkretes Zeichen.
 *     Getter für den ersten und zweiten Teil-String sowie den Gesamt-String
 *     und die Trennstelle. Beispiele für die vier Getter sind:
 *         Hello,World => Hello
 *         Hello,World => World
 *         Hello,World => HelloWorld
 *         Hello,World => 5
 *     Methoden zum Verschieben des Trenners an den Anfang und an das Ende.
 *         Beispiele:
 *         Hello,World => HelloWorld,
 *         Hello,World => ,HelloWorld
 *     Methoden zum Verschieben des Trenners um eine Position nach vorne
 *         und nach hinten. An den Enden bleibt der Trenner stehen. Beispiele:
 *         Hello,World => Hell,oWorld
 *         Hello,World => HelloW,orld
 *     Methoden, um einen neuen String vor und hinter dem Trenner einzufügen. Beispiele:
 *         Hello,World + Cruel => HelloCruel,World
 *         Hello,World + Cruel => Hello,CruelWorld
 *     Eine Methode zum Tauschen des ersten und zweiten Teil-Strings. Beispiele:
 *         Hello,World => World,Hello
 *     Methoden zum Löschen des Teil-Strings vor und nach dem Trenner. Der
 *         Trenner steht anschließend am hinteren beziehungsweise am vorderen
 *         Ende. Beispiele:
 *         Hello,World => Hello,
 *         Hello,World => ,World
 *     Eine Methode zum Einfügen eines zweiten SplitString. Beispiel:
 *         Hello,World + Anybody,Home => HelloAnybody,HomeWorld
 * Überlegen Sie sich, welche dieser Methoden auf eine konkrete Implementierung
 * angewiesen sind und welche nicht. Definieren Sie alle Methoden,
 * die auf anderen Methoden beruhen, in einer abstrakten Basisklasse names
 * AbstractSplitString.
 * Definieren Sie zwei verschiedene konkreten Klassen, die beide von Abstract
 * SplitString erben und die fehlenden Methoden implementieren. Eine der
 * Klassen arbeitet mit dem Gesamt-String und dem Index der Trennstelle. Die
 * andere verwaltet die beiden Teil-Strings getrennt.
 */
public interface SplitStrings {

    /**
     * Getter for first string.
     * @return first string of SplitString object
     */
    public String fst();

    /**
     * Getter for second string.
     * @return second string of SplitString object
     */
    public String snd();

    /**
     * Getter for concatenation of strings.
     * @return concatenation of both string, split by ','
     */
    public String concatString();

    /**
     * Getter for index of separator between both strings.
     * @return index of separator
     */
    public int indexOfMarker();


    /**
     * Shift separator mark to the beginning of the string.
     * @return edited String
     */
    public SplitStrings shiftSeparatorLeft();

    /**
     * Shift separator mark to the end of the string.
     * @return edited String
     */
    public SplitStrings shiftSeparatorRight();

    /**
     * Shift separator mark one position to the left.
     * @return edited String
     */
    public SplitStrings shiftSeparatorOneToTheLeft();

    /**
     * Shift separator mark one position to the right.
     * @return edited String
     */
    public SplitStrings shiftSeparatorOneToTheRight();

    /**
     * Add String left of the separator mark.
     * @param add - String which should be added
     * @return edited String
     */
    public SplitStrings addStringLeftOfTheSeparatorMark(String add);

    /**
     * Add String right of the separator mark.
     * @param add - String which should be edited
     * @return edited String
     */
    public SplitStrings addStringRightOfTheSeparatorMark(String add);

    /**
     * Switch fist and second String.
     * @return edited String
     */
    public SplitStrings switchFstAndSndString();

    /**
     * Delete the String left of the separator mark.
     * @return edited String
     */
    public SplitStrings deleteStringLeftOfSeparatorMark();

    /**
     * Delete String right of the separator mark.
     * @return edited String
     */
    public SplitStrings deleteStringRightOfSeparatorMark();

    /**
     * Add second split string to this one.
     * @param splitStrings another split String
     * @return edited String
     */
    public SplitStrings addSecondSplitString(SplitStrings splitStrings);
}
