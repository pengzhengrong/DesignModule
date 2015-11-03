package ehcacheUtil;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.InputStream;
import java.util.Collection;

import org.slf4j.LoggerFactory;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.ehcache.config.CacheConfiguration;
import net.sf.ehcache.search.Attribute;
import net.sf.ehcache.search.Query;
import net.sf.ehcache.search.Result;
import net.sf.ehcache.search.Results;

public class CacheUtil  implements EhCacheUtil{

	private Cache cache ;
	private CacheManager cm ;

	public CacheUtil( String cacheResource ,String cacheName ){
		this.cm = getCacheManager( cacheResource );
		this.cache = getCache(cacheName);
	}
	
	public  Cache getCache( String cacheName ){
		return cm.getCache( cacheName );
	}
	
	
	public CacheManager getCacheManager( String cacheResource ){
		InputStream is = CacheUtil.class.getResourceAsStream(cacheResource);
		CacheManager cm = CacheManager.create();
		return cm;
	}
	
	public void addCache( Cache cache ){
		cm.addCache(cache);
	}
	
	public void put(Object key, Object value) {
		// TODO Auto-generated method stub
		Element element = new Element(key, value);
		cache.put(element);
	}

	public void putIfAbsent(Object key, Object value) {
		// TODO Auto-generated method stub
		Element element = new Element(key, value);
		cache.putIfAbsent(element);
	}

	public void putAll(Collection<Element> elements) {
		// TODO Auto-generated method stub
		cache.putAll(elements);
	}

	public Object get(Object key) {
		// TODO Auto-generated method stub
		Element element = cache.get(key);
		return element.getObjectValue();
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		cache.addPropertyChangeListener(listener);
	}

	public void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
		// TODO Auto-generated method stub
		cache.firePropertyChange(propertyName, oldValue, newValue);
	}


	public static void main(String[] args) {
		
		CacheUtil cache = new CacheUtil("ehcache.xml", "data-cache");
		cache.put("name", "pzr");
		String name = (String) cache.get("name");
		System.out.println(name);
		
		cache.put("age", "23");
		String age = (String) cache.get("age");
		System.out.println( age );
		
/*		Query query =  cache.query();
		Attribute<String> a1 = new Attribute<String>("name");
		query.includeAttribute(a1);
		query.addCriteria(a1.eq("pzr"));
		query.execute();*/
		
	}

	public Query query() {
		// TODO Auto-generated method stub
		return cache.createQuery();
	}
	
}


class Listener implements PropertyChangeListener{

	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		
	}
	
}