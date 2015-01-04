package com.beton;

import org.apache.wicket.markup.html.WebPage;

/**
 * Created by Ashot Karakhanyan on 03-01-2015
 */
public class PanelDemoPage extends WebPage {

    public PanelDemoPage() {
        add(new SamplePanel("panelId"));
        //add(new SamplePanel("panel2Id"));
    }
}
