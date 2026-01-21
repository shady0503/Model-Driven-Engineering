/**
 */
package Context.impl;

import Context.ContextPackage;
import Context.EntityContext;
import Context.FieldContext;
import Context.RelationContext;

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
 * An implementation of the model object '<em><b>Entity Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link Context.impl.EntityContextImpl#getTableName <em>Table Name</em>}</li>
 *   <li>{@link Context.impl.EntityContextImpl#getClassName <em>Class Name</em>}</li>
 *   <li>{@link Context.impl.EntityContextImpl#getPackageName <em>Package Name</em>}</li>
 *   <li>{@link Context.impl.EntityContextImpl#isHasRelationships <em>Has Relationships</em>}</li>
 *   <li>{@link Context.impl.EntityContextImpl#getFields <em>Fields</em>}</li>
 *   <li>{@link Context.impl.EntityContextImpl#getRelations <em>Relations</em>}</li>
 *   <li>{@link Context.impl.EntityContextImpl#getPrimaryKey <em>Primary Key</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EntityContextImpl extends MinimalEObjectImpl.Container implements EntityContext {
	/**
	 * The default value of the '{@link #getTableName() <em>Table Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTableName()
	 * @generated
	 * @ordered
	 */
	protected static final String TABLE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTableName() <em>Table Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTableName()
	 * @generated
	 * @ordered
	 */
	protected String tableName = TABLE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getClassName() <em>Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassName()
	 * @generated
	 * @ordered
	 */
	protected static final String CLASS_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClassName() <em>Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassName()
	 * @generated
	 * @ordered
	 */
	protected String className = CLASS_NAME_EDEFAULT;

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
	 * The default value of the '{@link #isHasRelationships() <em>Has Relationships</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasRelationships()
	 * @generated
	 * @ordered
	 */
	protected static final boolean HAS_RELATIONSHIPS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isHasRelationships() <em>Has Relationships</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isHasRelationships()
	 * @generated
	 * @ordered
	 */
	protected boolean hasRelationships = HAS_RELATIONSHIPS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFields() <em>Fields</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFields()
	 * @generated
	 * @ordered
	 */
	protected EList<FieldContext> fields;

	/**
	 * The cached value of the '{@link #getRelations() <em>Relations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelations()
	 * @generated
	 * @ordered
	 */
	protected EList<RelationContext> relations;

	/**
	 * The cached value of the '{@link #getPrimaryKey() <em>Primary Key</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimaryKey()
	 * @generated
	 * @ordered
	 */
	protected FieldContext primaryKey;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EntityContextImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ContextPackage.Literals.ENTITY_CONTEXT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTableName() {
		return tableName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTableName(String newTableName) {
		String oldTableName = tableName;
		tableName = newTableName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContextPackage.ENTITY_CONTEXT__TABLE_NAME, oldTableName, tableName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getClassName() {
		return className;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setClassName(String newClassName) {
		String oldClassName = className;
		className = newClassName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContextPackage.ENTITY_CONTEXT__CLASS_NAME, oldClassName, className));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ContextPackage.ENTITY_CONTEXT__PACKAGE_NAME, oldPackageName, packageName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isHasRelationships() {
		return hasRelationships;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHasRelationships(boolean newHasRelationships) {
		boolean oldHasRelationships = hasRelationships;
		hasRelationships = newHasRelationships;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContextPackage.ENTITY_CONTEXT__HAS_RELATIONSHIPS, oldHasRelationships, hasRelationships));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<FieldContext> getFields() {
		if (fields == null) {
			fields = new EObjectContainmentEList<FieldContext>(FieldContext.class, this, ContextPackage.ENTITY_CONTEXT__FIELDS);
		}
		return fields;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<RelationContext> getRelations() {
		if (relations == null) {
			relations = new EObjectContainmentEList<RelationContext>(RelationContext.class, this, ContextPackage.ENTITY_CONTEXT__RELATIONS);
		}
		return relations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FieldContext getPrimaryKey() {
		if (primaryKey != null && primaryKey.eIsProxy()) {
			InternalEObject oldPrimaryKey = (InternalEObject)primaryKey;
			primaryKey = (FieldContext)eResolveProxy(oldPrimaryKey);
			if (primaryKey != oldPrimaryKey) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ContextPackage.ENTITY_CONTEXT__PRIMARY_KEY, oldPrimaryKey, primaryKey));
			}
		}
		return primaryKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FieldContext basicGetPrimaryKey() {
		return primaryKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPrimaryKey(FieldContext newPrimaryKey) {
		FieldContext oldPrimaryKey = primaryKey;
		primaryKey = newPrimaryKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContextPackage.ENTITY_CONTEXT__PRIMARY_KEY, oldPrimaryKey, primaryKey));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ContextPackage.ENTITY_CONTEXT__FIELDS:
				return ((InternalEList<?>)getFields()).basicRemove(otherEnd, msgs);
			case ContextPackage.ENTITY_CONTEXT__RELATIONS:
				return ((InternalEList<?>)getRelations()).basicRemove(otherEnd, msgs);
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
			case ContextPackage.ENTITY_CONTEXT__TABLE_NAME:
				return getTableName();
			case ContextPackage.ENTITY_CONTEXT__CLASS_NAME:
				return getClassName();
			case ContextPackage.ENTITY_CONTEXT__PACKAGE_NAME:
				return getPackageName();
			case ContextPackage.ENTITY_CONTEXT__HAS_RELATIONSHIPS:
				return isHasRelationships();
			case ContextPackage.ENTITY_CONTEXT__FIELDS:
				return getFields();
			case ContextPackage.ENTITY_CONTEXT__RELATIONS:
				return getRelations();
			case ContextPackage.ENTITY_CONTEXT__PRIMARY_KEY:
				if (resolve) return getPrimaryKey();
				return basicGetPrimaryKey();
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
			case ContextPackage.ENTITY_CONTEXT__TABLE_NAME:
				setTableName((String)newValue);
				return;
			case ContextPackage.ENTITY_CONTEXT__CLASS_NAME:
				setClassName((String)newValue);
				return;
			case ContextPackage.ENTITY_CONTEXT__PACKAGE_NAME:
				setPackageName((String)newValue);
				return;
			case ContextPackage.ENTITY_CONTEXT__HAS_RELATIONSHIPS:
				setHasRelationships((Boolean)newValue);
				return;
			case ContextPackage.ENTITY_CONTEXT__FIELDS:
				getFields().clear();
				getFields().addAll((Collection<? extends FieldContext>)newValue);
				return;
			case ContextPackage.ENTITY_CONTEXT__RELATIONS:
				getRelations().clear();
				getRelations().addAll((Collection<? extends RelationContext>)newValue);
				return;
			case ContextPackage.ENTITY_CONTEXT__PRIMARY_KEY:
				setPrimaryKey((FieldContext)newValue);
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
			case ContextPackage.ENTITY_CONTEXT__TABLE_NAME:
				setTableName(TABLE_NAME_EDEFAULT);
				return;
			case ContextPackage.ENTITY_CONTEXT__CLASS_NAME:
				setClassName(CLASS_NAME_EDEFAULT);
				return;
			case ContextPackage.ENTITY_CONTEXT__PACKAGE_NAME:
				setPackageName(PACKAGE_NAME_EDEFAULT);
				return;
			case ContextPackage.ENTITY_CONTEXT__HAS_RELATIONSHIPS:
				setHasRelationships(HAS_RELATIONSHIPS_EDEFAULT);
				return;
			case ContextPackage.ENTITY_CONTEXT__FIELDS:
				getFields().clear();
				return;
			case ContextPackage.ENTITY_CONTEXT__RELATIONS:
				getRelations().clear();
				return;
			case ContextPackage.ENTITY_CONTEXT__PRIMARY_KEY:
				setPrimaryKey((FieldContext)null);
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
			case ContextPackage.ENTITY_CONTEXT__TABLE_NAME:
				return TABLE_NAME_EDEFAULT == null ? tableName != null : !TABLE_NAME_EDEFAULT.equals(tableName);
			case ContextPackage.ENTITY_CONTEXT__CLASS_NAME:
				return CLASS_NAME_EDEFAULT == null ? className != null : !CLASS_NAME_EDEFAULT.equals(className);
			case ContextPackage.ENTITY_CONTEXT__PACKAGE_NAME:
				return PACKAGE_NAME_EDEFAULT == null ? packageName != null : !PACKAGE_NAME_EDEFAULT.equals(packageName);
			case ContextPackage.ENTITY_CONTEXT__HAS_RELATIONSHIPS:
				return hasRelationships != HAS_RELATIONSHIPS_EDEFAULT;
			case ContextPackage.ENTITY_CONTEXT__FIELDS:
				return fields != null && !fields.isEmpty();
			case ContextPackage.ENTITY_CONTEXT__RELATIONS:
				return relations != null && !relations.isEmpty();
			case ContextPackage.ENTITY_CONTEXT__PRIMARY_KEY:
				return primaryKey != null;
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
		result.append(" (tableName: ");
		result.append(tableName);
		result.append(", className: ");
		result.append(className);
		result.append(", packageName: ");
		result.append(packageName);
		result.append(", hasRelationships: ");
		result.append(hasRelationships);
		result.append(')');
		return result.toString();
	}

} //EntityContextImpl
