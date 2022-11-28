package promowarn.fp.core;

public final class Pair<A, B> {
    private final A fst;
    private final B snd;

    public Pair(A a, B b) {
        fst = a;
        snd = b;
    }

    public A fst() {
        return fst;
    }

    public B snd() {
        return snd;
    }

}
