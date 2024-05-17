package com.example.cardiopediafyp;

import java.util.List;

public class ParentItem {
    private String title;
    private int logo;
    private List<ChildItem> mList;

    public ParentItem(String title, int logo, List<ChildItem> mList) {
        this.title = title;
        this.logo = logo;
        this.mList = mList;
    }

    public String getTitle() {
        return title;
    }

    public int getLogo() {
        return logo;
    }

    public List<ChildItem> getMList() {
        return mList;
    }
}
