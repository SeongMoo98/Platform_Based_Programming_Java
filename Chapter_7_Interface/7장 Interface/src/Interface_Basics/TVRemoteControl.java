package Interface_Basics;
//abstract class처럼 사용
interface RemoteControl{
    public void power();
}

public class TVRemoteControl implements RemoteControl{
    private boolean powerOn=false;

    public void power(){
        powerOn = true;
    }
}
