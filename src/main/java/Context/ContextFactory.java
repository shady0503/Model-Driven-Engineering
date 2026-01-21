/**
 */
package Context;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see Context.ContextPackage
 * @generated
 */
public interface ContextFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ContextFactory eINSTANCE = Context.impl.ContextFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Project Context</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Project Context</em>'.
	 * @generated
	 */
	ProjectContext createProjectContext();

	/**
	 * Returns a new object of class '<em>Entity Context</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Entity Context</em>'.
	 * @generated
	 */
	EntityContext createEntityContext();

	/**
	 * Returns a new object of class '<em>Field Context</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Field Context</em>'.
	 * @generated
	 */
	FieldContext createFieldContext();

	/**
	 * Returns a new object of class '<em>Relation Context</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Relation Context</em>'.
	 * @generated
	 */
	RelationContext createRelationContext();

	/**
	 * Returns a new object of class '<em>Dependency Context</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Dependency Context</em>'.
	 * @generated
	 */
	DependencyContext createDependencyContext();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ContextPackage getContextPackage();

} //ContextFactory
