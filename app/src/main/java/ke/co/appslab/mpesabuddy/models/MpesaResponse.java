package ke.co.appslab.mpesabuddy.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MpesaResponse {

    @SerializedName("data")
    @Expose
    private Data data;
    @SerializedName("message")
    @Expose
    private String message;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
