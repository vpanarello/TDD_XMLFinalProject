/**
 * 
 */
package gamification.dao;

import java.util.Collection;

import org.jdom2.Element;

/**
 * S04.02_TDD_ProjetoFinal / ArrayList.java
 * FIAP / RM30222 - Vagner Panarello
 */
public class ArrayList<E> extends java.util.ArrayList<E> {

	public ArrayList() {super();}
	public ArrayList(Collection<? extends E> c) {super(c);}
	public ArrayList(int initialCapacity) {super(initialCapacity);}

	
	@SuppressWarnings("unchecked")
	public ArrayList<E> clone(){
		ArrayList<E> cloned = new ArrayList<>(this.size());
		
		for (E e : this) {
			if(e instanceof Element){
				cloned.add((E) ((Element) e).clone());
			} else cloned.add(e);
		}
		return cloned;
	}
	
	
	
}
