package dev.akarah.quantized.api.util.position;

public class FinePosition {
    double x;
    double y;
    double z;

    private FinePosition(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static FinePosition of(double x, double y, double z) {
        return new FinePosition(x, y, z);
    }

    public static FinePosition zero() {
        return new FinePosition(0, 0, 0);
    }

    public double x() {
        return this.x;
    }

    public double y() {
        return this.y;
    }

    public double z() {
        return this.z;
    }

    public FinePosition withX(Double x) {
        return FinePosition.of(x, y, z);
    }

    public FinePosition withY(Double y) {
        return FinePosition.of(x, y, z);
    }

    public FinePosition withZ(Double z) {
        return FinePosition.of(x, y, z);
    }

    public BlockPosition blockPosition() {
        return BlockPosition.of((int) x, (int) y, (int) z);
    }

    @Override
    public String toString() {
        return "FinePosition[x=" + this.x + ", y=" + this.y + ", z=" + this.z + "]";
    }
}
