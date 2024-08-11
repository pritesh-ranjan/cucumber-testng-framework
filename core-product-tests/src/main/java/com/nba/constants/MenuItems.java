package com.nba.constants;

public enum MenuItems {
    TICKETS("Tickets"),
    SCHEDULE("Schedule"),
    TEAM("Team"),
    SHOP("Shop"),
    CHASE_CENTER("Chase Center"),
    MY_WARRIORS_ACCOUNT("My Warriors Account");

    public final String value;

    private MenuItems(String value){
        this.value = value;
    }
}
