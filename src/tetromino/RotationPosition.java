package tetromino;

public enum RotationPosition {
    noRotation, oneQuarterRotation, halfRotation, threeQuarterRotation;

    public RotationPosition getNext() {
        return this.ordinal() < RotationPosition.values().length - 1
                ? RotationPosition.values()[this.ordinal() + 1]
                : RotationPosition.values()[0];
    }
}
