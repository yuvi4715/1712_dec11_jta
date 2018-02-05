package com.revature;

import static org.junit.Assert.*;

import org.junit.Test;

public class ActivityClientTest {

	@Test
	public void test() {
		ActivityClient client = new ActivityClient();
		Activity activity = client.getActivity("33");
		System.out.println(activity);
		assertNotNull(activity);
	}

}
