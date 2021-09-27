package com.oconte.david.firestoretuto;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    private String restaurantUid;
    private List<String> likedRestaurants;


    public Restaurant(String restaurantUid, List<String> likedRestaurants) {
        this.restaurantUid = restaurantUid;
        this.likedRestaurants = likedRestaurants;
    }

    public String getRestaurantUid() {
        return restaurantUid;
    }

    public List<String> getLikedRestaurants() {
        return likedRestaurants;
    }

    public void addLikedRestaurant(String restaurantUid){
        if(likedRestaurants == null) {
            this.likedRestaurants = new ArrayList<>();
        }
        this.likedRestaurants.add(restaurantUid);
    }

    public void removeLikedRestaurant(String restaurantUid){
        if(likedRestaurants != null) {
            int position = 0;
            for (String uid : likedRestaurants) {
                if (uid.equals(restaurantUid)) likedRestaurants.remove(position);
                position += 1;
            }
        }
    }

    public void setRestaurantUid(String restaurantUid) {
        this.restaurantUid = restaurantUid;
    }
}
