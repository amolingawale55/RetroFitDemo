package Utils;

import Models.SOAnswersResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by amol on 11/30/2017.
 */

public interface RetroInterface {

   // public static String BASE_URL="http://onlineaimsapi.azurewebsites.net/";
    public static final String BASE_URL = "https://api.stackexchange.com/2.2/";

    @GET("/answers?order=desc&sort=activity&site=stackoverflow")
    Call<SOAnswersResponse> getAnswers();

//    @GET("/answers?order=desc&sort=activity&site=stackoverflow")
//    Call<SOAnswersResponse> getAnswers(@Query("tagged") String tags);




}
