package com.publiss.whitelabel;

import android.app.Application;
import android.test.ApplicationTestCase;
import android.test.mock.MockContext;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    @Override
    protected void setUp() throws Exception {
//        final MockContext mockContext = new MockContext();
//        setContext(mockContext);
//        createApplication();
    }
}
