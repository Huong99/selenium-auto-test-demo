package com.testek.projects.pages.pages;

import com.testek.projects.common.BasePage;
import com.testek.projects.pages.objects.DashboardObjects;
import lombok.Getter;

@Getter
public class DashboardPage extends BasePage {
    final DashboardObjects dashboardObjects = new DashboardObjects();

    public void verifyDashboardPageDisplay() {
        dashboardObjects.verifySuccessMessageDisplay();
        dashboardObjects.verifyUserIconDisplay();
        dashboardObjects.verifyProductNavigationDisplay();
    }

}
