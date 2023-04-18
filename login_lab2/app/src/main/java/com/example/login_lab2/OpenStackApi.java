package com.example.login_lab2;

import com.google.gson.annotations.SerializedName;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class OpenStackApi {
    private static final String BASE_URL = "https://openstack.example.com/v2/";

    private static Retrofit retrofit;
/*
    public static <OpenStackApi> OpenStackApi getApi() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(OpenStackApi.class);
    }

    public class ImageRequestBody {
        @SerializedName("container_format")
        private String containerFormat;

        @SerializedName("disk_format")
        private String diskFormat;

        @SerializedName("name")
        private String name;

        @SerializedName("visibility")
        private String visibility;

        @SerializedName("copy_from")
        private String copyFrom;

        // constructors, getters, setters
    }

 */
}