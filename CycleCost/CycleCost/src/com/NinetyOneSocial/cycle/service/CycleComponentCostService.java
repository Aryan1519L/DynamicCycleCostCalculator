package com.NinetyOneSocial.cycle.service;

import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.NinetyOneSocial.cycle.model.ChainAssemblyBO;
import com.NinetyOneSocial.cycle.model.FrameBO;
import com.NinetyOneSocial.cycle.model.HandleBarBO;
import com.NinetyOneSocial.cycle.model.SeatingBO;
import com.NinetyOneSocial.cycle.model.WheelBO;
import com.NinetyOneSocial.cycle.util.CycleConstants;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CycleComponentCostService {
	
	public int getComponentCost(JSONObject timeSensitiveCycleObject, String componentName, String subPartKeyName, Class<?> boClass) throws JsonParseException, JsonMappingException, IOException {
		JSONArray frameComponentArray = (JSONArray)timeSensitiveCycleObject.get(componentName);
		 
		 Iterator<?> iterator = frameComponentArray.iterator();
		 
		 long sum = 0;
		 
		 while(iterator.hasNext()){
			 JSONObject componentDetails = (JSONObject) iterator.next();
			 
			 ObjectMapper mapper = new ObjectMapper();
			 
			 FrameBO frameBO;
			 HandleBarBO handleBarBO;
			 SeatingBO seatingBO;
			 WheelBO wheelBO;
			 ChainAssemblyBO chainAssemblyBO;
			 
			 if(boClass.isInstance(new FrameBO())){
				 frameBO = (FrameBO) mapper.readValue(componentDetails.toString(), boClass);
				 printSubPartCost(frameBO.getFrameName(),frameBO.getPrice());
				 sum=sum+frameBO.getPrice();
			 }else if(boClass.isInstance(new HandleBarBO())){
				 handleBarBO = (HandleBarBO) mapper.readValue(componentDetails.toString(), boClass);
				 printSubPartCost(handleBarBO.getHB_SubPart(),handleBarBO.getPrice());
				 sum=sum+handleBarBO.getPrice();
			 }else if(boClass.isInstance(new SeatingBO())){
				 seatingBO = (SeatingBO) mapper.readValue(componentDetails.toString(), boClass);
				 printSubPartCost(seatingBO.getSeatSubPart(),seatingBO.getPrice());
				 sum=sum+seatingBO.getPrice();
			 }else if(boClass.isInstance(new WheelBO())){
				 wheelBO = (WheelBO) mapper.readValue(componentDetails.toString(), boClass);
				 printSubPartCost(wheelBO.getWheelSubPart(),wheelBO.getPrice());
				 sum=sum+wheelBO.getPrice();
			 }else if(boClass.isInstance(new ChainAssemblyBO())){
				 chainAssemblyBO = (ChainAssemblyBO) mapper.readValue(componentDetails.toString(), boClass);
				 printSubPartCost(chainAssemblyBO.getCaSubPart(),chainAssemblyBO.getPrice());
				 sum=sum+chainAssemblyBO.getPrice();
			 }
			 
		 }
		 printComponetCost(componentName,sum);
		 return (int) sum;
		
	}

	public void printSubPartCost(String subPartName, long price) {
		System.out.println(CycleConstants.PRICE_OF+subPartName + CycleConstants.IS + price);
	}
	
	public void printComponetCost(String componentName, long sum) {
		System.out.println(CycleConstants.ESCAPE_SEQUENCE+CycleConstants.OVERALL_COST_OF + componentName+ CycleConstants.IS + sum + CycleConstants.ESCAPE_SEQUENCE);
	}


}
