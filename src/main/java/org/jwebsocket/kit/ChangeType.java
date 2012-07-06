
package org.jwebsocket.kit;

/**
 *
 * @author Marcos Antonio González Huerta (markos0886, UCI)
 */
public enum ChangeType {
    
    ADDED(1),
    UPDATED(2),
    REMOVED(3),
    ENABLED(4),
    DISABLED(5);
    
    private int mChangeType;
    
    ChangeType(int aChangeType) {
        mChangeType = aChangeType;
    }
    
    public int getTypeChange() {
        return mChangeType;
    }
}
