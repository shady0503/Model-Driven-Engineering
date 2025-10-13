/**
 */
package com.mde.ModelDrivenEngineering.impl;

import com.mde.ModelDrivenEngineering.CascadeType;
import com.mde.ModelDrivenEngineering.ModelDrivenPackage;
import com.mde.ModelDrivenEngineering.Relation;
import com.mde.ModelDrivenEngineering.RelationType;

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
 *   <li>{@link com.mde.ModelDrivenEngineering.impl.RelationImpl#getTargetTable <em>Target Table</em>}</li>
 *   <li>{@link com.mde.ModelDrivenEngineering.impl.RelationImpl#getTargetColumn <em>Target Column</em>}</li>
 *   <li>{@link com.mde.ModelDrivenEngineering.impl.RelationImpl#getOnDelete <em>On Delete</em>}</li>
 *   <li>{@link com.mde.ModelDrivenEngineering.impl.RelationImpl#getType <em>Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RelationImpl extends MinimalEObjectImpl.Container implements Relation {
	/**
	 * The default value of the '{@link #getTargetTable() <em>Target Table</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetTable()
	 * @generated
	 * @ordered
	 */
	protected static final String TARGET_TABLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTargetTable() <em>Target Table</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetTable()
	 * @generated
	 * @ordered
	 */
	protected String targetTable = TARGET_TABLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getTargetColumn() <em>Target Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetColumn()
	 * @generated
	 * @ordered
	 */
	protected static final String TARGET_COLUMN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTargetColumn() <em>Target Column</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetColumn()
	 * @generated
	 * @ordered
	 */
	protected String targetColumn = TARGET_COLUMN_EDEFAULT;

	/**
	 * The default value of the '{@link #getOnDelete() <em>On Delete</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOnDelete()
	 * @generated
	 * @ordered
	 */
	protected static final CascadeType ON_DELETE_EDEFAULT = CascadeType.RESTRICT;

	/**
	 * The cached value of the '{@link #getOnDelete() <em>On Delete</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOnDelete()
	 * @generated
	 * @ordered
	 */
	protected CascadeType onDelete = ON_DELETE_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final RelationType TYPE_EDEFAULT = RelationType.MANY_TO_ONE;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected RelationType type = TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RelationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelDrivenPackage.Literals.RELATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTargetTable() {
		return targetTable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTargetTable(String newTargetTable) {
		String oldTargetTable = targetTable;
		targetTable = newTargetTable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelDrivenPackage.RELATION__TARGET_TABLE, oldTargetTable, targetTable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTargetColumn() {
		return targetColumn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTargetColumn(String newTargetColumn) {
		String oldTargetColumn = targetColumn;
		targetColumn = newTargetColumn;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelDrivenPackage.RELATION__TARGET_COLUMN, oldTargetColumn, targetColumn));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CascadeType getOnDelete() {
		return onDelete;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOnDelete(CascadeType newOnDelete) {
		CascadeType oldOnDelete = onDelete;
		onDelete = newOnDelete == null ? ON_DELETE_EDEFAULT : newOnDelete;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelDrivenPackage.RELATION__ON_DELETE, oldOnDelete, onDelete));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RelationType getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setType(RelationType newType) {
		RelationType oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelDrivenPackage.RELATION__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelDrivenPackage.RELATION__TARGET_TABLE:
				return getTargetTable();
			case ModelDrivenPackage.RELATION__TARGET_COLUMN:
				return getTargetColumn();
			case ModelDrivenPackage.RELATION__ON_DELETE:
				return getOnDelete();
			case ModelDrivenPackage.RELATION__TYPE:
				return getType();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModelDrivenPackage.RELATION__TARGET_TABLE:
				setTargetTable((String)newValue);
				return;
			case ModelDrivenPackage.RELATION__TARGET_COLUMN:
				setTargetColumn((String)newValue);
				return;
			case ModelDrivenPackage.RELATION__ON_DELETE:
				setOnDelete((CascadeType)newValue);
				return;
			case ModelDrivenPackage.RELATION__TYPE:
				setType((RelationType)newValue);
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
			case ModelDrivenPackage.RELATION__TARGET_TABLE:
				setTargetTable(TARGET_TABLE_EDEFAULT);
				return;
			case ModelDrivenPackage.RELATION__TARGET_COLUMN:
				setTargetColumn(TARGET_COLUMN_EDEFAULT);
				return;
			case ModelDrivenPackage.RELATION__ON_DELETE:
				setOnDelete(ON_DELETE_EDEFAULT);
				return;
			case ModelDrivenPackage.RELATION__TYPE:
				setType(TYPE_EDEFAULT);
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
			case ModelDrivenPackage.RELATION__TARGET_TABLE:
				return TARGET_TABLE_EDEFAULT == null ? targetTable != null : !TARGET_TABLE_EDEFAULT.equals(targetTable);
			case ModelDrivenPackage.RELATION__TARGET_COLUMN:
				return TARGET_COLUMN_EDEFAULT == null ? targetColumn != null : !TARGET_COLUMN_EDEFAULT.equals(targetColumn);
			case ModelDrivenPackage.RELATION__ON_DELETE:
				return onDelete != ON_DELETE_EDEFAULT;
			case ModelDrivenPackage.RELATION__TYPE:
				return type != TYPE_EDEFAULT;
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
		result.append(" (targetTable: ");
		result.append(targetTable);
		result.append(", targetColumn: ");
		result.append(targetColumn);
		result.append(", onDelete: ");
		result.append(onDelete);
		result.append(", type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

} //RelationImpl
