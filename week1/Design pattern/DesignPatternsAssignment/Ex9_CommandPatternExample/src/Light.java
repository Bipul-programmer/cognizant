public class Light {
    private final String location;
    private boolean isOn = false;

    public Light(String location) {
        this.location = location;
    }

    public void turnOn() {
        isOn = true;
        System.out.println(location + " light is ON.");
    }

    public void turnOff() {
        isOn = false;
        System.out.println(location + " light is OFF.");
    }
}
