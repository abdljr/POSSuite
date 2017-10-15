package possuite.ilabamo;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class ApplicationPreferenceManager {

    private SharedPreferences appSharedPrefs;
    private static final String APP_SHARED_PREFS = "possuite-preferences";

    private static final String COMPANY_NAME = "ilabamo.db";
    private static final String DATABASE_NAME = COMPANY_NAME.toLowerCase()+".db";
    private static final String REPRINT_JO_CNT = "REPRINT_JO_CNT";
    private static final String DEVICE_ID = "DEVICE_ID";

    private SharedPreferences.Editor prefsEditor;

    public ApplicationPreferenceManager(Context context) {
        this.appSharedPrefs = context.getSharedPreferences(APP_SHARED_PREFS, Activity.MODE_PRIVATE);
        this.prefsEditor = appSharedPrefs.edit();

    }
    public void saveCompanyName(String token) {
        prefsEditor.putString(COMPANY_NAME, token);
        prefsEditor.commit();
    }
    public String loadCompanyName() {
        return appSharedPrefs.getString(COMPANY_NAME, "");
    }

    public void saveDatabaseName(String token) {
        prefsEditor.putString(DATABASE_NAME, token);
        prefsEditor.commit();
    }
    public String loadDatabaseName() {
        return appSharedPrefs.getString(DATABASE_NAME, "");
    }

    public void saveReprintCnt(int token) {
        prefsEditor.putInt(REPRINT_JO_CNT, token);
        prefsEditor.commit();
    }public int loadReprintCnt() {
        return appSharedPrefs.getInt(REPRINT_JO_CNT, 0);
    }
    public void saveDeviceID(String token) {
        prefsEditor.putString(DEVICE_ID, token);
        prefsEditor.commit();
    }public String loadDeviceID() {
        return appSharedPrefs.getString(DEVICE_ID, "");
    }

}
