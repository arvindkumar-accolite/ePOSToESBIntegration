package com.pru.service.impl;

import com.pru.service.ILService;
import com.prud.translator.EposToILTranslator;

public class ILServiceImpl implements ILService {
	EposToILTranslator eposToILTranslator;
	public static final String REST_SERVICE_URI = "http://localhost:8099/kafka/send/message";

	public String serviceRequest(String json) {
		String soapEnvelop = eposToILTranslator.generateILRequest(json);
		System.out.println("Envelop " + soapEnvelop);
		return soapEnvelop;
	}
}
