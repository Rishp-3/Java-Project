package practice.enums;

/** Problem 1: enum with a method. */
public enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    public boolean isWeekend() { return this == SATURDAY || this == SUNDAY; }

    public Day next() { return values()[(ordinal() + 1) % values().length]; }
}
