//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.08.02 at 11:52:18 AM IST 
//

package com.pru.model.il;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for anonymous complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within
 * this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.csc.smart/msp/schemas/MSPContext}MSPContext" minOccurs="0"/>
 *         &lt;element name="ADDRTYPE">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="BIRTHP">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="20"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CLTADDR01">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="30"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CLTADDR02">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="30"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CLTADDR03">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="30"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CLTADDR04">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="30"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CLTADDR05">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="30"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CLTDOBX">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="CCYY">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *                         &lt;totalDigits value="4"/>
 *                         &lt;pattern value="((2[0-9][0-9][0-9])|(1[0-9][0-9][0-9])|9999|0)"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="MM">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *                         &lt;totalDigits value="2"/>
 *                         &lt;pattern value="(([0-9])|(0[0-9])|(1[0-2])|99|0)"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="DD">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
 *                         &lt;totalDigits value="2"/>
 *                         &lt;pattern value="(([0-9])|(0[1-9]|[1-2][0-9])|(3[0-1])|99|0)"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="CLTPCODE">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="10"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CLTPHONE01">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="16"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CLTPHONE02">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="16"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CLTSEX">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="CTRYCODE">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DIRMAIL">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DOCNO">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="8"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="LGIVNAME">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="60"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="LSURNAME">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="60"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="MAILING">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="MARRYD">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="NATLTY">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="OCCPCODE">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="4"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SALUTL">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="8"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SECUITYNO">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="24"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="SOE">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="10"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="STATCODE">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="VIP">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "mspContext", "addrtype", "birthp", "cltaddr01", "cltaddr02", "cltaddr03",
		"cltaddr04", "cltaddr05", "cltdobx", "cltpcode", "cltphone01", "cltphone02", "cltsex", "ctrycode", "dirmail",
		"docno", "lgivname", "lsurname", "mailing", "marryd", "natlty", "occpcode", "salutl", "secuityno", "soe",
		"statcode", "vip" })
@XmlRootElement(name = "CLICRPI_REC", namespace = "http://www.csc.smart/bo/schemas/CLICRPI")
public class CLICRPIREC {

	@XmlElement(name = "MSPContext", namespace = "http://www.csc.smart/msp/schemas/MSPContext")
	protected MSPContext mspContext;
	@XmlElement(name = "ADDRTYPE", required = true)
	protected String addrtype;
	@XmlElement(name = "BIRTHP", required = true)
	protected String birthp;
	@XmlElement(name = "CLTADDR01", required = true)
	protected String cltaddr01;
	@XmlElement(name = "CLTADDR02", required = true)
	protected String cltaddr02;
	@XmlElement(name = "CLTADDR03", required = true)
	protected String cltaddr03;
	@XmlElement(name = "CLTADDR04", required = true)
	protected String cltaddr04;
	@XmlElement(name = "CLTADDR05", required = true)
	protected String cltaddr05;
	@XmlElement(name = "CLTDOBX", required = true)
	protected CLICRPIREC.CLTDOBX cltdobx;
	@XmlElement(name = "CLTPCODE", required = true)
	protected String cltpcode;
	@XmlElement(name = "CLTPHONE01", required = true)
	protected String cltphone01;
	@XmlElement(name = "CLTPHONE02", required = true)
	protected String cltphone02;
	@XmlElement(name = "CLTSEX", required = true)
	protected String cltsex;
	@XmlElement(name = "CTRYCODE", required = true)
	protected String ctrycode;
	@XmlElement(name = "DIRMAIL", required = true)
	protected String dirmail;
	@XmlElement(name = "DOCNO", required = true)
	protected String docno;
	@XmlElement(name = "LGIVNAME", required = true)
	protected String lgivname;
	@XmlElement(name = "LSURNAME", required = true)
	protected String lsurname;
	@XmlElement(name = "MAILING", required = true)
	protected String mailing;
	@XmlElement(name = "MARRYD", required = true)
	protected String marryd;
	@XmlElement(name = "NATLTY", required = true)
	protected String natlty;
	@XmlElement(name = "OCCPCODE", required = true)
	protected String occpcode;
	@XmlElement(name = "SALUTL", required = true)
	protected String salutl;
	@XmlElement(name = "SECUITYNO", required = true)
	protected String secuityno;
	@XmlElement(name = "SOE", required = true)
	protected String soe;
	@XmlElement(name = "STATCODE", required = true)
	protected String statcode;
	@XmlElement(name = "VIP", required = true)
	protected String vip;

	/**
	 * Gets the value of the mspContext property.
	 * 
	 * @return possible object is {@link MSPContext }
	 * 
	 */
	public MSPContext getMSPContext() {
		return mspContext;
	}

	/**
	 * Sets the value of the mspContext property.
	 * 
	 * @param value
	 *            allowed object is {@link MSPContext }
	 * 
	 */
	public void setMSPContext(MSPContext value) {
		this.mspContext = value;
	}

	/**
	 * Gets the value of the addrtype property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getADDRTYPE() {
		return addrtype;
	}

	/**
	 * Sets the value of the addrtype property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setADDRTYPE(String value) {
		this.addrtype = value;
	}

	/**
	 * Gets the value of the birthp property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getBIRTHP() {
		return birthp;
	}

	/**
	 * Sets the value of the birthp property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setBIRTHP(String value) {
		this.birthp = value;
	}

	/**
	 * Gets the value of the cltaddr01 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCLTADDR01() {
		return cltaddr01;
	}

	/**
	 * Sets the value of the cltaddr01 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCLTADDR01(String value) {
		this.cltaddr01 = value;
	}

	/**
	 * Gets the value of the cltaddr02 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCLTADDR02() {
		return cltaddr02;
	}

	/**
	 * Sets the value of the cltaddr02 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCLTADDR02(String value) {
		this.cltaddr02 = value;
	}

	/**
	 * Gets the value of the cltaddr03 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCLTADDR03() {
		return cltaddr03;
	}

	/**
	 * Sets the value of the cltaddr03 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCLTADDR03(String value) {
		this.cltaddr03 = value;
	}

	/**
	 * Gets the value of the cltaddr04 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCLTADDR04() {
		return cltaddr04;
	}

	/**
	 * Sets the value of the cltaddr04 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCLTADDR04(String value) {
		this.cltaddr04 = value;
	}

	/**
	 * Gets the value of the cltaddr05 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCLTADDR05() {
		return cltaddr05;
	}

	/**
	 * Sets the value of the cltaddr05 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCLTADDR05(String value) {
		this.cltaddr05 = value;
	}

	/**
	 * Gets the value of the cltdobx property.
	 * 
	 * @return possible object is {@link CLICRPIREC.CLTDOBX }
	 * 
	 */
	public CLICRPIREC.CLTDOBX getCLTDOBX() {
		return cltdobx;
	}

	/**
	 * Sets the value of the cltdobx property.
	 * 
	 * @param value
	 *            allowed object is {@link CLICRPIREC.CLTDOBX }
	 * 
	 */
	public void setCLTDOBX(CLICRPIREC.CLTDOBX value) {
		this.cltdobx = value;
	}

	/**
	 * Gets the value of the cltpcode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCLTPCODE() {
		return cltpcode;
	}

	/**
	 * Sets the value of the cltpcode property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCLTPCODE(String value) {
		this.cltpcode = value;
	}

	/**
	 * Gets the value of the cltphone01 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCLTPHONE01() {
		return cltphone01;
	}

	/**
	 * Sets the value of the cltphone01 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCLTPHONE01(String value) {
		this.cltphone01 = value;
	}

	/**
	 * Gets the value of the cltphone02 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCLTPHONE02() {
		return cltphone02;
	}

	/**
	 * Sets the value of the cltphone02 property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCLTPHONE02(String value) {
		this.cltphone02 = value;
	}

	/**
	 * Gets the value of the cltsex property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCLTSEX() {
		return cltsex;
	}

	/**
	 * Sets the value of the cltsex property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCLTSEX(String value) {
		this.cltsex = value;
	}

	/**
	 * Gets the value of the ctrycode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getCTRYCODE() {
		return ctrycode;
	}

	/**
	 * Sets the value of the ctrycode property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setCTRYCODE(String value) {
		this.ctrycode = value;
	}

	/**
	 * Gets the value of the dirmail property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDIRMAIL() {
		return dirmail;
	}

	/**
	 * Sets the value of the dirmail property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDIRMAIL(String value) {
		this.dirmail = value;
	}

	/**
	 * Gets the value of the docno property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDOCNO() {
		return docno;
	}

	/**
	 * Sets the value of the docno property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setDOCNO(String value) {
		this.docno = value;
	}

	/**
	 * Gets the value of the lgivname property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLGIVNAME() {
		return lgivname;
	}

	/**
	 * Sets the value of the lgivname property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLGIVNAME(String value) {
		this.lgivname = value;
	}

	/**
	 * Gets the value of the lsurname property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getLSURNAME() {
		return lsurname;
	}

	/**
	 * Sets the value of the lsurname property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setLSURNAME(String value) {
		this.lsurname = value;
	}

	/**
	 * Gets the value of the mailing property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMAILING() {
		return mailing;
	}

	/**
	 * Sets the value of the mailing property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMAILING(String value) {
		this.mailing = value;
	}

	/**
	 * Gets the value of the marryd property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMARRYD() {
		return marryd;
	}

	/**
	 * Sets the value of the marryd property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setMARRYD(String value) {
		this.marryd = value;
	}

	/**
	 * Gets the value of the natlty property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getNATLTY() {
		return natlty;
	}

	/**
	 * Sets the value of the natlty property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setNATLTY(String value) {
		this.natlty = value;
	}

	/**
	 * Gets the value of the occpcode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getOCCPCODE() {
		return occpcode;
	}

	/**
	 * Sets the value of the occpcode property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setOCCPCODE(String value) {
		this.occpcode = value;
	}

	/**
	 * Gets the value of the salutl property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSALUTL() {
		return salutl;
	}

	/**
	 * Sets the value of the salutl property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSALUTL(String value) {
		this.salutl = value;
	}

	/**
	 * Gets the value of the secuityno property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSECUITYNO() {
		return secuityno;
	}

	/**
	 * Sets the value of the secuityno property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSECUITYNO(String value) {
		this.secuityno = value;
	}

	/**
	 * Gets the value of the soe property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSOE() {
		return soe;
	}

	/**
	 * Sets the value of the soe property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSOE(String value) {
		this.soe = value;
	}

	/**
	 * Gets the value of the statcode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSTATCODE() {
		return statcode;
	}

	/**
	 * Sets the value of the statcode property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setSTATCODE(String value) {
		this.statcode = value;
	}

	/**
	 * Gets the value of the vip property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getVIP() {
		return vip;
	}

	/**
	 * Sets the value of the vip property.
	 * 
	 * @param value
	 *            allowed object is {@link String }
	 * 
	 */
	public void setVIP(String value) {
		this.vip = value;
	}

	/**
	 * <p>
	 * Java class for anonymous complex type.
	 * 
	 * <p>
	 * The following schema fragment specifies the expected content contained within
	 * this class.
	 * 
	 * <pre>
	 * &lt;complexType>
	 *   &lt;complexContent>
	 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
	 *       &lt;sequence>
	 *         &lt;element name="CCYY">
	 *           &lt;simpleType>
	 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
	 *               &lt;totalDigits value="4"/>
	 *               &lt;pattern value="((2[0-9][0-9][0-9])|(1[0-9][0-9][0-9])|9999|0)"/>
	 *             &lt;/restriction>
	 *           &lt;/simpleType>
	 *         &lt;/element>
	 *         &lt;element name="MM">
	 *           &lt;simpleType>
	 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
	 *               &lt;totalDigits value="2"/>
	 *               &lt;pattern value="(([0-9])|(0[0-9])|(1[0-2])|99|0)"/>
	 *             &lt;/restriction>
	 *           &lt;/simpleType>
	 *         &lt;/element>
	 *         &lt;element name="DD">
	 *           &lt;simpleType>
	 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}integer">
	 *               &lt;totalDigits value="2"/>
	 *               &lt;pattern value="(([0-9])|(0[1-9]|[1-2][0-9])|(3[0-1])|99|0)"/>
	 *             &lt;/restriction>
	 *           &lt;/simpleType>
	 *         &lt;/element>
	 *       &lt;/sequence>
	 *     &lt;/restriction>
	 *   &lt;/complexContent>
	 * &lt;/complexType>
	 * </pre>
	 * 
	 * 
	 */
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "ccyy", "mm", "dd" })
	public static class CLTDOBX {

		@XmlElement(name = "CCYY", required = true)
		protected BigInteger ccyy;
		@XmlElement(name = "MM", required = true)
		protected BigInteger mm;
		@XmlElement(name = "DD", required = true)
		protected BigInteger dd;

		/**
		 * Gets the value of the ccyy property.
		 * 
		 * @return possible object is {@link BigInteger }
		 * 
		 */
		public BigInteger getCCYY() {
			return ccyy;
		}

		/**
		 * Sets the value of the ccyy property.
		 * 
		 * @param value
		 *            allowed object is {@link BigInteger }
		 * 
		 */
		public void setCCYY(BigInteger value) {
			this.ccyy = value;
		}

		/**
		 * Gets the value of the mm property.
		 * 
		 * @return possible object is {@link BigInteger }
		 * 
		 */
		public BigInteger getMM() {
			return mm;
		}

		/**
		 * Sets the value of the mm property.
		 * 
		 * @param value
		 *            allowed object is {@link BigInteger }
		 * 
		 */
		public void setMM(BigInteger value) {
			this.mm = value;
		}

		/**
		 * Gets the value of the dd property.
		 * 
		 * @return possible object is {@link BigInteger }
		 * 
		 */
		public BigInteger getDD() {
			return dd;
		}

		/**
		 * Sets the value of the dd property.
		 * 
		 * @param value
		 *            allowed object is {@link BigInteger }
		 * 
		 */
		public void setDD(BigInteger value) {
			this.dd = value;
		}

	}

}