/*
* generated by Xtext
*/
package ch.hilbri.assist.mappingdsl.ui.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import ch.hilbri.assist.mappingdsl.services.MappingDSLGrammarAccess;

public class MappingDSLParser extends AbstractContentAssistParser {
	
	@Inject
	private MappingDSLGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected ch.hilbri.assist.mappingdsl.ui.contentassist.antlr.internal.InternalMappingDSLParser createParser() {
		ch.hilbri.assist.mappingdsl.ui.contentassist.antlr.internal.InternalMappingDSLParser result = new ch.hilbri.assist.mappingdsl.ui.contentassist.antlr.internal.InternalMappingDSLParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getHardwareElementContainerAccess().getAlternatives(), "rule__HardwareElementContainer__Alternatives");
					put(grammarAccess.getIOAdapterRequirementAccess().getAlternatives_4(), "rule__IOAdapterRequirement__Alternatives_4");
					put(grammarAccess.getDissimilarityClauseAccess().getAlternatives(), "rule__DissimilarityClause__Alternatives");
					put(grammarAccess.getDissimilarityClauseAccess().getAlternatives_1_1(), "rule__DissimilarityClause__Alternatives_1_1");
					put(grammarAccess.getDissimilarityEntryAccess().getAlternatives(), "rule__DissimilarityEntry__Alternatives");
					put(grammarAccess.getCompartmentAttributesAccess().getAlternatives(), "rule__CompartmentAttributes__Alternatives");
					put(grammarAccess.getBoardAttributesAccess().getAlternatives(), "rule__BoardAttributes__Alternatives");
					put(grammarAccess.getProcessorAttributesAccess().getAlternatives(), "rule__ProcessorAttributes__Alternatives");
					put(grammarAccess.getHardwareArchitectureLevelTypeAccess().getAlternatives(), "rule__HardwareArchitectureLevelType__Alternatives");
					put(grammarAccess.getDesignAssuranceLevelTypeAccess().getAlternatives(), "rule__DesignAssuranceLevelType__Alternatives");
					put(grammarAccess.getIOAdapterProtectionLevelTypeAccess().getAlternatives(), "rule__IOAdapterProtectionLevelType__Alternatives");
					put(grammarAccess.getIOAdapterTypeAccess().getAlternatives(), "rule__IOAdapterType__Alternatives");
					put(grammarAccess.getAssistModelAccess().getGroup(), "rule__AssistModel__Group__0");
					put(grammarAccess.getAssistModelAccess().getGroup_17(), "rule__AssistModel__Group_17__0");
					put(grammarAccess.getCompartmentAccess().getGroup(), "rule__Compartment__Group__0");
					put(grammarAccess.getCompartmentAccess().getGroup_3(), "rule__Compartment__Group_3__0");
					put(grammarAccess.getCompartmentAccess().getGroup_4(), "rule__Compartment__Group_4__0");
					put(grammarAccess.getCompartmentAccess().getGroup_5(), "rule__Compartment__Group_5__0");
					put(grammarAccess.getCompartmentAccess().getGroup_6(), "rule__Compartment__Group_6__0");
					put(grammarAccess.getCompartmentAccess().getGroup_8(), "rule__Compartment__Group_8__0");
					put(grammarAccess.getBoxAccess().getGroup(), "rule__Box__Group__0");
					put(grammarAccess.getBoxAccess().getGroup_3(), "rule__Box__Group_3__0");
					put(grammarAccess.getBoxAccess().getGroup_5(), "rule__Box__Group_5__0");
					put(grammarAccess.getBoardAccess().getGroup(), "rule__Board__Group__0");
					put(grammarAccess.getBoardAccess().getGroup_3(), "rule__Board__Group_3__0");
					put(grammarAccess.getBoardAccess().getGroup_4(), "rule__Board__Group_4__0");
					put(grammarAccess.getBoardAccess().getGroup_5(), "rule__Board__Group_5__0");
					put(grammarAccess.getBoardAccess().getGroup_6(), "rule__Board__Group_6__0");
					put(grammarAccess.getBoardAccess().getGroup_8(), "rule__Board__Group_8__0");
					put(grammarAccess.getBoardAccess().getGroup_9(), "rule__Board__Group_9__0");
					put(grammarAccess.getBoardAccess().getGroup_11(), "rule__Board__Group_11__0");
					put(grammarAccess.getProcessorAccess().getGroup(), "rule__Processor__Group__0");
					put(grammarAccess.getProcessorAccess().getGroup_3(), "rule__Processor__Group_3__0");
					put(grammarAccess.getProcessorAccess().getGroup_4(), "rule__Processor__Group_4__0");
					put(grammarAccess.getProcessorAccess().getGroup_6(), "rule__Processor__Group_6__0");
					put(grammarAccess.getCoreAccess().getGroup(), "rule__Core__Group__0");
					put(grammarAccess.getCoreAccess().getGroup_7(), "rule__Core__Group_7__0");
					put(grammarAccess.getCoreAccess().getGroup_8(), "rule__Core__Group_8__0");
					put(grammarAccess.getIOAdapterAccess().getGroup(), "rule__IOAdapter__Group__0");
					put(grammarAccess.getIOAdapterAccess().getGroup_10(), "rule__IOAdapter__Group_10__0");
					put(grammarAccess.getNetworkAccess().getGroup(), "rule__Network__Group__0");
					put(grammarAccess.getNetworkAccess().getGroup_11(), "rule__Network__Group_11__0");
					put(grammarAccess.getNetworkAccess().getGroup_13(), "rule__Network__Group_13__0");
					put(grammarAccess.getApplicationGroupAccess().getGroup(), "rule__ApplicationGroup__Group__0");
					put(grammarAccess.getApplicationGroupAccess().getGroup_4(), "rule__ApplicationGroup__Group_4__0");
					put(grammarAccess.getApplicationAccess().getGroup(), "rule__Application__Group__0");
					put(grammarAccess.getApplicationAccess().getGroup_3(), "rule__Application__Group_3__0");
					put(grammarAccess.getApplicationAccess().getGroup_4(), "rule__Application__Group_4__0");
					put(grammarAccess.getApplicationAccess().getGroup_5(), "rule__Application__Group_5__0");
					put(grammarAccess.getApplicationAccess().getGroup_6(), "rule__Application__Group_6__0");
					put(grammarAccess.getApplicationAccess().getGroup_7(), "rule__Application__Group_7__0");
					put(grammarAccess.getApplicationAccess().getGroup_8(), "rule__Application__Group_8__0");
					put(grammarAccess.getApplicationAccess().getGroup_9(), "rule__Application__Group_9__0");
					put(grammarAccess.getApplicationAccess().getGroup_11(), "rule__Application__Group_11__0");
					put(grammarAccess.getApplicationAccess().getGroup_11_3(), "rule__Application__Group_11_3__0");
					put(grammarAccess.getApplicationAccess().getGroup_12(), "rule__Application__Group_12__0");
					put(grammarAccess.getIOAdapterRequirementAccess().getGroup(), "rule__IOAdapterRequirement__Group__0");
					put(grammarAccess.getDislocalityRelationAccess().getGroup(), "rule__DislocalityRelation__Group__0");
					put(grammarAccess.getDislocalityRelationAccess().getGroup_1(), "rule__DislocalityRelation__Group_1__0");
					put(grammarAccess.getProximityRelationAccess().getGroup(), "rule__ProximityRelation__Group__0");
					put(grammarAccess.getProximityRelationAccess().getGroup_1(), "rule__ProximityRelation__Group_1__0");
					put(grammarAccess.getCommunicationRelationAccess().getGroup(), "rule__CommunicationRelation__Group__0");
					put(grammarAccess.getCommunicationRelationAccess().getGroup_1(), "rule__CommunicationRelation__Group_1__0");
					put(grammarAccess.getDissimilarityRelationAccess().getGroup(), "rule__DissimilarityRelation__Group__0");
					put(grammarAccess.getDissimilarityRelationAccess().getGroup_1(), "rule__DissimilarityRelation__Group_1__0");
					put(grammarAccess.getDissimilarityClauseAccess().getGroup_1(), "rule__DissimilarityClause__Group_1__0");
					put(grammarAccess.getDissimilarityDisjunctionAccess().getGroup(), "rule__DissimilarityDisjunction__Group__0");
					put(grammarAccess.getDissimilarityDisjunctionAccess().getGroup_1(), "rule__DissimilarityDisjunction__Group_1__0");
					put(grammarAccess.getDissimilarityConjunctionAccess().getGroup(), "rule__DissimilarityConjunction__Group__0");
					put(grammarAccess.getDissimilarityConjunctionAccess().getGroup_1(), "rule__DissimilarityConjunction__Group_1__0");
					put(grammarAccess.getDissimilarityEntryAccess().getGroup_0(), "rule__DissimilarityEntry__Group_0__0");
					put(grammarAccess.getDissimilarityEntryAccess().getGroup_1(), "rule__DissimilarityEntry__Group_1__0");
					put(grammarAccess.getDissimilarityEntryAccess().getGroup_2(), "rule__DissimilarityEntry__Group_2__0");
					put(grammarAccess.getDissimilarityEntryAccess().getGroup_3(), "rule__DissimilarityEntry__Group_3__0");
					put(grammarAccess.getMetricParameterAccess().getGroup(), "rule__MetricParameter__Group__0");
					put(grammarAccess.getQualifiedNameAccess().getGroup(), "rule__QualifiedName__Group__0");
					put(grammarAccess.getQualifiedNameAccess().getGroup_1(), "rule__QualifiedName__Group_1__0");
					put(grammarAccess.getAssistModelAccess().getSystemNameAssignment_4(), "rule__AssistModel__SystemNameAssignment_4");
					put(grammarAccess.getAssistModelAccess().getHardwareContainerAssignment_9(), "rule__AssistModel__HardwareContainerAssignment_9");
					put(grammarAccess.getAssistModelAccess().getNetworksAssignment_10(), "rule__AssistModel__NetworksAssignment_10");
					put(grammarAccess.getAssistModelAccess().getApplicationsAssignment_14(), "rule__AssistModel__ApplicationsAssignment_14");
					put(grammarAccess.getAssistModelAccess().getApplicationGroupsAssignment_15(), "rule__AssistModel__ApplicationGroupsAssignment_15");
					put(grammarAccess.getAssistModelAccess().getDissimilarityRelationsAssignment_17_2(), "rule__AssistModel__DissimilarityRelationsAssignment_17_2");
					put(grammarAccess.getAssistModelAccess().getDislocalityRelationsAssignment_17_3(), "rule__AssistModel__DislocalityRelationsAssignment_17_3");
					put(grammarAccess.getAssistModelAccess().getProximityRelationsAssignment_17_4(), "rule__AssistModel__ProximityRelationsAssignment_17_4");
					put(grammarAccess.getAssistModelAccess().getCommunicationRelationsAssignment_17_5(), "rule__AssistModel__CommunicationRelationsAssignment_17_5");
					put(grammarAccess.getCompartmentAccess().getNameAssignment_1(), "rule__Compartment__NameAssignment_1");
					put(grammarAccess.getCompartmentAccess().getManufacturerAssignment_3_2(), "rule__Compartment__ManufacturerAssignment_3_2");
					put(grammarAccess.getCompartmentAccess().getPowerSupplyAssignment_4_2(), "rule__Compartment__PowerSupplyAssignment_4_2");
					put(grammarAccess.getCompartmentAccess().getSideAssignment_5_2(), "rule__Compartment__SideAssignment_5_2");
					put(grammarAccess.getCompartmentAccess().getZoneAssignment_6_2(), "rule__Compartment__ZoneAssignment_6_2");
					put(grammarAccess.getCompartmentAccess().getBoxesAssignment_7(), "rule__Compartment__BoxesAssignment_7");
					put(grammarAccess.getCompartmentAccess().getMetricParametersAssignment_8_2(), "rule__Compartment__MetricParametersAssignment_8_2");
					put(grammarAccess.getBoxAccess().getNameAssignment_1(), "rule__Box__NameAssignment_1");
					put(grammarAccess.getBoxAccess().getManufacturerAssignment_3_2(), "rule__Box__ManufacturerAssignment_3_2");
					put(grammarAccess.getBoxAccess().getBoardsAssignment_4(), "rule__Box__BoardsAssignment_4");
					put(grammarAccess.getBoxAccess().getMetricParametersAssignment_5_2(), "rule__Box__MetricParametersAssignment_5_2");
					put(grammarAccess.getBoardAccess().getNameAssignment_1(), "rule__Board__NameAssignment_1");
					put(grammarAccess.getBoardAccess().getManufacturerAssignment_3_2(), "rule__Board__ManufacturerAssignment_3_2");
					put(grammarAccess.getBoardAccess().getBoardTypeAssignment_4_2(), "rule__Board__BoardTypeAssignment_4_2");
					put(grammarAccess.getBoardAccess().getPowerSupplyAssignment_5_2(), "rule__Board__PowerSupplyAssignment_5_2");
					put(grammarAccess.getBoardAccess().getAssuranceLevelAssignment_6_2(), "rule__Board__AssuranceLevelAssignment_6_2");
					put(grammarAccess.getBoardAccess().getProcessorsAssignment_7(), "rule__Board__ProcessorsAssignment_7");
					put(grammarAccess.getBoardAccess().getRamCapacityAssignment_8_2(), "rule__Board__RamCapacityAssignment_8_2");
					put(grammarAccess.getBoardAccess().getRomCapacityAssignment_9_2(), "rule__Board__RomCapacityAssignment_9_2");
					put(grammarAccess.getBoardAccess().getIoAdaptersAssignment_10(), "rule__Board__IoAdaptersAssignment_10");
					put(grammarAccess.getBoardAccess().getMetricParametersAssignment_11_2(), "rule__Board__MetricParametersAssignment_11_2");
					put(grammarAccess.getProcessorAccess().getNameAssignment_1(), "rule__Processor__NameAssignment_1");
					put(grammarAccess.getProcessorAccess().getManufacturerAssignment_3_2(), "rule__Processor__ManufacturerAssignment_3_2");
					put(grammarAccess.getProcessorAccess().getProcessorTypeAssignment_4_2(), "rule__Processor__ProcessorTypeAssignment_4_2");
					put(grammarAccess.getProcessorAccess().getCoresAssignment_5(), "rule__Processor__CoresAssignment_5");
					put(grammarAccess.getProcessorAccess().getMetricParametersAssignment_6_2(), "rule__Processor__MetricParametersAssignment_6_2");
					put(grammarAccess.getCoreAccess().getNameAssignment_1(), "rule__Core__NameAssignment_1");
					put(grammarAccess.getCoreAccess().getCapacityAssignment_5(), "rule__Core__CapacityAssignment_5");
					put(grammarAccess.getCoreAccess().getArchitectureAssignment_7_2(), "rule__Core__ArchitectureAssignment_7_2");
					put(grammarAccess.getCoreAccess().getMetricParametersAssignment_8_2(), "rule__Core__MetricParametersAssignment_8_2");
					put(grammarAccess.getIOAdapterAccess().getAdapterTypeAssignment_4(), "rule__IOAdapter__AdapterTypeAssignment_4");
					put(grammarAccess.getIOAdapterAccess().getTotalCountAssignment_8(), "rule__IOAdapter__TotalCountAssignment_8");
					put(grammarAccess.getIOAdapterAccess().getProtectionLevelAssignment_10_2(), "rule__IOAdapter__ProtectionLevelAssignment_10_2");
					put(grammarAccess.getNetworkAccess().getNameAssignment_1(), "rule__Network__NameAssignment_1");
					put(grammarAccess.getNetworkAccess().getBandwidthCapacityAssignment_5(), "rule__Network__BandwidthCapacityAssignment_5");
					put(grammarAccess.getNetworkAccess().getBoardsAssignment_8(), "rule__Network__BoardsAssignment_8");
					put(grammarAccess.getNetworkAccess().getBoardsAssignment_10(), "rule__Network__BoardsAssignment_10");
					put(grammarAccess.getNetworkAccess().getBoardsAssignment_11_1(), "rule__Network__BoardsAssignment_11_1");
					put(grammarAccess.getNetworkAccess().getMetricParametersAssignment_13_2(), "rule__Network__MetricParametersAssignment_13_2");
					put(grammarAccess.getApplicationGroupAccess().getNameAssignment_1(), "rule__ApplicationGroup__NameAssignment_1");
					put(grammarAccess.getApplicationGroupAccess().getApplicationsOrGroupsAssignment_3(), "rule__ApplicationGroup__ApplicationsOrGroupsAssignment_3");
					put(grammarAccess.getApplicationGroupAccess().getApplicationsOrGroupsAssignment_4_1(), "rule__ApplicationGroup__ApplicationsOrGroupsAssignment_4_1");
					put(grammarAccess.getApplicationAccess().getNameAssignment_1(), "rule__Application__NameAssignment_1");
					put(grammarAccess.getApplicationAccess().getCoreUtilizationAssignment_3_2(), "rule__Application__CoreUtilizationAssignment_3_2");
					put(grammarAccess.getApplicationAccess().getRamUtilizationAssignment_4_2(), "rule__Application__RamUtilizationAssignment_4_2");
					put(grammarAccess.getApplicationAccess().getRomUtilizationAssignment_5_2(), "rule__Application__RomUtilizationAssignment_5_2");
					put(grammarAccess.getApplicationAccess().getCriticalityLevelAssignment_6_2(), "rule__Application__CriticalityLevelAssignment_6_2");
					put(grammarAccess.getApplicationAccess().getIoAdapterProtectionLevelAssignment_7_2(), "rule__Application__IoAdapterProtectionLevelAssignment_7_2");
					put(grammarAccess.getApplicationAccess().getParallelThreadsAssignment_8_2(), "rule__Application__ParallelThreadsAssignment_8_2");
					put(grammarAccess.getApplicationAccess().getDevelopedByAssignment_9_2(), "rule__Application__DevelopedByAssignment_9_2");
					put(grammarAccess.getApplicationAccess().getIoAdapterRequirementsAssignment_10(), "rule__Application__IoAdapterRequirementsAssignment_10");
					put(grammarAccess.getApplicationAccess().getRestrictMappingToHardwareElementsAssignment_11_2(), "rule__Application__RestrictMappingToHardwareElementsAssignment_11_2");
					put(grammarAccess.getApplicationAccess().getRestrictMappingToHardwareElementsAssignment_11_3_1(), "rule__Application__RestrictMappingToHardwareElementsAssignment_11_3_1");
					put(grammarAccess.getApplicationAccess().getMetricParametersAssignment_12_2(), "rule__Application__MetricParametersAssignment_12_2");
					put(grammarAccess.getIOAdapterRequirementAccess().getRequiredAdapterCountAssignment_1(), "rule__IOAdapterRequirement__RequiredAdapterCountAssignment_1");
					put(grammarAccess.getIOAdapterRequirementAccess().getAdapterTypeAssignment_2(), "rule__IOAdapterRequirement__AdapterTypeAssignment_2");
					put(grammarAccess.getIOAdapterRequirementAccess().getIsExclusiveOnlyAssignment_4_0(), "rule__IOAdapterRequirement__IsExclusiveOnlyAssignment_4_0");
					put(grammarAccess.getIOAdapterRequirementAccess().getIsSharedAllowedAssignment_4_1(), "rule__IOAdapterRequirement__IsSharedAllowedAssignment_4_1");
					put(grammarAccess.getDislocalityRelationAccess().getApplicationsOrGroupsAssignment_0(), "rule__DislocalityRelation__ApplicationsOrGroupsAssignment_0");
					put(grammarAccess.getDislocalityRelationAccess().getApplicationsOrGroupsAssignment_1_1(), "rule__DislocalityRelation__ApplicationsOrGroupsAssignment_1_1");
					put(grammarAccess.getDislocalityRelationAccess().getHardwareLevelAssignment_3(), "rule__DislocalityRelation__HardwareLevelAssignment_3");
					put(grammarAccess.getProximityRelationAccess().getApplicationsOrGroupsAssignment_0(), "rule__ProximityRelation__ApplicationsOrGroupsAssignment_0");
					put(grammarAccess.getProximityRelationAccess().getApplicationsOrGroupsAssignment_1_1(), "rule__ProximityRelation__ApplicationsOrGroupsAssignment_1_1");
					put(grammarAccess.getProximityRelationAccess().getHardwareLevelAssignment_3(), "rule__ProximityRelation__HardwareLevelAssignment_3");
					put(grammarAccess.getCommunicationRelationAccess().getApplicationsOrGroupsAssignment_0(), "rule__CommunicationRelation__ApplicationsOrGroupsAssignment_0");
					put(grammarAccess.getCommunicationRelationAccess().getApplicationsOrGroupsAssignment_1_1(), "rule__CommunicationRelation__ApplicationsOrGroupsAssignment_1_1");
					put(grammarAccess.getCommunicationRelationAccess().getBandwidthUtilizationAssignment_3(), "rule__CommunicationRelation__BandwidthUtilizationAssignment_3");
					put(grammarAccess.getDissimilarityRelationAccess().getApplicationsOrGroupsAssignment_0(), "rule__DissimilarityRelation__ApplicationsOrGroupsAssignment_0");
					put(grammarAccess.getDissimilarityRelationAccess().getApplicationsOrGroupsAssignment_1_1(), "rule__DissimilarityRelation__ApplicationsOrGroupsAssignment_1_1");
					put(grammarAccess.getDissimilarityRelationAccess().getDissimilarityClauseAssignment_3(), "rule__DissimilarityRelation__DissimilarityClauseAssignment_3");
					put(grammarAccess.getDissimilarityDisjunctionAccess().getDissimilarityClausesAssignment_0(), "rule__DissimilarityDisjunction__DissimilarityClausesAssignment_0");
					put(grammarAccess.getDissimilarityDisjunctionAccess().getDissimilarityClausesAssignment_1_1(), "rule__DissimilarityDisjunction__DissimilarityClausesAssignment_1_1");
					put(grammarAccess.getDissimilarityConjunctionAccess().getDissimilarityClausesAssignment_0(), "rule__DissimilarityConjunction__DissimilarityClausesAssignment_0");
					put(grammarAccess.getDissimilarityConjunctionAccess().getDissimilarityClausesAssignment_1_1(), "rule__DissimilarityConjunction__DissimilarityClausesAssignment_1_1");
					put(grammarAccess.getDissimilarityEntryAccess().getCompartmentAttributeAssignment_0_1(), "rule__DissimilarityEntry__CompartmentAttributeAssignment_0_1");
					put(grammarAccess.getDissimilarityEntryAccess().getBoxAttributeAssignment_1_1(), "rule__DissimilarityEntry__BoxAttributeAssignment_1_1");
					put(grammarAccess.getDissimilarityEntryAccess().getBoardAttributeAssignment_2_1(), "rule__DissimilarityEntry__BoardAttributeAssignment_2_1");
					put(grammarAccess.getDissimilarityEntryAccess().getProcessorAttributeAssignment_3_1(), "rule__DissimilarityEntry__ProcessorAttributeAssignment_3_1");
					put(grammarAccess.getMetricParameterAccess().getNameAssignment_0(), "rule__MetricParameter__NameAssignment_0");
					put(grammarAccess.getMetricParameterAccess().getValueAssignment_2(), "rule__MetricParameter__ValueAssignment_2");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			ch.hilbri.assist.mappingdsl.ui.contentassist.antlr.internal.InternalMappingDSLParser typedParser = (ch.hilbri.assist.mappingdsl.ui.contentassist.antlr.internal.InternalMappingDSLParser) parser;
			typedParser.entryRuleAssistModel();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}
	
	public MappingDSLGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(MappingDSLGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
