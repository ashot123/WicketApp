package com.beton;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RequiredTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;
import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.IValidator;
import org.apache.wicket.validation.ValidationError;
import org.apache.wicket.validation.validator.EmailAddressValidator;
import org.apache.wicket.validation.validator.RangeValidator;

/**
 * Created by Ashot Karakhanyan on 01-01-2015
 */
public class FormValidationPage extends WebPage {

    public FormValidationPage() {
        prepareComponent();
    }

    void prepareComponent() {


        FeedbackPanel feedbackPanel = new FeedbackPanel("feedbackMessage");

        Form<?> form = new Form<Object>("form");

        TextField<String> name = new RequiredTextField<String>("name", new Model<String>());
        TextField<Integer> age = new RequiredTextField<Integer>("age", new Model<Integer>());
        TextField<String> email = new RequiredTextField<String>("email", new Model<String>());
        TextField<String> zipCode = new RequiredTextField<String>("zipCode", new Model<String>());

        age.setType(Integer.class);
        age.add(RangeValidator.range(18, 60));

        email.add(EmailAddressValidator.getInstance());

        zipCode.add(new ZipCodeValidator());

        form.add(new Button("submit") {
            @Override
            public void onSubmit() {
                super.onSubmit();
            }

        });

        add(feedbackPanel);
        add(form);

        form.add(name);
        form.add(age);
        form.add(email);
        form.add(zipCode);

    }

    private class ZipCodeValidator implements IValidator<String> {

        @Override
        public void validate(IValidatable<String> validatable) {
            String zipCode = validatable.getValue();

            if(!zipCode.startsWith("00") || zipCode.length() != 4) {
                validatable.error(new ValidationError().setMessage("Incorrect ZipCode"));
            }
        }
    }


}
