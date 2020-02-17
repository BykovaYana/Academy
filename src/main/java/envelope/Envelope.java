package envelope;

public class Envelope implements Comparable<Envelope> {
    private float length;
    private float width;

    public float getLength() {
        return length;
    }

    public void setLength(float Length) {
        this.length = Length;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float Width) {
        this.width = Width;
    }

    public int compareTo(Envelope envelope) {
        if ((length < envelope.length) && (width < envelope.width)) {
            return -1;
        } else if ((length > envelope.length) && (width > envelope.width)) {
            return 1;
        } else {
            return 0;
        }
    }
}
