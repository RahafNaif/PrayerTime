package com.example.prayertime;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.PreferenceFragment;
import android.widget.Toast;

import androidx.annotation.Nullable;


public class SettingsFragment extends PreferenceFragment {

    // list prefs
    public static final String PREF_JURISTIC = "juristic";
    public static final String PREF_CALC = "calculation";
    public static final String PREF_LATITUDE = "latitude";
    public static final String PREF_TIME = "time";

    private SharedPreferences.OnSharedPreferenceChangeListener preferenceChangeListener;

    private int RG1=0;
    private int RG2=4;
    private int RG3=0;
    private int RG4=1;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.prefrences);
        //Listener for all the groups
        preferenceChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() {
            @Override
            public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
                if (key.equals(PREF_JURISTIC)) {
                    ListPreference juristicPref = (ListPreference) findPreference(key); //if you need the prefrence key similar to find by ID
                    RG1=Integer.valueOf((juristicPref.getValue()));
                    Toast.makeText(getActivity(), juristicPref.getValue(), Toast.LENGTH_SHORT).show();
                }
                if (key.equals(PREF_CALC)) {
                    ListPreference calculatePref = (ListPreference) findPreference(key);
                    RG2=Integer.valueOf((calculatePref.getValue()));

                    Toast.makeText(getActivity(), calculatePref.getValue(), Toast.LENGTH_SHORT).show();
                }
                if (key.equals(PREF_LATITUDE)) {
                    ListPreference latitudePref = (ListPreference) findPreference(key);
                    RG3=Integer.valueOf((latitudePref.getValue()));

                    Toast.makeText(getActivity(), latitudePref.getValue(), Toast.LENGTH_SHORT).show();

                }
                if (key.equals(PREF_TIME)) {
                    ListPreference timePref = (ListPreference) findPreference(key);
                    RG4=Integer.valueOf((timePref.getValue()));

                    Toast.makeText(getActivity(), timePref.getValue(), Toast.LENGTH_SHORT).show();

                }
            }
        };

    }

    @Override
    public void onResume() {
        super.onResume();

        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(preferenceChangeListener);
    }

    @Override
    public void onPause() {
        super.onPause();
        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(preferenceChangeListener);
    }
    public int getRG1(){
        return RG1;
    }
    public int getRG2(){
        return RG2;
    }
    public int getRG3(){
        return RG3;
    }
    public int getRG4(){
        return RG4;
    }

}