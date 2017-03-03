package Chapter7.CallCenter;

/**
 * Created by bresai on 2017/2/24.
 */
public class Responsor extends Employee {
    @Override
    public boolean acceptCall() {
        return false;
    }

    @Override
    public boolean finishCall() {
        return false;
    }

    @Override
    public boolean escalate() {
        return false;
    }
}
