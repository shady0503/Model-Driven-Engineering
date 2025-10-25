/**
 */
package com.mde.generator.Context;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relation Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.mde.generator.Context.RelationContext#getFieldName <em>Field Name</em>}</li>
 *   <li>{@link com.mde.generator.Context.RelationContext#getTargetEntity <em>Target Entity</em>}</li>
 *   <li>{@link com.mde.generator.Context.RelationContext#getRelationType <em>Relation Type</em>}</li>
 *   <li>{@link com.mde.generator.Context.RelationContext#isIsOwner <em>Is Owner</em>}</li>
 *   <li>{@link com.mde.generator.Context.RelationContext#getJoinColumnName <em>Join Column Name</em>}</li>
 *   <li>{@link com.mde.generator.Context.RelationContext#getMappedBy <em>Mapped By</em>}</li>
 *   <li>{@link com.mde.generator.Context.RelationContext#getCascadeType <em>Cascade Type</em>}</li>
 *   <li>{@link com.mde.generator.Context.RelationContext#getFetchType <em>Fetch Type</em>}</li>
 * </ul>
 *
 * @see com.mde.generator.Context.ContextPackage#getRelationContext()
 * @model
 * @generated
 */
public interface RelationContext extends EObject {
	/**
	 * Returns the value of the '<em><b>Field Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Field Name</em>' attribute.
	 * @see #setFieldName(String)
	 * @see com.mde.generator.Context.ContextPackage#getRelationContext_FieldName()
	 * @model required="true"
	 * @generated
	 */
	String getFieldName();

	/**
	 * Sets the value of the '{@link com.mde.generator.Context.RelationContext#getFieldName <em>Field Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Field Name</em>' attribute.
	 * @see #getFieldName()
	 * @generated
	 */
	void setFieldName(String value);

	/**
	 * Returns the value of the '<em><b>Target Entity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Entity</em>' attribute.
	 * @see #setTargetEntity(String)
	 * @see com.mde.generator.Context.ContextPackage#getRelationContext_TargetEntity()
	 * @model required="true"
	 * @generated
	 */
	String getTargetEntity();

	/**
	 * Sets the value of the '{@link com.mde.generator.Context.RelationContext#getTargetEntity <em>Target Entity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Entity</em>' attribute.
	 * @see #getTargetEntity()
	 * @generated
	 */
	void setTargetEntity(String value);

	/**
	 * Returns the value of the '<em><b>Relation Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relation Type</em>' attribute.
	 * @see #setRelationType(String)
	 * @see com.mde.generator.Context.ContextPackage#getRelationContext_RelationType()
	 * @model required="true"
	 * @generated
	 */
	String getRelationType();

	/**
	 * Sets the value of the '{@link com.mde.generator.Context.RelationContext#getRelationType <em>Relation Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relation Type</em>' attribute.
	 * @see #getRelationType()
	 * @generated
	 */
	void setRelationType(String value);

	/**
	 * Returns the value of the '<em><b>Is Owner</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Owner</em>' attribute.
	 * @see #setIsOwner(boolean)
	 * @see com.mde.generator.Context.ContextPackage#getRelationContext_IsOwner()
	 * @model required="true"
	 * @generated
	 */
	boolean isIsOwner();

	/**
	 * Sets the value of the '{@link com.mde.generator.Context.RelationContext#isIsOwner <em>Is Owner</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Owner</em>' attribute.
	 * @see #isIsOwner()
	 * @generated
	 */
	void setIsOwner(boolean value);

	/**
	 * Returns the value of the '<em><b>Join Column Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Join Column Name</em>' attribute.
	 * @see #setJoinColumnName(String)
	 * @see com.mde.generator.Context.ContextPackage#getRelationContext_JoinColumnName()
	 * @model
	 * @generated
	 */
	String getJoinColumnName();

	/**
	 * Sets the value of the '{@link com.mde.generator.Context.RelationContext#getJoinColumnName <em>Join Column Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Join Column Name</em>' attribute.
	 * @see #getJoinColumnName()
	 * @generated
	 */
	void setJoinColumnName(String value);

	/**
	 * Returns the value of the '<em><b>Mapped By</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapped By</em>' attribute.
	 * @see #setMappedBy(String)
	 * @see com.mde.generator.Context.ContextPackage#getRelationContext_MappedBy()
	 * @model
	 * @generated
	 */
	String getMappedBy();

	/**
	 * Sets the value of the '{@link com.mde.generator.Context.RelationContext#getMappedBy <em>Mapped By</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapped By</em>' attribute.
	 * @see #getMappedBy()
	 * @generated
	 */
	void setMappedBy(String value);

	/**
	 * Returns the value of the '<em><b>Cascade Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cascade Type</em>' attribute.
	 * @see #setCascadeType(String)
	 * @see com.mde.generator.Context.ContextPackage#getRelationContext_CascadeType()
	 * @model required="true"
	 * @generated
	 */
	String getCascadeType();

	/**
	 * Sets the value of the '{@link com.mde.generator.Context.RelationContext#getCascadeType <em>Cascade Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cascade Type</em>' attribute.
	 * @see #getCascadeType()
	 * @generated
	 */
	void setCascadeType(String value);

	/**
	 * Returns the value of the '<em><b>Fetch Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fetch Type</em>' attribute.
	 * @see #setFetchType(String)
	 * @see com.mde.generator.Context.ContextPackage#getRelationContext_FetchType()
	 * @model required="true"
	 * @generated
	 */
	String getFetchType();

	/**
	 * Sets the value of the '{@link com.mde.generator.Context.RelationContext#getFetchType <em>Fetch Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fetch Type</em>' attribute.
	 * @see #getFetchType()
	 * @generated
	 */
	void setFetchType(String value);

} // RelationContext
