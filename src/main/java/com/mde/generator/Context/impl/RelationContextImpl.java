/**
 */
package com.mde.generator.Context.impl;

import com.mde.generator.Context.ContextPackage;
import com.mde.generator.Context.RelationContext;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Relation Context</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link com.mde.generator.Context.impl.RelationContextImpl#getFieldName <em>Field Name</em>}</li>
 *   <li>{@link com.mde.generator.Context.impl.RelationContextImpl#getTargetEntity <em>Target Entity</em>}</li>
 *   <li>{@link com.mde.generator.Context.impl.RelationContextImpl#getRelationType <em>Relation Type</em>}</li>
 *   <li>{@link com.mde.generator.Context.impl.RelationContextImpl#isIsOwner <em>Is Owner</em>}</li>
 *   <li>{@link com.mde.generator.Context.impl.RelationContextImpl#getJoinColumnName <em>Join Column Name</em>}</li>
 *   <li>{@link com.mde.generator.Context.impl.RelationContextImpl#getMappedBy <em>Mapped By</em>}</li>
 *   <li>{@link com.mde.generator.Context.impl.RelationContextImpl#getCascadeType <em>Cascade Type</em>}</li>
 *   <li>{@link com.mde.generator.Context.impl.RelationContextImpl#getFetchType <em>Fetch Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RelationContextImpl extends MinimalEObjectImpl.Container implements RelationContext {
	/**
	 * The default value of the '{@link #getFieldName() <em>Field Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFieldName()
	 * @generated
	 * @ordered
	 */
	protected static final String FIELD_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFieldName() <em>Field Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFieldName()
	 * @generated
	 * @ordered
	 */
	protected String fieldName = FIELD_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getTargetEntity() <em>Target Entity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetEntity()
	 * @generated
	 * @ordered
	 */
	protected static final String TARGET_ENTITY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTargetEntity() <em>Target Entity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTargetEntity()
	 * @generated
	 * @ordered
	 */
	protected String targetEntity = TARGET_ENTITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getRelationType() <em>Relation Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelationType()
	 * @generated
	 * @ordered
	 */
	protected static final String RELATION_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRelationType() <em>Relation Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelationType()
	 * @generated
	 * @ordered
	 */
	protected String relationType = RELATION_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsOwner() <em>Is Owner</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsOwner()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_OWNER_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsOwner() <em>Is Owner</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsOwner()
	 * @generated
	 * @ordered
	 */
	protected boolean isOwner = IS_OWNER_EDEFAULT;

	/**
	 * The default value of the '{@link #getJoinColumnName() <em>Join Column Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJoinColumnName()
	 * @generated
	 * @ordered
	 */
	protected static final String JOIN_COLUMN_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getJoinColumnName() <em>Join Column Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getJoinColumnName()
	 * @generated
	 * @ordered
	 */
	protected String joinColumnName = JOIN_COLUMN_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getMappedBy() <em>Mapped By</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMappedBy()
	 * @generated
	 * @ordered
	 */
	protected static final String MAPPED_BY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMappedBy() <em>Mapped By</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMappedBy()
	 * @generated
	 * @ordered
	 */
	protected String mappedBy = MAPPED_BY_EDEFAULT;

	/**
	 * The default value of the '{@link #getCascadeType() <em>Cascade Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCascadeType()
	 * @generated
	 * @ordered
	 */
	protected static final String CASCADE_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCascadeType() <em>Cascade Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCascadeType()
	 * @generated
	 * @ordered
	 */
	protected String cascadeType = CASCADE_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getFetchType() <em>Fetch Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFetchType()
	 * @generated
	 * @ordered
	 */
	protected static final String FETCH_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFetchType() <em>Fetch Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFetchType()
	 * @generated
	 * @ordered
	 */
	protected String fetchType = FETCH_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RelationContextImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ContextPackage.Literals.RELATION_CONTEXT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFieldName() {
		return fieldName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFieldName(String newFieldName) {
		String oldFieldName = fieldName;
		fieldName = newFieldName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContextPackage.RELATION_CONTEXT__FIELD_NAME, oldFieldName, fieldName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTargetEntity() {
		return targetEntity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTargetEntity(String newTargetEntity) {
		String oldTargetEntity = targetEntity;
		targetEntity = newTargetEntity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContextPackage.RELATION_CONTEXT__TARGET_ENTITY, oldTargetEntity, targetEntity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getRelationType() {
		return relationType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRelationType(String newRelationType) {
		String oldRelationType = relationType;
		relationType = newRelationType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContextPackage.RELATION_CONTEXT__RELATION_TYPE, oldRelationType, relationType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isIsOwner() {
		return isOwner;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setIsOwner(boolean newIsOwner) {
		boolean oldIsOwner = isOwner;
		isOwner = newIsOwner;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContextPackage.RELATION_CONTEXT__IS_OWNER, oldIsOwner, isOwner));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getJoinColumnName() {
		return joinColumnName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setJoinColumnName(String newJoinColumnName) {
		String oldJoinColumnName = joinColumnName;
		joinColumnName = newJoinColumnName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContextPackage.RELATION_CONTEXT__JOIN_COLUMN_NAME, oldJoinColumnName, joinColumnName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getMappedBy() {
		return mappedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMappedBy(String newMappedBy) {
		String oldMappedBy = mappedBy;
		mappedBy = newMappedBy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContextPackage.RELATION_CONTEXT__MAPPED_BY, oldMappedBy, mappedBy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCascadeType() {
		return cascadeType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCascadeType(String newCascadeType) {
		String oldCascadeType = cascadeType;
		cascadeType = newCascadeType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContextPackage.RELATION_CONTEXT__CASCADE_TYPE, oldCascadeType, cascadeType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFetchType() {
		return fetchType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFetchType(String newFetchType) {
		String oldFetchType = fetchType;
		fetchType = newFetchType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ContextPackage.RELATION_CONTEXT__FETCH_TYPE, oldFetchType, fetchType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ContextPackage.RELATION_CONTEXT__FIELD_NAME:
				return getFieldName();
			case ContextPackage.RELATION_CONTEXT__TARGET_ENTITY:
				return getTargetEntity();
			case ContextPackage.RELATION_CONTEXT__RELATION_TYPE:
				return getRelationType();
			case ContextPackage.RELATION_CONTEXT__IS_OWNER:
				return isIsOwner();
			case ContextPackage.RELATION_CONTEXT__JOIN_COLUMN_NAME:
				return getJoinColumnName();
			case ContextPackage.RELATION_CONTEXT__MAPPED_BY:
				return getMappedBy();
			case ContextPackage.RELATION_CONTEXT__CASCADE_TYPE:
				return getCascadeType();
			case ContextPackage.RELATION_CONTEXT__FETCH_TYPE:
				return getFetchType();
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
			case ContextPackage.RELATION_CONTEXT__FIELD_NAME:
				setFieldName((String)newValue);
				return;
			case ContextPackage.RELATION_CONTEXT__TARGET_ENTITY:
				setTargetEntity((String)newValue);
				return;
			case ContextPackage.RELATION_CONTEXT__RELATION_TYPE:
				setRelationType((String)newValue);
				return;
			case ContextPackage.RELATION_CONTEXT__IS_OWNER:
				setIsOwner((Boolean)newValue);
				return;
			case ContextPackage.RELATION_CONTEXT__JOIN_COLUMN_NAME:
				setJoinColumnName((String)newValue);
				return;
			case ContextPackage.RELATION_CONTEXT__MAPPED_BY:
				setMappedBy((String)newValue);
				return;
			case ContextPackage.RELATION_CONTEXT__CASCADE_TYPE:
				setCascadeType((String)newValue);
				return;
			case ContextPackage.RELATION_CONTEXT__FETCH_TYPE:
				setFetchType((String)newValue);
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
			case ContextPackage.RELATION_CONTEXT__FIELD_NAME:
				setFieldName(FIELD_NAME_EDEFAULT);
				return;
			case ContextPackage.RELATION_CONTEXT__TARGET_ENTITY:
				setTargetEntity(TARGET_ENTITY_EDEFAULT);
				return;
			case ContextPackage.RELATION_CONTEXT__RELATION_TYPE:
				setRelationType(RELATION_TYPE_EDEFAULT);
				return;
			case ContextPackage.RELATION_CONTEXT__IS_OWNER:
				setIsOwner(IS_OWNER_EDEFAULT);
				return;
			case ContextPackage.RELATION_CONTEXT__JOIN_COLUMN_NAME:
				setJoinColumnName(JOIN_COLUMN_NAME_EDEFAULT);
				return;
			case ContextPackage.RELATION_CONTEXT__MAPPED_BY:
				setMappedBy(MAPPED_BY_EDEFAULT);
				return;
			case ContextPackage.RELATION_CONTEXT__CASCADE_TYPE:
				setCascadeType(CASCADE_TYPE_EDEFAULT);
				return;
			case ContextPackage.RELATION_CONTEXT__FETCH_TYPE:
				setFetchType(FETCH_TYPE_EDEFAULT);
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
			case ContextPackage.RELATION_CONTEXT__FIELD_NAME:
				return FIELD_NAME_EDEFAULT == null ? fieldName != null : !FIELD_NAME_EDEFAULT.equals(fieldName);
			case ContextPackage.RELATION_CONTEXT__TARGET_ENTITY:
				return TARGET_ENTITY_EDEFAULT == null ? targetEntity != null : !TARGET_ENTITY_EDEFAULT.equals(targetEntity);
			case ContextPackage.RELATION_CONTEXT__RELATION_TYPE:
				return RELATION_TYPE_EDEFAULT == null ? relationType != null : !RELATION_TYPE_EDEFAULT.equals(relationType);
			case ContextPackage.RELATION_CONTEXT__IS_OWNER:
				return isOwner != IS_OWNER_EDEFAULT;
			case ContextPackage.RELATION_CONTEXT__JOIN_COLUMN_NAME:
				return JOIN_COLUMN_NAME_EDEFAULT == null ? joinColumnName != null : !JOIN_COLUMN_NAME_EDEFAULT.equals(joinColumnName);
			case ContextPackage.RELATION_CONTEXT__MAPPED_BY:
				return MAPPED_BY_EDEFAULT == null ? mappedBy != null : !MAPPED_BY_EDEFAULT.equals(mappedBy);
			case ContextPackage.RELATION_CONTEXT__CASCADE_TYPE:
				return CASCADE_TYPE_EDEFAULT == null ? cascadeType != null : !CASCADE_TYPE_EDEFAULT.equals(cascadeType);
			case ContextPackage.RELATION_CONTEXT__FETCH_TYPE:
				return FETCH_TYPE_EDEFAULT == null ? fetchType != null : !FETCH_TYPE_EDEFAULT.equals(fetchType);
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
		result.append(" (fieldName: ");
		result.append(fieldName);
		result.append(", targetEntity: ");
		result.append(targetEntity);
		result.append(", relationType: ");
		result.append(relationType);
		result.append(", isOwner: ");
		result.append(isOwner);
		result.append(", joinColumnName: ");
		result.append(joinColumnName);
		result.append(", mappedBy: ");
		result.append(mappedBy);
		result.append(", cascadeType: ");
		result.append(cascadeType);
		result.append(", fetchType: ");
		result.append(fetchType);
		result.append(')');
		return result.toString();
	}

} //RelationContextImpl
