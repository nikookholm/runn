package s112011.runn;

import java.util.List;

/**
 * Created by Doggystyle on 18-01-2016.
 */
public interface iDAOEvent {

    public void Execute();

    void Execute(List<ProfileDTO> profileDTOs);
}
