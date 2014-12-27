/**
 */
package ch.hilbri.assist.datamodel.result.mapping;

import ch.hilbri.assist.datamodel.model.HardwareArchitectureLevelType;

import java.lang.Comparable;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ch.hilbri.assist.datamodel.result.mapping.Result#getName <em>Name</em>}</li>
 *   <li>{@link ch.hilbri.assist.datamodel.result.mapping.Result#getSystemName <em>System Name</em>}</li>
 *   <li>{@link ch.hilbri.assist.datamodel.result.mapping.Result#getRootHardwareElements <em>Root Hardware Elements</em>}</li>
 *   <li>{@link ch.hilbri.assist.datamodel.result.mapping.Result#getTopHardwareLevel <em>Top Hardware Level</em>}</li>
 *   <li>{@link ch.hilbri.assist.datamodel.result.mapping.Result#getBottomHardwareLevel <em>Bottom Hardware Level</em>}</li>
 *   <li>{@link ch.hilbri.assist.datamodel.result.mapping.Result#getApplicationGroups <em>Application Groups</em>}</li>
 *   <li>{@link ch.hilbri.assist.datamodel.result.mapping.Result#getApplications <em>Applications</em>}</li>
 *   <li>{@link ch.hilbri.assist.datamodel.result.mapping.Result#getNetworks <em>Networks</em>}</li>
 *   <li>{@link ch.hilbri.assist.datamodel.result.mapping.Result#getCommunications <em>Communications</em>}</li>
 *   <li>{@link ch.hilbri.assist.datamodel.result.mapping.Result#getEvaluation <em>Evaluation</em>}</li>
 * </ul>
 * </p>
 *
 * @see ch.hilbri.assist.datamodel.result.mapping.MappingPackage#getResult()
 * @model superTypes="ch.hilbri.assist.datamodel.result.mapping.Comparable"
 * @generated
 */
public interface Result extends EObject, Comparable<Result> {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Name of this result
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see ch.hilbri.assist.datamodel.result.mapping.MappingPackage#getResult_Name()
	 * @model unique="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link ch.hilbri.assist.datamodel.result.mapping.Result#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>System Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Name of the system
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>System Name</em>' attribute.
	 * @see #setSystemName(String)
	 * @see ch.hilbri.assist.datamodel.result.mapping.MappingPackage#getResult_SystemName()
	 * @model unique="false"
	 * @generated
	 */
	String getSystemName();

	/**
	 * Sets the value of the '{@link ch.hilbri.assist.datamodel.result.mapping.Result#getSystemName <em>System Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>System Name</em>' attribute.
	 * @see #getSystemName()
	 * @generated
	 */
	void setSystemName(String value);

	/**
	 * Returns the value of the '<em><b>Root Hardware Elements</b></em>' containment reference list.
	 * The list contents are of type {@link ch.hilbri.assist.datamodel.result.mapping.HardwareElement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * List of all hardware elements in the top hierarchy level
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Root Hardware Elements</em>' containment reference list.
	 * @see ch.hilbri.assist.datamodel.result.mapping.MappingPackage#getResult_RootHardwareElements()
	 * @model containment="true"
	 * @generated
	 */
	EList<HardwareElement> getRootHardwareElements();

	/**
	 * Returns the value of the '<em><b>Top Hardware Level</b></em>' attribute.
	 * The literals are from the enumeration {@link ch.hilbri.assist.datamodel.model.HardwareArchitectureLevelType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns the top hardware level for this result
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Top Hardware Level</em>' attribute.
	 * @see ch.hilbri.assist.datamodel.model.HardwareArchitectureLevelType
	 * @see ch.hilbri.assist.datamodel.result.mapping.MappingPackage#getResult_TopHardwareLevel()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='<%ch.hilbri.assist.datamodel.model.HardwareArchitectureLevelType%> _xifexpression = null;\n<%org.eclipse.emf.common.util.EList%><<%ch.hilbri.assist.datamodel.result.mapping.HardwareElement%>> _rootHardwareElements = this.getRootHardwareElements();\nboolean _isEmpty = _rootHardwareElements.isEmpty();\nboolean _not = (!_isEmpty);\nif (_not)\n{\n\t<%ch.hilbri.assist.datamodel.model.HardwareArchitectureLevelType%> _switchResult = null;\n\t<%org.eclipse.emf.common.util.EList%><<%ch.hilbri.assist.datamodel.result.mapping.HardwareElement%>> _rootHardwareElements_1 = this.getRootHardwareElements();\n\t<%ch.hilbri.assist.datamodel.result.mapping.HardwareElement%> _get = _rootHardwareElements_1.get(0);\n\tboolean _matched = false;\n\tif (!_matched)\n\t{\n\t\tif (_get instanceof <%ch.hilbri.assist.datamodel.result.mapping.Compartment%>)\n\t\t{\n\t\t\t_matched=true;\n\t\t\t_switchResult = <%ch.hilbri.assist.datamodel.model.HardwareArchitectureLevelType%>.COMPARTMENT;\n\t\t}\n\t}\n\tif (!_matched)\n\t{\n\t\tif (_get instanceof <%ch.hilbri.assist.datamodel.result.mapping.Box%>)\n\t\t{\n\t\t\t_matched=true;\n\t\t\t_switchResult = <%ch.hilbri.assist.datamodel.model.HardwareArchitectureLevelType%>.BOX;\n\t\t}\n\t}\n\tif (!_matched)\n\t{\n\t\tif (_get instanceof <%ch.hilbri.assist.datamodel.result.mapping.Board%>)\n\t\t{\n\t\t\t_matched=true;\n\t\t\t_switchResult = <%ch.hilbri.assist.datamodel.model.HardwareArchitectureLevelType%>.BOARD;\n\t\t}\n\t}\n\tif (!_matched)\n\t{\n\t\tif (_get instanceof <%ch.hilbri.assist.datamodel.result.mapping.Processor%>)\n\t\t{\n\t\t\t_matched=true;\n\t\t\t_switchResult = <%ch.hilbri.assist.datamodel.model.HardwareArchitectureLevelType%>.PROCESSOR;\n\t\t}\n\t}\n\tif (!_matched)\n\t{\n\t\tif (_get instanceof <%ch.hilbri.assist.datamodel.result.mapping.Core%>)\n\t\t{\n\t\t\t_matched=true;\n\t\t\t_switchResult = <%ch.hilbri.assist.datamodel.model.HardwareArchitectureLevelType%>.CORE;\n\t\t}\n\t}\n\t_xifexpression = _switchResult;\n}\nreturn _xifexpression;'"
	 * @generated
	 */
	HardwareArchitectureLevelType getTopHardwareLevel();

	/**
	 * Returns the value of the '<em><b>Bottom Hardware Level</b></em>' attribute.
	 * The literals are from the enumeration {@link ch.hilbri.assist.datamodel.model.HardwareArchitectureLevelType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Returns the bottom hardware level for this result
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Bottom Hardware Level</em>' attribute.
	 * @see ch.hilbri.assist.datamodel.model.HardwareArchitectureLevelType
	 * @see ch.hilbri.assist.datamodel.result.mapping.MappingPackage#getResult_BottomHardwareLevel()
	 * @model unique="false" transient="true" changeable="false" volatile="true" derived="true"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel get='return <%ch.hilbri.assist.datamodel.model.HardwareArchitectureLevelType%>.CORE;'"
	 * @generated
	 */
	HardwareArchitectureLevelType getBottomHardwareLevel();

	/**
	 * Returns the value of the '<em><b>Application Groups</b></em>' containment reference list.
	 * The list contents are of type {@link ch.hilbri.assist.datamodel.result.mapping.ApplicationGroup}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Contains a list of all application groups
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Application Groups</em>' containment reference list.
	 * @see ch.hilbri.assist.datamodel.result.mapping.MappingPackage#getResult_ApplicationGroups()
	 * @model containment="true"
	 * @generated
	 */
	EList<ApplicationGroup> getApplicationGroups();

	/**
	 * Returns the value of the '<em><b>Applications</b></em>' containment reference list.
	 * The list contents are of type {@link ch.hilbri.assist.datamodel.result.mapping.Application}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Contains a list of all applications
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Applications</em>' containment reference list.
	 * @see ch.hilbri.assist.datamodel.result.mapping.MappingPackage#getResult_Applications()
	 * @model containment="true"
	 * @generated
	 */
	EList<Application> getApplications();

	/**
	 * Returns the value of the '<em><b>Networks</b></em>' containment reference list.
	 * The list contents are of type {@link ch.hilbri.assist.datamodel.result.mapping.Network}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Contains a list of all networks
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Networks</em>' containment reference list.
	 * @see ch.hilbri.assist.datamodel.result.mapping.MappingPackage#getResult_Networks()
	 * @model containment="true"
	 * @generated
	 */
	EList<Network> getNetworks();

	/**
	 * Returns the value of the '<em><b>Communications</b></em>' containment reference list.
	 * The list contents are of type {@link ch.hilbri.assist.datamodel.result.mapping.CommunicationRelation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Contains a list of all communication relations between applications
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Communications</em>' containment reference list.
	 * @see ch.hilbri.assist.datamodel.result.mapping.MappingPackage#getResult_Communications()
	 * @model containment="true"
	 * @generated
	 */
	EList<CommunicationRelation> getCommunications();

	/**
	 * Returns the value of the '<em><b>Evaluation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Contains the results of the evaluation for this result
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Evaluation</em>' containment reference.
	 * @see #setEvaluation(Evaluation)
	 * @see ch.hilbri.assist.datamodel.result.mapping.MappingPackage#getResult_Evaluation()
	 * @model containment="true"
	 * @generated
	 */
	Evaluation getEvaluation();

	/**
	 * Sets the value of the '{@link ch.hilbri.assist.datamodel.result.mapping.Result#getEvaluation <em>Evaluation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Evaluation</em>' containment reference.
	 * @see #getEvaluation()
	 * @generated
	 */
	void setEvaluation(Evaluation value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model unique="false" oUnique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%ch.hilbri.assist.datamodel.result.mapping.Evaluation%> _evaluation = null;\nif (this!=null)\n{\n\t_evaluation=this.getEvaluation();\n}\ndouble _totalScaledScore = _evaluation.getTotalScaledScore();\n<%ch.hilbri.assist.datamodel.result.mapping.Evaluation%> _evaluation_1 = null;\nif (o!=null)\n{\n\t_evaluation_1=o.getEvaluation();\n}\ndouble _totalScaledScore_1 = _evaluation_1.getTotalScaledScore();\nfinal double diff = (_totalScaledScore - _totalScaledScore_1);\nif ((diff < 0.0))\n{\n\treturn 1;\n}\nif ((diff > 0.0))\n{\n\treturn (-1);\n}\nreturn 0;'"
	 * @generated
	 */
	int compareTo(Result o);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Create a list of all compartmens in this result
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%ch.hilbri.assist.datamodel.model.HardwareArchitectureLevelType%> _topHardwareLevel = this.getTopHardwareLevel();\nboolean _equals = <%com.google.common.base.Objects%>.equal(_topHardwareLevel, <%ch.hilbri.assist.datamodel.model.HardwareArchitectureLevelType%>.COMPARTMENT);\nif (_equals)\n{\n\t<%org.eclipse.emf.common.util.EList%><<%ch.hilbri.assist.datamodel.result.mapping.HardwareElement%>> _rootHardwareElements = this.getRootHardwareElements();\n\tfinal <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%ch.hilbri.assist.datamodel.result.mapping.HardwareElement%>, <%ch.hilbri.assist.datamodel.result.mapping.Compartment%>> _function = new <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%ch.hilbri.assist.datamodel.result.mapping.HardwareElement%>, <%ch.hilbri.assist.datamodel.result.mapping.Compartment%>>()\n\t{\n\t\tpublic <%ch.hilbri.assist.datamodel.result.mapping.Compartment%> apply(final <%ch.hilbri.assist.datamodel.result.mapping.HardwareElement%> elem)\n\t\t{\n\t\t\treturn ((<%ch.hilbri.assist.datamodel.result.mapping.Compartment%>) elem);\n\t\t}\n\t};\n\treturn <%org.eclipse.emf.ecore.xcore.lib.XcoreEListExtensions%>.<<%ch.hilbri.assist.datamodel.result.mapping.HardwareElement%>, <%ch.hilbri.assist.datamodel.result.mapping.Compartment%>>map(_rootHardwareElements, _function);\n}\nelse\n{\n\treturn new <%org.eclipse.emf.common.util.BasicEList%><<%ch.hilbri.assist.datamodel.result.mapping.Compartment%>>();\n}'"
	 * @generated
	 */
	EList<Compartment> getAllCompartments();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Create a list of all boxes in this result
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='final <%org.eclipse.emf.common.util.BasicEList%><<%ch.hilbri.assist.datamodel.result.mapping.Box%>> list = new <%org.eclipse.emf.common.util.BasicEList%><<%ch.hilbri.assist.datamodel.result.mapping.Box%>>();\n<%ch.hilbri.assist.datamodel.model.HardwareArchitectureLevelType%> _topHardwareLevel = this.getTopHardwareLevel();\nif (_topHardwareLevel != null)\n{\n\tswitch (_topHardwareLevel)\n\t{\n\t\tcase COMPARTMENT:\n\t\t\t<%org.eclipse.emf.common.util.EList%><<%ch.hilbri.assist.datamodel.result.mapping.HardwareElement%>> _rootHardwareElements = this.getRootHardwareElements();\n\t\t\tfor (final <%ch.hilbri.assist.datamodel.result.mapping.HardwareElement%> c : _rootHardwareElements)\n\t\t\t{\n\t\t\t\t<%org.eclipse.emf.common.util.EList%><<%ch.hilbri.assist.datamodel.result.mapping.Box%>> _boxes = ((<%ch.hilbri.assist.datamodel.result.mapping.Compartment%>) c).getBoxes();\n\t\t\t\tlist.addAll(_boxes);\n\t\t\t}\n\t\t\tbreak;\n\t\tcase BOX:\n\t\t\t<%org.eclipse.emf.common.util.EList%><<%ch.hilbri.assist.datamodel.result.mapping.HardwareElement%>> _rootHardwareElements_1 = this.getRootHardwareElements();\n\t\t\tfinal <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%ch.hilbri.assist.datamodel.result.mapping.HardwareElement%>, <%ch.hilbri.assist.datamodel.result.mapping.Box%>> _function = new <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%ch.hilbri.assist.datamodel.result.mapping.HardwareElement%>, <%ch.hilbri.assist.datamodel.result.mapping.Box%>>()\n\t\t\t{\n\t\t\t\tpublic <%ch.hilbri.assist.datamodel.result.mapping.Box%> apply(final <%ch.hilbri.assist.datamodel.result.mapping.HardwareElement%> elem)\n\t\t\t\t{\n\t\t\t\t\treturn ((<%ch.hilbri.assist.datamodel.result.mapping.Box%>) elem);\n\t\t\t\t}\n\t\t\t};\n\t\t\t<%org.eclipse.emf.common.util.EList%><<%ch.hilbri.assist.datamodel.result.mapping.Box%>> _map = <%org.eclipse.emf.ecore.xcore.lib.XcoreEListExtensions%>.<<%ch.hilbri.assist.datamodel.result.mapping.HardwareElement%>, <%ch.hilbri.assist.datamodel.result.mapping.Box%>>map(_rootHardwareElements_1, _function);\n\t\t\tlist.addAll(_map);\n\t\t\tbreak;\n\t\tdefault:\n\t\t\tbreak;\n\t}\n}\nelse\n{\n}\nreturn list;'"
	 * @generated
	 */
	EList<Box> getAllBoxes();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Create a list of all boards in this result
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='final <%org.eclipse.emf.common.util.BasicEList%><<%ch.hilbri.assist.datamodel.result.mapping.Board%>> list = new <%org.eclipse.emf.common.util.BasicEList%><<%ch.hilbri.assist.datamodel.result.mapping.Board%>>();\n<%ch.hilbri.assist.datamodel.model.HardwareArchitectureLevelType%> _topHardwareLevel = this.getTopHardwareLevel();\nif (_topHardwareLevel != null)\n{\n\tswitch (_topHardwareLevel)\n\t{\n\t\tcase COMPARTMENT:\n\t\t\t<%org.eclipse.emf.common.util.EList%><<%ch.hilbri.assist.datamodel.result.mapping.HardwareElement%>> _rootHardwareElements = this.getRootHardwareElements();\n\t\t\tfor (final <%ch.hilbri.assist.datamodel.result.mapping.HardwareElement%> c : _rootHardwareElements)\n\t\t\t{\n\t\t\t\t<%org.eclipse.emf.common.util.EList%><<%ch.hilbri.assist.datamodel.result.mapping.Board%>> _allBoards = ((<%ch.hilbri.assist.datamodel.result.mapping.Compartment%>) c).getAllBoards();\n\t\t\t\tlist.addAll(_allBoards);\n\t\t\t}\n\t\t\tbreak;\n\t\tcase BOX:\n\t\t\t<%org.eclipse.emf.common.util.EList%><<%ch.hilbri.assist.datamodel.result.mapping.HardwareElement%>> _rootHardwareElements_1 = this.getRootHardwareElements();\n\t\t\tfor (final <%ch.hilbri.assist.datamodel.result.mapping.HardwareElement%> b : _rootHardwareElements_1)\n\t\t\t{\n\t\t\t\t<%org.eclipse.emf.common.util.EList%><<%ch.hilbri.assist.datamodel.result.mapping.Board%>> _boards = ((<%ch.hilbri.assist.datamodel.result.mapping.Box%>) b).getBoards();\n\t\t\t\tlist.addAll(_boards);\n\t\t\t}\n\t\t\tbreak;\n\t\tcase BOARD:\n\t\t\t<%org.eclipse.emf.common.util.EList%><<%ch.hilbri.assist.datamodel.result.mapping.HardwareElement%>> _rootHardwareElements_2 = this.getRootHardwareElements();\n\t\t\tfinal <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%ch.hilbri.assist.datamodel.result.mapping.HardwareElement%>, <%ch.hilbri.assist.datamodel.result.mapping.Board%>> _function = new <%org.eclipse.xtext.xbase.lib.Functions.Function1%><<%ch.hilbri.assist.datamodel.result.mapping.HardwareElement%>, <%ch.hilbri.assist.datamodel.result.mapping.Board%>>()\n\t\t\t{\n\t\t\t\tpublic <%ch.hilbri.assist.datamodel.result.mapping.Board%> apply(final <%ch.hilbri.assist.datamodel.result.mapping.HardwareElement%> elem)\n\t\t\t\t{\n\t\t\t\t\treturn ((<%ch.hilbri.assist.datamodel.result.mapping.Board%>) elem);\n\t\t\t\t}\n\t\t\t};\n\t\t\t<%org.eclipse.emf.common.util.EList%><<%ch.hilbri.assist.datamodel.result.mapping.Board%>> _map = <%org.eclipse.emf.ecore.xcore.lib.XcoreEListExtensions%>.<<%ch.hilbri.assist.datamodel.result.mapping.HardwareElement%>, <%ch.hilbri.assist.datamodel.result.mapping.Board%>>map(_rootHardwareElements_2, _function);\n\t\t\tlist.addAll(_map);\n\t\t\tbreak;\n\t\tdefault:\n\t\t\tbreak;\n\t}\n}\nelse\n{\n}\nreturn list;'"
	 * @generated
	 */
	EList<Board> getAllBoards();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Create a list of all processors in this result
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='final <%org.eclipse.emf.common.util.BasicEList%><<%ch.hilbri.assist.datamodel.result.mapping.Processor%>> list = new <%org.eclipse.emf.common.util.BasicEList%><<%ch.hilbri.assist.datamodel.result.mapping.Processor%>>();\n<%ch.hilbri.assist.datamodel.model.HardwareArchitectureLevelType%> _topHardwareLevel = this.getTopHardwareLevel();\nif (_topHardwareLevel != null)\n{\n\tswitch (_topHardwareLevel)\n\t{\n\t\tcase COMPARTMENT:\n\t\t\t<%org.eclipse.emf.common.util.EList%><<%ch.hilbri.assist.datamodel.result.mapping.HardwareElement%>> _rootHardwareElements = this.getRootHardwareElements();\n\t\t\tfor (final <%ch.hilbri.assist.datamodel.result.mapping.HardwareElement%> c : _rootHardwareElements)\n\t\t\t{\n\t\t\t\t<%org.eclipse.emf.common.util.EList%><<%ch.hilbri.assist.datamodel.result.mapping.Processor%>> _allProcessors = ((<%ch.hilbri.assist.datamodel.result.mapping.Compartment%>) c).getAllProcessors();\n\t\t\t\tlist.addAll(_allProcessors);\n\t\t\t}\n\t\t\tbreak;\n\t\tcase BOX:\n\t\t\t<%org.eclipse.emf.common.util.EList%><<%ch.hilbri.assist.datamodel.result.mapping.HardwareElement%>> _rootHardwareElements_1 = this.getRootHardwareElements();\n\t\t\tfor (final <%ch.hilbri.assist.datamodel.result.mapping.HardwareElement%> b : _rootHardwareElements_1)\n\t\t\t{\n\t\t\t\t<%org.eclipse.emf.common.util.EList%><<%ch.hilbri.assist.datamodel.result.mapping.Processor%>> _allProcessors_1 = ((<%ch.hilbri.assist.datamodel.result.mapping.Box%>) b).getAllProcessors();\n\t\t\t\tlist.addAll(_allProcessors_1);\n\t\t\t}\n\t\t\tbreak;\n\t\tcase BOARD:\n\t\t\t<%org.eclipse.emf.common.util.EList%><<%ch.hilbri.assist.datamodel.result.mapping.HardwareElement%>> _rootHardwareElements_2 = this.getRootHardwareElements();\n\t\t\tfor (final <%ch.hilbri.assist.datamodel.result.mapping.HardwareElement%> b_1 : _rootHardwareElements_2)\n\t\t\t{\n\t\t\t\t<%org.eclipse.emf.common.util.EList%><<%ch.hilbri.assist.datamodel.result.mapping.Processor%>> _processors = ((<%ch.hilbri.assist.datamodel.result.mapping.Board%>) b_1).getProcessors();\n\t\t\t\tlist.addAll(_processors);\n\t\t\t}\n\t\t\tbreak;\n\t\tdefault:\n\t\t\tbreak;\n\t}\n}\nelse\n{\n}\nreturn list;'"
	 * @generated
	 */
	EList<Processor> getAllProcessors();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Create a list of all cores in this result
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='final <%org.eclipse.emf.common.util.BasicEList%><<%ch.hilbri.assist.datamodel.result.mapping.Core%>> list = new <%org.eclipse.emf.common.util.BasicEList%><<%ch.hilbri.assist.datamodel.result.mapping.Core%>>();\n<%ch.hilbri.assist.datamodel.model.HardwareArchitectureLevelType%> _topHardwareLevel = this.getTopHardwareLevel();\nif (_topHardwareLevel != null)\n{\n\tswitch (_topHardwareLevel)\n\t{\n\t\tcase COMPARTMENT:\n\t\t\t<%org.eclipse.emf.common.util.EList%><<%ch.hilbri.assist.datamodel.result.mapping.HardwareElement%>> _rootHardwareElements = this.getRootHardwareElements();\n\t\t\tfor (final <%ch.hilbri.assist.datamodel.result.mapping.HardwareElement%> c : _rootHardwareElements)\n\t\t\t{\n\t\t\t\t<%org.eclipse.emf.common.util.EList%><<%ch.hilbri.assist.datamodel.result.mapping.Core%>> _allCores = ((<%ch.hilbri.assist.datamodel.result.mapping.Compartment%>) c).getAllCores();\n\t\t\t\tlist.addAll(_allCores);\n\t\t\t}\n\t\t\tbreak;\n\t\tcase BOX:\n\t\t\t<%org.eclipse.emf.common.util.EList%><<%ch.hilbri.assist.datamodel.result.mapping.HardwareElement%>> _rootHardwareElements_1 = this.getRootHardwareElements();\n\t\t\tfor (final <%ch.hilbri.assist.datamodel.result.mapping.HardwareElement%> b : _rootHardwareElements_1)\n\t\t\t{\n\t\t\t\t<%org.eclipse.emf.common.util.EList%><<%ch.hilbri.assist.datamodel.result.mapping.Core%>> _allCores_1 = ((<%ch.hilbri.assist.datamodel.result.mapping.Box%>) b).getAllCores();\n\t\t\t\tlist.addAll(_allCores_1);\n\t\t\t}\n\t\t\tbreak;\n\t\tcase BOARD:\n\t\t\t<%org.eclipse.emf.common.util.EList%><<%ch.hilbri.assist.datamodel.result.mapping.HardwareElement%>> _rootHardwareElements_2 = this.getRootHardwareElements();\n\t\t\tfor (final <%ch.hilbri.assist.datamodel.result.mapping.HardwareElement%> b_1 : _rootHardwareElements_2)\n\t\t\t{\n\t\t\t\t<%org.eclipse.emf.common.util.EList%><<%ch.hilbri.assist.datamodel.result.mapping.Core%>> _allCores_2 = ((<%ch.hilbri.assist.datamodel.result.mapping.Board%>) b_1).getAllCores();\n\t\t\t\tlist.addAll(_allCores_2);\n\t\t\t}\n\t\t\tbreak;\n\t\tdefault:\n\t\t\tbreak;\n\t}\n}\nelse\n{\n}\nreturn list;'"
	 * @generated
	 */
	EList<Core> getAllCores();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Creates a list of all threads in the result
	 * <!-- end-model-doc -->
	 * @model kind="operation" unique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='final <%org.eclipse.emf.common.util.BasicEList%><<%ch.hilbri.assist.datamodel.result.mapping.Thread%>> list = new <%org.eclipse.emf.common.util.BasicEList%><<%ch.hilbri.assist.datamodel.result.mapping.Thread%>>();\n<%org.eclipse.emf.common.util.EList%><<%ch.hilbri.assist.datamodel.result.mapping.Application%>> _applications = this.getApplications();\nfor (final <%ch.hilbri.assist.datamodel.result.mapping.Application%> a : _applications)\n{\n\t<%org.eclipse.emf.common.util.EList%><<%ch.hilbri.assist.datamodel.result.mapping.Thread%>> _threads = a.getThreads();\n\tlist.addAll(_threads);\n}\nreturn list;'"
	 * @generated
	 */
	EList<ch.hilbri.assist.datamodel.result.mapping.Thread> getAllThreads();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Finds a hardware element in the result model which represents a given hardware element in the input model
	 * <!-- end-model-doc -->
	 * @model unique="false" modelHwElementUnique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='boolean _matched = false;\nif (!_matched)\n{\n\tif (modelHwElement instanceof <%ch.hilbri.assist.datamodel.model.Core%>)\n\t{\n\t\t_matched=true;\n\t\t<%org.eclipse.emf.common.util.EList%><<%ch.hilbri.assist.datamodel.result.mapping.Core%>> _allCores = this.getAllCores();\n\t\tfor (final <%ch.hilbri.assist.datamodel.result.mapping.Core%> c : _allCores)\n\t\t{\n\t\t\t<%ch.hilbri.assist.datamodel.model.HardwareElement%> _referenceObject = c.getReferenceObject();\n\t\t\tboolean _equals = <%com.google.common.base.Objects%>.equal(_referenceObject, modelHwElement);\n\t\t\tif (_equals)\n\t\t\t{\n\t\t\t\treturn c;\n\t\t\t}\n\t\t}\n\t}\n}\nif (!_matched)\n{\n\tif (modelHwElement instanceof <%ch.hilbri.assist.datamodel.model.Processor%>)\n\t{\n\t\t_matched=true;\n\t\t<%org.eclipse.emf.common.util.EList%><<%ch.hilbri.assist.datamodel.result.mapping.Processor%>> _allProcessors = this.getAllProcessors();\n\t\tfor (final <%ch.hilbri.assist.datamodel.result.mapping.Processor%> p : _allProcessors)\n\t\t{\n\t\t\t<%ch.hilbri.assist.datamodel.model.HardwareElement%> _referenceObject = p.getReferenceObject();\n\t\t\tboolean _equals = <%com.google.common.base.Objects%>.equal(_referenceObject, modelHwElement);\n\t\t\tif (_equals)\n\t\t\t{\n\t\t\t\treturn p;\n\t\t\t}\n\t\t}\n\t}\n}\nif (!_matched)\n{\n\tif (modelHwElement instanceof <%ch.hilbri.assist.datamodel.model.Board%>)\n\t{\n\t\t_matched=true;\n\t\t<%org.eclipse.emf.common.util.EList%><<%ch.hilbri.assist.datamodel.result.mapping.Board%>> _allBoards = this.getAllBoards();\n\t\tfor (final <%ch.hilbri.assist.datamodel.result.mapping.Board%> b : _allBoards)\n\t\t{\n\t\t\t<%ch.hilbri.assist.datamodel.model.HardwareElement%> _referenceObject = b.getReferenceObject();\n\t\t\tboolean _equals = <%com.google.common.base.Objects%>.equal(_referenceObject, modelHwElement);\n\t\t\tif (_equals)\n\t\t\t{\n\t\t\t\treturn b;\n\t\t\t}\n\t\t}\n\t}\n}\nreturn null;'"
	 * @generated
	 */
	HardwareElement findResultHardwareElement(ch.hilbri.assist.datamodel.model.HardwareElement modelHwElement);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Finds an application in the result model which represents a given Application in the input model
	 * <!-- end-model-doc -->
	 * @model unique="false" modelAppUnique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%org.eclipse.emf.common.util.EList%><<%ch.hilbri.assist.datamodel.result.mapping.Application%>> _applications = this.getApplications();\nfor (final <%ch.hilbri.assist.datamodel.result.mapping.Application%> resultApp : _applications)\n{\n\t<%ch.hilbri.assist.datamodel.model.Application%> _referenceObject = resultApp.getReferenceObject();\n\tboolean _equals = <%com.google.common.base.Objects%>.equal(_referenceObject, modelApp);\n\tif (_equals)\n\t{\n\t\treturn resultApp;\n\t}\n}\nreturn null;'"
	 * @generated
	 */
	Application findResultApplication(ch.hilbri.assist.datamodel.model.Application modelApp);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Finds a thread in the result model which represents a given thread in the input model
	 * <!-- end-model-doc -->
	 * @model unique="false" modelThreadUnique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%org.eclipse.emf.common.util.EList%><<%ch.hilbri.assist.datamodel.result.mapping.Thread%>> _allThreads = this.getAllThreads();\nfor (final <%ch.hilbri.assist.datamodel.result.mapping.Thread%> resultThread : _allThreads)\n{\n\t<%ch.hilbri.assist.datamodel.model.Thread%> _referenceObject = resultThread.getReferenceObject();\n\tboolean _equals = <%com.google.common.base.Objects%>.equal(_referenceObject, modelThread);\n\tif (_equals)\n\t{\n\t\treturn resultThread;\n\t}\n}\nreturn null;'"
	 * @generated
	 */
	ch.hilbri.assist.datamodel.result.mapping.Thread findResultThread(ch.hilbri.assist.datamodel.model.Thread modelThread);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Finds an applicationgroup in the result model which represents a given ApplicationGroup in the input model
	 * <!-- end-model-doc -->
	 * @model unique="false" modelAppGroupUnique="false"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='<%org.eclipse.emf.common.util.EList%><<%ch.hilbri.assist.datamodel.result.mapping.ApplicationGroup%>> _applicationGroups = this.getApplicationGroups();\nfor (final <%ch.hilbri.assist.datamodel.result.mapping.ApplicationGroup%> resultAppGroup : _applicationGroups)\n{\n\t<%ch.hilbri.assist.datamodel.model.ApplicationGroup%> _referenceObject = resultAppGroup.getReferenceObject();\n\tboolean _equals = <%com.google.common.base.Objects%>.equal(_referenceObject, modelAppGroup);\n\tif (_equals)\n\t{\n\t\treturn resultAppGroup;\n\t}\n}\nreturn null;'"
	 * @generated
	 */
	ApplicationGroup findResultApplicationGroup(ch.hilbri.assist.datamodel.model.ApplicationGroup modelAppGroup);

} // Result