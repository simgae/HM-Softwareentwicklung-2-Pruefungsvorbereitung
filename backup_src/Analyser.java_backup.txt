package Task_10.c;

public class Analyser {

    public static void main(String[] args) {
        Net net = new Serial(new Parallel(new Parallel(new Resistor(50), new Resistor(50)), new Serial(new Resistor(50))));
        Net net2 = new Serial(new Parallel(new Parallel(new Potenziometer(50).setOhm(100), new Resistor(50)), new Serial(new Resistor(50))));

        System.out.println(net.ohm());
        System.out.println(net.resistors());
        System.out.println(net2.ohm());
    }

}
