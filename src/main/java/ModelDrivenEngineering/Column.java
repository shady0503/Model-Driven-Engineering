/**
 */
package ModelDrivenEngineering;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Column</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ModelDrivenEngineering.Column#getName <em>Name</em>}</li>
 *   <li>{@link ModelDrivenEngineering.Column#getType <em>Type</em>}</li>
 *   <li>{@link ModelDrivenEngineering.Column#isPrimary <em>Primary</em>}</li>
 *   <li>{@link ModelDrivenEngineering.Column#isUnique <em>Unique</em>}</li>
 *   <li>{@link ModelDrivenEngineering.Column#isNullable <em>Nullable</em>}</li>
 *   <li>{@link ModelDrivenEngineering.Column#getLength <em>Length</em>}</li>
 *   <li>{@link ModelDrivenEngineering.Column#getRelation <em>Relation</em>}</li>
 * </ul>
 *
 * @see ModelDrivenEngineering.ModelDrivenEngineeringPackage#getColumn()
 * @model
 * @generated
 */
public interface Column extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see ModelDrivenEngineering.ModelDrivenEngineeringPackage#getColumn_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link ModelDrivenEngineering.Column#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link ModelDrivenEngineering.DataType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see ModelDrivenEngineering.DataType
	 * @see #setType(DataType)
	 * @see ModelDrivenEngineering.ModelDrivenEngineeringPackage#getColumn_Type()
	 * @model required="true"
	 * @generated
	 */
	DataType getType();

	/**
	 * Sets the value of the '{@link ModelDrivenEngineering.Column#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see ModelDrivenEngineering.DataType
	 * @see #getType()
	 * @generated
	 */
	void setType(DataType value);

	/**
	 * Returns the value of the '<em><b>Primary</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primary</em>' attribute.
	 * @see #setPrimary(boolean)
	 * @see ModelDrivenEngineering.ModelDrivenEngineeringPackage#getColumn_Primary()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isPrimary();

	/**
	 * Sets the value of the '{@link ModelDrivenEngineering.Column#isPrimary <em>Primary</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primary</em>' attribute.
	 * @see #isPrimary()
	 * @generated
	 */
	void setPrimary(boolean value);

	/**
	 * Returns the value of the '<em><b>Unique</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unique</em>' attribute.
	 * @see #setUnique(boolean)
	 * @see ModelDrivenEngineering.ModelDrivenEngineeringPackage#getColumn_Unique()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isUnique();

	/**
	 * Sets the value of the '{@link ModelDrivenEngineering.Column#isUnique <em>Unique</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Unique</em>' attribute.
	 * @see #isUnique()
	 * @generated
	 */
	void setUnique(boolean value);

	/**
	 * Returns the value of the '<em><b>Nullable</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nullable</em>' attribute.
	 * @see #setNullable(boolean)
	 * @see ModelDrivenEngineering.ModelDrivenEngineeringPackage#getColumn_Nullable()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isNullable();

	/**
	 * Sets the value of the '{@link ModelDrivenEngineering.Column#isNullable <em>Nullable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nullable</em>' attribute.
	 * @see #isNullable()
	 * @generated
	 */
	void setNullable(boolean value);

	/**
	 * Returns the value of the '<em><b>Length</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Length</em>' attribute.
	 * @see #setLength(int)
	 * @see ModelDrivenEngineering.ModelDrivenEngineeringPackage#getColumn_Length()
	 * @model default="0"
	 * @generated
	 */
	int getLength();

	/**
	 * Sets the value of the '{@link ModelDrivenEngineering.Column#getLength <em>Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Length</em>' attribute.
	 * @see #getLength()
	 * @generated
	 */
	void setLength(int value);

	/**
	 * Returns the value of the '<em><b>Relation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relation</em>' containment reference.
	 * @see #setRelation(Relation)
	 * @see ModelDrivenEngineering.ModelDrivenEngineeringPackage#getColumn_Relation()
	 * @model containment="true"
	 * @generated
	 */
	Relation getRelation();

	/**
	 * Sets the value of the '{@link ModelDrivenEngineering.Column#getRelation <em>Relation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Relation</em>' containment reference.
	 * @see #getRelation()
	 * @generated
	 */
	void setRelation(Relation value);

} // Column
