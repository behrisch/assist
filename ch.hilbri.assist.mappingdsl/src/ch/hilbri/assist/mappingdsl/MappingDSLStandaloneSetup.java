/*
* generated by Xtext
*/
package ch.hilbri.assist.mappingdsl;


/**
 * Initialization support for running Xtext languages 
 * without equinox extension registry
 */
public class MappingDSLStandaloneSetup extends MappingDSLStandaloneSetupGenerated{

	public static void doSetup() {
		new MappingDSLStandaloneSetup().createInjectorAndDoEMFRegistration();
	}
}

