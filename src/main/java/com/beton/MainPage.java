package com.beton;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;

/**
 * Created by Ashot Karakhanyan on 31-12-2014
 */
public class MainPage extends WebPage {

    public MainPage() {

        add(new Label("message", new Model<String>(UserSession.getInstance().getUserModel().getName())));

        add(new Link<String>("signOut") {
            @Override
            public void onClick() {
                UserSession.getInstance().invalidate();
                setResponsePage(LoginPage.class);
            }
        });
    }
}
