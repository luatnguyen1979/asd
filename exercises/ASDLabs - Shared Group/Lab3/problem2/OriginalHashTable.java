package com.asd.lab3.prob2;

import java.util.Hashtable;

// Private class to keep track of proxies sharing the hash table.
 class OriginalHashTable extends Hashtable {
    private int proxyCount = 1;
    // Constructor
    public OriginalHashTable() {
        super();
    }
    // Return a copy of this object with proxyCount set back to 1.
    public synchronized Object clone() {
        OriginalHashTable copy;
        copy = (OriginalHashTable)super.clone();
        copy.proxyCount = 1;
        return copy;
    }

    // Return the number of proxies using this object.
    synchronized int getProxyCount() {
        return proxyCount;
    }
    // Increment the number of proxies using this object by one.
    synchronized void addProxy() {
        proxyCount++;
    }
    // Decrement the number of proxies using this object by one.
    synchronized void removeProxy() {
        proxyCount--;
    }
}

