package com.example.philippine.mysterynumber;

import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ContactFormFragment extends Fragment {

    private MainActivity mActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final View view = inflater.inflate(R.layout.fragment_contact_form, container, false);

        final EditText your_name        =  view.findViewById(R.id.your_name);
        final EditText your_email       = view.findViewById(R.id.your_email);
        final EditText your_tel         = view.findViewById(R.id.your_tel);
        final EditText your_firstname   = view.findViewById(R.id.your_firstname);

        ((Button) view.findViewById(R.id.next)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                game(view);
            }
        });

        Button email = view.findViewById(R.id.post_message);
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {

                String name      = your_name.getText().toString();
                String email     = your_email.getText().toString();
                String tel   = your_tel.getText().toString();
                String firstname   = your_firstname.getText().toString();

                if (TextUtils.isEmpty(name)){
                    your_name.setError("Entrez votre nom");
                    your_name.requestFocus();
                    return;
                }

                Boolean onError = false;
                if (!isValidEmail(email)) {
                    onError = true;
                    your_email.setError("E-mail Invalide");
                    return;
                }

                if (TextUtils.isEmpty(tel)){
                    your_tel.setError("Entrez votre numéro de telephone");
                    your_tel.requestFocus();
                    return;
                }

                if (TextUtils.isEmpty(firstname)){
                    your_firstname.setError("Entrez votre prénom");
                    your_firstname.requestFocus();
                    return;
                }

                Intent sendEmail = new Intent(android.content.Intent.ACTION_SEND);


                sendEmail.setType("message/rfc822");
                sendEmail.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"philippine_l@live.fr"});
                sendEmail.putExtra(android.content.Intent.EXTRA_SUBJECT, "Votre inscription au concours de Mystery Number");
                sendEmail.putExtra(android.content.Intent.EXTRA_TEXT,
                        "Nom:"+name+'\n'+"Prénom:"+firstname+'\n'+"Email:"+email+'\n'+"Numéro de télèphone:"+'\n'+tel);


                startActivity(Intent.createChooser(sendEmail, "Envoyer..."));


            }
        });
        return view;
    }

    public void game(View view) {
        FragmentTransaction transaction =  mActivity.getFragmentManager().beginTransaction();
        transaction.replace(R.id.container, new GameFragment());
        transaction.commit();
    }

    // validating email id

    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (MainActivity) context;
    }


}