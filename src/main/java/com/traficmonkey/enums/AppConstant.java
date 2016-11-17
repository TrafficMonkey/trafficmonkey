package com.traficmonkey.enums;

public enum AppConstant {
	STP_TEN(60),
	STP_TWENTY(20),
	STP_FIFTY(50),
	STP_HUNDREAD(100),
	STP_TEN_STRING("STP-10"),
	STP_TWENTY_STRING("STP-20"),
	STP_FIFTY_STRING("STP-50"),
	STP_HUNDREAD_STRING("STP-100"),
	INCOME_TYPE_DI("DI"),
	INCOME_TYPE_REFERRAL("RI")
	
	;
	private  int value=0;
    
    
	AppConstant(final int newValue) {
        value = newValue;
    }
	private  String packType=null;
	AppConstant(final String newpackType) {
		packType = newpackType;
    }
    public int getValue() { return value; }
    
    public String getStringValue() { return packType; }
}
