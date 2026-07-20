public class RemoteControlTest {
    public static void main(String[] args) {
        Light livingRoomLight = new Light("Living Room");
        Light kitchenLight = new Light("Kitchen");

        Command livingRoomOn = new LightOnCommand(livingRoomLight);
        Command livingRoomOff = new LightOffCommand(livingRoomLight);
        Command kitchenOn = new LightOnCommand(kitchenLight);
        Command kitchenOff = new LightOffCommand(kitchenLight);

        RemoteControl remote = new RemoteControl();

        remote.setCommand(livingRoomOn);
        remote.pressButton();

        remote.setCommand(kitchenOn);
        remote.pressButton();

        remote.setCommand(livingRoomOff);
        remote.pressButton();

        remote.setCommand(kitchenOff);
        remote.pressButton();
    }
}
