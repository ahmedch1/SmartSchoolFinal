package networkinbox;

import java.util.List;

import modelinbox.Message;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Ahmed Chouihi on 09-06-2017.
 */

public interface ApiInterface {

    @GET("inbox.json")
    Call<List<Message>> getInbox();

}