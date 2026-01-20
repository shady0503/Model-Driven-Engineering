/**
 */
package ModelDrivenEngineering;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Api</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link ModelDrivenEngineering.Api#getBasePath <em>Base Path</em>}</li>
 *   <li>{@link ModelDrivenEngineering.Api#getRoutes <em>Routes</em>}</li>
 * </ul>
 *
 * @see ModelDrivenEngineering.ModelDrivenEngineeringPackage#getApi()
 * @model
 * @generated
 */
public interface Api extends EObject {
	/**
	 * Returns the value of the '<em><b>Base Path</b></em>' attribute.
	 * The default value is <code>"/api"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Path</em>' attribute.
	 * @see #setBasePath(String)
	 * @see ModelDrivenEngineering.ModelDrivenEngineeringPackage#getApi_BasePath()
	 * @model default="/api" required="true"
	 * @generated
	 */
	String getBasePath();

	/**
	 * Sets the value of the '{@link ModelDrivenEngineering.Api#getBasePath <em>Base Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Path</em>' attribute.
	 * @see #getBasePath()
	 * @generated
	 */
	void setBasePath(String value);

	/**
	 * Returns the value of the '<em><b>Routes</b></em>' containment reference list.
	 * The list contents are of type {@link ModelDrivenEngineering.Route}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Routes</em>' containment reference list.
	 * @see ModelDrivenEngineering.ModelDrivenEngineeringPackage#getApi_Routes()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Route> getRoutes();

} // Api
