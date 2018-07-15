package com.master.killercode.ninjahide;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class NinjaHide {

    private static int fim = 20;
    private static int inicio_mgs = 15;
    private static int inicio = 0;
    /**
     *
     */
    @SuppressLint("StaticFieldLeak")
    private static TextView tvInfo;

    /**
     * @param activity
     */
    private static void initTextView(Activity activity) {
        tvInfo = new TextView(activity);
    }

    /**
     * @param activity
     * @return
     */
    public static TextView getTextView(Activity activity) {
        if (tvInfo == null) {
            initTextView(activity);
            return tvInfo;
        } else {
            return tvInfo;
        }
    }

    /**
     * @param activity
     * @param linearLayout
     */
    @SuppressLint({"ResourceType", "SetTextI18n"})
    public static void makeSetVersion(final Activity activity, ViewGroup linearLayout) {

        String app_name = activity.getResources().getString(R.string.app_name);
        int color = activity.getResources().getColor(R.color.Color_Palet_Flat_SILVER);

        initTextView(activity);
        tvInfo.setId(2000);
        tvInfo.setTextColor(color);
        tvInfo.setText(app_name + " V" + BuildConfig.VERSION_NAME);
        linearLayout.addView(tvInfo);

//        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.MATCH_PARENT, // Width of TextView
//                LinearLayout.LayoutParams.WRAP_CONTENT); // Height of TextView
//
//        lp.gravity = Gravity.CENTER | Gravity.BOTTOM;
////
//        // Apply the layout parameters to TextView widget
//        linearLayout.setLayoutParams(lp);
//        linearLayout.setOrientation(LinearLayout.VERTICAL);
//        linearLayout.setGravity(1);

    }


    @SuppressLint({"ResourceType", "SetTextI18n"})
    public static void makeSetVersion(final Activity activity, LinearLayout linearLayout, View hideShow) {

        String app_name = activity.getResources().getString(R.string.app_name);
        int color = activity.getResources().getColor(R.color.Color_Palet_Flat_SILVER);

        initTextView(activity);
        tvInfo.setId(2000);
        tvInfo.setTextColor(color);
        tvInfo.setText(app_name + " V" + BuildConfig.VERSION_NAME);
        linearLayout.addView(tvInfo);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, // Width of TextView
                LinearLayout.LayoutParams.WRAP_CONTENT); // Height of TextView

        lp.gravity = Gravity.CENTER | Gravity.BOTTOM;

        // Apply the layout parameters to TextView widget
        linearLayout.setLayoutParams(lp);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        linearLayout.setGravity(1);

        if (getHidding(activity)) {
            inicio = fim + 1;
            hideShow.setVisibility(View.VISIBLE);
        }

        makeShow(activity, linearLayout, hideShow);

    }

    private static void makeShow(final Activity activity, LinearLayout linearLayout, final View ll_btn_debug) {

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (getHidding(activity)) {
                    Funcao_Chama_Frases(activity);
                } else {

                    if (inicio < inicio_mgs) {
                        inicio++;
                    } else if (inicio >= inicio_mgs) {

                        int falta = fim - inicio;
                        String msg = "";
                        if (falta == 1) {
                            msg = falta + " vez";
                        } else {
                            msg = falta + " vezes";
                        }

                        if (inicio >= fim) {
                            setShowDebug(activity);
                            ll_btn_debug.setVisibility(View.VISIBLE);
                            showMsg(activity, "Menu de Cheats Liberado!");
//                            ToolBox_RingTone.Funcao_Play(activity);
                            inicio++;
                        } else {
                            showMsg(activity,  "Toque mais " + msg + " Para Liberar os Cheats!");
                            inicio++;
                        }

                    }
                }
            }
        });

    }

    private static void Funcao_Chama_Frases(Activity activity) {
        final Random n = new Random();
        String msg = "";
        int sw = n.nextInt(9) + 1;

        switch (sw) {
            case 1:
                msg = "Vai procurar oque fazer!";
                break;
            case 2:
                msg = "Você quer mais oque?";
                break;
            case 3:
                msg = "BURRO! Já está habilitado o menu!";
                break;
            case 4:
                msg = "Cara, sai dessa!";
                break;
            case 5:
                msg = "Porque ainda está clicando aqui?";
                break;
            case 6:
                msg = "Man, nem falo nada!";
                break;
            case 7:
                msg = "Debug habilitado!";
                break;
            case 8:
                msg = "Não sei você já percebeu, mas...";
                break;
            case 9:
                msg = "Porque clicas aqui?";
                break;
            case 10:
                msg = "Velho sai fora!";
                break;
        }

        showMsg(activity, msg);
    }

    private static final String CONSTANTE_SHAREDPREFS_DO_PROJETO = "ninjahide";
    private static SharedPreferences Prefs;

    private static void setShowDebug(Activity activity) {
        Prefs = activity.getSharedPreferences(CONSTANTE_SHAREDPREFS_DO_PROJETO, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = Prefs.edit();
        editor.putBoolean(CONSTANTE_SHAREDPREFS_DO_PROJETO, true);
        editor.apply();
    }

    private static Boolean getHidding(Activity activity) {
        Prefs = activity.getSharedPreferences(CONSTANTE_SHAREDPREFS_DO_PROJETO, Context.MODE_PRIVATE);
        return Prefs.getBoolean(CONSTANTE_SHAREDPREFS_DO_PROJETO, false);
    }

    private static void showMsg(Activity activity, String msg) {
        Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show();
    }


}
