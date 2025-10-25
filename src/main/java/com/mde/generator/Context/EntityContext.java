/**
 */
package com.mde.generator.Context;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entity Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.mde.generator.Context.EntityContext#getTableName <em>Table Name</em>}</li>
 *   <li>{@link com.mde.generator.Context.EntityContext#getClassName <em>Class Name</em>}</li>
 *   <li>{@link com.mde.generator.Context.EntityContext#getPackageName <em>Package Name</em>}</li>
 *   <li>{@link com.mde.generator.Context.EntityContext#isHasRelationships <em>Has Relationships</em>}</li>
 *   <li>{@link com.mde.generator.Context.EntityContext#getFields <em>Fields</em>}</li>
 *   <li>{@link com.mde.generator.Context.EntityContext#getRelations <em>Relations</em>}</li>
 *   <li>{@link com.mde.generator.Context.EntityContext#getPrimaryKey <em>Primary Key</em>}</li>
 * </ul>
 *
 * @see com.mde.generator.Context.ContextPackage#getEntityContext()
 * @model
 * @generated
 */
public interface EntityContext extends EObject {
	/**
	 * Returns the value of the '<em><b>Table Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Table Name</em>' attribute.
	 * @see #setTableName(String)
	 * @see com.mde.generator.Context.ContextPackage#getEntityContext_TableName()
	 * @model required="true"
	 * @generated
	 */
	String getTableName();

	/**
	 * Sets the value of the '{@link com.mde.generator.Context.EntityContext#getTableName <em>Table Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Table Name</em>' attribute.
	 * @see #getTableName()
	 * @generated
	 */
	void setTableName(String value);

	/**
	 * Returns the value of the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class Name</em>' attribute.
	 * @see #setClassName(String)
	 * @see com.mde.generator.Context.ContextPackage#getEntityContext_ClassName()
	 * @model required="true"
	 * @generated
	 */
	String getClassName();

	/**
	 * Sets the value of the '{@link com.mde.generator.Context.EntityContext#getClassName <em>Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class Name</em>' attribute.
	 * @see #getClassName()
	 * @generated
	 */
	void setClassName(String value);

	/**
	 * Returns the value of the '<em><b>Package Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Package Name</em>' attribute.
	 * @see #setPackageName(String)
	 * @see com.mde.generator.Context.ContextPackage#getEntityContext_PackageName()
	 * @model required="true"
	 * @generated
	 */
	String getPackageName();

	/**
	 * Sets the value of the '{@link com.mde.generator.Context.EntityContext#getPackageName <em>Package Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Package Name</em>' attribute.
	 * @see #getPackageName()
	 * @generated
	 */
	void setPackageName(String value);

	/**
	 * Returns the value of the '<em><b>Has Relationships</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Relationships</em>' attribute.
	 * @see #setHasRelationships(boolean)
	 * @see com.mde.generator.Context.ContextPackage#getEntityContext_HasRelationships()
	 * @model required="true"
	 * @generated
	 */
	boolean isHasRelationships();

	/**
	 * Sets the value of the '{@link com.mde.generator.Context.EntityContext#isHasRelationships <em>Has Relationships</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Has Relationships</em>' attribute.
	 * @see #isHasRelationships()
	 * @generated
	 */
	void setHasRelationships(boolean value);

	/**
	 * Returns the value of the '<em><b>Fields</b></em>' containment reference list.
	 * The list contents are of type {@link com.mde.generator.Context.FieldContext}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fields</em>' containment reference list.
	 * @see com.mde.generator.Context.ContextPackage#getEntityContext_Fields()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<FieldContext> getFields();

	/**
	 * Returns the value of the '<em><b>Relations</b></em>' containment reference list.
	 * The list contents are of type {@link com.mde.generator.Context.RelationContext}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relations</em>' containment reference list.
	 * @see com.mde.generator.Context.ContextPackage#getEntityContext_Relations()
	 * @model containment="true"
	 * @generated
	 */
	EList<RelationContext> getRelations();

	/**
	 * Returns the value of the '<em><b>Primary Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primary Key</em>' reference.
	 * @see #setPrimaryKey(FieldContext)
	 * @see com.mde.generator.Context.ContextPackage#getEntityContext_PrimaryKey()
	 * @model required="true"
	 * @generated
	 */
	FieldContext getPrimaryKey();

	/**
	 * Sets the value of the '{@link com.mde.generator.Context.EntityContext#getPrimaryKey <em>Primary Key</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primary Key</em>' reference.
	 * @see #getPrimaryKey()
	 * @generated
	 */
	void setPrimaryKey(FieldContext value);

} // EntityContext
