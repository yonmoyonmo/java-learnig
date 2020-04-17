package edu.pnu.edit;

public class Editor {
	private List<AreaComputable> shapes = new ArrayList<>() ;
	
	public void sort(final SortKind kind) {
		Comparator<AreaComputable> comparator = null ;
		switch ( kind ) {
		case ASCENDING :
			comparator = this.new AscendingComparator() ; break ;
		case DESCENDING :
			comparator = this.new DescendingComparator() ; break ;
		}
		if ( comparator != null )
			Collections.sort(shapes, comparator) ;
	}
	public void list() {
		System.out.println(shapes) ;
	}
}
