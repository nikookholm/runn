package s112011.runn;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;

public class ShowProfile extends Fragment implements View.OnClickListener{

    View root;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root  = inflater.inflate(R.layout.fragment_show_profil, container, false);
        return root;
    }

    @Override
    public void onClick(View v) {

    }

}
