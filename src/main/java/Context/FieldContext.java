/**
 */
package Context;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Field Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Context.FieldContext#getColumnName <em>Column Name</em>}</li>
 *   <li>{@link Context.FieldContext#getFieldName <em>Field Name</em>}</li>
 *   <li>{@link Context.FieldContext#getJavaType <em>Java Type</em>}</li>
 *   <li>{@link Context.FieldContext#isIsPrimaryKey <em>Is Primary Key</em>}</li>
 *   <li>{@link Context.FieldContext#isIsNullable <em>Is Nullable</em>}</li>
 *   <li>{@link Context.FieldContext#isIsUnique <em>Is Unique</em>}</li>
 *   <li>{@link Context.FieldContext#isIsAuditField <em>Is Audit Field</em>}</li>
 * </ul>
 *
 * @see Context.ContextPackage#getFieldContext()
 * @model
 * @generated
 */
public interface FieldContext extends EObject {
	/**
	 * Returns the value of the '<em><b>Column Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Column Name</em>' attribute.
	 * @see #setColumnName(String)
	 * @see Context.ContextPackage#getFieldContext_ColumnName()
	 * @model required="true"
	 * @generated
	 */
	String getColumnName();

	/**
	 * Sets the value of the '{@link Context.FieldContext#getColumnName <em>Column Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Column Name</em>' attribute.
	 * @see #getColumnName()
	 * @generated
	 */
	void setColumnName(String value);

	/**
	 * Returns the value of the '<em><b>Field Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Field Name</em>' attribute.
	 * @see #setFieldName(String)
	 * @see Context.ContextPackage#getFieldContext_FieldName()
	 * @model required="true"
	 * @generated
	 */
	String getFieldName();

	/**
	 * Sets the value of the '{@link Context.FieldContext#getFieldName <em>Field Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Field Name</em>' attribute.
	 * @see #getFieldName()
	 * @generated
	 */
	void setFieldName(String value);

	/**
	 * Returns the value of the '<em><b>Java Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Java Type</em>' attribute.
	 * @see #setJavaType(String)
	 * @see Context.ContextPackage#getFieldContext_JavaType()
	 * @model required="true"
	 * @generated
	 */
	String getJavaType();

	/**
	 * Sets the value of the '{@link Context.FieldContext#getJavaType <em>Java Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Java Type</em>' attribute.
	 * @see #getJavaType()
	 * @generated
	 */
	void setJavaType(String value);

	/**
	 * Returns the value of the '<em><b>Is Primary Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Primary Key</em>' attribute.
	 * @see #setIsPrimaryKey(boolean)
	 * @see Context.ContextPackage#getFieldContext_IsPrimaryKey()
	 * @model required="true"
	 * @generated
	 */
	boolean isIsPrimaryKey();

	/**
	 * Sets the value of the '{@link Context.FieldContext#isIsPrimaryKey <em>Is Primary Key</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Primary Key</em>' attribute.
	 * @see #isIsPrimaryKey()
	 * @generated
	 */
	void setIsPrimaryKey(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Nullable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Nullable</em>' attribute.
	 * @see #setIsNullable(boolean)
	 * @see Context.ContextPackage#getFieldContext_IsNullable()
	 * @model required="true"
	 * @generated
	 */
	boolean isIsNullable();

	/**
	 * Sets the value of the '{@link Context.FieldContext#isIsNullable <em>Is Nullable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Nullable</em>' attribute.
	 * @see #isIsNullable()
	 * @generated
	 */
	void setIsNullable(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Unique</em>' attribute.
	 * @see #setIsUnique(boolean)
	 * @see Context.ContextPackage#getFieldContext_IsUnique()
	 * @model required="true"
	 * @generated
	 */
	boolean isIsUnique();

	/**
	 * Sets the value of the '{@link Context.FieldContext#isIsUnique <em>Is Unique</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Unique</em>' attribute.
	 * @see #isIsUnique()
	 * @generated
	 */
	void setIsUnique(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Audit Field</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Audit Field</em>' attribute.
	 * @see #setIsAuditField(boolean)
	 * @see Context.ContextPackage#getFieldContext_IsAuditField()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isIsAuditField();

	/**
	 * Sets the value of the '{@link Context.FieldContext#isIsAuditField <em>Is Audit Field</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Audit Field</em>' attribute.
	 * @see #isIsAuditField()
	 * @generated
	 */
	void setIsAuditField(boolean value);

} // FieldContext
