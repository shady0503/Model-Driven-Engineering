/**
 */
package com.mde.generator.Context;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Project Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.mde.generator.Context.ProjectContext#getGroupId <em>Group Id</em>}</li>
 *   <li>{@link com.mde.generator.Context.ProjectContext#getArtifactId <em>Artifact Id</em>}</li>
 *   <li>{@link com.mde.generator.Context.ProjectContext#getVersion <em>Version</em>}</li>
 *   <li>{@link com.mde.generator.Context.ProjectContext#getPackageName <em>Package Name</em>}</li>
 *   <li>{@link com.mde.generator.Context.ProjectContext#getJavaVersion <em>Java Version</em>}</li>
 *   <li>{@link com.mde.generator.Context.ProjectContext#getSpringBootVersion <em>Spring Boot Version</em>}</li>
 *   <li>{@link com.mde.generator.Context.ProjectContext#getDatabaseType <em>Database Type</em>}</li>
 *   <li>{@link com.mde.generator.Context.ProjectContext#getDatabaseName <em>Database Name</em>}</li>
 *   <li>{@link com.mde.generator.Context.ProjectContext#getEntities <em>Entities</em>}</li>
 *   <li>{@link com.mde.generator.Context.ProjectContext#getDependencies <em>Dependencies</em>}</li>
 * </ul>
 *
 * @see com.mde.generator.Context.ContextPackage#getProjectContext()
 * @model
 * @generated
 */
public interface ProjectContext extends EObject {
	/**
	 * Returns the value of the '<em><b>Group Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Group Id</em>' attribute.
	 * @see #setGroupId(String)
	 * @see com.mde.generator.Context.ContextPackage#getProjectContext_GroupId()
	 * @model required="true"
	 * @generated
	 */
	String getGroupId();

	/**
	 * Sets the value of the '{@link com.mde.generator.Context.ProjectContext#getGroupId <em>Group Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Group Id</em>' attribute.
	 * @see #getGroupId()
	 * @generated
	 */
	void setGroupId(String value);

	/**
	 * Returns the value of the '<em><b>Artifact Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Artifact Id</em>' attribute.
	 * @see #setArtifactId(String)
	 * @see com.mde.generator.Context.ContextPackage#getProjectContext_ArtifactId()
	 * @model required="true"
	 * @generated
	 */
	String getArtifactId();

	/**
	 * Sets the value of the '{@link com.mde.generator.Context.ProjectContext#getArtifactId <em>Artifact Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Artifact Id</em>' attribute.
	 * @see #getArtifactId()
	 * @generated
	 */
	void setArtifactId(String value);

	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #setVersion(String)
	 * @see com.mde.generator.Context.ContextPackage#getProjectContext_Version()
	 * @model required="true"
	 * @generated
	 */
	String getVersion();

	/**
	 * Sets the value of the '{@link com.mde.generator.Context.ProjectContext#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(String value);

	/**
	 * Returns the value of the '<em><b>Package Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Package Name</em>' attribute.
	 * @see #setPackageName(String)
	 * @see com.mde.generator.Context.ContextPackage#getProjectContext_PackageName()
	 * @model required="true"
	 * @generated
	 */
	String getPackageName();

	/**
	 * Sets the value of the '{@link com.mde.generator.Context.ProjectContext#getPackageName <em>Package Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Package Name</em>' attribute.
	 * @see #getPackageName()
	 * @generated
	 */
	void setPackageName(String value);

	/**
	 * Returns the value of the '<em><b>Java Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Java Version</em>' attribute.
	 * @see #setJavaVersion(String)
	 * @see com.mde.generator.Context.ContextPackage#getProjectContext_JavaVersion()
	 * @model required="true"
	 * @generated
	 */
	String getJavaVersion();

	/**
	 * Sets the value of the '{@link com.mde.generator.Context.ProjectContext#getJavaVersion <em>Java Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Java Version</em>' attribute.
	 * @see #getJavaVersion()
	 * @generated
	 */
	void setJavaVersion(String value);

	/**
	 * Returns the value of the '<em><b>Spring Boot Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Spring Boot Version</em>' attribute.
	 * @see #setSpringBootVersion(String)
	 * @see com.mde.generator.Context.ContextPackage#getProjectContext_SpringBootVersion()
	 * @model required="true"
	 * @generated
	 */
	String getSpringBootVersion();

	/**
	 * Sets the value of the '{@link com.mde.generator.Context.ProjectContext#getSpringBootVersion <em>Spring Boot Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Spring Boot Version</em>' attribute.
	 * @see #getSpringBootVersion()
	 * @generated
	 */
	void setSpringBootVersion(String value);

	/**
	 * Returns the value of the '<em><b>Database Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Database Type</em>' attribute.
	 * @see #setDatabaseType(String)
	 * @see com.mde.generator.Context.ContextPackage#getProjectContext_DatabaseType()
	 * @model required="true"
	 * @generated
	 */
	String getDatabaseType();

	/**
	 * Sets the value of the '{@link com.mde.generator.Context.ProjectContext#getDatabaseType <em>Database Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Database Type</em>' attribute.
	 * @see #getDatabaseType()
	 * @generated
	 */
	void setDatabaseType(String value);

	/**
	 * Returns the value of the '<em><b>Database Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Database Name</em>' attribute.
	 * @see #setDatabaseName(String)
	 * @see com.mde.generator.Context.ContextPackage#getProjectContext_DatabaseName()
	 * @model required="true"
	 * @generated
	 */
	String getDatabaseName();

	/**
	 * Sets the value of the '{@link com.mde.generator.Context.ProjectContext#getDatabaseName <em>Database Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Database Name</em>' attribute.
	 * @see #getDatabaseName()
	 * @generated
	 */
	void setDatabaseName(String value);

	/**
	 * Returns the value of the '<em><b>Entities</b></em>' containment reference list.
	 * The list contents are of type {@link com.mde.generator.Context.EntityContext}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entities</em>' containment reference list.
	 * @see com.mde.generator.Context.ContextPackage#getProjectContext_Entities()
	 * @model containment="true"
	 * @generated
	 */
	EList<EntityContext> getEntities();

	/**
	 * Returns the value of the '<em><b>Dependencies</b></em>' containment reference list.
	 * The list contents are of type {@link com.mde.generator.Context.DependencyContext}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependencies</em>' containment reference list.
	 * @see com.mde.generator.Context.ContextPackage#getProjectContext_Dependencies()
	 * @model containment="true"
	 * @generated
	 */
	EList<DependencyContext> getDependencies();

} // ProjectContext
