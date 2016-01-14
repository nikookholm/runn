package s112011.runn;

import android.app.Application;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.firebase.client.Firebase;

/**
 * Created by Doggystyle on 14-01-2016.
 */
public class FireBaseTest {


    //public static void main(String[] args)
    //{
    //    new FireBaseTest();
    //}

    public FireBaseTest()
    {
        Firebase fb = new Firebase(FirebaseConnection.URL + "profiles");;
    }



}
