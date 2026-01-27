/**
 */
package Forge;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Backend Config</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link Forge.BackendConfig#getProject <em>Project</em>}</li>
 *   <li>{@link Forge.BackendConfig#getDatabase <em>Database</em>}</li>
 *   <li>{@link Forge.BackendConfig#getApi <em>Api</em>}</li>
 * </ul>
 *
 * @see Forge.ForgePackage#getBackendConfig()
 * @model
 * @generated
 */
public interface BackendConfig extends EObject {
	/**
	 * Returns the value of the '<em><b>Project</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project</em>' containment reference.
	 * @see #setProject(Project)
	 * @see Forge.ForgePackage#getBackendConfig_Project()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Project getProject();

	/**
	 * Sets the value of the '{@link Forge.BackendConfig#getProject <em>Project</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project</em>' containment reference.
	 * @see #getProject()
	 * @generated
	 */
	void setProject(Project value);

	/**
	 * Returns the value of the '<em><b>Database</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Database</em>' containment reference.
	 * @see #setDatabase(Database)
	 * @see Forge.ForgePackage#getBackendConfig_Database()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Database getDatabase();

	/**
	 * Sets the value of the '{@link Forge.BackendConfig#getDatabase <em>Database</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Database</em>' containment reference.
	 * @see #getDatabase()
	 * @generated
	 */
	void setDatabase(Database value);

	/**
	 * Returns the value of the '<em><b>Api</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Api</em>' containment reference.
	 * @see #setApi(Api)
	 * @see Forge.ForgePackage#getBackendConfig_Api()
	 * @model containment="true"
	 * @generated
	 */
	Api getApi();

	/**
	 * Sets the value of the '{@link Forge.BackendConfig#getApi <em>Api</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Api</em>' containment reference.
	 * @see #getApi()
	 * @generated
	 */
	void setApi(Api value);

} // BackendConfig
