package com.beton;

import com.beton.model.UserModel;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ashot Karakhanyan on 27-12-2014
 */
public class WelcomePage extends WebPage {


    public WelcomePage() {

        //add(new SamplePanel("panelId"));
        //add(new SamplePanel("panel2Id"));

        Form<?> form = new Form<Object>("form");

        final TextField<String> textField = new TextField<String>("textField", new Model<String>());
        textField.setOutputMarkupId(true);
        textField.setOutputMarkupPlaceholderTag(true);
        form.add(textField);

        form.add(new AjaxButton("submit") {
            @Override
            protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
                super.onSubmit(target, form);

                textField.setVisible(!textField.isVisible());

                target.add(textField);
            }
        });

        add(form);

    }
}
