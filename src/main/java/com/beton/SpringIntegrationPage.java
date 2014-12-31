package com.beton;

import com.beton.model.UserModel;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

/**
 * Created by Ashot Karakhanyan on 31-12-2014
 */
public class SpringIntegrationPage extends WebPage {


    @SpringBean(name = "userModel")
    private UserModel userModel;

    public SpringIntegrationPage() {

        add(new Label("nameLabel", new PropertyModel<String>(userModel, "name")));
        add(new Label("genderLabel", new PropertyModel<String>(userModel, "gender")));
    }
}
