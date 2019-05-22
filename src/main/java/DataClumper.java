public class DataClumper {

    public String shouldBeClumped(String s, float f, double d1, double d2, int i, short nigel, Object o1, Object o2) {
        return anotherMethod(s, f, d1);
    }

    public String anotherMethod(String s, float f, double d1) {
        return s + f + d1;
    }
}
