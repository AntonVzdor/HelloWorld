package Generics;

public class Box <S, I, F>{
    private S str;
    private I integer;
    private F floating;

    public Box(S str, I integer, F floating) {
        this.str = str;
        this.integer = integer;
        this.floating = floating;
    }

    public S getStr() {
        return str;
    }

    public void setStr(S str) {
        this.str = str;
    }

    public I getInteger() {
        return integer;
    }

    public void setInteger(I integer) {
        this.integer = integer;
    }

    public F getFloating() {
        return floating;
    }

    public void setFloating(F floating) {
        this.floating = floating;
    }
}
