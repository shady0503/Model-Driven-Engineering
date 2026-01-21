/**
 */
package Context.impl;

import Context.ContextPackage;
import Context.DependencyContext;
import Context.EntityContext;
import Context.ProjectContext;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Project Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link Context.impl.ProjectContextImpl#getGroupId <em>Group Id</em>}</li>
 *   <li>{@link Context.impl.ProjectContextImpl#getArtifactId <em>Artifact Id</em>}</li>
 *   <li>{@link Context.impl.ProjectContextImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link Context.impl.ProjectContextImpl#getPackageName <em>Package Name</em>}</li>
 *   <li>{@link Context.impl.ProjectContextImpl#getJavaVersion <em>Java Version</em>}</li>
 *   <li>{@link Context.impl.ProjectContextImpl#getSpringBootVersion <em>Spring Boot Version</em>}</li>
 *   <li>{@link Context.impl.ProjectContextImpl#getDatabaseType <em>Database Type</em>}</li>
 *   <li>{@link Context.impl.ProjectContextImpl#getDatabaseName <em>Database Name</em>}</li>
 *   <li>{@link Context.impl.ProjectContextImpl#getEntities <em>Entities</em>}</li>
 *   <li>{@link Context.impl.ProjectContextImpl#getDependencies <em>Dependencies</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ProjectContextImpl extends MinimalEObjectImpl.Container implements ProjectContext {
	/**
	 * The default value of the '{@link #getGroupId() <em>Group Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroupId()
	 * @generated
	 * @ordered
	 */
	protected static final String GROUP_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGroupId() <em>Group Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroupId()
	 * @generated
	 * @ordered
	 */
	protected String groupId = GROUP_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getArtifactId() <em>Artifact Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArtifactId()
	 * @generated
	 * @ordered
	 */
	protected static final String ARTIFACT_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getArtifactId() <em>Artifact Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArtifactId()
	 * @generated
	 * @ordered
	 */
	protected String artifactId = ARTIFACT_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected String version = VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getPackageName() <em>Package Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackageName()
	 * @generated
	 * @ordered
	 */
	protected static final String PACKAGE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPackageName() <em>Package Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackageName()
	 * @generated
	 * @ordered
	 */
	protected String packageName = PACKAGE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getJavaVersion() <em>Java Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJavaVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String JAVA_VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getJavaVersion() <em>Java Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJavaVersion()
	 * @generated
	 * @ordered
	 */
	protected String javaVersion = JAVA_VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getSpringBootVersion() <em>Spring Boot Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpringBootVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String SPRING_BOOT_VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSpringBootVersion() <em>Spring Boot Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSpringBootVersion()
	 * @generated
	 * @ordered
	 */
	protected String springBootVersion = SPRING_BOOT_VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getDatabaseType() <em>Database Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDatabaseType()
	 * @generated
	 * @ordered
	 */
	protected static final String DATABASE_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDatabaseType() <em>Database Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDatabaseType()
	 * @generated
	 * @ordered
	 */
	protected String databaseType = DATABASE_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getDatabaseName() <em>Database Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDatabaseName()
	 * @generated
	 * @ordered
	 */
	protected static final String DATABASE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDatabaseName() <em>Database Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDatabaseName()
	 * @generated
	 * @ordered
	 */
	protected String databaseName = DATABASE_NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEntities() <em>Entities</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEntities()
	 * @generated
	 * @ordered
	 */
	protected EList<EntityContext> entities;

	/**
	 * The cached value of the '{@link #getDependencies() <em>Dependencies</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDependencies()
	 * @generated
	 * @ordered
	 */
	protected EList<DependencyContext> dependencies;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProjectContextImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ContextPackage.Literals.PROJECT_CONTEXT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getGroupId() {
		return groupId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGroupId(String newGroupId) {
		String oldGroupId = groupId;
		groupId = newGroupId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContextPackage.PROJECT_CONTEXT__GROUP_ID, oldGroupId, groupId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getArtifactId() {
		return artifactId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setArtifactId(String newArtifactId) {
		String oldArtifactId = artifactId;
		artifactId = newArtifactId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContextPackage.PROJECT_CONTEXT__ARTIFACT_ID, oldArtifactId, artifactId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getVersion() {
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVersion(String newVersion) {
		String oldVersion = version;
		version = newVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContextPackage.PROJECT_CONTEXT__VERSION, oldVersion, version));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPackageName() {
		return packageName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPackageName(String newPackageName) {
		String oldPackageName = packageName;
		packageName = newPackageName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContextPackage.PROJECT_CONTEXT__PACKAGE_NAME, oldPackageName, packageName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getJavaVersion() {
		return javaVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setJavaVersion(String newJavaVersion) {
		String oldJavaVersion = javaVersion;
		javaVersion = newJavaVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContextPackage.PROJECT_CONTEXT__JAVA_VERSION, oldJavaVersion, javaVersion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getSpringBootVersion() {
		return springBootVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSpringBootVersion(String newSpringBootVersion) {
		String oldSpringBootVersion = springBootVersion;
		springBootVersion = newSpringBootVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContextPackage.PROJECT_CONTEXT__SPRING_BOOT_VERSION, oldSpringBootVersion, springBootVersion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDatabaseType() {
		return databaseType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDatabaseType(String newDatabaseType) {
		String oldDatabaseType = databaseType;
		databaseType = newDatabaseType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContextPackage.PROJECT_CONTEXT__DATABASE_TYPE, oldDatabaseType, databaseType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDatabaseName() {
		return databaseName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDatabaseName(String newDatabaseName) {
		String oldDatabaseName = databaseName;
		databaseName = newDatabaseName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContextPackage.PROJECT_CONTEXT__DATABASE_NAME, oldDatabaseName, databaseName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<EntityContext> getEntities() {
		if (entities == null) {
			entities = new EObjectContainmentEList<EntityContext>(EntityContext.class, this, ContextPackage.PROJECT_CONTEXT__ENTITIES);
		}
		return entities;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DependencyContext> getDependencies() {
		if (dependencies == null) {
			dependencies = new EObjectContainmentEList<DependencyContext>(DependencyContext.class, this, ContextPackage.PROJECT_CONTEXT__DEPENDENCIES);
		}
		return dependencies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ContextPackage.PROJECT_CONTEXT__ENTITIES:
				return ((InternalEList<?>)getEntities()).basicRemove(otherEnd, msgs);
			case ContextPackage.PROJECT_CONTEXT__DEPENDENCIES:
				return ((InternalEList<?>)getDependencies()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ContextPackage.PROJECT_CONTEXT__GROUP_ID:
				return getGroupId();
			case ContextPackage.PROJECT_CONTEXT__ARTIFACT_ID:
				return getArtifactId();
			case ContextPackage.PROJECT_CONTEXT__VERSION:
				return getVersion();
			case ContextPackage.PROJECT_CONTEXT__PACKAGE_NAME:
				return getPackageName();
			case ContextPackage.PROJECT_CONTEXT__JAVA_VERSION:
				return getJavaVersion();
			case ContextPackage.PROJECT_CONTEXT__SPRING_BOOT_VERSION:
				return getSpringBootVersion();
			case ContextPackage.PROJECT_CONTEXT__DATABASE_TYPE:
				return getDatabaseType();
			case ContextPackage.PROJECT_CONTEXT__DATABASE_NAME:
				return getDatabaseName();
			case ContextPackage.PROJECT_CONTEXT__ENTITIES:
				return getEntities();
			case ContextPackage.PROJECT_CONTEXT__DEPENDENCIES:
				return getDependencies();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ContextPackage.PROJECT_CONTEXT__GROUP_ID:
				setGroupId((String)newValue);
				return;
			case ContextPackage.PROJECT_CONTEXT__ARTIFACT_ID:
				setArtifactId((String)newValue);
				return;
			case ContextPackage.PROJECT_CONTEXT__VERSION:
				setVersion((String)newValue);
				return;
			case ContextPackage.PROJECT_CONTEXT__PACKAGE_NAME:
				setPackageName((String)newValue);
				return;
			case ContextPackage.PROJECT_CONTEXT__JAVA_VERSION:
				setJavaVersion((String)newValue);
				return;
			case ContextPackage.PROJECT_CONTEXT__SPRING_BOOT_VERSION:
				setSpringBootVersion((String)newValue);
				return;
			case ContextPackage.PROJECT_CONTEXT__DATABASE_TYPE:
				setDatabaseType((String)newValue);
				return;
			case ContextPackage.PROJECT_CONTEXT__DATABASE_NAME:
				setDatabaseName((String)newValue);
				return;
			case ContextPackage.PROJECT_CONTEXT__ENTITIES:
				getEntities().clear();
				getEntities().addAll((Collection<? extends EntityContext>)newValue);
				return;
			case ContextPackage.PROJECT_CONTEXT__DEPENDENCIES:
				getDependencies().clear();
				getDependencies().addAll((Collection<? extends DependencyContext>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ContextPackage.PROJECT_CONTEXT__GROUP_ID:
				setGroupId(GROUP_ID_EDEFAULT);
				return;
			case ContextPackage.PROJECT_CONTEXT__ARTIFACT_ID:
				setArtifactId(ARTIFACT_ID_EDEFAULT);
				return;
			case ContextPackage.PROJECT_CONTEXT__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case ContextPackage.PROJECT_CONTEXT__PACKAGE_NAME:
				setPackageName(PACKAGE_NAME_EDEFAULT);
				return;
			case ContextPackage.PROJECT_CONTEXT__JAVA_VERSION:
				setJavaVersion(JAVA_VERSION_EDEFAULT);
				return;
			case ContextPackage.PROJECT_CONTEXT__SPRING_BOOT_VERSION:
				setSpringBootVersion(SPRING_BOOT_VERSION_EDEFAULT);
				return;
			case ContextPackage.PROJECT_CONTEXT__DATABASE_TYPE:
				setDatabaseType(DATABASE_TYPE_EDEFAULT);
				return;
			case ContextPackage.PROJECT_CONTEXT__DATABASE_NAME:
				setDatabaseName(DATABASE_NAME_EDEFAULT);
				return;
			case ContextPackage.PROJECT_CONTEXT__ENTITIES:
				getEntities().clear();
				return;
			case ContextPackage.PROJECT_CONTEXT__DEPENDENCIES:
				getDependencies().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ContextPackage.PROJECT_CONTEXT__GROUP_ID:
				return GROUP_ID_EDEFAULT == null ? groupId != null : !GROUP_ID_EDEFAULT.equals(groupId);
			case ContextPackage.PROJECT_CONTEXT__ARTIFACT_ID:
				return ARTIFACT_ID_EDEFAULT == null ? artifactId != null : !ARTIFACT_ID_EDEFAULT.equals(artifactId);
			case ContextPackage.PROJECT_CONTEXT__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
			case ContextPackage.PROJECT_CONTEXT__PACKAGE_NAME:
				return PACKAGE_NAME_EDEFAULT == null ? packageName != null : !PACKAGE_NAME_EDEFAULT.equals(packageName);
			case ContextPackage.PROJECT_CONTEXT__JAVA_VERSION:
				return JAVA_VERSION_EDEFAULT == null ? javaVersion != null : !JAVA_VERSION_EDEFAULT.equals(javaVersion);
			case ContextPackage.PROJECT_CONTEXT__SPRING_BOOT_VERSION:
				return SPRING_BOOT_VERSION_EDEFAULT == null ? springBootVersion != null : !SPRING_BOOT_VERSION_EDEFAULT.equals(springBootVersion);
			case ContextPackage.PROJECT_CONTEXT__DATABASE_TYPE:
				return DATABASE_TYPE_EDEFAULT == null ? databaseType != null : !DATABASE_TYPE_EDEFAULT.equals(databaseType);
			case ContextPackage.PROJECT_CONTEXT__DATABASE_NAME:
				return DATABASE_NAME_EDEFAULT == null ? databaseName != null : !DATABASE_NAME_EDEFAULT.equals(databaseName);
			case ContextPackage.PROJECT_CONTEXT__ENTITIES:
				return entities != null && !entities.isEmpty();
			case ContextPackage.PROJECT_CONTEXT__DEPENDENCIES:
				return dependencies != null && !dependencies.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (groupId: ");
		result.append(groupId);
		result.append(", artifactId: ");
		result.append(artifactId);
		result.append(", version: ");
		result.append(version);
		result.append(", packageName: ");
		result.append(packageName);
		result.append(", javaVersion: ");
		result.append(javaVersion);
		result.append(", springBootVersion: ");
		result.append(springBootVersion);
		result.append(", databaseType: ");
		result.append(databaseType);
		result.append(", databaseName: ");
		result.append(databaseName);
		result.append(')');
		return result.toString();
	}

} //ProjectContextImpl
