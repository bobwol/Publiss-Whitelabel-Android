package com.publiss.coreapp;

import android.app.AlertDialog;
import android.os.Bundle;

import com.publiss.core.PublissConfig;
import com.publiss.core.ui.menu.*;

public class KioskActivity extends com.publiss.core.ui.KioskActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final KioskActivity self = this;

        MenuItem homepageMenuItem = new MenuItem("Visit Publiss", false, new MenuItemCallbacks() {
            @Override
            public void menuItemSelected(MenuItem menuItem) {
                String url = getString(com.publiss.core.R.string.publiss_hompage_link);
                startOpenInBrowserActivity(url);
            }
        });

        MenuItem aboutMenuItem = new MenuItem("About Publiss", false, new MenuItemCallbacks() {
            @Override
            public void menuItemSelected(MenuItem menuItem) {
                AlertDialog.Builder builder = new AlertDialog.Builder(self);
                builder.setTitle(getString(com.publiss.core.R.string.app_name));
                builder.setMessage("Version " + com.publiss.core.BuildConfig.VERSION_NAME);
                builder.setPositiveButton("OK", null);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        MenuItem contactMenuItem = new MenuItem("Contact", false, new MenuItemCallbacks() {
            @Override
            public void menuItemSelected(MenuItem menuItem) {
                String mailBody = getString(com.publiss.core.R.string.feedback_body);
                String receiver = getString(com.publiss.core.R.string.feedback_to);
                String subject = getString(com.publiss.core.R.string.feedback_subject);
                startFeedbackActivity(receiver, subject, mailBody);
            }
        });

        LoginLogoutMenuItem loginLogoutMenuItem = new LoginLogoutMenuItem(this, "Login", "Logout", true, new MenuItemCallbacks() {
            @Override
            public void menuItemSelected(MenuItem menuItem) {
                openLoginActivityOrLogout();
            }
        });
        loginLogoutMenuItem.setLogoutSubTitle(PublissConfig.getLoginValue(this, "email"));

        MenuItemManager.getInstance().clearMenuItems();
        MenuItemManager.getInstance().addMenuItem(homepageMenuItem);
        MenuItemManager.getInstance().addMenuItem(aboutMenuItem);
        MenuItemManager.getInstance().addMenuItem(contactMenuItem);
        MenuItemManager.getInstance().addMenuItem(loginLogoutMenuItem);
    }

}
