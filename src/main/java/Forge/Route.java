/**
 */
package Forge;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Route</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Forge.Route#getEntity <em>Entity</em>}</li>
 *   <li>{@link Forge.Route#getMethods <em>Methods</em>}</li>
 * </ul>
 *
 * @see Forge.ForgePackage#getRoute()
 * @model
 * @generated
 */
public interface Route extends EObject {
	/**
	 * Returns the value of the '<em><b>Entity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entity</em>' attribute.
	 * @see #setEntity(String)
	 * @see Forge.ForgePackage#getRoute_Entity()
	 * @model required="true"
	 * @generated
	 */
	String getEntity();

	/**
	 * Sets the value of the '{@link Forge.Route#getEntity <em>Entity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Entity</em>' attribute.
	 * @see #getEntity()
	 * @generated
	 */
	void setEntity(String value);

	/**
	 * Returns the value of the '<em><b>Methods</b></em>' attribute list.
	 * The list contents are of type {@link Forge.HttpMethod}.
	 * The literals are from the enumeration {@link Forge.HttpMethod}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Methods</em>' attribute list.
	 * @see Forge.HttpMethod
	 * @see Forge.ForgePackage#getRoute_Methods()
	 * @model required="true"
	 * @generated
	 */
	EList<HttpMethod> getMethods();

} // Route
