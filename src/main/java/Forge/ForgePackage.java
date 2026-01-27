/**
 */
package Forge;

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
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each operation of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * 
 * @see Forge.ForgeFactory
 * @model kind="package"
 * @generated
 */
public interface ForgePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "Forge";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://www.Forge.com/model/v1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "Forge";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	ForgePackage eINSTANCE = Forge.impl.ForgePackageImpl.init();

	/**
	 * The meta object id for the
	 * '{@link Forge.impl.BackendConfigImpl <em>Backend
	 * Config</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see Forge.impl.BackendConfigImpl
	 * @see Forge.impl.ForgePackageImpl#getBackendConfig()
	 * @generated
	 */
	int BACKEND_CONFIG = 0;

	/**
	 * The feature id for the '<em><b>Project</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BACKEND_CONFIG__PROJECT = 0;

	/**
	 * The feature id for the '<em><b>Database</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BACKEND_CONFIG__DATABASE = 1;

	/**
	 * The feature id for the '<em><b>Api</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BACKEND_CONFIG__API = 2;

	/**
	 * The number of structural features of the '<em>Backend Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BACKEND_CONFIG_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Backend Config</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BACKEND_CONFIG_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Forge.impl.ProjectImpl
	 * <em>Project</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see Forge.impl.ProjectImpl
	 * @see Forge.impl.ForgePackageImpl#getProject()
	 * @generated
	 */
	int PROJECT = 1;

	/**
	 * The feature id for the '<em><b>Group Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROJECT__GROUP_ID = 0;

	/**
	 * The feature id for the '<em><b>Java Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROJECT__JAVA_VERSION = 1;

	/**
	 * The feature id for the '<em><b>Spring Boot Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROJECT__SPRING_BOOT_VERSION = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROJECT__NAME = 3;

	/**
	 * The feature id for the '<em><b>Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROJECT__VERSION = 4;

	/**
	 * The feature id for the '<em><b>Language</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROJECT__LANGUAGE = 5;

	/**
	 * The feature id for the '<em><b>Framework</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROJECT__FRAMEWORK = 6;

	/**
	 * The number of structural features of the '<em>Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROJECT_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>Project</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PROJECT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Forge.impl.DatabaseImpl
	 * <em>Database</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see Forge.impl.DatabaseImpl
	 * @see Forge.impl.ForgePackageImpl#getDatabase()
	 * @generated
	 */
	int DATABASE = 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Host</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE__HOST = 1;

	/**
	 * The feature id for the '<em><b>Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE__PORT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE__NAME = 3;

	/**
	 * The feature id for the '<em><b>Tables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE__TABLES = 4;

	/**
	 * The number of structural features of the '<em>Database</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Database</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATABASE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Forge.impl.TableImpl
	 * <em>Table</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see Forge.impl.TableImpl
	 * @see Forge.impl.ForgePackageImpl#getTable()
	 * @generated
	 */
	int TABLE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TABLE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Columns</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TABLE__COLUMNS = 1;

	/**
	 * The feature id for the '<em><b>Relations</b></em>' containment reference
	 * list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TABLE__RELATIONS = 2;

	/**
	 * The number of structural features of the '<em>Table</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TABLE_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Table</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TABLE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Forge.impl.ColumnImpl
	 * <em>Column</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see Forge.impl.ColumnImpl
	 * @see Forge.impl.ForgePackageImpl#getColumn()
	 * @generated
	 */
	int COLUMN = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLUMN__NAME = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLUMN__TYPE = 1;

	/**
	 * The feature id for the '<em><b>Primary</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLUMN__PRIMARY = 2;

	/**
	 * The feature id for the '<em><b>Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLUMN__UNIQUE = 3;

	/**
	 * The feature id for the '<em><b>Nullable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLUMN__NULLABLE = 4;

	/**
	 * The feature id for the '<em><b>Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLUMN__LENGTH = 5;

	/**
	 * The feature id for the '<em><b>Relation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLUMN__RELATION = 6;

	/**
	 * The number of structural features of the '<em>Column</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLUMN_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>Column</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int COLUMN_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Forge.impl.RelationImpl
	 * <em>Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see Forge.impl.RelationImpl
	 * @see Forge.impl.ForgePackageImpl#getRelation()
	 * @generated
	 */
	int RELATION = 5;

	/**
	 * The feature id for the '<em><b>Target Table</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RELATION__TARGET_TABLE = 0;

	/**
	 * The feature id for the '<em><b>Target Column</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RELATION__TARGET_COLUMN = 1;

	/**
	 * The feature id for the '<em><b>On Delete</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RELATION__ON_DELETE = 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RELATION__TYPE = 3;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RELATION__OWNER = 4;

	/**
	 * The feature id for the '<em><b>Fetch</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RELATION__FETCH = 5;

	/**
	 * The feature id for the '<em><b>Cascade</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RELATION__CASCADE = 6;

	/**
	 * The feature id for the '<em><b>Optional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RELATION__OPTIONAL = 7;

	/**
	 * The feature id for the '<em><b>Join Table Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RELATION__JOIN_TABLE_NAME = 8;

	/**
	 * The feature id for the '<em><b>Join Column Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RELATION__JOIN_COLUMN_NAME = 9;

	/**
	 * The feature id for the '<em><b>Inverse Join Column Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RELATION__INVERSE_JOIN_COLUMN_NAME = 10;

	/**
	 * The feature id for the '<em><b>Mapped By</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RELATION__MAPPED_BY = 11;

	/**
	 * The number of structural features of the '<em>Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RELATION_FEATURE_COUNT = 12;

	/**
	 * The number of operations of the '<em>Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int RELATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Forge.impl.ApiImpl
	 * <em>Api</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see Forge.impl.ApiImpl
	 * @see Forge.impl.ForgePackageImpl#getApi()
	 * @generated
	 */
	int API = 6;

	/**
	 * The feature id for the '<em><b>Base Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int API__BASE_PATH = 0;

	/**
	 * The feature id for the '<em><b>Routes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int API__ROUTES = 1;

	/**
	 * The number of structural features of the '<em>Api</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int API_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Api</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int API_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Forge.impl.RouteImpl
	 * <em>Route</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see Forge.impl.RouteImpl
	 * @see Forge.impl.ForgePackageImpl#getRoute()
	 * @generated
	 */
	int ROUTE = 7;

	/**
	 * The feature id for the '<em><b>Entity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ROUTE__ENTITY = 0;

	/**
	 * The feature id for the '<em><b>Methods</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ROUTE__METHODS = 1;

	/**
	 * The number of structural features of the '<em>Route</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ROUTE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Route</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ROUTE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link Forge.Language
	 * <em>Language</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see Forge.Language
	 * @see Forge.impl.ForgePackageImpl#getLanguage()
	 * @generated
	 */
	int LANGUAGE = 8;

	/**
	 * The meta object id for the '{@link Forge.Framework
	 * <em>Framework</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see Forge.Framework
	 * @see Forge.impl.ForgePackageImpl#getFramework()
	 * @generated
	 */
	int FRAMEWORK = 9;

	/**
	 * The meta object id for the '{@link Forge.DatabaseType
	 * <em>Database Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see Forge.DatabaseType
	 * @see Forge.impl.ForgePackageImpl#getDatabaseType()
	 * @generated
	 */
	int DATABASE_TYPE = 10;

	/**
	 * The meta object id for the '{@link Forge.DataType <em>Data
	 * Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see Forge.DataType
	 * @see Forge.impl.ForgePackageImpl#getDataType()
	 * @generated
	 */
	int DATA_TYPE = 11;

	/**
	 * The meta object id for the '{@link Forge.RelationType
	 * <em>Relation Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see Forge.RelationType
	 * @see Forge.impl.ForgePackageImpl#getRelationType()
	 * @generated
	 */
	int RELATION_TYPE = 12;

	/**
	 * The meta object id for the '{@link Forge.CascadeType
	 * <em>Cascade Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see Forge.CascadeType
	 * @see Forge.impl.ForgePackageImpl#getCascadeType()
	 * @generated
	 */
	int CASCADE_TYPE = 13;

	/**
	 * The meta object id for the '{@link Forge.HttpMethod <em>Http
	 * Method</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see Forge.HttpMethod
	 * @see Forge.impl.ForgePackageImpl#getHttpMethod()
	 * @generated
	 */
	int HTTP_METHOD = 14;

	/**
	 * The meta object id for the '{@link Forge.FetchType <em>Fetch
	 * Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see Forge.FetchType
	 * @see Forge.impl.ForgePackageImpl#getFetchType()
	 * @generated
	 */
	int FETCH_TYPE = 15;

	/**
	 * The meta object id for the '{@link Forge.JpaCascadeType
	 * <em>Jpa Cascade Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see Forge.JpaCascadeType
	 * @see Forge.impl.ForgePackageImpl#getJpaCascadeType()
	 * @generated
	 */
	int JPA_CASCADE_TYPE = 16;

	/**
	 * Returns the meta object for class
	 * '{@link Forge.BackendConfig <em>Backend Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Backend Config</em>'.
	 * @see Forge.BackendConfig
	 * @generated
	 */
	EClass getBackendConfig();

	/**
	 * Returns the meta object for the containment reference
	 * '{@link Forge.BackendConfig#getProject <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Project</em>'.
	 * @see Forge.BackendConfig#getProject()
	 * @see #getBackendConfig()
	 * @generated
	 */
	EReference getBackendConfig_Project();

	/**
	 * Returns the meta object for the containment reference
	 * '{@link Forge.BackendConfig#getDatabase <em>Database</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Database</em>'.
	 * @see Forge.BackendConfig#getDatabase()
	 * @see #getBackendConfig()
	 * @generated
	 */
	EReference getBackendConfig_Database();

	/**
	 * Returns the meta object for the containment reference
	 * '{@link Forge.BackendConfig#getApi <em>Api</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Api</em>'.
	 * @see Forge.BackendConfig#getApi()
	 * @see #getBackendConfig()
	 * @generated
	 */
	EReference getBackendConfig_Api();

	/**
	 * Returns the meta object for class '{@link Forge.Project
	 * <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Project</em>'.
	 * @see Forge.Project
	 * @generated
	 */
	EClass getProject();

	/**
	 * Returns the meta object for the attribute
	 * '{@link Forge.Project#getGroupId <em>Group Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Group Id</em>'.
	 * @see Forge.Project#getGroupId()
	 * @see #getProject()
	 * @generated
	 */
	EAttribute getProject_GroupId();

	/**
	 * Returns the meta object for the attribute
	 * '{@link Forge.Project#getJavaVersion <em>Java
	 * Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Java Version</em>'.
	 * @see Forge.Project#getJavaVersion()
	 * @see #getProject()
	 * @generated
	 */
	EAttribute getProject_JavaVersion();

	/**
	 * Returns the meta object for the attribute
	 * '{@link Forge.Project#getSpringBootVersion <em>Spring Boot
	 * Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Spring Boot Version</em>'.
	 * @see Forge.Project#getSpringBootVersion()
	 * @see #getProject()
	 * @generated
	 */
	EAttribute getProject_SpringBootVersion();

	/**
	 * Returns the meta object for the attribute
	 * '{@link Forge.Project#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see Forge.Project#getName()
	 * @see #getProject()
	 * @generated
	 */
	EAttribute getProject_Name();

	/**
	 * Returns the meta object for the attribute
	 * '{@link Forge.Project#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see Forge.Project#getVersion()
	 * @see #getProject()
	 * @generated
	 */
	EAttribute getProject_Version();

	/**
	 * Returns the meta object for the attribute
	 * '{@link Forge.Project#getLanguage <em>Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Language</em>'.
	 * @see Forge.Project#getLanguage()
	 * @see #getProject()
	 * @generated
	 */
	EAttribute getProject_Language();

	/**
	 * Returns the meta object for the attribute
	 * '{@link Forge.Project#getFramework <em>Framework</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Framework</em>'.
	 * @see Forge.Project#getFramework()
	 * @see #getProject()
	 * @generated
	 */
	EAttribute getProject_Framework();

	/**
	 * Returns the meta object for class '{@link Forge.Database
	 * <em>Database</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Database</em>'.
	 * @see Forge.Database
	 * @generated
	 */
	EClass getDatabase();

	/**
	 * Returns the meta object for the attribute
	 * '{@link Forge.Database#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see Forge.Database#getType()
	 * @see #getDatabase()
	 * @generated
	 */
	EAttribute getDatabase_Type();

	/**
	 * Returns the meta object for the attribute
	 * '{@link Forge.Database#getHost <em>Host</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Host</em>'.
	 * @see Forge.Database#getHost()
	 * @see #getDatabase()
	 * @generated
	 */
	EAttribute getDatabase_Host();

	/**
	 * Returns the meta object for the attribute
	 * '{@link Forge.Database#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Port</em>'.
	 * @see Forge.Database#getPort()
	 * @see #getDatabase()
	 * @generated
	 */
	EAttribute getDatabase_Port();

	/**
	 * Returns the meta object for the attribute
	 * '{@link Forge.Database#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see Forge.Database#getName()
	 * @see #getDatabase()
	 * @generated
	 */
	EAttribute getDatabase_Name();

	/**
	 * Returns the meta object for the containment reference list
	 * '{@link Forge.Database#getTables <em>Tables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Tables</em>'.
	 * @see Forge.Database#getTables()
	 * @see #getDatabase()
	 * @generated
	 */
	EReference getDatabase_Tables();

	/**
	 * Returns the meta object for class '{@link Forge.Table
	 * <em>Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Table</em>'.
	 * @see Forge.Table
	 * @generated
	 */
	EClass getTable();

	/**
	 * Returns the meta object for the attribute
	 * '{@link Forge.Table#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see Forge.Table#getName()
	 * @see #getTable()
	 * @generated
	 */
	EAttribute getTable_Name();

	/**
	 * Returns the meta object for the containment reference list
	 * '{@link Forge.Table#getColumns <em>Columns</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list
	 *         '<em>Columns</em>'.
	 * @see Forge.Table#getColumns()
	 * @see #getTable()
	 * @generated
	 */
	EReference getTable_Columns();

	/**
	 * Returns the meta object for the containment reference list
	 * '{@link Forge.Table#getRelations <em>Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list
	 *         '<em>Relations</em>'.
	 * @see Forge.Table#getRelations()
	 * @see #getTable()
	 * @generated
	 */
	EReference getTable_Relations();

	/**
	 * Returns the meta object for class '{@link Forge.Column
	 * <em>Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Column</em>'.
	 * @see Forge.Column
	 * @generated
	 */
	EClass getColumn();

	/**
	 * Returns the meta object for the attribute
	 * '{@link Forge.Column#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see Forge.Column#getName()
	 * @see #getColumn()
	 * @generated
	 */
	EAttribute getColumn_Name();

	/**
	 * Returns the meta object for the attribute
	 * '{@link Forge.Column#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see Forge.Column#getType()
	 * @see #getColumn()
	 * @generated
	 */
	EAttribute getColumn_Type();

	/**
	 * Returns the meta object for the attribute
	 * '{@link Forge.Column#isPrimary <em>Primary</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Primary</em>'.
	 * @see Forge.Column#isPrimary()
	 * @see #getColumn()
	 * @generated
	 */
	EAttribute getColumn_Primary();

	/**
	 * Returns the meta object for the attribute
	 * '{@link Forge.Column#isUnique <em>Unique</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Unique</em>'.
	 * @see Forge.Column#isUnique()
	 * @see #getColumn()
	 * @generated
	 */
	EAttribute getColumn_Unique();

	/**
	 * Returns the meta object for the attribute
	 * '{@link Forge.Column#isNullable <em>Nullable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Nullable</em>'.
	 * @see Forge.Column#isNullable()
	 * @see #getColumn()
	 * @generated
	 */
	EAttribute getColumn_Nullable();

	/**
	 * Returns the meta object for the attribute
	 * '{@link Forge.Column#getLength <em>Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Length</em>'.
	 * @see Forge.Column#getLength()
	 * @see #getColumn()
	 * @generated
	 */
	EAttribute getColumn_Length();

	/**
	 * Returns the meta object for the containment reference
	 * '{@link Forge.Column#getRelation <em>Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Relation</em>'.
	 * @see Forge.Column#getRelation()
	 * @see #getColumn()
	 * @generated
	 */
	EReference getColumn_Relation();

	/**
	 * Returns the meta object for class '{@link Forge.Relation
	 * <em>Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Relation</em>'.
	 * @see Forge.Relation
	 * @generated
	 */
	EClass getRelation();

	/**
	 * Returns the meta object for the attribute
	 * '{@link Forge.Relation#getTargetTable <em>Target
	 * Table</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Target Table</em>'.
	 * @see Forge.Relation#getTargetTable()
	 * @see #getRelation()
	 * @generated
	 */
	EAttribute getRelation_TargetTable();

	/**
	 * Returns the meta object for the attribute
	 * '{@link Forge.Relation#getTargetColumn <em>Target
	 * Column</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Target Column</em>'.
	 * @see Forge.Relation#getTargetColumn()
	 * @see #getRelation()
	 * @generated
	 */
	EAttribute getRelation_TargetColumn();

	/**
	 * Returns the meta object for the attribute
	 * '{@link Forge.Relation#getOnDelete <em>On Delete</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>On Delete</em>'.
	 * @see Forge.Relation#getOnDelete()
	 * @see #getRelation()
	 * @generated
	 */
	EAttribute getRelation_OnDelete();

	/**
	 * Returns the meta object for the attribute
	 * '{@link Forge.Relation#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see Forge.Relation#getType()
	 * @see #getRelation()
	 * @generated
	 */
	EAttribute getRelation_Type();

	/**
	 * Returns the meta object for the attribute
	 * '{@link Forge.Relation#isOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Owner</em>'.
	 * @see Forge.Relation#isOwner()
	 * @see #getRelation()
	 * @generated
	 */
	EAttribute getRelation_Owner();

	/**
	 * Returns the meta object for the attribute
	 * '{@link Forge.Relation#getFetch <em>Fetch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Fetch</em>'.
	 * @see Forge.Relation#getFetch()
	 * @see #getRelation()
	 * @generated
	 */
	EAttribute getRelation_Fetch();

	/**
	 * Returns the meta object for the attribute
	 * '{@link Forge.Relation#getCascade <em>Cascade</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Cascade</em>'.
	 * @see Forge.Relation#getCascade()
	 * @see #getRelation()
	 * @generated
	 */
	EAttribute getRelation_Cascade();

	/**
	 * Returns the meta object for the attribute
	 * '{@link Forge.Relation#isOptional <em>Optional</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Optional</em>'.
	 * @see Forge.Relation#isOptional()
	 * @see #getRelation()
	 * @generated
	 */
	EAttribute getRelation_Optional();

	/**
	 * Returns the meta object for the attribute
	 * '{@link Forge.Relation#getJoinTableName <em>Join Table
	 * Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Join Table Name</em>'.
	 * @see Forge.Relation#getJoinTableName()
	 * @see #getRelation()
	 * @generated
	 */
	EAttribute getRelation_JoinTableName();

	/**
	 * Returns the meta object for the attribute
	 * '{@link Forge.Relation#getJoinColumnName <em>Join Column
	 * Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Join Column Name</em>'.
	 * @see Forge.Relation#getJoinColumnName()
	 * @see #getRelation()
	 * @generated
	 */
	EAttribute getRelation_JoinColumnName();

	/**
	 * Returns the meta object for the attribute
	 * '{@link Forge.Relation#getInverseJoinColumnName <em>Inverse
	 * Join Column Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Inverse Join Column
	 *         Name</em>'.
	 * @see Forge.Relation#getInverseJoinColumnName()
	 * @see #getRelation()
	 * @generated
	 */
	EAttribute getRelation_InverseJoinColumnName();

	/**
	 * Returns the meta object for the attribute
	 * '{@link Forge.Relation#getMappedBy <em>Mapped By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Mapped By</em>'.
	 * @see Forge.Relation#getMappedBy()
	 * @see #getRelation()
	 * @generated
	 */
	EAttribute getRelation_MappedBy();

	/**
	 * Returns the meta object for class '{@link Forge.Api
	 * <em>Api</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Api</em>'.
	 * @see Forge.Api
	 * @generated
	 */
	EClass getApi();

	/**
	 * Returns the meta object for the attribute
	 * '{@link Forge.Api#getBasePath <em>Base Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Base Path</em>'.
	 * @see Forge.Api#getBasePath()
	 * @see #getApi()
	 * @generated
	 */
	EAttribute getApi_BasePath();

	/**
	 * Returns the meta object for the containment reference list
	 * '{@link Forge.Api#getRoutes <em>Routes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference list '<em>Routes</em>'.
	 * @see Forge.Api#getRoutes()
	 * @see #getApi()
	 * @generated
	 */
	EReference getApi_Routes();

	/**
	 * Returns the meta object for class '{@link Forge.Route
	 * <em>Route</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Route</em>'.
	 * @see Forge.Route
	 * @generated
	 */
	EClass getRoute();

	/**
	 * Returns the meta object for the attribute
	 * '{@link Forge.Route#getEntity <em>Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Entity</em>'.
	 * @see Forge.Route#getEntity()
	 * @see #getRoute()
	 * @generated
	 */
	EAttribute getRoute_Entity();

	/**
	 * Returns the meta object for the attribute list
	 * '{@link Forge.Route#getMethods <em>Methods</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute list '<em>Methods</em>'.
	 * @see Forge.Route#getMethods()
	 * @see #getRoute()
	 * @generated
	 */
	EAttribute getRoute_Methods();

	/**
	 * Returns the meta object for enum '{@link Forge.Language
	 * <em>Language</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>Language</em>'.
	 * @see Forge.Language
	 * @generated
	 */
	EEnum getLanguage();

	/**
	 * Returns the meta object for enum '{@link Forge.Framework
	 * <em>Framework</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>Framework</em>'.
	 * @see Forge.Framework
	 * @generated
	 */
	EEnum getFramework();

	/**
	 * Returns the meta object for enum '{@link Forge.DatabaseType
	 * <em>Database Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>Database Type</em>'.
	 * @see Forge.DatabaseType
	 * @generated
	 */
	EEnum getDatabaseType();

	/**
	 * Returns the meta object for enum '{@link Forge.DataType
	 * <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>Data Type</em>'.
	 * @see Forge.DataType
	 * @generated
	 */
	EEnum getDataType();

	/**
	 * Returns the meta object for enum '{@link Forge.RelationType
	 * <em>Relation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>Relation Type</em>'.
	 * @see Forge.RelationType
	 * @generated
	 */
	EEnum getRelationType();

	/**
	 * Returns the meta object for enum '{@link Forge.CascadeType
	 * <em>Cascade Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>Cascade Type</em>'.
	 * @see Forge.CascadeType
	 * @generated
	 */
	EEnum getCascadeType();

	/**
	 * Returns the meta object for enum '{@link Forge.HttpMethod
	 * <em>Http Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>Http Method</em>'.
	 * @see Forge.HttpMethod
	 * @generated
	 */
	EEnum getHttpMethod();

	/**
	 * Returns the meta object for enum '{@link Forge.FetchType
	 * <em>Fetch Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>Fetch Type</em>'.
	 * @see Forge.FetchType
	 * @generated
	 */
	EEnum getFetchType();

	/**
	 * Returns the meta object for enum
	 * '{@link Forge.JpaCascadeType <em>Jpa Cascade Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>Jpa Cascade Type</em>'.
	 * @see Forge.JpaCascadeType
	 * @generated
	 */
	EEnum getJpaCascadeType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ForgeFactory getForgeFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each operation of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the
		 * '{@link Forge.impl.BackendConfigImpl <em>Backend
		 * Config</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see Forge.impl.BackendConfigImpl
		 * @see Forge.impl.ForgePackageImpl#getBackendConfig()
		 * @generated
		 */
		EClass BACKEND_CONFIG = eINSTANCE.getBackendConfig();

		/**
		 * The meta object literal for the '<em><b>Project</b></em>' containment
		 * reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference BACKEND_CONFIG__PROJECT = eINSTANCE.getBackendConfig_Project();

		/**
		 * The meta object literal for the '<em><b>Database</b></em>' containment
		 * reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference BACKEND_CONFIG__DATABASE = eINSTANCE.getBackendConfig_Database();

		/**
		 * The meta object literal for the '<em><b>Api</b></em>' containment reference
		 * feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference BACKEND_CONFIG__API = eINSTANCE.getBackendConfig_Api();

		/**
		 * The meta object literal for the
		 * '{@link Forge.impl.ProjectImpl <em>Project</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see Forge.impl.ProjectImpl
		 * @see Forge.impl.ForgePackageImpl#getProject()
		 * @generated
		 */
		EClass PROJECT = eINSTANCE.getProject();

		/**
		 * The meta object literal for the '<em><b>Group Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute PROJECT__GROUP_ID = eINSTANCE.getProject_GroupId();

		/**
		 * The meta object literal for the '<em><b>Java Version</b></em>' attribute
		 * feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute PROJECT__JAVA_VERSION = eINSTANCE.getProject_JavaVersion();

		/**
		 * The meta object literal for the '<em><b>Spring Boot Version</b></em>'
		 * attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute PROJECT__SPRING_BOOT_VERSION = eINSTANCE.getProject_SpringBootVersion();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute PROJECT__NAME = eINSTANCE.getProject_Name();

		/**
		 * The meta object literal for the '<em><b>Language</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute PROJECT__LANGUAGE = eINSTANCE.getProject_Language();

		/**
		 * The meta object literal for the '<em><b>Framework</b></em>' attribute
		 * feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute PROJECT__FRAMEWORK = eINSTANCE.getProject_Framework();

		/**
		 * The meta object literal for the
		 * '{@link Forge.impl.DatabaseImpl <em>Database</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see Forge.impl.DatabaseImpl
		 * @see Forge.impl.ForgePackageImpl#getDatabase()
		 * @generated
		 */
		EClass DATABASE = eINSTANCE.getDatabase();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DATABASE__TYPE = eINSTANCE.getDatabase_Type();

		/**
		 * The meta object literal for the '<em><b>Host</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DATABASE__HOST = eINSTANCE.getDatabase_Host();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DATABASE__PORT = eINSTANCE.getDatabase_Port();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DATABASE__NAME = eINSTANCE.getDatabase_Name();

		/**
		 * The meta object literal for the '<em><b>Tables</b></em>' containment
		 * reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference DATABASE__TABLES = eINSTANCE.getDatabase_Tables();

		/**
		 * The meta object literal for the '{@link Forge.impl.TableImpl
		 * <em>Table</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see Forge.impl.TableImpl
		 * @see Forge.impl.ForgePackageImpl#getTable()
		 * @generated
		 */
		EClass TABLE = eINSTANCE.getTable();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute TABLE__NAME = eINSTANCE.getTable_Name();

		/**
		 * The meta object literal for the '<em><b>Columns</b></em>' containment
		 * reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference TABLE__COLUMNS = eINSTANCE.getTable_Columns();

		/**
		 * The meta object literal for the '<em><b>Relations</b></em>' containment
		 * reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference TABLE__RELATIONS = eINSTANCE.getTable_Relations();

		/**
		 * The meta object literal for the
		 * '{@link Forge.impl.ColumnImpl <em>Column</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see Forge.impl.ColumnImpl
		 * @see Forge.impl.ForgePackageImpl#getColumn()
		 * @generated
		 */
		EClass COLUMN = eINSTANCE.getColumn();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute COLUMN__NAME = eINSTANCE.getColumn_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute COLUMN__TYPE = eINSTANCE.getColumn_Type();

		/**
		 * The meta object literal for the '<em><b>Primary</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute COLUMN__PRIMARY = eINSTANCE.getColumn_Primary();

		/**
		 * The meta object literal for the '<em><b>Unique</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute COLUMN__UNIQUE = eINSTANCE.getColumn_Unique();

		/**
		 * The meta object literal for the '<em><b>Nullable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute COLUMN__NULLABLE = eINSTANCE.getColumn_Nullable();

		/**
		 * The meta object literal for the '<em><b>Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute COLUMN__LENGTH = eINSTANCE.getColumn_Length();

		/**
		 * The meta object literal for the '<em><b>Relation</b></em>' containment
		 * reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference COLUMN__RELATION = eINSTANCE.getColumn_Relation();

		/**
		 * The meta object literal for the
		 * '{@link Forge.impl.RelationImpl <em>Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see Forge.impl.RelationImpl
		 * @see Forge.impl.ForgePackageImpl#getRelation()
		 * @generated
		 */
		EClass RELATION = eINSTANCE.getRelation();

		/**
		 * The meta object literal for the '<em><b>Target Table</b></em>' attribute
		 * feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute RELATION__TARGET_TABLE = eINSTANCE.getRelation_TargetTable();

		/**
		 * The meta object literal for the '<em><b>Target Column</b></em>' attribute
		 * feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute RELATION__TARGET_COLUMN = eINSTANCE.getRelation_TargetColumn();

		/**
		 * The meta object literal for the '<em><b>On Delete</b></em>' attribute
		 * feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute RELATION__ON_DELETE = eINSTANCE.getRelation_OnDelete();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute RELATION__TYPE = eINSTANCE.getRelation_Type();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute RELATION__OWNER = eINSTANCE.getRelation_Owner();

		/**
		 * The meta object literal for the '<em><b>Fetch</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute RELATION__FETCH = eINSTANCE.getRelation_Fetch();

		/**
		 * The meta object literal for the '<em><b>Cascade</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute RELATION__CASCADE = eINSTANCE.getRelation_Cascade();

		/**
		 * The meta object literal for the '<em><b>Optional</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute RELATION__OPTIONAL = eINSTANCE.getRelation_Optional();

		/**
		 * The meta object literal for the '{@link Forge.impl.ApiImpl
		 * <em>Api</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see Forge.impl.ApiImpl
		 * @see Forge.impl.ForgePackageImpl#getApi()
		 * @generated
		 */
		EClass API = eINSTANCE.getApi();

		/**
		 * The meta object literal for the '<em><b>Base Path</b></em>' attribute
		 * feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute API__BASE_PATH = eINSTANCE.getApi_BasePath();

		/**
		 * The meta object literal for the '<em><b>Routes</b></em>' containment
		 * reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference API__ROUTES = eINSTANCE.getApi_Routes();

		/**
		 * The meta object literal for the '{@link Forge.impl.RouteImpl
		 * <em>Route</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see Forge.impl.RouteImpl
		 * @see Forge.impl.ForgePackageImpl#getRoute()
		 * @generated
		 */
		EClass ROUTE = eINSTANCE.getRoute();

		/**
		 * The meta object literal for the '<em><b>Entity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ROUTE__ENTITY = eINSTANCE.getRoute_Entity();

		/**
		 * The meta object literal for the '<em><b>Methods</b></em>' attribute list
		 * feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ROUTE__METHODS = eINSTANCE.getRoute_Methods();

		/**
		 * The meta object literal for the '{@link Forge.Language
		 * <em>Language</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see Forge.Language
		 * @see Forge.impl.ForgePackageImpl#getLanguage()
		 * @generated
		 */
		EEnum LANGUAGE = eINSTANCE.getLanguage();

		/**
		 * The meta object literal for the '{@link Forge.Framework
		 * <em>Framework</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see Forge.Framework
		 * @see Forge.impl.ForgePackageImpl#getFramework()
		 * @generated
		 */
		EEnum FRAMEWORK = eINSTANCE.getFramework();

		/**
		 * The meta object literal for the '{@link Forge.DatabaseType
		 * <em>Database Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see Forge.DatabaseType
		 * @see Forge.impl.ForgePackageImpl#getDatabaseType()
		 * @generated
		 */
		EEnum DATABASE_TYPE = eINSTANCE.getDatabaseType();

		/**
		 * The meta object literal for the '{@link Forge.DataType
		 * <em>Data Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see Forge.DataType
		 * @see Forge.impl.ForgePackageImpl#getDataType()
		 * @generated
		 */
		EEnum DATA_TYPE = eINSTANCE.getDataType();

		/**
		 * The meta object literal for the '{@link Forge.RelationType
		 * <em>Relation Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see Forge.RelationType
		 * @see Forge.impl.ForgePackageImpl#getRelationType()
		 * @generated
		 */
		EEnum RELATION_TYPE = eINSTANCE.getRelationType();

		/**
		 * The meta object literal for the '{@link Forge.CascadeType
		 * <em>Cascade Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see Forge.CascadeType
		 * @see Forge.impl.ForgePackageImpl#getCascadeType()
		 * @generated
		 */
		EEnum CASCADE_TYPE = eINSTANCE.getCascadeType();

		/**
		 * The meta object literal for the '{@link Forge.HttpMethod
		 * <em>Http Method</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see Forge.HttpMethod
		 * @see Forge.impl.ForgePackageImpl#getHttpMethod()
		 * @generated
		 */
		EEnum HTTP_METHOD = eINSTANCE.getHttpMethod();

		/**
		 * The meta object literal for the '{@link Forge.FetchType
		 * <em>Fetch Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see Forge.FetchType
		 * @see Forge.impl.ForgePackageImpl#getFetchType()
		 * @generated
		 */
		EEnum FETCH_TYPE = eINSTANCE.getFetchType();

		/**
		 * The meta object literal for the '{@link Forge.JpaCascadeType
		 * <em>Jpa Cascade Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see Forge.JpaCascadeType
		 * @see Forge.impl.ForgePackageImpl#getJpaCascadeType()
		 * @generated
		 */
		EEnum JPA_CASCADE_TYPE = eINSTANCE.getJpaCascadeType();

	}

} // ForgePackage
