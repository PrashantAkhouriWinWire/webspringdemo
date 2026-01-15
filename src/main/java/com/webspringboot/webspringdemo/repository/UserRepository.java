package com.webspringboot.webspringdemo.repository;
import com.webspringboot.webspringdemo.entity.LoginUser;
import com.webspringboot.webspringdemo.entity.UserData;
import java.util.ArrayList;
import org.springframework.stereotype.Repository;

@Repository
public class  UserRepository
{
    public boolean validateUser(LoginUser user)
    {
        // In a real application, this method would query a database or another user store.
        // Here, we are using hardcoded values for demonstration purposes.
    return "admin".equals(user.username) && "password".equals(user.password);
    }

    //explain how caching works here in comments
    //
    //@Cacheable("userDataCache", cacheManager = "cacheManager")
    public ArrayList<UserData> getUserData()
    {
      //Make a SQL SErver DB call here to get user data
        ArrayList<UserData> userDataList = new ArrayList<UserData>();
        UserData userData = new UserData();
        userData.id = 1;
        userData.name = "John Doe";
        userData.email = "john.doe@example.com";
        userDataList.add(userData);
        return userDataList;
    }

}