/**
 */
package Forge;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link Forge.Relation#getTargetTable <em>Target
 * Table</em>}</li>
 * <li>{@link Forge.Relation#getTargetColumn <em>Target
 * Column</em>}</li>
 * <li>{@link Forge.Relation#getOnDelete <em>On
 * Delete</em>}</li>
 * <li>{@link Forge.Relation#getType <em>Type</em>}</li>
 * <li>{@link Forge.Relation#isOwner <em>Owner</em>}</li>
 * <li>{@link Forge.Relation#getFetch <em>Fetch</em>}</li>
 * <li>{@link Forge.Relation#getCascade <em>Cascade</em>}</li>
 * <li>{@link Forge.Relation#isOptional <em>Optional</em>}</li>
 * <li>{@link Forge.Relation#getJoinTableName <em>Join Table
 * Name</em>}</li>
 * <li>{@link Forge.Relation#getJoinColumnName <em>Join Column
 * Name</em>}</li>
 * <li>{@link Forge.Relation#getInverseJoinColumnName
 * <em>Inverse Join Column Name</em>}</li>
 * <li>{@link Forge.Relation#getMappedBy <em>Mapped
 * By</em>}</li>
 * </ul>
 *
 * @see Forge.ForgePackage#getRelation()
 * @model
 * @generated
 */
public interface Relation extends EObject {
	/**
	 * Returns the value of the '<em><b>Target Table</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Target Table</em>' attribute.
	 * @see #setTargetTable(String)
	 * @see Forge.ForgePackage#getRelation_TargetTable()
	 * @model required="true"
	 * @generated
	 */
	String getTargetTable();

	/**
	 * Sets the value of the '{@link Forge.Relation#getTargetTable
	 * <em>Target Table</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Target Table</em>' attribute.
	 * @see #getTargetTable()
	 * @generated
	 */
	void setTargetTable(String value);

	/**
	 * Returns the value of the '<em><b>Target Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Target Column</em>' attribute.
	 * @see #setTargetColumn(String)
	 * @see Forge.ForgePackage#getRelation_TargetColumn()
	 * @model
	 * @generated
	 */
	String getTargetColumn();

	/**
	 * Sets the value of the '{@link Forge.Relation#getTargetColumn
	 * <em>Target Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Target Column</em>' attribute.
	 * @see #getTargetColumn()
	 * @generated
	 */
	void setTargetColumn(String value);

	/**
	 * Returns the value of the '<em><b>On Delete</b></em>' attribute.
	 * The default value is <code>"RESTRICT"</code>.
	 * The literals are from the enumeration
	 * {@link Forge.CascadeType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>On Delete</em>' attribute.
	 * @see Forge.CascadeType
	 * @see #setOnDelete(CascadeType)
	 * @see Forge.ForgePackage#getRelation_OnDelete()
	 * @model default="RESTRICT"
	 * @generated
	 */
	CascadeType getOnDelete();

	/**
	 * Sets the value of the '{@link Forge.Relation#getOnDelete
	 * <em>On Delete</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>On Delete</em>' attribute.
	 * @see Forge.CascadeType
	 * @see #getOnDelete()
	 * @generated
	 */
	void setOnDelete(CascadeType value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The default value is <code>"MANY_TO_ONE"</code>.
	 * The literals are from the enumeration
	 * {@link Forge.RelationType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see Forge.RelationType
	 * @see #setType(RelationType)
	 * @see Forge.ForgePackage#getRelation_Type()
	 * @model default="MANY_TO_ONE" required="true"
	 * @generated
	 */
	RelationType getType();

	/**
	 * Sets the value of the '{@link Forge.Relation#getType
	 * <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see Forge.RelationType
	 * @see #getType()
	 * @generated
	 */
	void setType(RelationType value);

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Owner</em>' attribute.
	 * @see #setOwner(boolean)
	 * @see Forge.ForgePackage#getRelation_Owner()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isOwner();

	/**
	 * Sets the value of the '{@link Forge.Relation#isOwner
	 * <em>Owner</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Owner</em>' attribute.
	 * @see #isOwner()
	 * @generated
	 */
	void setOwner(boolean value);

	/**
	 * Returns the value of the '<em><b>Fetch</b></em>' attribute.
	 * The default value is <code>"LAZY"</code>.
	 * The literals are from the enumeration
	 * {@link Forge.FetchType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Fetch</em>' attribute.
	 * @see Forge.FetchType
	 * @see #setFetch(FetchType)
	 * @see Forge.ForgePackage#getRelation_Fetch()
	 * @model default="LAZY"
	 * @generated
	 */
	FetchType getFetch();

	/**
	 * Sets the value of the '{@link Forge.Relation#getFetch
	 * <em>Fetch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Fetch</em>' attribute.
	 * @see Forge.FetchType
	 * @see #getFetch()
	 * @generated
	 */
	void setFetch(FetchType value);

	/**
	 * Returns the value of the '<em><b>Cascade</b></em>' attribute.
	 * The default value is <code>"ALL"</code>.
	 * The literals are from the enumeration
	 * {@link Forge.JpaCascadeType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Cascade</em>' attribute.
	 * @see Forge.JpaCascadeType
	 * @see #setCascade(JpaCascadeType)
	 * @see Forge.ForgePackage#getRelation_Cascade()
	 * @model default="ALL"
	 * @generated
	 */
	JpaCascadeType getCascade();

	/**
	 * Sets the value of the '{@link Forge.Relation#getCascade
	 * <em>Cascade</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Cascade</em>' attribute.
	 * @see Forge.JpaCascadeType
	 * @see #getCascade()
	 * @generated
	 */
	void setCascade(JpaCascadeType value);

	/**
	 * Returns the value of the '<em><b>Optional</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Optional</em>' attribute.
	 * @see #setOptional(boolean)
	 * @see Forge.ForgePackage#getRelation_Optional()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isOptional();

	/**
	 * Sets the value of the '{@link Forge.Relation#isOptional
	 * <em>Optional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Optional</em>' attribute.
	 * @see #isOptional()
	 * @generated
	 */
	void setOptional(boolean value);

	/**
	 * Returns the value of the '<em><b>Join Table Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Join Table Name</em>' attribute.
	 * @see #setJoinTableName(String)
	 * @see Forge.ForgePackage#getRelation_JoinTableName()
	 * @model
	 * @generated
	 */
	String getJoinTableName();

	/**
	 * Sets the value of the
	 * '{@link Forge.Relation#getJoinTableName <em>Join Table
	 * Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Join Table Name</em>' attribute.
	 * @see #getJoinTableName()
	 * @generated
	 */
	void setJoinTableName(String value);

	/**
	 * Returns the value of the '<em><b>Join Column Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Join Column Name</em>' attribute.
	 * @see #setJoinColumnName(String)
	 * @see Forge.ForgePackage#getRelation_JoinColumnName()
	 * @model
	 * @generated
	 */
	String getJoinColumnName();

	/**
	 * Sets the value of the
	 * '{@link Forge.Relation#getJoinColumnName <em>Join Column
	 * Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Join Column Name</em>' attribute.
	 * @see #getJoinColumnName()
	 * @generated
	 */
	void setJoinColumnName(String value);

	/**
	 * Returns the value of the '<em><b>Inverse Join Column Name</b></em>'
	 * attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Inverse Join Column Name</em>' attribute.
	 * @see #setInverseJoinColumnName(String)
	 * @see Forge.ForgePackage#getRelation_InverseJoinColumnName()
	 * @model
	 * @generated
	 */
	String getInverseJoinColumnName();

	/**
	 * Sets the value of the
	 * '{@link Forge.Relation#getInverseJoinColumnName <em>Inverse
	 * Join Column Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Inverse Join Column Name</em>'
	 *              attribute.
	 * @see #getInverseJoinColumnName()
	 * @generated
	 */
	void setInverseJoinColumnName(String value);

	/**
	 * Returns the value of the '<em><b>Mapped By</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Mapped By</em>' attribute.
	 * @see #setMappedBy(String)
	 * @see Forge.ForgePackage#getRelation_MappedBy()
	 * @model
	 * @generated
	 */
	String getMappedBy();

	/**
	 * Sets the value of the '{@link Forge.Relation#getMappedBy
	 * <em>Mapped By</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Mapped By</em>' attribute.
	 * @see #getMappedBy()
	 * @generated
	 */
	void setMappedBy(String value);

} // Relation
