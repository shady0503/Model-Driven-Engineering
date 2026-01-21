/**
 */
package ModelDrivenEngineering.impl;

import ModelDrivenEngineering.Framework;
import ModelDrivenEngineering.Language;
import ModelDrivenEngineering.ModelDrivenEngineeringPackage;
import ModelDrivenEngineering.Project;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Project</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link ModelDrivenEngineering.impl.ProjectImpl#getGroupId <em>Group
 * Id</em>}</li>
 * <li>{@link ModelDrivenEngineering.impl.ProjectImpl#getJavaVersion <em>Java
 * Version</em>}</li>
 * <li>{@link ModelDrivenEngineering.impl.ProjectImpl#getSpringBootVersion
 * <em>Spring Boot Version</em>}</li>
 * <li>{@link ModelDrivenEngineering.impl.ProjectImpl#getName
 * <em>Name</em>}</li>
 * <li>{@link ModelDrivenEngineering.impl.ProjectImpl#getVersion
 * <em>Version</em>}</li>
 * <li>{@link ModelDrivenEngineering.impl.ProjectImpl#getLanguage
 * <em>Language</em>}</li>
 * <li>{@link ModelDrivenEngineering.impl.ProjectImpl#getFramework
 * <em>Framework</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ProjectImpl extends MinimalEObjectImpl.Container implements Project {
	/**
	 * The default value of the '{@link #getGroupId() <em>Group Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getGroupId()
	 * @generated
	 * @ordered
	 */
	protected static final String GROUP_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGroupId() <em>Group Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getGroupId()
	 * @generated
	 * @ordered
	 */
	protected String groupId = GROUP_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getJavaVersion() <em>Java Version</em>}'
	 * attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getJavaVersion()
	 * @generated
	 * @ordered
	 */
	protected static final int JAVA_VERSION_EDEFAULT = 17;

	/**
	 * The cached value of the '{@link #getJavaVersion() <em>Java Version</em>}'
	 * attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getJavaVersion()
	 * @generated
	 * @ordered
	 */
	protected int javaVersion = JAVA_VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getSpringBootVersion() <em>Spring Boot
	 * Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getSpringBootVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String SPRING_BOOT_VERSION_EDEFAULT = "3.5.6";

	/**
	 * The cached value of the '{@link #getSpringBootVersion() <em>Spring Boot
	 * Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getSpringBootVersion()
	 * @generated
	 * @ordered
	 */
	protected String springBootVersion = SPRING_BOOT_VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String VERSION_EDEFAULT = "1.0.0";

	/**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected String version = VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getLanguage() <em>Language</em>}'
	 * attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getLanguage()
	 * @generated
	 * @ordered
	 */
	protected static final Language LANGUAGE_EDEFAULT = Language.JAVA;

	/**
	 * The cached value of the '{@link #getLanguage() <em>Language</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getLanguage()
	 * @generated
	 * @ordered
	 */
	protected Language language = LANGUAGE_EDEFAULT;

	/**
	 * The default value of the '{@link #getFramework() <em>Framework</em>}'
	 * attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getFramework()
	 * @generated
	 * @ordered
	 */
	protected static final Framework FRAMEWORK_EDEFAULT = Framework.SPRING_BOOT;

	/**
	 * The cached value of the '{@link #getFramework() <em>Framework</em>}'
	 * attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getFramework()
	 * @generated
	 * @ordered
	 */
	protected Framework framework = FRAMEWORK_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected ProjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelDrivenEngineeringPackage.Literals.PROJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getGroupId() {
		return groupId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setGroupId(String newGroupId) {
		String oldGroupId = groupId;
		groupId = newGroupId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelDrivenEngineeringPackage.PROJECT__GROUP_ID,
					oldGroupId, groupId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public int getJavaVersion() {
		return javaVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setJavaVersion(int newJavaVersion) {
		int oldJavaVersion = javaVersion;
		javaVersion = newJavaVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelDrivenEngineeringPackage.PROJECT__JAVA_VERSION,
					oldJavaVersion, javaVersion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getSpringBootVersion() {
		return springBootVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setSpringBootVersion(String newSpringBootVersion) {
		String oldSpringBootVersion = springBootVersion;
		springBootVersion = newSpringBootVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ModelDrivenEngineeringPackage.PROJECT__SPRING_BOOT_VERSION, oldSpringBootVersion,
					springBootVersion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelDrivenEngineeringPackage.PROJECT__NAME, oldName,
					name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getVersion() {
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setVersion(String newVersion) {
		String oldVersion = version;
		version = newVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelDrivenEngineeringPackage.PROJECT__VERSION,
					oldVersion, version));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Language getLanguage() {
		return language;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setLanguage(Language newLanguage) {
		Language oldLanguage = language;
		language = newLanguage == null ? LANGUAGE_EDEFAULT : newLanguage;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelDrivenEngineeringPackage.PROJECT__LANGUAGE,
					oldLanguage, language));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Framework getFramework() {
		return framework;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setFramework(Framework newFramework) {
		Framework oldFramework = framework;
		framework = newFramework == null ? FRAMEWORK_EDEFAULT : newFramework;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelDrivenEngineeringPackage.PROJECT__FRAMEWORK,
					oldFramework, framework));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelDrivenEngineeringPackage.PROJECT__GROUP_ID:
				return getGroupId();
			case ModelDrivenEngineeringPackage.PROJECT__JAVA_VERSION:
				return getJavaVersion();
			case ModelDrivenEngineeringPackage.PROJECT__SPRING_BOOT_VERSION:
				return getSpringBootVersion();
			case ModelDrivenEngineeringPackage.PROJECT__NAME:
				return getName();
			case ModelDrivenEngineeringPackage.PROJECT__VERSION:
				return getVersion();
			case ModelDrivenEngineeringPackage.PROJECT__LANGUAGE:
				return getLanguage();
			case ModelDrivenEngineeringPackage.PROJECT__FRAMEWORK:
				return getFramework();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModelDrivenEngineeringPackage.PROJECT__GROUP_ID:
				setGroupId((String) newValue);
				return;
			case ModelDrivenEngineeringPackage.PROJECT__JAVA_VERSION:
				setJavaVersion((Integer) newValue);
				return;
			case ModelDrivenEngineeringPackage.PROJECT__SPRING_BOOT_VERSION:
				setSpringBootVersion((String) newValue);
				return;
			case ModelDrivenEngineeringPackage.PROJECT__NAME:
				setName((String) newValue);
				return;
			case ModelDrivenEngineeringPackage.PROJECT__VERSION:
				setVersion((String) newValue);
				return;
			case ModelDrivenEngineeringPackage.PROJECT__LANGUAGE:
				setLanguage((Language) newValue);
				return;
			case ModelDrivenEngineeringPackage.PROJECT__FRAMEWORK:
				setFramework((Framework) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ModelDrivenEngineeringPackage.PROJECT__GROUP_ID:
				setGroupId(GROUP_ID_EDEFAULT);
				return;
			case ModelDrivenEngineeringPackage.PROJECT__JAVA_VERSION:
				setJavaVersion(JAVA_VERSION_EDEFAULT);
				return;
			case ModelDrivenEngineeringPackage.PROJECT__SPRING_BOOT_VERSION:
				setSpringBootVersion(SPRING_BOOT_VERSION_EDEFAULT);
				return;
			case ModelDrivenEngineeringPackage.PROJECT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case ModelDrivenEngineeringPackage.PROJECT__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case ModelDrivenEngineeringPackage.PROJECT__LANGUAGE:
				setLanguage(LANGUAGE_EDEFAULT);
				return;
			case ModelDrivenEngineeringPackage.PROJECT__FRAMEWORK:
				setFramework(FRAMEWORK_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ModelDrivenEngineeringPackage.PROJECT__GROUP_ID:
				return GROUP_ID_EDEFAULT == null ? groupId != null : !GROUP_ID_EDEFAULT.equals(groupId);
			case ModelDrivenEngineeringPackage.PROJECT__JAVA_VERSION:
				return javaVersion != JAVA_VERSION_EDEFAULT;
			case ModelDrivenEngineeringPackage.PROJECT__SPRING_BOOT_VERSION:
				return SPRING_BOOT_VERSION_EDEFAULT == null ? springBootVersion != null
						: !SPRING_BOOT_VERSION_EDEFAULT.equals(springBootVersion);
			case ModelDrivenEngineeringPackage.PROJECT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case ModelDrivenEngineeringPackage.PROJECT__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
			case ModelDrivenEngineeringPackage.PROJECT__LANGUAGE:
				return language != LANGUAGE_EDEFAULT;
			case ModelDrivenEngineeringPackage.PROJECT__FRAMEWORK:
				return framework != FRAMEWORK_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (groupId: ");
		result.append(groupId);
		result.append(", javaVersion: ");
		result.append(javaVersion);
		result.append(", springBootVersion: ");
		result.append(springBootVersion);
		result.append(", name: ");
		result.append(name);
		result.append(", version: ");
		result.append(version);
		result.append(", language: ");
		result.append(language);
		result.append(", framework: ");
		result.append(framework);
		result.append(')');
		return result.toString();
	}

} // ProjectImpl
