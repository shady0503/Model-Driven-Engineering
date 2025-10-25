/**
 */
package com.mde.generator.Context.util;

import com.mde.generator.Context.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see com.mde.generator.Context.ContextPackage
 * @generated
 */
public class ContextAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ContextPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContextAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ContextPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContextSwitch<Adapter> modelSwitch =
		new ContextSwitch<Adapter>() {
			@Override
			public Adapter caseProjectContext(ProjectContext object) {
				return createProjectContextAdapter();
			}
			@Override
			public Adapter caseEntityContext(EntityContext object) {
				return createEntityContextAdapter();
			}
			@Override
			public Adapter caseFieldContext(FieldContext object) {
				return createFieldContextAdapter();
			}
			@Override
			public Adapter caseRelationContext(RelationContext object) {
				return createRelationContextAdapter();
			}
			@Override
			public Adapter caseDependencyContext(DependencyContext object) {
				return createDependencyContextAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link com.mde.generator.Context.ProjectContext <em>Project Context</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.mde.generator.Context.ProjectContext
	 * @generated
	 */
	public Adapter createProjectContextAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.mde.generator.Context.EntityContext <em>Entity Context</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.mde.generator.Context.EntityContext
	 * @generated
	 */
	public Adapter createEntityContextAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.mde.generator.Context.FieldContext <em>Field Context</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.mde.generator.Context.FieldContext
	 * @generated
	 */
	public Adapter createFieldContextAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.mde.generator.Context.RelationContext <em>Relation Context</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.mde.generator.Context.RelationContext
	 * @generated
	 */
	public Adapter createRelationContextAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link com.mde.generator.Context.DependencyContext <em>Dependency Context</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see com.mde.generator.Context.DependencyContext
	 * @generated
	 */
	public Adapter createDependencyContextAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ContextAdapterFactory
