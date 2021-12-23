package Default_Static;

public interface Vehicle {
    String getBrand();
    String speedUp();
    String slowDown();

    default String turnAlarmOn() {
        return "Turning the vehicle alarm on.";
    }
    default String turnAlarmOff() {
        return "Turning the vehicle alarm off.";
    }

    public static int getHorsePower(int rpm,int torque){
        return (rpm*torque)/5252;
    }
}
