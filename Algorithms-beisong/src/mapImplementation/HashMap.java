package mapImplementation;

public class HashMap<K, V> implements Map<K, V> {

    private Entry<K, V> [] table = null;
    private int size = 0;

    HashMap(){
        table = new Entry[16]; // no generics?
    }

    @Override
    public V put(K k, V v) {

        int idx = hash(k);
        Entry entry = table[idx];

        if(entry == null){
            table[idx] = new Entry<> (k, v, idx, null);
        } else {
            table[idx] = new Entry<> (k, v, idx, entry);
        }
        size++;
        return table[idx].getValue ();
    }

    private int hash(K k){
        int idx = k.hashCode ()%15;
        return Math.abs(idx);
    }

    @Override
    public V get(K k) {
        if (size() == 0){
            return null;
        }
        int idx = hash(k);
        Entry curr = getEntry(k, idx);
        return curr == null ? null : (V) curr.getValue ();
    }

    private Entry getEntry(K k, int idx) {
        for (Entry<K, V> entry = table[idx]; entry != null; entry = entry.next){
            if(entry.hash == idx && k == entry.getKey () || k.equals (entry.getKey ())){
                return entry;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }

    class Entry<K, V> implements Map.Entry<K, V> {

        K k;
        V v;
        int hash;
        Entry<K, V> next;

        public Entry(K k, V v, int hash, Entry<K, V> next) {
            this.k = k;
            this.v = v;
            this.hash = hash;
            this.next = next;
        }

        @Override
        public K getKey() {
            return k;
        }

        @Override
        public V getValue() {
            return v;
        }
    }
}
