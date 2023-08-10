public class PRNG {
    private static int seed = 0;
    private static int a = 1459;
    private static int b = 4441;
    private static int m = 7289;

    public static int generate() {
        seed = (a * seed + b) % m;
        return seed;
    }

    public static int generate(int newSeed) {
        seed = newSeed;
        return generate();
    }

    public static int getSeed() {
        return seed;
    }

    public static void setSeed(int seed) {
        PRNG.seed = seed;
    }

    public static int getA() {
        return a;
    }

    public static void setA(int a) {
        PRNG.a = a;
    }

    public static int getB() {
        return b;
    }

    public static void setB(int b) {
        PRNG.b = b;
    }

    public static int getM() {
        return m;
    }

    public static void setM(int m) {
        PRNG.m = m;
    }
}
