package com.sullivankw.NBAWinTotalsPredictor;


public enum DepthChartPosition {

    /** Rating System - Version 1 this system will be based on more knowledge of rotations which will suffice
     *  To make it more reliable I should define minutes played over some timeline prev seasons, etc
     * 1 - sees starters minutes
     * 2 - sees valuable mins
     * 3. scrub, blowouts and depleted rosters
     * **/

    PG1(1, TeamRole.STARTER),
    PG2(2, TeamRole.ROTATION),
    PG3(3, TeamRole.BENCH),
    PG4(3, TeamRole.BENCH),
    PG5(3, TeamRole.BENCH),
    PG6(3, TeamRole.BENCH),
    PG7(3, TeamRole.BENCH),
    PG8(3, TeamRole.BENCH),
    PG9(3, TeamRole.BENCH),
    PG10(3, TeamRole.BENCH),
    PG11(3, TeamRole.BENCH),

    SG1(1, TeamRole.STARTER),
    SG2(2, TeamRole.ROTATION),
    SG3(3, TeamRole.BENCH),
    SG4(3, TeamRole.BENCH),
    SG5(3, TeamRole.BENCH),
    SG6(3, TeamRole.BENCH),
    SG7(3, TeamRole.BENCH),
    SG8(3, TeamRole.BENCH),
    SG9(3, TeamRole.BENCH),
    SG10(3, TeamRole.BENCH),
    SG11(3, TeamRole.BENCH),

    SF1(1, TeamRole.STARTER),
    SF2(2, TeamRole.ROTATION),
    SF3(3, TeamRole.BENCH),
    SF4(3, TeamRole.BENCH),
    SF5(3, TeamRole.BENCH),
    SF6(3, TeamRole.BENCH),
    SF7(3, TeamRole.BENCH),
    SF8(3, TeamRole.BENCH),
    SF9(3, TeamRole.BENCH),
    SF10(3, TeamRole.BENCH),
    SF11(3, TeamRole.BENCH),

    PF1(1, TeamRole.STARTER),
    PF2(2, TeamRole.ROTATION),
    PF3(3, TeamRole.BENCH),
    PF4(3, TeamRole.BENCH),
    PF5(3, TeamRole.BENCH),
    PF6(3, TeamRole.BENCH),
    PF7(3, TeamRole.BENCH),
    PF8(3, TeamRole.BENCH),
    PF9(3, TeamRole.BENCH),
    PF10(3, TeamRole.BENCH),
    PF11(3, TeamRole.BENCH),

    C1(1, TeamRole.STARTER),
    C2(2, TeamRole.ROTATION),
    C3(3, TeamRole.BENCH),
    C4(3, TeamRole.BENCH),
    C5(3, TeamRole.BENCH),
    C6(3, TeamRole.BENCH),
    C7(3, TeamRole.BENCH),
    C8(3, TeamRole.BENCH),
    C9(3, TeamRole.BENCH),
    C10(3, TeamRole.BENCH),
    C11(3, TeamRole.BENCH);

    private TeamRole teamRole;
    private int rating;

    DepthChartPosition(int rating, TeamRole teamRole) {
        this.rating = rating;
        this.teamRole = teamRole;
    }

    public static DepthChartPosition getEnumByName(String name) {
        for (DepthChartPosition t: DepthChartPosition.values()) {
            if (t.name().equalsIgnoreCase(name)) {
                return t;
            }
        }
        throw new IllegalArgumentException();
    }

    public TeamRole getTeamRole() {
        return teamRole;
    }

    public void setTeamRole(TeamRole teamRole) {
        this.teamRole = teamRole;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
