package Chapter7.CallCenter;

/**
 * Created by bresai on 2017/2/24.
 */
public abstract class Employee {
    private TypeEnum type;
    private boolean avaliable;

    public abstract boolean acceptCall();

    public abstract boolean finishCall();

    public abstract boolean escalate();
}
