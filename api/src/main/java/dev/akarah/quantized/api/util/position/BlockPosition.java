package dev.akarah.quantized.api.util.position;

public class BlockPosition {
    int x;
    int y;
    int z;

    private BlockPosition(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static BlockPosition of(int x, int y, int z) {
        return new BlockPosition(x, y, z);
    }

    public static BlockPosition zero() {
        return new BlockPosition(0, 0, 0);
    }

    public int x() {
        return this.x;
    }

    public int y() {
        return this.y;
    }

    public int z() {
        return this.z;
    }

    public BlockPosition withX(Integer x) {
        return BlockPosition.of(x, y, z);
    }

    public BlockPosition withY(Integer y) {
        return BlockPosition.of(x, y, z);
    }

    public BlockPosition withZ(Integer z) {
        return BlockPosition.of(x, y, z);
    }

    @Override
    public String toString() {
        return "BlockPosition[x=" + this.x + ", y=" + this.y + ", z=" + this.z + "]";
    }
}
