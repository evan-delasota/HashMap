class Main {
  public static void main(String[] args) {
    HashMap obj = new HashMap();
    obj.put(1,3);
    int keyValue = obj.get(1);
    System.out.println("The value to key 1 is " + keyValue);
    obj.remove(keyValue);
  }
}
