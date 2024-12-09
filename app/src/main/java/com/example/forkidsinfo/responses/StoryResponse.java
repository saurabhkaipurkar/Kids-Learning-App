package com.example.forkidsinfo.responses;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StoryResponse {
    @SerializedName("items")
    public List<Item> items;
    public static class Item {
        @SerializedName("title")
        String title;
        @SerializedName("link")
        String link;
        @SerializedName("snippet")
        public String snippet;
    }
}
