package ModelDrivenEngineering;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Jpa Cascade
 * Type</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * 
 * @see ModelDrivenEngineering.ModelDrivenEngineeringPackage#getJpaCascadeType()
 * @model
 * @generated
 */
public enum JpaCascadeType implements Enumerator {
    /**
     * The '<em><b>ALL</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #ALL_VALUE
     * @generated
     * @ordered
     */
    ALL(0, "ALL", "ALL"),

    /**
     * The '<em><b>PERSIST</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #PERSIST_VALUE
     * @generated
     * @ordered
     */
    PERSIST(1, "PERSIST", "PERSIST"),

    /**
     * The '<em><b>MERGE</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #MERGE_VALUE
     * @generated
     * @ordered
     */
    MERGE(2, "MERGE", "MERGE"),

    /**
     * The '<em><b>REMOVE</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #REMOVE_VALUE
     * @generated
     * @ordered
     */
    REMOVE(3, "REMOVE", "REMOVE"),

    /**
     * The '<em><b>REFRESH</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #REFRESH_VALUE
     * @generated
     * @ordered
     */
    REFRESH(4, "REFRESH", "REFRESH"),

    /**
     * The '<em><b>DETACH</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #DETACH_VALUE
     * @generated
     * @ordered
     */
    DETACH(5, "DETACH", "DETACH"),

    /**
     * The '<em><b>NONE</b></em>' literal object.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #NONE_VALUE
     * @generated
     * @ordered
     */
    NONE(6, "NONE", "NONE");

    /**
     * The '<em><b>ALL</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    public static final int ALL_VALUE = 0;

    /**
     * The '<em><b>PERSIST</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    public static final int PERSIST_VALUE = 1;

    /**
     * The '<em><b>MERGE</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    public static final int MERGE_VALUE = 2;

    /**
     * The '<em><b>REMOVE</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    public static final int REMOVE_VALUE = 3;

    /**
     * The '<em><b>REFRESH</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    public static final int REFRESH_VALUE = 4;

    /**
     * The '<em><b>DETACH</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    public static final int DETACH_VALUE = 5;

    /**
     * The '<em><b>NONE</b></em>' literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    public static final int NONE_VALUE = 6;

    /**
     * An array of all the '<em><b>Jpa Cascade Type</b></em>' enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private static final JpaCascadeType[] VALUES_ARRAY = new JpaCascadeType[] {
            ALL,
            PERSIST,
            MERGE,
            REMOVE,
            REFRESH,
            DETACH,
            NONE,
    };

    /**
     * A public read-only list of all the '<em><b>Jpa Cascade Type</b></em>'
     * enumerators.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final List<JpaCascadeType> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

    /**
     * Returns the '<em><b>Jpa Cascade Type</b></em>' literal with the specified
     * literal value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param literal the literal.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static JpaCascadeType get(String literal) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            JpaCascadeType result = VALUES_ARRAY[i];
            if (result.toString().equals(literal)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Jpa Cascade Type</b></em>' literal with the specified
     * name.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param name the name.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static JpaCascadeType getByName(String name) {
        for (int i = 0; i < VALUES_ARRAY.length; ++i) {
            JpaCascadeType result = VALUES_ARRAY[i];
            if (result.getName().equals(name)) {
                return result;
            }
        }
        return null;
    }

    /**
     * Returns the '<em><b>Jpa Cascade Type</b></em>' literal with the specified
     * integer value.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value the integer value.
     * @return the matching enumerator or <code>null</code>.
     * @generated
     */
    public static JpaCascadeType get(int value) {
        switch (value) {
            case ALL_VALUE:
                return ALL;
            case PERSIST_VALUE:
                return PERSIST;
            case MERGE_VALUE:
                return MERGE;
            case REMOVE_VALUE:
                return REMOVE;
            case REFRESH_VALUE:
                return REFRESH;
            case DETACH_VALUE:
                return DETACH;
            case NONE_VALUE:
                return NONE;
        }
        return null;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private final int value;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private final String name;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private final String literal;

    /**
     * Only this class can construct instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    private JpaCascadeType(int value, String name, String literal) {
        this.value = value;
        this.name = name;
        this.literal = literal;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public int getValue() {
        return value;
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
    public String getLiteral() {
        return literal;
    }

    /**
     * Returns the literal value of the enumerator, which is its string
     * representation.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public String toString() {
        return literal;
    }

} // JpaCascadeType
