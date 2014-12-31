package com.beton;

import com.beton.model.UserModel;
import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;

/**
 * Created by Ashot Karakhanyan on 31-12-2014
 */
public class UserSession extends WebSession {

    private UserModel userModel;

    /**
     * Constructor. Note that {@link RequestCycle} is not available until this constructor returns.
     *
     * @param request The current request
     */
    public UserSession(Request request) {
        super(request);
    }

    public static UserSession getInstance() {
        return (UserSession) Session.get();

    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }
}
