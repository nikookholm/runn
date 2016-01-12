package s112011.runn;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * Created by amal on 11/01/16.
 */
public class MinProfile extends Fragment {

  /*  ImageView contactImageView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);

        contactImageView = (ImageView) findViewById(R.id.imageViewContacteImage);
    }
    contactImageView.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v){
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intent, "Select Contac Image"),1);

        }
    });

    public void onActivityResult( int reqCode, int resCode, Intent data){
        if(resCode== RESULT_OK){
            if(resCode==1){
                contactImageView.setImageURI(data.getData());

            }
        }
    }
*/}


