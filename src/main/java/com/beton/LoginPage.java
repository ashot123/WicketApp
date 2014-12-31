package com.beton;

import com.beton.model.UserModel;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.PropertyModel;

/**
 * Created by Ashot Karakhanyan on 31-12-2014
 */
public class LoginPage extends WebPage {

    public LoginPage() {

        final UserModel userModel = new UserModel();
        Form<?> form = new Form<Object>("form");

        form.add(new TextField<String>("userName", new PropertyModel<String>(userModel, "name")));
        form.add(new PasswordTextField("password", new PropertyModel<String>(userModel, "password")));


        form.add(new Button("submit") {
            @Override
            public void onSubmit() {
                super.onSubmit();

                if(userModel.getName().equalsIgnoreCase("admin") && userModel.getPassword().equals("admin")) {
                    UserSession.getInstance().setUserModel(userModel);
                    setResponsePage(MainPage.class);
                } else {
                    System.out.println("Invalid username or password");
                }
            }
        });

        add(form);
    }
}
