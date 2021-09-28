package com.oconte.david.firestoretuto;

import androidx.test.espresso.idling.CountingIdlingResource;


public class Injection {

    public static final CountingIdlingResource resource = new CountingIdlingResource("GooglePlaceIdling");

   /* public static GooglePlaceService getService() {
        return GooglePlaceFactory.getRetrofit().create(GooglePlaceService.class);
    }

    For Call getRestaurantDetail
    public static RestaurantDetailRepository getRestaurantDetail (GooglePlaceService googlePlaceService, CountingIdlingResource resource) {
        RestaurantDetailRepository restaurantDetails = new RestaurantDetailRepository(googlePlaceService, resource);
        return restaurantDetails;
    }

    //For Call getRestaurantNearBy
    public static RestaurantRepository getRestaurantNearBy (GooglePlaceService googlePlaceService, CountingIdlingResource resource) {
        RestaurantRepository restaurantNearBy = new RestaurantRepository(googlePlaceService, resource);
        return restaurantNearBy;
    }*/

    //For Call getUserRepository
    public static UserRepository getUserRepository () {
        UserRepository userRepository = new UserRepository();
        return userRepository;
    }

}
