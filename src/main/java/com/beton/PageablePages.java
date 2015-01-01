package com.beton;

import com.beton.model.UserModel;
import org.apache.wicket.ajax.markup.html.navigation.paging.AjaxPagingNavigation;
import org.apache.wicket.ajax.markup.html.navigation.paging.AjaxPagingNavigator;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.PageableListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ashot Karakhanyan on 01-01-2015
 */
public class PageablePages extends WebPage {

    public PageablePages() {

        PageableListView<?> pageableListView = new PageableListView<Object>("rows", getUserModelList(), 10) {
            @Override
            protected void populateItem(ListItem<Object> item) {
                UserModel userModel = (UserModel) item.getDefaultModelObject();
                item.add(new Label("name", userModel.getName()));
                item.add(new Label("gender", userModel.getGender()));
            }
        };

        add(pageableListView);

        add(new AjaxPagingNavigator("nav", pageableListView));
    }

    private List<UserModel> getUserModelList() {
        List<UserModel> userModels = new ArrayList<UserModel>();

        for (int i = 0; i < 100; i++) {
            userModels.add(new UserModel("Name " + i, i % 2 == 0 ? "Male" : "Female"));
        }

        return userModels;
    }
}
