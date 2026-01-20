/**
 */
package ModelDrivenEngineering;

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
 *   <li>{@link ModelDrivenEngineering.Relation#getTargetTable <em>Target Table</em>}</li>
 *   <li>{@link ModelDrivenEngineering.Relation#getTargetColumn <em>Target Column</em>}</li>
 *   <li>{@link ModelDrivenEngineering.Relation#getOnDelete <em>On Delete</em>}</li>
 *   <li>{@link ModelDrivenEngineering.Relation#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see ModelDrivenEngineering.ModelDrivenEngineeringPackage#getRelation()
 * @model
 * @generated
 */
public interface Relation extends EObject {
	/**
	 * Returns the value of the '<em><b>Target Table</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Table</em>' attribute.
	 * @see #setTargetTable(String)
	 * @see ModelDrivenEngineering.ModelDrivenEngineeringPackage#getRelation_TargetTable()
	 * @model required="true"
	 * @generated
	 */
	String getTargetTable();

	/**
	 * Sets the value of the '{@link ModelDrivenEngineering.Relation#getTargetTable <em>Target Table</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Table</em>' attribute.
	 * @see #getTargetTable()
	 * @generated
	 */
	void setTargetTable(String value);

	/**
	 * Returns the value of the '<em><b>Target Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Column</em>' attribute.
	 * @see #setTargetColumn(String)
	 * @see ModelDrivenEngineering.ModelDrivenEngineeringPackage#getRelation_TargetColumn()
	 * @model
	 * @generated
	 */
	String getTargetColumn();

	/**
	 * Sets the value of the '{@link ModelDrivenEngineering.Relation#getTargetColumn <em>Target Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Column</em>' attribute.
	 * @see #getTargetColumn()
	 * @generated
	 */
	void setTargetColumn(String value);

	/**
	 * Returns the value of the '<em><b>On Delete</b></em>' attribute.
	 * The default value is <code>"RESTRICT"</code>.
	 * The literals are from the enumeration {@link ModelDrivenEngineering.CascadeType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>On Delete</em>' attribute.
	 * @see ModelDrivenEngineering.CascadeType
	 * @see #setOnDelete(CascadeType)
	 * @see ModelDrivenEngineering.ModelDrivenEngineeringPackage#getRelation_OnDelete()
	 * @model default="RESTRICT"
	 * @generated
	 */
	CascadeType getOnDelete();

	/**
	 * Sets the value of the '{@link ModelDrivenEngineering.Relation#getOnDelete <em>On Delete</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>On Delete</em>' attribute.
	 * @see ModelDrivenEngineering.CascadeType
	 * @see #getOnDelete()
	 * @generated
	 */
	void setOnDelete(CascadeType value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The default value is <code>"MANY_TO_ONE"</code>.
	 * The literals are from the enumeration {@link ModelDrivenEngineering.RelationType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see ModelDrivenEngineering.RelationType
	 * @see #setType(RelationType)
	 * @see ModelDrivenEngineering.ModelDrivenEngineeringPackage#getRelation_Type()
	 * @model default="MANY_TO_ONE" required="true"
	 * @generated
	 */
	RelationType getType();

	/**
	 * Sets the value of the '{@link ModelDrivenEngineering.Relation#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see ModelDrivenEngineering.RelationType
	 * @see #getType()
	 * @generated
	 */
	void setType(RelationType value);

} // Relation
