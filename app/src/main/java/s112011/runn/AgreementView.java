package s112011.runn;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.ImageView;


public class AgreementView extends Fragment implements View.OnClickListener{

    ImageView iv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_agreement_view, container, false);

        iv = (ImageView) root.findViewById(R.id.imageView2);
        iv.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View v) {
        Fragment fragment = new showProfil();
        getFragmentManager().beginTransaction()
                .replace(R.id.fragmentView, fragment )
                .addToBackStack(null)
                .commit();
    }
    }

