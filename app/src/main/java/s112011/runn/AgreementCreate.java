package s112011.runn;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class AgreementCreate extends Fragment implements View.OnClickListener {

Button ok;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.content_agreement_create, container, false);

        ok = (Button) root.findViewById(R.id.button);
        ok.setOnClickListener(this);


        return root;
    }

    @Override
    public void onClick(View v) {
        Fragment fragment = new listAgreements();
        getFragmentManager().beginTransaction()
                .replace(R.id.fragmentView, fragment )
                .addToBackStack(null)
                .commit();
    }
}
