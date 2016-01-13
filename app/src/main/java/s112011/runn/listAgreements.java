package s112011.runn;


import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.support.v4.app.Fragment;

import java.util.ArrayList;


public class listAgreements extends Fragment implements AdapterView.OnItemClickListener{

    ProfileDAO pDAO = new ProfileDAO();

    //ArrayList<ProfileDTO> p = pDAO.getProfile();

    View rod;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rod = inflater.inflate(R.layout.activity_list_agreements, container, false);

     //   final ProfileAdapter adapter = new ProfileAdapter(getActivity(), p) ;

        ListView listView =(ListView) rod.findViewById(R.id.listView);
        listView.setOnItemClickListener(this);
       // listView.setAdapter(adapter);

        return rod;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Fragment fragment = new AgreementView();
        getFragmentManager().beginTransaction()
                .replace(R.id.fragmentView, fragment )
                .addToBackStack(null)
                .commit();
    }


}
