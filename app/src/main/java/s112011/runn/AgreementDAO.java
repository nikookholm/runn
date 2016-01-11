package s112011.runn;

import java.util.ArrayList;

/**
 * Created by nehfi on 11-01-16.
 */
public class AgreementDAO {

    public ArrayList<AgreementDTO> agreements;

    public AgreementDAO(){
        agreements = new ArrayList<AgreementDTO>();
    }

    public ArrayList<AgreementDTO> getAgreements(){
        return agreements;
    }
}
