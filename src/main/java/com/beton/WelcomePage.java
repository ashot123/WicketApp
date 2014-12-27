package com.beton;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.Model;

/**
 * Created by Ashot Karakhanyan on 27-12-2014
 */
public class WelcomePage extends WebPage {

    public WelcomePage() {
        add(new Label("lbl", new Model<String>("This is the first page")));
    }
}
