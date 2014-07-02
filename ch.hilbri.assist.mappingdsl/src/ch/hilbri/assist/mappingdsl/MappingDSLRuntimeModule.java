/*
 * generated by Xtext
 */
package ch.hilbri.assist.mappingdsl;

import org.eclipse.xtext.scoping.IGlobalScopeProvider;

import ch.hilbri.assist.mappingdsl.scoping.NullGlobalScopeProvider;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class MappingDSLRuntimeModule extends ch.hilbri.assist.mappingdsl.AbstractMappingDSLRuntimeModule {

	/*
	 * Dies fuegt den NullGlobalScopeProvider ein; dies ist notwendig,
	 * damit wir bei Referenzen uns nur auf das aktuelle File beziehen und keine
	 * anderen Files mit gleicher Endung im gleichen Projekt miteinbeziehen
	 */
	@Override
	public Class<? extends IGlobalScopeProvider> bindIGlobalScopeProvider() {
	    return NullGlobalScopeProvider.class;
	}
}
