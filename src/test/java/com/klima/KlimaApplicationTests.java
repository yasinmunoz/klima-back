package com.klima;

import org.junit.platform.suite.api.IncludeClassNamePatterns;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;


@Suite
@SuiteDisplayName("Klima Application Tests")
@SelectPackages("com.klima")
@IncludeClassNamePatterns({".*IT", ".*UT"})
class KlimaApplicationTests { }
