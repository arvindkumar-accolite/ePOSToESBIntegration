package com.prud.mapper.impl;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;

import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.prud.constant.ConfigConstants;
import com.prud.model.middleware.ApplyCashDetails;
import com.prud.model.middleware.AssigneeDetails;
import com.prud.model.middleware.Assignees;
import com.prud.model.middleware.BankDetails;
import com.prud.model.middleware.Beneficiary;
import com.prud.model.middleware.BeneficiaryDetails;
import com.prud.model.middleware.ClientDetails;
import com.prud.model.middleware.ContractDetails;
import com.prud.model.middleware.CoverageDetails;
import com.prud.model.middleware.DispatchDetails;
import com.prud.model.middleware.DoctorDetails;
import com.prud.model.middleware.FollowUps;
import com.prud.model.middleware.FollowUpsDetails;
import com.prud.model.middleware.FundDetails;
import com.prud.model.middleware.JointOwnerDetails;
import com.prud.model.middleware.LifeDetails;
import com.prud.model.middleware.MandateDetails;
import com.prud.model.middleware.NewBusinessModel;
import com.prud.model.middleware.OwnerDetails;
import com.prud.model.middleware.PayerDetails;
import com.prud.model.middleware.PremiumRCTDetails;
import com.prud.model.middleware.QuestionDetails;
import com.prud.model.middleware.RiderDetails;
import com.prud.model.middleware.SFLDetails;
import com.prud.model.middleware.SpecialTermDetails;
import com.prud.model.middleware.SpecialTerms;
import com.prud.translator.JsonValueExtractor;

public class NewBusinessPopulator {
	private JsonValueExtractor extractor;
	private static Properties newBuisnessProperties;
	private static HashMap<String, String> propertyMap = null;
	private static String contractType = null;

	static {
		newBuisnessProperties = new Properties();
		InputStream input = null;
		try {

			input = new FileInputStream(ConfigConstants.NBS_MAPPING_PROPERTIES);
			newBuisnessProperties.load(input);
			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		propertyMap = new HashMap<String, String>();
		for (Entry<Object, Object> entry : newBuisnessProperties.entrySet()) {
			propertyMap.put((String) entry.getKey(), (String) entry.getValue());
		}
		// System.out.println(propertyMap);
	}

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		String content = new String(Files.readAllBytes(Paths.get("./resources/newJson.txt")));
		NewBusinessPopulator nbspop = new NewBusinessPopulator();
		ObjectMapper mapper = new ObjectMapper();
		NewBusinessModel nbsModel = nbspop.buildNewBusiness(content);
		System.out.println("meeee");

		// ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		// String json = ow.writeValueAsString(nbsModel);
		// Object to JSON in file
		// String json = mapper.writeValueAsString(nbsModel);
		// System.out.println(json);
		// Object to JSON in String

		String jsonInString = mapper.writeValueAsString(nbsModel);
		System.out.println(jsonInString);

	}

	public NewBusinessModel buildNewBusiness(String json) {
		NewBusinessModel nbsModel = new NewBusinessModel();
		extractor = new JsonValueExtractor(json);

		nbsModel.setApplyCashDetails(populateApplyCashDetails());
		nbsModel.setAssignees(populateAssignees());
		nbsModel.setBankDetails(populateBankDetails());
		nbsModel.setBeneficiary(populateBeneficiary());
		nbsModel.getClientDetails().add(populateClientDetails());
		nbsModel.setContractDetails(populateContractDetails());
		nbsModel.getCoverageDetails().add(populateCoverageDetails());
		nbsModel.setDispatchDetails(populateDispatchDetails());
		nbsModel.setDoctorDetails(populateDoctorDetails());
		nbsModel.setFollowUps(populateFollowUps());
		nbsModel.getFundDetails().add((populateFundDetails()));
		nbsModel.setJointOwnerDetails(populateJointOwnerDetails());
		nbsModel.getLifeDetails().add(populateLifeDetails());
		nbsModel.setMandateDetails(populateMandateDetails());
		nbsModel.setOwnerDetails(populateOwnerDetails());
		nbsModel.setPayerDetails(populatePayerDetails());
		nbsModel.setPremiumRCTDetails(populatePremiumRCTDetails());
		nbsModel.getQuestionDetails().add(populateQuestionDetails());
		nbsModel.getRiderDetails().add(populateRiderDetails());
		// nbsModel.setSflDetails(populateSFLDetails());
		nbsModel.setSpecialTerms(populateSpecialTerms());
		return nbsModel;
	}

	private ApplyCashDetails populateApplyCashDetails() {
		ApplyCashDetails applyCashDetails = new ApplyCashDetails();
		applyCashDetails.setApplyCashId("");
		applyCashDetails.setReceiptNo("");
		return applyCashDetails;
	}

	private Assignees populateAssignees() {
		Assignees assignees = new Assignees();
		assignees.setAssigneeId("");
		assignees.getAssigneeDetails().add(populateAssigneeDetails());
		return assignees;
	}

	private AssigneeDetails populateAssigneeDetails() {
		AssigneeDetails assigneeDetails = new AssigneeDetails();
		assigneeDetails.setAssigneeParty("");
		assigneeDetails.setCommissionFromDate("2018-09-06T00:00:00.000Z");
		assigneeDetails.setCommissionToDate("2018-09-06T00:00:00.000Z");
		assigneeDetails.setReasonCode("");
		return assigneeDetails;
	}

	private BankDetails populateBankDetails() {
		BankDetails bankDetails = new BankDetails();
		bankDetails.setBankAccountDesc("");
		bankDetails.setBankAccountId("");
		bankDetails.setBankAccountKey("");
		bankDetails.setBankKey("");
		bankDetails.setClientSelectionWithBankDetails("");
		bankDetails.setCurrencyCode("");
		bankDetails.setDatefrom("2018-09-06T00:00:00.000Z");
		bankDetails.setFactoringHouse("");
		return bankDetails;
	}

	private Beneficiary populateBeneficiary() {
		Beneficiary beneficiary = new Beneficiary();
		beneficiary.setBeneficiaryId("");
		BeneficiaryDetails beneficiaryDetail = populateBeneficiaryDetails();
		beneficiary.getBeneficiaryDetails().add(beneficiaryDetail);
		return beneficiary;
	}

	private BeneficiaryDetails populateBeneficiaryDetails() {
		BeneficiaryDetails beneficiaryDetail = new BeneficiaryDetails();
		beneficiaryDetail.setBeneficiaryClientNumber("");
		beneficiaryDetail.setBeneficiaryParty("");
		beneficiaryDetail.setBeneficiaryPercentage(new BigDecimal("0"));
		beneficiaryDetail.setBeneficiaryType("");
		beneficiaryDetail.setClientRelationship("");
		beneficiaryDetail.setEffectiveDate("2018-09-06T00:00:00.000Z");
		return beneficiaryDetail;
	}

	private ClientDetails populateClientDetails() {
		ClientDetails clientDetails = new ClientDetails();
		System.out.println(propertyMap.get("newbusiness.client.address1"));
		clientDetails.setAddress01(extractor.fetchString(propertyMap.get("newbusiness.client.address1")));
		clientDetails.setAddressType("R");
		clientDetails.setBirthPlace(extractor.fetchString(propertyMap.get("newbusiness.client.birthPlace")));
		clientDetails.setCountryCode(extractor.fetchString(propertyMap.get("newbusiness.client.countryCode")));
		clientDetails.setDateOfBirth(extractor.fetchString(propertyMap.get("newbusiness.client.dateOfBirth")));
		clientDetails.setGender(extractor.fetchString(propertyMap.get("newbusiness.client.sex")));
		clientDetails.setGivenName(extractor.fetchString(propertyMap.get("newbusiness.client.givenName")));
		clientDetails.setMailingIndicator("");
		clientDetails
				.setMarriedIndicator(extractor.fetchString(propertyMap.get("newbusiness.client.marriedIndicator")));
//		clientDetails.setPostalCode(extractor.fetchString(propertyMap.get("newbusiness.client.postalCode")));
		clientDetails.setPostalCode("");
		String salutation = extractor.fetchString(propertyMap.get("newbusiness.client.longSalutation"));
		if (salutation.equalsIgnoreCase("MR")) {
			clientDetails.setSalutaion("Mr");
		} else if (salutation.equalsIgnoreCase("MS")) {
			clientDetails.setSalutaion("Ms");
		} else if (salutation.equalsIgnoreCase("DR")) {
			clientDetails.setSalutaion("Dr");
		}
		clientDetails.setSurName(extractor.fetchString(propertyMap.get("newbusiness.client.surname")));
		clientDetails.setNationality(extractor.fetchString(propertyMap.get("newbusiness.client.nationality")));
		clientDetails.setPhone01(extractor.fetchString(propertyMap.get("newbusiness.client.phone1")));
		clientDetails.setVipIndicator("");
		clientDetails.setMiddleName01("");
		clientDetails.setMiddleName02("");
		clientDetails.setOccupationCode(extractor.fetchString(propertyMap.get("newbusiness.client.occupationCode")));
		clientDetails.setParty("");
		clientDetails.setPhone02("");
		clientDetails.setPrefCom("");
		clientDetails.setSecurityNumber("");
		clientDetails.setSourceOfEvidence("");
		clientDetails.setStatusCode("");
		clientDetails.setAddress02("");
		clientDetails.setAddress03("");
		clientDetails.setAddress04("");
		clientDetails.setLanguage("");
		clientDetails.setDirectMailIndicator("");
		clientDetails.setDocumentNumber("");
		clientDetails.setEmail("");
		clientDetails.setEntId("");
		clientDetails.setEthnicOrigin("");
		clientDetails.setForTheAttentionOf("");
		clientDetails.setClientNumber("");
		clientDetails.setClientType("");
		clientDetails.setCorporateName("");
		return clientDetails;
	}

	private ContractDetails populateContractDetails() {
		ContractDetails contractDetails = new ContractDetails();
		contractDetails.setAccountType("AG");
		contractDetails.setAgentNumber(extractor.fetchString(propertyMap.get("newbusiness.contract.agentNumber")));
		contractDetails
				.setBillingCurrency(extractor.fetchString(propertyMap.get("newbusiness.contract.billingCurrency")));
		int billingFrequency = extractor.fetchInt((propertyMap.get("newbusiness.contract.billingFrequency")));

		contractDetails.setBillingfrequency(String.format("%02d", billingFrequency));
		contractDetails.setBillingRenewalDate("2019-09-04T00:00:00.000Z");
		contractDetails.setBillingRenewalIndicator(new BigInteger("00"));
		contractDetails
				.setContractCurrency(extractor.fetchString(propertyMap.get("newbusiness.contract.contractcurrency")));
		contractType = extractor.fetchString(propertyMap.get("newbusiness.contract.contractType"));
		contractDetails.setContractType(contractType);
		contractDetails
				.setMethodOfPayment(extractor.fetchString(propertyMap.get("newbusiness.contract.methodOfPayment")));
		contractDetails.setOriginalCommencementDate(
				extractor.fetchString(propertyMap.get("newbusiness.contract.originalCommencementDate")));
		contractDetails.setPlanSuffix(new BigInteger("01"));
		String register = extractor.fetchString(propertyMap.get("newbusiness.contract.register"));
		if (null != register && !register.isEmpty()) {
			if (register.equalsIgnoreCase("Z")) {
				contractDetails.setRegister("ZMA");
			} else if (register.equalsIgnoreCase("UGD")) {
				contractDetails.setRegister("CA1");
			}
		}

		contractDetails.setProposalDate("2018-09-03T00:00:00.000Z");
		contractDetails.setContractHDREntId("");
		contractDetails.setContractNumber("");

		return contractDetails;
	}

	public BigDecimal convertStringToBigDecimal(String str) {
		BigDecimal temp = null;
		if (null != str) {
			temp = new BigDecimal(str);
		} else
			temp = new BigDecimal(0);
		return temp;
	}

	public BigDecimal convertIntToBigDecimal(Integer num) {
		BigDecimal temp = null;
		if (null != num) {
			temp = new BigDecimal(num);
		} else
			temp = new BigDecimal(0);
		return temp;
	}

	public BigInteger convertIntToBigInteger(Integer num) {
		BigInteger temp = null;
		if (null != num) {
			temp = BigInteger.valueOf(num);
		} else
			temp = BigInteger.valueOf(0);
		return temp;
	}

	public String convertIntegerToString(Integer num) {
		String temp = null;
		if (null != num) {
			temp = String.valueOf(num);
		} else
			temp = "0";
		return temp;
	}

	public BigInteger convertStringToBigInteger(String str) {
		BigInteger temp = null;

		if (null != str) {
			temp = new BigInteger(str);
		} else
			temp = new BigInteger("0");
		return temp;
	}

	private CoverageDetails populateCoverageDetails() {
		CoverageDetails coverageDetails = new CoverageDetails();
//		coverageDetails.setCoverageOrRiderInstalmentAmount(
//				convertIntToBigDecimal(extractor.fetchInt(propertyMap.get("newbusiness.coverage.instalmentAmount"))));
		coverageDetails.setCoverageOrRiderInstalmentAmount(new BigDecimal("0"));
		if (null != contractType) {
			if (contractType.equalsIgnoreCase("EDU")) {
				coverageDetails.setCoverageOrRiderTable("EDU1");
			} else if (contractType.equalsIgnoreCase("SCP")) {
				coverageDetails.setCoverageOrRiderTable("SCP1");
			}
		}

		coverageDetails.setLumpSumContribution(new BigDecimal("1"));
		boolean mortality = extractor.fetchBoolean(propertyMap.get("newbusiness.coverage.mortalityClass"));
		if (mortality) {
			coverageDetails.setMortalityClass("Y");
		} else {
			coverageDetails.setMortalityClass("N");
		}

		coverageDetails.setPremiumCessationAge(new BigInteger("00"));
		coverageDetails.setPremiumCessationDate("2028-09-06T00:00:00.000Z");
		coverageDetails.setPremiumCessationTerm(new BigInteger("10"));
		coverageDetails.setReserveUnitsAllocationDate("2028-09-06T00:00:00.000Z");
		coverageDetails.setRiskCessationAge(new BigInteger("00"));
		coverageDetails.setRiskCessationDate("2028-09-06T00:00:00.000Z");
		coverageDetails.setRiskCessationTerm(new BigInteger("10"));
		coverageDetails.setSumInsured(
				convertIntToBigInteger(extractor.fetchInt(propertyMap.get("newbusiness.coverage.sumInsured"))));
		coverageDetails.setCoverageId("");
		coverageDetails.setReserveUnitsIndicator("");
		coverageDetails.setCoverageParent("");
		return coverageDetails;
	}

	private DispatchDetails populateDispatchDetails() {
		DispatchDetails dispatchDetails = new DispatchDetails();
		dispatchDetails.setDespatchId("");
		dispatchDetails.setDespatchParty("");
		return dispatchDetails;
	}

	private DoctorDetails populateDoctorDetails() {
		DoctorDetails doctorDetails = new DoctorDetails();
		doctorDetails.setDoctorId("");
		doctorDetails.setDoctorParent("");
		doctorDetails.setDoctorParty("");
		doctorDetails.setDoctorType("");
		return doctorDetails;
	}

	private FollowUps populateFollowUps() {
		FollowUps followUps = new FollowUps();
		followUps.setFollowUpsId("");
		followUps.setZDoctor("");
		FollowUpsDetails followUpsDetail = populateFollowUpsDetails();
		followUps.getFollowUpsDetails().add(followUpsDetail);
		return followUps;
	}

	private FollowUpsDetails populateFollowUpsDetails() {
		FollowUpsDetails followUpsDetail = new FollowUpsDetails();
		followUpsDetail.setFollowUpCode("");
		followUpsDetail.setFollowUpDate("2019-09-06T00:00:00.000Z");
		followUpsDetail.setFollowUpNumber(new BigInteger("1"));
		followUpsDetail.setFollowUpStatus("");
		followUpsDetail.setFollowUpType("");
		followUpsDetail.setJointLifeNumber(new BigInteger("1"));
		followUpsDetail.setLifeNumber(new BigInteger("1"));
		return followUpsDetail;
	}

	private FundDetails populateFundDetails() {
		FundDetails fundDetails = new FundDetails();
		fundDetails.setAmount01(new BigDecimal("0"));
		fundDetails.setAmount02(new BigDecimal("0"));
		fundDetails.setAmount03(new BigDecimal("0"));
		fundDetails.setAmount04(new BigDecimal("0"));
		fundDetails.setAmount05(new BigDecimal("0"));
		fundDetails.setAmount06(new BigDecimal("0"));
		fundDetails.setAmount07(new BigDecimal("0"));
		fundDetails.setAmount08(new BigDecimal("0"));
		fundDetails.setAmount09(new BigDecimal("0"));
		fundDetails.setAmount10(new BigDecimal("0"));
		fundDetails.setFundId("");
		fundDetails.setFundParent("");
		fundDetails.setInterateRate01(new BigDecimal("0"));
		fundDetails.setInterateRate02(new BigDecimal("0"));
		fundDetails.setInterateRate03(new BigDecimal("0"));
		fundDetails.setInterateRate04(new BigDecimal("0"));
		fundDetails.setInterateRate05(new BigDecimal("0"));
		fundDetails.setInterateRate06(new BigDecimal("0"));
		fundDetails.setInterateRate07(new BigDecimal("0"));
		fundDetails.setInterateRate08(new BigDecimal("0"));
		fundDetails.setInterateRate09(new BigDecimal("0"));
		fundDetails.setInterateRate10(new BigDecimal("0"));
		fundDetails.setPercentageOfAmountIndicator("");
		fundDetails.setRenewalMonths01(new BigInteger("0"));
		fundDetails.setRenewalMonths02(new BigInteger("0"));
		fundDetails.setRenewalMonths03(new BigInteger("0"));
		fundDetails.setRenewalMonths04(new BigInteger("0"));
		fundDetails.setRenewalMonths05(new BigInteger("0"));
		fundDetails.setRenewalMonths06(new BigInteger("0"));
		fundDetails.setRenewalMonths07(new BigInteger("0"));
		fundDetails.setRenewalMonths08(new BigInteger("0"));
		fundDetails.setRenewalMonths09(new BigInteger("0"));
		fundDetails.setRenewalMonths10(new BigInteger("0"));
		fundDetails.setUnitLinkedFund01("");
		fundDetails.setUnitLinkedFund02("");
		fundDetails.setUnitLinkedFund03("");
		fundDetails.setUnitLinkedFund04("");
		fundDetails.setUnitLinkedFund05("");
		fundDetails.setUnitLinkedFund06("");
		fundDetails.setUnitLinkedFund07("");
		fundDetails.setUnitLinkedFund08("");
		fundDetails.setUnitLinkedFund09("");
		fundDetails.setUnitLinkedFund10("");
		fundDetails.setVirtualFundSplitMethod("");
		fundDetails.setYearsInForce01(new BigInteger("0"));
		fundDetails.setYearsInForce02(new BigInteger("0"));
		fundDetails.setYearsInForce03(new BigInteger("0"));
		fundDetails.setYearsInForce04(new BigInteger("0"));
		fundDetails.setYearsInForce05(new BigInteger("0"));
		fundDetails.setYearsInForce06(new BigInteger("0"));
		fundDetails.setYearsInForce07(new BigInteger("0"));
		fundDetails.setYearsInForce08(new BigInteger("0"));
		fundDetails.setYearsInForce09(new BigInteger("0"));
		fundDetails.setYearsInForce10(new BigInteger("0"));
		return fundDetails;
	}

	private JointOwnerDetails populateJointOwnerDetails() {
		JointOwnerDetails jointOwnerDetails = new JointOwnerDetails();
		jointOwnerDetails.setJointOwnerId("");
		jointOwnerDetails.setJointOwnerParty("");
		return jointOwnerDetails;
	}

	private LifeDetails populateLifeDetails() {
		LifeDetails lifeDetails = new LifeDetails();
//		BigInteger age = convertIntToBigInteger(extractor.fetchInt(propertyMap.get("newbusiness.lives.anbAge")));
		lifeDetails.setAnbAge(convertIntToBigInteger(extractor.fetchInt(propertyMap.get("newbusiness.lives.anbAge"))));

		lifeDetails.setDateOfBirth(extractor.fetchString(propertyMap.get("newbusiness.lives.dateOfBirth")));
		lifeDetails.setHeight(
				convertStringToBigInteger(extractor.fetchString(propertyMap.get("newbusiness.lives.hight"))));
		lifeDetails.setLifeId("");
		lifeDetails.setLifeParty("");
		lifeDetails.setOccupationCode(extractor.fetchString(propertyMap.get("newbusiness.lives.occupationCode")));
		lifeDetails.setRelationshipToLifeInsured(
				extractor.fetchString(propertyMap.get("newbusiness.lives.relationshipToLifeInsured")));
		lifeDetails.setSelection("OTH");
		lifeDetails.setSex(extractor.fetchString(propertyMap.get("newbusiness.lives.sex")));
		boolean smoke = extractor.fetchBoolean(propertyMap.get("newbusiness.lives.smokingIndicator"));
		String smokeIndicator;
		if (smoke) {
			smokeIndicator = "Y";
		} else {
			smokeIndicator = "N";
		}
		lifeDetails.setSmokingIndicator(smokeIndicator);
		lifeDetails.setWeight(
				convertStringToBigInteger(extractor.fetchString(propertyMap.get("newbusiness.lives.weight"))));
		return lifeDetails;
	}

	private MandateDetails populateMandateDetails() {
		MandateDetails mandateDetails = new MandateDetails();
		mandateDetails.setBankAccountKey("");
		mandateDetails.setBankKey("");
		mandateDetails.setClientNumber("");
		mandateDetails.setEffectiveDate("2018-09-06T00:00:00.000Z");
		mandateDetails.setFactoringHouse("");
		mandateDetails.setMandateId("");
		mandateDetails.setMandateRefNumber("");
		mandateDetails.setMandateStatus("");
		mandateDetails.setTimesToUse(new BigInteger("0"));
		return mandateDetails;
	}

	private OwnerDetails populateOwnerDetails() {
		OwnerDetails ownerDetails = new OwnerDetails();
		ownerDetails.setOwnerentId("");
		ownerDetails.setOwnerParty("");
		return ownerDetails;
	}

	private PayerDetails populatePayerDetails() {
		PayerDetails payerDetails = new PayerDetails();
		payerDetails.setPayerId("");
		payerDetails.setPayerParty("");
		return payerDetails;
	}

	private PremiumRCTDetails populatePremiumRCTDetails() {
		PremiumRCTDetails premiumRCTDetails = new PremiumRCTDetails();
		premiumRCTDetails.setBankCode("");
		premiumRCTDetails.setBankDesc01("");
		premiumRCTDetails.setBankDesc02("");
		premiumRCTDetails.setBankDesc03("");
		premiumRCTDetails.setBankedFlag("");
		premiumRCTDetails.setBankKey("");
		premiumRCTDetails.setCheqNumber("");
		premiumRCTDetails.setCurrencyRate(new BigDecimal("0"));
		premiumRCTDetails.setDissectionNumber(new BigInteger("0"));
		premiumRCTDetails.setDocumentAmount(new BigDecimal("0"));
		premiumRCTDetails.setOriginalCurrency("");
		premiumRCTDetails.setPaymentType("");
		premiumRCTDetails.setPremiumRCTId("");
		premiumRCTDetails.setProtectIndicator("");
		premiumRCTDetails.setRecievedFromCode("");
		premiumRCTDetails.setRecievedFromNumber("");
		premiumRCTDetails.getSfldetails().add(populateSFLDetails());
		premiumRCTDetails.setTranDate("2018-09-06T00:00:00.000Z");
		return premiumRCTDetails;
	}

	private QuestionDetails populateQuestionDetails() {
		QuestionDetails questionDetails = new QuestionDetails();
		questionDetails.setAnswer("");
		questionDetails.setQuestionId("");
		questionDetails.setQuestionParent("");
		return questionDetails;
	}

	private RiderDetails populateRiderDetails() {
		RiderDetails riderDetails = new RiderDetails();
		riderDetails.setCoverageOrRiderInstalmentAmount(new BigDecimal("0"));
		riderDetails.setCoverageOrRiderTable("");
		riderDetails.setMortalityClass("");
		riderDetails.setPremiumCessationAge(new BigInteger("0"));
		riderDetails.setPremiumCessationTerm(new BigInteger("0"));
		riderDetails.setRiderId("");
		riderDetails.setRiderParent("");
		riderDetails.setRiskCessationAge(new BigInteger("0"));
		riderDetails.setRiskCessationTerm(new BigInteger("0"));
		riderDetails.setSumInsured(new BigInteger("0"));
		return riderDetails;
	}

	private SFLDetails populateSFLDetails() {
		SFLDetails sflDetails = new SFLDetails();
		sflDetails.setAmountInOriginalCurrency(new BigDecimal("0"));
		sflDetails.setEntity("");
		sflDetails.setSubAccountCode("");
		sflDetails.setSubAccountType("");
		return sflDetails;
	}

	private SpecialTerms populateSpecialTerms() {
		SpecialTerms specialTerms = new SpecialTerms();
		specialTerms.getSpecialTermDetails().add(new SpecialTermDetails());
		return specialTerms;
	}

	private SpecialTermDetails populateSpecialTermDetails() {
		SpecialTermDetails specialTermDetails = new SpecialTermDetails();
		specialTermDetails.setAdjustmentCode("");
		specialTermDetails.setAdjustmentDuration(new BigInteger("0"));
		specialTermDetails.setAdjustmentPercentage(new BigDecimal("0"));
		specialTermDetails.setAgeRating(new BigInteger("0"));
		specialTermDetails.setRateAdjustment(new BigInteger("0"));
		specialTermDetails.setReassuranceIndicator("");
		specialTermDetails.setSelectLineOfSubFile("");
		specialTermDetails.setSpecialTermId("");
		specialTermDetails.setSpecialTermParent("");
		return specialTermDetails;
	}
}
