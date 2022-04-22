package madsen;

/**
 * This is our remote control class slot function that will handle set commands and the on and off buttons.
 * This code was given from project 6
 */

public class RemoteControlSlotFunction {
    private String name = "EMPTY SLOT";
    private Command command;

    public RemoteControlSlotFunction() {}

    public RemoteControlSlotFunction(String name, Command command) {
        this.name = name;
        this.command = command;
    }

    public void assignCommand(Command command) {
        this.command = command;
    }

    public void toggleButtonPress() {
        if (command != null) {
            command.pressButton();
        } else {
            System.out.println("No command assigned to this slot");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
