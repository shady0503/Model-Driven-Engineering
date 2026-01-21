/**
 */
package ModelDrivenEngineering;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Project</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link ModelDrivenEngineering.Project#getGroupId <em>Group Id</em>}</li>
 * <li>{@link ModelDrivenEngineering.Project#getJavaVersion <em>Java
 * Version</em>}</li>
 * <li>{@link ModelDrivenEngineering.Project#getSpringBootVersion <em>Spring
 * Boot Version</em>}</li>
 * <li>{@link ModelDrivenEngineering.Project#getName <em>Name</em>}</li>
 * <li>{@link ModelDrivenEngineering.Project#getVersion <em>Version</em>}</li>
 * <li>{@link ModelDrivenEngineering.Project#getLanguage <em>Language</em>}</li>
 * <li>{@link ModelDrivenEngineering.Project#getFramework
 * <em>Framework</em>}</li>
 * </ul>
 *
 * @see ModelDrivenEngineering.ModelDrivenEngineeringPackage#getProject()
 * @model
 * @generated
 */
public interface Project extends EObject {
	/**
	 * Returns the value of the '<em><b>Group Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Group Id</em>' attribute.
	 * @see #setGroupId(String)
	 * @see ModelDrivenEngineering.ModelDrivenEngineeringPackage#getProject_GroupId()
	 * @model required="true"
	 * @generated
	 */
	String getGroupId();

	/**
	 * Sets the value of the '{@link ModelDrivenEngineering.Project#getGroupId
	 * <em>Group Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Group Id</em>' attribute.
	 * @see #getGroupId()
	 * @generated
	 */
	void setGroupId(String value);

	/**
	 * Returns the value of the '<em><b>Java Version</b></em>' attribute.
	 * The default value is <code>"17"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Java Version</em>' attribute.
	 * @see #setJavaVersion(int)
	 * @see ModelDrivenEngineering.ModelDrivenEngineeringPackage#getProject_JavaVersion()
	 * @model default="17" required="true"
	 * @generated
	 */
	int getJavaVersion();

	/**
	 * Sets the value of the '{@link ModelDrivenEngineering.Project#getJavaVersion
	 * <em>Java Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Java Version</em>' attribute.
	 * @see #getJavaVersion()
	 * @generated
	 */
	void setJavaVersion(int value);

	/**
	 * Returns the value of the '<em><b>Spring Boot Version</b></em>' attribute.
	 * The default value is <code>"3.5.6"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Spring Boot Version</em>' attribute.
	 * @see #setSpringBootVersion(String)
	 * @see ModelDrivenEngineering.ModelDrivenEngineeringPackage#getProject_SpringBootVersion()
	 * @model default="3.5.6" required="true"
	 * @generated
	 */
	String getSpringBootVersion();

	/**
	 * Sets the value of the
	 * '{@link ModelDrivenEngineering.Project#getSpringBootVersion <em>Spring Boot
	 * Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Spring Boot Version</em>' attribute.
	 * @see #getSpringBootVersion()
	 * @generated
	 */
	void setSpringBootVersion(String value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see ModelDrivenEngineering.ModelDrivenEngineeringPackage#getProject_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link ModelDrivenEngineering.Project#getName
	 * <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * The default value is <code>"1.0.0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #setVersion(String)
	 * @see ModelDrivenEngineering.ModelDrivenEngineeringPackage#getProject_Version()
	 * @model default="1.0.0"
	 * @generated
	 */
	String getVersion();

	/**
	 * Sets the value of the '{@link ModelDrivenEngineering.Project#getVersion
	 * <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(String value);

	/**
	 * Returns the value of the '<em><b>Language</b></em>' attribute.
	 * The literals are from the enumeration
	 * {@link ModelDrivenEngineering.Language}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Language</em>' attribute.
	 * @see ModelDrivenEngineering.Language
	 * @see #setLanguage(Language)
	 * @see ModelDrivenEngineering.ModelDrivenEngineeringPackage#getProject_Language()
	 * @model required="true"
	 * @generated
	 */
	Language getLanguage();

	/**
	 * Sets the value of the '{@link ModelDrivenEngineering.Project#getLanguage
	 * <em>Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Language</em>' attribute.
	 * @see ModelDrivenEngineering.Language
	 * @see #getLanguage()
	 * @generated
	 */
	void setLanguage(Language value);

	/**
	 * Returns the value of the '<em><b>Framework</b></em>' attribute.
	 * The literals are from the enumeration
	 * {@link ModelDrivenEngineering.Framework}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Framework</em>' attribute.
	 * @see ModelDrivenEngineering.Framework
	 * @see #setFramework(Framework)
	 * @see ModelDrivenEngineering.ModelDrivenEngineeringPackage#getProject_Framework()
	 * @model required="true"
	 * @generated
	 */
	Framework getFramework();

	/**
	 * Sets the value of the '{@link ModelDrivenEngineering.Project#getFramework
	 * <em>Framework</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Framework</em>' attribute.
	 * @see ModelDrivenEngineering.Framework
	 * @see #getFramework()
	 * @generated
	 */
	void setFramework(Framework value);

} // Project
