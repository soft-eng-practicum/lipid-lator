package teamtriplej.com.lipidlator21;

import android.app.Activity;
import android.app.Instrumentation;
import android.support.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertNotNull;


/* @Author: Joseph Tsegaye
 * @Date: 11/10/2017
 */
public class SystemTestCHE {

    @Rule
    public ActivityTestRule<HomeActivity> homeActivityActivityTestRule = new ActivityTestRule<>(HomeActivity.class);
    private HomeActivity mhomeActivity = null;
    private Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(CholesterylEsters_Result_Activity.class.getName(),null,false);



    //Declaring and initialize the variable
    @Before
    public void setUp() throws Exception {
        mhomeActivity = homeActivityActivityTestRule.getActivity();
    }

    @Test
    public void fullTest() {
        assertNotNull(mhomeActivity.findViewById(R.id.imbtnCholesterylEsters));
        onView(withId(R.id.imbtnCholesterylEsters)).perform(click());
        mhomeActivity.findViewById(R.id.spnIon);
        mhomeActivity.findViewById(R.id.btnSubmit);
        onView(withId(R.id.btnSubmit)).perform(click());
        Activity CholesterolEster_Result = getInstrumentation().waitForMonitorWithTimeout(monitor,5000);
        assertNotNull(CholesterolEster_Result);
        mhomeActivity.findViewById(R.id.btnBack);
        onView(withId(R.id.btnBack)).perform(click());
        mhomeActivity.findViewById(R.id.btnSubmit);
        onView(withId(R.id.btnSubmit)).perform(click());
        mhomeActivity.findViewById(R.id.btnBack);
        onView(withId(R.id.btnBack)).perform(click());
        assertNotNull(mhomeActivity);
    }

    @After
    public void tearDown() throws Exception {
        mhomeActivity = null;
    }
}