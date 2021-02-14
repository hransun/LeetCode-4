class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> ite;
    Integer cache;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
        ite = iterator;
        cache = ite.next();

	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return cache;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer res = cache;
        if(ite.hasNext()) {
            cache = ite.next();
        }else{
            cache = null;
        }
        return res;
	}

	@Override
	public boolean hasNext() {
	    return cache != null;
	}
}
