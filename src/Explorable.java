import java.util.List;

public interface Explorable<T> {

    List<T> NextStep();
    boolean isFinish();

}
