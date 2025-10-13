/**
 */
package com.mde.ModelDrivenEngineering;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.mde.ModelDrivenEngineering.ModelDrivenFactory
 * @model kind="package"
 * @generated
 */
public interface ModelDrivenPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "ModelDrivenEngineering";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.ModelDrivenEngineering.com/model/v1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "MDE";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelDrivenPackage eINSTANCE = com.mde.ModelDrivenEngineering.impl.ModelDrivenPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.mde.ModelDrivenEngineering.impl.BackendConfigImpl <em>Backend Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.mde.ModelDrivenEngineering.impl.BackendConfigImpl
	 * @see com.mde.ModelDrivenEngineering.impl.ModelDrivenPackageImpl#getBackendConfig()
	 * @generated
	 */
	int BACKEND_CONFIG = 0;

	/**
	 * The feature id for the '<em><b>Project</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKEND_CONFIG__PROJECT = 0;

	/**
	 * The feature id for the '<em><b>Database</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKEND_CONFIG__DATABASE = 1;

	/**
	 * The feature id for the '<em><b>Api</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKEND_CONFIG__API = 2;

	/**
	 * The number of structural features of the '<em>Backend Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKEND_CONFIG_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Backend Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BACKEND_CONFIG_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.mde.ModelDrivenEngineering.impl.ProjectImpl <em>Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.mde.ModelDrivenEngineering.impl.ProjectImpl
	 * @see com.mde.ModelDrivenEngineering.impl.ModelDrivenPackageImpl#getProject()
	 * @generated
	 */
	int PROJECT = 1;

	/**
	 * The feature id for the '<em><b>Group Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__GROUP_ID = 0;

	/**
	 * The feature id for the '<em><b>Java Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__JAVA_VERSION = 1;

	/**
	 * The feature id for the '<em><b>Spring Boot Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__SPRING_BOOT_VERSION = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__NAME = 3;

	/**
	 * The feature id for the '<em><b>Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__LANGUAGE = 4;

	/**
	 * The feature id for the '<em><b>Framework</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT__FRAMEWORK = 5;

	/**
	 * The number of structural features of the '<em>Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.mde.ModelDrivenEngineering.impl.DatabaseImpl <em>Database</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.mde.ModelDrivenEngineering.impl.DatabaseImpl
	 * @see com.mde.ModelDrivenEngineering.impl.ModelDrivenPackageImpl#getDatabase()
	 * @generated
	 */
	int DATABASE = 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE__HOST = 1;

	/**
	 * The feature id for the '<em><b>Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE__PORT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE__NAME = 3;

	/**
	 * The feature id for the '<em><b>Tables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE__TABLES = 4;

	/**
	 * The number of structural features of the '<em>Database</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Database</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATABASE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.mde.ModelDrivenEngineering.impl.TableImpl <em>Table</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.mde.ModelDrivenEngineering.impl.TableImpl
	 * @see com.mde.ModelDrivenEngineering.impl.ModelDrivenPackageImpl#getTable()
	 * @generated
	 */
	int TABLE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Columns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE__COLUMNS = 1;

	/**
	 * The number of structural features of the '<em>Table</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Table</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TABLE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.mde.ModelDrivenEngineering.impl.ColumnImpl <em>Column</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.mde.ModelDrivenEngineering.impl.ColumnImpl
	 * @see com.mde.ModelDrivenEngineering.impl.ModelDrivenPackageImpl#getColumn()
	 * @generated
	 */
	int COLUMN = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN__NAME = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN__TYPE = 1;

	/**
	 * The feature id for the '<em><b>Primary</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN__PRIMARY = 2;

	/**
	 * The feature id for the '<em><b>Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN__UNIQUE = 3;

	/**
	 * The feature id for the '<em><b>Nullable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN__NULLABLE = 4;

	/**
	 * The feature id for the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN__LENGTH = 5;

	/**
	 * The feature id for the '<em><b>Relation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN__RELATION = 6;

	/**
	 * The number of structural features of the '<em>Column</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>Column</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLUMN_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.mde.ModelDrivenEngineering.impl.RelationImpl <em>Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.mde.ModelDrivenEngineering.impl.RelationImpl
	 * @see com.mde.ModelDrivenEngineering.impl.ModelDrivenPackageImpl#getRelation()
	 * @generated
	 */
	int RELATION = 5;

	/**
	 * The feature id for the '<em><b>Target Table</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__TARGET_TABLE = 0;

	/**
	 * The feature id for the '<em><b>Target Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__TARGET_COLUMN = 1;

	/**
	 * The feature id for the '<em><b>On Delete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__ON_DELETE = 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION__TYPE = 3;

	/**
	 * The number of structural features of the '<em>Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.mde.ModelDrivenEngineering.impl.ApiImpl <em>Api</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.mde.ModelDrivenEngineering.impl.ApiImpl
	 * @see com.mde.ModelDrivenEngineering.impl.ModelDrivenPackageImpl#getApi()
	 * @generated
	 */
	int API = 6;

	/**
	 * The feature id for the '<em><b>Base Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int API__BASE_PATH = 0;

	/**
	 * The feature id for the '<em><b>Routes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int API__ROUTES = 1;

	/**
	 * The number of structural features of the '<em>Api</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int API_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Api</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int API_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.mde.ModelDrivenEngineering.impl.RouteImpl <em>Route</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.mde.ModelDrivenEngineering.impl.RouteImpl
	 * @see com.mde.ModelDrivenEngineering.impl.ModelDrivenPackageImpl#getRoute()
	 * @generated
	 */
	int ROUTE = 7;

	/**
	 * The feature id for the '<em><b>Entity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTE__ENTITY = 0;

	/**
	 * The feature id for the '<em><b>Methods</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTE__METHODS = 1;

	/**
	 * The number of structural features of the '<em>Route</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Route</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.mde.ModelDrivenEngineering.Language <em>Language</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.mde.ModelDrivenEngineering.Language
	 * @see com.mde.ModelDrivenEngineering.impl.ModelDrivenPackageImpl#getLanguage()
	 * @generated
	 */
	int LANGUAGE = 8;

	/**
	 * The meta object id for the '{@link com.mde.ModelDrivenEngineering.Framework <em>Framework</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.mde.ModelDrivenEngineering.Framework
	 * @see com.mde.ModelDrivenEngineering.impl.ModelDrivenPackageImpl#getFramework()
	 * @generated
	 */
	int FRAMEWORK = 9;

	/**
	 * The meta object id for the '{@link com.mde.ModelDrivenEngineering.DatabaseType <em>Database Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.mde.ModelDrivenEngineering.DatabaseType
	 * @see com.mde.ModelDrivenEngineering.impl.ModelDrivenPackageImpl#getDatabaseType()
	 * @generated
	 */
	int DATABASE_TYPE = 10;

	/**
	 * The meta object id for the '{@link com.mde.ModelDrivenEngineering.DataType <em>Data Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.mde.ModelDrivenEngineering.DataType
	 * @see com.mde.ModelDrivenEngineering.impl.ModelDrivenPackageImpl#getDataType()
	 * @generated
	 */
	int DATA_TYPE = 11;

	/**
	 * The meta object id for the '{@link com.mde.ModelDrivenEngineering.RelationType <em>Relation Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.mde.ModelDrivenEngineering.RelationType
	 * @see com.mde.ModelDrivenEngineering.impl.ModelDrivenPackageImpl#getRelationType()
	 * @generated
	 */
	int RELATION_TYPE = 12;

	/**
	 * The meta object id for the '{@link com.mde.ModelDrivenEngineering.CascadeType <em>Cascade Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.mde.ModelDrivenEngineering.CascadeType
	 * @see com.mde.ModelDrivenEngineering.impl.ModelDrivenPackageImpl#getCascadeType()
	 * @generated
	 */
	int CASCADE_TYPE = 13;

	/**
	 * The meta object id for the '{@link com.mde.ModelDrivenEngineering.HttpMethod <em>Http Method</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.mde.ModelDrivenEngineering.HttpMethod
	 * @see com.mde.ModelDrivenEngineering.impl.ModelDrivenPackageImpl#getHttpMethod()
	 * @generated
	 */
	int HTTP_METHOD = 14;


	/**
	 * Returns the meta object for class '{@link com.mde.ModelDrivenEngineering.BackendConfig <em>Backend Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Backend Config</em>'.
	 * @see com.mde.ModelDrivenEngineering.BackendConfig
	 * @generated
	 */
	EClass getBackendConfig();

	/**
	 * Returns the meta object for the containment reference '{@link com.mde.ModelDrivenEngineering.BackendConfig#getProject <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Project</em>'.
	 * @see com.mde.ModelDrivenEngineering.BackendConfig#getProject()
	 * @see #getBackendConfig()
	 * @generated
	 */
	EReference getBackendConfig_Project();

	/**
	 * Returns the meta object for the containment reference '{@link com.mde.ModelDrivenEngineering.BackendConfig#getDatabase <em>Database</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Database</em>'.
	 * @see com.mde.ModelDrivenEngineering.BackendConfig#getDatabase()
	 * @see #getBackendConfig()
	 * @generated
	 */
	EReference getBackendConfig_Database();

	/**
	 * Returns the meta object for the containment reference '{@link com.mde.ModelDrivenEngineering.BackendConfig#getApi <em>Api</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Api</em>'.
	 * @see com.mde.ModelDrivenEngineering.BackendConfig#getApi()
	 * @see #getBackendConfig()
	 * @generated
	 */
	EReference getBackendConfig_Api();

	/**
	 * Returns the meta object for class '{@link com.mde.ModelDrivenEngineering.Project <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Project</em>'.
	 * @see com.mde.ModelDrivenEngineering.Project
	 * @generated
	 */
	EClass getProject();

	/**
	 * Returns the meta object for the attribute '{@link com.mde.ModelDrivenEngineering.Project#getGroupId <em>Group Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Group Id</em>'.
	 * @see com.mde.ModelDrivenEngineering.Project#getGroupId()
	 * @see #getProject()
	 * @generated
	 */
	EAttribute getProject_GroupId();

	/**
	 * Returns the meta object for the attribute '{@link com.mde.ModelDrivenEngineering.Project#getJavaVersion <em>Java Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Java Version</em>'.
	 * @see com.mde.ModelDrivenEngineering.Project#getJavaVersion()
	 * @see #getProject()
	 * @generated
	 */
	EAttribute getProject_JavaVersion();

	/**
	 * Returns the meta object for the attribute '{@link com.mde.ModelDrivenEngineering.Project#getSpringBootVersion <em>Spring Boot Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Spring Boot Version</em>'.
	 * @see com.mde.ModelDrivenEngineering.Project#getSpringBootVersion()
	 * @see #getProject()
	 * @generated
	 */
	EAttribute getProject_SpringBootVersion();

	/**
	 * Returns the meta object for the attribute '{@link com.mde.ModelDrivenEngineering.Project#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.mde.ModelDrivenEngineering.Project#getName()
	 * @see #getProject()
	 * @generated
	 */
	EAttribute getProject_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.mde.ModelDrivenEngineering.Project#getLanguage <em>Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Language</em>'.
	 * @see com.mde.ModelDrivenEngineering.Project#getLanguage()
	 * @see #getProject()
	 * @generated
	 */
	EAttribute getProject_Language();

	/**
	 * Returns the meta object for the attribute '{@link com.mde.ModelDrivenEngineering.Project#getFramework <em>Framework</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Framework</em>'.
	 * @see com.mde.ModelDrivenEngineering.Project#getFramework()
	 * @see #getProject()
	 * @generated
	 */
	EAttribute getProject_Framework();

	/**
	 * Returns the meta object for class '{@link com.mde.ModelDrivenEngineering.Database <em>Database</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Database</em>'.
	 * @see com.mde.ModelDrivenEngineering.Database
	 * @generated
	 */
	EClass getDatabase();

	/**
	 * Returns the meta object for the attribute '{@link com.mde.ModelDrivenEngineering.Database#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.mde.ModelDrivenEngineering.Database#getType()
	 * @see #getDatabase()
	 * @generated
	 */
	EAttribute getDatabase_Type();

	/**
	 * Returns the meta object for the attribute '{@link com.mde.ModelDrivenEngineering.Database#getHost <em>Host</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Host</em>'.
	 * @see com.mde.ModelDrivenEngineering.Database#getHost()
	 * @see #getDatabase()
	 * @generated
	 */
	EAttribute getDatabase_Host();

	/**
	 * Returns the meta object for the attribute '{@link com.mde.ModelDrivenEngineering.Database#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Port</em>'.
	 * @see com.mde.ModelDrivenEngineering.Database#getPort()
	 * @see #getDatabase()
	 * @generated
	 */
	EAttribute getDatabase_Port();

	/**
	 * Returns the meta object for the attribute '{@link com.mde.ModelDrivenEngineering.Database#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.mde.ModelDrivenEngineering.Database#getName()
	 * @see #getDatabase()
	 * @generated
	 */
	EAttribute getDatabase_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link com.mde.ModelDrivenEngineering.Database#getTables <em>Tables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Tables</em>'.
	 * @see com.mde.ModelDrivenEngineering.Database#getTables()
	 * @see #getDatabase()
	 * @generated
	 */
	EReference getDatabase_Tables();

	/**
	 * Returns the meta object for class '{@link com.mde.ModelDrivenEngineering.Table <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Table</em>'.
	 * @see com.mde.ModelDrivenEngineering.Table
	 * @generated
	 */
	EClass getTable();

	/**
	 * Returns the meta object for the attribute '{@link com.mde.ModelDrivenEngineering.Table#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.mde.ModelDrivenEngineering.Table#getName()
	 * @see #getTable()
	 * @generated
	 */
	EAttribute getTable_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link com.mde.ModelDrivenEngineering.Table#getColumns <em>Columns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Columns</em>'.
	 * @see com.mde.ModelDrivenEngineering.Table#getColumns()
	 * @see #getTable()
	 * @generated
	 */
	EReference getTable_Columns();

	/**
	 * Returns the meta object for class '{@link com.mde.ModelDrivenEngineering.Column <em>Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Column</em>'.
	 * @see com.mde.ModelDrivenEngineering.Column
	 * @generated
	 */
	EClass getColumn();

	/**
	 * Returns the meta object for the attribute '{@link com.mde.ModelDrivenEngineering.Column#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see com.mde.ModelDrivenEngineering.Column#getName()
	 * @see #getColumn()
	 * @generated
	 */
	EAttribute getColumn_Name();

	/**
	 * Returns the meta object for the attribute '{@link com.mde.ModelDrivenEngineering.Column#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.mde.ModelDrivenEngineering.Column#getType()
	 * @see #getColumn()
	 * @generated
	 */
	EAttribute getColumn_Type();

	/**
	 * Returns the meta object for the attribute '{@link com.mde.ModelDrivenEngineering.Column#isPrimary <em>Primary</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Primary</em>'.
	 * @see com.mde.ModelDrivenEngineering.Column#isPrimary()
	 * @see #getColumn()
	 * @generated
	 */
	EAttribute getColumn_Primary();

	/**
	 * Returns the meta object for the attribute '{@link com.mde.ModelDrivenEngineering.Column#isUnique <em>Unique</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unique</em>'.
	 * @see com.mde.ModelDrivenEngineering.Column#isUnique()
	 * @see #getColumn()
	 * @generated
	 */
	EAttribute getColumn_Unique();

	/**
	 * Returns the meta object for the attribute '{@link com.mde.ModelDrivenEngineering.Column#isNullable <em>Nullable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nullable</em>'.
	 * @see com.mde.ModelDrivenEngineering.Column#isNullable()
	 * @see #getColumn()
	 * @generated
	 */
	EAttribute getColumn_Nullable();

	/**
	 * Returns the meta object for the attribute '{@link com.mde.ModelDrivenEngineering.Column#getLength <em>Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Length</em>'.
	 * @see com.mde.ModelDrivenEngineering.Column#getLength()
	 * @see #getColumn()
	 * @generated
	 */
	EAttribute getColumn_Length();

	/**
	 * Returns the meta object for the containment reference '{@link com.mde.ModelDrivenEngineering.Column#getRelation <em>Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Relation</em>'.
	 * @see com.mde.ModelDrivenEngineering.Column#getRelation()
	 * @see #getColumn()
	 * @generated
	 */
	EReference getColumn_Relation();

	/**
	 * Returns the meta object for class '{@link com.mde.ModelDrivenEngineering.Relation <em>Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relation</em>'.
	 * @see com.mde.ModelDrivenEngineering.Relation
	 * @generated
	 */
	EClass getRelation();

	/**
	 * Returns the meta object for the attribute '{@link com.mde.ModelDrivenEngineering.Relation#getTargetTable <em>Target Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target Table</em>'.
	 * @see com.mde.ModelDrivenEngineering.Relation#getTargetTable()
	 * @see #getRelation()
	 * @generated
	 */
	EAttribute getRelation_TargetTable();

	/**
	 * Returns the meta object for the attribute '{@link com.mde.ModelDrivenEngineering.Relation#getTargetColumn <em>Target Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target Column</em>'.
	 * @see com.mde.ModelDrivenEngineering.Relation#getTargetColumn()
	 * @see #getRelation()
	 * @generated
	 */
	EAttribute getRelation_TargetColumn();

	/**
	 * Returns the meta object for the attribute '{@link com.mde.ModelDrivenEngineering.Relation#getOnDelete <em>On Delete</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>On Delete</em>'.
	 * @see com.mde.ModelDrivenEngineering.Relation#getOnDelete()
	 * @see #getRelation()
	 * @generated
	 */
	EAttribute getRelation_OnDelete();

	/**
	 * Returns the meta object for the attribute '{@link com.mde.ModelDrivenEngineering.Relation#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see com.mde.ModelDrivenEngineering.Relation#getType()
	 * @see #getRelation()
	 * @generated
	 */
	EAttribute getRelation_Type();

	/**
	 * Returns the meta object for class '{@link com.mde.ModelDrivenEngineering.Api <em>Api</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Api</em>'.
	 * @see com.mde.ModelDrivenEngineering.Api
	 * @generated
	 */
	EClass getApi();

	/**
	 * Returns the meta object for the attribute '{@link com.mde.ModelDrivenEngineering.Api#getBasePath <em>Base Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Base Path</em>'.
	 * @see com.mde.ModelDrivenEngineering.Api#getBasePath()
	 * @see #getApi()
	 * @generated
	 */
	EAttribute getApi_BasePath();

	/**
	 * Returns the meta object for the containment reference list '{@link com.mde.ModelDrivenEngineering.Api#getRoutes <em>Routes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Routes</em>'.
	 * @see com.mde.ModelDrivenEngineering.Api#getRoutes()
	 * @see #getApi()
	 * @generated
	 */
	EReference getApi_Routes();

	/**
	 * Returns the meta object for class '{@link com.mde.ModelDrivenEngineering.Route <em>Route</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Route</em>'.
	 * @see com.mde.ModelDrivenEngineering.Route
	 * @generated
	 */
	EClass getRoute();

	/**
	 * Returns the meta object for the attribute '{@link com.mde.ModelDrivenEngineering.Route#getEntity <em>Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Entity</em>'.
	 * @see com.mde.ModelDrivenEngineering.Route#getEntity()
	 * @see #getRoute()
	 * @generated
	 */
	EAttribute getRoute_Entity();

	/**
	 * Returns the meta object for the attribute list '{@link com.mde.ModelDrivenEngineering.Route#getMethods <em>Methods</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Methods</em>'.
	 * @see com.mde.ModelDrivenEngineering.Route#getMethods()
	 * @see #getRoute()
	 * @generated
	 */
	EAttribute getRoute_Methods();

	/**
	 * Returns the meta object for enum '{@link com.mde.ModelDrivenEngineering.Language <em>Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Language</em>'.
	 * @see com.mde.ModelDrivenEngineering.Language
	 * @generated
	 */
	EEnum getLanguage();

	/**
	 * Returns the meta object for enum '{@link com.mde.ModelDrivenEngineering.Framework <em>Framework</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Framework</em>'.
	 * @see com.mde.ModelDrivenEngineering.Framework
	 * @generated
	 */
	EEnum getFramework();

	/**
	 * Returns the meta object for enum '{@link com.mde.ModelDrivenEngineering.DatabaseType <em>Database Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Database Type</em>'.
	 * @see com.mde.ModelDrivenEngineering.DatabaseType
	 * @generated
	 */
	EEnum getDatabaseType();

	/**
	 * Returns the meta object for enum '{@link com.mde.ModelDrivenEngineering.DataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Data Type</em>'.
	 * @see com.mde.ModelDrivenEngineering.DataType
	 * @generated
	 */
	EEnum getDataType();

	/**
	 * Returns the meta object for enum '{@link com.mde.ModelDrivenEngineering.RelationType <em>Relation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Relation Type</em>'.
	 * @see com.mde.ModelDrivenEngineering.RelationType
	 * @generated
	 */
	EEnum getRelationType();

	/**
	 * Returns the meta object for enum '{@link com.mde.ModelDrivenEngineering.CascadeType <em>Cascade Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Cascade Type</em>'.
	 * @see com.mde.ModelDrivenEngineering.CascadeType
	 * @generated
	 */
	EEnum getCascadeType();

	/**
	 * Returns the meta object for enum '{@link com.mde.ModelDrivenEngineering.HttpMethod <em>Http Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Http Method</em>'.
	 * @see com.mde.ModelDrivenEngineering.HttpMethod
	 * @generated
	 */
	EEnum getHttpMethod();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ModelDrivenFactory getModelDrivenFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link com.mde.ModelDrivenEngineering.impl.BackendConfigImpl <em>Backend Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.mde.ModelDrivenEngineering.impl.BackendConfigImpl
		 * @see com.mde.ModelDrivenEngineering.impl.ModelDrivenPackageImpl#getBackendConfig()
		 * @generated
		 */
		EClass BACKEND_CONFIG = eINSTANCE.getBackendConfig();

		/**
		 * The meta object literal for the '<em><b>Project</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BACKEND_CONFIG__PROJECT = eINSTANCE.getBackendConfig_Project();

		/**
		 * The meta object literal for the '<em><b>Database</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BACKEND_CONFIG__DATABASE = eINSTANCE.getBackendConfig_Database();

		/**
		 * The meta object literal for the '<em><b>Api</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BACKEND_CONFIG__API = eINSTANCE.getBackendConfig_Api();

		/**
		 * The meta object literal for the '{@link com.mde.ModelDrivenEngineering.impl.ProjectImpl <em>Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.mde.ModelDrivenEngineering.impl.ProjectImpl
		 * @see com.mde.ModelDrivenEngineering.impl.ModelDrivenPackageImpl#getProject()
		 * @generated
		 */
		EClass PROJECT = eINSTANCE.getProject();

		/**
		 * The meta object literal for the '<em><b>Group Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT__GROUP_ID = eINSTANCE.getProject_GroupId();

		/**
		 * The meta object literal for the '<em><b>Java Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT__JAVA_VERSION = eINSTANCE.getProject_JavaVersion();

		/**
		 * The meta object literal for the '<em><b>Spring Boot Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT__SPRING_BOOT_VERSION = eINSTANCE.getProject_SpringBootVersion();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT__NAME = eINSTANCE.getProject_Name();

		/**
		 * The meta object literal for the '<em><b>Language</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT__LANGUAGE = eINSTANCE.getProject_Language();

		/**
		 * The meta object literal for the '<em><b>Framework</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT__FRAMEWORK = eINSTANCE.getProject_Framework();

		/**
		 * The meta object literal for the '{@link com.mde.ModelDrivenEngineering.impl.DatabaseImpl <em>Database</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.mde.ModelDrivenEngineering.impl.DatabaseImpl
		 * @see com.mde.ModelDrivenEngineering.impl.ModelDrivenPackageImpl#getDatabase()
		 * @generated
		 */
		EClass DATABASE = eINSTANCE.getDatabase();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATABASE__TYPE = eINSTANCE.getDatabase_Type();

		/**
		 * The meta object literal for the '<em><b>Host</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATABASE__HOST = eINSTANCE.getDatabase_Host();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATABASE__PORT = eINSTANCE.getDatabase_Port();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATABASE__NAME = eINSTANCE.getDatabase_Name();

		/**
		 * The meta object literal for the '<em><b>Tables</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATABASE__TABLES = eINSTANCE.getDatabase_Tables();

		/**
		 * The meta object literal for the '{@link com.mde.ModelDrivenEngineering.impl.TableImpl <em>Table</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.mde.ModelDrivenEngineering.impl.TableImpl
		 * @see com.mde.ModelDrivenEngineering.impl.ModelDrivenPackageImpl#getTable()
		 * @generated
		 */
		EClass TABLE = eINSTANCE.getTable();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TABLE__NAME = eINSTANCE.getTable_Name();

		/**
		 * The meta object literal for the '<em><b>Columns</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TABLE__COLUMNS = eINSTANCE.getTable_Columns();

		/**
		 * The meta object literal for the '{@link com.mde.ModelDrivenEngineering.impl.ColumnImpl <em>Column</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.mde.ModelDrivenEngineering.impl.ColumnImpl
		 * @see com.mde.ModelDrivenEngineering.impl.ModelDrivenPackageImpl#getColumn()
		 * @generated
		 */
		EClass COLUMN = eINSTANCE.getColumn();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLUMN__NAME = eINSTANCE.getColumn_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLUMN__TYPE = eINSTANCE.getColumn_Type();

		/**
		 * The meta object literal for the '<em><b>Primary</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLUMN__PRIMARY = eINSTANCE.getColumn_Primary();

		/**
		 * The meta object literal for the '<em><b>Unique</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLUMN__UNIQUE = eINSTANCE.getColumn_Unique();

		/**
		 * The meta object literal for the '<em><b>Nullable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLUMN__NULLABLE = eINSTANCE.getColumn_Nullable();

		/**
		 * The meta object literal for the '<em><b>Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLUMN__LENGTH = eINSTANCE.getColumn_Length();

		/**
		 * The meta object literal for the '<em><b>Relation</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLUMN__RELATION = eINSTANCE.getColumn_Relation();

		/**
		 * The meta object literal for the '{@link com.mde.ModelDrivenEngineering.impl.RelationImpl <em>Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.mde.ModelDrivenEngineering.impl.RelationImpl
		 * @see com.mde.ModelDrivenEngineering.impl.ModelDrivenPackageImpl#getRelation()
		 * @generated
		 */
		EClass RELATION = eINSTANCE.getRelation();

		/**
		 * The meta object literal for the '<em><b>Target Table</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RELATION__TARGET_TABLE = eINSTANCE.getRelation_TargetTable();

		/**
		 * The meta object literal for the '<em><b>Target Column</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RELATION__TARGET_COLUMN = eINSTANCE.getRelation_TargetColumn();

		/**
		 * The meta object literal for the '<em><b>On Delete</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RELATION__ON_DELETE = eINSTANCE.getRelation_OnDelete();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RELATION__TYPE = eINSTANCE.getRelation_Type();

		/**
		 * The meta object literal for the '{@link com.mde.ModelDrivenEngineering.impl.ApiImpl <em>Api</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.mde.ModelDrivenEngineering.impl.ApiImpl
		 * @see com.mde.ModelDrivenEngineering.impl.ModelDrivenPackageImpl#getApi()
		 * @generated
		 */
		EClass API = eINSTANCE.getApi();

		/**
		 * The meta object literal for the '<em><b>Base Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute API__BASE_PATH = eINSTANCE.getApi_BasePath();

		/**
		 * The meta object literal for the '<em><b>Routes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference API__ROUTES = eINSTANCE.getApi_Routes();

		/**
		 * The meta object literal for the '{@link com.mde.ModelDrivenEngineering.impl.RouteImpl <em>Route</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.mde.ModelDrivenEngineering.impl.RouteImpl
		 * @see com.mde.ModelDrivenEngineering.impl.ModelDrivenPackageImpl#getRoute()
		 * @generated
		 */
		EClass ROUTE = eINSTANCE.getRoute();

		/**
		 * The meta object literal for the '<em><b>Entity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROUTE__ENTITY = eINSTANCE.getRoute_Entity();

		/**
		 * The meta object literal for the '<em><b>Methods</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROUTE__METHODS = eINSTANCE.getRoute_Methods();

		/**
		 * The meta object literal for the '{@link com.mde.ModelDrivenEngineering.Language <em>Language</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.mde.ModelDrivenEngineering.Language
		 * @see com.mde.ModelDrivenEngineering.impl.ModelDrivenPackageImpl#getLanguage()
		 * @generated
		 */
		EEnum LANGUAGE = eINSTANCE.getLanguage();

		/**
		 * The meta object literal for the '{@link com.mde.ModelDrivenEngineering.Framework <em>Framework</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.mde.ModelDrivenEngineering.Framework
		 * @see com.mde.ModelDrivenEngineering.impl.ModelDrivenPackageImpl#getFramework()
		 * @generated
		 */
		EEnum FRAMEWORK = eINSTANCE.getFramework();

		/**
		 * The meta object literal for the '{@link com.mde.ModelDrivenEngineering.DatabaseType <em>Database Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.mde.ModelDrivenEngineering.DatabaseType
		 * @see com.mde.ModelDrivenEngineering.impl.ModelDrivenPackageImpl#getDatabaseType()
		 * @generated
		 */
		EEnum DATABASE_TYPE = eINSTANCE.getDatabaseType();

		/**
		 * The meta object literal for the '{@link com.mde.ModelDrivenEngineering.DataType <em>Data Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.mde.ModelDrivenEngineering.DataType
		 * @see com.mde.ModelDrivenEngineering.impl.ModelDrivenPackageImpl#getDataType()
		 * @generated
		 */
		EEnum DATA_TYPE = eINSTANCE.getDataType();

		/**
		 * The meta object literal for the '{@link com.mde.ModelDrivenEngineering.RelationType <em>Relation Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.mde.ModelDrivenEngineering.RelationType
		 * @see com.mde.ModelDrivenEngineering.impl.ModelDrivenPackageImpl#getRelationType()
		 * @generated
		 */
		EEnum RELATION_TYPE = eINSTANCE.getRelationType();

		/**
		 * The meta object literal for the '{@link com.mde.ModelDrivenEngineering.CascadeType <em>Cascade Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.mde.ModelDrivenEngineering.CascadeType
		 * @see com.mde.ModelDrivenEngineering.impl.ModelDrivenPackageImpl#getCascadeType()
		 * @generated
		 */
		EEnum CASCADE_TYPE = eINSTANCE.getCascadeType();

		/**
		 * The meta object literal for the '{@link com.mde.ModelDrivenEngineering.HttpMethod <em>Http Method</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.mde.ModelDrivenEngineering.HttpMethod
		 * @see com.mde.ModelDrivenEngineering.impl.ModelDrivenPackageImpl#getHttpMethod()
		 * @generated
		 */
		EEnum HTTP_METHOD = eINSTANCE.getHttpMethod();

	}

} //ModelDrivenPackage
