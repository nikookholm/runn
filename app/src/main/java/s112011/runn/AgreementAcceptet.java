package s112011.runn;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class AgreementAcceptet extends android.support.v4.app.Fragment implements View.OnClickListener {

    View root;
    Button ok;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_agreement_acceptet, container, false);
        ok = (Button) root.findViewById(R.id.okBtn);
        ok.setOnClickListener(this);
        return root;
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(getActivity(), "DU er blevet tilmeldt", Toast.LENGTH_SHORT).show();
        if (v== ok ) {
            android.support.v4.app.Fragment create = new listAgreements();
            getFragmentManager().beginTransaction()
                    .replace(R.id.fragmentView, create)  // tom container i layout
                    .commit();
        }
    }

}