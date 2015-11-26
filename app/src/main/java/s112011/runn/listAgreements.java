package s112011.runn;


import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;



public class listAgreements extends Fragment implements AdapterView.OnItemClickListener{


    /**
     * Created by KimDrewes on 18-11-2015.
     */


        View rod;

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            rod = inflater.inflate(R.layout.fragment_list_agreements, container, false);


            String[] lande = {"Hent ord fra DR", "Ikke implementeret","Ikke implementeret","Ikke implementeret","Ikke implementeret"};

            ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, lande);

            ListView listView =(ListView) rod.findViewById(R.id.listView);
            listView.setOnItemClickListener(this);
            listView.setAdapter(adapter);




            return rod;
        }


        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {



        }
    }




