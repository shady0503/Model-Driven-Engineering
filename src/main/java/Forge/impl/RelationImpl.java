/**
 */
package Forge.impl;

import Forge.CascadeType;
import Forge.FetchType;
import Forge.JpaCascadeType;
import Forge.ForgePackage;
import Forge.Relation;
import Forge.RelationType;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link Forge.impl.RelationImpl#getTargetTable <em>Target
 * Table</em>}</li>
 * <li>{@link Forge.impl.RelationImpl#getTargetColumn
 * <em>Target Column</em>}</li>
 * <li>{@link Forge.impl.RelationImpl#getOnDelete <em>On
 * Delete</em>}</li>
 * <li>{@link Forge.impl.RelationImpl#getType
 * <em>Type</em>}</li>
 * <li>{@link Forge.impl.RelationImpl#isOwner
 * <em>Owner</em>}</li>
 * <li>{@link Forge.impl.RelationImpl#getFetch
 * <em>Fetch</em>}</li>
 * <li>{@link Forge.impl.RelationImpl#getCascade
 * <em>Cascade</em>}</li>
 * <li>{@link Forge.impl.RelationImpl#isOptional
 * <em>Optional</em>}</li>
 * <li>{@link Forge.impl.RelationImpl#getJoinTableName <em>Join
 * Table Name</em>}</li>
 * <li>{@link Forge.impl.RelationImpl#getJoinColumnName
 * <em>Join Column Name</em>}</li>
 * <li>{@link Forge.impl.RelationImpl#getInverseJoinColumnName
 * <em>Inverse Join Column Name</em>}</li>
 * <li>{@link Forge.impl.RelationImpl#getMappedBy <em>Mapped
 * By</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RelationImpl extends MinimalEObjectImpl.Container implements Relation {
	/**
	 * The default value of the '{@link #getTargetTable() <em>Target Table</em>}'
	 * attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getTargetTable()
	 * @generated
	 * @ordered
	 */
	protected static final String TARGET_TABLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTargetTable() <em>Target Table</em>}'
	 * attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getTargetTable()
	 * @generated
	 * @ordered
	 */
	protected String targetTable = TARGET_TABLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getTargetColumn() <em>Target Column</em>}'
	 * attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getTargetColumn()
	 * @generated
	 * @ordered
	 */
	protected static final String TARGET_COLUMN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTargetColumn() <em>Target Column</em>}'
	 * attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getTargetColumn()
	 * @generated
	 * @ordered
	 */
	protected String targetColumn = TARGET_COLUMN_EDEFAULT;

	/**
	 * The default value of the '{@link #getOnDelete() <em>On Delete</em>}'
	 * attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getOnDelete()
	 * @generated
	 * @ordered
	 */
	protected static final CascadeType ON_DELETE_EDEFAULT = CascadeType.RESTRICT;

	/**
	 * The cached value of the '{@link #getOnDelete() <em>On Delete</em>}'
	 * attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getOnDelete()
	 * @generated
	 * @ordered
	 */
	protected CascadeType onDelete = ON_DELETE_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final RelationType TYPE_EDEFAULT = RelationType.MANY_TO_ONE;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected RelationType type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #isOwner() <em>Owner</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #isOwner()
	 * @generated
	 * @ordered
	 */
	protected static final boolean OWNER_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isOwner() <em>Owner</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #isOwner()
	 * @generated
	 * @ordered
	 */
	protected boolean owner = OWNER_EDEFAULT;

	/**
	 * The default value of the '{@link #getFetch() <em>Fetch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getFetch()
	 * @generated
	 * @ordered
	 */
	protected static final FetchType FETCH_EDEFAULT = FetchType.LAZY;

	/**
	 * The cached value of the '{@link #getFetch() <em>Fetch</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getFetch()
	 * @generated
	 * @ordered
	 */
	protected FetchType fetch = FETCH_EDEFAULT;

	/**
	 * The default value of the '{@link #getCascade() <em>Cascade</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getCascade()
	 * @generated
	 * @ordered
	 */
	protected static final JpaCascadeType CASCADE_EDEFAULT = JpaCascadeType.ALL;

	/**
	 * The cached value of the '{@link #getCascade() <em>Cascade</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getCascade()
	 * @generated
	 * @ordered
	 */
	protected JpaCascadeType cascade = CASCADE_EDEFAULT;

	/**
	 * The default value of the '{@link #isOptional() <em>Optional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #isOptional()
	 * @generated
	 * @ordered
	 */
	protected static final boolean OPTIONAL_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isOptional() <em>Optional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #isOptional()
	 * @generated
	 * @ordered
	 */
	protected boolean optional = OPTIONAL_EDEFAULT;

	/**
	 * The default value of the '{@link #getJoinTableName() <em>Join Table
	 * Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getJoinTableName()
	 * @generated
	 * @ordered
	 */
	protected static final String JOIN_TABLE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getJoinTableName() <em>Join Table
	 * Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getJoinTableName()
	 * @generated
	 * @ordered
	 */
	protected String joinTableName = JOIN_TABLE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getJoinColumnName() <em>Join Column
	 * Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getJoinColumnName()
	 * @generated
	 * @ordered
	 */
	protected static final String JOIN_COLUMN_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getJoinColumnName() <em>Join Column
	 * Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getJoinColumnName()
	 * @generated
	 * @ordered
	 */
	protected String joinColumnName = JOIN_COLUMN_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getInverseJoinColumnName() <em>Inverse Join
	 * Column Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getInverseJoinColumnName()
	 * @generated
	 * @ordered
	 */
	protected static final String INVERSE_JOIN_COLUMN_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInverseJoinColumnName() <em>Inverse Join
	 * Column Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getInverseJoinColumnName()
	 * @generated
	 * @ordered
	 */
	protected String inverseJoinColumnName = INVERSE_JOIN_COLUMN_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getMappedBy() <em>Mapped By</em>}'
	 * attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getMappedBy()
	 * @generated
	 * @ordered
	 */
	protected static final String MAPPED_BY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMappedBy() <em>Mapped By</em>}'
	 * attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getMappedBy()
	 * @generated
	 * @ordered
	 */
	protected String mappedBy = MAPPED_BY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected RelationImpl() {
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
		return ForgePackage.Literals.RELATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getTargetTable() {
		return targetTable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setTargetTable(String newTargetTable) {
		String oldTargetTable = targetTable;
		targetTable = newTargetTable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ForgePackage.RELATION__TARGET_TABLE,
					oldTargetTable, targetTable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getTargetColumn() {
		return targetColumn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setTargetColumn(String newTargetColumn) {
		String oldTargetColumn = targetColumn;
		targetColumn = newTargetColumn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ForgePackage.RELATION__TARGET_COLUMN,
					oldTargetColumn, targetColumn));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public CascadeType getOnDelete() {
		return onDelete;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setOnDelete(CascadeType newOnDelete) {
		CascadeType oldOnDelete = onDelete;
		onDelete = newOnDelete == null ? ON_DELETE_EDEFAULT : newOnDelete;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ForgePackage.RELATION__ON_DELETE,
					oldOnDelete, onDelete));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public RelationType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setType(RelationType newType) {
		RelationType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ForgePackage.RELATION__TYPE, oldType,
					type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean isOwner() {
		return owner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setOwner(boolean newOwner) {
		boolean oldOwner = owner;
		owner = newOwner;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ForgePackage.RELATION__OWNER,
					oldOwner, owner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public FetchType getFetch() {
		return fetch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setFetch(FetchType newFetch) {
		FetchType oldFetch = fetch;
		fetch = newFetch == null ? FETCH_EDEFAULT : newFetch;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ForgePackage.RELATION__FETCH,
					oldFetch, fetch));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public JpaCascadeType getCascade() {
		return cascade;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setCascade(JpaCascadeType newCascade) {
		JpaCascadeType oldCascade = cascade;
		cascade = newCascade == null ? CASCADE_EDEFAULT : newCascade;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ForgePackage.RELATION__CASCADE,
					oldCascade, cascade));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean isOptional() {
		return optional;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setOptional(boolean newOptional) {
		boolean oldOptional = optional;
		optional = newOptional;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ForgePackage.RELATION__OPTIONAL,
					oldOptional, optional));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getJoinTableName() {
		return joinTableName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setJoinTableName(String newJoinTableName) {
		String oldJoinTableName = joinTableName;
		joinTableName = newJoinTableName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ForgePackage.RELATION__JOIN_TABLE_NAME, oldJoinTableName, joinTableName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getJoinColumnName() {
		return joinColumnName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setJoinColumnName(String newJoinColumnName) {
		String oldJoinColumnName = joinColumnName;
		joinColumnName = newJoinColumnName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ForgePackage.RELATION__JOIN_COLUMN_NAME, oldJoinColumnName, joinColumnName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getInverseJoinColumnName() {
		return inverseJoinColumnName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setInverseJoinColumnName(String newInverseJoinColumnName) {
		String oldInverseJoinColumnName = inverseJoinColumnName;
		inverseJoinColumnName = newInverseJoinColumnName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					ForgePackage.RELATION__INVERSE_JOIN_COLUMN_NAME, oldInverseJoinColumnName,
					inverseJoinColumnName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getMappedBy() {
		return mappedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void setMappedBy(String newMappedBy) {
		String oldMappedBy = mappedBy;
		mappedBy = newMappedBy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ForgePackage.RELATION__MAPPED_BY,
					oldMappedBy, mappedBy));
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
			case ForgePackage.RELATION__TARGET_TABLE:
				return getTargetTable();
			case ForgePackage.RELATION__TARGET_COLUMN:
				return getTargetColumn();
			case ForgePackage.RELATION__ON_DELETE:
				return getOnDelete();
			case ForgePackage.RELATION__TYPE:
				return getType();
			case ForgePackage.RELATION__OWNER:
				return isOwner();
			case ForgePackage.RELATION__FETCH:
				return getFetch();
			case ForgePackage.RELATION__CASCADE:
				return getCascade();
			case ForgePackage.RELATION__OPTIONAL:
				return isOptional();
			case ForgePackage.RELATION__JOIN_TABLE_NAME:
				return getJoinTableName();
			case ForgePackage.RELATION__JOIN_COLUMN_NAME:
				return getJoinColumnName();
			case ForgePackage.RELATION__INVERSE_JOIN_COLUMN_NAME:
				return getInverseJoinColumnName();
			case ForgePackage.RELATION__MAPPED_BY:
				return getMappedBy();
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
			case ForgePackage.RELATION__TARGET_TABLE:
				setTargetTable((String) newValue);
				return;
			case ForgePackage.RELATION__TARGET_COLUMN:
				setTargetColumn((String) newValue);
				return;
			case ForgePackage.RELATION__ON_DELETE:
				setOnDelete((CascadeType) newValue);
				return;
			case ForgePackage.RELATION__TYPE:
				setType((RelationType) newValue);
				return;
			case ForgePackage.RELATION__OWNER:
				setOwner((Boolean) newValue);
				return;
			case ForgePackage.RELATION__FETCH:
				setFetch((FetchType) newValue);
				return;
			case ForgePackage.RELATION__CASCADE:
				setCascade((JpaCascadeType) newValue);
				return;
			case ForgePackage.RELATION__OPTIONAL:
				setOptional((Boolean) newValue);
				return;
			case ForgePackage.RELATION__JOIN_TABLE_NAME:
				setJoinTableName((String) newValue);
				return;
			case ForgePackage.RELATION__JOIN_COLUMN_NAME:
				setJoinColumnName((String) newValue);
				return;
			case ForgePackage.RELATION__INVERSE_JOIN_COLUMN_NAME:
				setInverseJoinColumnName((String) newValue);
				return;
			case ForgePackage.RELATION__MAPPED_BY:
				setMappedBy((String) newValue);
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
			case ForgePackage.RELATION__TARGET_TABLE:
				setTargetTable(TARGET_TABLE_EDEFAULT);
				return;
			case ForgePackage.RELATION__TARGET_COLUMN:
				setTargetColumn(TARGET_COLUMN_EDEFAULT);
				return;
			case ForgePackage.RELATION__ON_DELETE:
				setOnDelete(ON_DELETE_EDEFAULT);
				return;
			case ForgePackage.RELATION__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case ForgePackage.RELATION__OWNER:
				setOwner(OWNER_EDEFAULT);
				return;
			case ForgePackage.RELATION__FETCH:
				setFetch(FETCH_EDEFAULT);
				return;
			case ForgePackage.RELATION__CASCADE:
				setCascade(CASCADE_EDEFAULT);
				return;
			case ForgePackage.RELATION__OPTIONAL:
				setOptional(OPTIONAL_EDEFAULT);
				return;
			case ForgePackage.RELATION__JOIN_TABLE_NAME:
				setJoinTableName(JOIN_TABLE_NAME_EDEFAULT);
				return;
			case ForgePackage.RELATION__JOIN_COLUMN_NAME:
				setJoinColumnName(JOIN_COLUMN_NAME_EDEFAULT);
				return;
			case ForgePackage.RELATION__INVERSE_JOIN_COLUMN_NAME:
				setInverseJoinColumnName(INVERSE_JOIN_COLUMN_NAME_EDEFAULT);
				return;
			case ForgePackage.RELATION__MAPPED_BY:
				setMappedBy(MAPPED_BY_EDEFAULT);
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
			case ForgePackage.RELATION__TARGET_TABLE:
				return TARGET_TABLE_EDEFAULT == null ? targetTable != null : !TARGET_TABLE_EDEFAULT.equals(targetTable);
			case ForgePackage.RELATION__TARGET_COLUMN:
				return TARGET_COLUMN_EDEFAULT == null ? targetColumn != null
						: !TARGET_COLUMN_EDEFAULT.equals(targetColumn);
			case ForgePackage.RELATION__ON_DELETE:
				return onDelete != ON_DELETE_EDEFAULT;
			case ForgePackage.RELATION__TYPE:
				return type != TYPE_EDEFAULT;
			case ForgePackage.RELATION__OWNER:
				return owner != OWNER_EDEFAULT;
			case ForgePackage.RELATION__FETCH:
				return fetch != FETCH_EDEFAULT;
			case ForgePackage.RELATION__CASCADE:
				return cascade != CASCADE_EDEFAULT;
			case ForgePackage.RELATION__OPTIONAL:
				return optional != OPTIONAL_EDEFAULT;
			case ForgePackage.RELATION__JOIN_TABLE_NAME:
				return JOIN_TABLE_NAME_EDEFAULT == null ? joinTableName != null
						: !JOIN_TABLE_NAME_EDEFAULT.equals(joinTableName);
			case ForgePackage.RELATION__JOIN_COLUMN_NAME:
				return JOIN_COLUMN_NAME_EDEFAULT == null ? joinColumnName != null
						: !JOIN_COLUMN_NAME_EDEFAULT.equals(joinColumnName);
			case ForgePackage.RELATION__INVERSE_JOIN_COLUMN_NAME:
				return INVERSE_JOIN_COLUMN_NAME_EDEFAULT == null ? inverseJoinColumnName != null
						: !INVERSE_JOIN_COLUMN_NAME_EDEFAULT.equals(inverseJoinColumnName);
			case ForgePackage.RELATION__MAPPED_BY:
				return MAPPED_BY_EDEFAULT == null ? mappedBy != null : !MAPPED_BY_EDEFAULT.equals(mappedBy);
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
		result.append(" (targetTable: ");
		result.append(targetTable);
		result.append(", targetColumn: ");
		result.append(targetColumn);
		result.append(", onDelete: ");
		result.append(onDelete);
		result.append(", type: ");
		result.append(type);
		result.append(", owner: ");
		result.append(owner);
		result.append(", fetch: ");
		result.append(fetch);
		result.append(", cascade: ");
		result.append(cascade);
		result.append(", optional: ");
		result.append(optional);
		result.append(", joinTableName: ");
		result.append(joinTableName);
		result.append(", joinColumnName: ");
		result.append(joinColumnName);
		result.append(", inverseJoinColumnName: ");
		result.append(inverseJoinColumnName);
		result.append(", mappedBy: ");
		result.append(mappedBy);
		result.append(')');
		return result.toString();
	}

} // RelationImpl
