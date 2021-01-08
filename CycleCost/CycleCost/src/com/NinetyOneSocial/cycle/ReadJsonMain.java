package com.NinetyOneSocial.cycle;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.NinetyOneSocial.cycle.model.ChainAssemblyBO;
import com.NinetyOneSocial.cycle.model.FrameBO;
import com.NinetyOneSocial.cycle.model.HandleBarBO;
import com.NinetyOneSocial.cycle.model.SeatingBO;
import com.NinetyOneSocial.cycle.model.WheelBO;
import com.NinetyOneSocial.cycle.service.CycleComponentCostService;
import com.NinetyOneSocial.cycle.util.CycleConstants;

public class ReadJsonMain extends Thread {
	
	public void run(){  
	    System.out.println("My thread is in running state.");  

		
		 JSONParser parser = new JSONParser();
		 
		 try{
			 
			 Object obj = parser.parse(new FileReader(CycleConstants.JSON_CONFIGURATION_FILENAME)); 
			 JSONObject jsonObject = (JSONObject) obj;
			 
			 Scanner inputFromKeyboard = new Scanner(System.in);
			 System.out.println(CycleConstants.SELECT_INDEX+ CycleConstants.ESCAPE_SEQUENCE +
					 CycleConstants.ONE+ CycleConstants.JAN_2016_TO_JUN_2016 + CycleConstants.ESCAPE_SEQUENCE +
					 CycleConstants.TWO+ CycleConstants.JUL_2016_TO_DEC_2016 + CycleConstants.ESCAPE_SEQUENCE +
					 CycleConstants.THREE+ CycleConstants.JAN_2017_TO_MAR_2017 + CycleConstants.ESCAPE_SEQUENCE);
			 
			 int index = inputFromKeyboard.nextInt();
			 inputFromKeyboard.close();
			 
			 String chosenPeriod = null;
			 
			 switch(index){
				 case 1: chosenPeriod = CycleConstants.JAN_2016_TO_JUN_2016; break;
				 case 2: chosenPeriod = CycleConstants.JUL_2016_TO_DEC_2016; break;
				 case 3: chosenPeriod = CycleConstants.JAN_2017_TO_MAR_2017; break;
				 default: System.out.println(CycleConstants.CONFIGURATION_NOT_AVAILABLE); throw new Exception();
			 }
			 
			 JSONObject timeSensitiveCycleObject = (JSONObject) jsonObject.get(chosenPeriod);
			 
			 CycleComponentCostService cycleComponentCostService = new CycleComponentCostService();
			 
			 int cycleSum=0;
			 cycleSum+=cycleComponentCostService.getComponentCost(timeSensitiveCycleObject,CycleConstants.FRAME,CycleConstants.FRAME_SUBPART,FrameBO.class);
			 cycleSum+=cycleComponentCostService.getComponentCost(timeSensitiveCycleObject,CycleConstants.HANDLE_BAR,CycleConstants.HANDLE_BAR_SUBPART,HandleBarBO.class);
			 cycleSum+=cycleComponentCostService.getComponentCost(timeSensitiveCycleObject,CycleConstants.SEATING,CycleConstants.SEATING_SUBPART,SeatingBO.class);
			 cycleSum+=cycleComponentCostService.getComponentCost(timeSensitiveCycleObject,CycleConstants.WHEEL,CycleConstants.WHEEL_SUBPART,WheelBO.class);
			 cycleSum+=cycleComponentCostService.getComponentCost(timeSensitiveCycleObject,CycleConstants.CHAIN_ASSEMBLY,CycleConstants.CHAIN_ASSEMBLY_SUBPART,ChainAssemblyBO.class);
			 
			 cycleComponentCostService.printComponetCost(CycleConstants.CYCLE, cycleSum);
			 
		 }catch(FileNotFoundException e){
			 System.out.println(CycleConstants.FILE_NOT_FOUND_EXCEPTION);
			 e.printStackTrace();
		 }catch(IOException e){
			 System.out.println(CycleConstants.IO_EXCEPTION);
			 e.printStackTrace();
		 }catch(ParseException e){
			 System.out.println(CycleConstants.PARSE_EXCEPTION);
			 e.printStackTrace();
		 }catch(Exception e){
			 System.out.println(CycleConstants.EXCEPTION);
			 e.printStackTrace();
		 }
	
	  }
	
	public static void main(String[] args){
		ReadJsonMain cycleCostThreadObject=new ReadJsonMain();   
		cycleCostThreadObject.start(); 
	}

	
}
