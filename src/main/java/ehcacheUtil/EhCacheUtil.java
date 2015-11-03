package ehcacheUtil;

import java.beans.PropertyChangeListener;
import java.util.Collection;

import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;
import net.sf.ehcache.search.Query;

public interface EhCacheUtil {

	public  void put( Object key , Object value );
	
	public  void putIfAbsent( Object key , Object value );
	
	public  void putAll( Collection<Element> eles );
	
	public  Object get( Object key );
	
	public  void addPropertyChangeListener( PropertyChangeListener listener );
	
	public  void firePropertyChange( String propertyName , Object  oldValue , Object newValue );
	
	public Query query();
	
	
}
