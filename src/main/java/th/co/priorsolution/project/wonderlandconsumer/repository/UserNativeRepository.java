package th.co.priorsolution.project.wonderlandconsumer.repository;


import th.co.priorsolution.project.wonderlandconsumer.model.UserModel;

import java.util.List;

public interface UserNativeRepository {

    public int insertManyUser(List<UserModel> userModels);

}
