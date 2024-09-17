package th.co.priorsolution.project.wonderlandconsumer.service;

import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import th.co.priorsolution.project.wonderlandconsumer.model.UserModel;
import th.co.priorsolution.project.wonderlandconsumer.repository.UserNativeRepository;

import java.lang.reflect.Type;
import java.util.List;

@Slf4j
@Service
public class UserService {

    private UserNativeRepository userNativeRepository;

    public UserService(UserNativeRepository userNativeRepository) {
        this.userNativeRepository = userNativeRepository;
    }

    public void createUserByNativeSql(String message) {
        try {

//            List<UserModel> x = mapper.readValue(message, List<UserModel>.class);
            Gson gson = new Gson();
            Type userListType = new TypeToken<List<UserModel>>(){}.getType();
            List<UserModel> userModels = gson.fromJson(message, userListType);

            this.userNativeRepository.insertManyUser(userModels);

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
