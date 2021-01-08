package com.NinetyOneSocial.cycle.JUnitTestCase;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import com.NinetyOneSocial.cycle.model.FrameBO;
import com.NinetyOneSocial.cycle.service.CycleComponentCostService;

public class CheckComponentCost {

	@Test
	public void test() throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("CycleConfiguration.json")); 
		JSONObject jsonObject = (JSONObject) obj;
		JSONObject timeSensitiveCycleObject = (JSONObject) jsonObject.get("JAN 2016 - JUN 2016");
		
		CycleComponentCostService cycleComponentCostService = new CycleComponentCostService();
		int result = cycleComponentCostService.getComponentCost(timeSensitiveCycleObject, "FRAME", "frameName", FrameBO.class);
		assertEquals(4742,result);
	}

}
