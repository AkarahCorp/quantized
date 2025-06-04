package dev.akarah.quantized.api.util.position;

public class EulerAngles {
    float pitch;
    float yaw;
    float roll;

    private EulerAngles(float pitch, float yaw, float roll) {
        this.pitch = pitch;
        this.yaw = yaw;
        this.roll = roll;
    }

    public static EulerAngles of(float pitch, float yaw) {
        return new EulerAngles(pitch, yaw, 0);
    }

    public static EulerAngles of(float pitch, float yaw, float roll) {
        return new EulerAngles(pitch, yaw, roll);
    }

    public float pitch() {
        return this.pitch;
    }

    public float yaw() {
        return this.yaw;
    }

    public float roll() {
        return this.roll;
    }

    @Override
    public String toString() {
        return "EulerAngles[pitch=" + this.pitch + ", yaw=" + this.yaw + ", roll=" + this.roll + "]";
    }
}
