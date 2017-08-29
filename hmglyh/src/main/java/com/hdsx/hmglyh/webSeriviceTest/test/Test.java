package com.hdsx.hmglyh.webSeriviceTest.test;

import com.hdsx.hmglyh.webSeriviceTest.service.CommonWebService;
import com.hdsx.hmglyh.webSeriviceTest.service.CommonWebService_Service;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CommonWebService_Service service=new CommonWebService_Service();
		CommonWebService s = service.getCommonWebServiceImplPort();
		
		//企业资质列表
//		System.out.println("============企业基本信息列表==========");
//		System.out.println(s.getCorporationRegistration("610100", ""));//610100
//		
//		//企业资质列表
//		System.out.println("============企业资质列表==========");
//		System.out.println(s.getCorporationAptitudeList("62590614-4", ""));//91110000625906144E
//		
//		//企业信用列表
//		System.out.println("============企业信用列表==========");
//		System.out.println(s.getCorporationCreditList("62590614-4",""));
//		
//		//企业财务列表
//		System.out.println("============企业财务列表==========");
//		System.out.println(s.getCorporationFinanceList("62590614-4", ""));
		
		//企业业绩列表
//		System.out.println("============企业业绩列表==========");
//		System.out.println(s.getCorporationPerformanceList("19043517-8", ""));//19043517-8,62590614-4,72235490-0
		
		//企业奖励列表
//		System.out.println("============企业奖励列表==========");
//		System.out.println(s.getCorporationRagList("72235490-0", ""));
//		
//		//项目信息列表
		System.out.println("============项目信息列表==========");
		System.out.println(s.getProjectInfoList("150000",""));//610000
//	
//		//标段信息列表
//		System.out.println("============标段信息列表==========");
//		System.out.println(s.getTendersList("2483bda6-982a-4644-810e-8a4b4babcf21","" ));
//		
//		System.out.println("============人员信息列表==========");
//		System.out.println(s.getPractitionersInfoList("91430111183977227F", ""));//18397722-7
//
//		System.out.println("============人员业绩==========");
//		System.out.println(s.getPractitionersResultsList("9137088216608112XA", ""));//16608112-X
//		
//		System.out.println("============人员奖励==========");
//		System.out.println(s.getPractitionersRIList("91110000100001916P", ""));//10000191-6
//		
//		System.out.println("============人员职称==========");
//		System.out.println(s.getPractitionersTitleList("11010451-3", ""));//91110000625906144E

	}

}
