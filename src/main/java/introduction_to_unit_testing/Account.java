package introduction_to_unit_testing;

public class Account {
    public boolean active;

    public Account() {
        this.active = false;
    }

    public void activate() {
        this.active = true;
    }

    public boolean isActive() {
        return this.active;
    }
}
