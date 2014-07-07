/**
 * Copyright 2014 - Robert Hilbrich
 */
package ch.hilbri.assist.result;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Processor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ch.hilbri.assist.result.Processor#getManufacturer <em>Manufacturer</em>}</li>
 *   <li>{@link ch.hilbri.assist.result.Processor#getProcessorType <em>Processor Type</em>}</li>
 *   <li>{@link ch.hilbri.assist.result.Processor#getBoard <em>Board</em>}</li>
 *   <li>{@link ch.hilbri.assist.result.Processor#getCores <em>Cores</em>}</li>
 * </ul>
 * </p>
 *
 * @see ch.hilbri.assist.result.ResultPackage#getProcessor()
 * @model
 * @generated
 */
public interface Processor extends HardwareElement {
	/**
	 * Returns the value of the '<em><b>Manufacturer</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Manufacturer</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Manufacturer</em>' attribute.
	 * @see #setManufacturer(String)
	 * @see ch.hilbri.assist.result.ResultPackage#getProcessor_Manufacturer()
	 * @model unique="false"
	 * @generated
	 */
	String getManufacturer();

	/**
	 * Sets the value of the '{@link ch.hilbri.assist.result.Processor#getManufacturer <em>Manufacturer</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Manufacturer</em>' attribute.
	 * @see #getManufacturer()
	 * @generated
	 */
	void setManufacturer(String value);

	/**
	 * Returns the value of the '<em><b>Processor Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Processor Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Processor Type</em>' attribute.
	 * @see #setProcessorType(String)
	 * @see ch.hilbri.assist.result.ResultPackage#getProcessor_ProcessorType()
	 * @model unique="false"
	 * @generated
	 */
	String getProcessorType();

	/**
	 * Sets the value of the '{@link ch.hilbri.assist.result.Processor#getProcessorType <em>Processor Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Processor Type</em>' attribute.
	 * @see #getProcessorType()
	 * @generated
	 */
	void setProcessorType(String value);

	/**
	 * Returns the value of the '<em><b>Board</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link ch.hilbri.assist.result.Board#getProcessors <em>Processors</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Board</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Board</em>' container reference.
	 * @see #setBoard(Board)
	 * @see ch.hilbri.assist.result.ResultPackage#getProcessor_Board()
	 * @see ch.hilbri.assist.result.Board#getProcessors
	 * @model opposite="processors" transient="false"
	 * @generated
	 */
	Board getBoard();

	/**
	 * Sets the value of the '{@link ch.hilbri.assist.result.Processor#getBoard <em>Board</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Board</em>' container reference.
	 * @see #getBoard()
	 * @generated
	 */
	void setBoard(Board value);

	/**
	 * Returns the value of the '<em><b>Cores</b></em>' containment reference list.
	 * The list contents are of type {@link ch.hilbri.assist.result.Core}.
	 * It is bidirectional and its opposite is '{@link ch.hilbri.assist.result.Core#getProcessor <em>Processor</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cores</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cores</em>' containment reference list.
	 * @see ch.hilbri.assist.result.ResultPackage#getProcessor_Cores()
	 * @see ch.hilbri.assist.result.Core#getProcessor
	 * @model opposite="processor" containment="true" required="true"
	 * @generated
	 */
	EList<Core> getCores();

} // Processor
