package com.beton;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Fragment;
import org.apache.wicket.model.Model;

/**
 * Created by Ashot Karakhanyan on 27-12-2014
 */
public class WelcomePage extends WebPage {


    private String action;

    public WelcomePage(String action) {

        //add(new SamplePanel("panelId"));
        //add(new SamplePanel("panel2Id"));
        this.action = action;
        addComponents();

    }

    private void addComponents() {
        Form<?> form = new Form<Object>("form");

        Fragment fragment;
        if (action.equalsIgnoreCase("view")) {
            fragment = new Fragment("container", "viewFragment", this);
            fragment.add(new Label("label", new Model<String>("Hello World")));
        } else {
            fragment = new Fragment("container", "editFragment", this);
            fragment.add(new TextField<String>("textField", new Model<String>("Hello World")));
        }

        form.add(fragment);
        add(form);
    }
}
