package envelope;

public class Envelope implements Comparable<Envelope> {
    private float length;
    private float width;

    public Envelope(float length, float width) {
        this.length = length;
        this.width = width;
    }

    public float getLength() {
        return length;
    }

    public float getWidth() {
        return width;
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
