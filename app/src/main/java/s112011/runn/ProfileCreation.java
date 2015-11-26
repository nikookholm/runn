package s112011.runn;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class ProfileCreation extends Fragment implements View.OnClickListener {

    View root;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root  = inflater.inflate(R.layout.profile_creation, container, false);
        return root;
    }


    @Override
    public void onClick(View v) {

    }
}
