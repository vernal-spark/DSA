import java.util.*;

class RandomizedSet {
    private List<Integer> list;
    private HashMap<Integer, Integer> h;
    private Random random;
    
    public RandomizedSet() {
        this.list = new ArrayList<>();
        this.h = new HashMap<>();
        this.random = new Random();
    }
    
    public boolean insert(int val) {
        if (h.containsKey(val)) return false;
        this.list.add(val);
        this.h.put(val, this.list.size() - 1); // Store 0-based index
        return true;
    }
    
    public boolean remove(int val) {
        if (!this.h.containsKey(val)) return false;
        
        int index = this.h.get(val);
        int last = this.list.get(list.size() - 1);
        
        // Move last element to the position of element to remove
        this.list.set(index, last);
        
        // Update hashmap for the moved element (unless it's the same element)
        if (index != list.size() - 1) {
            this.h.put(last, index);
        }
        
        // Remove the element from hashmap and list
        this.h.remove(val);
        this.list.remove(list.size() - 1);
        
        return true;
    }
    
    public int getRandom() {
        if (this.list.isEmpty()) {
            throw new IllegalStateException("Set is empty");
        }
        int randomIndex = this.random.nextInt(this.list.size()); // No -1 needed
        return this.list.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */