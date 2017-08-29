package com.hdsx.hmglyh.webSeriviceTest.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * This class was generated by the JAX-WS RI. JAX-WS RI 2.1.3-hudson-390-
 * Generated source version: 2.0
 * 
 */
@WebService(name = "CommonWebService", targetNamespace = "http://service.bmds.com/")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface CommonWebService {

	/**
	 * 
	 * @param corpCode
	 * @param lastUpdateDate
	 * @return returns java.lang.String
	 */
	@WebMethod
	@WebResult(partName = "return")
	public String getPractitionersRecognitionList(
			@WebParam(name = "corpCode", partName = "corpCode") String corpCode,
			@WebParam(name = "lastUpdateDate", partName = "lastUpdateDate") String lastUpdateDate);

	/**
	 * 
	 * @param corpCode
	 * @param lastUpdateDate
	 * @return returns java.lang.String
	 */
	@WebMethod
	@WebResult(partName = "return")
	public String getPractitionersTapList(
			@WebParam(name = "corpCode", partName = "corpCode") String corpCode,
			@WebParam(name = "lastUpdateDate", partName = "lastUpdateDate") String lastUpdateDate);

	/**
	 * 
	 * @param corpCode
	 * @param lastUpdateDate
	 * @return returns java.lang.String
	 */
	@WebMethod
	@WebResult(partName = "return")
	public String getPractitionersIcList(
			@WebParam(name = "corpCode", partName = "corpCode") String corpCode,
			@WebParam(name = "lastUpdateDate", partName = "lastUpdateDate") String lastUpdateDate);

	/**
	 * 
	 * @param corpCode
	 * @param lastUpdateDate
	 * @return returns java.lang.String
	 */
	@WebMethod
	@WebResult(partName = "return")
	public String getPractitionersQualificationList(
			@WebParam(name = "corpCode", partName = "corpCode") String corpCode,
			@WebParam(name = "lastUpdateDate", partName = "lastUpdateDate") String lastUpdateDate);

	/**
	 * 
	 * @param corpCode
	 * @param lastUpdateDate
	 * @return returns java.lang.String
	 */
	@WebMethod
	@WebResult(partName = "return")
	public String getPractitionersOtherList(
			@WebParam(name = "corpCode", partName = "corpCode") String corpCode,
			@WebParam(name = "lastUpdateDate", partName = "lastUpdateDate") String lastUpdateDate);

	/**
	 * 
	 * @param corpCode
	 * @param lastUpdateDate
	 * @return returns java.lang.String
	 */
	@WebMethod
	@WebResult(partName = "return")
	public String getCorporationRagList(
			@WebParam(name = "corpCode", partName = "corpCode") String corpCode,
			@WebParam(name = "lastUpdateDate", partName = "lastUpdateDate") String lastUpdateDate);

	/**
	 * 
	 * @param corpCode
	 * @param lastUpdateDate
	 * @return returns java.lang.String
	 */
	@WebMethod
	@WebResult(partName = "return")
	public String getCorporationPerformanceList(
			@WebParam(name = "corpCode", partName = "corpCode") String corpCode,
			@WebParam(name = "lastUpdateDate", partName = "lastUpdateDate") String lastUpdateDate);

	/**
	 * 
	 * @param regCityCode
	 * @param lastUpdateDate
	 * @return returns java.lang.String
	 */
	@WebMethod
	@WebResult(partName = "return")
	public String getCorporationRegistration(
			@WebParam(name = "regCityCode", partName = "regCityCode") String regCityCode,
			@WebParam(name = "lastUpdateDate", partName = "lastUpdateDate") String lastUpdateDate);

	/**
	 * 
	 * @param corpCode
	 * @param lastUpdateDate
	 * @return returns java.lang.String
	 */
	@WebMethod
	@WebResult(partName = "return")
	public String getCorporationEquipmentList(
			@WebParam(name = "corpCode", partName = "corpCode") String corpCode,
			@WebParam(name = "lastUpdateDate", partName = "lastUpdateDate") String lastUpdateDate);

	/**
	 * 
	 * @param projectCode
	 * @param lastUpdateDate
	 * @return returns java.lang.String
	 */
	@WebMethod
	@WebResult(partName = "return")
	public String getTendersList(
			@WebParam(name = "projectCode", partName = "projectCode") String projectCode,
			@WebParam(name = "lastUpdateDate", partName = "lastUpdateDate") String lastUpdateDate);

	/**
	 * 
	 * @param corpCode
	 * @param lastUpdateDate
	 * @return returns java.lang.String
	 */
	@WebMethod
	@WebResult(partName = "return")
	public String getPractitionersInfoList(
			@WebParam(name = "corpCode", partName = "corpCode") String corpCode,
			@WebParam(name = "lastUpdateDate", partName = "lastUpdateDate") String lastUpdateDate);

	/**
	 * 
	 * @param corpCode
	 * @param lastUpdateDate
	 * @return returns java.lang.String
	 */
	@WebMethod
	@WebResult(partName = "return")
	public String getPractitionersTitleList(
			@WebParam(name = "corpCode", partName = "corpCode") String corpCode,
			@WebParam(name = "lastUpdateDate", partName = "lastUpdateDate") String lastUpdateDate);

	/**
	 * 
	 * @param corpCode
	 * @param lastUpdateDate
	 * @return returns java.lang.String
	 */
	@WebMethod
	@WebResult(partName = "return")
	public String getCorporationRtnfoList(
			@WebParam(name = "corpCode", partName = "corpCode") String corpCode,
			@WebParam(name = "lastUpdateDate", partName = "lastUpdateDate") String lastUpdateDate);

	/**
	 * 
	 * @param corpCode
	 * @param lastUpdateDate
	 * @return returns java.lang.String
	 */
	@WebMethod
	@WebResult(partName = "return")
	public String getCorporationAptitudeList(
			@WebParam(name = "corpCode", partName = "corpCode") String corpCode,
			@WebParam(name = "lastUpdateDate", partName = "lastUpdateDate") String lastUpdateDate);

	/**
	 * 
	 * @param corpCode
	 * @param lastUpdateDate
	 * @return returns java.lang.String
	 */
	@WebMethod
	@WebResult(partName = "return")
	public String getCorporationIrList(
			@WebParam(name = "corpCode", partName = "corpCode") String corpCode,
			@WebParam(name = "lastUpdateDate", partName = "lastUpdateDate") String lastUpdateDate);

	/**
	 * 
	 * @param corpCode
	 * @param lastUpdateDate
	 * @return returns java.lang.String
	 */
	@WebMethod
	@WebResult(partName = "return")
	public String getPractitionersIacbList(
			@WebParam(name = "corpCode", partName = "corpCode") String corpCode,
			@WebParam(name = "lastUpdateDate", partName = "lastUpdateDate") String lastUpdateDate);

	/**
	 * 
	 * @param provinceCode
	 * @param lastUpdateDate
	 * @return returns java.lang.String
	 */
	@WebMethod
	@WebResult(partName = "return")
	public String getProjectInfoList(
			@WebParam(name = "provinceCode", partName = "provinceCode") String provinceCode,
			@WebParam(name = "lastUpdateDate", partName = "lastUpdateDate") String lastUpdateDate);

	/**
	 * 
	 * @param corpCode
	 * @param lastUpdateDate
	 * @return returns java.lang.String
	 */
	@WebMethod
	@WebResult(partName = "return")
	public String getPractitionersResultsList(
			@WebParam(name = "corpCode", partName = "corpCode") String corpCode,
			@WebParam(name = "lastUpdateDate", partName = "lastUpdateDate") String lastUpdateDate);

	/**
	 * 
	 * @param corpCode
	 * @param lastUpdateDate
	 * @return returns java.lang.String
	 */
	@WebMethod
	@WebResult(partName = "return")
	public String getPractitionersCVList(
			@WebParam(name = "corpCode", partName = "corpCode") String corpCode,
			@WebParam(name = "lastUpdateDate", partName = "lastUpdateDate") String lastUpdateDate);

	/**
	 * 
	 * @param corpCode
	 * @return returns java.lang.String
	 */
	@WebMethod
	@WebResult(partName = "return")
	public String getCorporationRegistrationByCode(
			@WebParam(name = "corpCode", partName = "corpCode") String corpCode);

	/**
	 * 
	 * @param corpCode
	 * @param lastUpdateDate
	 * @return returns java.lang.String
	 */
	@WebMethod
	@WebResult(partName = "return")
	public String getCorporationCreditList(
			@WebParam(name = "corpCode", partName = "corpCode") String corpCode,
			@WebParam(name = "lastUpdateDate", partName = "lastUpdateDate") String lastUpdateDate);

	/**
	 * 
	 * @param corpCode
	 * @param lastUpdateDate
	 * @return returns java.lang.String
	 */
	@WebMethod
	@WebResult(partName = "return")
	public String getCorporationRacList(
			@WebParam(name = "corpCode", partName = "corpCode") String corpCode,
			@WebParam(name = "lastUpdateDate", partName = "lastUpdateDate") String lastUpdateDate);

	/**
	 * 
	 * @param corpCode
	 * @param lastUpdateDate
	 * @return returns java.lang.String
	 */
	@WebMethod
	@WebResult(partName = "return")
	public String getPractitionersRIList(
			@WebParam(name = "corpCode", partName = "corpCode") String corpCode,
			@WebParam(name = "lastUpdateDate", partName = "lastUpdateDate") String lastUpdateDate);

	/**
	 * 
	 * @param corpCode
	 * @param lastUpdateDate
	 * @return returns java.lang.String
	 */
	@WebMethod
	@WebResult(partName = "return")
	public String getCorporationCorList(
			@WebParam(name = "corpCode", partName = "corpCode") String corpCode,
			@WebParam(name = "lastUpdateDate", partName = "lastUpdateDate") String lastUpdateDate);

	/**
	 * 
	 * @param corpCode
	 * @param lastUpdateDate
	 * @return returns java.lang.String
	 */
	@WebMethod
	@WebResult(partName = "return")
	public String getCorporationPersonalStatisicsList(
			@WebParam(name = "corpCode", partName = "corpCode") String corpCode,
			@WebParam(name = "lastUpdateDate", partName = "lastUpdateDate") String lastUpdateDate);

	/**
	 * 
	 * @param corpCode
	 * @param lastUpdateDate
	 * @return returns java.lang.String
	 */
	@WebMethod
	@WebResult(partName = "return")
	public String getCorporationFinanceList(
			@WebParam(name = "corpCode", partName = "corpCode") String corpCode,
			@WebParam(name = "lastUpdateDate", partName = "lastUpdateDate") String lastUpdateDate);

	/**
	 * 
	 * @param corpCode
	 * @param lastUpdateDate
	 * @return returns java.lang.String
	 */
	@WebMethod
	@WebResult(partName = "return")
	public String getPractitionersTerList(
			@WebParam(name = "corpCode", partName = "corpCode") String corpCode,
			@WebParam(name = "lastUpdateDate", partName = "lastUpdateDate") String lastUpdateDate);

	/**
	 * 
	 * @param corpCode
	 * @param lastUpdateDate
	 * @return returns java.lang.String
	 */
	@WebMethod
	@WebResult(partName = "return")
	public String getCorporationTapList(
			@WebParam(name = "corpCode", partName = "corpCode") String corpCode,
			@WebParam(name = "lastUpdateDate", partName = "lastUpdateDate") String lastUpdateDate);

}
