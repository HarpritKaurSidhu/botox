package io.itmatic.botox.model;

/**
 * Created by Manoj on 4/17/2017.
 */

public class Education {

    /** The id. */
    private int id;

    /** The display name. */
    private String displayName;

    private boolean selectCourse;

    public boolean isSelectCourse() {
        return selectCourse;
    }

    public void setSelectCourse(boolean selectCourse) {
        this.selectCourse = selectCourse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
