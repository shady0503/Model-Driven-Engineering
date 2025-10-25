/**
 */
package com.mde.generator.Context;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see com.mde.generator.Context.ContextFactory
 * @model kind="package"
 * @generated
 */
public interface ContextPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "Context";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.mde.com/context";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "context";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ContextPackage eINSTANCE = com.mde.generator.Context.impl.ContextPackageImpl.init();

	/**
	 * The meta object id for the '{@link com.mde.generator.Context.impl.ProjectContextImpl <em>Project Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.mde.generator.Context.impl.ProjectContextImpl
	 * @see com.mde.generator.Context.impl.ContextPackageImpl#getProjectContext()
	 * @generated
	 */
	int PROJECT_CONTEXT = 0;

	/**
	 * The feature id for the '<em><b>Group Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_CONTEXT__GROUP_ID = 0;

	/**
	 * The feature id for the '<em><b>Artifact Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_CONTEXT__ARTIFACT_ID = 1;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_CONTEXT__VERSION = 2;

	/**
	 * The feature id for the '<em><b>Package Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_CONTEXT__PACKAGE_NAME = 3;

	/**
	 * The feature id for the '<em><b>Java Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_CONTEXT__JAVA_VERSION = 4;

	/**
	 * The feature id for the '<em><b>Spring Boot Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_CONTEXT__SPRING_BOOT_VERSION = 5;

	/**
	 * The feature id for the '<em><b>Database Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_CONTEXT__DATABASE_TYPE = 6;

	/**
	 * The feature id for the '<em><b>Database Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_CONTEXT__DATABASE_NAME = 7;

	/**
	 * The feature id for the '<em><b>Entities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_CONTEXT__ENTITIES = 8;

	/**
	 * The feature id for the '<em><b>Dependencies</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_CONTEXT__DEPENDENCIES = 9;

	/**
	 * The number of structural features of the '<em>Project Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_CONTEXT_FEATURE_COUNT = 10;

	/**
	 * The number of operations of the '<em>Project Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROJECT_CONTEXT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.mde.generator.Context.impl.EntityContextImpl <em>Entity Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.mde.generator.Context.impl.EntityContextImpl
	 * @see com.mde.generator.Context.impl.ContextPackageImpl#getEntityContext()
	 * @generated
	 */
	int ENTITY_CONTEXT = 1;

	/**
	 * The feature id for the '<em><b>Table Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_CONTEXT__TABLE_NAME = 0;

	/**
	 * The feature id for the '<em><b>Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_CONTEXT__CLASS_NAME = 1;

	/**
	 * The feature id for the '<em><b>Package Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_CONTEXT__PACKAGE_NAME = 2;

	/**
	 * The feature id for the '<em><b>Has Relationships</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_CONTEXT__HAS_RELATIONSHIPS = 3;

	/**
	 * The feature id for the '<em><b>Fields</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_CONTEXT__FIELDS = 4;

	/**
	 * The feature id for the '<em><b>Relations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_CONTEXT__RELATIONS = 5;

	/**
	 * The feature id for the '<em><b>Primary Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_CONTEXT__PRIMARY_KEY = 6;

	/**
	 * The number of structural features of the '<em>Entity Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_CONTEXT_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>Entity Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTITY_CONTEXT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.mde.generator.Context.impl.FieldContextImpl <em>Field Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.mde.generator.Context.impl.FieldContextImpl
	 * @see com.mde.generator.Context.impl.ContextPackageImpl#getFieldContext()
	 * @generated
	 */
	int FIELD_CONTEXT = 2;

	/**
	 * The feature id for the '<em><b>Column Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_CONTEXT__COLUMN_NAME = 0;

	/**
	 * The feature id for the '<em><b>Field Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_CONTEXT__FIELD_NAME = 1;

	/**
	 * The feature id for the '<em><b>Java Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_CONTEXT__JAVA_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Is Primary Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_CONTEXT__IS_PRIMARY_KEY = 3;

	/**
	 * The feature id for the '<em><b>Is Nullable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_CONTEXT__IS_NULLABLE = 4;

	/**
	 * The feature id for the '<em><b>Is Unique</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_CONTEXT__IS_UNIQUE = 5;

	/**
	 * The number of structural features of the '<em>Field Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_CONTEXT_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Field Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FIELD_CONTEXT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.mde.generator.Context.impl.RelationContextImpl <em>Relation Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.mde.generator.Context.impl.RelationContextImpl
	 * @see com.mde.generator.Context.impl.ContextPackageImpl#getRelationContext()
	 * @generated
	 */
	int RELATION_CONTEXT = 3;

	/**
	 * The feature id for the '<em><b>Field Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_CONTEXT__FIELD_NAME = 0;

	/**
	 * The feature id for the '<em><b>Target Entity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_CONTEXT__TARGET_ENTITY = 1;

	/**
	 * The feature id for the '<em><b>Relation Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_CONTEXT__RELATION_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Is Owner</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_CONTEXT__IS_OWNER = 3;

	/**
	 * The feature id for the '<em><b>Join Column Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_CONTEXT__JOIN_COLUMN_NAME = 4;

	/**
	 * The feature id for the '<em><b>Mapped By</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_CONTEXT__MAPPED_BY = 5;

	/**
	 * The feature id for the '<em><b>Cascade Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_CONTEXT__CASCADE_TYPE = 6;

	/**
	 * The feature id for the '<em><b>Fetch Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_CONTEXT__FETCH_TYPE = 7;

	/**
	 * The number of structural features of the '<em>Relation Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_CONTEXT_FEATURE_COUNT = 8;

	/**
	 * The number of operations of the '<em>Relation Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_CONTEXT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link com.mde.generator.Context.impl.DependencyContextImpl <em>Dependency Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see com.mde.generator.Context.impl.DependencyContextImpl
	 * @see com.mde.generator.Context.impl.ContextPackageImpl#getDependencyContext()
	 * @generated
	 */
	int DEPENDENCY_CONTEXT = 4;

	/**
	 * The feature id for the '<em><b>Group Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_CONTEXT__GROUP_ID = 0;

	/**
	 * The feature id for the '<em><b>Artifact Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_CONTEXT__ARTIFACT_ID = 1;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_CONTEXT__VERSION = 2;

	/**
	 * The feature id for the '<em><b>Scope</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_CONTEXT__SCOPE = 3;

	/**
	 * The number of structural features of the '<em>Dependency Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_CONTEXT_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Dependency Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPENDENCY_CONTEXT_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link com.mde.generator.Context.ProjectContext <em>Project Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Project Context</em>'.
	 * @see com.mde.generator.Context.ProjectContext
	 * @generated
	 */
	EClass getProjectContext();

	/**
	 * Returns the meta object for the attribute '{@link com.mde.generator.Context.ProjectContext#getGroupId <em>Group Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Group Id</em>'.
	 * @see com.mde.generator.Context.ProjectContext#getGroupId()
	 * @see #getProjectContext()
	 * @generated
	 */
	EAttribute getProjectContext_GroupId();

	/**
	 * Returns the meta object for the attribute '{@link com.mde.generator.Context.ProjectContext#getArtifactId <em>Artifact Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Artifact Id</em>'.
	 * @see com.mde.generator.Context.ProjectContext#getArtifactId()
	 * @see #getProjectContext()
	 * @generated
	 */
	EAttribute getProjectContext_ArtifactId();

	/**
	 * Returns the meta object for the attribute '{@link com.mde.generator.Context.ProjectContext#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see com.mde.generator.Context.ProjectContext#getVersion()
	 * @see #getProjectContext()
	 * @generated
	 */
	EAttribute getProjectContext_Version();

	/**
	 * Returns the meta object for the attribute '{@link com.mde.generator.Context.ProjectContext#getPackageName <em>Package Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Package Name</em>'.
	 * @see com.mde.generator.Context.ProjectContext#getPackageName()
	 * @see #getProjectContext()
	 * @generated
	 */
	EAttribute getProjectContext_PackageName();

	/**
	 * Returns the meta object for the attribute '{@link com.mde.generator.Context.ProjectContext#getJavaVersion <em>Java Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Java Version</em>'.
	 * @see com.mde.generator.Context.ProjectContext#getJavaVersion()
	 * @see #getProjectContext()
	 * @generated
	 */
	EAttribute getProjectContext_JavaVersion();

	/**
	 * Returns the meta object for the attribute '{@link com.mde.generator.Context.ProjectContext#getSpringBootVersion <em>Spring Boot Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Spring Boot Version</em>'.
	 * @see com.mde.generator.Context.ProjectContext#getSpringBootVersion()
	 * @see #getProjectContext()
	 * @generated
	 */
	EAttribute getProjectContext_SpringBootVersion();

	/**
	 * Returns the meta object for the attribute '{@link com.mde.generator.Context.ProjectContext#getDatabaseType <em>Database Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Database Type</em>'.
	 * @see com.mde.generator.Context.ProjectContext#getDatabaseType()
	 * @see #getProjectContext()
	 * @generated
	 */
	EAttribute getProjectContext_DatabaseType();

	/**
	 * Returns the meta object for the attribute '{@link com.mde.generator.Context.ProjectContext#getDatabaseName <em>Database Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Database Name</em>'.
	 * @see com.mde.generator.Context.ProjectContext#getDatabaseName()
	 * @see #getProjectContext()
	 * @generated
	 */
	EAttribute getProjectContext_DatabaseName();

	/**
	 * Returns the meta object for the containment reference list '{@link com.mde.generator.Context.ProjectContext#getEntities <em>Entities</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Entities</em>'.
	 * @see com.mde.generator.Context.ProjectContext#getEntities()
	 * @see #getProjectContext()
	 * @generated
	 */
	EReference getProjectContext_Entities();

	/**
	 * Returns the meta object for the containment reference list '{@link com.mde.generator.Context.ProjectContext#getDependencies <em>Dependencies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Dependencies</em>'.
	 * @see com.mde.generator.Context.ProjectContext#getDependencies()
	 * @see #getProjectContext()
	 * @generated
	 */
	EReference getProjectContext_Dependencies();

	/**
	 * Returns the meta object for class '{@link com.mde.generator.Context.EntityContext <em>Entity Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entity Context</em>'.
	 * @see com.mde.generator.Context.EntityContext
	 * @generated
	 */
	EClass getEntityContext();

	/**
	 * Returns the meta object for the attribute '{@link com.mde.generator.Context.EntityContext#getTableName <em>Table Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Table Name</em>'.
	 * @see com.mde.generator.Context.EntityContext#getTableName()
	 * @see #getEntityContext()
	 * @generated
	 */
	EAttribute getEntityContext_TableName();

	/**
	 * Returns the meta object for the attribute '{@link com.mde.generator.Context.EntityContext#getClassName <em>Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class Name</em>'.
	 * @see com.mde.generator.Context.EntityContext#getClassName()
	 * @see #getEntityContext()
	 * @generated
	 */
	EAttribute getEntityContext_ClassName();

	/**
	 * Returns the meta object for the attribute '{@link com.mde.generator.Context.EntityContext#getPackageName <em>Package Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Package Name</em>'.
	 * @see com.mde.generator.Context.EntityContext#getPackageName()
	 * @see #getEntityContext()
	 * @generated
	 */
	EAttribute getEntityContext_PackageName();

	/**
	 * Returns the meta object for the attribute '{@link com.mde.generator.Context.EntityContext#isHasRelationships <em>Has Relationships</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Has Relationships</em>'.
	 * @see com.mde.generator.Context.EntityContext#isHasRelationships()
	 * @see #getEntityContext()
	 * @generated
	 */
	EAttribute getEntityContext_HasRelationships();

	/**
	 * Returns the meta object for the containment reference list '{@link com.mde.generator.Context.EntityContext#getFields <em>Fields</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Fields</em>'.
	 * @see com.mde.generator.Context.EntityContext#getFields()
	 * @see #getEntityContext()
	 * @generated
	 */
	EReference getEntityContext_Fields();

	/**
	 * Returns the meta object for the containment reference list '{@link com.mde.generator.Context.EntityContext#getRelations <em>Relations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Relations</em>'.
	 * @see com.mde.generator.Context.EntityContext#getRelations()
	 * @see #getEntityContext()
	 * @generated
	 */
	EReference getEntityContext_Relations();

	/**
	 * Returns the meta object for the reference '{@link com.mde.generator.Context.EntityContext#getPrimaryKey <em>Primary Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Primary Key</em>'.
	 * @see com.mde.generator.Context.EntityContext#getPrimaryKey()
	 * @see #getEntityContext()
	 * @generated
	 */
	EReference getEntityContext_PrimaryKey();

	/**
	 * Returns the meta object for class '{@link com.mde.generator.Context.FieldContext <em>Field Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Field Context</em>'.
	 * @see com.mde.generator.Context.FieldContext
	 * @generated
	 */
	EClass getFieldContext();

	/**
	 * Returns the meta object for the attribute '{@link com.mde.generator.Context.FieldContext#getColumnName <em>Column Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Column Name</em>'.
	 * @see com.mde.generator.Context.FieldContext#getColumnName()
	 * @see #getFieldContext()
	 * @generated
	 */
	EAttribute getFieldContext_ColumnName();

	/**
	 * Returns the meta object for the attribute '{@link com.mde.generator.Context.FieldContext#getFieldName <em>Field Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Field Name</em>'.
	 * @see com.mde.generator.Context.FieldContext#getFieldName()
	 * @see #getFieldContext()
	 * @generated
	 */
	EAttribute getFieldContext_FieldName();

	/**
	 * Returns the meta object for the attribute '{@link com.mde.generator.Context.FieldContext#getJavaType <em>Java Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Java Type</em>'.
	 * @see com.mde.generator.Context.FieldContext#getJavaType()
	 * @see #getFieldContext()
	 * @generated
	 */
	EAttribute getFieldContext_JavaType();

	/**
	 * Returns the meta object for the attribute '{@link com.mde.generator.Context.FieldContext#isIsPrimaryKey <em>Is Primary Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Primary Key</em>'.
	 * @see com.mde.generator.Context.FieldContext#isIsPrimaryKey()
	 * @see #getFieldContext()
	 * @generated
	 */
	EAttribute getFieldContext_IsPrimaryKey();

	/**
	 * Returns the meta object for the attribute '{@link com.mde.generator.Context.FieldContext#isIsNullable <em>Is Nullable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Nullable</em>'.
	 * @see com.mde.generator.Context.FieldContext#isIsNullable()
	 * @see #getFieldContext()
	 * @generated
	 */
	EAttribute getFieldContext_IsNullable();

	/**
	 * Returns the meta object for the attribute '{@link com.mde.generator.Context.FieldContext#isIsUnique <em>Is Unique</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Unique</em>'.
	 * @see com.mde.generator.Context.FieldContext#isIsUnique()
	 * @see #getFieldContext()
	 * @generated
	 */
	EAttribute getFieldContext_IsUnique();

	/**
	 * Returns the meta object for class '{@link com.mde.generator.Context.RelationContext <em>Relation Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relation Context</em>'.
	 * @see com.mde.generator.Context.RelationContext
	 * @generated
	 */
	EClass getRelationContext();

	/**
	 * Returns the meta object for the attribute '{@link com.mde.generator.Context.RelationContext#getFieldName <em>Field Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Field Name</em>'.
	 * @see com.mde.generator.Context.RelationContext#getFieldName()
	 * @see #getRelationContext()
	 * @generated
	 */
	EAttribute getRelationContext_FieldName();

	/**
	 * Returns the meta object for the attribute '{@link com.mde.generator.Context.RelationContext#getTargetEntity <em>Target Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Target Entity</em>'.
	 * @see com.mde.generator.Context.RelationContext#getTargetEntity()
	 * @see #getRelationContext()
	 * @generated
	 */
	EAttribute getRelationContext_TargetEntity();

	/**
	 * Returns the meta object for the attribute '{@link com.mde.generator.Context.RelationContext#getRelationType <em>Relation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Relation Type</em>'.
	 * @see com.mde.generator.Context.RelationContext#getRelationType()
	 * @see #getRelationContext()
	 * @generated
	 */
	EAttribute getRelationContext_RelationType();

	/**
	 * Returns the meta object for the attribute '{@link com.mde.generator.Context.RelationContext#isIsOwner <em>Is Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Owner</em>'.
	 * @see com.mde.generator.Context.RelationContext#isIsOwner()
	 * @see #getRelationContext()
	 * @generated
	 */
	EAttribute getRelationContext_IsOwner();

	/**
	 * Returns the meta object for the attribute '{@link com.mde.generator.Context.RelationContext#getJoinColumnName <em>Join Column Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Join Column Name</em>'.
	 * @see com.mde.generator.Context.RelationContext#getJoinColumnName()
	 * @see #getRelationContext()
	 * @generated
	 */
	EAttribute getRelationContext_JoinColumnName();

	/**
	 * Returns the meta object for the attribute '{@link com.mde.generator.Context.RelationContext#getMappedBy <em>Mapped By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mapped By</em>'.
	 * @see com.mde.generator.Context.RelationContext#getMappedBy()
	 * @see #getRelationContext()
	 * @generated
	 */
	EAttribute getRelationContext_MappedBy();

	/**
	 * Returns the meta object for the attribute '{@link com.mde.generator.Context.RelationContext#getCascadeType <em>Cascade Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cascade Type</em>'.
	 * @see com.mde.generator.Context.RelationContext#getCascadeType()
	 * @see #getRelationContext()
	 * @generated
	 */
	EAttribute getRelationContext_CascadeType();

	/**
	 * Returns the meta object for the attribute '{@link com.mde.generator.Context.RelationContext#getFetchType <em>Fetch Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fetch Type</em>'.
	 * @see com.mde.generator.Context.RelationContext#getFetchType()
	 * @see #getRelationContext()
	 * @generated
	 */
	EAttribute getRelationContext_FetchType();

	/**
	 * Returns the meta object for class '{@link com.mde.generator.Context.DependencyContext <em>Dependency Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dependency Context</em>'.
	 * @see com.mde.generator.Context.DependencyContext
	 * @generated
	 */
	EClass getDependencyContext();

	/**
	 * Returns the meta object for the attribute '{@link com.mde.generator.Context.DependencyContext#getGroupId <em>Group Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Group Id</em>'.
	 * @see com.mde.generator.Context.DependencyContext#getGroupId()
	 * @see #getDependencyContext()
	 * @generated
	 */
	EAttribute getDependencyContext_GroupId();

	/**
	 * Returns the meta object for the attribute '{@link com.mde.generator.Context.DependencyContext#getArtifactId <em>Artifact Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Artifact Id</em>'.
	 * @see com.mde.generator.Context.DependencyContext#getArtifactId()
	 * @see #getDependencyContext()
	 * @generated
	 */
	EAttribute getDependencyContext_ArtifactId();

	/**
	 * Returns the meta object for the attribute '{@link com.mde.generator.Context.DependencyContext#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see com.mde.generator.Context.DependencyContext#getVersion()
	 * @see #getDependencyContext()
	 * @generated
	 */
	EAttribute getDependencyContext_Version();

	/**
	 * Returns the meta object for the attribute '{@link com.mde.generator.Context.DependencyContext#getScope <em>Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Scope</em>'.
	 * @see com.mde.generator.Context.DependencyContext#getScope()
	 * @see #getDependencyContext()
	 * @generated
	 */
	EAttribute getDependencyContext_Scope();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ContextFactory getContextFactory();

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
		 * The meta object literal for the '{@link com.mde.generator.Context.impl.ProjectContextImpl <em>Project Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.mde.generator.Context.impl.ProjectContextImpl
		 * @see com.mde.generator.Context.impl.ContextPackageImpl#getProjectContext()
		 * @generated
		 */
		EClass PROJECT_CONTEXT = eINSTANCE.getProjectContext();

		/**
		 * The meta object literal for the '<em><b>Group Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT_CONTEXT__GROUP_ID = eINSTANCE.getProjectContext_GroupId();

		/**
		 * The meta object literal for the '<em><b>Artifact Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT_CONTEXT__ARTIFACT_ID = eINSTANCE.getProjectContext_ArtifactId();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT_CONTEXT__VERSION = eINSTANCE.getProjectContext_Version();

		/**
		 * The meta object literal for the '<em><b>Package Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT_CONTEXT__PACKAGE_NAME = eINSTANCE.getProjectContext_PackageName();

		/**
		 * The meta object literal for the '<em><b>Java Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT_CONTEXT__JAVA_VERSION = eINSTANCE.getProjectContext_JavaVersion();

		/**
		 * The meta object literal for the '<em><b>Spring Boot Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT_CONTEXT__SPRING_BOOT_VERSION = eINSTANCE.getProjectContext_SpringBootVersion();

		/**
		 * The meta object literal for the '<em><b>Database Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT_CONTEXT__DATABASE_TYPE = eINSTANCE.getProjectContext_DatabaseType();

		/**
		 * The meta object literal for the '<em><b>Database Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROJECT_CONTEXT__DATABASE_NAME = eINSTANCE.getProjectContext_DatabaseName();

		/**
		 * The meta object literal for the '<em><b>Entities</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT_CONTEXT__ENTITIES = eINSTANCE.getProjectContext_Entities();

		/**
		 * The meta object literal for the '<em><b>Dependencies</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROJECT_CONTEXT__DEPENDENCIES = eINSTANCE.getProjectContext_Dependencies();

		/**
		 * The meta object literal for the '{@link com.mde.generator.Context.impl.EntityContextImpl <em>Entity Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.mde.generator.Context.impl.EntityContextImpl
		 * @see com.mde.generator.Context.impl.ContextPackageImpl#getEntityContext()
		 * @generated
		 */
		EClass ENTITY_CONTEXT = eINSTANCE.getEntityContext();

		/**
		 * The meta object literal for the '<em><b>Table Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTITY_CONTEXT__TABLE_NAME = eINSTANCE.getEntityContext_TableName();

		/**
		 * The meta object literal for the '<em><b>Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTITY_CONTEXT__CLASS_NAME = eINSTANCE.getEntityContext_ClassName();

		/**
		 * The meta object literal for the '<em><b>Package Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTITY_CONTEXT__PACKAGE_NAME = eINSTANCE.getEntityContext_PackageName();

		/**
		 * The meta object literal for the '<em><b>Has Relationships</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTITY_CONTEXT__HAS_RELATIONSHIPS = eINSTANCE.getEntityContext_HasRelationships();

		/**
		 * The meta object literal for the '<em><b>Fields</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITY_CONTEXT__FIELDS = eINSTANCE.getEntityContext_Fields();

		/**
		 * The meta object literal for the '<em><b>Relations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITY_CONTEXT__RELATIONS = eINSTANCE.getEntityContext_Relations();

		/**
		 * The meta object literal for the '<em><b>Primary Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTITY_CONTEXT__PRIMARY_KEY = eINSTANCE.getEntityContext_PrimaryKey();

		/**
		 * The meta object literal for the '{@link com.mde.generator.Context.impl.FieldContextImpl <em>Field Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.mde.generator.Context.impl.FieldContextImpl
		 * @see com.mde.generator.Context.impl.ContextPackageImpl#getFieldContext()
		 * @generated
		 */
		EClass FIELD_CONTEXT = eINSTANCE.getFieldContext();

		/**
		 * The meta object literal for the '<em><b>Column Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIELD_CONTEXT__COLUMN_NAME = eINSTANCE.getFieldContext_ColumnName();

		/**
		 * The meta object literal for the '<em><b>Field Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIELD_CONTEXT__FIELD_NAME = eINSTANCE.getFieldContext_FieldName();

		/**
		 * The meta object literal for the '<em><b>Java Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIELD_CONTEXT__JAVA_TYPE = eINSTANCE.getFieldContext_JavaType();

		/**
		 * The meta object literal for the '<em><b>Is Primary Key</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIELD_CONTEXT__IS_PRIMARY_KEY = eINSTANCE.getFieldContext_IsPrimaryKey();

		/**
		 * The meta object literal for the '<em><b>Is Nullable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIELD_CONTEXT__IS_NULLABLE = eINSTANCE.getFieldContext_IsNullable();

		/**
		 * The meta object literal for the '<em><b>Is Unique</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FIELD_CONTEXT__IS_UNIQUE = eINSTANCE.getFieldContext_IsUnique();

		/**
		 * The meta object literal for the '{@link com.mde.generator.Context.impl.RelationContextImpl <em>Relation Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.mde.generator.Context.impl.RelationContextImpl
		 * @see com.mde.generator.Context.impl.ContextPackageImpl#getRelationContext()
		 * @generated
		 */
		EClass RELATION_CONTEXT = eINSTANCE.getRelationContext();

		/**
		 * The meta object literal for the '<em><b>Field Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RELATION_CONTEXT__FIELD_NAME = eINSTANCE.getRelationContext_FieldName();

		/**
		 * The meta object literal for the '<em><b>Target Entity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RELATION_CONTEXT__TARGET_ENTITY = eINSTANCE.getRelationContext_TargetEntity();

		/**
		 * The meta object literal for the '<em><b>Relation Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RELATION_CONTEXT__RELATION_TYPE = eINSTANCE.getRelationContext_RelationType();

		/**
		 * The meta object literal for the '<em><b>Is Owner</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RELATION_CONTEXT__IS_OWNER = eINSTANCE.getRelationContext_IsOwner();

		/**
		 * The meta object literal for the '<em><b>Join Column Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RELATION_CONTEXT__JOIN_COLUMN_NAME = eINSTANCE.getRelationContext_JoinColumnName();

		/**
		 * The meta object literal for the '<em><b>Mapped By</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RELATION_CONTEXT__MAPPED_BY = eINSTANCE.getRelationContext_MappedBy();

		/**
		 * The meta object literal for the '<em><b>Cascade Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RELATION_CONTEXT__CASCADE_TYPE = eINSTANCE.getRelationContext_CascadeType();

		/**
		 * The meta object literal for the '<em><b>Fetch Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RELATION_CONTEXT__FETCH_TYPE = eINSTANCE.getRelationContext_FetchType();

		/**
		 * The meta object literal for the '{@link com.mde.generator.Context.impl.DependencyContextImpl <em>Dependency Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see com.mde.generator.Context.impl.DependencyContextImpl
		 * @see com.mde.generator.Context.impl.ContextPackageImpl#getDependencyContext()
		 * @generated
		 */
		EClass DEPENDENCY_CONTEXT = eINSTANCE.getDependencyContext();

		/**
		 * The meta object literal for the '<em><b>Group Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPENDENCY_CONTEXT__GROUP_ID = eINSTANCE.getDependencyContext_GroupId();

		/**
		 * The meta object literal for the '<em><b>Artifact Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPENDENCY_CONTEXT__ARTIFACT_ID = eINSTANCE.getDependencyContext_ArtifactId();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPENDENCY_CONTEXT__VERSION = eINSTANCE.getDependencyContext_Version();

		/**
		 * The meta object literal for the '<em><b>Scope</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPENDENCY_CONTEXT__SCOPE = eINSTANCE.getDependencyContext_Scope();

	}

} //ContextPackage
