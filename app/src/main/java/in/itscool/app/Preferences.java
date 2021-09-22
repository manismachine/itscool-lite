package in.itscool.app;

import android.content.Context;
import android.content.SharedPreferences;


public class Preferences {
    SharedPreferences savepref;
    Context mContext;

    public Preferences(Context context) {
        this.mContext = context;
        this.savepref = mContext.getSharedPreferences("savepref", 0);
    }

    //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    public String getMainUrl() {
        return this.savepref.getString("MainUrl","");
    }
    public void setMainUrl(String res) {
        SharedPreferences.Editor editor = this.savepref.edit();
        editor.putString("MainUrl", res);
        editor.apply();
    }

    //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
}
