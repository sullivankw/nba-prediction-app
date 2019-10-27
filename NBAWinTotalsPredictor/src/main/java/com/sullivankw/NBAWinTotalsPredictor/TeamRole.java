package com.sullivankw.NBAWinTotalsPredictor;

public enum TeamRole {

    STARTER,
    ROTATION,
    BENCH;

    public static TeamRole getEnumByName(String name) {
        for (TeamRole t : TeamRole.values()) {
            if (t.name().equalsIgnoreCase(name)) {
                return t;
            }
        }
        throw new IllegalArgumentException();
    }
}
