package ua.opnu;

public class TimeSpan {
    private int hours;
    private int minutes; // invariant: 0..59

    public TimeSpan() {
        this(0, 0);
    }

    public TimeSpan(int minutes) {
        this(0, minutes);
    }

    public TimeSpan(int hours, int minutes) {
        this.hours = Math.max(0, hours);
        this.minutes = Math.max(0, minutes);
        normalize();
    }

    public TimeSpan(TimeSpan other) {
        this(other != null ? other.hours : 0, other != null ? other.minutes : 0);
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void add(int hours, int minutes) {
        if (hours < 0 || minutes < 0) return;
        this.hours += hours;
        this.minutes += minutes;
        normalize();
    }

    public void add(int minutes) {
        if (minutes < 0) return;
        this.minutes += minutes;
        normalize();
    }

    public void add(TimeSpan span) {
        if (span == null) return;
        add(span.getHours(), span.getMinutes());
    }

    public void subtract(int hours, int minutes) {
        if (hours < 0 || minutes < 0) return;
        int cur = getTotalMinutes();
        int dec = hours * 60 + minutes;
        if (dec > cur) return; // не дозволяємо піти в мінус
        int newTotal = cur - dec;
        this.hours = newTotal / 60;
        this.minutes = newTotal % 60;
    }

    public void subtract(int minutes) {
        if (minutes < 0) return;
        subtract(0, minutes);
    }

    public void subtract(TimeSpan span) {
        if (span == null) return;
        subtract(span.getHours(), span.getMinutes());
    }

    public double getTotalHours() {
        return hours + (minutes / 60.0);
    }

    public int getTotalMinutes() {
        return hours * 60 + minutes;
    }

    public void scale(int factor) {
        if (factor <= 0) return;
        int total = getTotalMinutes() * factor;
        this.hours = total / 60;
        this.minutes = total % 60;
    }

    private void normalize() {
        if (minutes >= 60) {
            hours += minutes / 60;
            minutes = minutes % 60;
        }
        if (hours < 0) hours = 0;
        if (minutes < 0) minutes = 0;
    }
}
