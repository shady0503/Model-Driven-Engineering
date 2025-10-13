/**
 */
package com.mde.ModelDrivenEngineering;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Database</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.mde.ModelDrivenEngineering.Database#getType <em>Type</em>}</li>
 *   <li>{@link com.mde.ModelDrivenEngineering.Database#getHost <em>Host</em>}</li>
 *   <li>{@link com.mde.ModelDrivenEngineering.Database#getPort <em>Port</em>}</li>
 *   <li>{@link com.mde.ModelDrivenEngineering.Database#getName <em>Name</em>}</li>
 *   <li>{@link com.mde.ModelDrivenEngineering.Database#getTables <em>Tables</em>}</li>
 * </ul>
 *
 * @see com.mde.ModelDrivenEngineering.ModelDrivenPackage#getDatabase()
 * @model
 * @generated
 */
public interface Database extends EObject {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link com.mde.ModelDrivenEngineering.DatabaseType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see com.mde.ModelDrivenEngineering.DatabaseType
	 * @see #setType(DatabaseType)
	 * @see com.mde.ModelDrivenEngineering.ModelDrivenPackage#getDatabase_Type()
	 * @model required="true"
	 * @generated
	 */
	DatabaseType getType();

	/**
	 * Sets the value of the '{@link com.mde.ModelDrivenEngineering.Database#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see com.mde.ModelDrivenEngineering.DatabaseType
	 * @see #getType()
	 * @generated
	 */
	void setType(DatabaseType value);

	/**
	 * Returns the value of the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Host</em>' attribute.
	 * @see #setHost(String)
	 * @see com.mde.ModelDrivenEngineering.ModelDrivenPackage#getDatabase_Host()
	 * @model required="true"
	 * @generated
	 */
	String getHost();

	/**
	 * Sets the value of the '{@link com.mde.ModelDrivenEngineering.Database#getHost <em>Host</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Host</em>' attribute.
	 * @see #getHost()
	 * @generated
	 */
	void setHost(String value);

	/**
	 * Returns the value of the '<em><b>Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Port</em>' attribute.
	 * @see #setPort(int)
	 * @see com.mde.ModelDrivenEngineering.ModelDrivenPackage#getDatabase_Port()
	 * @model required="true"
	 * @generated
	 */
	int getPort();

	/**
	 * Sets the value of the '{@link com.mde.ModelDrivenEngineering.Database#getPort <em>Port</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Port</em>' attribute.
	 * @see #getPort()
	 * @generated
	 */
	void setPort(int value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see com.mde.ModelDrivenEngineering.ModelDrivenPackage#getDatabase_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link com.mde.ModelDrivenEngineering.Database#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Tables</b></em>' containment reference list.
	 * The list contents are of type {@link com.mde.ModelDrivenEngineering.Table}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tables</em>' containment reference list.
	 * @see com.mde.ModelDrivenEngineering.ModelDrivenPackage#getDatabase_Tables()
	 * @model containment="true"
	 * @generated
	 */
	EList<Table> getTables();

} // Database
