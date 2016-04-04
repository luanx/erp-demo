package com.wantdo.erp.test.spring;

/**
 * @ Date : 16/4/4
 * @ From : erp-demo
 * @ Author : luanx@wantdo.com
 */
public class Profiles {

    public static final String ACTIVE_PROFILE = "spring.profiles.active";
    public static final String DEFAULT_PROFILE = "spring.profiles.default";

    public static final String PRODUCTION = "production";
    public static final String DEVELOPMENT = "development";
    public static final String UNIT_TEST = "test";
    public static final String FUNCTIONAL_TEST = "functional";

    public static void setProfileAsSystemProperty(String profile){
        System.setProperty(ACTIVE_PROFILE, profile);
    }
}
