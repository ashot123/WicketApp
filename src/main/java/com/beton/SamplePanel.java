package com.beton;

import com.beton.model.UserModel;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.PropertyModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ashot Karakhanyan on 30-12-2014
 */
public class SamplePanel extends Panel {


    private boolean visible = true;
    public SamplePanel(String id) {
        super(id);

        List<String> genderChoices = new ArrayList<String>();
        genderChoices.add("Male") ;
        genderChoices.add("Female");

        final UserModel userModel = new UserModel();

        Form<?> form = new Form("form");

        final TextField<String> text = new TextField<String>("text", new PropertyModel<String>(userModel, "name"));
        text.setOutputMarkupPlaceholderTag(true);
        text.setOutputMarkupId(true);

        final DropDownChoice<String> gender =
                new DropDownChoice<String>("gender", new PropertyModel<String>(userModel, "gender"), genderChoices);
        gender.setOutputMarkupPlaceholderTag(true);
        gender.setOutputMarkupId(true);

        AjaxButton ajaxButton = new AjaxButton("submit") {

            @Override
            protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
                super.onSubmit(target, form);

                visible = !visible;
                //text.setEnabled(false);
                //gender.setEnabled(false);

                text.setVisible(visible);
                gender.setVisible(visible);

                target.add(text);
                target.add(gender);
            }
        };

        add(form);
        form.add(text);
        form.add(gender);
        form.add(ajaxButton);
    }
}
