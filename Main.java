class HashMap {
  private int range;
  private List<Bucket> hashMap;

  public HashMap() {
    this.range = 2069;
    this.hashMap = new ArrayList<Bucket>();

    for (int i = 0; i < this.range; ++i) {
      this.hashMap.add(new Bucket());
    }

  }

  public void put(int key, int value) {
    int hashIndex = key % this.range;
    this.hashMap.get(hashIndex).update(key, value);

  }

  public void get(int key) {
    int hashIndex = key % this.range;
    return this.hashMap.get(hashIndex).get(key);

  }

  public void remove(int key) {
    int hashIndex = key % this.range;
    this.hashMap.get(hashIndex).remove(key);

  }
}


class Pair<U, V> {
  public U first;
  public V second;

  public Pair(U first, V second) {
    this.first = first;
    this.second = second;
  }

}

class Bucket {
  private List<Pair<Integer, Integer>> bucket;

  public Bucket() {
    this.bucket = new LinkedList<Pair<Integer, Integer>>();

  }

  public Integer get(Integer key) {
    for (Pair<Integer, Integer> pair: this.bucket) {
      if (pair.first.equals(key)) {
        return pair.second;
      }
    }

    return -1;
  }

  public void update(Integer key, Integer value) {
    boolean found = false;

    for (Pair<Integer, Integer> pair : this.bucket) {
      if (pair.first.equals(key)) {
        pair.second = value;
        found = true;
      }
    }

    if (!found) {
      this.bucket.add(new Pair<Integer, Integer>(key, value));
    }

  }

  public void remove(Integer key) {
    for (Pair<Integer, Integer> pair : this.bucket) {
      if (pair.first.equals(key)) {
        this.bucket.remove(pair);
        break;
      }
    }

  }

}