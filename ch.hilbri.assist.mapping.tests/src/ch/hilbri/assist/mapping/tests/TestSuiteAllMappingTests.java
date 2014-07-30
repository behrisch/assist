package ch.hilbri.assist.mapping.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import ch.hilbri.assist.mapping.tests.constraints.CoreCapacityTests;
import ch.hilbri.assist.mapping.tests.constraints.RAMCapacityTests;
import ch.hilbri.assist.mapping.tests.constraints.ROMCapacityTests;
import ch.hilbri.assist.mapping.tests.results.BasicResultTests;
import ch.hilbri.assist.mapping.tests.results.MultipleResultsTests;

@RunWith(Suite.class)
@SuiteClasses({
	BasicResultTests.class,
	MultipleResultsTests.class,
	CoreCapacityTests.class,
	RAMCapacityTests.class,
	ROMCapacityTests.class
})  

public class TestSuiteAllMappingTests {}
