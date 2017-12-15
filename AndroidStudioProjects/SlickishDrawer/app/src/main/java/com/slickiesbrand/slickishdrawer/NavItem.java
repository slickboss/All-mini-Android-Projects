package com.slickiesbrand.slickishdrawer;

/**
 * Created by SLICKBOSS on 7/11/2016.
 */
public class NavItem {

    private String title;
    private String subtitle;
    private int resIcon;
  //   public int getResIcon;

    public NavItem(String title, String subtitle, int resIcon) {
        super();
        this.title = title;
        this.subtitle = subtitle;
        this.resIcon = resIcon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public int getResIcon() {
        return resIcon;
    }

    public void setResIcon(int resIcon) {
        this.resIcon = resIcon;
    }
}

