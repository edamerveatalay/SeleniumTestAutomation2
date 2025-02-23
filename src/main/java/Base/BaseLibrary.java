package Base;

public class BaseLibrary extends Data{
    public void sleep (int millis) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
