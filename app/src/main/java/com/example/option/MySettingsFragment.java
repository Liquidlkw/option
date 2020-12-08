package com.example.option;

import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.preference.EditTextPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;

public class MySettingsFragment extends PreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.preferences, rootKey);
        EditTextPreference signaturePreference = findPreference("signature");

        if (signaturePreference!=null){
            signaturePreference.setSummaryProvider(new Preference.SummaryProvider<EditTextPreference>() {
                @Override
                public CharSequence provideSummary(EditTextPreference  preference) {
                    String text = preference.getText();
                    if (TextUtils.isEmpty(text)){
                        return "展示没有签名噢噢噢噢";
                    }
                    return "Length of saved value: " + text.length()+"  "+text;
                }
            });



            signaturePreference.setOnPreferenceClickListener(preference -> {
                // do something
                Toast.makeText(getActivity(), "✌被点击了！！！", Toast.LENGTH_SHORT).show();
                return true;
            });
        }


        EditTextPreference numberPreference = findPreference("number");

        if (numberPreference != null) {
            numberPreference.setOnBindEditTextListener(
                    new EditTextPreference.OnBindEditTextListener() {
                        @Override
                        public void onBindEditText(@NonNull EditText editText) {
                            editText.setInputType(InputType.TYPE_CLASS_NUMBER);
                        }
                    });

            numberPreference.setSummaryProvider(new Preference.SummaryProvider<EditTextPreference>() {
                @Override
                public CharSequence provideSummary(EditTextPreference preference) {
                    String text = preference.getText();
                    return text;
                }
            });

        }

    }


}
