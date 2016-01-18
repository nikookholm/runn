package s112011.runn;

import android.app.Application;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;


/**
 * Created by Doggystyle on 14-01-2016.
 */
public class FireBaseTest {


    public static void main(String[] args)
    {
        new FireBaseTest();
    }

    public FireBaseTest()
    {
        ProfileDAO dao = new ProfileDAO();
        ProfileDTO dto = new ProfileDTO();
        try {
            dto = dao.getProfile(1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(dto.getUsername());

    }



}
